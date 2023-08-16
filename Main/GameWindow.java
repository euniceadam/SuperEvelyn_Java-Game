package Main;

import javax.swing.*;
import java.awt.*;

// Creating the game window using JFrame
public class GameWindow extends JFrame {

    public static GamePanel gamePanel;
    public GameWindow(GamePanel panel) {

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        setSize(800, 348);
        setBackground(Color.BLACK);
        this.setTitle("Everything Everywhere Rocks Edition");

        this.gamePanel = new GamePanel();
        this.setContentPane(gamePanel);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

}
