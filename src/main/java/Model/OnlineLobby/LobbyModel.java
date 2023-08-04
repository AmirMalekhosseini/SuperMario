package Model.OnlineLobby;

import Controller.Menu.OnlineLobby.LobbyButtonCreator;
import Model.Game.OfflineUser;
import View.Menu.OnlineLobby.OnlineLobbyScreen;

import java.util.ArrayList;

public class LobbyModel {

    private String lobbyName;
    private String adminUser;
    public LobbyButtonCreator buttonCreator;

    // Admin Constructor:
    public LobbyModel(String adminUser) {
        this.adminUser = adminUser;
        lobbyName = adminUser;
        buttonCreator = new LobbyButtonCreator();
    }


    // Members Constructor:
    public LobbyModel(ArrayList<String> members, String adminUser) {
        this.adminUser = adminUser;
        buttonCreator = new LobbyButtonCreator();
    }

    public void addButton(OnlineLobbyScreen screen, String newUser) {
        LobbyMemberButton newMemberButton = buttonCreator.createButton(newUser);
        screen.choosePanel.add(newMemberButton);
        screen.choosePanel.revalidate();
        screen.revalidate();
    }

    public void goToLobby(OnlineLobbyScreen screen) {

        screen.inputPanel.setVisible(false);
        screen.chatScroll.setVisible(false);
        screen.chatPanel.setVisible(false);

        screen.lobbyPanel.setVisible(true);

    }

    public void goToChat(OnlineLobbyScreen screen) {

        screen.inputPanel.setVisible(true);
        screen.chatScroll.setVisible(true);
        screen.chatPanel.setVisible(true);

        screen.lobbyPanel.setVisible(false);

    }

    public String getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
    }


    public String getLobbyName() {
        return lobbyName;
    }

    public void setLobbyName(String lobbyName) {
        this.lobbyName = lobbyName;
    }
}
