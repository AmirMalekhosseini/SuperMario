package View.Button;

import Model.NetworkCommunication.Message.FriendRequestMessage;
import Model.NetworkCommunication.Message.MessageType;
import MyProject.MyProject;
import MyProject.MyProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class AddFriendButton extends JButton {

    private final BufferedImage background;
    private int x;
    private int y;

    public AddFriendButton(int x, int y) {

        background = MyProjectData.getProjectData().getAddFriend();
        setFocusable(false);
        setBounds(x, y, 50, 50);
        addButtonAction();

    }

    private void addButtonAction() {
        addActionListener(e -> {

            String username = JOptionPane.showInputDialog("Enter Username");
            FriendRequestMessage friendRequest = new FriendRequestMessage();
            friendRequest.setMessageType(MessageType.FRIEND_REQUEST);
            friendRequest.setTargetUser(username);
            MyProject.activeClient.sendToServer(friendRequest);

        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, 50, 50, null);
    }


}
