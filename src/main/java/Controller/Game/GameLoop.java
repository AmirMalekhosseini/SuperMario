package Controller.Game;

import Model.Game.BossFightSectionModel;
import View.Game.LevelScreens;
import View.Menu.MainMenuScreen;
import Model.Enemy.Enemy;
import Model.Enemy.Goompa;
import Model.Game.GameGodFather;
import Model.Game.Score;
import Model.Item.Coin;
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
        gameGodFather.marioMoverController.locateMarioLocation();
        MarioMoverThread marioMoverThread = new MarioMoverThread();
        CalculatorThread calculatorThread = new CalculatorThread();
        GraphicThread graphicThread = new GraphicThread();
        EnemyThread enemyThread = new EnemyThread();
        VilgaxCalculator vilgaxCalculator = new VilgaxCalculator();
        VilgaxMover vilgaxMover = new VilgaxMover();
        marioMoverThread.start();
        calculatorThread.start();
        graphicThread.start();
        enemyThread.start();
        vilgaxCalculator.start();
        vilgaxMover.start();

    }

    public GameLoop() {

    }

    private class CalculatorThread extends Thread {

        public void run() {

            while (!gameGodFather.getGameData().isGameFinish) {

                int fps = 120;
                long targetTime = 1000 / fps;
                if (!gameGodFather.getGameData().isGameFinish
                        && !gameGodFather.getGameData().isGamePause) {
                    long startTime = System.currentTimeMillis();
                    // Check is boss trigger
                    if (gameGodFather.activeLevel.getScreenModel() instanceof BossFightSectionModel) {
                        // trigger boss
                        if (!gameGodFather.getGameData().isBossTriggered()) {
                            synchronized (gameGodFather.waitObject) {
                                ((BossFightSectionModel) gameGodFather.activeLevel.getScreenModel()).vilgaxTrigger.triggerBoss(gameGodFather);

                            }
                        }
                        // check boss in phase_2
                        ((BossFightSectionModel) gameGodFather.activeLevel.getScreenModel()).vilgaxTrigger.activePhase_2();
                    }
                    gameGodFather.marioMoverController.locateMarioLocation();
                    gameGodFather.marioMoverController.moveMarioLeft();
                    gameGodFather.marioMoverController.moveMarioRight();

                    gameGodFather.activeLevel.getScreenModel().controller.checkAddShield();
                    gameGodFather.activeLevel.getScreenModel().controller.checkRemoveShield();
                    gameGodFather.activeLevel.getScreenModel().controller.gravity.allocateGravity();
                    gameGodFather.activeLevel.getIntersect().intersection.refreshIntersectsBooleans();
                    gameGodFather.activeLevel.getIntersect().intersection.marioIntersectWithObjects();
                    gameGodFather.activeLevel.getIntersect().intersection.marioIntersectWithItems();
                    if (gameGodFather.activeLevel.getIntersect().intersection.marioIntersectWithEnemies()) {
                        gameGodFather.activeLevel.getLevelPanel().setLocation(0, 0);
                        gameGodFather.activeLevel.getScreenModel().controller.setLocationAfterLoose();
                    }
                    if (gameGodFather.activeLevel.getIntersect().intersection.marioIntersectWithEmptyGround()) {
                        gameGodFather.activeLevel.getLevelPanel().setLocation(0, 0);
                        gameGodFather.activeLevel.getScreenModel().controller.setLocationAfterLoose();
                        gameGodFather.gameTimer.setSectionTime(50);
                    }
                    if (gameGodFather.gameTimer.getSectionTime() == 0) {
                        gameGodFather.getGameData().setUserHeartValue(gameGodFather.getGameData().getUserHeartValue() - 1);
                        gameGodFather.activeLevel.getLevelPanel().setLocation(0, 0);
                        gameGodFather.activeLevel.getScreenModel().controller.setLocationAfterLoose();
                        gameGodFather.gameTimer.setSectionTime(50);
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
                    gameGodFather.gameTimer.stopTimer();
                    gameGodFather.calculateScore.calculateScore(gameGodFather.activeLevel.getScreen());
                    Score thisGameScore = new Score();
                    thisGameScore.setUserScore(gameGodFather.getGameData().thisGameScore);
                    MyProject.activeUser.get(0).setUserCoinValue(MyProject.activeUser.get(0).getUserCoinValue() + gameGodFather.getGameData().getThisGameCoin());
                    MyProject.activeUser.get(0).getUserScore().add(thisGameScore);
                    if (MyProject.activeUser.get(0).getUserHighScore().getUserScore() <= thisGameScore.getUserScore()) {
                        MyProject.activeUser.get(0).setUserHighScore(thisGameScore);
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
                if (!gameGodFather.getGameData().isGameFinish
                        && !gameGodFather.getGameData().isGamePause) {
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
                if (!gameGodFather.getGameData().isGameFinish
                        && !gameGodFather.getGameData().isGamePause) {
                    long startTime = System.currentTimeMillis();

                    gameGodFather.marioMover.getMarioMoverModel().move();
                    gameGodFather.activeLevel.getMario().changeBackground();
                    gameGodFather.activeLevel.getScreenModel().controller.moveShot();
                    setGameData();
                    gameGodFather.marioMoverController.changeMarioHeight();

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

    private class EnemyThread extends Thread {

        public void run() {

            while (!gameGodFather.getGameData().isGameFinish) {

                int fps = 120;
                long targetTime = 1000 / fps;
                if (!gameGodFather.getGameData().isGameFinish
                        && !gameGodFather.getGameData().isGamePause) {
                    long startTime = System.currentTimeMillis();

                    gameGodFather.activeLevel.getScreenModel().controller.moveEnemy();
                    gameGodFather.activeLevel.getScreenModel().controller.moveItem();
                    gameGodFather.activeLevel.getScreenModel().controller.startThrowSword();
                    gameGodFather.activeLevel.getIntersect().intersection.intersectShot();

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

    public class VilgaxCalculator extends Thread {


        public void run() {


            while (!gameGodFather.getGameData().isGameFinish) {

                // Wait until boss trigger
                while (!gameGodFather.getGameData().isBossTriggered()) {
                    try {
                        synchronized (gameGodFather.waitObject) {
                            gameGodFather.waitObject.wait();
                        }

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                int fps = 120;
                long targetTime = 1000 / fps;
                if (!gameGodFather.getGameData().isGameFinish
                        && !gameGodFather.getGameData().isGamePause) {
                    long startTime = System.currentTimeMillis();

                    gameGodFather.getBossFightScreenSection().vilgax.activeMove.moveIntersection.intersection();
                    if (gameGodFather.activeLevel.getMario().isMarioShouldDie()) {
                        gameGodFather.getBossFightSectionModel().controller.setLocationAfterLoose();
                    }
                    gameGodFather.intersectInBossSection.vilgaxIntersection.allIntersection();
                    gameGodFather.getBossFightScreenSection().healthBar.setValue(gameGodFather.getBossFightScreenSection().vilgax.getHealth());
                    int value = gameGodFather.getBossFightScreenSection().healthBar.getValue();
                    gameGodFather.getBossFightScreenSection().healthBar.setString(value + " / 100");

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

    private class VilgaxMover extends Thread {

        public void run() {


            while (!gameGodFather.getGameData().isGameFinish) {

                // Wait until boss trigger
                while (!gameGodFather.getGameData().isBossTriggered()) {
                    try {
                        synchronized (gameGodFather.waitObject) {
                            gameGodFather.waitObject.wait();
                        }

                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                int fps = 120;
                long targetTime = 1000 / fps;
                if (!gameGodFather.getGameData().isGameFinish
                        && !gameGodFather.getGameData().isGamePause) {
                    long startTime = System.currentTimeMillis();

                    gameGodFather.getBossFightSectionModel().vilgaxMover.moveChooser();
                    gameGodFather.getBossFightSectionModel().vilgaxMover.move();
                    gameGodFather.getBossFightSectionModel().vilgaxAndScreenConnection.moveVilgaxWeapon();


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

    public void setGameData() {

        gameGodFather.activeLevel.getScreen().userHeartValueLabel.setText(String.valueOf(gameGodFather.getGameData().userHeartValue));
        gameGodFather.activeLevel.getScreen().thisGameCoin.setText(String.valueOf(gameGodFather.getGameData().getThisGameCoin()));
        gameGodFather.activeLevel.getScreen().userScoreLabel.setText("Score: " + gameGodFather.getGameData().thisGameScore);
        gameGodFather.activeLevel.getScreen().userHeartValueLabel.setLocation(gameGodFather.activeLevel.getScreen().XUserHeartValueLabel, 30);
        gameGodFather.activeLevel.getScreen().userHeartImage.setLocation(gameGodFather.activeLevel.getScreen().XUserHeartImage, 30);
        gameGodFather.activeLevel.getScreen().userScoreLabel.setLocation(gameGodFather.activeLevel.getScreen().XUserScoreLabel, 30);
        gameGodFather.activeLevel.getScreen().thisSectionTimeLabel.setLocation(gameGodFather.activeLevel.getScreen().XThisSectionTimeLabel, 30);
        gameGodFather.activeLevel.getScreen().thisGameCoin.setLocation(gameGodFather.activeLevel.getScreen().XThisGameCoin, 27);
        gameGodFather.activeLevel.getScreen().thisGameCoinImage.setLocation(gameGodFather.activeLevel.getScreen().XThisGameCoinImage, 30);
        gameGodFather.activeLevel.getScreen().marioLocationLabel.setLocation(gameGodFather.activeLevel.getScreen().XMarioLocationLabel, 25);

    }

    public GameGodFather getGameScreenFrame() {
        return gameGodFather;
    }

    public void setGameScreenFrame(GameGodFather gameGodFather) {
        this.gameGodFather = gameGodFather;
    }
}


