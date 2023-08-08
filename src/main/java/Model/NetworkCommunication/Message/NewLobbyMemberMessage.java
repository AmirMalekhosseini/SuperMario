package Model.NetworkCommunication.Message;

public class NewLobbyMemberMessage extends Message {

    String newMemberName;
    boolean isMemberBlock;

    public NewLobbyMemberMessage() {

    }

    public String getNewMemberName() {
        return newMemberName;
    }

    public void setNewMemberName(String newMemberName) {
        this.newMemberName = newMemberName;
    }

    public boolean isMemberBlock() {
        return isMemberBlock;
    }

    public void setMemberBlock(boolean memberBlock) {
        isMemberBlock = memberBlock;
    }
}
