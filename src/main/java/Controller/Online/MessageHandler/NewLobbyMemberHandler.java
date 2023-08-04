package Controller.Online.MessageHandler;

import Model.NetworkCommunication.Message.Message;
import Model.NetworkCommunication.Message.NewLobbyMemberMessage;
import MyProject.MyProject;

public class NewLobbyMemberHandler implements MessageHandler{


    @Override
    public void handlerMessage(Message message) {

        if (message instanceof NewLobbyMemberMessage) {
            NewLobbyMemberMessage lobbyMemberMessage = (NewLobbyMemberMessage) message;
            MyProject.activeClient.getActiveLobbyScreen().getModel().addButton(MyProject.activeClient.getActiveLobbyScreen(), lobbyMemberMessage.getNewMemberName());
        }

    }
}
