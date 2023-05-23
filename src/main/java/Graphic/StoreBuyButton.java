package Graphic;

import javax.swing.*;

public class StoreBuyButton extends JButton {

    private boolean isButtonChoose;

    public boolean isButtonChoose() {
        return !isButtonChoose;
    }

    public void setButtonChoose(boolean buttonChoose) {
        isButtonChoose = buttonChoose;
    }
}
