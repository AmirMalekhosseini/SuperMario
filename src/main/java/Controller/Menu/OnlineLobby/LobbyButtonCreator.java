package Controller.Menu.OnlineLobby;

import Model.Game.OfflineUser;
import Model.OnlineLobby.LobbyMemberButton;
import MyProject.MyProject;

import java.util.ArrayList;

public class LobbyButtonCreator {

    public LobbyMemberButton createButton(String newUser) {
        return new LobbyMemberButton(newUser);
    }

}
