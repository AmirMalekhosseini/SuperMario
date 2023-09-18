package Controller.Online.MessageHandler;

import Model.NetworkCommunication.Message.Message;
import Model.NetworkCommunication.Message.OnlineShopMessage;
import Model.Object.PackItem;
import Model.OnlineStorePack.Pack;
import MyProject.MyProject;

public class OnlineShopMessageHandler implements MessageHandler {


    @Override
    public void handlerMessage(Message message) {

        if (message instanceof OnlineShopMessage) {
            OnlineShopMessage shopMessage = (OnlineShopMessage) message;
            boolean isBought = shopMessage.isShopValid();
            if (isBought) {
                MyProject.activeClient.getUserData().setUserCoinValue(shopMessage.getUserCoinValue());
                MyProject.activeClient.getUserData().setUserDiamondValue(shopMessage.getUserDiamondValue());
                addItemToUser(shopMessage);
            }
        }

    }

    private void addItemToUser(OnlineShopMessage shopMessage) {

        int packIndex = shopMessage.getPackIndex();
        Pack pack = MyProject.StorePacks.get(packIndex).getPack();

        for (PackItem packItem : pack.packItems) {
            String packItemName = packItem.getClass().getName();
            int currentCount = MyProject.activeClient.getClientItems().getOrDefault(packItemName, 0);
            MyProject.activeClient.getClientItems().put(packItemName, currentCount + 1);
        }

    }
}
