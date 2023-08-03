package Controller.Online.MessageHandler;

import Model.NetworkCommunication.Message.FriendRequestMessage;
import Model.NetworkCommunication.Message.Message;
import Model.NetworkCommunication.Message.NewItemMessage;
import View.Notification.FriendRequestNotification;
import View.Notification.StoreItemNotification;

public class NewItemHandler implements MessageHandler {

    @Override
    public void handlerMessage(Message message) {

        if (message instanceof NewItemMessage) {
            NewItemMessage newItemMessage = (NewItemMessage) message;

            String messageContext = "New Item is Available";
            String title = newItemMessage.getItemName();
            new StoreItemNotification(title, messageContext);

        }

    }
}
