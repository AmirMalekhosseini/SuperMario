package MyProject;

import Model.Game.GameData;
import Model.Game.GameGodFather;
import Model.Game.User;
import View.Menu.LoginPageScreen;
import View.Menu.OnlineStoreScreen;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MyProject {

    ObjectMapper objectMapper;
    public static ArrayList<User> allUsers = new ArrayList<>();
    public static ArrayList<User> activeUser = new ArrayList<>();

    public MyProject() {
        init();
    }

    private void init() {

        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        try {
            allUsers = objectMapper.readValue(new File("User.jason"), new TypeReference<ArrayList<User>>() {
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        activeUser.add(new User());
//        new LoginPageScreen();
//        new GameGodFather(new GameData());
        new OnlineStoreScreen();

    }


}
