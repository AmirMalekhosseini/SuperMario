package Model.Game;

import Model.Mario.Mario;

import javax.swing.*;

public class StoreBuyButton extends JButton {

    private boolean isButtonChoose;
    private Mario mario;

    public StoreBuyButton(Mario mario) {
        this.mario = mario;
    }

    public boolean isButtonChoose() {
        return !isButtonChoose;
    }

    public void setButtonChoose(boolean buttonChoose) {
        isButtonChoose = buttonChoose;
    }

    public Mario getMario() {
        return mario;
    }

    public void setMario(Mario mario) {
        this.mario = mario;
    }
}
