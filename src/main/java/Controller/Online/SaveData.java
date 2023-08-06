package Controller.Online;

import Model.Game.OfflineUser;
import MyProject.MyProject;

public class SaveData {

    public static void saveUserData() {


        for (int i = 0; i < MyProject.allOfflineUsers.size(); i++) {
            if (MyProject.allOfflineUsers.get(i).getUserData().getUsername().equals
                    (MyProject.activeClient.getUsername())) {

                // Update Current Data of the User
                MyProject.allOfflineUsers.get(i).setUserData(MyProject.activeClient.getUserData());
                break;
                // Create a New User
            } else if (i == MyProject.allOfflineUsers.size() - 1) {
                OfflineUser newUser = new OfflineUser();
                newUser.setUserData(MyProject.activeClient.getUserData());
                MyProject.allOfflineUsers.add(newUser);
            }
        }

    }

}
