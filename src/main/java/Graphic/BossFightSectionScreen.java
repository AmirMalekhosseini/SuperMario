package Graphic;

import Graphic.Vilgax.Vilgax;
import Graphic.Vilgax.VilgaxWeapon;
import Model.*;
import MyProject.MyProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BossFightSectionScreen extends LevelScreens {

    protected ArrayList<ObjectsInGame> objectsInThisSection = new ArrayList<>();
    protected ArrayList<BlockInAir> wall_BlockInAir = new ArrayList<>();
    protected ArrayList<ItemsInGame> itemsInThisSection = new ArrayList<>();
    protected ArrayList<Bomb> bombsInThisSection = new ArrayList<>();
    protected volatile ArrayList<Enemy> enemiesInThisSection = new ArrayList<>();
    protected volatile ArrayList<MarioWeapon> weaponsInThisSection = new ArrayList<>();
    protected volatile ArrayList<VilgaxWeapon> vilgaxWeaponsInThisSection = new ArrayList<>();
    protected ArrayList<EmptySpaceInGround> emptySpaceInGroundsInThisSection = new ArrayList<>();
    GameData gameData;
    public JLabel backgroundLabelSceneOne;
    public JLabel backgroundLabelSceneTwo;
    public JLabel backgroundLabelSceneThree;
    public JLabel backgroundLabelSceneFour;

    public  JProgressBar healthBar;
    BlockInAir firstBlockInAirSceneBossFight;
    BlockInAir secondBlockInAirSceneBossFight;
    BlockInAir thirdBlockInAirSceneBossFight;
    BlockInAir fourthBlockInAirSceneBossFight;
    BlockInAir fifthBlockInAirSceneBossFight;
    BlockInAir sixthBlockInAirSceneBossFight;
    BlockInAir seventhBlockInAirSceneBossFight;
    BlockInAir eightBlockInAirSceneBossFight;
    PrizeInAir firstPrizeInAirSceneBossFight;
    PrizeInAir secondPrizeInAirSceneBossFight;
    PrizeInAir thirdPrizeInAirSceneBossFight;
    PrizeInAir fourthPrizeInAirSceneBossFight;
    PrizeInAir fifthPrizeInAirSceneBossFight;
    PrizeInAir sixthPrizeInAirSceneBossFight;
    PrizeInAir seventhPrizeInAirSceneBossFight;
    PrizeInAir eightPrizeInAirSceneBossFight;

    BlockInAir Left_Wall_1;
    BlockInAir Left_Wall_2;
    BlockInAir Left_Wall_3;
    BlockInAir Left_Wall_4;
    BlockInAir Left_Wall_5;
    BlockInAir Left_Wall_6;
    BlockInAir Left_Wall_7;
    BlockInAir Left_Wall_8;
    BlockInAir Left_Wall_9;
    BlockInAir Left_Wall_10;
    BlockInAir Left_Wall_11;
    BlockInAir Left_Wall_12;
    BlockInAir Left_Wall_13;
    BlockInAir Left_Wall_14;
    BlockInAir Left_Wall_15;
    BlockInAir Right_Wall_1;
    BlockInAir Right_Wall_2;
    BlockInAir Right_Wall_3;
    BlockInAir Right_Wall_4;
    BlockInAir Right_Wall_5;
    BlockInAir Right_Wall_6;
    BlockInAir Right_Wall_7;
    BlockInAir Right_Wall_8;
    BlockInAir Right_Wall_9;
    BlockInAir Right_Wall_10;
    BlockInAir Right_Wall_11;
    BlockInAir Right_Wall_12;
    BlockInAir Right_Wall_13;
    BlockInAir Right_Wall_14;
    BlockInAir Right_Wall_15;

    public Vilgax vilgax;
    NormalMario normalMario;
    CoinMario coinMario;
    JumperMario jumperMario;
    RunnerMario runnerMario;
    ShooterMario shooterMario;


    public BossFightSectionScreen(GameData gameData) {
        init(gameData);
        this.setScreenLock(true);
    }

    private void init(GameData gameData) {

        this.gameData = gameData;
        ImageIcon backgroundImage = new ImageIcon("BackgroundSections.jpg");
        activeMario = new NormalMario(0, 0);
        Font font1 = MyProjectData.getProjectData().getFont22();

        this.setSize(6800, 1100);
        this.setVisible(true);
        this.setLocation(-5100, 0);

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

        healthBar = new JProgressBar(0, 100);
        healthBar.setBounds(5500, 30, 800, 50);
        healthBar.setStringPainted(true);
        healthBar.setForeground(Color.red);
        healthBar.setValue(50);
        healthBar.setString(healthBar.getValue()+ " / 100");
        healthBar.setFont(MyProjectData.getProjectData().getFont22());

        vilgax = new Vilgax(6300, 620);
        this.add(vilgax, Integer.valueOf(2));

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
        this.add(healthBar, Integer.valueOf(1));

        addMario();
        addObject();

    }

    private void addMario() {

        if (MyProject.activeUser.get(0).isUserChooseNormal_RedMario()) {
            normalMario = new NormalMario(5200, 900);
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

    }

    private void addObject() {


        // Scene BossFight:
        Left_Wall_1 = new EmptyBlockInAir(5100, 890);
        Left_Wall_2 = new EmptyBlockInAir(5100, 825);
        Left_Wall_3 = new EmptyBlockInAir(5100, 760);
        Left_Wall_4 = new EmptyBlockInAir(5100, 695);
        Left_Wall_5 = new EmptyBlockInAir(5100, 630);
        Left_Wall_6 = new EmptyBlockInAir(5100, 565);
        Left_Wall_7 = new EmptyBlockInAir(5100, 500);
        Left_Wall_8 = new EmptyBlockInAir(5100, 435);
        Left_Wall_9 = new EmptyBlockInAir(5100, 370);
        Left_Wall_10 = new EmptyBlockInAir(5100, 305);
        Left_Wall_11 = new EmptyBlockInAir(5100, 240);
        Left_Wall_12 = new EmptyBlockInAir(5100, 175);
        Left_Wall_13 = new EmptyBlockInAir(5100, 110);
        Left_Wall_14 = new EmptyBlockInAir(5100, 45);
        Left_Wall_15 = new EmptyBlockInAir(5100, 0);

        Right_Wall_1 = new EmptyBlockInAir(6645, 890);
        Right_Wall_2 = new EmptyBlockInAir(6645, 825);
        Right_Wall_3 = new EmptyBlockInAir(6645, 760);
        Right_Wall_4 = new EmptyBlockInAir(6645, 695);
        Right_Wall_5 = new EmptyBlockInAir(6645, 630);
        Right_Wall_6 = new EmptyBlockInAir(6645, 565);
        Right_Wall_7 = new EmptyBlockInAir(6645, 500);
        Right_Wall_8 = new EmptyBlockInAir(6645, 435);
        Right_Wall_9 = new EmptyBlockInAir(6645, 370);
        Right_Wall_10 = new EmptyBlockInAir(6645, 305);
        Right_Wall_11 = new EmptyBlockInAir(6645, 240);
        Right_Wall_12 = new EmptyBlockInAir(6645, 175);
        Right_Wall_13 = new EmptyBlockInAir(6645, 110);
        Right_Wall_14 = new EmptyBlockInAir(6645, 45);
        Right_Wall_15 = new EmptyBlockInAir(6645, 0);

        firstBlockInAirSceneBossFight = new FullOfCoinBlockInAir(5500, 700);
        secondBlockInAirSceneBossFight = new SimpleBlockInAir(5570, 700);
        thirdBlockInAirSceneBossFight = new SimpleBlockInAir(5640, 700);
        fourthBlockInAirSceneBossFight = new OneCoinBlockInAir(5710, 700);
        fifthBlockInAirSceneBossFight = new SimpleBlockInAir(5900, 500);
        sixthBlockInAirSceneBossFight = new SimpleBlockInAir(5970, 500);
        seventhBlockInAirSceneBossFight = new SimpleBlockInAir(6040, 500);
        eightBlockInAirSceneBossFight = new SimpleBlockInAir(6110, 500);

        firstPrizeInAirSceneBossFight = new PrizeInAir(5170, 580);
        secondPrizeInAirSceneBossFight = new PrizeInAir(5240, 580);
        thirdPrizeInAirSceneBossFight = new PrizeInAir(5570, 400);
        fourthPrizeInAirSceneBossFight = new PrizeInAir(5640, 400);
        fifthPrizeInAirSceneBossFight = new PrizeInAir(5900, 200);
        sixthPrizeInAirSceneBossFight = new PrizeInAir(6100, 200);
        seventhPrizeInAirSceneBossFight = new PrizeInAir(6505, 580);
        eightPrizeInAirSceneBossFight = new PrizeInAir(6575, 580);

        // Add wall:
        wall_BlockInAir.add(Left_Wall_1);
        wall_BlockInAir.add(Left_Wall_2);
        wall_BlockInAir.add(Left_Wall_3);
        wall_BlockInAir.add(Left_Wall_4);
        wall_BlockInAir.add(Left_Wall_5);
        wall_BlockInAir.add(Left_Wall_6);
        wall_BlockInAir.add(Left_Wall_7);
        wall_BlockInAir.add(Left_Wall_8);
        wall_BlockInAir.add(Left_Wall_9);
        wall_BlockInAir.add(Left_Wall_10);
        wall_BlockInAir.add(Left_Wall_11);
        wall_BlockInAir.add(Left_Wall_12);
        wall_BlockInAir.add(Left_Wall_13);
        wall_BlockInAir.add(Left_Wall_14);
        wall_BlockInAir.add(Left_Wall_15);
        wall_BlockInAir.add(Right_Wall_1);
        wall_BlockInAir.add(Right_Wall_2);
        wall_BlockInAir.add(Right_Wall_3);
        wall_BlockInAir.add(Right_Wall_4);
        wall_BlockInAir.add(Right_Wall_5);
        wall_BlockInAir.add(Right_Wall_6);
        wall_BlockInAir.add(Right_Wall_7);
        wall_BlockInAir.add(Right_Wall_8);
        wall_BlockInAir.add(Right_Wall_9);
        wall_BlockInAir.add(Right_Wall_10);
        wall_BlockInAir.add(Right_Wall_11);
        wall_BlockInAir.add(Right_Wall_12);
        wall_BlockInAir.add(Right_Wall_13);
        wall_BlockInAir.add(Right_Wall_14);
        wall_BlockInAir.add(Right_Wall_15);

        for (BlockInAir block : wall_BlockInAir) {
            this.add(block, Integer.valueOf(1));
        }

        // Scene BossFight:
        objectsInThisSection.add(firstBlockInAirSceneBossFight);
        objectsInThisSection.add(secondBlockInAirSceneBossFight);
        objectsInThisSection.add(thirdBlockInAirSceneBossFight);
        objectsInThisSection.add(fourthBlockInAirSceneBossFight);
        objectsInThisSection.add(fifthBlockInAirSceneBossFight);
        objectsInThisSection.add(sixthBlockInAirSceneBossFight);
        objectsInThisSection.add(seventhBlockInAirSceneBossFight);
        objectsInThisSection.add(eightBlockInAirSceneBossFight);

        objectsInThisSection.add(firstPrizeInAirSceneBossFight);
        objectsInThisSection.add(secondPrizeInAirSceneBossFight);
        objectsInThisSection.add(thirdPrizeInAirSceneBossFight);
        objectsInThisSection.add(fourthPrizeInAirSceneBossFight);
        objectsInThisSection.add(fifthPrizeInAirSceneBossFight);
        objectsInThisSection.add(sixthPrizeInAirSceneBossFight);
        objectsInThisSection.add(seventhPrizeInAirSceneBossFight);
        objectsInThisSection.add(eightPrizeInAirSceneBossFight);

        for (ObjectsInGame object : objectsInThisSection) {
            this.add(object, Integer.valueOf(1));
        }

    }


    @Override
    public ArrayList<ObjectsInGame> getObjectsInThisSection() {
        return objectsInThisSection;
    }

    public void setObjectsInThisSection(ArrayList<ObjectsInGame> objectsInThisSection) {
        this.objectsInThisSection = objectsInThisSection;
    }

    public ArrayList<BlockInAir> getWall_BlockInAir() {
        return wall_BlockInAir;
    }

    public void setWall_BlockInAir(ArrayList<BlockInAir> wall_BlockInAir) {
        this.wall_BlockInAir = wall_BlockInAir;
    }

    @Override
    public ArrayList<ItemsInGame> getItemsInThisSection() {
        return itemsInThisSection;
    }

    public void setItemsInThisSection(ArrayList<ItemsInGame> itemsInThisSection) {
        this.itemsInThisSection = itemsInThisSection;
    }

    @Override
    public ArrayList<MarioWeapon> getWeaponsInThisSection() {
        return weaponsInThisSection;
    }

    public void setWeaponsInThisSection(ArrayList<MarioWeapon> weaponsInThisSection) {
        this.weaponsInThisSection = weaponsInThisSection;
    }

    public ArrayList<VilgaxWeapon> getVilgaxWeaponsInThisSection() {
        return vilgaxWeaponsInThisSection;
    }

    public void setVilgaxWeaponsInThisSection(ArrayList<VilgaxWeapon> vilgaxWeaponsInThisSection) {
        this.vilgaxWeaponsInThisSection = vilgaxWeaponsInThisSection;
    }

    @Override
    public ArrayList<Bomb> getBombsInThisSection() {
        return bombsInThisSection;
    }

    public void setBombsInThisSection(ArrayList<Bomb> bombsInThisSection) {
        this.bombsInThisSection = bombsInThisSection;
    }

    @Override
    public ArrayList<Enemy> getEnemiesInThisSection() {
        return enemiesInThisSection;
    }

    public void setEnemiesInThisSection(ArrayList<Enemy> enemiesInThisSection) {
        this.enemiesInThisSection = enemiesInThisSection;
    }

    @Override
    public ArrayList<EmptySpaceInGround> getEmptySpaceInGroundsInThisSection() {
        return emptySpaceInGroundsInThisSection;
    }

    public void setEmptySpaceInGroundsInThisSection(ArrayList<EmptySpaceInGround> emptySpaceInGroundsInThisSection) {
        this.emptySpaceInGroundsInThisSection = emptySpaceInGroundsInThisSection;
    }

    @Override
    public GameData getGameData() {
        return gameData;
    }

    @Override
    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }
}
