package Model.NetworkCommunication.Message;

public class OnlineShopMessage extends Message {


    private int packIndex;
    private boolean isShopValid;
    private int userCoinValue;
    private int userDiamondValue;

    public OnlineShopMessage() {

    }

    public int getPackIndex() {
        return packIndex;
    }

    public void setPackIndex(int packIndex) {
        this.packIndex = packIndex;
    }

    public boolean isShopValid() {
        return isShopValid;
    }

    public void setShopValid(boolean shopValid) {
        isShopValid = shopValid;
    }

    public int getUserCoinValue() {
        return userCoinValue;
    }

    public void setUserCoinValue(int userCoinValue) {
        this.userCoinValue = userCoinValue;
    }

    public int getUserDiamondValue() {
        return userDiamondValue;
    }

    public void setUserDiamondValue(int userDiamondValue) {
        this.userDiamondValue = userDiamondValue;
    }
}
