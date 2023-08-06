package Controller.Online.MessageHandler;

import Controller.Menu.SwingUtils;
import Model.NetworkCommunication.Message.JoinLobbyMessage;
import Model.NetworkCommunication.Message.Message;
import MyProject.MyProject;
import View.Menu.OnlineLobby.OnlineLobbyScreen;

public class JoinLobbyHandler implements MessageHandler{
    @Override
    public void handlerMessage(Message message) {

        if (message instanceof JoinLobbyMessage) {
            JoinLobbyMessage joinMessage = (JoinLobbyMessage) message;

            if (joinMessage.isJoined()) {

                SwingUtils.closeAllFrames();
                OnlineLobbyScreen lobbyScreen = new OnlineLobbyScreen(joinMessage.getMembers(), joinMessage.getLobbyName());
                MyProject.activeClient.setActiveLobbyScreen(lobbyScreen);

            }

        }

    }
}
