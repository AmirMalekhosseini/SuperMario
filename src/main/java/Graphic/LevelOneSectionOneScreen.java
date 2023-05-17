package Graphic;

import MyProject.MyProject;
import Model.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LevelOneSectionOneScreen extends JLayeredPane {

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
    BlockInAir firstBlockInAirSceneOne;
    Coin coinOnFirstBlockInAirSceneOne;
    BlockInAir secondBlockInAirSceneOne;
    PrizeInAir firstPrizeInAirSceneOne;
    CoinInPrizeInAirs coinInFirstPrizeInAirSceneOne;
    BlockInAir thirdBlockInAirSceneOne;
    Coin coinOnThirdBlockInAirSceneOne;
    BlockInAir fourthBlockInAirSceneOne;
    Coin firstCoinOnGroundSceneOne;
    Coin secondCoinOnGroundSceneOne;
    Coin thirdCoinOnGroundSceneOne;
    BlockInAir fifthBlockInAirSceneOne;
    BlockInAir sixthBlockInAirSceneOne;
    Coin coinOnSixthBlockInAirSceneOne;
    PrizeInAir secondPrizeInAirSceneOne;
    CoinInPrizeInAirs coinInSecondPrizeInAirSceneOne;
    BlockInAir seventhBlockInAirSceneOne;
    Coin fourthCoinOnGroundSceneOne;
    Coin fifthCoinOnGroundSceneOne;

    BlockInAir firstBlockInAirSceneTwo;
    BlockInAir secondBlockInAirSceneTwo;
    BlockInAir thirdBlockInAirSceneTwo;
    BlockInAir fourthBlockInAirSceneTwo;
    PrizeInAir firstPrizeInAirSceneTwo;
    CoinInPrizeInAirs coinInFirstPrizeInAirSceneTwo;
    EmptySpaceInGround firstEmptySpaceInGroundSceneTwo;
    BlockInAir fifthBlockInAirSceneTwo;
    Coin coinOnFifthBlockInAirSceneTwo;
    BlockInAir sixthBlockInAirSceneTwo;
    Coin coinOnSixthBlockInAirSceneTwo;
    BlockInAir seventhBlockInAirSceneTwo;
    Coin coinOnSeventhBlockInAirSceneTwo;

    PrizeInAir firstPrizeInAirSceneThree;
    CoinInPrizeInAirs coinInFirstPrizeInAirSceneThree;
    PrizeInAir secondPrizeInAirSceneThree;
    CoinInPrizeInAirs coinInSecondPrizeInAirSceneThree;
    Coin firstCoinOnGroundSceneThree;
    Coin secondCoinOnGroundSceneThree;
    Coin thirdCoinOnGroundSceneThree;
    Pipe firstPipeSceneThree;
    Plant plantInFirstPipeSceneThree;
    Pipe secondPipeSceneThree;

    PipeHorizontal pipeHorizontalSceneFour;
    CastleInLevelOne castle;
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
    public LevelOneSectionOneTime thisSectionTime;

    public int XUserHeartImage = 1520;
    public int XUserHeartValueLabel = 1510;
    public int XUserScoreLabel = 1345;
    public int XThisSectionTimeLabel = 1180;
    public int XThisGameCoin = 1080;
    public int XThisGameCoinImage = 1110;



    LevelOneSectionOneScreen(GameData gameData) {
        init(gameData);
    }

    public LevelOneSectionOneScreen() {

    }

    private void init(GameData gameData) {

        this.gameData = gameData;
        ImageIcon backgroundImage = new ImageIcon("BackgroundSections.jpg");
        activeMario = new ArrayList<>();
        activeMario.add(new NormalMario(0, 0));
        Font font1 = new Font("Comic Sans MS", Font.PLAIN, 22);
        thisSectionTime = new LevelOneSectionOneTime(this);

        this.setSize(6800, 1100);
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

        userScoreLabel = new JLabel("Score: " + String.valueOf(gameData.getThisGameScore()));
        userScoreLabel.setBounds(XUserScoreLabel, 30, 200, 20);
        userScoreLabel.setFont(font1);

        thisSectionTimeLabel = new JLabel("Time: " + thisSectionTime.getSectionTime());
        thisSectionTimeLabel.setBounds(XThisSectionTimeLabel, 30, 200, 20);
        thisSectionTimeLabel.setFont(font1);

        thisGameCoin = new JLabel();
        thisGameCoin.setBounds(XThisGameCoin, 25, 200, 30);
        thisGameCoin.setFont(font1);
        thisGameCoinImage = new CoinForStore(XThisGameCoinImage, 30);
        thisGameCoinImage.setLocation(thisGameCoinImage.getX(), thisGameCoinImage.getY());

//        Add Mario:
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
        }

        // Scene One
        firstBlockInAirSceneOne = new SimpleBlockInAir(450, 700);
        coinOnFirstBlockInAirSceneOne = new Coin(450, 650);
        secondBlockInAirSceneOne = new SimpleBlockInAir(520, 700);
        firstPrizeInAirSceneOne = new PrizeInAir(555, 450);
        thirdBlockInAirSceneOne = new EmptyBlockInAir(590, 700);
        coinOnThirdBlockInAirSceneOne = new Coin(590, 650);
        fourthBlockInAirSceneOne = new FullOfCoinBlockInAir(660, 700);
        firstCoinOnGroundSceneOne = new Coin(610, 890);
        secondCoinOnGroundSceneOne = new Coin(690, 890);
        thirdCoinOnGroundSceneOne = new Coin(770, 890);
        fifthBlockInAirSceneOne = new OneCoinBlockInAir(1000, 700);
        secondPrizeInAirSceneOne = new PrizeInAir(1070, 700);
        sixthBlockInAirSceneOne = new EmptyBlockInAir(1140, 700);
        coinOnSixthBlockInAirSceneOne = new Coin(1140, 650);
        seventhBlockInAirSceneOne = new FullOfCoinBlockInAir(1210, 700);
        fourthCoinOnGroundSceneOne = new Coin(1220, 890);
        fifthCoinOnGroundSceneOne = new Coin(1300, 890);

        // Scene Two
        firstBlockInAirSceneTwo = new SimpleBlockInAir(2100, 700);
        secondBlockInAirSceneTwo = new SimpleBlockInAir(2170, 700);
        thirdBlockInAirSceneTwo = new EmptyBlockInAir(2240, 700);
        fourthBlockInAirSceneTwo = new OneCoinBlockInAir(2310, 700);
        firstPrizeInAirSceneTwo = new PrizeInAir(2900, 520);
        firstEmptySpaceInGroundSceneTwo = new EmptySpaceInGround(2550, 945);
        fifthBlockInAirSceneTwo = new SimpleBlockInAir(2500, 600);
        coinOnFifthBlockInAirSceneTwo = new Coin(2500, 550);
        sixthBlockInAirSceneTwo = new EmptyBlockInAir(2570, 600);
        coinOnSixthBlockInAirSceneTwo = new Coin(2570, 550);
        seventhBlockInAirSceneTwo = new FullOfCoinBlockInAir(2640, 600);
        coinOnSeventhBlockInAirSceneTwo = new Coin(2640, 550);

        // Scene Three
        firstPrizeInAirSceneThree = new PrizeInAir(4300, 500);
        secondPrizeInAirSceneThree = new PrizeInAir(4700, 500);
        firstCoinOnGroundSceneThree = new Coin(4400, 890);
        secondCoinOnGroundSceneThree = new Coin(4480, 890);
        thirdCoinOnGroundSceneThree = new Coin(4480, 890);
        firstPipeSceneThree = new Pipe(4100, 765);
        plantInFirstPipeSceneThree = new Plant(4125, 750);
        secondPipeSceneThree = new Pipe(4800, 765);

        // Scene Four
        castle = new CastleInLevelOne(6220, 490);
        pipeHorizontalSceneFour = new PipeHorizontal(5780, 820);

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
        this.add(coinOnThirdBlockInAirSceneOne, Integer.valueOf(1));
        coinsInThisSection.add(coinOnThirdBlockInAirSceneOne);
        this.add(fourthBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(fourthBlockInAirSceneOne);
        this.add(firstCoinOnGroundSceneOne, Integer.valueOf(1));
        coinsInThisSection.add(firstCoinOnGroundSceneOne);
        this.add(secondCoinOnGroundSceneOne, Integer.valueOf(1));
        coinsInThisSection.add(secondCoinOnGroundSceneOne);
        this.add(thirdCoinOnGroundSceneOne, Integer.valueOf(1));
        coinsInThisSection.add(thirdCoinOnGroundSceneOne);
        this.add(fifthBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(fifthBlockInAirSceneOne);
        this.add(secondPrizeInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(secondPrizeInAirSceneOne);
        this.add(sixthBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(sixthBlockInAirSceneOne);
        this.add(coinOnSixthBlockInAirSceneOne, Integer.valueOf(1));
        coinsInThisSection.add(coinOnSixthBlockInAirSceneOne);
        this.add(seventhBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(seventhBlockInAirSceneOne);
        this.add(fourthCoinOnGroundSceneOne, Integer.valueOf(1));
        coinsInThisSection.add(fourthCoinOnGroundSceneOne);
        this.add(fifthCoinOnGroundSceneOne, Integer.valueOf(1));
        coinsInThisSection.add(fifthCoinOnGroundSceneOne);

        // Scene Two:
        this.add(firstBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(firstBlockInAirSceneTwo);
        this.add(secondBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(secondBlockInAirSceneTwo);
        this.add(thirdBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(thirdBlockInAirSceneTwo);
        this.add(fourthBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(fourthBlockInAirSceneTwo);
        this.add(firstPrizeInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(firstPrizeInAirSceneTwo);
        this.add(firstEmptySpaceInGroundSceneTwo, Integer.valueOf(1));
        emptySpaceInGroundsInThisSection.add(firstEmptySpaceInGroundSceneTwo);
        this.add(fifthBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(fifthBlockInAirSceneTwo);
        this.add(coinOnFifthBlockInAirSceneTwo, Integer.valueOf(1));
        coinsInThisSection.add(coinOnFifthBlockInAirSceneTwo);
        this.add(sixthBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(sixthBlockInAirSceneTwo);
        this.add(coinOnSixthBlockInAirSceneTwo, Integer.valueOf(1));
        coinsInThisSection.add(coinOnSixthBlockInAirSceneTwo);
        this.add(seventhBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(seventhBlockInAirSceneTwo);
        this.add(coinOnSeventhBlockInAirSceneTwo, Integer.valueOf(1));
        coinsInThisSection.add(coinOnSeventhBlockInAirSceneTwo);

        // Scene Three:
        this.add(firstPrizeInAirSceneThree, Integer.valueOf(1));
        objectsInThisSection.add(firstPrizeInAirSceneThree);
        this.add(secondPrizeInAirSceneThree, Integer.valueOf(1));
        objectsInThisSection.add(secondPrizeInAirSceneThree);
        this.add(firstPipeSceneThree, Integer.valueOf(1));
        objectsInThisSection.add(firstPipeSceneThree);
        this.add(plantInFirstPipeSceneThree, Integer.valueOf(1));
        enemiesInThisSection.add(plantInFirstPipeSceneThree);
        this.add(firstCoinOnGroundSceneThree, Integer.valueOf(1));
        coinsInThisSection.add(firstCoinOnGroundSceneThree);
        this.add(secondCoinOnGroundSceneThree, Integer.valueOf(1));
        coinsInThisSection.add(secondCoinOnGroundSceneThree);
        this.add(thirdCoinOnGroundSceneThree, Integer.valueOf(1));
        coinsInThisSection.add(thirdCoinOnGroundSceneThree);
        this.add(secondPipeSceneThree, Integer.valueOf(1));
        objectsInThisSection.add(secondPipeSceneThree);

        // Scene Four:
        this.add(castle, Integer.valueOf(1));
        this.add(pipeHorizontalSceneFour, Integer.valueOf(1));
        objectsInThisSection.add(pipeHorizontalSceneFour);

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

    public Coin getCoinOnThirdBlockInAirSceneOne() {
        return coinOnThirdBlockInAirSceneOne;
    }

    public void setCoinOnThirdBlockInAirSceneOne(Coin coinOnThirdBlockInAirSceneOne) {
        this.coinOnThirdBlockInAirSceneOne = coinOnThirdBlockInAirSceneOne;
    }

    public BlockInAir getFourthBlockInAirSceneOne() {
        return fourthBlockInAirSceneOne;
    }

    public void setFourthBlockInAirSceneOne(BlockInAir fourthBlockInAirSceneOne) {
        this.fourthBlockInAirSceneOne = fourthBlockInAirSceneOne;
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

    public BlockInAir getFifthBlockInAirSceneOne() {
        return fifthBlockInAirSceneOne;
    }

    public void setFifthBlockInAirSceneOne(BlockInAir fifthBlockInAirSceneOne) {
        this.fifthBlockInAirSceneOne = fifthBlockInAirSceneOne;
    }

    public BlockInAir getSixthBlockInAirSceneOne() {
        return sixthBlockInAirSceneOne;
    }

    public void setSixthBlockInAirSceneOne(BlockInAir sixthBlockInAirSceneOne) {
        this.sixthBlockInAirSceneOne = sixthBlockInAirSceneOne;
    }

    public Coin getCoinOnSixthBlockInAirSceneOne() {
        return coinOnSixthBlockInAirSceneOne;
    }

    public void setCoinOnSixthBlockInAirSceneOne(Coin coinOnSixthBlockInAirSceneOne) {
        this.coinOnSixthBlockInAirSceneOne = coinOnSixthBlockInAirSceneOne;
    }

    public PrizeInAir getSecondPrizeInAirSceneOne() {
        return secondPrizeInAirSceneOne;
    }

    public void setSecondPrizeInAirSceneOne(PrizeInAir secondPrizeInAirSceneOne) {
        this.secondPrizeInAirSceneOne = secondPrizeInAirSceneOne;
    }

    public CoinInPrizeInAirs getCoinInSecondPrizeInAirSceneOne() {
        return coinInSecondPrizeInAirSceneOne;
    }

    public void setCoinInSecondPrizeInAirSceneOne(CoinInPrizeInAirs coinInSecondPrizeInAirSceneOne) {
        this.coinInSecondPrizeInAirSceneOne = coinInSecondPrizeInAirSceneOne;
    }

    public BlockInAir getSeventhBlockInAirSceneOne() {
        return seventhBlockInAirSceneOne;
    }

    public void setSeventhBlockInAirSceneOne(BlockInAir seventhBlockInAirSceneOne) {
        this.seventhBlockInAirSceneOne = seventhBlockInAirSceneOne;
    }

    public Coin getFourthCoinOnGroundSceneOne() {
        return fourthCoinOnGroundSceneOne;
    }

    public void setFourthCoinOnGroundSceneOne(Coin fourthCoinOnGroundSceneOne) {
        this.fourthCoinOnGroundSceneOne = fourthCoinOnGroundSceneOne;
    }

    public Coin getFifthCoinOnGroundSceneOne() {
        return fifthCoinOnGroundSceneOne;
    }

    public void setFifthCoinOnGroundSceneOne(Coin fifthCoinOnGroundSceneOne) {
        this.fifthCoinOnGroundSceneOne = fifthCoinOnGroundSceneOne;
    }

    public BlockInAir getFirstBlockInAirSceneTwo() {
        return firstBlockInAirSceneTwo;
    }

    public void setFirstBlockInAirSceneTwo(BlockInAir firstBlockInAirSceneTwo) {
        this.firstBlockInAirSceneTwo = firstBlockInAirSceneTwo;
    }

    public BlockInAir getSecondBlockInAirSceneTwo() {
        return secondBlockInAirSceneTwo;
    }

    public void setSecondBlockInAirSceneTwo(BlockInAir secondBlockInAirSceneTwo) {
        this.secondBlockInAirSceneTwo = secondBlockInAirSceneTwo;
    }

    public BlockInAir getThirdBlockInAirSceneTwo() {
        return thirdBlockInAirSceneTwo;
    }

    public void setThirdBlockInAirSceneTwo(BlockInAir thirdBlockInAirSceneTwo) {
        this.thirdBlockInAirSceneTwo = thirdBlockInAirSceneTwo;
    }

    public BlockInAir getFourthBlockInAirSceneTwo() {
        return fourthBlockInAirSceneTwo;
    }

    public void setFourthBlockInAirSceneTwo(BlockInAir fourthBlockInAirSceneTwo) {
        this.fourthBlockInAirSceneTwo = fourthBlockInAirSceneTwo;
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

    public BlockInAir getFifthBlockInAirSceneTwo() {
        return fifthBlockInAirSceneTwo;
    }

    public void setFifthBlockInAirSceneTwo(BlockInAir fifthBlockInAirSceneTwo) {
        this.fifthBlockInAirSceneTwo = fifthBlockInAirSceneTwo;
    }

    public Coin getCoinOnFifthBlockInAirSceneTwo() {
        return coinOnFifthBlockInAirSceneTwo;
    }

    public void setCoinOnFifthBlockInAirSceneTwo(Coin coinOnFifthBlockInAirSceneTwo) {
        this.coinOnFifthBlockInAirSceneTwo = coinOnFifthBlockInAirSceneTwo;
    }

    public BlockInAir getSixthBlockInAirSceneTwo() {
        return sixthBlockInAirSceneTwo;
    }

    public void setSixthBlockInAirSceneTwo(BlockInAir sixthBlockInAirSceneTwo) {
        this.sixthBlockInAirSceneTwo = sixthBlockInAirSceneTwo;
    }

    public Coin getCoinOnSixthBlockInAirSceneTwo() {
        return coinOnSixthBlockInAirSceneTwo;
    }

    public void setCoinOnSixthBlockInAirSceneTwo(Coin coinOnSixthBlockInAirSceneTwo) {
        this.coinOnSixthBlockInAirSceneTwo = coinOnSixthBlockInAirSceneTwo;
    }

    public BlockInAir getSeventhBlockInAirSceneTwo() {
        return seventhBlockInAirSceneTwo;
    }

    public void setSeventhBlockInAirSceneTwo(BlockInAir seventhBlockInAirSceneTwo) {
        this.seventhBlockInAirSceneTwo = seventhBlockInAirSceneTwo;
    }

    public Coin getCoinOnSeventhBlockInAirSceneTwo() {
        return coinOnSeventhBlockInAirSceneTwo;
    }

    public void setCoinOnSeventhBlockInAirSceneTwo(Coin coinOnSeventhBlockInAirSceneTwo) {
        this.coinOnSeventhBlockInAirSceneTwo = coinOnSeventhBlockInAirSceneTwo;
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

    public Pipe getFirstPipeSceneThree() {
        return firstPipeSceneThree;
    }

    public void setFirstPipeSceneThree(Pipe firstPipeSceneThree) {
        this.firstPipeSceneThree = firstPipeSceneThree;
    }

    public Plant getPlantInFirstPipeSceneThree() {
        return plantInFirstPipeSceneThree;
    }

    public void setPlantInFirstPipeSceneThree(Plant plantInFirstPipeSceneThree) {
        this.plantInFirstPipeSceneThree = plantInFirstPipeSceneThree;
    }

    public Pipe getSecondPipeSceneThree() {
        return secondPipeSceneThree;
    }

    public void setSecondPipeSceneThree(Pipe secondPipeSceneThree) {
        this.secondPipeSceneThree = secondPipeSceneThree;
    }

    public PipeHorizontal getPipeHorizontalSceneFour() {
        return pipeHorizontalSceneFour;
    }

    public void setPipeHorizontalSceneFour(PipeHorizontal pipeHorizontalSceneFour) {
        this.pipeHorizontalSceneFour = pipeHorizontalSceneFour;
    }

    public CastleInLevelOne getCastle() {
        return castle;
    }

    public void setCastle(CastleInLevelOne castle) {
        this.castle = castle;
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

    public LevelOneSectionOneTime getThisSectionTime() {
        return thisSectionTime;
    }

    public void setThisSectionTime(LevelOneSectionOneTime thisSectionTime) {
        this.thisSectionTime = thisSectionTime;
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
