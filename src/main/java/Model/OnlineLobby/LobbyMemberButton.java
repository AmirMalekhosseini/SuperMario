package Model.OnlineLobby;

import Model.Game.OfflineUser;

import javax.swing.*;
import java.awt.*;

public class LobbyMemberButton extends JButton {

    private final OfflineUser recipientUsername;
    private final int height = 100;
    private final int width = 200;
    private int indexInList;

    public LobbyMemberButton( OfflineUser recipientUsername) {
        this.recipientUsername = recipientUsername;

        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(Short.MAX_VALUE, height)); // Set maximum width to expand horizontally
        setText(recipientUsername.getUserData().getUsername());
        setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        setForeground(Color.WHITE);
        setBackground(Color.DARK_GRAY);
    }

    public OfflineUser getRecipientUsername() {
        return recipientUsername;
    }

    public int getIndexInList() {
        return indexInList;
    }

    public void setIndexInList(int indexInList) {
        this.indexInList = indexInList;
    }
}
