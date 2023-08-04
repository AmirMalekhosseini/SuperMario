package Controller.Online.MessageHandler;

import Model.NetworkCommunication.Message.GameRequestMessage;
import Model.NetworkCommunication.Message.Message;
import View.Notification.GameRequestNotification;

public class GameRequestHandler implements MessageHandler{


    @Override
    public void handlerMessage(Message message) {

        if (message instanceof GameRequestMessage) {
            GameRequestMessage requestMessage = (GameRequestMessage) message;
            String sender = requestMessage.getSenderUser();
            String messageContext = "You Have a Game Request From " + sender;
            String title = "Game Request";
            new GameRequestNotification(title, messageContext);

            //ToDo : get Client answer and create a game request answer and sends it to server.

        }

    }
}
