package Model.NetworkCommunication.Message;

public class AddAdminMessage extends Message {

    private String lobbyName;

    public AddAdminMessage() {

    }

    public String getLobbyName() {
        return lobbyName;
    }

    public void setLobbyName(String lobbyName) {
        this.lobbyName = lobbyName;
    }
}
