package Model.NetworkCommunication.Message;

public class ChooseBagMessage extends Message {

    private int bagIndex;
    private boolean isChoose;

    public ChooseBagMessage() {

    }

    public int getBagIndex() {
        return bagIndex;
    }

    public void setBagIndex(int bagIndex) {
        this.bagIndex = bagIndex;
    }

    public boolean isChoose() {
        return isChoose;
    }

    public void setChoose(boolean choose) {
        isChoose = choose;
    }
}
