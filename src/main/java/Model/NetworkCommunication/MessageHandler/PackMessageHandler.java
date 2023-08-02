package Model.NetworkCommunication.MessageHandler;

import Controller.Menu.SwingUtils;
import Model.NetworkCommunication.Message.Message;
import Model.NetworkCommunication.Message.PackMessage;
import Model.OnlineStorePack.StorePack;
import MyProject.MyProject;
import View.Menu.OnlineStoreScreen;

public class PackMessageHandler implements MessageHandler{
    @Override
    public void handleMessage(Message message) {
        if (message instanceof PackMessage) {
            PackMessage packMessage = (PackMessage) message;
            MyProject.packs = packMessage.getPacks();
            if (SwingUtils.getActiveFrame() instanceof OnlineStoreScreen) {
                for (int i = 0; i < ((OnlineStoreScreen) SwingUtils.getActiveFrame()).getStorePacks().size(); i++) {
                    ((OnlineStoreScreen) SwingUtils.getActiveFrame()).getStorePacks().get(i).setPack(
                            MyProject.packs.get(i)
                    );
                    SwingUtils.getActiveFrame().revalidate();
                }

            }
        }
    }
}
