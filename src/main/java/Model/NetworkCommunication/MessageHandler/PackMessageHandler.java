package Model.NetworkCommunication.MessageHandler;

import Controller.Menu.SwingUtils;
import Controller.Online.ClassUtils;
import Model.Item.Currency;
import Model.NetworkCommunication.Message.Message;
import Model.NetworkCommunication.Message.PackMessage;
import Model.Object.PackItem;
import Model.OnlineStorePack.Pack;
import MyProject.MyProject;
import View.Menu.OnlineStoreScreen;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PackMessageHandler implements MessageHandler {
    @Override
    public void handleMessage(Message message) {
        if (message instanceof PackMessage) {
            PackMessage packMessage = (PackMessage) message;
            Pack newPack = createPack(packMessage);
            MyProject.StorePacks.get(packMessage.getPackIndex()).setPack(newPack);
            if (SwingUtils.getActiveFrame() instanceof OnlineStoreScreen) {
                ((OnlineStoreScreen) SwingUtils.getActiveFrame()).getStorePacks().get
                        (packMessage.getPackIndex()).setPack(newPack);
                ((OnlineStoreScreen) SwingUtils.getActiveFrame()).addStorePacks();
            }

        }
    }

    private Pack createPack(PackMessage packMessage) {

        ArrayList<PackItem> packItems = new ArrayList<>();
        int currentY = 0;
        for (String itemName : packMessage.getPackItems()) {
            Object item;
            try {
                item = ClassUtils.createInstanceFromClassName(itemName, 0, currentY);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            if (item instanceof PackItem) {

                packItems.add((PackItem) item);
            }
            currentY += 100;
        }

        Pack newPack = new Pack(packItems, packMessage.getPrice());
        newPack.setCount(packMessage.getCount());
        newPack.setCountPerUser(packMessage.getCountPerUser());
        newPack.setStartTime(LocalDateTime.parse(packMessage.getStartTime()));
        newPack.setEndTime(LocalDateTime.parse(packMessage.getEndTime()));
        newPack.setLevel(packMessage.getLevel());

        try {
            newPack.setCurrency((Currency) ClassUtils.createInstanceFromClassName(packMessage.getCurrency(),0,0 ));
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        MyProject.StorePacks.get(packMessage.getPackIndex()).getCurrency().add((Component) newPack.getCurrency());
        newPack.setPackIndex(packMessage.getPackIndex());

        return newPack;
    }
}
