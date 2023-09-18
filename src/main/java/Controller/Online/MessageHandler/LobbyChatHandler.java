package Controller.Online.MessageHandler;

import Model.NetworkCommunication.Message.LobbyChatMessage;
import Model.NetworkCommunication.Message.Message;
import MyProject.MyProject;

public class LobbyChatHandler implements MessageHandler{


    @Override
    public void handlerMessage(Message message) {

        if (message instanceof LobbyChatMessage) {
            LobbyChatMessage lobbyChat = (LobbyChatMessage) message;
            String messageContext = lobbyChat.getMessageContext();
            MyProject.activeClient.getActiveLobbyScreen().getChatScreen().addOtherMessage(messageContext);
        }

    }
}
