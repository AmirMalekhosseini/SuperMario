package Controller.Menu.OnlineLobby;

import Model.Game.User;
import Model.OnlineLobby.LobbyMemberButton;
import java.util.ArrayList;

public class LobbyButtonCreator {

    public ArrayList<LobbyMemberButton> createButton(ArrayList<LobbyMemberButton> currentMemberList,User newUser) {

        LobbyMemberButton button = new LobbyMemberButton(newUser);
        currentMemberList.add(button);

        return currentMemberList;
    }

}
