package Controller.Online;

import Model.NetworkCommunication.Client;
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
        }
    }
}

