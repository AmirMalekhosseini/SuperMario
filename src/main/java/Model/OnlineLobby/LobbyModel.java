package Model.OnlineLobby;

import Controller.Menu.OnlineLobby.LobbyButtonCreator;
import Model.Game.OfflineUser;
import View.Menu.OnlineLobby.OnlineLobbyScreen;

import java.util.ArrayList;

public class LobbyModel {

    private OfflineUser adminOfflineUser;
    private ArrayList<OfflineUser> coAdmins;
    private ArrayList<OfflineUser> members;
    public LobbyButtonCreator buttonCreator;

    public LobbyModel(OfflineUser adminOfflineUser) {
        this.adminOfflineUser = adminOfflineUser;
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

    public OfflineUser getAdminUser() {
        return adminOfflineUser;
    }

    public void setAdminUser(OfflineUser adminOfflineUser) {
        this.adminOfflineUser = adminOfflineUser;
    }

    public ArrayList<OfflineUser> getCoAdmins() {
        return coAdmins;
    }

    public void setCoAdmins(ArrayList<OfflineUser> coAdmins) {
        this.coAdmins = coAdmins;
    }

    public ArrayList<OfflineUser> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<OfflineUser> members) {
        this.members = members;
    }
}
