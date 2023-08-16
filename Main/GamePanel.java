package Main;


import Inputs.KeyboardInputs;
import Villain.Bagel;
import Sprites.Evelyn;
import Objects.Eyes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

// This is the class that is "painting" the game in the frame/window.
public class GamePanel extends JPanel {

    //--Instance Variables--//
    Image bg1, bg2, flag, joy;
    ImageIcon bg1Icon, flagIcon, joyIcon;
    private int skyHeight = 0;
    private final int groundHeight = 216;

    private int bg1_x, bg2_x;
    public int dx = 0; // the change in position of background image (i.e. how much the image should move)
    public int dx2 = -1; // how much the background image has moved (i.e. -1 is it's moved back)

    // Instance of Evelyn
    public Evelyn evelyn;

    // Instance of Bagel
    public Bagel bagel;

    // Instances of Eyes
    public Eyes eye1, eye2, eye3;

    // ArrayList to store the Eyes
    private final ArrayList<Eyes> eyeList;
    private final ArrayList<Bagel> bagelList;

    // Instance of score
    private Score score;

    // Font for text
    Font font;

    public GamePanel() {
        super(); // adds double-buffer (smooth)

        // Instantiating the background image
        bg1Icon = new ImageIcon(Objects.requireNonNull(getClass().
                getResource("/Images/game_images/bg_clouds.png")));
        bg1 = bg1Icon.getImage(); // using an icon because the image is like a container.
        bg2 = bg1Icon.getImage();

        bg2_x = 800; // second image should start where first one ends.
        flagIcon = new ImageIcon(Objects.requireNonNull(getClass().
                getResource("/Images/game_images/start.png")));
        flag = flagIcon.getImage();

        this.skyHeight = 0; // the sky is at a height of

        // Joy image
        joyIcon = new ImageIcon(Objects.requireNonNull(getClass().
                getResource("/Images/game_images/joy.png")));
        joy = joyIcon.getImage();

        // Parameters for the Evelyn rock (the player)
        evelyn = new Evelyn(71, 216, 96, 96);

        // Parameters for Bagel
        bagel = new Bagel(546, 209, 96, 96);

        // Instantiating the eyes
        eye1 = new Eyes(300, 218, 32, 32);
        eye2 = new Eyes(765, 219, 32, 32);
        eye3 = new Eyes(986, 219, 32, 32);

        this.eyeList = new ArrayList<Eyes>();
        this.eyeList.add(eye1);
        this.eyeList.add(eye2);
        this.eyeList.add(eye3);

        this.bagelList = new ArrayList<Bagel>();
        this.bagelList.add(bagel);

        this.score = new Score();

        this.font = new Font("Arial", Font.BOLD, 20);

        // Action Listeners
        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new KeyboardInputs());

        // Instance of game Thread
        Thread gameThread = new Thread(new GameThread());
        gameThread.start();

    }

    //--Getters and Setters--//

    public void setBg1_x(int bg1_x) {
        this.bg1_x = bg1_x;
    }

    public void setBg2_x(int bg2_x) {
        this.bg2_x = bg2_x;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDx() {
        return dx;
    }

    public int getDx2() {
        return dx2;
    }
    public void setDx2(int dx2) {
        this.dx2 = dx2;
    }

    public int getSkyHeight() {
        return skyHeight;
    }

    public int getGroundHeight() {
        return groundHeight;
    }

    //--Methods--//

    // Making the background image move, so it gives illusion of character moving
    public void scrollingBackground() {

        if (this.dx2 >= 0) {
            this.dx2 += dx; // This is so that the flag does not move with the background.
            this.bg1_x -= this.dx;
            this.bg2_x -= this.dx;
        }
        // When the second image becomes x=0, change first image to x=800. This is a loop that
        // queues the images and will be used in paint components.
        if (this.bg1_x == -800) {this.bg1_x = 800;}
        else if (this.bg2_x == 800) {this.bg2_x = -800;}
        else if (this.bg1_x == 800) {this.bg1_x = -800;}
        else if (this.bg2_x == -800) {this.bg2_x = 800;}

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        // Eyes Collision
        for (int i = 0; i < eyeList.size(); i++) {
            if (this.evelyn.eyesCollision(this.eyeList.get(i))) {
                this.eyeList.remove(i);
                this.score.setScore(this.score.getScore() + 1);
            }
        }

        // Villain Collision
        for (int i = 0; i < eyeList.size(); i++) {
            if (this.evelyn.eyesCollision(this.eyeList.get(i))) {
                this.eyeList.remove(i);
                this.score.setScore(this.score.getScore() - 1);
            }
        }

        this.scrollingBackground();

        // This loop keeps the position of the eyes fixed.
        if (this.dx2 >= 0 && this.dx2 <= 1600) {
            for (int i = 0; i < this.eyeList.size(); i++) {
                this.eyeList.get(i).position();
            }
        }

        // This loop keeps the position of the bagel fixed.
        if (this.dx2 >= 0 && this.dx2 <= 1600) {
            for (int i = 0; i < this.bagelList.size(); i++) {
                this.bagelList.get(i).position();
            }
        }


        g2.drawImage(this.bg1, this.bg1_x, 0, null);
        g2.drawImage(this.bg2, this.bg2_x, 0, null);
        g2.drawImage(this.flag, 23 - this.dx2, 195, null);
        g2.drawImage(this.joy, 1630 - this.dx2, 216, null);
        if (this.evelyn.isJumping) {
            g2.drawImage(this.evelyn.jump(), this.evelyn.getX() + 1,
                    this.evelyn.getY(), null);
        }
        else {
            g2.drawImage(this.evelyn.animate(30, "player"), this.evelyn.getX(),
                    this.evelyn.getY(), null);
        }
        for (Eyes eyes : this.eyeList) {
            g2.drawImage(eyes.getEyes(), eyes.getX(),
                    eyes.getY(), null);
        }
        for (Bagel bagel : this.bagelList) {
            g2.drawImage(bagel.getBagel(), bagel.getX(),
                    bagel.getY(), null);
        }
        g2.setFont(font);
        g2.drawString("Score: " + this.score.getScore(), 474, 30);
    }

}
