package Controller.Menu.OnlineLobby;

import Model.Game.OfflineUser;
import Model.OnlineLobby.LobbyMemberButton;
import java.util.ArrayList;

public class LobbyButtonCreator {

    public ArrayList<LobbyMemberButton> createButton(ArrayList<LobbyMemberButton> currentMemberList, OfflineUser newOfflineUser) {

        LobbyMemberButton button = new LobbyMemberButton(newOfflineUser);
        currentMemberList.add(button);

        return currentMemberList;
    }

}
