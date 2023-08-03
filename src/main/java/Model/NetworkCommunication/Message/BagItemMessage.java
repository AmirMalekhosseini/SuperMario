package Model.NetworkCommunication.Message;

public class BagItemMessage extends Message{

    private String item;
    private boolean isItemAdded;// Sent by Client
    private int bagIndex;

    public BagItemMessage() {

    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public boolean isItemAdded() {
        return isItemAdded;
    }

    public void setItemAdded(boolean itemAdded) {
        isItemAdded = itemAdded;
    }

    public int getBagIndex() {
        return bagIndex;
    }

    public void setBagIndex(int bagIndex) {
        this.bagIndex = bagIndex;
    }

}
