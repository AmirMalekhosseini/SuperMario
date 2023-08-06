package Model.NetworkCommunication.Message;

public class RemoveLobbyMemberMessage extends Message {

    private String lobbyName;
    private boolean isUserRemoved;

    public RemoveLobbyMemberMessage() {

    }

    public String getLobbyName() {
        return lobbyName;
    }

    public void setLobbyName(String lobbyName) {
        this.lobbyName = lobbyName;
    }

    public boolean isUserRemoved() {
        return isUserRemoved;
    }

    public void setUserRemoved(boolean userRemoved) {
        isUserRemoved = userRemoved;
    }
}
