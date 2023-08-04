package Model.NetworkCommunication.Message;

public class NewLobbyMemberMessage extends Message {

    String newMemberName;

    public NewLobbyMemberMessage() {

    }

    public String getNewMemberName() {
        return newMemberName;
    }

    public void setNewMemberName(String newMemberName) {
        this.newMemberName = newMemberName;
    }

}
