package Controller;

import MyProject.MyProject;
import Model.*;
import Graphic.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class MarioMover implements KeyListener {


    ObjectMapper objectMapper;
    private boolean rightMario;
    private boolean leftMario;
    private boolean upMario;
    private boolean downMario;

    private boolean isUserPressedUp;
    private boolean marioEnterInSectionTwo;
    GameScreenFrame gameScreenFrame;


    public MarioMover(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    public MarioMover() {

    }

    public void move() {

        if (gameScreenFrame.getXLevelOneBackgroundPanel() >= -6700) {// Game is in LevelOne SectionOne
            gameScreenFrame.getGameData().setMarioLocation("levelonesectionone");

            try {
                if (gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getX() >= 6380) {// Go to Section Two
                    gameScreenFrame.setXLevelOneBackgroundPanel(-6800);

                }

                // Gravity:

                if (upMario) {// Mario start jumping

                    gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setVelocityY(gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getVelocityY() + (Gravity.gravity * Gravity.dt));
                    gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setY((int) (gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getY() + gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getVelocityY()));
                    gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setMarioJumping(true);// Mario is jumping
                    if (gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionOne.isMarioHitsDownOfTheObject()) {// Mario hits down of an object and comes back to ground
                        gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setVelocityY(0);
                        gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setY((gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getY() + 2));
                    } else if (gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionOne.isMarioHitsUpOfTheObject()) {// Mario hits up an object and stand on it
                        gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setVelocityY(0);
                        gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setY((gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getY() - 2));
                        gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setMarioJumping(false);// Mario stop jumping
                        gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionOne.setMarioHitsAnObject(false);
                        gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionOne.setMarioHitsFullOfCoinBlockInAir(false);
                        isUserPressedUp = false;

                    }

                    if (gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getY() >= 840 && gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getY() <= 860) {// Mario Hits Ground and Stop jumping
                        upMario = false;
                        isUserPressedUp = false;
                        gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setMarioJumping(false);
                        gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionOne.setMarioHitsAnObject(false);
                        gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionOne.setMarioHitsFullOfCoinBlockInAir(false);
                    }

                }

                if (rightMario && !leftMario && !gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionOne.isMarioHitsLeftOfTheObject()) {// Go Right
                    if (gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getX() < 830 || gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getX() >= 5800) {// Move Mario
                        gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setX(gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getX() + 5);
                    } else {// Move Panel
                        int xLevelOneBackgroundPanel = gameScreenFrame.getXLevelOneBackgroundPanel();
                        gameScreenFrame.setXLevelOneBackgroundPanel(xLevelOneBackgroundPanel - 5);
                        gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setX(gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getX() + 5);
                        gameScreenFrame.getLevelOneSectionOneScreen().XThisGameCoinImage += 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().thisGameCoinImage.setX(gameScreenFrame.getLevelOneSectionOneScreen().XThisGameCoinImage);
                        gameScreenFrame.getLevelOneSectionOneScreen().XThisGameCoin += 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().XThisSectionTimeLabel += 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().XUserHeartImage += 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().userHeartImage.setX(gameScreenFrame.getLevelOneSectionOneScreen().XUserHeartImage);
                        gameScreenFrame.getLevelOneSectionOneScreen().XUserScoreLabel += 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().XUserHeartValueLabel += 5;
                    }
                }
                if (leftMario && !rightMario && !gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionOne.isMarioHitsRightOfTheObject()) {// Go Left
                    if (gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getX() < 840 || gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getX() >= 5800) {// Move Mario
                        gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setX(gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getX() - 5);
                    } else {// Move Panel
                        int xLevelOneBackgroundPanel = gameScreenFrame.getXLevelOneBackgroundPanel();
                        gameScreenFrame.setXLevelOneBackgroundPanel(xLevelOneBackgroundPanel + 5);
                        gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setX(gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getX() - 5);
                        gameScreenFrame.getLevelOneSectionOneScreen().XThisGameCoinImage -= 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().thisGameCoinImage.setX(gameScreenFrame.getLevelOneSectionOneScreen().XThisGameCoinImage);
                        gameScreenFrame.getLevelOneSectionOneScreen().XThisGameCoin -= 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().XThisSectionTimeLabel -= 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().XUserHeartImage -= 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().userHeartImage.setX(gameScreenFrame.getLevelOneSectionOneScreen().XUserHeartImage);
                        gameScreenFrame.getLevelOneSectionOneScreen().XUserScoreLabel -= 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().XUserHeartValueLabel -= 5;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {// Game is in SectionTwo

            gameScreenFrame.getGameData().setMarioLocation("levelonesectiontwo");
            if (!marioEnterInSectionTwo) {
                marioEnterInSectionTwo = true;
                gameScreenFrame.getLevelOneSectionTwoScreen().thisSectionTime.setSectionTime(50);
                // Add Score At The End Of SectionOne
                gameScreenFrame.calculateScore.calculateScoreInSectionOneLevelOne();
            }

//            if (gameScreenFrame.getLevelTwoSectionTwoScreen().activeMario.get(0).getX() >= 6200) {// Level is Finish
//                gameScreenFrame.getGameData().setGameFinish(true);
//            }

            try {

                // Gravity:

                if (upMario) {// Mario start jumping

                    gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setVelocityY(gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getVelocityY() + (Gravity.gravity * Gravity.dt));
                    gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setY((int) (gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getY() + gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getVelocityY()));
                    gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setMarioJumping(true);// Mario is jumping
                    if (gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionTwo.isMarioHitsDownOfTheObject()) {// Mario hits down of an object and comes back to ground
                        gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setVelocityY(0);
                        gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setY((gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getY() + 2));
                    } else if (gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionTwo.isMarioHitsUpOfTheObject()) {// Mario hits up an object and stand on it
                        gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setVelocityY(0);
                        gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setY((gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getY() - 2));
                        gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setMarioJumping(false);// Mario stop jumping
                        gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionTwo.setMarioHitsAnObject(false);
                        gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionTwo.setMarioHitsFullOfCoinBlockInAir(false);
                        isUserPressedUp = false;
                    }

                    if (gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getY() >= 840 && gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getY() <= 860) {// Mario Hits Ground and Stop jumping
                        upMario = false;
                        isUserPressedUp = false;
                        gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setMarioJumping(false);
                        gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionTwo.setMarioHitsAnObject(false);
                        gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionTwo.setMarioHitsFullOfCoinBlockInAir(false);
                    }

                }


                if (rightMario && !leftMario && !gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionTwo.isMarioHitsLeftOfTheObject()) {
                    if (gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getX() < 830 || gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getX() >= 5800) {// Move Mario
                        gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setX(gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getX() + 5);
                    } else {// Move Panel
                        int xLevelOneBackgroundPanel = gameScreenFrame.getXLevelOneBackgroundPanel();
                        gameScreenFrame.setXLevelOneBackgroundPanel(xLevelOneBackgroundPanel - 5);
                        gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setX(gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getX() + 5);
                        gameScreenFrame.getLevelOneSectionTwoScreen().XThisGameCoinImage += 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().thisGameCoinImage.setX(gameScreenFrame.getLevelOneSectionTwoScreen().XThisGameCoinImage);
                        gameScreenFrame.getLevelOneSectionTwoScreen().XThisGameCoin += 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().XThisSectionTimeLabel += 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().XUserHeartImage += 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().userHeartImage.setX(gameScreenFrame.getLevelOneSectionTwoScreen().XUserHeartImage);
                        gameScreenFrame.getLevelOneSectionTwoScreen().XUserScoreLabel += 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().XUserHeartValueLabel += 5;
                    }
                }
                if (leftMario && !rightMario && !gameScreenFrame.intersectMarioAndObjectsInLevelOneSectionTwo.isMarioHitsRightOfTheObject()) {
                    if (gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getX() < 840 || gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getX() >= 5800) {// Move Mario
                        gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setX(gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getX() - 5);

                    } else {// Move Panel
                        int xLevelOneBackgroundPanel = gameScreenFrame.getXLevelOneBackgroundPanel();
                        gameScreenFrame.setXLevelOneBackgroundPanel(xLevelOneBackgroundPanel + 5);
                        gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setX(gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getX() - 5);
                        gameScreenFrame.getLevelOneSectionTwoScreen().XThisGameCoinImage -= 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().thisGameCoinImage.setX(gameScreenFrame.getLevelOneSectionTwoScreen().XThisGameCoinImage);
                        gameScreenFrame.getLevelOneSectionTwoScreen().XThisGameCoin -= 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().XThisSectionTimeLabel -= 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().XUserHeartImage -= 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().userHeartImage.setX(gameScreenFrame.getLevelOneSectionTwoScreen().XUserHeartImage);
                        gameScreenFrame.getLevelOneSectionTwoScreen().XUserScoreLabel -= 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().XUserHeartValueLabel -= 5;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            gameScreenFrame.dispose();
            gameScreenFrame.getGameData().setGamePause(true);
            new MainMenuScreen();
            try {
                objectMapper.writeValue(new File("User.jason"), MyProject.allUsers);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getKeyChar() == 'w') {
            if (!isUserPressedUp) {
                upMario = true;
                gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setVelocityY(-10);
                gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setVelocityY(-10);
                isUserPressedUp = true;
            }
        }

        if (e.getKeyChar() == 's') {
            downMario = true;
        }

        if (e.getKeyChar() == 'a') {
            leftMario = true;
            gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setMarioRight(false);
            gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setMarioLeft(true);
            gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setMarioRight(false);
            gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setMarioLeft(true);
        }

        if (e.getKeyChar() == 'd') {
            rightMario = true;
            gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setMarioRight(true);
            gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setMarioLeft(false);
            gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setMarioRight(true);
            gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setMarioLeft(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyChar() == 's') {
            downMario = false;
        }

        if (e.getKeyChar() == 'a') {
            leftMario = false;
            gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setMarioLeft(false);
            gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setMarioLeft(false);
        }

        if (e.getKeyChar() == 'd') {
            rightMario = false;
            gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).setMarioRight(false);
            gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).setMarioRight(false);
        }
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public boolean isRightMario() {
        return rightMario;
    }

    public void setRightMario(boolean rightMario) {
        this.rightMario = rightMario;
    }

    public boolean isLeftMario() {
        return leftMario;
    }

    public void setLeftMario(boolean leftMario) {
        this.leftMario = leftMario;
    }

    public boolean isUpMario() {
        return upMario;
    }

    public void setUpMario(boolean upMario) {
        this.upMario = upMario;
    }

    public boolean isDownMario() {
        return downMario;
    }

    public void setDownMario(boolean downMario) {
        this.downMario = downMario;
    }

    public boolean isUserPressedUp() {
        return isUserPressedUp;
    }

    public void setUserPressedUp(boolean userPressedUp) {
        isUserPressedUp = userPressedUp;
    }

    public boolean isMarioEnterInSectionTwo() {
        return marioEnterInSectionTwo;
    }

    public void setMarioEnterInSectionTwo(boolean marioEnterInSectionTwo) {
        this.marioEnterInSectionTwo = marioEnterInSectionTwo;
    }

    public GameScreenFrame getGameScreenFrame() {
        return gameScreenFrame;
    }

    public void setGameScreenFrame(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
    }
}