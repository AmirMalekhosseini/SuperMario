package Graphic;

import Model.*;
import MyProject.MyProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LevelTwoSectionOneScreen extends LevelScreens {

    protected ArrayList<ObjectsInGame> objectsInThisSection = new ArrayList<>();
    public ArrayList<ItemsInGame> itemsInThisSection = new ArrayList<>();
    protected ArrayList<Enemy> enemiesInThisSection = new ArrayList<>();
    protected ArrayList<Bomb> bombsInThisSection = new ArrayList<>();
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
    BlockInAir eightBlockInAirSceneOne;
    Coin coinOnEightBlockInAirSceneOne;
    BlockInAir ninthBlockInAirSceneOne;
    BlockInAir tenthBlockInAirSceneOne;
    BlockInAir eleventhBlockInAirSceneOne;
    Coin coinOnEleventhBlockInAirSceneOne;
    BlockInAir twelveBlockInAirSceneOne;
    BlockInAir thirteenthBlockInAirSceneOne;
    Enemy firstEnemyInSceneOne;
    Enemy secondEnemyInSceneOne;
    Enemy thirdEnemyInSceneOne;
    Enemy fourthEnemyInSceneOne;
    Enemy fifthEnemyInSceneOne;

    BlockInAir firstBlockInAirSceneTwo;
    BlockInAir secondBlockInAirSceneTwo;
    BlockInAir thirdBlockInAirSceneTwo;
    BlockInAir fourthBlockInAirSceneTwo;
    PrizeInAir firstPrizeInAirSceneTwo;
    EmptySpaceInGround firstEmptySpaceInGroundSceneTwo;
    BlockInAir fifthBlockInAirSceneTwo;
    Coin coinOnFifthBlockInAirSceneTwo;
    BlockInAir sixthBlockInAirSceneTwo;
    BlockInAir seventhBlockInAirSceneTwo;
    Coin coinOnSeventhBlockInAirSceneTwo;
    PrizeInAir secondPrizeInAirSceneTwo;
    Enemy firstEnemyInSceneTwo;
    Enemy secondEnemyInSceneTwo;
    Enemy thirdEnemyInSceneTwo;

    BlockInAir slimeBlockInAirSceneThree;
    BlockInAir firstBlockInAirSceneThree;
    Coin coinOnFirstBlockInAirSceneThree;
    BlockInAir secondBlockInAirSceneThree;
    BlockInAir thirdBlockInAirSceneThree;
    PrizeInAir firstPrizeInAirSceneThree;
    PrizeInAir secondPrizeInAirSceneThree;
    Coin firstCoinOnGroundSceneThree;
    Coin secondCoinOnGroundSceneThree;
    Coin thirdCoinOnGroundSceneThree;
    Pipe firstPipeSceneThree;
    Plant plantInFirstPipeSceneThree;
    Pipe secondPipeSceneThree;
    Enemy firstEnemyInSceneThree;
    Enemy secondEnemyInSceneThree;
    Enemy thirdEnemyInSceneThree;
    Enemy fourthEnemyInSceneThree;
    Enemy fifthEnemyInSceneThree;

    PipeHorizontal pipeHorizontalSceneFour;
    Castle castle;
    NormalMario normalMario;
    CoinMario coinMario;
    JumperMario jumperMario;
    RunnerMario runnerMario;
    ShooterMario shooterMario;

    LevelTwoSectionOneScreen(GameData gameData) {
        init(gameData);
    }

    public LevelTwoSectionOneScreen() {

    }

    public void init(GameData gameData) {

        this.gameData = gameData;
        ImageIcon backgroundImage = new ImageIcon("BackgroundSections.jpg");
        activeMario = new NormalMario(0, 0);
        Font font1 = MyProjectData.getProjectData().getFont22();

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

        thisSectionTimeLabel = new JLabel("Time: ");
        thisSectionTimeLabel.setBounds(XThisSectionTimeLabel, 30, 200, 20);
        thisSectionTimeLabel.setFont(font1);

        thisGameCoin = new JLabel();
        thisGameCoin.setBounds(XThisGameCoin, 25, 200, 30);
        thisGameCoin.setFont(font1);
        thisGameCoinImage = new CoinForStore(XThisGameCoinImage, 30);
        thisGameCoinImage.setLocation(thisGameCoinImage.getX(), thisGameCoinImage.getY());

        marioLocationLabel = new JLabel("WORLD: 2 _ 1");
        marioLocationLabel.setFont(font1);
        marioLocationLabel.setBounds(XMarioLocationLabel, 25, 200, 30);

//        Add Mario:
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
        eightBlockInAirSceneOne = new SimpleBlockInAir(750, 500);
        coinOnEightBlockInAirSceneOne = new Coin(750, 450);
        ninthBlockInAirSceneOne = new EmptyBlockInAir(820, 500);
        tenthBlockInAirSceneOne = new OneCoinBlockInAir(890, 500);
        eleventhBlockInAirSceneOne = new FullOfCoinBlockInAir(1150, 350);
        coinOnEleventhBlockInAirSceneOne = new Coin(1150, 300);
        twelveBlockInAirSceneOne = new SimpleBlockInAir(1220, 350);
        thirteenthBlockInAirSceneOne = new SimpleBlockInAir(1290, 350);
        firstEnemyInSceneOne = new Turtle(1290, 270);
        secondEnemyInSceneOne = new Goompa(500, 890);
        thirdEnemyInSceneOne = new Goompa(1100, 890);
        fourthEnemyInSceneOne = new Goompa(1400, 890);
        fifthEnemyInSceneOne = new Spiny(1500, 890);

        // Scene Two
        firstBlockInAirSceneTwo = new SimpleBlockInAir(2100, 700);
        secondBlockInAirSceneTwo = new EmptyBlockInAir(2170, 700);
        thirdBlockInAirSceneTwo = new EmptyBlockInAir(2240, 700);
        fourthBlockInAirSceneTwo = new OneCoinBlockInAir(2310, 700);
        firstPrizeInAirSceneTwo = new PrizeInAir(2180, 420);
        firstEmptySpaceInGroundSceneTwo = new EmptySpaceInGround(2550, 945);
        fifthBlockInAirSceneTwo = new SimpleBlockInAir(2500, 600);
        coinOnFifthBlockInAirSceneTwo = new Coin(2500, 550);
        sixthBlockInAirSceneTwo = new EmptyBlockInAir(2570, 600);
        seventhBlockInAirSceneTwo = new FullOfCoinBlockInAir(2640, 600);
        coinOnSeventhBlockInAirSceneTwo = new Coin(2640, 550);
        secondPrizeInAirSceneTwo = new PrizeInAir(2800, 420);
        firstEnemyInSceneTwo = new Goompa(2300, 890);
        secondEnemyInSceneTwo = new Goompa(2200, 890);
        thirdEnemyInSceneTwo = new Turtle(2450, 890);

        // Scene Three
        slimeBlockInAirSceneThree = new SlimeBlockInAir(3400, 700);
        firstBlockInAirSceneThree = new FullOfCoinBlockInAir(3700, 500);
        coinOnFirstBlockInAirSceneThree = new Coin(3700, 450);
        secondBlockInAirSceneThree = new EmptyBlockInAir(3770, 500);
        thirdBlockInAirSceneThree = new SimpleBlockInAir(3840, 500);
        firstPrizeInAirSceneThree = new PrizeInAir(4300, 500);
        secondPrizeInAirSceneThree = new PrizeInAir(4700, 500);
        firstCoinOnGroundSceneThree = new Coin(4400, 890);
        secondCoinOnGroundSceneThree = new Coin(4480, 890);
        thirdCoinOnGroundSceneThree = new Coin(4480, 890);
        firstPipeSceneThree = new Pipe(4100, 765);
        plantInFirstPipeSceneThree = new Plant(4125, 750);
        secondPipeSceneThree = new Pipe(4800, 765);
        firstEnemyInSceneThree = new Bird(3200, 300, 3200, 4000);
        secondEnemyInSceneThree = new Spiny(3600, 890);
        thirdEnemyInSceneThree = new Goompa(4300, 890);
        fourthEnemyInSceneThree = new Goompa(4400, 890);
        fifthEnemyInSceneThree = new Goompa(4500, 890);

        // Scene Four
        pipeHorizontalSceneFour = new PipeHorizontal(5780, 820);
        castle = new Castle(6220, 490);

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
        this.add(marioLocationLabel, Integer.valueOf(1));

        // Scene One:
        objectsInThisSection.add(firstBlockInAirSceneOne);
        itemsInThisSection.add(coinOnFirstBlockInAirSceneOne);
        objectsInThisSection.add(secondBlockInAirSceneOne);
        objectsInThisSection.add(firstPrizeInAirSceneOne);
        objectsInThisSection.add(thirdBlockInAirSceneOne);
        itemsInThisSection.add(coinOnThirdBlockInAirSceneOne);
        objectsInThisSection.add(fourthBlockInAirSceneOne);
        itemsInThisSection.add(firstCoinOnGroundSceneOne);
        itemsInThisSection.add(secondCoinOnGroundSceneOne);
        itemsInThisSection.add(thirdCoinOnGroundSceneOne);
        objectsInThisSection.add(fifthBlockInAirSceneOne);
        objectsInThisSection.add(secondPrizeInAirSceneOne);
        objectsInThisSection.add(sixthBlockInAirSceneOne);
        itemsInThisSection.add(coinOnSixthBlockInAirSceneOne);
        objectsInThisSection.add(seventhBlockInAirSceneOne);
        itemsInThisSection.add(fourthCoinOnGroundSceneOne);
        itemsInThisSection.add(fifthCoinOnGroundSceneOne);
        objectsInThisSection.add(eightBlockInAirSceneOne);
        itemsInThisSection.add(coinOnEightBlockInAirSceneOne);
        objectsInThisSection.add(ninthBlockInAirSceneOne);
        objectsInThisSection.add(tenthBlockInAirSceneOne);
        objectsInThisSection.add(eleventhBlockInAirSceneOne);
        itemsInThisSection.add(coinOnEleventhBlockInAirSceneOne);
        objectsInThisSection.add(twelveBlockInAirSceneOne);
        objectsInThisSection.add(thirteenthBlockInAirSceneOne);
        enemiesInThisSection.add(firstEnemyInSceneOne);
        enemiesInThisSection.add(secondEnemyInSceneOne);
        enemiesInThisSection.add(thirdEnemyInSceneOne);
        enemiesInThisSection.add(fourthEnemyInSceneOne);
        enemiesInThisSection.add(fifthEnemyInSceneOne);

        // Scene Two:
        objectsInThisSection.add(firstBlockInAirSceneTwo);
        objectsInThisSection.add(secondBlockInAirSceneTwo);
        objectsInThisSection.add(thirdBlockInAirSceneTwo);
        objectsInThisSection.add(fourthBlockInAirSceneTwo);
        objectsInThisSection.add(firstPrizeInAirSceneTwo);
        emptySpaceInGroundsInThisSection.add(firstEmptySpaceInGroundSceneTwo);
        objectsInThisSection.add(fifthBlockInAirSceneTwo);
        itemsInThisSection.add(coinOnFifthBlockInAirSceneTwo);
        objectsInThisSection.add(sixthBlockInAirSceneTwo);
        objectsInThisSection.add(seventhBlockInAirSceneTwo);
        itemsInThisSection.add(coinOnSeventhBlockInAirSceneTwo);
        objectsInThisSection.add(secondPrizeInAirSceneTwo);
        enemiesInThisSection.add(firstEnemyInSceneTwo);
        enemiesInThisSection.add(secondEnemyInSceneTwo);
        enemiesInThisSection.add(thirdEnemyInSceneTwo);

        // Scene Three:
        objectsInThisSection.add(slimeBlockInAirSceneThree);
        objectsInThisSection.add(firstBlockInAirSceneThree);
        itemsInThisSection.add(coinOnFirstBlockInAirSceneThree);
        objectsInThisSection.add(secondBlockInAirSceneThree);
        objectsInThisSection.add(thirdBlockInAirSceneThree);
        objectsInThisSection.add(firstPrizeInAirSceneThree);
        objectsInThisSection.add(secondPrizeInAirSceneThree);
        objectsInThisSection.add(firstPipeSceneThree);
        enemiesInThisSection.add(plantInFirstPipeSceneThree);
        itemsInThisSection.add(firstCoinOnGroundSceneThree);
        itemsInThisSection.add(secondCoinOnGroundSceneThree);
        itemsInThisSection.add(thirdCoinOnGroundSceneThree);
        objectsInThisSection.add(secondPipeSceneThree);
        enemiesInThisSection.add(firstEnemyInSceneThree);
        enemiesInThisSection.add(secondEnemyInSceneThree);
        enemiesInThisSection.add(thirdEnemyInSceneThree);
        enemiesInThisSection.add(fourthEnemyInSceneThree);
        enemiesInThisSection.add(fifthEnemyInSceneThree);

        // Scene Four:
        this.add(castle, Integer.valueOf(1));
        objectsInThisSection.add(pipeHorizontalSceneFour);

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
    public ArrayList<Bomb> getBombsInThisSection() {
        return bombsInThisSection;
    }

    public void setBombsInThisSection(ArrayList<Bomb> bombsInThisSection) {
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
