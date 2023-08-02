package Controller.Online;

import Model.Game.OfflineUser;
import Model.NetworkCommunication.Client;
import Model.NetworkCommunication.Message.LogOutMessage;
import Model.NetworkCommunication.Message.MessageType;
import MyProject.MyProject;

import java.io.IOException;

public class ServerConnection {

    public static void connectToServer(String serverAddress, int serverPort) throws IOException {
        MyProject.activeClient = new Client(serverAddress, serverPort);
        MyProject.isProjectOnline = true;
    }

    public static void disconnectFromServer() {
        if (MyProject.activeClient != null) {
            // Set the Client's Online Status:
            MyProject.activeClient.setClientOnline(false);
            MyProject.isProjectOnline = false;
            // Close the Socket:
            try {
                MyProject.activeClient.getSocket().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            logOut();
        }
    }

    public static void logOut() {
        if (!MyProject.isProjectOnline) {
            return;
        }
        // Save Online User Data to Offline Database
        SaveData.saveUserData();
        // Send LogOut Message to Server:

        LogOutMessage logOutMessage = new LogOutMessage();
        logOutMessage.setMessageType(MessageType.LOG_OUT);
        logOutMessage.setTargetUser(MyProject.activeOnlineUser.getUserData().getUsername());
        MyProject.activeClient.sendToServer(logOutMessage);

        for (OfflineUser user : MyProject.allOfflineUsers) {
            if (user.getUserData().getUsername().equals(MyProject.activeOnlineUser.getUserData().getUsername())) {
                MyProject.activeOfflineUser = user;
                MyProject.activeOnlineUser = null;
                MyProject.activeClient = null;
                break;
            }
        }
    }

}

