package Graphic;

import MyProject.MyProject;
import Model.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LevelOneSectionTwoScreen extends LevelScreens {

    protected ArrayList<ObjectsInGame> objectsInThisSection = new ArrayList<>();
    protected ArrayList<ItemsInGame> itemsInThisSection = new ArrayList<>();
    protected ArrayList<Enemy> enemiesInThisSection = new ArrayList<>();
    protected ArrayList<BirdBomb> bombsInThisSection = new ArrayList<>();
    protected ArrayList<MarioWeapon> weaponsInThisSection = new ArrayList<>();
    protected ArrayList<EmptySpaceInGround> emptySpaceInGroundsInThisSection = new ArrayList<>();
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
    Enemy firstEnemyInSceneOne;
    Enemy secondEnemyInSceneOne;
    Enemy thirdEnemyInSceneOne;
    Enemy fourthEnemyInSceneOne;
    Enemy fifthEnemyInSceneOne;

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
    Enemy firstEnemyInSceneTwo;
    Enemy secondEnemyInSceneTwo;
    Enemy thirdEnemyInSceneTwo;
    BlockInAir slimeBlockInSceneTwo;

    Coin firstCoinOnGroundSceneThree;
    Coin secondCoinOnGroundSceneThree;
    Coin thirdCoinOnGroundSceneThree;
    Coin fourthCoinOnGroundSceneThree;
    PrizeInAir firstPrizeInAirSceneThree;
    PrizeInAir secondPrizeInAirSceneThree;
    Pipe firstPipeSceneThree;
    Pipe secondPipeSceneThree;
    Plant plantInSecondPipeSceneThree;
    Enemy firstEnemyInSceneThree;
    Enemy secondEnemyInSceneThree;
    Enemy thirdEnemyInSceneThree;
    Enemy fourthEnemyInSceneThree;
    Enemy fifthEnemyInSceneThree;
    Enemy sixthEnemyInSceneThree;

    NormalMario normalMario;
    CoinMario coinMario;
    JumperMario jumperMario;
    RunnerMario runnerMario;
    ShooterMario shooterMario;
    Castle castle;

    LevelOneSectionTwoScreen(GameData gameData) {
        init(gameData);
    }

    public LevelOneSectionTwoScreen() {

    }

    public void init(GameData gameData) {

        this.gameData = gameData;
        ImageIcon backgroundImage = new ImageIcon("BackgroundSections.jpg");
        Font font1 = MyProjectData.getProjectData().getFont22();
        activeMario = new NormalMario(0, 0);

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
            activeMario = normalMario;
            this.add(normalMario, Integer.valueOf(2));
        } else if (MyProject.activeUser.get(0).isUserChooseCoin_YellowMario()) {
            coinMario = new CoinMario(100, 840);
            activeMario = coinMario;
            this.add(coinMario, Integer.valueOf(2));
        } else if (MyProject.activeUser.get(0).isUserChooseJumper_GreenMario()) {
            jumperMario = new JumperMario(100, 840);
            activeMario = jumperMario;
            this.add(jumperMario, Integer.valueOf(2));
        } else if (MyProject.activeUser.get(0).isUserChooseRunner_BlueMario()) {
            runnerMario = new RunnerMario(100, 840);
            activeMario = runnerMario;
            this.add(runnerMario, Integer.valueOf(2));
        } else if (MyProject.activeUser.get(0).isUserChooseShooter_BlackMario()) {
            shooterMario = new ShooterMario(100, 840);
            activeMario = shooterMario;
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
        firstEnemyInSceneOne = new Bird(400, 300, 400, 1400);
        secondEnemyInSceneOne = new Spiny(500, 890);
        thirdEnemyInSceneOne = new Goompa(1300, 890);
        fourthEnemyInSceneOne = new Spiny(1400, 890);
        fifthEnemyInSceneOne = new Goompa(1500, 890);

        // Scene Two:
        slimeBlockInSceneTwo = new SlimeBlockInAir(2100, 700);
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
        firstEnemyInSceneTwo = new Turtle(2300, 890);
        secondEnemyInSceneTwo = new Goompa(2200, 890);
        thirdEnemyInSceneTwo = new Turtle(2450, 890);

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
        firstEnemyInSceneThree = new Bird(3200, 300, 3200, 4000);
        secondEnemyInSceneThree = new Spiny(3600, 890);
        thirdEnemyInSceneThree = new Goompa(4800, 890);
        fourthEnemyInSceneThree = new Goompa(4900, 890);
        fifthEnemyInSceneThree = new Goompa(5000, 890);
        sixthEnemyInSceneThree = new Spiny(5100, 890);

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
        itemsInThisSection.add(firstCoinOnGroundSceneOne);
        itemsInThisSection.add(secondCoinOnGroundSceneOne);
        itemsInThisSection.add(thirdCoinOnGroundSceneOne);
        objectsInThisSection.add(firstBlockInAirSceneOne);
        itemsInThisSection.add(coinOnFirstBlockInAirSceneOne);
        objectsInThisSection.add(secondBlockInAirSceneOne);
        objectsInThisSection.add(firstPrizeInAirSceneOne);
        objectsInThisSection.add(thirdBlockInAirSceneOne);
        objectsInThisSection.add(fourthBlockInAirSceneOne);
        itemsInThisSection.add(coinOnFourthBlockInAirSceneOne);
        enemiesInThisSection.add(firstEnemyInSceneOne);
        enemiesInThisSection.add(secondEnemyInSceneOne);
        enemiesInThisSection.add(thirdEnemyInSceneOne);
        enemiesInThisSection.add(fourthEnemyInSceneOne);
        enemiesInThisSection.add(fifthEnemyInSceneOne);

        // Scene Two:
        objectsInThisSection.add(slimeBlockInSceneTwo);
        itemsInThisSection.add(firstCoinOnGroundSceneTwo);
        objectsInThisSection.add(firstBlockInAirSceneTwo);
        itemsInThisSection.add(coinOnFirstBlockInAirSceneTwo);
        objectsInThisSection.add(secondBlockInAirSceneTwo);
        itemsInThisSection.add(coinOnSecondBlockInAirSceneTwo);
        objectsInThisSection.add(thirdBlockInAirSceneTwo);
        itemsInThisSection.add(coinOnThirdBlockInAirSceneTwo);
        objectsInThisSection.add(fourthBlockInAirSceneTwo);
        itemsInThisSection.add(coinOnFourthBlockInAirSceneTwo);
        objectsInThisSection.add(firstPrizeInAirSceneTwo);
        emptySpaceInGroundsInThisSection.add(firstEmptySpaceInGroundSceneTwo);
        enemiesInThisSection.add(firstEnemyInSceneTwo);
        enemiesInThisSection.add(secondEnemyInSceneTwo);
        enemiesInThisSection.add(thirdEnemyInSceneTwo);

        // Scene Three:
        itemsInThisSection.add(firstCoinOnGroundSceneThree);
        itemsInThisSection.add(secondCoinOnGroundSceneThree);
        itemsInThisSection.add(thirdCoinOnGroundSceneThree);
        objectsInThisSection.add(firstPrizeInAirSceneThree);
        objectsInThisSection.add(secondPrizeInAirSceneThree);
        objectsInThisSection.add(firstPipeSceneThree);
        objectsInThisSection.add(secondPipeSceneThree);
        enemiesInThisSection.add(plantInSecondPipeSceneThree);
        itemsInThisSection.add(fourthCoinOnGroundSceneThree);
        enemiesInThisSection.add(firstEnemyInSceneThree);
        enemiesInThisSection.add(secondEnemyInSceneThree);
        enemiesInThisSection.add(thirdEnemyInSceneThree);
        enemiesInThisSection.add(fourthEnemyInSceneThree);
        enemiesInThisSection.add(fifthEnemyInSceneThree);
        enemiesInThisSection.add(sixthEnemyInSceneThree);

        // Scene Four:
        objectsInThisSection.add(castle);

        // Add To Screen:

        for (ObjectsInGame object : objectsInThisSection) {
            this.add(object, Integer.valueOf(1));
        }

        for (Enemy enemy : enemiesInThisSection) {
            this.add(enemy, Integer.valueOf(1));
        }

        for (ItemsInGame item : itemsInThisSection) {
            this.add(item, Integer.valueOf(1));
        }

        for (EmptySpaceInGround emptySpaceInGround : emptySpaceInGroundsInThisSection) {
            this.add(emptySpaceInGround, Integer.valueOf(1));
        }

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

    public ArrayList<MarioWeapon> getWeaponsInThisSection() {
        return weaponsInThisSection;
    }

    public void setWeaponsInThisSection(ArrayList<MarioWeapon> weaponsInThisSection) {
        this.weaponsInThisSection = weaponsInThisSection;
    }

    public GameData getGameData() {
        return gameData;
    }

}




