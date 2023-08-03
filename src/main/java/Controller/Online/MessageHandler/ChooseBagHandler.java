package Controller.Online.MessageHandler;

import Model.NetworkCommunication.Message.ChooseBagMessage;
import Model.NetworkCommunication.Message.Message;

public class ChooseBagHandler implements MessageHandler{
    @Override
    public void handlerMessage(Message message) {
        if (message instanceof ChooseBagMessage) {
            ChooseBagMessage chooseBagMessage = (ChooseBagMessage) message;
        }

    }
}
