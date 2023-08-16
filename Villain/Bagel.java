package Villain;

import Main.GameWindow;
import Sprites.Sprite;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Bagel {

    Image bagel;
    ImageIcon bagelIcon;
    String str = "/Images/game_images/villain_Right.png";
    private int x, y, height, width;

    public Bagel(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.bagelIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        this.bagel = this.bagelIcon.getImage();
    }

    //--Getters and Setters--//
    public Image getBagel() {
        return bagel;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    // This method makes the items remain at fixed positions as the game moves. The position of the item is
    // equal to the difference between the previous x and the change in bg img x position if the bg is moving.
    public void position() {
        if (GameWindow.gamePanel.getDx2() >= 0) {
            this.x -= GameWindow.gamePanel.getDx();
        }
    }
}
