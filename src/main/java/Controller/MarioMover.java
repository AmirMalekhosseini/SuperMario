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
    Mario activeMario;

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
            activeMario = gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0);

            try {
                if (gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getX() >= 6380) {// Go to Section Two
                    gameScreenFrame.setXLevelOneBackgroundPanel(-6800);

                }

                // GravityData:

                if (upMario) {// Mario start jumping

                    activeMario.setVelocityY(gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getVelocityY() + (GravityData.gravity * GravityData.dt));
                    activeMario.setY((int) (gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getY() + gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getVelocityY()));
                    activeMario.setMarioJumping(true);// Mario is jumping
                    if (gameScreenFrame.intersectInLevelOneSectionOne.isMarioHitsDownOfTheObject()) {// Mario hits down of an object and comes back to ground
                        activeMario.setVelocityY(0);
                        activeMario.setY((activeMario.getY() + 2));
                    } else if (gameScreenFrame.intersectInLevelOneSectionOne.isMarioHitsUpOfTheObject()) {// Mario hits up an object and stand on it
                        activeMario.setVelocityY(0);
                        activeMario.setY((activeMario.getY() - 2));
                        activeMario.setMarioJumping(false);// Mario stop jumping
                        gameScreenFrame.intersectInLevelOneSectionOne.setMarioHitsAnObject(false);
                        gameScreenFrame.intersectInLevelOneSectionOne.setMarioHitsFullOfCoinBlockInAir(false);
                        gameScreenFrame.intersectInLevelOneSectionOne.setMarioHitsTurtle(false);
                        isUserPressedUp = false;

                    }

                    if (activeMario.getY() >= 960 - activeMario.getHeight()
                            && activeMario.getY() <= 980 - activeMario.getHeight()) {// Mario Hits Ground and Stop jumping


                        upMario = false;
                        isUserPressedUp = false;
                        activeMario.setMarioJumping(false);
                        gameScreenFrame.intersectInLevelOneSectionOne.setMarioHitsAnObject(false);
                        gameScreenFrame.intersectInLevelOneSectionOne.setMarioHitsFullOfCoinBlockInAir(false);
                        gameScreenFrame.intersectInLevelOneSectionOne.setMarioHitsTurtle(false);
                    }

                }

                if (rightMario && !leftMario && !gameScreenFrame.intersectInLevelOneSectionOne.isMarioHitsLeftOfTheObject()) {// Go Right
                    if (activeMario.getX() < 830 || activeMario.getX() >= 5800) {// Move Mario
                        activeMario.setX(activeMario.getX() + 5);
                    } else {// Move Panel
                        int xLevelOneBackgroundPanel = gameScreenFrame.getXLevelOneBackgroundPanel();
                        gameScreenFrame.setXLevelOneBackgroundPanel(xLevelOneBackgroundPanel - 5);
                        activeMario.setX(activeMario.getX() + 5);
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
                if (leftMario && !rightMario && !gameScreenFrame.intersectInLevelOneSectionOne.isMarioHitsRightOfTheObject()) {// Go Left
                    if (activeMario.getX() < 840 || activeMario.getX() >= 5800) {// Move Mario
                        activeMario.setX(activeMario.getX() - 5);
                    } else {// Move Panel
                        int xLevelOneBackgroundPanel = gameScreenFrame.getXLevelOneBackgroundPanel();
                        gameScreenFrame.setXLevelOneBackgroundPanel(xLevelOneBackgroundPanel + 5);
                        activeMario.setX(activeMario.getX() - 5);
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
            activeMario = gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0);
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

                // GravityData:

                if (upMario) {// Mario start jumping

                    activeMario.setVelocityY(activeMario.getVelocityY() + (GravityData.gravity * GravityData.dt));
                    activeMario.setY((int) (activeMario.getY() + activeMario.getVelocityY()));
                    activeMario.setMarioJumping(true);// Mario is jumping
                    if (gameScreenFrame.intersectInLevelOneSectionTwo.isMarioHitsDownOfTheObject()) {// Mario hits down of an object and comes back to ground
                        activeMario.setVelocityY(0);
                        activeMario.setY(((activeMario).getY() + 2));
                    } else if (gameScreenFrame.intersectInLevelOneSectionTwo.isMarioHitsUpOfTheObject()) {// Mario hits up an object and stand on it
                        activeMario.setVelocityY(0);
                        activeMario.setY((gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getY() - 2));
                        activeMario.setMarioJumping(false);// Mario stop jumping
                        gameScreenFrame.intersectInLevelOneSectionTwo.setMarioHitsAnObject(false);
                        gameScreenFrame.intersectInLevelOneSectionTwo.setMarioHitsFullOfCoinBlockInAir(false);
                        isUserPressedUp = false;
                    }

                    if (activeMario.getY() >= 960 - activeMario.getHeight() && activeMario.getY() <= 980 - activeMario.getHeight()) {// Mario Hits Ground and Stop jumping

                        upMario = false;
                        isUserPressedUp = false;
                        activeMario.setMarioJumping(false);
                        gameScreenFrame.intersectInLevelOneSectionTwo.setMarioHitsAnObject(false);
                        gameScreenFrame.intersectInLevelOneSectionTwo.setMarioHitsFullOfCoinBlockInAir(false);
                    }

                }


                if (rightMario && !leftMario && !gameScreenFrame.intersectInLevelOneSectionTwo.isMarioHitsLeftOfTheObject()) {
                    if (activeMario.getX() < 830 || activeMario.getX() >= 5800) {// Move Mario
                        activeMario.setX(activeMario.getX() + 5);
                    } else {// Move Panel
                        int xLevelOneBackgroundPanel = gameScreenFrame.getXLevelOneBackgroundPanel();
                        gameScreenFrame.setXLevelOneBackgroundPanel(xLevelOneBackgroundPanel - 5);
                        activeMario.setX(activeMario.getX() + 5);
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
                if (leftMario && !rightMario && !gameScreenFrame.intersectInLevelOneSectionTwo.isMarioHitsRightOfTheObject()) {
                    if (activeMario.getX() < 840 || activeMario.getX() >= 5800) {// Move Mario
                        activeMario.setX(activeMario.getX() - 5);

                    } else {// Move Panel
                        int xLevelOneBackgroundPanel = gameScreenFrame.getXLevelOneBackgroundPanel();
                        gameScreenFrame.setXLevelOneBackgroundPanel(xLevelOneBackgroundPanel + 5);
                        activeMario.setX(activeMario.getX() - 5);
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
                activeMario.setVelocityY(-10);
                isUserPressedUp = true;
            }
        }

        if (e.getKeyChar() == 's') {
            downMario = true;
            activeMario.setMarioSit(true);
        }

        if (e.getKeyChar() == 'a') {
            leftMario = true;
            activeMario.setMarioRight(false);
            activeMario.setMarioLeft(true);
        }

        if (e.getKeyChar() == 'd') {
            rightMario = true;
            activeMario.setMarioRight(true);
            activeMario.setMarioLeft(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyChar() == 's') {
            downMario = false;
            activeMario.setMarioSit(false);
        }

        if (e.getKeyChar() == 'a') {
            leftMario = false;
            activeMario.setMarioLeft(false);
        }

        if (e.getKeyChar() == 'd') {
            rightMario = false;
            activeMario.setMarioRight(false);
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