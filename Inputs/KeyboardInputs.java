package Inputs;

import Main.GameWindow;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT -> {
                if (GameWindow.gamePanel.getDx2() == -1) {
                    GameWindow.gamePanel.setBg1_x(0);
                    GameWindow.gamePanel.setBg2_x(800);
                    GameWindow.gamePanel.setDx2(0);
                    // When the right key is pressed, the change is the bg image position is +1,
                    // if the position of the background is already -1 px (dx2 = -1), then the first
                    // image is set back to 0, and second to 800. The position is also returned to 0 because
                    // the image is moving forward.
                }
                GameWindow.gamePanel.evelyn.setMoving(true);
                GameWindow.gamePanel.evelyn.setMovingForward(true);
                GameWindow.gamePanel.setDx(1);
            }
            case KeyEvent.VK_LEFT -> {
                GameWindow.gamePanel.evelyn.setMoving(true);
                GameWindow.gamePanel.evelyn.setMovingForward(false);
                GameWindow.gamePanel.setDx(-1); // Pressing the left key means that the image moves -1 px backwards.

            }
            case KeyEvent.VK_SPACE -> {
                GameWindow.gamePanel.evelyn.setJumping(true);
            }
            case KeyEvent.VK_UP -> {
                GameWindow.gamePanel.evelyn.setJumping(true);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        GameWindow.gamePanel.evelyn.setMoving(false);
        GameWindow.gamePanel.setDx(0);
    }
}
