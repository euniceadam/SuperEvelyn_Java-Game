package Objects;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Eyes extends Object {

    //--Instance Variables--//
    Image eyes;
    ImageIcon eyesIcon;
    String str = "/Images/game_images/bonuses_left.png";

    //--Constructor--//
    public Eyes(int x, int y, int height, int width) {
        super(x, y, 32, 32);
        this.eyesIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(str)));
        this.eyes = this.eyesIcon.getImage();
    }

    //--Getters and Setters--//
    public Image getEyes() {
        return eyes;
    }

    //--Methods--//

}
