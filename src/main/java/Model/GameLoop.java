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
        EnemyThread enemyThread = new EnemyThread();
        HiddenCoinSectionThread hiddenCoinSectionThread = new HiddenCoinSectionThread();
        HiddenEnemySectionThread hiddenEnemySectionThread = new HiddenEnemySectionThread();
        calculatorThread.start();
        graphicThread.start();
        enemyThread.start();
        hiddenCoinSectionThread.start();
//        hiddenEnemySectionThread.start();
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
                    gameScreenFrame.marioMover.move();
                    if (gameScreenFrame.getGameData().getMarioLocation().equalsIgnoreCase("levelonesectionone")) {
                        gameScreenFrame.getLevelOneSectionOneModel().gravity.allocateGravity();
                        gameScreenFrame.intersectInLevelOneSectionOne.refreshIntersectsBooleans();
                        gameScreenFrame.intersectInLevelOneSectionOne.intersectWithObjects();
                        gameScreenFrame.intersectInLevelOneSectionOne.intersectWithItems();
                        if (gameScreenFrame.intersectInLevelOneSectionOne.intersectWithEnemies()) {
                            gameScreenFrame.setXLevelOneBackgroundPanel(0);
                            gameScreenFrame.getLevelOneSectionOneModel().setLocationAfterLoose();
                        }
                        if (gameScreenFrame.intersectInLevelOneSectionOne.intersectWithEmptyGround()) {
                            gameScreenFrame.setXLevelOneBackgroundPanel(0);
                            gameScreenFrame.getLevelOneSectionOneModel().setLocationAfterLoose();
                            gameScreenFrame.getLevelOneSectionOneScreen().thisSectionTime.setSectionTime(50);
                        }
                        if (gameScreenFrame.getLevelOneSectionOneScreen().thisSectionTime.getSectionTime() == 0) {
                            gameScreenFrame.getGameData().setUserHeartValue(gameScreenFrame.getGameData().getUserHeartValue() - 1);
                            gameScreenFrame.setXLevelOneBackgroundPanel(0);
                            gameScreenFrame.getLevelOneSectionOneModel().setLocationAfterLoose();
                            gameScreenFrame.getLevelOneSectionOneScreen().thisSectionTime.setSectionTime(50);
                        }
                    }
                    if (gameScreenFrame.getGameData().getMarioLocation().equalsIgnoreCase("levelonesectiontwo")) {
                        gameScreenFrame.getLevelOneSectionTwoModel().gravity.allocateGravity();
                        gameScreenFrame.intersectInLevelOneSectionTwo.refreshIntersectsBooleans();
                        gameScreenFrame.intersectInLevelOneSectionTwo.intersectWithObjects();
                        gameScreenFrame.intersectInLevelOneSectionTwo.intersectWithItems();
                        if (gameScreenFrame.intersectInLevelOneSectionTwo.intersectWithEnemies()) {
                            gameScreenFrame.setXLevelOneBackgroundPanel(-6800);
                            gameScreenFrame.getLevelOneSectionTwoModel().setLocationAfterLoose();
                        }
                        if (gameScreenFrame.intersectInLevelOneSectionTwo.intersectWithEmptyGround()) {
                            gameScreenFrame.setXLevelOneBackgroundPanel(-6800);
                            gameScreenFrame.getLevelOneSectionTwoModel().setLocationAfterLoose();
                            gameScreenFrame.getLevelOneSectionTwoScreen().thisSectionTime.setSectionTime(50);
                        }
                        if (gameScreenFrame.getLevelOneSectionTwoScreen().thisSectionTime.getSectionTime() == 0 &&
                                gameScreenFrame.getGameData().getMarioLocation().equalsIgnoreCase("levelonesectiontwo")) {
                            gameScreenFrame.getGameData().setUserHeartValue(gameScreenFrame.getGameData().getUserHeartValue() - 1);
                            gameScreenFrame.setXLevelOneBackgroundPanel(-6800);
                            gameScreenFrame.getLevelOneSectionTwoModel().setLocationAfterLoose();
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
                if (gameScreenFrame.getGameData().isGameFinish) {// Finish the Game
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
                    gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setLocation
                            (gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getX(),
                                    gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getY());
                    gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setLocation
                            (gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getX(),
                                    gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getY());
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

    private class HiddenEnemySectionThread extends Thread {

        public void run() {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            while (true) {

                synchronized (this) {

                    if (gameScreenFrame.getHiddenEnemySectionModel().enemyCounter <= 25) {

                        if (gameScreenFrame.getHiddenEnemySectionModel().isCannonOneWorking()) {
                            Enemy newEnemy = new Goompa(1250, 275);
                            gameScreenFrame.getHiddenEnemySectionScreen().getEnemiesInThisSection().add(newEnemy);
                            gameScreenFrame.getHiddenEnemySectionScreen().add(newEnemy, Integer.valueOf(1));
                            gameScreenFrame.getHiddenEnemySectionModel().setCannonOneWorking(false);
                            gameScreenFrame.getHiddenEnemySectionModel().setCannonTwoWorking(true);
                            gameScreenFrame.getHiddenEnemySectionModel().setCannonThreeWorking(false);
                            gameScreenFrame.getHiddenEnemySectionModel().enemyCounter++;
                        } else if (gameScreenFrame.getHiddenEnemySectionModel().isCannonTwoWorking()) {
                            Enemy newEnemy = new Goompa(1200, 475);
                            gameScreenFrame.getHiddenEnemySectionScreen().getEnemiesInThisSection().add(newEnemy);
                            gameScreenFrame.getHiddenEnemySectionScreen().add(newEnemy, Integer.valueOf(1));
                            gameScreenFrame.getHiddenEnemySectionModel().setCannonOneWorking(false);
                            gameScreenFrame.getHiddenEnemySectionModel().setCannonTwoWorking(false);
                            gameScreenFrame.getHiddenEnemySectionModel().setCannonThreeWorking(true);
                            gameScreenFrame.getHiddenEnemySectionModel().enemyCounter++;
                        } else if (gameScreenFrame.getHiddenEnemySectionModel().isCannonThreeWorking()) {
                            Enemy newEnemy = new Goompa(1150, 675);
                            gameScreenFrame.getHiddenEnemySectionScreen().getEnemiesInThisSection().add(newEnemy);
                            gameScreenFrame.getHiddenEnemySectionScreen().add(newEnemy, Integer.valueOf(1));
                            gameScreenFrame.getHiddenEnemySectionModel().setCannonOneWorking(true);
                            gameScreenFrame.getHiddenEnemySectionModel().setCannonTwoWorking(false);
                            gameScreenFrame.getHiddenEnemySectionModel().setCannonThreeWorking(false);
                            gameScreenFrame.getHiddenEnemySectionModel().enemyCounter++;
                        }
                    }
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (this) {

                    gameScreenFrame.getHiddenEnemySectionModel().gravity.allocateGravity();

                }

            }

        }

    }


    private class HiddenCoinSectionThread extends Thread {

        public void run() {

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            while (true) {

                synchronized (this) {

                    if (gameScreenFrame.getHiddenCoinSectionModel().coinCounter <= 25) {

                        if (gameScreenFrame.getHiddenCoinSectionModel().isCannonOneWorking()) {
                            Coin newCoin = new Coin(1250, 300);
                            gameScreenFrame.getHiddenCoinSectionScreen().getItemsInThisSection().add(newCoin);
                            gameScreenFrame.getHiddenCoinSectionScreen().add(newCoin, Integer.valueOf(1));
                            gameScreenFrame.getHiddenCoinSectionModel().setCannonOneWorking(false);
                            gameScreenFrame.getHiddenCoinSectionModel().setCannonTwoWorking(true);
                            gameScreenFrame.getHiddenCoinSectionModel().setCannonThreeWorking(false);
                            gameScreenFrame.getHiddenCoinSectionModel().coinCounter++;
                        } else if (gameScreenFrame.getHiddenCoinSectionModel().isCannonTwoWorking()) {
                            Coin newCoin = new Coin(1200, 500);
                            gameScreenFrame.getHiddenCoinSectionScreen().getItemsInThisSection().add(newCoin);
                            gameScreenFrame.getHiddenCoinSectionScreen().add(newCoin, Integer.valueOf(1));
                            gameScreenFrame.getHiddenCoinSectionModel().setCannonOneWorking(false);
                            gameScreenFrame.getHiddenCoinSectionModel().setCannonTwoWorking(false);
                            gameScreenFrame.getHiddenCoinSectionModel().setCannonThreeWorking(true);
                            gameScreenFrame.getHiddenCoinSectionModel().coinCounter++;
                        } else if (gameScreenFrame.getHiddenCoinSectionModel().isCannonThreeWorking()) {
                            Coin newCoin = new Coin(1150, 700);
                            gameScreenFrame.getHiddenCoinSectionScreen().getItemsInThisSection().add(newCoin);
                            gameScreenFrame.getHiddenCoinSectionScreen().add(newCoin, Integer.valueOf(1));
                            gameScreenFrame.getHiddenCoinSectionModel().setCannonOneWorking(true);
                            gameScreenFrame.getHiddenCoinSectionModel().setCannonTwoWorking(false);
                            gameScreenFrame.getHiddenCoinSectionModel().setCannonThreeWorking(false);
                            gameScreenFrame.getHiddenCoinSectionModel().coinCounter++;
                        }
                    }
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (this) {

                gameScreenFrame.getHiddenCoinSectionModel().gravity.allocateGravity();

                }

            }

        }

    }


    private class EnemyThread extends Thread {

        public void run() {

            while (!gameScreenFrame.getGameData().isGameFinish) {

                int fps = 120;
                long targetTime = 1000 / fps;
                if (!gameScreenFrame.getGameData().isGameFinish) {
                    long startTime = System.currentTimeMillis();
                    gameScreenFrame.getLevelOneSectionOneModel().moveEnemy();
                    gameScreenFrame.getLevelOneSectionOneModel().moveItem();
                    gameScreenFrame.getLevelOneSectionTwoModel().moveEnemy();
                    gameScreenFrame.getLevelOneSectionTwoModel().moveItem();
                    gameScreenFrame.getLevelTwoSectionOneModel().moveEnemy();
                    gameScreenFrame.getLevelTwoSectionOneModel().moveItem();
                    gameScreenFrame.getLevelTwoSectionTwoModel().moveEnemy();
                    gameScreenFrame.getLevelTwoSectionTwoModel().moveItem();
                    gameScreenFrame.getLevelOneSectionOneModel().setLocationOfEnemies();
                    gameScreenFrame.getLevelOneSectionTwoModel().setLocationOfEnemies();
                    gameScreenFrame.getLevelTwoSectionOneModel().setLocationOfEnemies();
                    gameScreenFrame.getLevelTwoSectionTwoModel().setLocationOfEnemies();
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

    public void setGameDataInLevelOne() {

        gameScreenFrame.getLevelOneSectionOneScreen().userHeartValueLabel.setText(String.valueOf(gameScreenFrame.getGameData().userHeartValue));
        gameScreenFrame.getLevelOneSectionOneScreen().thisGameCoin.setText(String.valueOf(gameScreenFrame.getGameData().thisGameCoin));
        gameScreenFrame.getLevelOneSectionOneScreen().userScoreLabel.setText("Score: " + gameScreenFrame.getGameData().thisGameScore);
        gameScreenFrame.getLevelOneSectionTwoScreen().userHeartValueLabel.setText(String.valueOf(gameScreenFrame.getGameData().userHeartValue));
        gameScreenFrame.getLevelOneSectionTwoScreen().thisGameCoin.setText(String.valueOf(gameScreenFrame.getGameData().thisGameCoin));
        gameScreenFrame.getLevelOneSectionTwoScreen().userScoreLabel.setText("Score: " + gameScreenFrame.getGameData().thisGameScore);
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


