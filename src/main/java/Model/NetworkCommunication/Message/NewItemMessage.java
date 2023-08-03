package Model.NetworkCommunication.Message;

public class NewItemMessage extends Message {

    String itemName;

    public NewItemMessage() {

    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
