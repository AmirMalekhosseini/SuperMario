package Model.Game;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class OfflineUser {

    @JsonIgnore
    protected ArrayList<Game> gameSaves = new ArrayList<>();
    private UserData userData;

    public OfflineUser() {
        userData = new UserData();
        gameSaves.add(null);
        gameSaves.add(null);
        gameSaves.add(null);
    }

    public ArrayList<Game> getGameSaves() {
        return gameSaves;
    }

    public void setGameSaves(ArrayList<Game> gameSaves) {
        this.gameSaves = gameSaves;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}

