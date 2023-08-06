package Model.NetworkCommunication.Message;

public class NewLobbyMessage extends Message {

    private String password;
    public NewLobbyMessage() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
