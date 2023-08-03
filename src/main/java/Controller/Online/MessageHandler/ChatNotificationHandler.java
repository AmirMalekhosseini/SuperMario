package Controller.Online.MessageHandler;

import Model.NetworkCommunication.Message.ChatNotificationMessage;
import Model.NetworkCommunication.Message.Message;
import View.Notification.ChatNotification;

public class ChatNotificationHandler implements MessageHandler{
    @Override
    public void handlerMessage(Message message) {

        if (message instanceof ChatNotificationMessage) {
            ChatNotificationMessage notificationMessage = (ChatNotificationMessage) message;
            String messageContext = notificationMessage.getMessage();
            String sender = notificationMessage.getSenderUser();
            new ChatNotification(sender, trimMessage(messageContext));

        }

    }

    private String trimMessage(String message) {

        if (message.length() > 40) {
            return message.substring(0, 40);
        } else {
            return message;
        }

    }

}
