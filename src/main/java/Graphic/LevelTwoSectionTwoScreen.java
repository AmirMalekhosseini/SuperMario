package Graphic;

import Model.*;
import MyProject.MyProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LevelTwoSectionTwoScreen extends LevelScreens {

    protected ArrayList<ObjectsInGame> objectsInThisSection = new ArrayList<>();
    public ArrayList<ItemsInGame> itemsInThisSection = new ArrayList<>();
    protected ArrayList<Enemy> enemiesInThisSection = new ArrayList<>();
    protected ArrayList<BirdBomb> bombsInThisSection = new ArrayList<>();
    protected ArrayList<MarioWeapon> weaponsInThisSection = new ArrayList<>();
    protected ArrayList<EmptySpaceInGround> emptySpaceInGroundsInThisSection = new ArrayList<>();

    GameData gameData;
    public JLabel backgroundLabelSceneOne;
    public JLabel backgroundLabelSceneTwo;
    public JLabel backgroundLabelSceneThree;
    public JLabel backgroundLabelSceneFour;

    BlockInAir firstBlockInAirSceneOne;
    Coin coinOnFirstBlockInAirSceneOne;
    BlockInAir secondBlockInAirSceneOne;
    ItemsInGame itemOnSecondBlockInAirSceneOne;
    BlockInAir thirdBlockInAirSceneOne;
    BlockInAir fourthBlockInAirSceneOne;
    ItemsInGame itemOnFourthBlockInAirSceneOne;
    BlockInAir fifthBlockInAirSceneOne;
    BlockInAir sixthBlockInAirSceneOne;
    Coin coinOnSixthBlockInAirSceneOne;
    BlockInAir seventhBlockInAirSceneOne;
    BlockInAir eighthBlockInAirSceneOne;
    ItemsInGame itemOnEighthBlockInAirSceneOne;
    Coin firstCoinOnGroundSceneOne;
    Coin secondCoinOnGroundSceneOne;
    Coin thirdCoinOnGroundSceneOne;
    Coin fourthCoinOnGroundSceneOne;
    Enemy firstEnemyInSceneOne;
    Enemy secondEnemyInSceneOne;
    Enemy thirdEnemyInSceneOne;
    Enemy fourthEnemyInSceneOne;
    Enemy fifthEnemyInSceneOne;

    BlockInAir firstBlockInAirSceneTwo;
    Coin coinOnFirstBlockInAirSceneTwo;
    BlockInAir secondBlockInAirSceneTwo;
    ItemsInGame itemOnSecondBlockInAirSceneTwo;
    BlockInAir thirdBlockInAirSceneTwo;
    BlockInAir fourthBlockInAirSceneTwo;
    PrizeInAir firstPrizeInAirSceneTwo;
    Pipe firstPipeInSceneTwo;
    Plant plantOnFirstPipeSceneTwo;
    Coin firstCoinOnGroundSceneTwo;
    Coin secondCoinOnGroundSceneTwo;
    Enemy firstEnemyInSceneTwo;
    Enemy secondEnemyInSceneTwo;
    Enemy thirdEnemyInSceneTwo;
    Enemy fourthEnemyInSceneTwo;

    BlockInAir firstBlockInAirSceneThree;
    BlockInAir secondBlockInAirSceneThree;
    BlockInAir thirdBlockInAirSceneThree;
    BlockInAir fourthBlockInAirSceneThree;
    EmptySpaceInGround firstEmptySpaceInSceneThree;
    PrizeInAir firstPrizeInAirSceneThree;
    Coin firstCoinOnGroundSceneThree;
    Coin secondCoinOnGroundSceneThree;
    Coin thirdCoinOnGroundSceneThree;
    Enemy firstEnemyInSceneThree;
    Enemy secondEnemyInSceneThree;
    Enemy thirdEnemyInSceneThree;
    Enemy fourthEnemyInSceneThree;
    Enemy fifthEnemyInSceneThree;
    Enemy sixthEnemyInSceneThree;
    Enemy seventhEnemyInSceneThree;

    BlockInAir firstBlockInAirSceneFour;
    BlockInAir secondBlockInAirSceneFour;
    Coin coinOnSecondBlockInAirSceneFour;
    BlockInAir thirdBlockInAirSceneFour;
    Castle castle;
    PipeHorizontal pipeHorizontalSceneFour;

    NormalMario normalMario;
    CoinMario coinMario;
    JumperMario jumperMario;
    RunnerMario runnerMario;
    ShooterMario shooterMario;


    LevelTwoSectionTwoScreen(GameData gameData) {
        init(gameData);
    }

    public void init(GameData gameData) {

        this.gameData = gameData;
        ImageIcon backgroundImage = new ImageIcon("BackgroundSections.jpg");
        Font font1 = MyProjectData.getProjectData().getFont22();
        activeMario = new ArrayList<>();
        activeMario.add(new NormalMario(0, 0));
        this.thisSectionTime = new LevelTwoSectionTwoTime(this);

        this.setSize(6800, 1100);
        this.setLocation(6800, 0);
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

        // Scene One:
        firstBlockInAirSceneOne = new SimpleBlockInAir(550, 600);
        coinOnFirstBlockInAirSceneOne = new Coin(550, 550);
        secondBlockInAirSceneOne = new FullOfCoinBlockInAir(620, 600);
        thirdBlockInAirSceneOne = new FullOfCoinBlockInAir(690, 600);
        fourthBlockInAirSceneOne = new SimpleBlockInAir(760, 600);
        fifthBlockInAirSceneOne = new SimpleBlockInAir(1000, 750);
        sixthBlockInAirSceneOne = new EmptyBlockInAir(1070, 750);
        coinOnSixthBlockInAirSceneOne = new Coin(1070, 700);
        seventhBlockInAirSceneOne = new EmptyBlockInAir(1140, 750);
        eighthBlockInAirSceneOne = new SimpleBlockInAir(1210, 750);
        firstCoinOnGroundSceneOne = new Coin(1400, 890);
        secondCoinOnGroundSceneOne = new Coin(1480, 890);
        thirdCoinOnGroundSceneOne = new Coin(1560, 890);
        fourthCoinOnGroundSceneOne = new Coin(1640, 890);
        firstEnemyInSceneOne = new Bird(800, 300, 800, 1800);
        secondEnemyInSceneOne = new Spiny(1600, 890);
        thirdEnemyInSceneOne = new Goompa(1300, 890);
        fourthEnemyInSceneOne = new Goompa(1400, 890);
        fifthEnemyInSceneOne = new Goompa(1500, 890);

        // Scene Two:
        firstBlockInAirSceneTwo = new SimpleBlockInAir(2320, 700);
        coinOnFirstBlockInAirSceneTwo = new Coin(2320, 650);
        secondBlockInAirSceneTwo = new EmptyBlockInAir(2390, 700);
        thirdBlockInAirSceneTwo = new EmptyBlockInAir(2460, 700);
        fourthBlockInAirSceneTwo = new OneCoinBlockInAir(2530, 700);
        firstPrizeInAirSceneTwo = new PrizeInAir(2900, 520);
        firstPipeInSceneTwo = new Pipe(2880, 765);
        plantOnFirstPipeSceneTwo = new Plant(2905, 750);
        firstCoinOnGroundSceneTwo = new Coin(3270, 890);
        secondCoinOnGroundSceneTwo = new Coin(3350, 890);
        firstEnemyInSceneTwo = new Goompa(2300, 890);
        secondEnemyInSceneTwo = new Goompa(2200, 890);
        thirdEnemyInSceneTwo = new Turtle(2450, 890);
        fourthEnemyInSceneTwo = new Bird(2700, 300,2700,3000);

        // Scene Three:
        firstBlockInAirSceneThree = new SimpleBlockInAir(4020, 700);
        secondBlockInAirSceneThree = new EmptyBlockInAir(4090, 700);
        thirdBlockInAirSceneThree = new EmptyBlockInAir(4160, 700);
        fourthBlockInAirSceneThree = new OneCoinBlockInAir(4230, 700);
        firstEmptySpaceInSceneThree = new EmptySpaceInGround(4100, 945);
        firstPrizeInAirSceneThree = new PrizeInAir(4170, 420);
        firstCoinOnGroundSceneThree = new Coin(5000, 890);
        secondCoinOnGroundSceneThree = new Coin(5080, 890);
        thirdCoinOnGroundSceneThree = new Coin(5160, 890);
        firstEmptySpaceInSceneThree.setOpaque(true);
        firstEnemyInSceneThree = new Goompa(3200, 890);
        secondEnemyInSceneThree = new Spiny(3600, 890);
        thirdEnemyInSceneThree = new Goompa(4300, 890);
        fourthEnemyInSceneThree = new Goompa(4400, 890);
        fifthEnemyInSceneThree = new Goompa(4500, 890);
        sixthEnemyInSceneThree = new Spiny(3800, 890);
        seventhEnemyInSceneThree = new Spiny(3400, 890);

        // Scene Four:
        firstBlockInAirSceneFour = new EmptyBlockInAir(5400, 700);
        secondBlockInAirSceneFour = new EmptyBlockInAir(5470, 700);
        coinOnSecondBlockInAirSceneFour = new Coin(5470, 650);
        thirdBlockInAirSceneFour = new EmptyBlockInAir(5540, 700);
        pipeHorizontalSceneFour = new PipeHorizontal(5880, 820);
        castle = new Castle(6200, 490);

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
        this.add(thirdBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(thirdBlockInAirSceneOne);
        this.add(fourthBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(fourthBlockInAirSceneOne);
        this.add(fifthBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(fifthBlockInAirSceneOne);
        this.add(sixthBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(sixthBlockInAirSceneOne);
        this.add(coinOnSixthBlockInAirSceneOne, Integer.valueOf(1));
        itemsInThisSection.add(coinOnSixthBlockInAirSceneOne);
        this.add(seventhBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(seventhBlockInAirSceneOne);
        this.add(eighthBlockInAirSceneOne, Integer.valueOf(1));
        objectsInThisSection.add(eighthBlockInAirSceneOne);
        this.add(firstCoinOnGroundSceneOne, Integer.valueOf(1));
        itemsInThisSection.add(firstCoinOnGroundSceneOne);
        this.add(secondCoinOnGroundSceneOne, Integer.valueOf(1));
        itemsInThisSection.add(secondCoinOnGroundSceneOne);
        this.add(thirdCoinOnGroundSceneOne, Integer.valueOf(1));
        itemsInThisSection.add(thirdCoinOnGroundSceneOne);
        this.add(fourthCoinOnGroundSceneOne, Integer.valueOf(1));
        itemsInThisSection.add(fourthCoinOnGroundSceneOne);
        this.add(firstEnemyInSceneOne, Integer.valueOf(1));
        enemiesInThisSection.add(firstEnemyInSceneOne);
        this.add(secondEnemyInSceneOne, Integer.valueOf(1));
        enemiesInThisSection.add(secondEnemyInSceneOne);
        this.add(thirdEnemyInSceneOne, Integer.valueOf(1));
        enemiesInThisSection.add(thirdEnemyInSceneOne);
        this.add(fourthEnemyInSceneOne, Integer.valueOf(1));
        enemiesInThisSection.add(fourthEnemyInSceneOne);
        this.add(fifthEnemyInSceneOne, Integer.valueOf(1));
        enemiesInThisSection.add(fifthEnemyInSceneOne);

        // Scene Two:
        this.add(firstBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(firstBlockInAirSceneTwo);
        this.add(coinOnFirstBlockInAirSceneTwo, Integer.valueOf(1));
        itemsInThisSection.add(coinOnFirstBlockInAirSceneTwo);
        this.add(secondBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(secondBlockInAirSceneTwo);
        this.add(thirdBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(thirdBlockInAirSceneTwo);
        this.add(fourthBlockInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(fourthBlockInAirSceneTwo);
        this.add(firstPrizeInAirSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(firstPrizeInAirSceneTwo);
        this.add(firstPipeInSceneTwo, Integer.valueOf(1));
        objectsInThisSection.add(firstPipeInSceneTwo);
        this.add(plantOnFirstPipeSceneTwo, Integer.valueOf(1));
        enemiesInThisSection.add(plantOnFirstPipeSceneTwo);
        this.add(firstCoinOnGroundSceneTwo, Integer.valueOf(1));
        itemsInThisSection.add(firstCoinOnGroundSceneTwo);
        this.add(secondCoinOnGroundSceneTwo, Integer.valueOf(1));
        itemsInThisSection.add(secondCoinOnGroundSceneTwo);
        this.add(firstEnemyInSceneTwo, Integer.valueOf(1));
        enemiesInThisSection.add(firstEnemyInSceneTwo);
        this.add(secondEnemyInSceneTwo, Integer.valueOf(1));
        enemiesInThisSection.add(secondEnemyInSceneTwo);
        this.add(thirdEnemyInSceneTwo, Integer.valueOf(1));
        enemiesInThisSection.add(thirdEnemyInSceneTwo);
        this.add(fourthEnemyInSceneTwo, Integer.valueOf(1));
        enemiesInThisSection.add(fourthEnemyInSceneTwo);

        // Scene Three:
        this.add(firstBlockInAirSceneThree, Integer.valueOf(1));
        objectsInThisSection.add(firstBlockInAirSceneThree);
        this.add(secondBlockInAirSceneThree, Integer.valueOf(1));
        objectsInThisSection.add(secondBlockInAirSceneThree);
        this.add(thirdBlockInAirSceneThree, Integer.valueOf(1));
        objectsInThisSection.add(thirdBlockInAirSceneThree);
        this.add(fourthBlockInAirSceneThree, Integer.valueOf(1));
        objectsInThisSection.add(fourthBlockInAirSceneThree);
        this.add(firstEmptySpaceInSceneThree, Integer.valueOf(1));
        emptySpaceInGroundsInThisSection.add(firstEmptySpaceInSceneThree);
        this.add(firstPrizeInAirSceneThree, Integer.valueOf(1));
        objectsInThisSection.add(firstPrizeInAirSceneThree);
        this.add(firstCoinOnGroundSceneThree, Integer.valueOf(1));
        itemsInThisSection.add(firstCoinOnGroundSceneThree);
        this.add(secondCoinOnGroundSceneThree, Integer.valueOf(1));
        itemsInThisSection.add(secondCoinOnGroundSceneThree);
        this.add(thirdCoinOnGroundSceneThree, Integer.valueOf(1));
        itemsInThisSection.add(thirdCoinOnGroundSceneThree);
        this.add(firstEnemyInSceneThree, Integer.valueOf(1));
        enemiesInThisSection.add(firstEnemyInSceneThree);
        this.add(secondEnemyInSceneThree, Integer.valueOf(1));
        enemiesInThisSection.add(secondEnemyInSceneThree);
        this.add(thirdEnemyInSceneThree, Integer.valueOf(1));
        enemiesInThisSection.add(thirdEnemyInSceneThree);
        this.add(fourthEnemyInSceneThree, Integer.valueOf(1));
        enemiesInThisSection.add(fourthEnemyInSceneThree);
        this.add(fifthEnemyInSceneThree, Integer.valueOf(1));
        enemiesInThisSection.add(fifthEnemyInSceneThree);
        this.add(sixthEnemyInSceneThree, Integer.valueOf(1));
        enemiesInThisSection.add(sixthEnemyInSceneThree);
        this.add(seventhEnemyInSceneThree, Integer.valueOf(1));
        enemiesInThisSection.add(seventhEnemyInSceneThree);

        // Scene Four:
        this.add(firstBlockInAirSceneFour, Integer.valueOf(1));
        objectsInThisSection.add(firstBlockInAirSceneFour);
        this.add(secondBlockInAirSceneFour, Integer.valueOf(1));
        objectsInThisSection.add(secondBlockInAirSceneFour);
        this.add(coinOnSecondBlockInAirSceneFour, Integer.valueOf(1));
        itemsInThisSection.add(coinOnSecondBlockInAirSceneFour);
        this.add(thirdBlockInAirSceneFour, Integer.valueOf(1));
        objectsInThisSection.add(thirdBlockInAirSceneFour);
        this.add(pipeHorizontalSceneFour, Integer.valueOf(1));
        objectsInThisSection.add(pipeHorizontalSceneFour);
        this.add(castle, Integer.valueOf(1));


    }

    public GameData getGameData() {
        return gameData;
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

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }
}
