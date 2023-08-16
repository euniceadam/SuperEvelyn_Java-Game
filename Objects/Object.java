package Objects;

import Main.GameWindow;

public class Object {

    //--Instance Variables--//
    private int x, y, height, width;


    //--Constructor--//
    public Object(int x, int y, int height, int width) {

        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;

    }

    //--Getters and Setters--//
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

    //--Methods--//

    // This method makes the items remain at fixed positions as the game moves. The position of the item is
    // equal to the difference between the previous x and the change in bg img x position if the bg is moving.
    public void position() {
        if (GameWindow.gamePanel.getDx2() >= 0) {
            this.x -= GameWindow.gamePanel.getDx();
        }
    }


}
