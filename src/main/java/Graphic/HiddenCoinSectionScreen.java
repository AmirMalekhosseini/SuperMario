package Graphic;

import Model.GameData;
import Model.LevelOneSectionOneTime;
import Model.MyProjectData;
import MyProject.MyProject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HiddenCoinSectionScreen extends LevelScreens {

    protected ArrayList<ObjectsInGame> objectsInThisSection = new ArrayList<>();
    protected volatile ArrayList<ItemsInGame> itemsInThisSection = new ArrayList<>();
    protected ArrayList<MarioWeapon> weaponsInThisSection = new ArrayList<>();
    GameData gameData;
    NormalMario normalMario;
    CoinMario coinMario;
    JumperMario jumperMario;
    RunnerMario runnerMario;
    ShooterMario shooterMario;
    public JLabel backgroundLabel;
    public UserHeart userHeartImage;
    public JLabel userHeartValueLabel;
    public JLabel userScoreLabel;
    public JLabel thisSectionTimeLabel;
    public JLabel thisGameCoin;
    public CoinForStore thisGameCoinImage;
    public int XUserHeartImage = 1520;
    public int XUserHeartValueLabel = 1510;
    public int XUserScoreLabel = 1345;
    public int XThisSectionTimeLabel = 1180;
    public int XThisGameCoin = 1080;
    public int XThisGameCoinImage = 1110;

    Cannon cannon_1;
    Cannon cannon_2;
    Cannon cannon_3;
    BlockInAir blockInAir1_1;
    BlockInAir blockInAir1_2;
    BlockInAir blockInAir1_3;
    BlockInAir blockInAir1_4;
    BlockInAir blockInAir1_5;
    BlockInAir blockInAir1_6;
    BlockInAir blockInAir1_7;
    BlockInAir blockInAir1_8;
    BlockInAir blockInAir1_9;
    BlockInAir blockInAir1_10;
    BlockInAir blockInAir1_11;
    BlockInAir blockInAir1_12;
    BlockInAir blockInAir1_13;
    BlockInAir blockInAir1_14;
    BlockInAir blockInAir2_1;
    BlockInAir blockInAir2_2;
    BlockInAir blockInAir2_3;
    BlockInAir blockInAir2_4;
    BlockInAir blockInAir2_5;
    BlockInAir blockInAir2_6;
    BlockInAir blockInAir2_7;
    BlockInAir blockInAir2_8;
    BlockInAir blockInAir2_9;
    BlockInAir blockInAir2_10;
    BlockInAir blockInAir3_1;
    BlockInAir blockInAir3_2;
    BlockInAir blockInAir3_3;
    BlockInAir blockInAir3_4;
    BlockInAir blockInAir3_5;
    BlockInAir blockInAir3_6;
    BlockInAir blockInAir3_7;
    BlockInAir blockInAir3_8;
    PipeHorizontal pipeHorizontal;

    public HiddenCoinSectionScreen(GameData gameData) {
        init(gameData);
    }

    private void init(GameData gameData) {

        this.gameData = gameData;
        ImageIcon backgroundImage = new ImageIcon("BackgroundSections.jpg");
        activeMario = new ArrayList<>();
        activeMario.add(new NormalMario(0, 0));
        Font font1 = MyProjectData.getProjectData().getFont22();
        thisSectionTime = new HiddenCoinSectionTime(this);

        this.setSize(1700, 1100);
        this.setVisible(true);
        backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 1700, 1100);

        userHeartImage = new UserHeart(XUserHeartImage, 20);
        userHeartImage.setBounds(userHeartImage.getX(), userHeartImage.getY(), 50, 50);
        userHeartValueLabel = new JLabel(String.valueOf(gameData.getUserHeartValue()));
        userHeartValueLabel.setBounds(XUserHeartValueLabel, 30, 20, 20);
        userHeartValueLabel.setFont(font1);

        userScoreLabel = new JLabel("Score: " + String.valueOf(gameData.getThisGameScore()));
        userScoreLabel.setBounds(XUserScoreLabel, 30, 200, 20);
        userScoreLabel.setFont(font1);

        thisSectionTimeLabel = new JLabel("Time: ??:?? " );
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

        cannon_1 = new Cannon(1260, 270);
        blockInAir1_1 = new SimpleBlockInAir(400, 750);
        blockInAir1_2 = new SimpleBlockInAir(470, 750);
        blockInAir1_3 = new SimpleBlockInAir(540, 750);
        blockInAir1_4 = new SimpleBlockInAir(610, 750);
        blockInAir1_5 = new SimpleBlockInAir(680, 750);
        blockInAir1_6 = new SimpleBlockInAir(750, 750);
        blockInAir1_7 = new SimpleBlockInAir(820, 750);
        blockInAir1_8 = new SimpleBlockInAir(890, 750);
        blockInAir1_9 = new SimpleBlockInAir(960, 750);
        blockInAir1_10 = new SimpleBlockInAir(1030, 750);
        blockInAir1_11 = new SimpleBlockInAir(1100, 750);
        blockInAir1_12 = new SimpleBlockInAir(1170, 750);
        blockInAir1_13 = new SimpleBlockInAir(1240, 750);
        blockInAir1_14 = new SimpleBlockInAir(1310, 750);

        cannon_2 = new Cannon(1260, 470);
        blockInAir2_1 = new SimpleBlockInAir(680, 550);
        blockInAir2_2 = new SimpleBlockInAir(750, 550);
        blockInAir2_3 = new SimpleBlockInAir(820, 550);
        blockInAir2_4 = new SimpleBlockInAir(890, 550);
        blockInAir2_5 = new SimpleBlockInAir(960, 550);
        blockInAir2_6 = new SimpleBlockInAir(1030, 550);
        blockInAir2_7 = new SimpleBlockInAir(1100, 550);
        blockInAir2_8 = new SimpleBlockInAir(1170, 550);
        blockInAir2_9 = new SimpleBlockInAir(1240, 550);
        blockInAir2_10 = new SimpleBlockInAir(1310, 550);

        cannon_3 = new Cannon(1260, 670);
        blockInAir3_1 = new SimpleBlockInAir(820, 350);
        blockInAir3_2 = new SimpleBlockInAir(890, 350);
        blockInAir3_3 = new SimpleBlockInAir(960, 350);
        blockInAir3_4 = new SimpleBlockInAir(1030, 350);
        blockInAir3_5 = new SimpleBlockInAir(1100, 350);
        blockInAir3_6 = new SimpleBlockInAir(1170, 350);
        blockInAir3_7 = new SimpleBlockInAir(1240, 350);
        blockInAir3_8 = new SimpleBlockInAir(1310, 350);

        pipeHorizontal = new PipeHorizontal(1300, 820);

        this.add(backgroundLabel, Integer.valueOf(0));
        this.add(userHeartImage, Integer.valueOf(1));
        this.add(userHeartValueLabel, Integer.valueOf(1));
        this.add(userScoreLabel, Integer.valueOf(1));
        this.add(thisSectionTimeLabel, Integer.valueOf(1));
        this.add(thisGameCoin, Integer.valueOf(1));
        this.add(thisGameCoinImage, Integer.valueOf(1));

        this.add(cannon_1, Integer.valueOf(1));
        this.add(blockInAir1_1, Integer.valueOf(1));
        this.add(blockInAir1_2, Integer.valueOf(1));
        this.add(blockInAir1_3, Integer.valueOf(1));
        this.add(blockInAir1_4, Integer.valueOf(1));
        this.add(blockInAir1_5, Integer.valueOf(1));
        this.add(blockInAir1_6, Integer.valueOf(1));
        this.add(blockInAir1_7, Integer.valueOf(1));
        this.add(blockInAir1_8, Integer.valueOf(1));
        this.add(blockInAir1_9, Integer.valueOf(1));
        this.add(blockInAir1_10, Integer.valueOf(1));
        this.add(blockInAir1_11, Integer.valueOf(1));
        this.add(blockInAir1_12, Integer.valueOf(1));
        this.add(blockInAir1_13, Integer.valueOf(1));
        this.add(blockInAir1_14, Integer.valueOf(1));

        this.add(cannon_2, Integer.valueOf(1));
        this.add(blockInAir2_1, Integer.valueOf(1));
        this.add(blockInAir2_2, Integer.valueOf(1));
        this.add(blockInAir2_3, Integer.valueOf(1));
        this.add(blockInAir2_4, Integer.valueOf(1));
        this.add(blockInAir2_5, Integer.valueOf(1));
        this.add(blockInAir2_6, Integer.valueOf(1));
        this.add(blockInAir2_7, Integer.valueOf(1));
        this.add(blockInAir2_8, Integer.valueOf(1));
        this.add(blockInAir2_9, Integer.valueOf(1));
        this.add(blockInAir2_10, Integer.valueOf(1));

        this.add(cannon_3, Integer.valueOf(1));
        this.add(blockInAir3_1, Integer.valueOf(1));
        this.add(blockInAir3_2, Integer.valueOf(1));
        this.add(blockInAir3_3, Integer.valueOf(1));
        this.add(blockInAir3_4, Integer.valueOf(1));
        this.add(blockInAir3_5, Integer.valueOf(1));
        this.add(blockInAir3_6, Integer.valueOf(1));
        this.add(blockInAir3_7, Integer.valueOf(1));
        this.add(blockInAir3_8, Integer.valueOf(1));
        this.add(pipeHorizontal, Integer.valueOf(1));


        objectsInThisSection.add(cannon_1);
        objectsInThisSection.add(blockInAir1_1);
        objectsInThisSection.add(blockInAir1_2);
        objectsInThisSection.add(blockInAir1_3);
        objectsInThisSection.add(blockInAir1_4);
        objectsInThisSection.add(blockInAir1_5);
        objectsInThisSection.add(blockInAir1_6);
        objectsInThisSection.add(blockInAir1_7);
        objectsInThisSection.add(blockInAir1_8);
        objectsInThisSection.add(blockInAir1_9);
        objectsInThisSection.add(blockInAir1_10);
        objectsInThisSection.add(blockInAir1_11);
        objectsInThisSection.add(blockInAir1_12);
        objectsInThisSection.add(blockInAir1_13);
        objectsInThisSection.add(blockInAir1_14);

        objectsInThisSection.add(cannon_2);
        objectsInThisSection.add(blockInAir2_1);
        objectsInThisSection.add(blockInAir2_2);
        objectsInThisSection.add(blockInAir2_3);
        objectsInThisSection.add(blockInAir2_4);
        objectsInThisSection.add(blockInAir2_5);
        objectsInThisSection.add(blockInAir2_6);
        objectsInThisSection.add(blockInAir2_7);
        objectsInThisSection.add(blockInAir2_8);
        objectsInThisSection.add(blockInAir2_9);
        objectsInThisSection.add(blockInAir2_10);

        objectsInThisSection.add(cannon_3);
        objectsInThisSection.add(blockInAir3_1);
        objectsInThisSection.add(blockInAir3_2);
        objectsInThisSection.add(blockInAir3_3);
        objectsInThisSection.add(blockInAir3_4);
        objectsInThisSection.add(blockInAir3_5);
        objectsInThisSection.add(blockInAir3_6);
        objectsInThisSection.add(blockInAir3_7);
        objectsInThisSection.add(blockInAir3_8);
        objectsInThisSection.add(pipeHorizontal);



    }

    public ArrayList<ObjectsInGame> getObjectsInThisSection() {
        return objectsInThisSection;
    }

    public void setObjectsInThisSection(ArrayList<ObjectsInGame> objectsInThisSection) {
        this.objectsInThisSection = objectsInThisSection;
    }

    public ArrayList<ItemsInGame> getItemsInThisSection() {
        return itemsInThisSection;
    }

    public void setItemsInThisSection(ArrayList<ItemsInGame> itemsInThisSection) {
        this.itemsInThisSection = itemsInThisSection;
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

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }
}
