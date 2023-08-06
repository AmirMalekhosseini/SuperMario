package View.Notification;

import Controller.Menu.SwingUtils;
import Model.NetworkCommunication.Message.FriendRequestAnswer;
import Model.NetworkCommunication.Message.GameRequestAnswer;
import Model.NetworkCommunication.Message.GameRequestMessage;
import Model.NetworkCommunication.Message.MessageType;
import MyProject.MyProject;
import View.Menu.OnlineLobby.OnlineLobbyScreen;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class GameRequestNotification extends Notification{


    GameRequestMessage requestMessage;
    String sender;
    public GameRequestNotification(String title, String message, GameRequestMessage gameRequestMessage) {
        super(title, message);
        this.requestMessage = gameRequestMessage;
        this.sender = gameRequestMessage.getSenderUser();
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
        GameRequestAnswer requestAnswer = new GameRequestAnswer();
        requestAnswer.setMessageType(MessageType.GAME_REQUEST_ANSWER);
        requestAnswer.setAnswer(true);
        requestAnswer.setTargetUser(sender);
        requestAnswer.setLobbyName(requestMessage.getLobbyName());
        MyProject.activeClient.sendToServer(requestAnswer);
        dispose();
        SwingUtils.closeAllFrames();
        OnlineLobbyScreen lobbyScreen = new OnlineLobbyScreen(requestMessage.getMembers(), requestMessage.getLobbyName());
        MyProject.activeClient.setActiveLobbyScreen(lobbyScreen);
    }

    private void handleRightClick() {
        // Handle right-click behavior here
        dispose();

    }

}
