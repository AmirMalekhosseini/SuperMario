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
    JLabel backgroundLabelSceneOne;
    JLabel backgroundLabelSceneTwo;
    JLabel backgroundLabelSceneThree;
    JLabel backgroundLabelSceneFour;
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
        } else {
            System.out.println("WTF");
        }

        // Scene One:
        firstBlockInAirSceneOne = new BlockInAir(450, 700);
        firstBlockInAirSceneOne.setLocation(firstBlockInAirSceneOne.getX(), firstBlockInAirSceneOne.getY());
        firstBlockInAirSceneOne.setOpaque(true);
        coinOnFirstBlockInAirSceneOne = new Coin(450, 650);
        coinOnFirstBlockInAirSceneOne.setLocation(coinOnFirstBlockInAirSceneOne.getX(), coinOnFirstBlockInAirSceneOne.getY());
        coinOnFirstBlockInAirSceneOne.setOpaque(true);

        secondBlockInAirSceneOne = new BlockInAir(520, 700);
        secondBlockInAirSceneOne.setLocation(secondBlockInAirSceneOne.getX(), secondBlockInAirSceneOne.getY());
        secondBlockInAirSceneOne.setOpaque(true);

        firstPrizeInAirSceneOne = new PrizeInAir(555, 450);
        firstPrizeInAirSceneOne.setLocation(firstPrizeInAirSceneOne.getX(), firstPrizeInAirSceneOne.getY());
        firstPrizeInAirSceneOne.setOpaque(true);

        thirdBlockInAirSceneOne = new BlockInAir(590, 700);
        thirdBlockInAirSceneOne.setLocation(thirdBlockInAirSceneOne.getX(), thirdBlockInAirSceneOne.getY());
        thirdBlockInAirSceneOne.setOpaque(true);
        coinOnThirdBlockInAirSceneOne = new Coin(590, 650);
        coinOnThirdBlockInAirSceneOne.setLocation(coinOnThirdBlockInAirSceneOne.getX(), coinOnThirdBlockInAirSceneOne.getY());
        coinOnThirdBlockInAirSceneOne.setOpaque(true);

        fourthBlockInAirSceneOne = new BlockInAir(660, 700);
        fourthBlockInAirSceneOne.setLocation(fourthBlockInAirSceneOne.getX(), fourthBlockInAirSceneOne.getY());
        fourthBlockInAirSceneOne.setOpaque(true);

        firstCoinOnGroundSceneOne = new Coin(610, 890);
        firstCoinOnGroundSceneOne.setLocation(firstCoinOnGroundSceneOne.getX(), firstCoinOnGroundSceneOne.getY());
        firstCoinOnGroundSceneOne.setOpaque(true);
        secondCoinOnGroundSceneOne = new Coin(690, 890);
        secondCoinOnGroundSceneOne.setLocation(secondCoinOnGroundSceneOne.getX(), secondCoinOnGroundSceneOne.getY());
        secondCoinOnGroundSceneOne.setOpaque(true);
        thirdCoinOnGroundSceneOne = new Coin(770, 890);
        thirdCoinOnGroundSceneOne.setLocation(thirdCoinOnGroundSceneOne.getX(), thirdCoinOnGroundSceneOne.getY());
        thirdCoinOnGroundSceneOne.setOpaque(true);

        fifthBlockInAirSceneOne = new BlockInAir(1000, 700);
        fifthBlockInAirSceneOne.setLocation(fifthBlockInAirSceneOne.getX(), fifthBlockInAirSceneOne.getY());
        fifthBlockInAirSceneOne.setOpaque(true);

        secondPrizeInAirSceneOne = new PrizeInAir(1070, 700);
        secondPrizeInAirSceneOne.setLocation(secondPrizeInAirSceneOne.getX(), secondPrizeInAirSceneOne.getY());
        secondPrizeInAirSceneOne.setOpaque(true);

        sixthBlockInAirSceneOne = new BlockInAir(1140, 700);
        sixthBlockInAirSceneOne.setLocation(sixthBlockInAirSceneOne.getX(), sixthBlockInAirSceneOne.getY());
        sixthBlockInAirSceneOne.setOpaque(true);
        coinOnSixthBlockInAirSceneOne = new Coin(1140, 650);
        coinOnSixthBlockInAirSceneOne.setLocation(coinOnSixthBlockInAirSceneOne.getX(), coinOnSixthBlockInAirSceneOne.getY());
        coinOnSixthBlockInAirSceneOne.setOpaque(true);

        seventhBlockInAirSceneOne = new BlockInAir(1210, 700);
        seventhBlockInAirSceneOne.setLocation(seventhBlockInAirSceneOne.getX(), seventhBlockInAirSceneOne.getY());
        seventhBlockInAirSceneOne.setOpaque(true);

        fourthCoinOnGroundSceneOne = new Coin(1220, 890);
        fourthCoinOnGroundSceneOne.setLocation(fourthCoinOnGroundSceneOne.getX(), fourthCoinOnGroundSceneOne.getY());
        fourthCoinOnGroundSceneOne.setOpaque(true);
        fifthCoinOnGroundSceneOne = new Coin(1300, 890);
        fifthCoinOnGroundSceneOne.setLocation(fifthCoinOnGroundSceneOne.getX(), fifthCoinOnGroundSceneOne.getY());
        fifthCoinOnGroundSceneOne.setOpaque(true);

        // Scene Two:
        firstBlockInAirSceneTwo = new BlockInAir(2100, 700);
        firstBlockInAirSceneTwo.setLocation(firstBlockInAirSceneTwo.getX(), firstBlockInAirSceneTwo.getY());
        firstBlockInAirSceneTwo.setOpaque(true);

        secondBlockInAirSceneTwo = new BlockInAir(2170, 700);
        secondBlockInAirSceneTwo.setLocation(secondBlockInAirSceneTwo.getX(), secondBlockInAirSceneTwo.getY());
        secondBlockInAirSceneTwo.setOpaque(true);

        thirdBlockInAirSceneTwo = new BlockInAir(2240, 700);
        thirdBlockInAirSceneTwo.setLocation(thirdBlockInAirSceneTwo.getX(), thirdBlockInAirSceneTwo.getY());
        thirdBlockInAirSceneTwo.setOpaque(true);

        fourthBlockInAirSceneTwo = new BlockInAir(2310, 700);
        fourthBlockInAirSceneTwo.setLocation(fourthBlockInAirSceneTwo.getX(), fourthBlockInAirSceneTwo.getY());
        fourthBlockInAirSceneTwo.setOpaque(true);

        firstPrizeInAirSceneTwo = new PrizeInAir(2900, 520);
        firstPrizeInAirSceneTwo.setLocation(firstPrizeInAirSceneTwo.getX(), firstPrizeInAirSceneTwo.getY());
        firstPrizeInAirSceneTwo.setOpaque(true);

        firstEmptySpaceInGroundSceneTwo = new EmptySpaceInGround(2550, 945);
        firstEmptySpaceInGroundSceneTwo.setLocation(firstEmptySpaceInGroundSceneTwo.getX(), firstEmptySpaceInGroundSceneTwo.getY());
        firstEmptySpaceInGroundSceneTwo.setOpaque(true);

        fifthBlockInAirSceneTwo = new BlockInAir(2500, 600);
        fifthBlockInAirSceneTwo.setLocation(fifthBlockInAirSceneTwo.getX(), fifthBlockInAirSceneTwo.getY());
        fifthBlockInAirSceneTwo.setOpaque(true);
        coinOnFifthBlockInAirSceneTwo = new Coin(2500, 550);
        coinOnFifthBlockInAirSceneTwo.setLocation(coinOnFifthBlockInAirSceneTwo.getX(), coinOnFifthBlockInAirSceneTwo.getY());
        coinOnFifthBlockInAirSceneTwo.setOpaque(true);

        sixthBlockInAirSceneTwo = new BlockInAir(2570, 600);
        sixthBlockInAirSceneTwo.setLocation(sixthBlockInAirSceneTwo.getX(), sixthBlockInAirSceneTwo.getY());
        sixthBlockInAirSceneTwo.setOpaque(true);
        coinOnSixthBlockInAirSceneTwo = new Coin(2570, 550);
        coinOnSixthBlockInAirSceneTwo.setLocation(coinOnSixthBlockInAirSceneTwo.getX(), coinOnSixthBlockInAirSceneTwo.getY());
        coinOnSixthBlockInAirSceneTwo.setOpaque(true);

        seventhBlockInAirSceneTwo = new BlockInAir(2640, 600);
        seventhBlockInAirSceneTwo.setLocation(seventhBlockInAirSceneTwo.getX(), seventhBlockInAirSceneTwo.getY());
        seventhBlockInAirSceneTwo.setOpaque(true);
        coinOnSeventhBlockInAirSceneTwo = new Coin(2640, 550);
        coinOnSeventhBlockInAirSceneTwo.setLocation(coinOnSeventhBlockInAirSceneTwo.getX(), coinOnSeventhBlockInAirSceneTwo.getY());
        coinOnSeventhBlockInAirSceneTwo.setOpaque(true);

        firstPrizeInAirSceneOne = new PrizeInAir(555, 450);
        firstPrizeInAirSceneOne.setLocation(firstPrizeInAirSceneOne.getX(), firstPrizeInAirSceneOne.getY());
        firstPrizeInAirSceneOne.setOpaque(true);

        // Scene Three:
        firstPrizeInAirSceneThree = new PrizeInAir(4300, 500);
        firstPrizeInAirSceneThree.setLocation(firstPrizeInAirSceneThree.getX(), firstPrizeInAirSceneThree.getY());
        firstPrizeInAirSceneThree.setOpaque(true);

        secondPrizeInAirSceneThree = new PrizeInAir(4700, 500);
        secondPrizeInAirSceneThree.setLocation(secondPrizeInAirSceneThree.getX(), secondPrizeInAirSceneThree.getY());
        secondPrizeInAirSceneThree.setOpaque(true);

        firstPipeSceneThree = new Pipe(4100, 765);
        firstPipeSceneThree.setLocation(firstPipeSceneThree.getX(), firstPipeSceneThree.getY());
        firstPipeSceneThree.setOpaque(true);
        plantInFirstPipeSceneThree = new Plant(4125, 750);
        plantInFirstPipeSceneThree.setLocation(plantInFirstPipeSceneThree.getX(), plantInFirstPipeSceneThree.getY());
        plantInFirstPipeSceneThree.setOpaque(true);

        firstCoinOnGroundSceneThree = new Coin(4400, 890);
        firstCoinOnGroundSceneThree.setLocation(firstCoinOnGroundSceneThree.getX(), firstCoinOnGroundSceneThree.getY());
        firstCoinOnGroundSceneThree.setOpaque(true);
        secondCoinOnGroundSceneThree = new Coin(4480, 890);
        secondCoinOnGroundSceneThree.setLocation(secondCoinOnGroundSceneThree.getX(), secondCoinOnGroundSceneThree.getY());
        secondCoinOnGroundSceneThree.setOpaque(true);
        thirdCoinOnGroundSceneThree = new Coin(4480, 890);
        thirdCoinOnGroundSceneThree.setLocation(thirdCoinOnGroundSceneThree.getX(), thirdCoinOnGroundSceneThree.getY());
        thirdCoinOnGroundSceneThree.setOpaque(true);

        secondPipeSceneThree = new Pipe(4800, 765);
        secondPipeSceneThree.setLocation(secondPipeSceneThree.getX(), secondPipeSceneThree.getY());
        secondPipeSceneThree.setOpaque(false);

        // Scene Four:
        castle = new CastleInLevelOne(6220, 490);
        castle.setLocation(castle.getX(), castle.getY());
        castle.setOpaque(true);

        pipeHorizontalSceneFour = new PipeHorizontal(5780, 820);
        pipeHorizontalSceneFour.setLocation(pipeHorizontalSceneFour.getX(), pipeHorizontalSceneFour.getY());
        pipeHorizontalSceneFour.setOpaque(true);

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
