package Model;

import Graphic.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import MyProject.MyProject;

import java.io.File;
import java.io.IOException;

public class GameLoop {

    ObjectMapper objectMapper;
    GameGodFather gameGodFather;

    public GameLoop(GameGodFather gameGodFather) {

        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        this.gameGodFather = gameGodFather;
        gameGodFather.marioMover.getMarioMoverModel().locateMarioLocation();
        MarioMoverThread marioMoverThread = new MarioMoverThread();
        CalculatorThread calculatorThread = new CalculatorThread();
        GraphicThread graphicThread = new GraphicThread();
        EnemyThread enemyThread = new EnemyThread();
        VilgaxThread vilgaxThread = new VilgaxThread();
        HiddenCoinSectionThread hiddenCoinSectionThread = new HiddenCoinSectionThread();
        HiddenEnemySectionThread hiddenEnemySectionThread = new HiddenEnemySectionThread();
        marioMoverThread.start();
        calculatorThread.start();
        graphicThread.start();
        enemyThread.start();
        vilgaxThread.start();
//        hiddenCoinSectionThread.start();
//        hiddenEnemySectionThread.start();
    }

    public GameLoop() {

    }

    private class CalculatorThread extends Thread {

        public void run() {

            while (!gameGodFather.getGameData().isGameFinish) {

                int fps = 120;
                long targetTime = 1000 / fps;
                if (!gameGodFather.getGameData().isGameFinish) {
                    long startTime = System.currentTimeMillis();
                    gameGodFather.marioMover.getMarioMoverModel().locateMarioLocation();
                    if (gameGodFather.getGameData().getMarioLocation().equalsIgnoreCase("levelonesectionone")) {
                        gameGodFather.getLevelOneSectionOneModel().controller.gravity.allocateGravity();
                        gameGodFather.intersectInLevelOneSectionOne.intersection.refreshIntersectsBooleans();
                        gameGodFather.intersectInLevelOneSectionOne.intersection.marioIntersectWithObjects();
                        gameGodFather.intersectInLevelOneSectionOne.intersection.marioIntersectWithItems();
                        if (gameGodFather.intersectInLevelOneSectionOne.intersection.marioIntersectWithEnemies()) {
                            gameGodFather.getGameScreenFrame().currentPanel.setLocation(0, 0);
                            gameGodFather.getLevelOneSectionOneModel().controller.setLocationAfterLoose();
                        }
                        if (gameGodFather.intersectInLevelOneSectionOne.intersection.marioIntersectWithEmptyGround()) {
                            gameGodFather.getGameScreenFrame().currentPanel.setLocation(0, 0);
                            gameGodFather.getLevelOneSectionOneModel().controller.setLocationAfterLoose();
                            gameGodFather.gameTimer.setSectionTime(50);
                        }
                        if (gameGodFather.gameTimer.getSectionTime() == 0) {
                            gameGodFather.getGameData().setUserHeartValue(gameGodFather.getGameData().getUserHeartValue() - 1);
                            gameGodFather.getGameScreenFrame().currentPanel.setLocation(0, 0);
                            gameGodFather.getLevelOneSectionOneModel().controller.setLocationAfterLoose();
                            gameGodFather.gameTimer.setSectionTime(50);
                        }
                    }
                    if (gameGodFather.getGameData().getMarioLocation().equalsIgnoreCase("levelonesectiontwo")) {
                        gameGodFather.getLevelOneSectionTwoModel().controller.gravity.allocateGravity();
                        gameGodFather.intersectInLevelOneSectionTwo.intersection.refreshIntersectsBooleans();
                        gameGodFather.intersectInLevelOneSectionTwo.intersection.marioIntersectWithObjects();
                        gameGodFather.intersectInLevelOneSectionTwo.intersection.marioIntersectWithItems();
                        if (gameGodFather.intersectInLevelOneSectionTwo.intersection.marioIntersectWithEnemies()) {
                            gameGodFather.getGameScreenFrame().currentPanel.setLocation(-6800, 0);
                            gameGodFather.getLevelOneSectionTwoModel().controller.setLocationAfterLoose();
                        }
                        if (gameGodFather.intersectInLevelOneSectionTwo.intersection.marioIntersectWithEmptyGround()) {
                            gameGodFather.getGameScreenFrame().currentPanel.setLocation(-6800, 0);
                            gameGodFather.getLevelOneSectionTwoModel().controller.setLocationAfterLoose();
                            gameGodFather.gameTimer.setSectionTime(50);
                        }
                        if (gameGodFather.gameTimer.getSectionTime() == 0) {
                            gameGodFather.getGameData().setUserHeartValue(gameGodFather.getGameData().getUserHeartValue() - 1);
                            gameGodFather.getGameScreenFrame().currentPanel.setLocation(-6800, 0);
                            gameGodFather.getLevelOneSectionTwoModel().controller.setLocationAfterLoose();
                            gameGodFather.gameTimer.setSectionTime(50);
                        }
                    }

                    if (gameGodFather.getGameData().userHeartValue == 0) {
                        gameGodFather.getGameData().isGameFinish = true;
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
                if (gameGodFather.getGameData().isGameFinish) {// Finish the Game
                    gameGodFather.calculateScore.calculateScore(gameGodFather.getLevelOneSectionTwoScreen());
                    Score thisGameScore = new Score();
                    thisGameScore.setUserScore(gameGodFather.getGameData().thisGameScore);
                    MyProject.activeUser.get(0).setUserCoinValue(MyProject.activeUser.get(0).getUserCoinValue() + gameGodFather.getGameData().thisGameCoin);
                    MyProject.activeUser.get(0).userScore.add(thisGameScore);
                    if (MyProject.activeUser.get(0).userHighScore.getUserScore() <= thisGameScore.getUserScore()) {
                        MyProject.activeUser.get(0).userHighScore = thisGameScore;
                    }

                    gameGodFather.getGameScreenFrame().dispose();
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

            while (!gameGodFather.getGameData().isGameFinish) {

                int fps = 120;
                long targetTime = 1000 / fps;
                if (!gameGodFather.getGameData().isGameFinish) {
                    long startTime = System.currentTimeMillis();

                    gameGodFather.getGameScreenFrame().repaint();
                    for (LevelScreens screen : gameGodFather.getGameScreens()) {
                        screen.repaint();
                        screen.thisSectionTimeLabel.setText("Time: " + gameGodFather.gameTimer.getSectionTime());
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

            }
        }
    }

    private class MarioMoverThread extends Thread {

        public void run() {

            while (!gameGodFather.getGameData().isGameFinish) {

                int fps = 120;
                long targetTime = 1000 / fps;
                if (!gameGodFather.getGameData().isGameFinish) {
                    long startTime = System.currentTimeMillis();

                    gameGodFather.marioMover.getMarioMoverModel().move();
                    gameGodFather.marioMover.getMarioMoverModel().activeScreen.activeMario.changeBackground();
                    gameGodFather.getLevelOneSectionOneModel().controller.moveShot();
                    gameGodFather.getLevelOneSectionTwoModel().controller.moveShot();
                    setGameDataInLevelOne();
                    gameGodFather.marioMoverModel.changeMarioHeight();

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

                    if (gameGodFather.getHiddenEnemySectionModel().enemyCounter <= 25) {

                        if (gameGodFather.getHiddenEnemySectionModel().isCannonOneWorking()) {
                            Enemy newEnemy = new Goompa(1250, 275);
                            gameGodFather.getHiddenEnemySectionScreen().getEnemiesInThisSection().add(newEnemy);
                            gameGodFather.getHiddenEnemySectionScreen().add(newEnemy, Integer.valueOf(1));
                            gameGodFather.getHiddenEnemySectionModel().setCannonOneWorking(false);
                            gameGodFather.getHiddenEnemySectionModel().setCannonTwoWorking(true);
                            gameGodFather.getHiddenEnemySectionModel().setCannonThreeWorking(false);
                            gameGodFather.getHiddenEnemySectionModel().enemyCounter++;
                        } else if (gameGodFather.getHiddenEnemySectionModel().isCannonTwoWorking()) {
                            Enemy newEnemy = new Goompa(1200, 475);
                            gameGodFather.getHiddenEnemySectionScreen().getEnemiesInThisSection().add(newEnemy);
                            gameGodFather.getHiddenEnemySectionScreen().add(newEnemy, Integer.valueOf(1));
                            gameGodFather.getHiddenEnemySectionModel().setCannonOneWorking(false);
                            gameGodFather.getHiddenEnemySectionModel().setCannonTwoWorking(false);
                            gameGodFather.getHiddenEnemySectionModel().setCannonThreeWorking(true);
                            gameGodFather.getHiddenEnemySectionModel().enemyCounter++;
                        } else if (gameGodFather.getHiddenEnemySectionModel().isCannonThreeWorking()) {
                            Enemy newEnemy = new Goompa(1150, 675);
                            gameGodFather.getHiddenEnemySectionScreen().getEnemiesInThisSection().add(newEnemy);
                            gameGodFather.getHiddenEnemySectionScreen().add(newEnemy, Integer.valueOf(1));
                            gameGodFather.getHiddenEnemySectionModel().setCannonOneWorking(true);
                            gameGodFather.getHiddenEnemySectionModel().setCannonTwoWorking(false);
                            gameGodFather.getHiddenEnemySectionModel().setCannonThreeWorking(false);
                            gameGodFather.getHiddenEnemySectionModel().enemyCounter++;
                        }
                    }
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (this) {

                    gameGodFather.getHiddenEnemySectionModel().controller.gravity.allocateGravity();

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

                    if (gameGodFather.getHiddenCoinSectionModel().coinCounter <= 25) {

                        if (gameGodFather.getHiddenCoinSectionModel().isCannonOneWorking()) {
                            Coin newCoin = new Coin(1250, 300);
                            gameGodFather.getHiddenCoinSectionScreen().getItemsInThisSection().add(newCoin);
                            gameGodFather.getHiddenCoinSectionScreen().add(newCoin, Integer.valueOf(1));
                            gameGodFather.getHiddenCoinSectionModel().setCannonOneWorking(false);
                            gameGodFather.getHiddenCoinSectionModel().setCannonTwoWorking(true);
                            gameGodFather.getHiddenCoinSectionModel().setCannonThreeWorking(false);
                            gameGodFather.getHiddenCoinSectionModel().coinCounter++;
                        } else if (gameGodFather.getHiddenCoinSectionModel().isCannonTwoWorking()) {
                            Coin newCoin = new Coin(1200, 500);
                            gameGodFather.getHiddenCoinSectionScreen().getItemsInThisSection().add(newCoin);
                            gameGodFather.getHiddenCoinSectionScreen().add(newCoin, Integer.valueOf(1));
                            gameGodFather.getHiddenCoinSectionModel().setCannonOneWorking(false);
                            gameGodFather.getHiddenCoinSectionModel().setCannonTwoWorking(false);
                            gameGodFather.getHiddenCoinSectionModel().setCannonThreeWorking(true);
                            gameGodFather.getHiddenCoinSectionModel().coinCounter++;
                        } else if (gameGodFather.getHiddenCoinSectionModel().isCannonThreeWorking()) {
                            Coin newCoin = new Coin(1150, 700);
                            gameGodFather.getHiddenCoinSectionScreen().getItemsInThisSection().add(newCoin);
                            gameGodFather.getHiddenCoinSectionScreen().add(newCoin, Integer.valueOf(1));
                            gameGodFather.getHiddenCoinSectionModel().setCannonOneWorking(true);
                            gameGodFather.getHiddenCoinSectionModel().setCannonTwoWorking(false);
                            gameGodFather.getHiddenCoinSectionModel().setCannonThreeWorking(false);
                            gameGodFather.getHiddenCoinSectionModel().coinCounter++;
                        }
                    }
                }

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (this) {

                    gameGodFather.getHiddenCoinSectionModel().controller.gravity.allocateGravity();

                }

            }

        }

    }


    private class EnemyThread extends Thread {

        public void run() {

            while (!gameGodFather.getGameData().isGameFinish) {

                int fps = 120;
                long targetTime = 1000 / fps;
                if (!gameGodFather.getGameData().isGameFinish) {
                    long startTime = System.currentTimeMillis();
                    if (gameGodFather.getGameData().getMarioLocation().equalsIgnoreCase("levelonesectionone")) {
                        gameGodFather.getLevelOneSectionOneModel().controller.moveEnemy();
                        gameGodFather.getLevelOneSectionOneModel().controller.moveItem();
                        gameGodFather.intersectInLevelOneSectionOne.intersection.intersectShot();
                        gameGodFather.getLevelOneSectionOneModel().controller.startThrowSword();
                    } else if (gameGodFather.getGameData().getMarioLocation().equalsIgnoreCase("levelonesectiontwo")) {
                        gameGodFather.getLevelOneSectionTwoModel().controller.moveEnemy();
                        gameGodFather.getLevelOneSectionTwoModel().controller.moveItem();
                        gameGodFather.intersectInLevelOneSectionTwo.intersection.intersectShot();
                        gameGodFather.getLevelOneSectionTwoModel().controller.startThrowSword();
                    } else if (gameGodFather.getGameData().getMarioLocation().equalsIgnoreCase("leveltwosectionone")) {
                        gameGodFather.getLevelTwoSectionOneModel().controller.moveEnemy();
                        gameGodFather.getLevelTwoSectionOneModel().controller.moveItem();
                        gameGodFather.intersectInLevelTwoSectionOne.intersection.intersectShot();
                        gameGodFather.getLevelTwoSectionOneModel().controller.startThrowSword();
                    } else if (gameGodFather.getGameData().getMarioLocation().equalsIgnoreCase("levelTwosectiontwo")) {
                        gameGodFather.getLevelTwoSectionTwoModel().controller.moveEnemy();
                        gameGodFather.getLevelTwoSectionTwoModel().controller.moveItem();
                        gameGodFather.intersectInLevelTwoSectionTwo.intersection.intersectShot();
                        gameGodFather.getLevelTwoSectionTwoModel().controller.startThrowSword();
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

            }
        }

    }

    private class VilgaxThread extends Thread {

        public void run() {

            while (!gameGodFather.getGameData().isGameFinish) {

                int fps = 120;
                long targetTime = 1000 / fps;
                if (!gameGodFather.getGameData().isGameFinish) {
                    long startTime = System.currentTimeMillis();

                    gameGodFather.getBossFightScreenSection().vilgax.activeMove.action();
                    gameGodFather.getBossFightScreenSection().vilgaxAndScreenConnection.moveVilgaxWeapon();
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

        gameGodFather.getLevelOneSectionOneScreen().userHeartValueLabel.setText(String.valueOf(gameGodFather.getGameData().userHeartValue));
        gameGodFather.getLevelOneSectionOneScreen().thisGameCoin.setText(String.valueOf(gameGodFather.getGameData().thisGameCoin));
        gameGodFather.getLevelOneSectionOneScreen().userScoreLabel.setText("Score: " + gameGodFather.getGameData().thisGameScore);
        gameGodFather.getLevelOneSectionTwoScreen().userHeartValueLabel.setText(String.valueOf(gameGodFather.getGameData().userHeartValue));
        gameGodFather.getLevelOneSectionTwoScreen().thisGameCoin.setText(String.valueOf(gameGodFather.getGameData().thisGameCoin));
        gameGodFather.getLevelOneSectionTwoScreen().userScoreLabel.setText("Score: " + gameGodFather.getGameData().thisGameScore);
        gameGodFather.getLevelOneSectionOneScreen().userHeartValueLabel.setLocation(gameGodFather.getLevelOneSectionOneScreen().XUserHeartValueLabel, 30);
        gameGodFather.getLevelOneSectionOneScreen().userHeartImage.setLocation(gameGodFather.getLevelOneSectionOneScreen().XUserHeartImage, 30);
        gameGodFather.getLevelOneSectionOneScreen().userScoreLabel.setLocation(gameGodFather.getLevelOneSectionOneScreen().XUserScoreLabel, 30);
        gameGodFather.getLevelOneSectionOneScreen().thisSectionTimeLabel.setLocation(gameGodFather.getLevelOneSectionOneScreen().XThisSectionTimeLabel, 30);
        gameGodFather.getLevelOneSectionOneScreen().thisGameCoin.setLocation(gameGodFather.getLevelOneSectionOneScreen().XThisGameCoin, 27);
        gameGodFather.getLevelOneSectionOneScreen().thisGameCoinImage.setLocation(gameGodFather.getLevelOneSectionOneScreen().XThisGameCoinImage, 30);
        gameGodFather.getLevelOneSectionTwoScreen().userHeartValueLabel.setLocation(gameGodFather.getLevelOneSectionTwoScreen().XUserHeartValueLabel, 30);
        gameGodFather.getLevelOneSectionTwoScreen().userHeartImage.setLocation(gameGodFather.getLevelOneSectionTwoScreen().XUserHeartImage, 30);
        gameGodFather.getLevelOneSectionTwoScreen().userScoreLabel.setLocation(gameGodFather.getLevelOneSectionTwoScreen().XUserScoreLabel, 30);
        gameGodFather.getLevelOneSectionTwoScreen().thisSectionTimeLabel.setLocation(gameGodFather.getLevelOneSectionTwoScreen().XThisSectionTimeLabel, 30);
        gameGodFather.getLevelOneSectionTwoScreen().thisGameCoin.setLocation(gameGodFather.getLevelOneSectionTwoScreen().XThisGameCoin, 27);
        gameGodFather.getLevelOneSectionTwoScreen().thisGameCoinImage.setLocation(gameGodFather.getLevelOneSectionTwoScreen().XThisGameCoinImage, 30);

    }

    public GameGodFather getGameScreenFrame() {
        return gameGodFather;
    }

    public void setGameScreenFrame(GameGodFather gameGodFather) {
        this.gameGodFather = gameGodFather;
    }
}


