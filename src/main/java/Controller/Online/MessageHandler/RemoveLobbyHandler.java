package Controller.Online.MessageHandler;

import Model.NetworkCommunication.Message.FriendRequestMessage;
import Model.NetworkCommunication.Message.Message;
import Model.NetworkCommunication.Message.RemoveLobbyMessage;
import View.Notification.FriendRequestNotification;
import View.Notification.RemoveLobbyNotification;

public class RemoveLobbyHandler implements MessageHandler{

    @Override
    public void handlerMessage(Message message) {

        if (message instanceof RemoveLobbyMessage) {
            RemoveLobbyMessage removeMessage = (RemoveLobbyMessage) message;
            String messageContext = "You Have been Removed from Lobby";
            String title = removeMessage.getSenderUser();
            new RemoveLobbyNotification(title, messageContext);

        }

    }
}
