package Sprites;

import Main.GameWindow;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

// This class represents the general attributes and functions of a sprite image in the game (i.e x, y, height...),
// and it also takes care of animations and Collisions.
public class Sprite {

    //--Instance Variables--//
    private int x, y, height, width;
    private boolean isMoving; // is the sprite moving or not?
    private boolean movingForward; // is the sprite going forward or backward?
    private int counter;

    //--Constructor--//
    public Sprite(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;

        this.isMoving = false;
        this.movingForward = true;
    }

    //--Getters and Setters--//
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public void setMovingForward(boolean movingForward) {
        this.movingForward = movingForward;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isMovingForward() {
        return movingForward;
    }



    //--Methods--//

    // Method for animations of the sprites
    public Image animate(int step, String spriteName) {
        Image sprite;
        ImageIcon spriteIcon;
        String path;

        // Setting up the conditions for the animations
        if (!this.isMoving || GameWindow.gamePanel.getDx2() <= 0) {
            // If the character is not moving, or the position-x of the background is negative or 0,
            // Paint the default image of the sprite.
            if (this.movingForward) {
                path = "/Images/game_images/" + spriteName + "_Right.png";
            }
            else {
                path = "/Images/game_images/" + spriteName + "_Left.png";
            }
        }
        else {
            this.counter++; // The counter increases because the sprite is performing a step.
            if (this.counter / step == 0) {
                // If the counter is 0, meaning the sprite is not moving or making a step then default img.
                if (this.movingForward) {path = "/Images/game_images/" + spriteName + "_Right.png";}
                else {path = "/Images/game_images/" + spriteName + "_Left.png";}
            }
            else {
                // Or else, paint the first step animation
                if (this.movingForward) {path = "/Images/game_images/" + spriteName + "_movingR.png";}
                else {path = "/Images/game_images/" + spriteName + "_movingL.png";}
            }
            if (this.counter == step * 3) {
                this.counter = 0; // When the counter is three times the amount of step
                // (1 animation loop per 3 steps). After, reset the counter to 0 so
                // the animation can loop again.

            }
        }
        // Defining what is being painted in the above conditions
        spriteIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(path)));
        sprite = spriteIcon.getImage();

        return sprite; // The method returns the animation images every time a key is pressed

    }
}
