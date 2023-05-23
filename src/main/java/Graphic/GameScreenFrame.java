package Graphic;

import Controller.MarioMover;
import Model.*;

import javax.swing.*;

public class GameScreenFrame extends JFrame {

    protected GameData gameData;
    protected GravityData gravityData;
    protected JPanel hiddenCoinBackgroundPanel;
    protected JPanel levelOneGameBackgroundPanel;
    protected JPanel levelTwoGameBackgroundPanel;
    protected HiddenCoinSectionScreen hiddenCoinSectionScreen;
    protected HiddenCoinSectionModel hiddenCoinSectionModel;
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
        hiddenCoinSectionScreen = new HiddenCoinSectionScreen(gameData);
        levelOneSectionOneScreen = new LevelOneSectionOneScreen(gameData);
        levelOneSectionTwoScreen = new LevelOneSectionTwoScreen(gameData);
        levelTwoSectionOneScreen = new LevelTwoSectionOneScreen(gameData);
        levelTwoSectionTwoScreen = new LevelTwoSectionTwoScreen(gameData);
        hiddenCoinBackgroundPanel = new JPanel();
        levelOneGameBackgroundPanel = new JPanel();
        levelTwoGameBackgroundPanel = new JPanel();
        Model modelStarter = new Model() {
            @Override
            public void startModel(GameScreenFrame gameScreenFrame) {

                calculateScore = new CalculateScore(gameScreenFrame);
                marioMover = new MarioMover(gameScreenFrame);
                intersectInLevelOneSectionTwo = new IntersectInLevelOneSectionTwo(gameScreenFrame);
                intersectInLevelOneSectionOne = new IntersectInLevelOneSectionOne(gameScreenFrame);
                intersectInLevelTwoSectionOne = new IntersectInLevelTwoSectionOne(gameScreenFrame);
                intersectInLevelTwoSectionTwo = new IntersectInLevelTwoSectionTwo(gameScreenFrame);
                gravityData = new GravityData(gameScreenFrame);
                hiddenCoinSectionModel = new HiddenCoinSectionModel(hiddenCoinSectionScreen);
                levelOneSectionOneModel = new LevelOneSectionOneModel(levelOneSectionOneScreen);
                levelOneSectionTwoModel = new LevelOneSectionTwoModel(levelOneSectionTwoScreen);
                levelTwoSectionOneModel = new LevelTwoSectionOneModel(levelTwoSectionOneScreen);
                levelTwoSectionTwoModel = new LevelTwoSectionTwoModel(levelTwoSectionTwoScreen);
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

        hiddenCoinBackgroundPanel.setBounds(0, 0, 1700, 1300);
        hiddenCoinBackgroundPanel.setLayout(null);
        hiddenCoinBackgroundPanel.setVisible(true);
        hiddenCoinBackgroundPanel.add(hiddenCoinSectionScreen);

        levelOneGameBackgroundPanel.setBounds(xLevelOneBackgroundPanel, 0, 14000, 1300);
        levelOneGameBackgroundPanel.setLayout(null);
        levelOneGameBackgroundPanel.setVisible(false);
        levelOneGameBackgroundPanel.add(levelOneSectionOneScreen);
        levelOneGameBackgroundPanel.add(levelOneSectionTwoScreen);

        levelTwoGameBackgroundPanel.setBounds(xLevelTwoBackgroundPanel, 0, 14000, 1300);
        levelTwoGameBackgroundPanel.setLayout(null);
        levelTwoGameBackgroundPanel.setVisible(false);
        levelTwoGameBackgroundPanel.add(levelTwoSectionOneScreen);
        levelTwoGameBackgroundPanel.add(levelTwoSectionTwoScreen);

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

}
