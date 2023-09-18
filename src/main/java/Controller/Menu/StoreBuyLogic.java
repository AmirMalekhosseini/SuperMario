package Controller.Menu;

import View.Button.StoreBuyButton;
import View.Menu.OfflineStoreScreen;
import MyProject.MyProject;

public class StoreBuyLogic {

    public static int runnerMarioPrice = 20;
    public static int jumperMarioPrice = 30;
    public static int shooterMarioPrice = 40;
    public static int coinMarioPrice = 50;
    protected StoreBuyButton buyButton;

    OfflineStoreScreen offlineStoreScreen;

    public StoreBuyLogic(StoreBuyButton buyButton, OfflineStoreScreen offlineStoreScreen) {
        this.offlineStoreScreen = offlineStoreScreen;
        this.buyButton = buyButton;
    }

    public boolean canUserBuyMario() {

        if (MyProject.activeOfflineUser.getUserData().getUserCoinValue() >= buyButton.getMario().getPrice()) {
            MyProject.activeOfflineUser.getUserData().setUserCoinValue(MyProject.activeOfflineUser.getUserData().getUserCoinValue() - buyButton.getMario().getPrice());
            return true;
        } else {
            return false;
        }

    }

}
