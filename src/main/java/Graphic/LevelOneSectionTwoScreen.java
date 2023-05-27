package Graphic;

import MyProject.MyProject;
import Model.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LevelOneSectionTwoScreen extends JLayeredPane {

    protected ArrayList<ObjectsInGame> objectsInThisSection = new ArrayList<>();
    protected ArrayList<ItemsInGame> itemsInThisSection = new ArrayList<>();
    protected ArrayList<Enemy> enemiesInThisSection = new ArrayList<>();
    protected ArrayList<BirdBomb> bombsInThisSection = new ArrayList<>();
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
    EmptySpaceInGround firstEmptySpaceInGroundSceneTwo;

    Coin firstCoinOnGroundSceneThree;
    Coin secondCoinOnGroundSceneThree;
    Coin thirdCoinOnGroundSceneThree;
    Coin fourthCoinOnGroundSceneThree;
    PrizeInAir firstPrizeInAirSceneThree;
    PrizeInAir secondPrizeInAirSceneThree;
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
    Castle castle;

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
        Font font1 = MyProjectData.getProjectData().getFont22();
        activeMario = new ArrayList<>();
        activeMario.add(new NormalMario(0, 0));
        this.thisSectionTime = new LevelOneSectionTwoTime(this);

        this.setSize(6800, 1100);
        this.setLocation(6800,0);
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
        castle = new Castle(6000, 490);

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
        itemsInThisSection.add(firstCoinOnGroundSceneOne);
        this.add(secondCoinOnGroundSceneOne, Integer.valueOf(1));
        itemsInThisSection.add(secondCoinOnGroundSceneOne);
        this.add(thirdCoinOnGroundSceneOne, Integer.valueOf(1));
        itemsInThisSection.add(thirdCoinOnGroundSceneOne);
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
        this.add(fourthBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(fourthBlockInAirSceneOne);
        this.add(coinOnFourthBlockInAirSceneOne, Integer.valueOf(1));
        itemsInThisSection.add(coinOnFourthBlockInAirSceneOne);

        // Scene Two:
        this.add(firstCoinOnGroundSceneTwo, Integer.valueOf(1));
        itemsInThisSection.add(firstCoinOnGroundSceneTwo);
        this.add(firstBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(firstBlockInAirSceneTwo);
        this.add(coinOnFirstBlockInAirSceneTwo, Integer.valueOf(1));
        itemsInThisSection.add(coinOnFirstBlockInAirSceneTwo);
        this.add(secondBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(secondBlockInAirSceneTwo);
        this.add(coinOnSecondBlockInAirSceneTwo, Integer.valueOf(1));
        itemsInThisSection.add(coinOnSecondBlockInAirSceneTwo);
        this.add(thirdBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(thirdBlockInAirSceneTwo);
        this.add(coinOnThirdBlockInAirSceneTwo, Integer.valueOf(1));
        itemsInThisSection.add(coinOnThirdBlockInAirSceneTwo);
        this.add(fourthBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(fourthBlockInAirSceneTwo);
        this.add(coinOnFourthBlockInAirSceneTwo, Integer.valueOf(1));
        itemsInThisSection.add(coinOnFourthBlockInAirSceneTwo);
        this.add(firstPrizeInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(firstPrizeInAirSceneTwo);
        this.add(firstEmptySpaceInGroundSceneTwo, Integer.valueOf(1));
        emptySpaceInGroundsInThisSection.add(firstEmptySpaceInGroundSceneTwo);

        // Scene Three:
        this.add(firstCoinOnGroundSceneThree, Integer.valueOf(1));
        itemsInThisSection.add(firstCoinOnGroundSceneThree);
        this.add(secondCoinOnGroundSceneThree, Integer.valueOf(1));
        itemsInThisSection.add(secondCoinOnGroundSceneThree);
        this.add(thirdCoinOnGroundSceneThree, Integer.valueOf(1));
        itemsInThisSection.add(thirdCoinOnGroundSceneThree);
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
        itemsInThisSection.add(fourthCoinOnGroundSceneThree);

        // Scene Four:
        this.add(castle, Integer.valueOf(1));

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
    public ArrayList<BirdBomb> getBombsInThisSection() {
        return bombsInThisSection;
    }

    public void setBombsInThisSection(ArrayList<BirdBomb> bombsInThisSection) {
        this.bombsInThisSection = bombsInThisSection;
    }
    public GameData getGameData() {
        return gameData;
    }

}




