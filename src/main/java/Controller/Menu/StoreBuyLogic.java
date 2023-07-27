package Controller.Menu;

import Model.Game.StoreBuyButton;
import View.Menu.StoreScreen;
import MyProject.MyProject;

public class StoreBuyLogic {

    public static int runnerMarioPrice = 20;
    public static int jumperMarioPrice = 30;
    public static int shooterMarioPrice = 40;
    public static int coinMarioPrice = 50;
    protected StoreBuyButton buyButton;

    StoreScreen storeScreen;

    public StoreBuyLogic(StoreBuyButton buyButton, StoreScreen storeScreen) {
        this.storeScreen = storeScreen;
        this.buyButton = buyButton;
    }

    public boolean canUserBuyMario() {

        if (MyProject.activeUser.get(0).getUserCoinValue() >= buyButton.getMario().getPrice()) {
            MyProject.activeUser.get(0).setUserCoinValue(MyProject.activeUser.get(0).getUserCoinValue() - buyButton.getMario().getPrice());
            return true;
        } else {
            return false;
        }

    }

}
