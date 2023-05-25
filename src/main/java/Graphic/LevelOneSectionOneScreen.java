package Graphic;

import MyProject.MyProject;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LevelOneSectionOneScreen extends JLayeredPane {

    protected ArrayList<ObjectsInGame> objectsInThisSection = new ArrayList<>();
    protected ArrayList<ItemsInGame> itemsInThisSection = new ArrayList<>();
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
    BlockInAir seventhBlockInAirSceneOne;
    Coin fourthCoinOnGroundSceneOne;
    Coin fifthCoinOnGroundSceneOne;

    BlockInAir firstBlockInAirSceneTwo;
    BlockInAir secondBlockInAirSceneTwo;
    BlockInAir thirdBlockInAirSceneTwo;
    BlockInAir fourthBlockInAirSceneTwo;
    PrizeInAir firstPrizeInAirSceneTwo;
    EmptySpaceInGround firstEmptySpaceInGroundSceneTwo;
    BlockInAir fifthBlockInAirSceneTwo;
    Coin coinOnFifthBlockInAirSceneTwo;
    BlockInAir sixthBlockInAirSceneTwo;
    Coin coinOnSixthBlockInAirSceneTwo;
    BlockInAir seventhBlockInAirSceneTwo;
    Coin coinOnSeventhBlockInAirSceneTwo;

    PrizeInAir firstPrizeInAirSceneThree;
    PrizeInAir secondPrizeInAirSceneThree;
    Coin firstCoinOnGroundSceneThree;
    Coin secondCoinOnGroundSceneThree;
    Coin thirdCoinOnGroundSceneThree;
    Pipe firstPipeSceneThree;
    Plant plantInFirstPipeSceneThree;
    Pipe secondPipeSceneThree;

    PipeHorizontal pipeHorizontalSceneFour;
    Castle castle;
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
        Font font1 = MyProjectData.getProjectData().getFont22();
        thisSectionTime = new LevelOneSectionOneTime(this);

        this.setSize(6800, 1100);
        this.setVisible(true);

        backgroundLabelSceneOne = new JLabel(backgroundImage);
        backgroundLabelSceneOne.setBounds(0, 0, 1700, 1100);

        backgroundLabelSceneTwo = new JLabel(backgroundImage);
        backgroundLabelSceneTwo.setBounds(1700, 0, 1700, 1100);

        backgroundLabelSceneThree = new JLabel(backgroundImage);
        backgroundLabelSceneThree.setBounds(3400, 0, 1700, 1100);

        backgroundLabelSceneFour = new JLabel(backgroundImage);
        backgroundLabelSceneFour.setBounds(5100, 0, 1700, 1100);

        userHeartImage = new UserHeart(XUserHeartImage, 20);
        userHeartImage.setBounds(userHeartImage.getX(), userHeartImage.getY(), 50, 50);
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
        } else if (MyProject.activeUser.get(0).isUserChooseCoin_YellowMario()) {
            coinMario = new CoinMario(100, 840);
            activeMario.set(0, coinMario);
            this.add(coinMario, Integer.valueOf(2));
        } else if (MyProject.activeUser.get(0).isUserChooseJumper_GreenMario()) {
            jumperMario = new JumperMario(100, 840);
            activeMario.set(0, jumperMario);
            this.add(jumperMario, Integer.valueOf(2));
        } else if (MyProject.activeUser.get(0).isUserChooseRunner_BlueMario()) {
            runnerMario = new RunnerMario(100, 840);
            activeMario.set(0, runnerMario);
            this.add(runnerMario, Integer.valueOf(2));
        } else if (MyProject.activeUser.get(0).isUserChooseShooter_BlackMario()) {
            shooterMario = new ShooterMario(100, 840);
            activeMario.set(0, shooterMario);
            this.add(shooterMario, Integer.valueOf(2));
        }

        // Scene One
//        Enemy testEnemy = new Goompa(4900, 625);
//        this.add(testEnemy, Integer.valueOf(1));
//        enemiesInThisSection.add(testEnemy);
//        Enemy testEnemy1 = new Goompa(4800, 625);
//        this.add(testEnemy1, Integer.valueOf(1));
//        enemiesInThisSection.add(testEnemy1);
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
        castle = new Castle(6220, 490);
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
        itemsInThisSection.add(coinOnFirstBlockInAirSceneOne);
        this.add(secondBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(secondBlockInAirSceneOne);
        this.add(firstPrizeInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(firstPrizeInAirSceneOne);
        this.add(thirdBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(thirdBlockInAirSceneOne);
        this.add(coinOnThirdBlockInAirSceneOne, Integer.valueOf(1));
        itemsInThisSection.add(coinOnThirdBlockInAirSceneOne);
        this.add(fourthBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(fourthBlockInAirSceneOne);
        this.add(firstCoinOnGroundSceneOne, Integer.valueOf(1));
        itemsInThisSection.add(firstCoinOnGroundSceneOne);
        this.add(secondCoinOnGroundSceneOne, Integer.valueOf(1));
        itemsInThisSection.add(secondCoinOnGroundSceneOne);
        this.add(thirdCoinOnGroundSceneOne, Integer.valueOf(1));
        itemsInThisSection.add(thirdCoinOnGroundSceneOne);
        this.add(fifthBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(fifthBlockInAirSceneOne);
        this.add(secondPrizeInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(secondPrizeInAirSceneOne);
        this.add(sixthBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(sixthBlockInAirSceneOne);
        this.add(coinOnSixthBlockInAirSceneOne, Integer.valueOf(1));
        itemsInThisSection.add(coinOnSixthBlockInAirSceneOne);
        this.add(seventhBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(seventhBlockInAirSceneOne);
        this.add(fourthCoinOnGroundSceneOne, Integer.valueOf(1));
        itemsInThisSection.add(fourthCoinOnGroundSceneOne);
        this.add(fifthCoinOnGroundSceneOne, Integer.valueOf(1));
        itemsInThisSection.add(fifthCoinOnGroundSceneOne);

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
        itemsInThisSection.add(coinOnFifthBlockInAirSceneTwo);
        this.add(sixthBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(sixthBlockInAirSceneTwo);
        this.add(coinOnSixthBlockInAirSceneTwo, Integer.valueOf(1));
        itemsInThisSection.add(coinOnSixthBlockInAirSceneTwo);
        this.add(seventhBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(seventhBlockInAirSceneTwo);
        this.add(coinOnSeventhBlockInAirSceneTwo, Integer.valueOf(1));
        itemsInThisSection.add(coinOnSeventhBlockInAirSceneTwo);

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
        itemsInThisSection.add(firstCoinOnGroundSceneThree);
        this.add(secondCoinOnGroundSceneThree, Integer.valueOf(1));
        itemsInThisSection.add(secondCoinOnGroundSceneThree);
        this.add(thirdCoinOnGroundSceneThree, Integer.valueOf(1));
        itemsInThisSection.add(thirdCoinOnGroundSceneThree);
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

    public ArrayList<ItemsInGame> getItemsInThisSection() {
        return itemsInThisSection;
    }

    public ArrayList<Enemy> getEnemiesInThisSection() {
        return enemiesInThisSection;
    }

    public ArrayList<EmptySpaceInGround> getEmptySpaceInGroundsInThisSection() {
        return emptySpaceInGroundsInThisSection;
    }

    public GameData getGameData() {
        return gameData;
    }

}
