package Sprites;

import Main.GameWindow;
import Objects.Object;
import Objects.Eyes;
import Villain.Bagel;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;


public class Evelyn extends Sprite {

    //--Instance Variables--//
    Image evelyn;
    ImageIcon evelynIcon;
    String str = "/Images/game_images/player_Right.png";
    public boolean isJumping;

    private int jumpHeight;

    //--Constructor--//
    public Evelyn(int x, int y, int height, int width) {
        super(x, y, 96, 96);
        this.evelynIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        this.evelyn = this.evelynIcon.getImage(); // The Evelyn image is part of the constructor
        this.isJumping = false;
        this.jumpHeight = 0;
    }

    //--Getters and Setters--//

    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }

    //--Methods--//

    // This is an image method because there is animation.
    public Image jump() {
        Image evelyn;
        ImageIcon evelynIcon;

        jumpHeight++;
        // Conditions for the jump
        if (this.jumpHeight <= 95) {
            if (this.getY() > GameWindow.gamePanel.getSkyHeight()) {this.setY((this.getY() - 2));}
            else {this.jumpHeight = 96;}
            if (this.isMovingForward()) {
                evelynIcon = new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/Images/game_images/player_jumpR.png")));
            }
            else {
                evelynIcon = new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/Images/game_images/player_jumpL.png")));
            }
        }
        // Falling back down (Gravity)
        else if (this.getY() < GameWindow.gamePanel.getGroundHeight()) {
            this.setY(this.getY() + 2);
            if (this.isMovingForward()) {
                evelynIcon = new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/Images/game_images/player_jumpR.png")));
            }
            else {
                evelynIcon = new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/Images/game_images/player_jumpL.png")));
            }
        }
        // Ending the jump, Evelyn is on the ground
        else {
            if (this.isMovingForward()) {
                evelynIcon = new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/Images/game_images/player_jumpR.png")));
            }
            else {
                evelynIcon = new ImageIcon(Objects.requireNonNull(getClass().
                        getResource("/Images/game_images/player_jumpL.png")));
            }
            this.isJumping = false;
            this.jumpHeight = 0;
        }

        evelyn = evelynIcon.getImage();
        return evelyn;
    }

    public boolean sideCollision(Object o) {
        // Setting up the parameters for collision
        return o.getX() == this.getX();
    }

    public boolean topCollision(Object o) {
        // Setting up the parameters for collision
        return this.getY() == o.getY();
    }

    public boolean bottomCollision(Object o) {
        // Setting up the parameters for collision
        return this.getY() == o.getY();
    }


    public boolean eyesCollision(Eyes eye) {
        return this.sideCollision(eye) || this.topCollision(eye)
                || this.bottomCollision(eye);
    }

    public boolean bagelSideCollision(Bagel b) {
        // Setting up the parameters for collision
        return b.getX() == this.getX() - 5;
    }

    public boolean bagelTopCollision(Bagel b ) {
        // Setting up the parameters for collision
        return this.getY() == b.getY();
    }

    public boolean bagelBottomCollision(Bagel b) {
        // Setting up the parameters for collision
        return this.getY() == b.getY();
    }


    public boolean bagelCollision(Bagel b) {
        return this.bagelSideCollision(b) || this.bagelTopCollision(b)
                || this.bagelBottomCollision(b);
    }



}
