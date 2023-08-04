package Model.NetworkCommunication.Message;

import java.util.ArrayList;

public class GameRequestMessage extends Message {

    String lobbyName;
    ArrayList<String> members;
    ArrayList<String> coAdmins;

    public GameRequestMessage() {

    }

    public String getLobbyName() {
        return lobbyName;
    }

    public void setLobbyName(String lobbyName) {
        this.lobbyName = lobbyName;
    }

    public ArrayList<String> getMembers() {
        return members;
    }

    public void setMembers(ArrayList<String> members) {
        this.members = members;
    }

    public ArrayList<String> getCoAdmins() {
        return coAdmins;
    }

    public void setCoAdmins(ArrayList<String> coAdmins) {
        this.coAdmins = coAdmins;
    }
}
