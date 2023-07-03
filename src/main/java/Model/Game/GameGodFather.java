package Model.Game;

import Controller.Game.*;
import Music.MusicPlayer;
import View.Game.*;
import View.Listener.GameListener;
import View.Listener.MarioMover;

import javax.swing.*;
import java.util.ArrayList;

public class GameGodFather {

    private Graphic graphicStarter;
    private Model modelStarter;
    protected ArrayList<LevelScreens> gameScreens = new ArrayList<>();
    public GameTimer gameTimer;
    public ActiveLevel activeLevel;
    protected GameData gameData;
    protected PowerUp powerUp;
    protected GravityData gravityData;
    protected GameScreenFrame gameScreenFrame;
    protected JPanel[] gamePanels = new JPanel[5];
    protected JPanel hiddenEnemyBackgroundPanel;
    protected JPanel hiddenCoinBackgroundPanel;
    protected JPanel levelOneGameBackgroundPanel;
    protected JPanel levelTwoGameBackgroundPanel;
    protected JPanel levelThreeGameBackgroundPanel;
    protected BossFightSectionScreen bossFightSectionScreen;
    protected BossFightSectionModel bossFightSectionModel;
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
    public IntersectInBossSection intersectInBossSection;
    public MarioMover marioMover;
    protected GameListener gameListener;
    protected MusicPlayer musicPlayer;
    public MarioMoverController marioMoverController;
    public GameLoop gameLoop;
    public CalculateScore calculateScore;
    public WaitObject waitObject;

    public GameGodFather(GameData gameData) {
        init(gameData);
        gameTimer = new GameTimer(this);
        gameTimer.addGameData(gameData);
        gameTimer.startTimer();
        graphicStarter.startGraphic(gameData);
        activeLevel = new ActiveLevel(this);
        modelStarter.startModel(this);
    }

    public GameGodFather() {

    }

    private void init(GameData gameData) {

        this.gameData = gameData;

        graphicStarter = gameData1 -> {

            bossFightSectionScreen = new BossFightSectionScreen(gameData1);
            hiddenEnemySectionScreen = new HiddenEnemySectionScreen(gameData1);
            hiddenCoinSectionScreen = new HiddenCoinSectionScreen(gameData1);
            levelOneSectionOneScreen = new LevelOneSectionOneScreen(gameData1);
            levelOneSectionTwoScreen = new LevelOneSectionTwoScreen(gameData1);
            levelTwoSectionOneScreen = new LevelTwoSectionOneScreen(gameData1);
            levelTwoSectionTwoScreen = new LevelTwoSectionTwoScreen(gameData1);
            gameScreens.add(bossFightSectionScreen);
            gameScreens.add(hiddenEnemySectionScreen);
            gameScreens.add(hiddenCoinSectionScreen);
            gameScreens.add(levelOneSectionOneScreen);
            gameScreens.add(levelOneSectionTwoScreen);
            gameScreens.add(levelTwoSectionOneScreen);
            gameScreens.add(levelTwoSectionTwoScreen);
            hiddenCoinBackgroundPanel = new JPanel();
            hiddenEnemyBackgroundPanel = new JPanel();
            levelOneGameBackgroundPanel = new JPanel();
            levelTwoGameBackgroundPanel = new JPanel();
            levelThreeGameBackgroundPanel = new JPanel();
            hiddenEnemyBackgroundPanel.setBounds(0, 0, 1700, 1300);
            hiddenEnemyBackgroundPanel.setLayout(null);
            hiddenEnemyBackgroundPanel.setVisible(false);
            hiddenEnemyBackgroundPanel.add(hiddenEnemySectionScreen);
            gamePanels[0] = hiddenEnemyBackgroundPanel;

            hiddenCoinBackgroundPanel.setBounds(0, 0, 1700, 1300);
            hiddenCoinBackgroundPanel.setLayout(null);
            hiddenCoinBackgroundPanel.setVisible(false);
            hiddenCoinBackgroundPanel.add(hiddenCoinSectionScreen);
            gamePanels[1] = hiddenCoinBackgroundPanel;

            levelOneGameBackgroundPanel.setBounds(0, 0, 14000, 1300);
            levelOneGameBackgroundPanel.setLayout(null);
            levelOneGameBackgroundPanel.setVisible(true);
            levelOneGameBackgroundPanel.add(levelOneSectionOneScreen);
            levelOneGameBackgroundPanel.add(levelOneSectionTwoScreen);
            gamePanels[2] = levelOneGameBackgroundPanel;

            levelTwoGameBackgroundPanel.setBounds(0, 0, 14000, 1300);
            levelTwoGameBackgroundPanel.setLayout(null);
            levelTwoGameBackgroundPanel.setVisible(false);
            levelTwoGameBackgroundPanel.add(levelTwoSectionOneScreen);
            levelTwoGameBackgroundPanel.add(levelTwoSectionTwoScreen);
            gamePanels[3] = levelTwoGameBackgroundPanel;

            levelThreeGameBackgroundPanel.setBounds(0, 0, 14000, 1300);
            levelThreeGameBackgroundPanel.setLayout(null);
            levelThreeGameBackgroundPanel.setVisible(false);
            levelThreeGameBackgroundPanel.add(bossFightSectionScreen);
            gamePanels[4] = levelThreeGameBackgroundPanel;

            gameScreenFrame = new GameScreenFrame(gamePanels);

        };

        modelStarter = godFather -> {

            waitObject = new WaitObject();
            musicPlayer = new MusicPlayer();
            calculateScore = new CalculateScore(godFather);
            marioMoverController = new MarioMoverController(godFather);
            powerUp = new PowerUp(godFather);
            marioMover = new MarioMover(godFather);
            gameListener = new GameListener(this);
            intersectInLevelOneSectionOne = new IntersectInLevelOneSectionOne(godFather);
            intersectInLevelOneSectionTwo = new IntersectInLevelOneSectionTwo(godFather);
            intersectInLevelTwoSectionOne = new IntersectInLevelTwoSectionOne(godFather);
            intersectInLevelTwoSectionTwo = new IntersectInLevelTwoSectionTwo(godFather);
            intersectInHiddenCoinSection = new IntersectInHiddenCoinSection(godFather);
            intersectInHiddenEnemySection = new IntersectInHiddenEnemySection(godFather);
            intersectInBossSection = new IntersectInBossSection(godFather);
            gravityData = new GravityData();
            hiddenEnemySectionModel = new HiddenEnemySectionModel(godFather);
            hiddenCoinSectionModel = new HiddenCoinSectionModel(godFather);
            levelOneSectionOneModel = new LevelOneSectionOneModel(godFather);
            levelOneSectionTwoModel = new LevelOneSectionTwoModel(godFather);
            levelTwoSectionOneModel = new LevelTwoSectionOneModel(godFather);
            levelTwoSectionTwoModel = new LevelTwoSectionTwoModel(godFather);
            bossFightSectionModel = new BossFightSectionModel(godFather);
            gameLoop = new GameLoop(godFather);


        };

    }

    public ArrayList<LevelScreens> getGameScreens() {
        return gameScreens;
    }

    public void setGameScreens(ArrayList<LevelScreens> gameScreens) {
        this.gameScreens = gameScreens;
    }

    public GameScreenFrame getGameScreenFrame() {
        return gameScreenFrame;
    }

    public void setGameScreenFrame(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
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

    public JPanel getLevelThreeGameBackgroundPanel() {
        return levelThreeGameBackgroundPanel;
    }

    public void setLevelThreeGameBackgroundPanel(JPanel levelThreeGameBackgroundPanel) {
        this.levelThreeGameBackgroundPanel = levelThreeGameBackgroundPanel;
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

    public BossFightSectionScreen getBossFightScreenSection() {
        return bossFightSectionScreen;
    }

    public void setBossFightScreenSection(BossFightSectionScreen bossFightSectionScreen) {
        this.bossFightSectionScreen = bossFightSectionScreen;
    }

    public BossFightSectionModel getBossFightSectionModel() {
        return bossFightSectionModel;
    }

    public void setBossFightSectionModel(BossFightSectionModel bossFightSectionModel) {
        this.bossFightSectionModel = bossFightSectionModel;
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

    public JPanel getHiddenEnemyBackgroundPanel() {
        return hiddenEnemyBackgroundPanel;
    }

    public void setHiddenEnemyBackgroundPanel(JPanel hiddenEnemyBackgroundPanel) {
        this.hiddenEnemyBackgroundPanel = hiddenEnemyBackgroundPanel;
    }

    public JPanel getHiddenCoinBackgroundPanel() {
        return hiddenCoinBackgroundPanel;
    }

    public void setHiddenCoinBackgroundPanel(JPanel hiddenCoinBackgroundPanel) {
        this.hiddenCoinBackgroundPanel = hiddenCoinBackgroundPanel;
    }

    public MusicPlayer getMusicPlayer() {
        return musicPlayer;
    }

    public void setMusicPlayer(MusicPlayer musicPlayer) {
        this.musicPlayer = musicPlayer;
    }
}
