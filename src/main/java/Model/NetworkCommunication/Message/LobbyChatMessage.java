package Model.NetworkCommunication.Message;

public class LobbyChatMessage extends Message {

    private String lobbyName;
    private String messageContext;

    public LobbyChatMessage() {

    }

    public String getLobbyName() {
        return lobbyName;
    }

    public void setLobbyName(String lobbyName) {
        this.lobbyName = lobbyName;
    }

    public String getMessageContext() {
        return messageContext;
    }

    public void setMessageContext(String messageContext) {
        this.messageContext = messageContext;
    }
}
