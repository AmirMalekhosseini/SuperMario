package Graphic;

import Controller.MarioMover;
import Model.*;

import javax.swing.*;

public class GameScreenFrame extends JFrame {

    protected GameData gameData;
    protected JPanel levelOneGameBackgroundPanel;
    protected JPanel levelTwoGameBackgroundPanel;
    protected LevelOneSectionOneScreen levelOneSectionOneScreen;
    protected LevelOneSectionTwoScreen levelOneSectionTwoScreen;
    protected LevelTwoSectionOneScreen levelTwoSectionOneScreen;
    protected LevelTwoSectionTwoScreen levelTwoSectionTwoScreen;
    public IntersectMarioAndObjectsInLevelOneSectionOne intersectMarioAndObjectsInLevelOneSectionOne;
    public IntersectMarioAndObjectsInLevelOneSectionTwo intersectMarioAndObjectsInLevelOneSectionTwo;
    public MarioMover marioMover;
    public GameLoop gameLoop;
    public CalculateScore calculateScore;

    private int xLevelOneBackgroundPanel = 0;
    private int xLevelTwoBackgroundPanel = 0;

    public GameScreenFrame(GameData gameData) {
        init(gameData);
    }

    public GameScreenFrame() {

    }

    private void init(GameData gameData) {

        this.gameData = gameData;
        ImageIcon gameIcon = new ImageIcon("GameIcon.jpeg");
        levelOneSectionOneScreen = new LevelOneSectionOneScreen(gameData);
        levelOneSectionTwoScreen = new LevelOneSectionTwoScreen(gameData);
        levelTwoSectionOneScreen = new LevelTwoSectionOneScreen(gameData);
        levelTwoSectionTwoScreen = new LevelTwoSectionTwoScreen(gameData);
        levelOneGameBackgroundPanel = new JPanel();
        levelTwoGameBackgroundPanel = new JPanel();
        Model modelStarter = new Model() {
            @Override
            public void startModel(GameScreenFrame gameScreenFrame) {

                calculateScore = new CalculateScore(gameScreenFrame);
                marioMover = new MarioMover(gameScreenFrame);
                intersectMarioAndObjectsInLevelOneSectionTwo = new IntersectMarioAndObjectsInLevelOneSectionTwo(gameScreenFrame);
                intersectMarioAndObjectsInLevelOneSectionOne = new IntersectMarioAndObjectsInLevelOneSectionOne(gameScreenFrame);
                gameLoop = new GameLoop(gameScreenFrame);

            }
        };

        modelStarter.startModel(this);

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
        levelOneGameBackgroundPanel.setVisible(true);
        levelOneGameBackgroundPanel.add(levelOneSectionOneScreen);
        levelOneGameBackgroundPanel.add(levelOneSectionTwoScreen);

        levelTwoGameBackgroundPanel.setBounds(xLevelTwoBackgroundPanel, 0, 14000, 1300);
        levelTwoGameBackgroundPanel.setLayout(null);
        levelTwoGameBackgroundPanel.setVisible(false);
        levelTwoGameBackgroundPanel.add(levelTwoSectionOneScreen);
        levelTwoGameBackgroundPanel.add(levelTwoSectionTwoScreen);

        this.add(levelOneGameBackgroundPanel);
        this.add(levelTwoGameBackgroundPanel);

    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    public JPanel getLevelOneGameBackgroundPanel() {
        return levelOneGameBackgroundPanel;
    }

    public void setLevelOneGameBackgroundPanel(JPanel levelOneGameBackgroundPanel) {
        this.levelOneGameBackgroundPanel = levelOneGameBackgroundPanel;
    }

    public JPanel getLevelTwoGameBackgroundPanel() {
        return levelTwoGameBackgroundPanel;
    }

    public void setLevelTwoGameBackgroundPanel(JPanel levelTwoGameBackgroundPanel) {
        this.levelTwoGameBackgroundPanel = levelTwoGameBackgroundPanel;
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

    public LevelTwoSectionOneScreen getLevelTwoSectionOneScreen() {
        return levelTwoSectionOneScreen;
    }

    public void setLevelTwoSectionOneScreen(LevelTwoSectionOneScreen levelTwoSectionOneScreen) {
        this.levelTwoSectionOneScreen = levelTwoSectionOneScreen;
    }

    public LevelTwoSectionTwoScreen getLevelTwoSectionTwoScreen() {
        return levelTwoSectionTwoScreen;
    }

    public void setLevelTwoSectionTwoScreen(LevelTwoSectionTwoScreen levelTwoSectionTwoScreen) {
        this.levelTwoSectionTwoScreen = levelTwoSectionTwoScreen;
    }

    public IntersectMarioAndObjectsInLevelOneSectionOne getIntersectMarioAndObjectsInLevelOneSectionOne() {
        return intersectMarioAndObjectsInLevelOneSectionOne;
    }

    public void setIntersectMarioAndObjectsInLevelOneSectionOne(IntersectMarioAndObjectsInLevelOneSectionOne intersectMarioAndObjectsInLevelOneSectionOne) {
        this.intersectMarioAndObjectsInLevelOneSectionOne = intersectMarioAndObjectsInLevelOneSectionOne;
    }

    public IntersectMarioAndObjectsInLevelOneSectionTwo getIntersectMarioAndObjectsInLevelOneSectionTwo() {
        return intersectMarioAndObjectsInLevelOneSectionTwo;
    }

    public void setIntersectMarioAndObjectsInLevelOneSectionTwo(IntersectMarioAndObjectsInLevelOneSectionTwo intersectMarioAndObjectsInLevelOneSectionTwo) {
        this.intersectMarioAndObjectsInLevelOneSectionTwo = intersectMarioAndObjectsInLevelOneSectionTwo;
    }

    public MarioMover getMarioMover() {
        return marioMover;
    }

    public void setMarioMover(MarioMover marioMover) {
        this.marioMover = marioMover;
    }

    public GameLoop getGameLoop() {
        return gameLoop;
    }

    public void setGameLoop(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
    }

    public CalculateScore getCalculateScore() {
        return calculateScore;
    }

    public void setCalculateScore(CalculateScore calculateScore) {
        this.calculateScore = calculateScore;
    }

    public int getXLevelOneBackgroundPanel() {
        return xLevelOneBackgroundPanel;
    }

    public void setXLevelOneBackgroundPanel(int xLevelOneBackgroundPanel) {
        this.xLevelOneBackgroundPanel = xLevelOneBackgroundPanel;
    }

    public int getXLevelTwoBackgroundPanel() {
        return xLevelTwoBackgroundPanel;
    }

    public void setXLevelTwoBackgroundPanel(int xLevelTwoBackgroundPanel) {
        this.xLevelTwoBackgroundPanel = xLevelTwoBackgroundPanel;
    }

}
