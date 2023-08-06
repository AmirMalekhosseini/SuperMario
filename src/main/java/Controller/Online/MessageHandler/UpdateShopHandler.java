package Controller.Online.MessageHandler;

import Model.NetworkCommunication.Message.Message;
import Model.NetworkCommunication.Message.UpdateShopMessage;
import MyProject.MyProject;

public class UpdateShopHandler implements MessageHandler {


    @Override
    public void handlerMessage(Message message) {

        if (message instanceof UpdateShopMessage) {
            UpdateShopMessage updateShopMessage = (UpdateShopMessage) message;
            int packIndex = updateShopMessage.getPackIndex();
            int currentCount = MyProject.StorePacks.get(packIndex).getPack().getCount();
            if (currentCount > 0) {
                MyProject.StorePacks.get(packIndex).getPack().setCount(currentCount - 1);
            }
        }

    }
}
