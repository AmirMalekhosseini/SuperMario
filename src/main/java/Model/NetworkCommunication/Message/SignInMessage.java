package Model.NetworkCommunication.Message;

import Model.Game.OnlineUser;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class SignInMessage extends Message {

    private String username;
    private String password;
    private boolean isUsernameOK;
    private boolean isPasswordOK;

    public SignInMessage(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SignInMessage() {

    }

    public boolean isUsernameOK() {
        return isUsernameOK;
    }

    public void setUsernameOK(boolean usernameOK) {
        isUsernameOK = usernameOK;
    }

    public boolean isPasswordOK() {
        return isPasswordOK;
    }

    public void setPasswordOK(boolean passwordOK) {
        isPasswordOK = passwordOK;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
