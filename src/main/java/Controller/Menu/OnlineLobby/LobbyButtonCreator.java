package Controller.Menu.OnlineLobby;

import View.Button.LobbyMemberButton;

public class LobbyButtonCreator {

    public LobbyMemberButton createButton(String newUser) {
        return new LobbyMemberButton(newUser);
    }

}
