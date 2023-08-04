package Model.NetworkCommunication.Message;

public class RemoveLobbyMemberMessage extends Message {

    String lobbyName;

    public RemoveLobbyMemberMessage() {

    }

    public String getLobbyName() {
        return lobbyName;
    }

    public void setLobbyName(String lobbyName) {
        this.lobbyName = lobbyName;
    }
}
