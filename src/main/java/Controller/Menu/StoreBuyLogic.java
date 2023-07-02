package Controller.Menu;

import View.Menu.StoreScreen;
import MyProject.MyProject;

public class StoreBuyLogic {

    public static int runnerMarioPrice = 20;
    public static int jumperMarioPrice = 30;
    public static int shooterMarioPrice = 40;
    public static int coinMarioPrice = 50;
    protected String marioName;

    StoreScreen storeScreen;

    public StoreBuyLogic(String marioName, StoreScreen storeScreen) {
        this.storeScreen = storeScreen;
        this.marioName = marioName;
    }

    public boolean canUserBuyMario() {

        if (marioName.equalsIgnoreCase("runner mario")) {
            if (MyProject.activeUser.get(0).getUserCoinValue() >= runnerMarioPrice) {
                MyProject.activeUser.get(0).setUserCoinValue(MyProject.activeUser.get(0).getUserCoinValue() - runnerMarioPrice);
                return true;
            } else {
                return false;
            }
        }

        if (marioName.equalsIgnoreCase("jumper mario")) {
            if (MyProject.activeUser.get(0).getUserCoinValue() >= jumperMarioPrice) {
                MyProject.activeUser.get(0).setUserCoinValue(MyProject.activeUser.get(0).getUserCoinValue() - jumperMarioPrice);
                return true;
            } else {
                return false;
            }
        }

        if (marioName.equalsIgnoreCase("shooter mario")) {
            if (MyProject.activeUser.get(0).getUserCoinValue() >= shooterMarioPrice) {
                MyProject.activeUser.get(0).setUserCoinValue(MyProject.activeUser.get(0).getUserCoinValue() - shooterMarioPrice);
                return true;
            } else {
                return false;
            }
        }

        if (marioName.equalsIgnoreCase("coin mario")) {
            if (MyProject.activeUser.get(0).getUserCoinValue() >= coinMarioPrice) {
                MyProject.activeUser.get(0).setUserCoinValue(MyProject.activeUser.get(0).getUserCoinValue() - coinMarioPrice);
                return true;
            } else {
                return false;
            }
        }

        storeScreen.userCoinValue.setText(String.valueOf(MyProject.activeUser.get(0).getUserCoinValue()));
        return false;
    }

}
