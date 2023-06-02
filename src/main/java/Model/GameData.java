package Model;

public class GameData {

    protected volatile boolean isGameFinish;
    protected volatile boolean isGamePause;
    private boolean isMarioMini;
    private boolean isMarioMega;
    private boolean isMarioShooter;
    protected int userHeartValue = 3;
    protected int thisGameScore = 0;
    protected int thisGameCoin = 0;
    protected String gameMode;
    protected String marioLocation = "";
    private int level;
    private int section;

    public GameData() {

    }

    public boolean isGameFinish() {
        return !isGameFinish;
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

    public String getMarioLocation() {
        return marioLocation;
    }

    public void setMarioLocation(String marioLocation) {
        this.marioLocation = marioLocation;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getSection() {
        return section;
    }

    public void setSection(int section) {
        this.section = section;
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
}
