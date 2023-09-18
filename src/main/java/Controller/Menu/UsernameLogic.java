package Controller.Menu;

import Model.Game.OfflineUser;
import MyProject.MyProject;

import java.util.Objects;

public class UsernameLogic {

    private boolean isUsernameOK;
    private boolean isUsernameOKForSignIn;
    private int usernameIndex;

    public boolean signInUser(String username) {

        for (int i = 0; i < MyProject.allOfflineUsers.size(); i++) {
            if (Objects.equals(MyProject.allOfflineUsers.get(i).getUserData().getUsername(), username)) {
                isUsernameOKForSignIn = true;
                usernameIndex = i;
                break;
            } else {
                isUsernameOKForSignIn = false;
            }
        }

        return isUsernameOKForSignIn;
    }

    public boolean checkPassword(String password) {

        boolean isPasswordOK;
        if (Objects.equals(MyProject.allOfflineUsers.get(usernameIndex).getUserData().getPassword(), password)) {
                MyProject.activeOfflineUser = MyProject.allOfflineUsers.get(usernameIndex);
                isPasswordOK = true;
            } else {
                isPasswordOK = false;
            }

        return isPasswordOK;
    }

    public int getUsernameIndex() {
        return usernameIndex;
    }

    public void setUsernameIndex(int usernameIndex) {
        this.usernameIndex = usernameIndex;
    }
}
