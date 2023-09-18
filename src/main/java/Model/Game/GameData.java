package Model.Game;

public class GameData {

    public volatile boolean isGameFinish;
    public volatile boolean isGamePause;
    private boolean isMarioMini = true;
    private boolean isMarioMega;
    private boolean isMarioShooter;
    public int userHeartValue = 3;
    public int thisGameScore = 0;
    public int thisGameCoin = 0;
    protected String gameMode;
    private boolean isBossTriggered;

    public GameData() {

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
    public boolean isMarioMini() {
        return isMarioMini;
    }

    public void setMarioMini(boolean marioMini) {
        isMarioMini = marioMini;
    }

    public boolean isMarioMega() {
        return isMarioMega;
    }

    public void setMarioMega(boolean marioMega) {
        isMarioMega = marioMega;
    }

    public boolean isMarioShooter() {
        return isMarioShooter;
    }

    public void setMarioShooter(boolean marioShooter) {
        isMarioShooter = marioShooter;
    }

    public boolean isBossTriggered() {
        return isBossTriggered;
    }

    public void setBossTriggered(boolean bossTriggered) {
        isBossTriggered = bossTriggered;
    }

}
