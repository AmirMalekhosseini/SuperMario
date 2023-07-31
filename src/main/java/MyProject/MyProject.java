package MyProject;

import Model.Game.OfflineUser;
import Model.Game.OnlineUser;
import Model.NetworkCommunication.Client;
import View.Menu.LoginPageScreen;
import View.Menu.OnlineLobby.OnlineLobbyScreen;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MyProject {

    ObjectMapper objectMapper;
    public static ArrayList<OfflineUser> allOfflineUsers = new ArrayList<>();
    public static OfflineUser activeOfflineUser;
    public static OnlineUser activeOnlineUser;
    public static Client activeClient;
    public static boolean isProjectOnline;

    public MyProject() {
        init();
    }

    private void init() {

        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        try {
            allOfflineUsers = objectMapper.readValue(new File("OfflineUser.jason"), new TypeReference<>() {
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        activeOfflineUser = new OfflineUser();
        new LoginPageScreen();
//        new GameGodFather(new GameData());
//        SwingUtilities.invokeLater(() -> new OnlineLobbyScreen(MyProject.activeOfflineUser));

    }


}
