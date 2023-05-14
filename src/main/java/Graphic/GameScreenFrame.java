package Graphic;

import Controller.MarioMover;
import Model.*;
import javax.swing.*;

public class GameScreenFrame extends JFrame {

    protected GameData gameData;
    protected JPanel levelOneGameBackgroundPanel;
    protected LevelOneSectionOneScreen levelOneSectionOneScreen;
    public IntersectMarioAndObjectsInSectionOne intersectMarioAndObjectsInSectionOne;
    public IntersectMarioAndObjectsInSectionTwo intersectMarioAndObjectsInSectionTwo;
    protected LevelOneSectionTwoScreen levelOneSectionTwoScreen;
    public MarioMover marioMover;
    public GameLoop gameLoop;
    public CalculateScore calculateScore;

    private int xLevelOneBackgroundPanel = 0;

    GameScreenFrame(GameData gameData) {
        this.gameData = gameData;
        ImageIcon gameIcon = new ImageIcon("GameIcon.jpeg");
        levelOneSectionOneScreen = new LevelOneSectionOneScreen(gameData);
        intersectMarioAndObjectsInSectionOne = new IntersectMarioAndObjectsInSectionOne(this);
        levelOneSectionTwoScreen = new LevelOneSectionTwoScreen(gameData, levelOneSectionOneScreen);
        intersectMarioAndObjectsInSectionTwo = new IntersectMarioAndObjectsInSectionTwo(this);
        marioMover = new MarioMover(this);
        levelOneGameBackgroundPanel = new JPanel();
        gameLoop = new GameLoop(this);
        calculateScore = new CalculateScore(this);

        this.setSize(1700, 1300);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setIconImage(gameIcon.getImage());
        this.addKeyListener(marioMover);

        levelOneGameBackgroundPanel.setBounds(xLevelOneBackgroundPanel, 0, 14000, 1300);
        levelOneGameBackgroundPanel.setLayout(null);



        levelOneGameBackgroundPanel.add(levelOneSectionOneScreen);
        levelOneGameBackgroundPanel.add(levelOneSectionTwoScreen);
        this.add(levelOneGameBackgroundPanel);

    }

    public int getXLevelOneBackgroundPanel() {
        return xLevelOneBackgroundPanel;
    }

    public void setXLevelOneBackgroundPanel(int xLevelOneBackgroundPanel) {
        this.xLevelOneBackgroundPanel = xLevelOneBackgroundPanel;
    }

    public LevelOneSectionOneScreen getLevelOneSectionOneScreen() {
        return levelOneSectionOneScreen;
    }

    public void setLevelOneSectionOneScreen(LevelOneSectionOneScreen levelOneSectionOneScreen) {
        this.levelOneSectionOneScreen = levelOneSectionOneScreen;
    }

    public LevelOneSectionTwoScreen getLevelOneSectionTwoScreen() {
        return levelOneSectionTwoScreen;
    }

    public void setLevelOneSectionTwoScreen(LevelOneSectionTwoScreen levelOneSectionTwoScreen) {
        this.levelOneSectionTwoScreen = levelOneSectionTwoScreen;
    }

    public JPanel getLevelOneGameBackgroundPanel() {
        return levelOneGameBackgroundPanel;
    }

    public void setLevelOneGameBackgroundPanel(JPanel levelOneGameBackgroundPanel) {
        this.levelOneGameBackgroundPanel = levelOneGameBackgroundPanel;
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }
}
