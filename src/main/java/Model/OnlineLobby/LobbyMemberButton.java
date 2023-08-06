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
            addAdminMessage.setLobbyName(MyProject.activeClient.getActiveLobbyScreen().getModel().getLobbyName());
            MyProject.activeClient.sendToServer(addAdminMessage);
        } else if (choice == 1) {// Remove Admin
            RemoveAdminMessage removeAdminMessage = new RemoveAdminMessage();
            removeAdminMessage.setMessageType(MessageType.REMOVE_ADMIN_MESSAGE);
            removeAdminMessage.setTargetUser(targetUser);
            removeAdminMessage.setLobbyName(MyProject.activeClient.getActiveLobbyScreen().getModel().getLobbyName());
            MyProject.activeClient.sendToServer(removeAdminMessage);
        } else if (choice == 2) {// Remove
            RemoveLobbyMemberMessage removeMemberMessage = new RemoveLobbyMemberMessage();
            removeMemberMessage.setMessageType(MessageType.REMOVE_LOBBY_MEMBER);
            removeMemberMessage.setTargetUser(targetUser);
            removeMemberMessage.setLobbyName(MyProject.activeClient.getActiveLobbyScreen().getModel().getLobbyName());
            MyProject.activeClient.sendToServer(removeMemberMessage);
        }
    }

    public String getTargetUser() {
        return targetUser;
    }

}
