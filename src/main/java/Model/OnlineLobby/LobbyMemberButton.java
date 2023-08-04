package Model.OnlineLobby;

import Model.NetworkCommunication.Message.AddAdminMessage;
import Model.NetworkCommunication.Message.MessageType;
import Model.NetworkCommunication.Message.RemoveAdminMessage;
import Model.NetworkCommunication.Message.RemoveLobbyMemberMessage;
import MyProject.MyProject;

import javax.swing.*;
import java.awt.*;

public class LobbyMemberButton extends JButton {

    private final String targetUser;

    public LobbyMemberButton(String targetUser) {
        this.targetUser = targetUser;

        int height = 100;
        int width = 200;
        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(Short.MAX_VALUE, height)); // Set maximum width to expand horizontally
        setText(targetUser);
        setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        setForeground(Color.WHITE);
        setBackground(Color.DARK_GRAY);
        setVisible(true);
        setFocusable(false);

        addActionListener(e -> showOptions());

    }

    private void showOptions() {
        Object[] options = {"Admin", "Remove Admin", "Remove"};
        int choice = JOptionPane.showOptionDialog(
                this,
                "Choose an Action:",
                "Action",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                options,
                options[0]
        );

        // Handle the User's Choice:
        if (choice == 0) {// Admin
            AddAdminMessage addAdminMessage = new AddAdminMessage();
            addAdminMessage.setMessageType(MessageType.ADD_ADMIN_MESSAGE);
            addAdminMessage.setTargetUser(targetUser);
            MyProject.activeClient.sendToServer(addAdminMessage);
        } else if (choice == 1) {// Remove Admin
            RemoveAdminMessage addAdminMessage = new RemoveAdminMessage();
            addAdminMessage.setMessageType(MessageType.REMOVE_ADMIN_MESSAGE);
            addAdminMessage.setTargetUser(targetUser);
            MyProject.activeClient.sendToServer(addAdminMessage);
        } else if (choice == 2) {// Remove
            RemoveLobbyMemberMessage addAdminMessage = new RemoveLobbyMemberMessage();
            addAdminMessage.setMessageType(MessageType.REMOVE_LOBBY_MEMBER);
            addAdminMessage.setTargetUser(targetUser);
            MyProject.activeClient.sendToServer(addAdminMessage);
        }
    }

    public String getTargetUser() {
        return targetUser;
    }

}
