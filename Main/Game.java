package Main;

public class Game {

    private GameWindow window;
    private GamePanel panel;

    // Constructor
    public Game() {
        panel = new GamePanel();
        window = new GameWindow(panel); // a new game window object.
        panel.requestFocus();

    }

}
