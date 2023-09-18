package Controller.Online.MessageHandler;

import Model.NetworkCommunication.Message.Message;
import Model.NetworkCommunication.Message.NewLobbyMemberMessage;
import MyProject.MyProject;

import javax.swing.*;

public class NewLobbyMemberHandler implements MessageHandler{


    @Override
    public void handlerMessage(Message message) {

        if (message instanceof NewLobbyMemberMessage) {
            NewLobbyMemberMessage lobbyMemberMessage = (NewLobbyMemberMessage) message;
            if (lobbyMemberMessage.isMemberBlock()) {
                JOptionPane.showMessageDialog(null, "Blocked User Just Added to Lobby", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
            MyProject.activeClient.getActiveLobbyScreen().getModel().addButton(MyProject.activeClient.getActiveLobbyScreen(), lobbyMemberMessage.getNewMemberName());
        }

    }
}
