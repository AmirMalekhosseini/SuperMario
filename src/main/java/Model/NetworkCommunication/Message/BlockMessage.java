package Model.NetworkCommunication.Message;

public class BlockMessage extends Message {

    private boolean isBlock;// True: Block , False: UnBlock

    public BlockMessage() {

    }

    public boolean isBlock() {
        return isBlock;
    }

    public void setBlock(boolean block) {
        isBlock = block;
    }
}
