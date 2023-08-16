package Main;

// Without this class, the key inputs are repainted at a rate that is too fast for the human eye
// to detect. The thread allows for the images to be repainted at a rate of 4 milliseconds.
// Using the Runnable interface,
// we track the game's run time in real time and set a rate at which panel is updated.

public class GameThread implements Runnable {

    private static int repaintRate = 2;
    @Override
    public void run() {
        while (true) {
            GameWindow.gamePanel.repaint();
            try {
                java.lang.Thread.sleep(repaintRate);
            } catch (InterruptedException e) {

            }
        }
    }
}
