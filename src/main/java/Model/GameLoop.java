package Model;

import Graphic.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import MyProject.MyProject;

import java.io.File;
import java.io.IOException;

public class GameLoop {

    ObjectMapper objectMapper;
    GameScreenFrame gameScreenFrame;

    public GameLoop(GameScreenFrame gameScreenFrame) {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        this.gameScreenFrame = gameScreenFrame;
        CalculatorThread calculatorThread = new CalculatorThread();
        GraphicThread graphicThread = new GraphicThread();
        calculatorThread.start();
        graphicThread.start();
    }

    public GameLoop() {

    }

    private class CalculatorThread extends Thread {

        public void run() {

            while (!gameScreenFrame.getGameData().isGameFinish) {

                int fps = 120;
                long targetTime = 1000 / fps;
                if (!gameScreenFrame.getGameData().isGameFinish) {
                    long startTime = System.currentTimeMillis();
                    int xLevelOneBackgroundPanel = gameScreenFrame.getXLevelOneBackgroundPanel();
                    gameScreenFrame.getLevelOneGameBackgroundPanel().setLocation(xLevelOneBackgroundPanel, 0);
                    setLocationOfEnemiesInSectionOneLevelOne();
                    setLocationOfEnemiesInSectionTwoLevelOne();
                    gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setLocation
                            (gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getX(),
                                    gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getY());
                    gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setLocation
                            (gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getX(),
                                    gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getY());
                    gameScreenFrame.marioMover.move();
                    if (gameScreenFrame.getGameData().getMarioLocation().equalsIgnoreCase("levelonesectionone")) {
                        gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionOne.refreshIntersectsBooleans();
                        gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionOne.intersectWithObjects();
                        gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionOne.intersectWithItems();
                        if (gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionOne.intersectWithEnemies()) {
                            setLocationAfterLooseInSectionOneLevelOne();
                        }
                        if (gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionOne.intersectWithEmptyGround()) {
                            setLocationAfterLooseInSectionOneLevelOne();
                            gameScreenFrame.getLevelOneSectionOneScreen().thisSectionTime.setSectionTime(50);
                        }
                        if (gameScreenFrame.getLevelOneSectionOneScreen().thisSectionTime.getSectionTime() == 0) {
                            gameScreenFrame.getGameData().setUserHeartValue(gameScreenFrame.getGameData().getUserHeartValue() - 1);
                            setLocationAfterLooseInSectionOneLevelOne();
                            gameScreenFrame.getLevelOneSectionOneScreen().thisSectionTime.setSectionTime(50);
                        }
                    }
                    if (gameScreenFrame.getGameData().getMarioLocation().equalsIgnoreCase("levelonesectiontwo")) {
                        gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionTwo.refreshIntersectsBooleans();
                        gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionTwo.intersectWithObjects();
                        gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionTwo.intersectWithItems();
                        if (gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionTwo.intersectWithEnemies()) {
                            setLocationAfterLooseInSectionTwoLevelOne();
                        }
                        if (gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionTwo.intersectWithEmptyGround()) {
                            setLocationAfterLooseInSectionTwoLevelOne();
                            gameScreenFrame.getLevelOneSectionTwoScreen().thisSectionTime.setSectionTime(50);
                        }
                        if (gameScreenFrame.getLevelOneSectionTwoScreen().thisSectionTime.getSectionTime() == 0 &&
                                gameScreenFrame.getGameData().getMarioLocation().equalsIgnoreCase("levelonesectiontwo")) {
                            gameScreenFrame.getGameData().setUserHeartValue(gameScreenFrame.getGameData().getUserHeartValue() - 1);
                            setLocationAfterLooseInSectionTwoLevelOne();
                            gameScreenFrame.getLevelOneSectionTwoScreen().thisSectionTime.setSectionTime(50);
                        }
                    }

                    setGameDataInLevelOne();

                    if (gameScreenFrame.getGameData().userHeartValue == 0) {
                        gameScreenFrame.getGameData().isGameFinish = true;
                    }

                    long elapsedTime = System.currentTimeMillis() - startTime;
                    long sleepTime = targetTime - elapsedTime;
                    if (sleepTime > 0) {
                        try {
                            Thread.sleep(sleepTime);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
                if (gameScreenFrame.getGameData().isGameFinish){// Finish the Game
                    gameScreenFrame.calculateScore.calculateScoreInSectionTwoLevelOne();
                    Score thisGameScore = new Score();
                    thisGameScore.setUserScore(gameScreenFrame.getGameData().thisGameScore);
                    MyProject.activeUser.get(0).setUserCoinValue(MyProject.activeUser.get(0).getUserCoinValue() + gameScreenFrame.getGameData().thisGameCoin);
                    MyProject.activeUser.get(0).userScore.add(thisGameScore);
                    if (MyProject.activeUser.get(0).userHighScore.getUserScore() <= thisGameScore.getUserScore()) {
                        MyProject.activeUser.get(0).userHighScore = thisGameScore;
                    }

                    gameScreenFrame.dispose();
                    new MainMenuScreen();

                    try {
                        objectMapper.writeValue(new File("User.jason"), MyProject.allUsers);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }
    }

    private class GraphicThread extends Thread {

        public void run() {

            while (!gameScreenFrame.getGameData().isGameFinish) {

                int fps = 120;
                long targetTime = 1000 / fps;
                if (!gameScreenFrame.getGameData().isGameFinish) {
                    long startTime = System.currentTimeMillis();
                    gameScreenFrame.getLevelOneSectionOneScreen().backgroundLabelSceneOne.repaint();
                    gameScreenFrame.getLevelOneSectionOneScreen().backgroundLabelSceneTwo.repaint();
                    gameScreenFrame.getLevelOneSectionOneScreen().backgroundLabelSceneThree.repaint();
                    gameScreenFrame.getLevelOneSectionOneScreen().backgroundLabelSceneFour.repaint();
                    gameScreenFrame.getLevelOneSectionTwoScreen().backgroundLabelSceneOne.repaint();
                    gameScreenFrame.getLevelOneSectionTwoScreen().backgroundLabelSceneTwo.repaint();
                    gameScreenFrame.getLevelOneSectionTwoScreen().backgroundLabelSceneThree.repaint();
                    gameScreenFrame.getLevelOneSectionTwoScreen().backgroundLabelSceneFour.repaint();
                    gameScreenFrame.repaint();
                    gameScreenFrame.setFocusable(true);
                    gameScreenFrame.requestFocusInWindow();
                    gameScreenFrame.requestFocus();
                    long elapsedTime = System.currentTimeMillis() - startTime;
                    long sleepTime = targetTime - elapsedTime;
                    if (sleepTime > 0) {
                        try {
                            Thread.sleep(sleepTime);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }

            }
        }
    }


    public void setLocationOfEnemiesInSectionOneLevelOne() {

        for (int i = 0; i < gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().size(); i++) {
            int x = gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).getX();
            int y = gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).getY();
            gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).setLocation(x, y);

        }
    }

    public void setLocationOfEnemiesInSectionTwoLevelOne() {

        for (int i = 0; i < gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().size(); i++) {
            int x = gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i).getX();
            int y = gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i).getY();
            gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i).setLocation(x, y);

        }
    }

    public void setLocationAfterLooseInSectionOneLevelOne() {

        gameScreenFrame.setXLevelOneBackgroundPanel(0);
        gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setX(100);
        gameScreenFrame.getLevelOneSectionOneScreen().XUserHeartImage = 1520;
        gameScreenFrame.getLevelOneSectionOneScreen().userHeartImage.setX(gameScreenFrame.getLevelOneSectionOneScreen().XUserHeartImage);
        gameScreenFrame.getLevelOneSectionOneScreen().XThisGameCoinImage = 1110;
        gameScreenFrame.getLevelOneSectionOneScreen().thisGameCoinImage.setX(gameScreenFrame.getLevelOneSectionOneScreen().XThisGameCoinImage);
        gameScreenFrame.getLevelOneSectionOneScreen().XThisGameCoin = 1080;
        gameScreenFrame.getLevelOneSectionOneScreen().XUserHeartValueLabel = 1510;
        gameScreenFrame.getLevelOneSectionOneScreen().XThisSectionTimeLabel = 1180;
        gameScreenFrame.getLevelOneSectionOneScreen().XUserScoreLabel = 1345;

    }

    public void setLocationAfterLooseInSectionTwoLevelOne() {

        gameScreenFrame.setXLevelOneBackgroundPanel(-6800);
        gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setX(100);
        gameScreenFrame.getLevelOneSectionTwoScreen().XUserHeartImage = 1520;
        gameScreenFrame.getLevelOneSectionTwoScreen().userHeartImage.setX(gameScreenFrame.getLevelOneSectionTwoScreen().XUserHeartImage);
        gameScreenFrame.getLevelOneSectionTwoScreen().XThisGameCoinImage = 1110;
        gameScreenFrame.getLevelOneSectionTwoScreen().thisGameCoinImage.setX(gameScreenFrame.getLevelOneSectionTwoScreen().XThisGameCoinImage);
        gameScreenFrame.getLevelOneSectionTwoScreen().XThisGameCoin = 1080;
        gameScreenFrame.getLevelOneSectionTwoScreen().XUserHeartValueLabel = 1510;
        gameScreenFrame.getLevelOneSectionTwoScreen().XThisSectionTimeLabel = 1180;
        gameScreenFrame.getLevelOneSectionTwoScreen().XUserScoreLabel = 1345;

    }

    public void setGameDataInLevelOne() {

        gameScreenFrame.getLevelOneSectionOneScreen().userHeartValueLabel.setText(String.valueOf(gameScreenFrame.getGameData().userHeartValue));
        gameScreenFrame.getLevelOneSectionOneScreen().thisGameCoin.setText(String.valueOf(gameScreenFrame.getGameData().thisGameCoin));
        gameScreenFrame.getLevelOneSectionOneScreen().userScoreLabel.setText("Score: " + String.valueOf(gameScreenFrame.getGameData().thisGameScore));
        gameScreenFrame.getLevelOneSectionTwoScreen().userHeartValueLabel.setText(String.valueOf(gameScreenFrame.getGameData().userHeartValue));
        gameScreenFrame.getLevelOneSectionTwoScreen().thisGameCoin.setText(String.valueOf(gameScreenFrame.getGameData().thisGameCoin));
        gameScreenFrame.getLevelOneSectionTwoScreen().userScoreLabel.setText("Score: " + String.valueOf(gameScreenFrame.getGameData().thisGameScore));
        gameScreenFrame.getLevelOneSectionOneScreen().userHeartValueLabel.setLocation(gameScreenFrame.getLevelOneSectionOneScreen().XUserHeartValueLabel, 30);
        gameScreenFrame.getLevelOneSectionOneScreen().userHeartImage.setLocation(gameScreenFrame.getLevelOneSectionOneScreen().XUserHeartImage, 30);
        gameScreenFrame.getLevelOneSectionOneScreen().userScoreLabel.setLocation(gameScreenFrame.getLevelOneSectionOneScreen().XUserScoreLabel, 30);
        gameScreenFrame.getLevelOneSectionOneScreen().thisSectionTimeLabel.setLocation(gameScreenFrame.getLevelOneSectionOneScreen().XThisSectionTimeLabel, 30);
        gameScreenFrame.getLevelOneSectionOneScreen().thisGameCoin.setLocation(gameScreenFrame.getLevelOneSectionOneScreen().XThisGameCoin, 27);
        gameScreenFrame.getLevelOneSectionOneScreen().thisGameCoinImage.setLocation(gameScreenFrame.getLevelOneSectionOneScreen().XThisGameCoinImage, 30);
        gameScreenFrame.getLevelOneSectionTwoScreen().userHeartValueLabel.setLocation(gameScreenFrame.getLevelOneSectionTwoScreen().XUserHeartValueLabel, 30);
        gameScreenFrame.getLevelOneSectionTwoScreen().userHeartImage.setLocation(gameScreenFrame.getLevelOneSectionTwoScreen().XUserHeartImage, 30);
        gameScreenFrame.getLevelOneSectionTwoScreen().userScoreLabel.setLocation(gameScreenFrame.getLevelOneSectionTwoScreen().XUserScoreLabel, 30);
        gameScreenFrame.getLevelOneSectionTwoScreen().thisSectionTimeLabel.setLocation(gameScreenFrame.getLevelOneSectionTwoScreen().XThisSectionTimeLabel, 30);
        gameScreenFrame.getLevelOneSectionTwoScreen().thisGameCoin.setLocation(gameScreenFrame.getLevelOneSectionTwoScreen().XThisGameCoin, 27);
        gameScreenFrame.getLevelOneSectionTwoScreen().thisGameCoinImage.setLocation(gameScreenFrame.getLevelOneSectionTwoScreen().XThisGameCoinImage, 30);

    }

    public GameScreenFrame getGameScreenFrame() {
        return gameScreenFrame;
    }

    public void setGameScreenFrame(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
    }
}


