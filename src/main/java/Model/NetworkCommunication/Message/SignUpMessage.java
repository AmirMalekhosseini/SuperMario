package Model.NetworkCommunication.Message;

import Model.Game.OnlineUser;

public class SignUpMessage extends Message{

    private String username;
    private String password;
    private boolean isPasswordOK;

    public SignUpMessage(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SignUpMessage() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPasswordOK() {
        return isPasswordOK;
    }

    public void setPasswordOK(boolean passwordOK) {
        isPasswordOK = passwordOK;
    }
}
