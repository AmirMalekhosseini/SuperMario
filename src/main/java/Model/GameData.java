package Model;

public class GameData {

    protected volatile boolean isGameFinish;
    protected volatile boolean isGamePause;
    protected int userHeartValue = 3;
    protected int thisGameScore = 0;
    protected int thisGameCoin = 0;
    protected String gameMode;

    public boolean isGameFinish() {
        return isGameFinish;
    }

    public void setGameFinish(boolean gameFinish) {
        isGameFinish = gameFinish;
    }

    public boolean isGamePause() {
        return isGamePause;
    }

    public void setGamePause(boolean gamePause) {
        isGamePause = gamePause;
    }

    public int getUserHeartValue() {
        return userHeartValue;
    }

    public void setUserHeartValue(int userHeartValue) {
        this.userHeartValue = userHeartValue;
    }

    public int getThisGameScore() {
        return thisGameScore;
    }

    public void setThisGameScore(int thisGameScore) {
        this.thisGameScore = thisGameScore;
    }

    public int getThisGameCoin() {
        return thisGameCoin;
    }

    public void setThisGameCoin(int thisGameCoin) {
        this.thisGameCoin = thisGameCoin;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }
}
