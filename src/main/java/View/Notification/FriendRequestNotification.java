package View.Notification;

import Model.NetworkCommunication.Message.FriendRequestAnswer;
import Model.NetworkCommunication.Message.MessageType;
import MyProject.MyProject;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FriendRequestNotification extends Notification {

    String requestSender;

    public FriendRequestNotification(String title, String message, String requestSender) {

        super(title, message);
        this.requestSender = requestSender;
        addButtonListener();

    }

    private void addButtonListener() {

        okButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    handleLeftClick();
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    handleRightClick();
                }
            }
        });

    }


    private void handleLeftClick() {
        // Handle left-click behavior here
        FriendRequestAnswer requestAnswer = new FriendRequestAnswer();
        requestAnswer.setMessageType(MessageType.FRIEND_REQUEST_ANSWER);
        requestAnswer.setAnswer(true);
        requestAnswer.setTargetUser(requestSender);
        MyProject.activeClient.getUserFriends().add(requestSender);
        MyProject.activeClient.sendToServer(requestAnswer);
        dispose();

    }

    private void handleRightClick() {
        // Handle right-click behavior here
        dispose();

    }

}
