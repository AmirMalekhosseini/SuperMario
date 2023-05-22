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
    Gravity gravity;

    public GameLoop(GameScreenFrame gameScreenFrame, Gravity gravity) {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        this.gameScreenFrame = gameScreenFrame;
        this.gravity = gravity;
        CalculatorThread calculatorThread = new CalculatorThread();
        GraphicThread graphicThread = new GraphicThread();
        EnemyThread enemyThread = new EnemyThread();
        calculatorThread.start();
        graphicThread.start();
        enemyThread.start();

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
                    gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setLocation
                            (gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getX(),
                                    gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getY());
                    gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setLocation
                            (gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getX(),
                                    gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getY());
                    gameScreenFrame.marioMover.move();
                    if (gameScreenFrame.getGameData().getMarioLocation().equalsIgnoreCase("levelonesectionone")) {
                        gravity.objectsGravityInLevelOneSectionOne();
                        gameScreenFrame.intersectInLevelOneSectionOne.refreshIntersectsBooleans();
                        gameScreenFrame.intersectInLevelOneSectionOne.intersectWithObjects();
                        gameScreenFrame.intersectInLevelOneSectionOne.intersectWithItems();
                        if (gameScreenFrame.intersectInLevelOneSectionOne.intersectWithEnemies()) {
                            setLocationAfterLooseInSectionOneLevelOne();
                        }
                        if (gameScreenFrame.intersectInLevelOneSectionOne.intersectWithEmptyGround()) {
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
                        gravity.objectsGravityInLevelOneSectionTwo();
                        gameScreenFrame.intersectInLevelOneSectionTwo.refreshIntersectsBooleans();
                        gameScreenFrame.intersectInLevelOneSectionTwo.intersectWithObjects();
                        gameScreenFrame.intersectInLevelOneSectionTwo.intersectWithItems();
                        if (gameScreenFrame.intersectInLevelOneSectionTwo.intersectWithEnemies()) {
                            setLocationAfterLooseInSectionTwoLevelOne();
                        }
                        if (gameScreenFrame.intersectInLevelOneSectionTwo.intersectWithEmptyGround()) {
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

    private class EnemyThread extends Thread {

        public void enemyInLevelOneSectionOne() {

            for (int i = 0; i < gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().size(); i++) {

                if (gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i) instanceof Plant) {
                    gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).secondCounter++;
                    if (gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).secondCounter == 10) {
                        gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).setY(
                                gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).getY() -
                                        gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).getVelocity());
                        if (gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).getY() <= 695) {// Plant should go up
                            ((Plant) gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i)).plantWaitTime++;
                            gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).setVelocity(0);
                            if (((Plant) gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i)).plantWaitTime == 9) {
                                gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).setVelocity(-5);
                                ((Plant) gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i)).plantWaitTime = 0;
                            }
                        } else if (gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).getY() >= 850) {
                            int velocity = gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).getVelocity();
                            gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).setVelocity(-velocity);
                        }
                        gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).secondCounter = 0;
                    }

                } else if (gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i) instanceof Goompa) {

                    gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).secondCounter++;
                    if (gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).secondCounter == 10) {
                        gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).setX(
                                gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).getX() +
                                        gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).getVelocity());
                        // Goompa Change its Direction:
                        if (gameScreenFrame.intersectInLevelOneSectionOne.isEnemyHitAnObject
                                (gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i))) {
                            int velocity = gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).getVelocity();
                            gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).setVelocity(-velocity);
                        }
                        gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).secondCounter = 0;
                    }

                }else if (gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i) instanceof Turtle) {

                    gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).secondCounter++;
                    if (gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).secondCounter == 10) {
                        if (((Turtle) gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i)).isTurtleHit()) {
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            ((Turtle) gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i)).setTurtleHit(false);

                        }
                        gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).setX(
                                gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).getX() +
                                        gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).getVelocity());
                        // Goompa Change its Direction:
                        if (gameScreenFrame.intersectInLevelOneSectionOne.isEnemyHitAnObject
                                (gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i))) {
                            int velocity = gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).getVelocity();
                            gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).setVelocity(-velocity);
                        }
                        gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).secondCounter = 0;
                    }

                }else if (gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i) instanceof Spiny) {


                }else if (gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i) instanceof Bird) {

                }

            }

        }

        public void enemyInLevelOneSectionTwo() {

            for (int i = 0; i < gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().size(); i++) {

                if (gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i) instanceof Plant) {
                    gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i).secondCounter++;
                    if (gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i).secondCounter == 10) {
                        gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i).setY(
                                gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i).getY() -
                                        gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i).getVelocity());
                        if (gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i).getY() <= 695) {// Plant should go up
                            ((Plant) gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i)).plantWaitTime++;
                            gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i).setVelocity(0);
                            if (((Plant) gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i)).plantWaitTime == 9) {
                                gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i).setVelocity(-5);
                                ((Plant) gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i)).plantWaitTime = 0;
                            }
                        } else if (gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i).getY() >= 850) {
                            int velocity = gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i).getVelocity();
                            gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i).setVelocity(-velocity);
                        }
                        gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i).secondCounter = 0;
                    }
                }

            }

        }

        public void enemyInLevelTwoSectionOne() {

            for (int i = 0; i < gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().size(); i++) {

                if (gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i) instanceof Plant) {
                    gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i).secondCounter++;
                    if (gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i).secondCounter == 10) {
                        gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i).setY(
                                gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i).getY() -
                                        gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i).getVelocity());
                        if (gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i).getY() <= 695) {// Plant should go up
                            ((Plant) gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i)).plantWaitTime++;
                            gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i).setVelocity(0);
                            if (((Plant) gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i)).plantWaitTime == 9) {
                                gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i).setVelocity(-5);
                                ((Plant) gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i)).plantWaitTime = 0;
                            }
                        } else if (gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i).getY() >= 850) {
                            int velocity = gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i).getVelocity();
                            gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i).setVelocity(-velocity);
                        }
                        gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i).secondCounter = 0;
                    }
                }
            }
        }

        public void enemyInLevelTwoSectionTwo() {

            for (int i = 0; i < gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().size(); i++) {

                if (gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i) instanceof Plant) {
                    gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i).secondCounter++;
                    if (gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i).secondCounter == 10) {
                        gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i).setY(
                                gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i).getY() -
                                        gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i).getVelocity());
                        if (gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i).getY() <= 695) {// Plant should go up
                            ((Plant) gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i)).plantWaitTime++;
                            gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i).setVelocity(0);
                            if (((Plant) gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i)).plantWaitTime == 9) {
                                gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i).setVelocity(-5);
                                ((Plant) gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i)).plantWaitTime = 0;
                            }
                        } else if (gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i).getY() >= 850) {
                            int velocity = gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i).getVelocity();
                            gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i).setVelocity(-velocity);
                        }
                        gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i).secondCounter = 0;
                    }
                }
            }
        }

        public void run() {

            while (!gameScreenFrame.getGameData().isGameFinish) {

                int fps = 120;
                long targetTime = 1000 / fps;
                if (!gameScreenFrame.getGameData().isGameFinish) {
                    long startTime = System.currentTimeMillis();
                    enemyInLevelOneSectionOne();
                    enemyInLevelOneSectionTwo();
                    enemyInLevelTwoSectionOne();
                    enemyInLevelTwoSectionTwo();
                    setLocationOfEnemiesInSectionOneLevelOne();
                    setLocationOfEnemiesInSectionTwoLevelOne();
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


