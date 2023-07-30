package Model.OnlineLobby;

import Controller.Menu.OnlineLobby.LobbyButtonCreator;
import Model.Game.User;
import View.Menu.OnlineLobby.OnlineLobbyScreen;

import java.util.ArrayList;

public class LobbyModel {

    private User adminUser;
    private ArrayList<User> coAdmins;
    private ArrayList<User> members;
    public LobbyButtonCreator buttonCreator;

    public LobbyModel(User adminUser) {
        this.adminUser = adminUser;
        coAdmins = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addButtons(OnlineLobbyScreen screen) {

        for (LobbyMemberButton button : screen.getMemberButtons()) {
            screen.choosePanel.add(button);
        }
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

    public User getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(User adminUser) {
        this.adminUser = adminUser;
    }

    public ArrayList<User> getCoAdmins() {
        return coAdmins;
    }

    public void setCoAdmins(ArrayList<User> coAdmins) {
        this.coAdmins = coAdmins;
    }

    public ArrayList<User> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<User> members) {
        this.members = members;
    }
}
