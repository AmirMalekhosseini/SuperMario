package Model.NetworkCommunication.Message;

public class RemoveAdminMessage extends Message {

    private String lobbyName;

    public RemoveAdminMessage() {

    }

    public String getLobbyName() {
        return lobbyName;
    }

    public void setLobbyName(String lobbyName) {
        this.lobbyName = lobbyName;
    }
}
