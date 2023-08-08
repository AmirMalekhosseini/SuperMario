package View.Button;

import Model.Mario.Sword;
import Model.NetworkCommunication.Message.BagItemMessage;
import Model.NetworkCommunication.Message.MessageType;
import Model.Object.ObjectsInGame;
import Model.Object.PackItem;
import MyProject.MyProject;
import MyProject.MyProjectData;

import javax.swing.*;
import java.awt.*;

public class BagAddButton extends JButton {

    private int x;
    private int y;
    private PackItem packItem;
    private Sword sword;
    private boolean isItemChoose;
    private int bagIndex;
    private boolean isItemSword = false;

    public BagAddButton(int x, int y, PackItem packItem, JLayeredPane panel, int bagIndex) {
        this.bagIndex = bagIndex;
        this.x = x;
        this.y = y;
        setBounds(x, y, 70, 40);
        setFont(MyProjectData.getProjectData().getFont15());
        setBackground(Color.green);
        setForeground(Color.WHITE);
        setText("add");
        setFocusable(false);
        addAction();
        panel.add(this);
        this.packItem = packItem;
        panel.add((ObjectsInGame) packItem, Integer.valueOf(1));

    }

    public BagAddButton(int x, int y, Sword sword, JLayeredPane panel, int bagIndex) {
        isItemSword = true;
        this.bagIndex = bagIndex;
        this.x = x;
        this.y = y;
        setBounds(x, y, 70, 40);
        setFont(MyProjectData.getProjectData().getFont15());
        setBackground(Color.green);
        setForeground(Color.WHITE);
        setText("add");
        setFocusable(false);
        addAction();
        panel.add(this);
        this.sword = sword;
        panel.add(sword, Integer.valueOf(1));

    }

    private void addAction() {

        addActionListener(e -> {

            // If Client doesn't Have Item, Can't Choose it
            if (isItemSword) {
                if (!MyProject.activeClient.getClientItems().containsKey(sword.getClass().getName())) {
                    return;
                }
            } else {
                if (!MyProject.activeClient.getClientItems().containsKey(packItem.getClass().getName())) {
                    return;
                }
            }

            BagItemMessage bagItemMessage = new BagItemMessage();
            bagItemMessage.setBagIndex(bagIndex);
            bagItemMessage.setMessageType(MessageType.BAG_ITEM_MESSAGE);
            if (isItemSword) {
                bagItemMessage.setItem(sword.getClass().getName());
            } else {
                bagItemMessage.setItem(packItem.getClass().getName());
            }

            if (isItemChoose) {// Button is Red and User Removes Item:
                setBackground(Color.green);
                setText("add");
                setFont(MyProjectData.getProjectData().getFont15());
                bagItemMessage.setItemAdded(false);
                isItemChoose = false;
            } else {
                setBackground(Color.red);
                setText("remove");
                setFont(MyProjectData.getProjectData().getFont10());
                bagItemMessage.setItemAdded(true);
                isItemChoose = true;
            }

            MyProject.activeClient.sendToServer(bagItemMessage);

        });

    }

    public PackItem getPackItem() {
        return packItem;
    }

    public void setPackItem(PackItem packItem) {
        this.packItem = packItem;
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

    public boolean isItemChoose() {
        return isItemChoose;
    }

    public void setItemChoose(boolean itemChoose) {
        isItemChoose = itemChoose;
    }

    public Sword getSword() {
        return sword;
    }

    public void setSword(Sword sword) {
        this.sword = sword;
    }

    public int getBagIndex() {
        return bagIndex;
    }

    public void setBagIndex(int bagIndex) {
        this.bagIndex = bagIndex;
    }

    public boolean isItemSword() {
        return isItemSword;
    }

    public void setItemSword(boolean itemSword) {
        isItemSword = itemSword;
    }
}
