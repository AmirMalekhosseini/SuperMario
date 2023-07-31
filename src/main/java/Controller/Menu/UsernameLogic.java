package Controller.Menu;

import Model.Game.OfflineUser;
import MyProject.MyProject;

import java.util.Objects;

public class UsernameLogic {

    private boolean isUsernameOK;
    private boolean isUsernameOKForSignIn;
    private boolean isPasswordOK;

    private int usernameIndex;

    public boolean addUser(OfflineUser offlineUser) {

            int usernameCounter = 0;
            for (int i = 0; i < 100000000; i++) {
                if (MyProject.allOfflineUsers.size() == 0) {
                    return true;
                }
                if (!Objects.equals(MyProject.allOfflineUsers.get(i).getUserData().getUsername(), offlineUser.getUserData().getUsername())) {
                    usernameCounter++;
                    if (usernameCounter == MyProject.allOfflineUsers.size()) {
                        isUsernameOK = true;
                        break;
                    }
                } else {
                    isUsernameOK = false;
                    break;
                }
            }

        return isUsernameOK;
    }

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
