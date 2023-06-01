package Graphic;

import Controller.MarioMover;
import Model.*;

import javax.swing.*;

public class GameScreenFrame extends JFrame {

    protected GameData gameData;
    protected PowerUp powerUp;
    protected GravityData gravityData;
    protected JPanel hiddenEnemyBackgroundPanel;
    protected JPanel hiddenCoinBackgroundPanel;
    protected JPanel levelOneGameBackgroundPanel;
    protected JPanel levelTwoGameBackgroundPanel;
    protected HiddenCoinSectionScreen hiddenCoinSectionScreen;
    protected HiddenCoinSectionModel hiddenCoinSectionModel;
    protected HiddenEnemySectionScreen hiddenEnemySectionScreen;
    protected HiddenEnemySectionModel hiddenEnemySectionModel;
    protected LevelOneSectionOneScreen levelOneSectionOneScreen;
    protected LevelOneSectionTwoScreen levelOneSectionTwoScreen;
    protected LevelTwoSectionOneScreen levelTwoSectionOneScreen;
    protected LevelTwoSectionTwoScreen levelTwoSectionTwoScreen;
    protected LevelOneSectionOneModel levelOneSectionOneModel;
    protected LevelOneSectionTwoModel levelOneSectionTwoModel;
    protected LevelTwoSectionOneModel levelTwoSectionOneModel;
    protected LevelTwoSectionTwoModel levelTwoSectionTwoModel;
    public IntersectInLevelOneSectionOne intersectInLevelOneSectionOne;
    public IntersectInLevelOneSectionTwo intersectInLevelOneSectionTwo;
    public IntersectInLevelTwoSectionOne intersectInLevelTwoSectionOne;
    public IntersectInLevelTwoSectionTwo intersectInLevelTwoSectionTwo;
    public IntersectInHiddenCoinSection intersectInHiddenCoinSection;
    public IntersectInHiddenEnemySection intersectInHiddenEnemySection;
    public MarioMover marioMover;
    public MarioMoverModel marioMoverModel;
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
        hiddenEnemySectionScreen = new HiddenEnemySectionScreen(gameData);
        hiddenCoinSectionScreen = new HiddenCoinSectionScreen(gameData);
        levelOneSectionOneScreen = new LevelOneSectionOneScreen(gameData);
        levelOneSectionTwoScreen = new LevelOneSectionTwoScreen(gameData);
        levelTwoSectionOneScreen = new LevelTwoSectionOneScreen(gameData);
        levelTwoSectionTwoScreen = new LevelTwoSectionTwoScreen(gameData);
        hiddenCoinBackgroundPanel = new JPanel();
        hiddenEnemyBackgroundPanel = new JPanel();
        levelOneGameBackgroundPanel = new JPanel();
        levelTwoGameBackgroundPanel = new JPanel();
        Model modelStarter = new Model() {
            @Override
            public void startModel(GameScreenFrame gameScreenFrame) {

                calculateScore = new CalculateScore(gameScreenFrame);
                marioMoverModel = new MarioMoverModel(gameScreenFrame);
                marioMover = new MarioMover(gameScreenFrame, marioMoverModel);
                powerUp = new PowerUp(gameScreenFrame);
                intersectInLevelOneSectionOne = new IntersectInLevelOneSectionOne(gameScreenFrame, powerUp);
                intersectInLevelOneSectionTwo = new IntersectInLevelOneSectionTwo(gameScreenFrame, powerUp);
                intersectInLevelTwoSectionOne = new IntersectInLevelTwoSectionOne(gameScreenFrame, powerUp);
                intersectInLevelTwoSectionTwo = new IntersectInLevelTwoSectionTwo(gameScreenFrame, powerUp);
                intersectInHiddenCoinSection = new IntersectInHiddenCoinSection(gameScreenFrame, powerUp);
                intersectInHiddenEnemySection = new IntersectInHiddenEnemySection(gameScreenFrame, powerUp);
                gravityData = new GravityData(gameScreenFrame);
                hiddenEnemySectionModel = new HiddenEnemySectionModel(hiddenEnemySectionScreen, intersectInHiddenEnemySection, marioMoverModel);
                hiddenCoinSectionModel = new HiddenCoinSectionModel(hiddenCoinSectionScreen, intersectInHiddenCoinSection, marioMoverModel);
                levelOneSectionOneModel = new LevelOneSectionOneModel(levelOneSectionOneScreen, intersectInLevelOneSectionOne, marioMoverModel);
                levelOneSectionTwoModel = new LevelOneSectionTwoModel(levelOneSectionTwoScreen, intersectInLevelOneSectionTwo, marioMoverModel);
                levelTwoSectionOneModel = new LevelTwoSectionOneModel(levelTwoSectionOneScreen, intersectInLevelTwoSectionOne, marioMoverModel);
                levelTwoSectionTwoModel = new LevelTwoSectionTwoModel(levelTwoSectionTwoScreen, intersectInLevelTwoSectionTwo, marioMoverModel);
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

        hiddenEnemyBackgroundPanel.setBounds(0, 0, 1700, 1300);
        hiddenEnemyBackgroundPanel.setLayout(null);
        hiddenEnemyBackgroundPanel.setVisible(false);
        hiddenEnemyBackgroundPanel.add(hiddenEnemySectionScreen);

        hiddenCoinBackgroundPanel.setBounds(0, 0, 1700, 1300);
        hiddenCoinBackgroundPanel.setLayout(null);
        hiddenCoinBackgroundPanel.setVisible(false);
        hiddenCoinBackgroundPanel.add(hiddenCoinSectionScreen);

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

        this.add(hiddenEnemyBackgroundPanel);
        this.add(hiddenCoinBackgroundPanel);
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

    public HiddenEnemySectionScreen getHiddenEnemySectionScreen() {
        return hiddenEnemySectionScreen;
    }

    public void setHiddenEnemySectionScreen(HiddenEnemySectionScreen hiddenEnemySectionScreen) {
        this.hiddenEnemySectionScreen = hiddenEnemySectionScreen;
    }

    public HiddenEnemySectionModel getHiddenEnemySectionModel() {
        return hiddenEnemySectionModel;
    }

    public void setHiddenEnemySectionModel(HiddenEnemySectionModel hiddenEnemySectionModel) {
        this.hiddenEnemySectionModel = hiddenEnemySectionModel;
    }

    public HiddenCoinSectionModel getHiddenCoinSectionModel() {
        return hiddenCoinSectionModel;
    }

    public void setHiddenCoinSectionModel(HiddenCoinSectionModel hiddenCoinSectionModel) {
        this.hiddenCoinSectionModel = hiddenCoinSectionModel;
    }

    public HiddenCoinSectionScreen getHiddenCoinSectionScreen() {
        return hiddenCoinSectionScreen;
    }

    public void setHiddenCoinSectionScreen(HiddenCoinSectionScreen hiddenCoinSectionScreen) {
        this.hiddenCoinSectionScreen = hiddenCoinSectionScreen;
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

    public IntersectInLevelOneSectionOne getIntersectMarioAndObjectsInLevelOneSectionOne() {
        return intersectInLevelOneSectionOne;
    }

    public void setIntersectMarioAndObjectsInLevelOneSectionOne(IntersectInLevelOneSectionOne intersectInLevelOneSectionOne) {
        this.intersectInLevelOneSectionOne = intersectInLevelOneSectionOne;
    }

    public IntersectInLevelOneSectionTwo getIntersectMarioAndObjectsInLevelOneSectionTwo() {
        return intersectInLevelOneSectionTwo;
    }

    public void setIntersectMarioAndObjectsInLevelOneSectionTwo(IntersectInLevelOneSectionTwo intersectInLevelOneSectionTwo) {
        this.intersectInLevelOneSectionTwo = intersectInLevelOneSectionTwo;
    }

    public LevelOneSectionOneModel getLevelOneSectionOneModel() {
        return levelOneSectionOneModel;
    }

    public void setLevelOneSectionOneModel(LevelOneSectionOneModel levelOneSectionOneModel) {
        this.levelOneSectionOneModel = levelOneSectionOneModel;
    }

    public LevelOneSectionTwoModel getLevelOneSectionTwoModel() {
        return levelOneSectionTwoModel;
    }

    public void setLevelOneSectionTwoModel(LevelOneSectionTwoModel levelOneSectionTwoModel) {
        this.levelOneSectionTwoModel = levelOneSectionTwoModel;
    }

    public LevelTwoSectionOneModel getLevelTwoSectionOneModel() {
        return levelTwoSectionOneModel;
    }

    public void setLevelTwoSectionOneModel(LevelTwoSectionOneModel levelTwoSectionOneModel) {
        this.levelTwoSectionOneModel = levelTwoSectionOneModel;
    }

    public LevelTwoSectionTwoModel getLevelTwoSectionTwoModel() {
        return levelTwoSectionTwoModel;
    }

    public void setLevelTwoSectionTwoModel(LevelTwoSectionTwoModel levelTwoSectionTwoModel) {
        this.levelTwoSectionTwoModel = levelTwoSectionTwoModel;
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

    public GravityData getGravity() {
        return gravityData;
    }

    public void setGravity(GravityData gravityData) {
        this.gravityData = gravityData;
    }

    public PowerUp getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }
}
