package View.Button;

import Model.NetworkCommunication.Message.ChooseBagMessage;
import MyProject.MyProject;
import MyProject.MyProjectData;

import javax.swing.*;
import java.awt.*;

public class BagButton extends JButton {


    private int x;
    private int y;
    private int bagIndex;
    private boolean isButtonChoose;

    public BagButton(int x, int y, int bagIndex) {

        this.x = x;
        this.y = y;
        this.bagIndex = bagIndex;
        setBounds(x, y, 70, 35);
        setForeground(Color.BLACK);
        setFocusable(false);
        setFont(MyProjectData.getProjectData().getFont10());
        setBackground(Color.GREEN);
        setText("Choose");
        isButtonChoose = false;
        addButtonAction();

    }

    private void addButtonAction() {

        addActionListener(e -> {


            if (isButtonChoose) {// UnChoose it
                unChooseButton();
            } else {// Choose it
                chooseButton();
            }

        });

    }

    private void chooseButton() {

        setBackground(Color.GRAY);
        setText("Chosen");
        isButtonChoose = true;
        ChooseBagMessage chooseBagMessage = new ChooseBagMessage();
        chooseBagMessage.setBagIndex(bagIndex);
        chooseBagMessage.setChoose(true);
        MyProject.activeClient.sendToServer(chooseBagMessage);

    }

    public void unChooseButton() {

        setBackground(Color.GREEN);
        setText("Choose");
        isButtonChoose = false;
        MyProject.activeClient.setActiveBagIndex(-1);
        ChooseBagMessage chooseBagMessage = new ChooseBagMessage();
        chooseBagMessage.setBagIndex(bagIndex);
        chooseBagMessage.setChoose(false);
        MyProject.activeClient.sendToServer(chooseBagMessage);

    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isButtonChoose() {
        return isButtonChoose;
    }

    public void setButtonChoose(boolean buttonChoose) {
        isButtonChoose = buttonChoose;
    }

    public int getBagIndex() {
        return bagIndex;
    }

    public void setBagIndex(int bagIndex) {
        this.bagIndex = bagIndex;
    }
}
