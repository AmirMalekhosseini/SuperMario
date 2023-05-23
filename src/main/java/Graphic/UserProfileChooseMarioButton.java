package Graphic;

import javax.swing.*;

public class UserProfileChooseMarioButton extends JButton {

    private boolean isButtonChoose;

    public boolean isButtonChoose() {
        return !isButtonChoose;
    }

    public void setButtonChoose(boolean buttonChoose) {
        isButtonChoose = buttonChoose;
    }
}
