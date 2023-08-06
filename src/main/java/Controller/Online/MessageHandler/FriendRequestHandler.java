package Controller.Online.MessageHandler;

import Model.NetworkCommunication.Message.FriendRequestMessage;
import Model.NetworkCommunication.Message.Message;
import View.Notification.FriendRequestNotification;

public class FriendRequestHandler implements MessageHandler {

    @Override
    public void handlerMessage(Message message) {

        if (message instanceof FriendRequestMessage) {
            FriendRequestMessage requestMessage = (FriendRequestMessage) message;
            String sender = requestMessage.getSenderUser();
            String messageContext = "You Have a Friend Request From " + sender;
            String title = "Friend Request";
            new FriendRequestNotification(title, messageContext, sender);

        }

    }
}
