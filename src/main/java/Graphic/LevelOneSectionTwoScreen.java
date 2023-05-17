package Graphic;

import MyProject.MyProject;
import Model.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LevelOneSectionTwoScreen extends JLayeredPane {

    protected ArrayList<ObjectsInGame> objectsInThisSection = new ArrayList<>();
    protected ArrayList<Coin> coinsInThisSection = new ArrayList<>();
    protected ArrayList<Enemy> enemiesInThisSection = new ArrayList<>();
    protected ArrayList<EmptySpaceInGround> emptySpaceInGroundsInThisSection = new ArrayList<>();
    public ArrayList<Mario> activeMario;

    GameData gameData;
    public JLabel backgroundLabelSceneOne;
    public JLabel backgroundLabelSceneTwo;
    public JLabel backgroundLabelSceneThree;
    public JLabel backgroundLabelSceneFour;

    Coin firstCoinOnGroundSceneOne;
    Coin secondCoinOnGroundSceneOne;
    Coin thirdCoinOnGroundSceneOne;
    BlockInAir firstBlockInAirSceneOne;
    Coin coinOnFirstBlockInAirSceneOne;
    BlockInAir secondBlockInAirSceneOne;
    PrizeInAir firstPrizeInAirSceneOne;
    CoinInPrizeInAirs coinInFirstPrizeInAirSceneOne;
    BlockInAir thirdBlockInAirSceneOne;
    BlockInAir fourthBlockInAirSceneOne;
    Coin coinOnFourthBlockInAirSceneOne;

    Coin firstCoinOnGroundSceneTwo;
    BlockInAir firstBlockInAirSceneTwo;
    Coin coinOnFirstBlockInAirSceneTwo;
    BlockInAir secondBlockInAirSceneTwo;
    Coin coinOnSecondBlockInAirSceneTwo;
    BlockInAir thirdBlockInAirSceneTwo;
    Coin coinOnThirdBlockInAirSceneTwo;
    BlockInAir fourthBlockInAirSceneTwo;
    Coin coinOnFourthBlockInAirSceneTwo;
    PrizeInAir firstPrizeInAirSceneTwo;
    CoinInPrizeInAirs coinInFirstPrizeInAirSceneTwo;
    EmptySpaceInGround firstEmptySpaceInGroundSceneTwo;

    Coin firstCoinOnGroundSceneThree;
    Coin secondCoinOnGroundSceneThree;
    Coin thirdCoinOnGroundSceneThree;
    Coin fourthCoinOnGroundSceneThree;
    PrizeInAir firstPrizeInAirSceneThree;
    CoinInPrizeInAirs coinInFirstPrizeInAirSceneThree;
    PrizeInAir secondPrizeInAirSceneThree;
    CoinInPrizeInAirs coinInSecondPrizeInAirSceneThree;
    Pipe firstPipeSceneThree;
    Pipe secondPipeSceneThree;
    Plant plantInSecondPipeSceneThree;
    NormalMario normalMario;
    CoinMario coinMario;
    JumperMario jumperMario;
    RunnerMario runnerMario;
    ShooterMario shooterMario;

    public UserHeart userHeartImage;
    public JLabel userHeartValueLabel;
    public JLabel userScoreLabel;
    public JLabel thisSectionTimeLabel;
    public JLabel thisGameCoin;
    public CoinForStore thisGameCoinImage;
    public LevelOneSectionTwoTime thisSectionTime;
    CastleInLevelOne castle;

    public int XUserHeartImage = 1520;
    public int XUserHeartValueLabel = 1510;
    public int XUserScoreLabel = 1345;
    public int XThisSectionTimeLabel = 1180;
    public int XThisGameCoin = 1080;
    public int XThisGameCoinImage = 1110;

    LevelOneSectionTwoScreen(GameData gameData) {
        init(gameData);
    }

    public LevelOneSectionTwoScreen() {

    }

    public void init(GameData gameData) {

        this.gameData = gameData;
        ImageIcon backgroundImage = new ImageIcon("BackgroundSections.jpg");
        Font font1 = new Font("Comic Sans MS", Font.PLAIN, 22);
        activeMario = new ArrayList<>();
        activeMario.add(new NormalMario(0, 0));
        this.thisSectionTime = new LevelOneSectionTwoTime(this);

        this.setSize(6800, 1100);
        this.setLocation(6800,0);
        this.setVisible(true);

        backgroundLabelSceneOne = new JLabel(backgroundImage);
        backgroundLabelSceneOne.setBounds(0, 0, 1700, 1100);
        backgroundLabelSceneOne.setOpaque(true);

        backgroundLabelSceneTwo = new JLabel(backgroundImage);
        backgroundLabelSceneTwo.setBounds(1700, 0, 1700, 1100);
        backgroundLabelSceneTwo.setOpaque(true);

        backgroundLabelSceneThree = new JLabel(backgroundImage);
        backgroundLabelSceneThree.setBounds(3400, 0, 1700, 1100);
        backgroundLabelSceneThree.setOpaque(true);

        backgroundLabelSceneFour = new JLabel(backgroundImage);
        backgroundLabelSceneFour.setBounds(5100, 0, 1700, 1100);
        backgroundLabelSceneFour.setOpaque(true);

        userHeartImage = new UserHeart(XUserHeartImage, 20);
        userHeartImage.setBounds(userHeartImage.getX(), userHeartImage.getY(), 50, 50);
        userHeartImage.setOpaque(true);
        userHeartValueLabel = new JLabel(String.valueOf(gameData.getUserHeartValue()));
        userHeartValueLabel.setBounds(XUserHeartValueLabel, 30, 20, 20);
        userHeartValueLabel.setFont(font1);

        userScoreLabel = new JLabel("Score: "+ String.valueOf(gameData.getThisGameScore()));
        userScoreLabel.setBounds(XUserScoreLabel, 30, 200, 20);
        userScoreLabel.setFont(font1);

        thisSectionTimeLabel = new JLabel();
        thisSectionTimeLabel.setBounds(XThisSectionTimeLabel, 30, 200, 20);
        thisSectionTimeLabel.setFont(font1);

        thisGameCoin = new JLabel();
        thisGameCoin.setBounds(XThisGameCoin, 25, 200, 30);
        thisGameCoin.setFont(font1);
        thisGameCoinImage = new CoinForStore(XThisGameCoinImage, 30);
        thisGameCoinImage.setLocation(thisGameCoinImage.getX(), thisGameCoinImage.getY());

        //Add Mario:
        if (MyProject.activeUser.get(0).isUserChooseNormal_RedMario()) {
            normalMario = new NormalMario(100, 840);
            activeMario.set(0, normalMario);
            this.add(normalMario, Integer.valueOf(2));
        }
        else if (MyProject.activeUser.get(0).isUserChooseCoin_YellowMario()) {
            coinMario = new CoinMario(100, 840);
            activeMario.set(0,coinMario);
            this.add(coinMario, Integer.valueOf(2));
        }
        else if (MyProject.activeUser.get(0).isUserChooseJumper_GreenMario()) {
            jumperMario = new JumperMario(100, 840);
            activeMario.set(0, jumperMario);
            this.add(jumperMario, Integer.valueOf(2));
        }
        else if (MyProject.activeUser.get(0).isUserChooseRunner_BlueMario()) {
            runnerMario = new RunnerMario(100, 840);
            activeMario.set(0, runnerMario);
            this.add(runnerMario, Integer.valueOf(2));
        } else if (MyProject.activeUser.get(0).isUserChooseShooter_BlackMario()) {
            shooterMario = new ShooterMario(100, 840);
            activeMario.set(0, shooterMario);
            this.add(shooterMario, Integer.valueOf(2));
        } else {
            System.out.println("WTF");
        }

        // Scene One:
        firstCoinOnGroundSceneOne = new Coin(610, 890);
        secondCoinOnGroundSceneOne = new Coin(690, 890);
        thirdCoinOnGroundSceneOne = new Coin(770, 890);
        firstBlockInAirSceneOne = new SimpleBlockInAir(800,700);
        coinOnFirstBlockInAirSceneOne = new Coin(800, 650);
        secondBlockInAirSceneOne = new SimpleBlockInAir(870,700);
        firstPrizeInAirSceneOne = new PrizeInAir(905,450);
        thirdBlockInAirSceneOne = new EmptyBlockInAir(940,700);
        fourthBlockInAirSceneOne = new FullOfCoinBlockInAir(1010,700);
        coinOnFourthBlockInAirSceneOne = new Coin(1010, 650);

// Scene Two:
        firstCoinOnGroundSceneTwo = new Coin(1800, 890);
        firstBlockInAirSceneTwo = new OneCoinBlockInAir(2620,700);
        coinOnFirstBlockInAirSceneTwo = new Coin(2620, 650);
        secondBlockInAirSceneTwo = new EmptyBlockInAir(2690,700);
        coinOnSecondBlockInAirSceneTwo = new Coin(2690, 650);
        thirdBlockInAirSceneTwo = new SimpleBlockInAir(2760,700);
        coinOnThirdBlockInAirSceneTwo = new Coin(2760, 650);
        fourthBlockInAirSceneTwo = new SimpleBlockInAir(2830,700);
        coinOnFourthBlockInAirSceneTwo = new Coin(2830, 650);
        firstPrizeInAirSceneTwo = new PrizeInAir(3020,520);
        firstEmptySpaceInGroundSceneTwo = new EmptySpaceInGround(2310, 945);
        firstPrizeInAirSceneOne = new PrizeInAir(555,450);

// Scene Three:
        firstCoinOnGroundSceneThree = new Coin(3640, 890);
        secondCoinOnGroundSceneThree = new Coin(3720, 890);
        thirdCoinOnGroundSceneThree = new Coin(3800, 890);
        firstPrizeInAirSceneThree = new PrizeInAir(4000,500);
        secondPrizeInAirSceneThree = new PrizeInAir(4400,500);
        firstPipeSceneThree = new Pipe(4100, 765);
        secondPipeSceneThree = new Pipe(4210, 765);
        plantInSecondPipeSceneThree = new Plant(4235, 750);
        fourthCoinOnGroundSceneThree = new Coin(4500, 890);

// Scene Four:
        castle = new CastleInLevelOne(6000, 490);

        firstEmptySpaceInGroundSceneTwo.setOpaque(true);

        this.add(backgroundLabelSceneOne, Integer.valueOf(0));
        this.add(backgroundLabelSceneTwo, Integer.valueOf(0));
        this.add(backgroundLabelSceneThree, Integer.valueOf(0));
        this.add(backgroundLabelSceneFour, Integer.valueOf(0));
        this.add(userHeartImage, Integer.valueOf(1));
        this.add(userHeartValueLabel, Integer.valueOf(1));
        this.add(userScoreLabel, Integer.valueOf(1));
        this.add(thisSectionTimeLabel, Integer.valueOf(1));
        this.add(thisGameCoin, Integer.valueOf(1));
        this.add(thisGameCoinImage, Integer.valueOf(1));

        // Scene One:
        this.add(firstCoinOnGroundSceneOne, Integer.valueOf(1));
        coinsInThisSection.add(firstCoinOnGroundSceneOne);
        this.add(secondCoinOnGroundSceneOne, Integer.valueOf(1));
        coinsInThisSection.add(secondCoinOnGroundSceneOne);
        this.add(thirdCoinOnGroundSceneOne, Integer.valueOf(1));
        coinsInThisSection.add(thirdCoinOnGroundSceneOne);
        this.add(firstBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(firstBlockInAirSceneOne);
        this.add(coinOnFirstBlockInAirSceneOne, Integer.valueOf(1));
        coinsInThisSection.add(coinOnFirstBlockInAirSceneOne);
        this.add(secondBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(secondBlockInAirSceneOne);
        this.add(firstPrizeInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(firstPrizeInAirSceneOne);
        this.add(thirdBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(thirdBlockInAirSceneOne);
        this.add(fourthBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(fourthBlockInAirSceneOne);
        this.add(coinOnFourthBlockInAirSceneOne, Integer.valueOf(1));
        coinsInThisSection.add(coinOnFourthBlockInAirSceneOne);

        // Scene Two:
        this.add(firstCoinOnGroundSceneTwo, Integer.valueOf(1));
        coinsInThisSection.add(firstCoinOnGroundSceneTwo);
        this.add(firstBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(firstBlockInAirSceneTwo);
        this.add(coinOnFirstBlockInAirSceneTwo, Integer.valueOf(1));
        coinsInThisSection.add(coinOnFirstBlockInAirSceneTwo);
        this.add(secondBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(secondBlockInAirSceneTwo);
        this.add(coinOnSecondBlockInAirSceneTwo, Integer.valueOf(1));
        coinsInThisSection.add(coinOnSecondBlockInAirSceneTwo);
        this.add(thirdBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(thirdBlockInAirSceneTwo);
        this.add(coinOnThirdBlockInAirSceneTwo, Integer.valueOf(1));
        coinsInThisSection.add(coinOnThirdBlockInAirSceneTwo);
        this.add(fourthBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(fourthBlockInAirSceneTwo);
        this.add(coinOnFourthBlockInAirSceneTwo, Integer.valueOf(1));
        coinsInThisSection.add(coinOnFourthBlockInAirSceneTwo);
        this.add(firstPrizeInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(firstPrizeInAirSceneTwo);
        this.add(firstEmptySpaceInGroundSceneTwo, Integer.valueOf(1));
        emptySpaceInGroundsInThisSection.add(firstEmptySpaceInGroundSceneTwo);

        // Scene Three:
        this.add(firstCoinOnGroundSceneThree, Integer.valueOf(1));
        coinsInThisSection.add(firstCoinOnGroundSceneThree);
        this.add(secondCoinOnGroundSceneThree, Integer.valueOf(1));
        coinsInThisSection.add(secondCoinOnGroundSceneThree);
        this.add(thirdCoinOnGroundSceneThree, Integer.valueOf(1));
        coinsInThisSection.add(thirdCoinOnGroundSceneThree);
        this.add(firstPrizeInAirSceneThree, Integer.valueOf(1));
        objectsInThisSection.add(firstPrizeInAirSceneThree);
        this.add(secondPrizeInAirSceneThree, Integer.valueOf(1));
        objectsInThisSection.add(secondPrizeInAirSceneThree);
        this.add(firstPipeSceneThree, Integer.valueOf(1));
        objectsInThisSection.add(firstPipeSceneThree);
        this.add(secondPipeSceneThree, Integer.valueOf(1));
        objectsInThisSection.add(secondPipeSceneThree);
        this.add(plantInSecondPipeSceneThree, Integer.valueOf(1));
        enemiesInThisSection.add(plantInSecondPipeSceneThree);
        this.add(fourthCoinOnGroundSceneThree, Integer.valueOf(1));
        coinsInThisSection.add(fourthCoinOnGroundSceneThree);

        // Scene Four:
        this.add(castle, Integer.valueOf(1));

    }

    public ArrayList<ObjectsInGame> getObjectsInThisSection() {
        return objectsInThisSection;
    }

    public void setObjectsInThisSection(ArrayList<ObjectsInGame> objectsInThisSection) {
        this.objectsInThisSection = objectsInThisSection;
    }

    public ArrayList<Coin> getCoinsInThisSection() {
        return coinsInThisSection;
    }

    public void setCoinsInThisSection(ArrayList<Coin> coinsInThisSection) {
        this.coinsInThisSection = coinsInThisSection;
    }

    public ArrayList<Enemy> getEnemiesInThisSection() {
        return enemiesInThisSection;
    }

    public void setEnemiesInThisSection(ArrayList<Enemy> enemiesInThisSection) {
        this.enemiesInThisSection = enemiesInThisSection;
    }

    public ArrayList<EmptySpaceInGround> getEmptySpaceInGroundsInThisSection() {
        return emptySpaceInGroundsInThisSection;
    }

    public void setEmptySpaceInGroundsInThisSection(ArrayList<EmptySpaceInGround> emptySpaceInGroundsInThisSection) {
        this.emptySpaceInGroundsInThisSection = emptySpaceInGroundsInThisSection;
    }

    public ArrayList<Mario> getActiveMario() {
        return activeMario;
    }

    public void setActiveMario(ArrayList<Mario> activeMario) {
        this.activeMario = activeMario;
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    public JLabel getBackgroundLabelSceneOne() {
        return backgroundLabelSceneOne;
    }

    public void setBackgroundLabelSceneOne(JLabel backgroundLabelSceneOne) {
        this.backgroundLabelSceneOne = backgroundLabelSceneOne;
    }

    public JLabel getBackgroundLabelSceneTwo() {
        return backgroundLabelSceneTwo;
    }

    public void setBackgroundLabelSceneTwo(JLabel backgroundLabelSceneTwo) {
        this.backgroundLabelSceneTwo = backgroundLabelSceneTwo;
    }

    public JLabel getBackgroundLabelSceneThree() {
        return backgroundLabelSceneThree;
    }

    public void setBackgroundLabelSceneThree(JLabel backgroundLabelSceneThree) {
        this.backgroundLabelSceneThree = backgroundLabelSceneThree;
    }

    public JLabel getBackgroundLabelSceneFour() {
        return backgroundLabelSceneFour;
    }

    public void setBackgroundLabelSceneFour(JLabel backgroundLabelSceneFour) {
        this.backgroundLabelSceneFour = backgroundLabelSceneFour;
    }

    public Coin getFirstCoinOnGroundSceneOne() {
        return firstCoinOnGroundSceneOne;
    }

    public void setFirstCoinOnGroundSceneOne(Coin firstCoinOnGroundSceneOne) {
        this.firstCoinOnGroundSceneOne = firstCoinOnGroundSceneOne;
    }

    public Coin getSecondCoinOnGroundSceneOne() {
        return secondCoinOnGroundSceneOne;
    }

    public void setSecondCoinOnGroundSceneOne(Coin secondCoinOnGroundSceneOne) {
        this.secondCoinOnGroundSceneOne = secondCoinOnGroundSceneOne;
    }

    public Coin getThirdCoinOnGroundSceneOne() {
        return thirdCoinOnGroundSceneOne;
    }

    public void setThirdCoinOnGroundSceneOne(Coin thirdCoinOnGroundSceneOne) {
        this.thirdCoinOnGroundSceneOne = thirdCoinOnGroundSceneOne;
    }

    public BlockInAir getFirstBlockInAirSceneOne() {
        return firstBlockInAirSceneOne;
    }

    public void setFirstBlockInAirSceneOne(BlockInAir firstBlockInAirSceneOne) {
        this.firstBlockInAirSceneOne = firstBlockInAirSceneOne;
    }

    public Coin getCoinOnFirstBlockInAirSceneOne() {
        return coinOnFirstBlockInAirSceneOne;
    }

    public void setCoinOnFirstBlockInAirSceneOne(Coin coinOnFirstBlockInAirSceneOne) {
        this.coinOnFirstBlockInAirSceneOne = coinOnFirstBlockInAirSceneOne;
    }

    public BlockInAir getSecondBlockInAirSceneOne() {
        return secondBlockInAirSceneOne;
    }

    public void setSecondBlockInAirSceneOne(BlockInAir secondBlockInAirSceneOne) {
        this.secondBlockInAirSceneOne = secondBlockInAirSceneOne;
    }

    public PrizeInAir getFirstPrizeInAirSceneOne() {
        return firstPrizeInAirSceneOne;
    }

    public void setFirstPrizeInAirSceneOne(PrizeInAir firstPrizeInAirSceneOne) {
        this.firstPrizeInAirSceneOne = firstPrizeInAirSceneOne;
    }

    public CoinInPrizeInAirs getCoinInFirstPrizeInAirSceneOne() {
        return coinInFirstPrizeInAirSceneOne;
    }

    public void setCoinInFirstPrizeInAirSceneOne(CoinInPrizeInAirs coinInFirstPrizeInAirSceneOne) {
        this.coinInFirstPrizeInAirSceneOne = coinInFirstPrizeInAirSceneOne;
    }

    public BlockInAir getThirdBlockInAirSceneOne() {
        return thirdBlockInAirSceneOne;
    }

    public void setThirdBlockInAirSceneOne(BlockInAir thirdBlockInAirSceneOne) {
        this.thirdBlockInAirSceneOne = thirdBlockInAirSceneOne;
    }

    public BlockInAir getFourthBlockInAirSceneOne() {
        return fourthBlockInAirSceneOne;
    }

    public void setFourthBlockInAirSceneOne(BlockInAir fourthBlockInAirSceneOne) {
        this.fourthBlockInAirSceneOne = fourthBlockInAirSceneOne;
    }

    public Coin getCoinOnFourthBlockInAirSceneOne() {
        return coinOnFourthBlockInAirSceneOne;
    }

    public void setCoinOnFourthBlockInAirSceneOne(Coin coinOnFourthBlockInAirSceneOne) {
        this.coinOnFourthBlockInAirSceneOne = coinOnFourthBlockInAirSceneOne;
    }

    public Coin getFirstCoinOnGroundSceneTwo() {
        return firstCoinOnGroundSceneTwo;
    }

    public void setFirstCoinOnGroundSceneTwo(Coin firstCoinOnGroundSceneTwo) {
        this.firstCoinOnGroundSceneTwo = firstCoinOnGroundSceneTwo;
    }

    public BlockInAir getFirstBlockInAirSceneTwo() {
        return firstBlockInAirSceneTwo;
    }

    public void setFirstBlockInAirSceneTwo(BlockInAir firstBlockInAirSceneTwo) {
        this.firstBlockInAirSceneTwo = firstBlockInAirSceneTwo;
    }

    public Coin getCoinOnFirstBlockInAirSceneTwo() {
        return coinOnFirstBlockInAirSceneTwo;
    }

    public void setCoinOnFirstBlockInAirSceneTwo(Coin coinOnFirstBlockInAirSceneTwo) {
        this.coinOnFirstBlockInAirSceneTwo = coinOnFirstBlockInAirSceneTwo;
    }

    public BlockInAir getSecondBlockInAirSceneTwo() {
        return secondBlockInAirSceneTwo;
    }

    public void setSecondBlockInAirSceneTwo(BlockInAir secondBlockInAirSceneTwo) {
        this.secondBlockInAirSceneTwo = secondBlockInAirSceneTwo;
    }

    public Coin getCoinOnSecondBlockInAirSceneTwo() {
        return coinOnSecondBlockInAirSceneTwo;
    }

    public void setCoinOnSecondBlockInAirSceneTwo(Coin coinOnSecondBlockInAirSceneTwo) {
        this.coinOnSecondBlockInAirSceneTwo = coinOnSecondBlockInAirSceneTwo;
    }

    public BlockInAir getThirdBlockInAirSceneTwo() {
        return thirdBlockInAirSceneTwo;
    }

    public void setThirdBlockInAirSceneTwo(BlockInAir thirdBlockInAirSceneTwo) {
        this.thirdBlockInAirSceneTwo = thirdBlockInAirSceneTwo;
    }

    public Coin getCoinOnThirdBlockInAirSceneTwo() {
        return coinOnThirdBlockInAirSceneTwo;
    }

    public void setCoinOnThirdBlockInAirSceneTwo(Coin coinOnThirdBlockInAirSceneTwo) {
        this.coinOnThirdBlockInAirSceneTwo = coinOnThirdBlockInAirSceneTwo;
    }

    public BlockInAir getFourthBlockInAirSceneTwo() {
        return fourthBlockInAirSceneTwo;
    }

    public void setFourthBlockInAirSceneTwo(BlockInAir fourthBlockInAirSceneTwo) {
        this.fourthBlockInAirSceneTwo = fourthBlockInAirSceneTwo;
    }

    public Coin getCoinOnFourthBlockInAirSceneTwo() {
        return coinOnFourthBlockInAirSceneTwo;
    }

    public void setCoinOnFourthBlockInAirSceneTwo(Coin coinOnFourthBlockInAirSceneTwo) {
        this.coinOnFourthBlockInAirSceneTwo = coinOnFourthBlockInAirSceneTwo;
    }

    public PrizeInAir getFirstPrizeInAirSceneTwo() {
        return firstPrizeInAirSceneTwo;
    }

    public void setFirstPrizeInAirSceneTwo(PrizeInAir firstPrizeInAirSceneTwo) {
        this.firstPrizeInAirSceneTwo = firstPrizeInAirSceneTwo;
    }

    public CoinInPrizeInAirs getCoinInFirstPrizeInAirSceneTwo() {
        return coinInFirstPrizeInAirSceneTwo;
    }

    public void setCoinInFirstPrizeInAirSceneTwo(CoinInPrizeInAirs coinInFirstPrizeInAirSceneTwo) {
        this.coinInFirstPrizeInAirSceneTwo = coinInFirstPrizeInAirSceneTwo;
    }

    public EmptySpaceInGround getFirstEmptySpaceInGroundSceneTwo() {
        return firstEmptySpaceInGroundSceneTwo;
    }

    public void setFirstEmptySpaceInGroundSceneTwo(EmptySpaceInGround firstEmptySpaceInGroundSceneTwo) {
        this.firstEmptySpaceInGroundSceneTwo = firstEmptySpaceInGroundSceneTwo;
    }

    public Coin getFirstCoinOnGroundSceneThree() {
        return firstCoinOnGroundSceneThree;
    }

    public void setFirstCoinOnGroundSceneThree(Coin firstCoinOnGroundSceneThree) {
        this.firstCoinOnGroundSceneThree = firstCoinOnGroundSceneThree;
    }

    public Coin getSecondCoinOnGroundSceneThree() {
        return secondCoinOnGroundSceneThree;
    }

    public void setSecondCoinOnGroundSceneThree(Coin secondCoinOnGroundSceneThree) {
        this.secondCoinOnGroundSceneThree = secondCoinOnGroundSceneThree;
    }

    public Coin getThirdCoinOnGroundSceneThree() {
        return thirdCoinOnGroundSceneThree;
    }

    public void setThirdCoinOnGroundSceneThree(Coin thirdCoinOnGroundSceneThree) {
        this.thirdCoinOnGroundSceneThree = thirdCoinOnGroundSceneThree;
    }

    public Coin getFourthCoinOnGroundSceneThree() {
        return fourthCoinOnGroundSceneThree;
    }

    public void setFourthCoinOnGroundSceneThree(Coin fourthCoinOnGroundSceneThree) {
        this.fourthCoinOnGroundSceneThree = fourthCoinOnGroundSceneThree;
    }

    public PrizeInAir getFirstPrizeInAirSceneThree() {
        return firstPrizeInAirSceneThree;
    }

    public void setFirstPrizeInAirSceneThree(PrizeInAir firstPrizeInAirSceneThree) {
        this.firstPrizeInAirSceneThree = firstPrizeInAirSceneThree;
    }

    public CoinInPrizeInAirs getCoinInFirstPrizeInAirSceneThree() {
        return coinInFirstPrizeInAirSceneThree;
    }

    public void setCoinInFirstPrizeInAirSceneThree(CoinInPrizeInAirs coinInFirstPrizeInAirSceneThree) {
        this.coinInFirstPrizeInAirSceneThree = coinInFirstPrizeInAirSceneThree;
    }

    public PrizeInAir getSecondPrizeInAirSceneThree() {
        return secondPrizeInAirSceneThree;
    }

    public void setSecondPrizeInAirSceneThree(PrizeInAir secondPrizeInAirSceneThree) {
        this.secondPrizeInAirSceneThree = secondPrizeInAirSceneThree;
    }

    public CoinInPrizeInAirs getCoinInSecondPrizeInAirSceneThree() {
        return coinInSecondPrizeInAirSceneThree;
    }

    public void setCoinInSecondPrizeInAirSceneThree(CoinInPrizeInAirs coinInSecondPrizeInAirSceneThree) {
        this.coinInSecondPrizeInAirSceneThree = coinInSecondPrizeInAirSceneThree;
    }

    public Pipe getFirstPipeSceneThree() {
        return firstPipeSceneThree;
    }

    public void setFirstPipeSceneThree(Pipe firstPipeSceneThree) {
        this.firstPipeSceneThree = firstPipeSceneThree;
    }

    public Pipe getSecondPipeSceneThree() {
        return secondPipeSceneThree;
    }

    public void setSecondPipeSceneThree(Pipe secondPipeSceneThree) {
        this.secondPipeSceneThree = secondPipeSceneThree;
    }

    public Plant getPlantInSecondPipeSceneThree() {
        return plantInSecondPipeSceneThree;
    }

    public void setPlantInSecondPipeSceneThree(Plant plantInSecondPipeSceneThree) {
        this.plantInSecondPipeSceneThree = plantInSecondPipeSceneThree;
    }

    public NormalMario getNormalMario() {
        return normalMario;
    }

    public void setNormalMario(NormalMario normalMario) {
        this.normalMario = normalMario;
    }

    public CoinMario getCoinMario() {
        return coinMario;
    }

    public void setCoinMario(CoinMario coinMario) {
        this.coinMario = coinMario;
    }

    public JumperMario getJumperMario() {
        return jumperMario;
    }

    public void setJumperMario(JumperMario jumperMario) {
        this.jumperMario = jumperMario;
    }

    public RunnerMario getRunnerMario() {
        return runnerMario;
    }

    public void setRunnerMario(RunnerMario runnerMario) {
        this.runnerMario = runnerMario;
    }

    public ShooterMario getShooterMario() {
        return shooterMario;
    }

    public void setShooterMario(ShooterMario shooterMario) {
        this.shooterMario = shooterMario;
    }

    public UserHeart getUserHeartImage() {
        return userHeartImage;
    }

    public void setUserHeartImage(UserHeart userHeartImage) {
        this.userHeartImage = userHeartImage;
    }

    public JLabel getUserHeartValueLabel() {
        return userHeartValueLabel;
    }

    public void setUserHeartValueLabel(JLabel userHeartValueLabel) {
        this.userHeartValueLabel = userHeartValueLabel;
    }

    public JLabel getUserScoreLabel() {
        return userScoreLabel;
    }

    public void setUserScoreLabel(JLabel userScoreLabel) {
        this.userScoreLabel = userScoreLabel;
    }

    public JLabel getThisSectionTimeLabel() {
        return thisSectionTimeLabel;
    }

    public void setThisSectionTimeLabel(JLabel thisSectionTimeLabel) {
        this.thisSectionTimeLabel = thisSectionTimeLabel;
    }

    public JLabel getThisGameCoin() {
        return thisGameCoin;
    }

    public void setThisGameCoin(JLabel thisGameCoin) {
        this.thisGameCoin = thisGameCoin;
    }

    public CoinForStore getThisGameCoinImage() {
        return thisGameCoinImage;
    }

    public void setThisGameCoinImage(CoinForStore thisGameCoinImage) {
        this.thisGameCoinImage = thisGameCoinImage;
    }

    public LevelOneSectionTwoTime getThisSectionTime() {
        return thisSectionTime;
    }

    public void setThisSectionTime(LevelOneSectionTwoTime thisSectionTime) {
        this.thisSectionTime = thisSectionTime;
    }

    public CastleInLevelOne getCastle() {
        return castle;
    }

    public void setCastle(CastleInLevelOne castle) {
        this.castle = castle;
    }

    public int getXUserHeartImage() {
        return XUserHeartImage;
    }

    public void setXUserHeartImage(int XUserHeartImage) {
        this.XUserHeartImage = XUserHeartImage;
    }

    public int getXUserHeartValueLabel() {
        return XUserHeartValueLabel;
    }

    public void setXUserHeartValueLabel(int XUserHeartValueLabel) {
        this.XUserHeartValueLabel = XUserHeartValueLabel;
    }

    public int getXUserScoreLabel() {
        return XUserScoreLabel;
    }

    public void setXUserScoreLabel(int XUserScoreLabel) {
        this.XUserScoreLabel = XUserScoreLabel;
    }

    public int getXThisSectionTimeLabel() {
        return XThisSectionTimeLabel;
    }

    public void setXThisSectionTimeLabel(int XThisSectionTimeLabel) {
        this.XThisSectionTimeLabel = XThisSectionTimeLabel;
    }

    public int getXThisGameCoin() {
        return XThisGameCoin;
    }

    public void setXThisGameCoin(int XThisGameCoin) {
        this.XThisGameCoin = XThisGameCoin;
    }

    public int getXThisGameCoinImage() {
        return XThisGameCoinImage;
    }

    public void setXThisGameCoinImage(int XThisGameCoinImage) {
        this.XThisGameCoinImage = XThisGameCoinImage;
    }
}




