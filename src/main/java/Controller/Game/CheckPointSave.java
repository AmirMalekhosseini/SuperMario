package Controller.Game;

import View.Game.LevelScreens;

public class CheckPointSave {

    private static CheckPointSave checkPointSave;
    private int marioX;
    private int marioY;
    private int XUserHeartImage;
    private int XThisGameCoinImage;
    private int XThisGameCoin;
    private int XUserHeartValueLabel;
    private int XThisSectionTimeLabel;
    private int XUserScoreLabel;
    private int XMarioLocationLabel;
    private int XLevelPanel;
    private int saveTime;

    public static synchronized CheckPointSave getCheckPointSave() {
        if (checkPointSave == null) {
            checkPointSave = new CheckPointSave();
        }
        return checkPointSave;
    }


    public void save(LevelScreens screen) {

        marioX = screen.activeMario.getX();
        marioY = screen.activeMario.getY();
        XUserHeartImage = screen.XUserHeartImage;
        XThisGameCoinImage = screen.XThisGameCoinImage;
        XThisGameCoin = screen.XThisGameCoin;
        XUserHeartValueLabel = screen.XUserHeartValueLabel;
        XThisSectionTimeLabel = screen.XThisSectionTimeLabel;
        XUserScoreLabel = screen.XUserScoreLabel;
        XMarioLocationLabel = screen.XMarioLocationLabel;

    }

    public void load(LevelScreens screen) {

        screen.activeMario.setX(marioX);
        screen.activeMario.setY(marioY-2);
        screen.XUserHeartImage = XUserHeartImage;
        screen.userHeartImage.setX(screen.XUserHeartImage);
        screen.XThisGameCoinImage = XThisGameCoinImage;
        screen.thisGameCoinImage.setX(screen.XThisGameCoinImage);
        screen.XThisGameCoin = XThisGameCoin;
        screen.XUserHeartValueLabel = XUserHeartValueLabel;
        screen.XThisSectionTimeLabel = XThisSectionTimeLabel;
        screen.XUserScoreLabel = XUserScoreLabel;
        screen.XMarioLocationLabel = XMarioLocationLabel;

    }

    public void saveXPanel(int XLevelPanel) {

        this.XLevelPanel = XLevelPanel;

    }

    public int loadXPanel() {
        return XLevelPanel;
    }


}
