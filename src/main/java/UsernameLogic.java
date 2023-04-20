import java.util.ArrayList;
import java.util.Objects;

public class UsernameLogic {

    private boolean isUsernameOK;
    private boolean isUsernameOKForSignIn;
    private boolean isPasswordOK;

    private int usernameIndex;

    public  boolean addUser(User user) {

            int usernameCounter = 0;
            for (int i = 0; i < 100000000; i++) {
                if (MyProject.allUsers.size() == 0) {
                    return true;
                }
                if (!Objects.equals(MyProject.allUsers.get(i).username, user.username)) {
                    usernameCounter++;
                    if (usernameCounter == MyProject.allUsers.size()) {
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

        for (int i = 0; i < MyProject.allUsers.size(); i++) {
            if (Objects.equals(MyProject.allUsers.get(i).username, username)) {
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

            if (Objects.equals(MyProject.allUsers.get(usernameIndex).getPassword(), password)) {
                MyProject.activeUser.set(0, MyProject.allUsers.get(usernameIndex));
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
