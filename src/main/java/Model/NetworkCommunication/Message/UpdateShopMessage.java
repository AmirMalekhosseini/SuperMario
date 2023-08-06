package Model.NetworkCommunication.Message;

public class UpdateShopMessage extends Message {

    private int packIndex;

    public UpdateShopMessage() {

    }

    public int getPackIndex() {
        return packIndex;
    }

    public void setPackIndex(int packIndex) {
        this.packIndex = packIndex;
    }
}
