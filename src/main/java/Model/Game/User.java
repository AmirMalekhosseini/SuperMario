package Model.Game;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class User {

    @JsonIgnore
    protected ArrayList<Game> gameSaves = new ArrayList<>();
    @JsonIgnore
    protected ArrayList<Score> userScore = new ArrayList<>();
    protected Score userHighScore = new Score();
    protected String username;
    private String password;
    private int userCoinValue = 0;
    private int userDiamondValue = 0;
    private boolean userChooseNormal_RedMario = true;
    private boolean userChooseCoin_YellowMario;
    private boolean userChooseJumper_GreenMario;
    private boolean userChooseRunner_BlueMario;
    private boolean userChooseShooter_BlackMario;

    private boolean isUserBoughtNormalMario = true;
    private boolean isUserBoughtRunnerMario;
    private boolean isUserBoughtJumperMario;
    private boolean isUserBoughtShooterMario;
    private boolean isUserBoughtCoinMario;

    public User() {
        gameSaves.add(null);
        gameSaves.add(null);
        gameSaves.add(null);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserCoinValue() {
        return userCoinValue;
    }

    public void setUserCoinValue(int userCoinValue) {
        this.userCoinValue = userCoinValue;
    }

    public boolean isUserChooseNormal_RedMario() {
        return userChooseNormal_RedMario;
    }

    public void setUserChooseNormal_RedMario(boolean userChooseNormal_RedMario) {
        this.userChooseNormal_RedMario = userChooseNormal_RedMario;
    }

    public boolean isUserChooseCoin_YellowMario() {
        return userChooseCoin_YellowMario;
    }

    public void setUserChooseCoin_YellowMario(boolean userChooseCoin_YellowMario) {
        this.userChooseCoin_YellowMario = userChooseCoin_YellowMario;
    }

    public boolean isUserChooseJumper_GreenMario() {
        return userChooseJumper_GreenMario;
    }

    public void setUserChooseJumper_GreenMario(boolean userChooseJumper_GreenMario) {
        this.userChooseJumper_GreenMario = userChooseJumper_GreenMario;
    }

    public boolean isUserChooseRunner_BlueMario() {
        return userChooseRunner_BlueMario;
    }

    public void setUserChooseRunner_BlueMario(boolean userChooseRunner_BlueMario) {
        this.userChooseRunner_BlueMario = userChooseRunner_BlueMario;
    }

    public boolean isUserChooseShooter_BlackMario() {
        return userChooseShooter_BlackMario;
    }

    public void setUserChooseShooter_BlackMario(boolean userChooseShooter_BlackMario) {
        this.userChooseShooter_BlackMario = userChooseShooter_BlackMario;
    }

    public boolean isUserBoughtNormalMario() {
        return isUserBoughtNormalMario;
    }

    public void setUserBoughtNormalMario(boolean userBoughtNormalMario) {
        isUserBoughtNormalMario = userBoughtNormalMario;
    }

    public boolean isUserBoughtRunnerMario() {
        return isUserBoughtRunnerMario;
    }

    public void setUserBoughtRunnerMario(boolean userBoughtRunnerMario) {
        isUserBoughtRunnerMario = userBoughtRunnerMario;
    }

    public boolean isUserBoughtJumperMario() {
        return isUserBoughtJumperMario;
    }

    public void setUserBoughtJumperMario(boolean userBoughtJumperMario) {
        isUserBoughtJumperMario = userBoughtJumperMario;
    }

    public boolean isUserBoughtShooterMario() {
        return isUserBoughtShooterMario;
    }

    public void setUserBoughtShooterMario(boolean userBoughtShooterMario) {
        isUserBoughtShooterMario = userBoughtShooterMario;
    }

    public boolean isUserBoughtCoinMario() {
        return isUserBoughtCoinMario;
    }

    public void setUserBoughtCoinMario(boolean userBoughtCoinMario) {
        isUserBoughtCoinMario = userBoughtCoinMario;
    }

    public ArrayList<Game> getGameSaves() {
        return gameSaves;
    }

    public void setGameSaves(ArrayList<Game> gameSaves) {
        this.gameSaves = gameSaves;
    }

    public ArrayList<Score> getUserScore() {
        return userScore;
    }

    public void setUserScore(ArrayList<Score> userScore) {
        this.userScore = userScore;
    }

    public Score getUserHighScore() {
        return userHighScore;
    }

    public void setUserHighScore(Score userHighScore) {
        this.userHighScore = userHighScore;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getUserDiamondValue() {
        return userDiamondValue;
    }

    public void setUserDiamondValue(int userDiamondValue) {
        this.userDiamondValue = userDiamondValue;
    }
}

