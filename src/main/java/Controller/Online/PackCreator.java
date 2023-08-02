package Controller.Online;

import Model.Item.Online.HealItem;
import Model.Item.Online.InvisibleItem;
import Model.Item.Online.SpeedItem;
import Model.Mario.Online.DamageBomb;
import Model.Mario.Online.Hammer;
import Model.Mario.Online.SpeedBomb;
import Model.Object.PackItems;
import Model.OnlineStorePack.Pack;
import Model.OnlineStorePack.StorePack;

import java.util.ArrayList;

public class PackCreator {

    private static PackCreator creator;

    private PackCreator() {

    }

    public static PackCreator getInstance() {
        if ((creator == null)) {
            creator = new PackCreator();
        }
        return creator;
    }

    public ArrayList<StorePack> createInitPack() {

        StorePack hammerPack;
        StorePack damageBombPack;
        StorePack speedBombPack;
        StorePack invisiblePotionPack;
        StorePack healPotionPack;
        StorePack speedPotionPack;
        ArrayList<StorePack> storePacks = new ArrayList<>();

        ArrayList<PackItems> packItems = new ArrayList<>();
        packItems.add(new Hammer(0, 0, true));
        Pack hammer = new Pack(packItems, 100);
        hammerPack = new StorePack(50, 150, hammer);
        storePacks.add(hammerPack);

        packItems = new ArrayList<>();
        packItems.add(new DamageBomb(0, 0));
        Pack damageBomb = new Pack(packItems, 100);
        damageBombPack = new StorePack(200, 150, damageBomb);
        storePacks.add(damageBombPack);

        packItems = new ArrayList<>();
        packItems.add(new SpeedBomb(0, 0));
        Pack speedBomb = new Pack(packItems, 100);
        speedBombPack = new StorePack(350, 150, speedBomb);
        storePacks.add(speedBombPack);

        packItems = new ArrayList<>();
        packItems.add(new HealItem(0, 0));
        Pack healPotion = new Pack(packItems, 100);
        healPotionPack = new StorePack(50, 350, healPotion);
        storePacks.add(healPotionPack);

        packItems = new ArrayList<>();
        packItems.add(new InvisibleItem(0, 0));
        Pack invisiblePotion = new Pack(packItems, 100);
        invisiblePotionPack = new StorePack(200, 350, invisiblePotion);
        storePacks.add(invisiblePotionPack);

        packItems = new ArrayList<>();
        packItems.add(new SpeedItem(0, 0));
        Pack speedPotion = new Pack(packItems, 100);
        speedPotionPack = new StorePack(350, 350, speedPotion);
        storePacks.add(speedPotionPack);

        return storePacks;
    }

}
