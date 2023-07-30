package Model.OnlineLobby;

import Model.Game.User;
import View.Menu.OnlineLobby.OnlineLobbyScreen;

import javax.swing.*;
import java.awt.*;

public class LobbyMemberButton extends JButton {

    private final User recipientUsername;
    private final int height = 100;
    private final int width = 200;
    private int indexInList;

    public LobbyMemberButton( User recipientUsername) {
        this.recipientUsername = recipientUsername;

        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(Short.MAX_VALUE, height)); // Set maximum width to expand horizontally
        setText(recipientUsername.getUsername());
        setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        setForeground(Color.WHITE);
        setBackground(Color.DARK_GRAY);
    }

    public User getRecipientUsername() {
        return recipientUsername;
    }

    public int getIndexInList() {
        return indexInList;
    }

    public void setIndexInList(int indexInList) {
        this.indexInList = indexInList;
    }
}
