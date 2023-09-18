package Model.Item.Online;

import Model.Item.ItemsInGame;
import Model.Mario.Mario;
import Model.Object.PackItem;

public abstract class OnlineItem extends ItemsInGame implements PackItem {


    public abstract void action(Mario mario);
    public abstract void removeAction(Mario mario);

}
