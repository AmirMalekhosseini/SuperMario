package Model.Item.Online;

import Model.Item.ItemsInGame;
import Model.Mario.Mario;
import Model.Object.PackItems;

public abstract class OnlineItems extends ItemsInGame implements PackItems {


    public abstract void action(Mario mario);
    public abstract void removeAction(Mario mario);

}
