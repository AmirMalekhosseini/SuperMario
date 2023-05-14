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
    JLabel backgroundLabelSceneOne;
    JLabel backgroundLabelSceneTwo;
    JLabel backgroundLabelSceneThree;
    JLabel backgroundLabelSceneFour;

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

    LevelOneSectionTwoScreen(GameData gameData, LevelOneSectionOneScreen levelOneSectionOneScreen) {
        this.gameData = gameData;
        ImageIcon backgroundImage = new ImageIcon("BackgroundSections.jpg");
        Font font1 = new Font("Comic Sans MS", Font.PLAIN, 22);
        activeMario = new ArrayList<>();
        activeMario.add(new NormalMario(0, 0));
        this.thisSectionTime = new LevelOneSectionTwoTime(this, levelOneSectionOneScreen);

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
        firstCoinOnGroundSceneOne.setLocation(firstCoinOnGroundSceneOne.getX(), firstCoinOnGroundSceneOne.getY());
        firstCoinOnGroundSceneOne.setOpaque(true);
        secondCoinOnGroundSceneOne = new Coin(690, 890);
        secondCoinOnGroundSceneOne.setLocation(secondCoinOnGroundSceneOne.getX(), secondCoinOnGroundSceneOne.getY());
        secondCoinOnGroundSceneOne.setOpaque(true);
        thirdCoinOnGroundSceneOne = new Coin(770, 890);
        thirdCoinOnGroundSceneOne.setLocation(thirdCoinOnGroundSceneOne.getX(), thirdCoinOnGroundSceneOne.getY());
        thirdCoinOnGroundSceneOne.setOpaque(true);

        firstBlockInAirSceneOne = new BlockInAir(800,700);
        firstBlockInAirSceneOne.setLocation(firstBlockInAirSceneOne.getX(), firstBlockInAirSceneOne.getY());
        firstBlockInAirSceneOne.setOpaque(true);
        coinOnFirstBlockInAirSceneOne = new Coin(800, 650);
        coinOnFirstBlockInAirSceneOne.setLocation(coinOnFirstBlockInAirSceneOne.getX(), coinOnFirstBlockInAirSceneOne.getY());
        coinOnFirstBlockInAirSceneOne.setOpaque(true);

        secondBlockInAirSceneOne = new BlockInAir(870,700);
        secondBlockInAirSceneOne.setLocation(secondBlockInAirSceneOne.getX(), secondBlockInAirSceneOne.getY());
        secondBlockInAirSceneOne.setOpaque(true);

        firstPrizeInAirSceneOne = new PrizeInAir(905,450);
        firstPrizeInAirSceneOne.setLocation(firstPrizeInAirSceneOne.getX(), firstPrizeInAirSceneOne.getY());
        firstPrizeInAirSceneOne.setOpaque(true);

        thirdBlockInAirSceneOne = new BlockInAir(940,700);
        thirdBlockInAirSceneOne.setLocation(thirdBlockInAirSceneOne.getX(), thirdBlockInAirSceneOne.getY());
        thirdBlockInAirSceneOne.setOpaque(true);

        fourthBlockInAirSceneOne = new BlockInAir(1010,700);
        fourthBlockInAirSceneOne.setLocation(fourthBlockInAirSceneOne.getX(), fourthBlockInAirSceneOne.getY());
        fourthBlockInAirSceneOne.setOpaque(true);
        coinOnFourthBlockInAirSceneOne = new Coin(1010, 650);
        coinOnFourthBlockInAirSceneOne.setLocation(coinOnFourthBlockInAirSceneOne.getX(), coinOnFourthBlockInAirSceneOne.getY());
        coinOnFourthBlockInAirSceneOne.setOpaque(true);

        // Scene Two:
        firstCoinOnGroundSceneTwo = new Coin(1800, 890);
        firstCoinOnGroundSceneTwo.setLocation(firstCoinOnGroundSceneTwo.getX(), firstCoinOnGroundSceneTwo.getY());
        firstCoinOnGroundSceneTwo.setOpaque(true);

        firstBlockInAirSceneTwo = new BlockInAir(2620,700);
        firstBlockInAirSceneTwo.setLocation(firstBlockInAirSceneTwo.getX(), firstBlockInAirSceneTwo.getY());
        firstBlockInAirSceneTwo.setOpaque(true);
        coinOnFirstBlockInAirSceneTwo = new Coin(2620, 650);
        coinOnFirstBlockInAirSceneTwo.setLocation(coinOnFirstBlockInAirSceneTwo.getX(), coinOnFirstBlockInAirSceneTwo.getY());
        coinOnFirstBlockInAirSceneTwo.setOpaque(true);

        secondBlockInAirSceneTwo = new BlockInAir(2690,700);
        secondBlockInAirSceneTwo.setLocation(secondBlockInAirSceneTwo.getX(), secondBlockInAirSceneTwo.getY());
        secondBlockInAirSceneTwo.setOpaque(true);
        coinOnSecondBlockInAirSceneTwo = new Coin(2690, 650);
        coinOnSecondBlockInAirSceneTwo.setLocation(coinOnSecondBlockInAirSceneTwo.getX(), coinOnSecondBlockInAirSceneTwo.getY());
        coinOnSecondBlockInAirSceneTwo.setOpaque(true);

        thirdBlockInAirSceneTwo = new BlockInAir(2760,700);
        thirdBlockInAirSceneTwo.setLocation(thirdBlockInAirSceneTwo.getX(), thirdBlockInAirSceneTwo.getY());
        thirdBlockInAirSceneTwo.setOpaque(true);
        coinOnThirdBlockInAirSceneTwo = new Coin(2760, 650);
        coinOnThirdBlockInAirSceneTwo.setLocation(coinOnThirdBlockInAirSceneTwo.getX(), coinOnThirdBlockInAirSceneTwo.getY());
        coinOnThirdBlockInAirSceneTwo.setOpaque(true);

        fourthBlockInAirSceneTwo = new BlockInAir(2830,700);
        fourthBlockInAirSceneTwo.setLocation(fourthBlockInAirSceneTwo.getX(), fourthBlockInAirSceneTwo.getY());
        fourthBlockInAirSceneTwo.setOpaque(true);
        coinOnFourthBlockInAirSceneTwo = new Coin(2830, 650);
        coinOnFourthBlockInAirSceneTwo.setLocation(coinOnFourthBlockInAirSceneTwo.getX(), coinOnFourthBlockInAirSceneTwo.getY());
        coinOnFourthBlockInAirSceneTwo.setOpaque(true);

        firstPrizeInAirSceneTwo = new PrizeInAir(3020,520);
        firstPrizeInAirSceneTwo.setLocation(firstPrizeInAirSceneTwo.getX(), firstPrizeInAirSceneTwo.getY());
        firstPrizeInAirSceneTwo.setOpaque(true);

        firstEmptySpaceInGroundSceneTwo = new EmptySpaceInGround(2310, 945);
        firstEmptySpaceInGroundSceneTwo.setLocation(firstEmptySpaceInGroundSceneTwo.getX(), firstEmptySpaceInGroundSceneTwo.getY());
        firstEmptySpaceInGroundSceneTwo.setOpaque(true);


        firstPrizeInAirSceneOne = new PrizeInAir(555,450);
        firstPrizeInAirSceneOne.setLocation(firstPrizeInAirSceneOne.getX(), firstPrizeInAirSceneOne.getY());
        firstPrizeInAirSceneOne.setOpaque(true);

        // Scene Three:
        firstCoinOnGroundSceneThree = new Coin(3640, 890);
        firstCoinOnGroundSceneThree.setLocation(firstCoinOnGroundSceneThree.getX(), firstCoinOnGroundSceneThree.getY());
        firstCoinOnGroundSceneThree.setOpaque(true);
        secondCoinOnGroundSceneThree = new Coin(3720, 890);
        secondCoinOnGroundSceneThree.setLocation(secondCoinOnGroundSceneThree.getX(), secondCoinOnGroundSceneThree.getY());
        secondCoinOnGroundSceneThree.setOpaque(true);
        thirdCoinOnGroundSceneThree = new Coin(3800, 890);
        thirdCoinOnGroundSceneThree.setLocation(thirdCoinOnGroundSceneThree.getX(), thirdCoinOnGroundSceneThree.getY());
        thirdCoinOnGroundSceneThree.setOpaque(true);

        firstPrizeInAirSceneThree = new PrizeInAir(4000,500);
        firstPrizeInAirSceneThree.setLocation(firstPrizeInAirSceneThree.getX(), firstPrizeInAirSceneThree.getY());
        firstPrizeInAirSceneThree.setOpaque(true);

        secondPrizeInAirSceneThree = new PrizeInAir(4400,500);
        secondPrizeInAirSceneThree.setLocation(secondPrizeInAirSceneThree.getX(), secondPrizeInAirSceneThree.getY());
        secondPrizeInAirSceneThree.setOpaque(true);

        firstPipeSceneThree = new Pipe(4100, 765);
        firstPipeSceneThree.setLocation(firstPipeSceneThree.getX(), firstPipeSceneThree.getY());
        firstPipeSceneThree.setOpaque(true);

        secondPipeSceneThree = new Pipe(4210, 765);
        secondPipeSceneThree.setLocation(secondPipeSceneThree.getX(), secondPipeSceneThree.getY());
        secondPipeSceneThree.setOpaque(false);
        plantInSecondPipeSceneThree = new Plant(4235, 750);
        plantInSecondPipeSceneThree.setLocation(plantInSecondPipeSceneThree.getX(), plantInSecondPipeSceneThree.getY());
        plantInSecondPipeSceneThree.setOpaque(true);

        fourthCoinOnGroundSceneThree = new Coin(4500, 890);
        fourthCoinOnGroundSceneThree.setLocation(thirdCoinOnGroundSceneThree.getX(), thirdCoinOnGroundSceneThree.getY());
        fourthCoinOnGroundSceneThree.setOpaque(true);

        // Scene Four:
        castle = new CastleInLevelOne(6000, 490);
        castle.setLocation(castle.getX(), castle.getY());
        castle.setOpaque(true);

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

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
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
}




