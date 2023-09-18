package Model.NetworkCommunication.Message;

public class RemoveLobbyMessage extends Message {

    private String lobbyName;

    public RemoveLobbyMessage() {

    }

    public String getLobbyName() {
        return lobbyName;
    }

    public void setLobbyName(String lobbyName) {
        this.lobbyName = lobbyName;
    }
}
