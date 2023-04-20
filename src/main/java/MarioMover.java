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

    public void move() {

        if (gameScreenFrame.getxLevelOneBackgroundPanel() >= -6700) {// Game is in SectionOne

            if (gameScreenFrame.levelOneSectionOneScreen.thisSectionTime.getSectionTime() == 0) {
                gameScreenFrame.gameData.isGameFinish = true;
            }

            try {
                if (gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).getX() >= 6380) {// Go to Section Two
                    gameScreenFrame.setxLevelOneBackgroundPanel(-6800);

                }

                // Gravity:

                if (upMario) {// Mario start jumping

                    gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setVelocityY(gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).getVelocityY() + (Gravity.gravity * Gravity.dt));
                    gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setY((int) (gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).getY() + gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).getVelocityY()));
                    gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setMarioJumping(true);// Mario is jumping
                    if (gameScreenFrame.intersectMarioAndObjectsInSectionOne.marioHitsDownOfTheObject) {// Mario hits down of an object and comes back to ground
                        gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setVelocityY(0);
                        gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setY((gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).getY() + 2));
                    } else if (gameScreenFrame.intersectMarioAndObjectsInSectionOne.marioHitsUpOfTheObject) {// Mario hits up an object and stand on it
                        gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setVelocityY(0);
                        gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setY((gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).getY() - 2));
                        gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setMarioJumping(false);// Mario stop jumping
                        isUserPressedUp = false;
                    }

                    if (gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).getY() >= 840 && gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).getY() <= 860) {// Mario Hits Ground and Stop jumping
                        upMario = false;
                        isUserPressedUp = false;
                        gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setMarioJumping(false);
                    }

                }

                if (rightMario && !leftMario && !gameScreenFrame.intersectMarioAndObjectsInSectionOne.marioHitsLeftOfTheObject) {// Go Right
                    if (gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).getX() < 830 || gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).getX() >= 5800) {// Move Mario
                        gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setX(gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).getX() + 5);
                    } else {// Move Panel
                        int xLevelOneBackgroundPanel = gameScreenFrame.getxLevelOneBackgroundPanel();
                        gameScreenFrame.setxLevelOneBackgroundPanel(xLevelOneBackgroundPanel - 10);
                        gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setX(gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).getX() + 10);
                        gameScreenFrame.levelOneSectionOneScreen.XThisGameCoinImage += 10;
                        gameScreenFrame.levelOneSectionOneScreen.thisGameCoinImage.setX(gameScreenFrame.levelOneSectionOneScreen.XThisGameCoinImage);
                        gameScreenFrame.levelOneSectionOneScreen.XThisGameCoin += 10;
                        gameScreenFrame.levelOneSectionOneScreen.XThisSectionTimeLabel += 10;
                        gameScreenFrame.levelOneSectionOneScreen.XUserHeartImage += 10;
                        gameScreenFrame.levelOneSectionOneScreen.userHeartImage.setX(gameScreenFrame.levelOneSectionOneScreen.XUserHeartImage);
                        gameScreenFrame.levelOneSectionOneScreen.XUserScoreLabel += 10;
                        gameScreenFrame.levelOneSectionOneScreen.XUserHeartValueLabel += 10;
                    }
                }
                if (leftMario && !rightMario && !gameScreenFrame.intersectMarioAndObjectsInSectionOne.marioHitsRightOfTheObject) {// Go Left
                    if (gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).getX() < 840 || gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).getX() >= 5800) {// Move Mario
                        gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setX(gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).getX() - 5);
                    } else {// Move Panel
                        int xLevelOneBackgroundPanel = gameScreenFrame.getxLevelOneBackgroundPanel();
                        gameScreenFrame.setxLevelOneBackgroundPanel(xLevelOneBackgroundPanel + 10);
                        gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setX(gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).getX() - 10);
                        gameScreenFrame.levelOneSectionOneScreen.XThisGameCoinImage -= 10;
                        gameScreenFrame.levelOneSectionOneScreen.thisGameCoinImage.setX(gameScreenFrame.levelOneSectionOneScreen.XThisGameCoinImage);
                        gameScreenFrame.levelOneSectionOneScreen.XThisGameCoin -= 10;
                        gameScreenFrame.levelOneSectionOneScreen.XThisSectionTimeLabel -= 10;
                        gameScreenFrame.levelOneSectionOneScreen.XUserHeartImage -= 10;
                        gameScreenFrame.levelOneSectionOneScreen.userHeartImage.setX(gameScreenFrame.levelOneSectionOneScreen.XUserHeartImage);
                        gameScreenFrame.levelOneSectionOneScreen.XUserScoreLabel -= 10;
                        gameScreenFrame.levelOneSectionOneScreen.XUserHeartValueLabel -= 10;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {// Game is in SectionTwo

            if (gameScreenFrame.levelOneSectionTwoScreen.thisSectionTime.getSectionTime() == 0) {
                gameScreenFrame.gameData.isGameFinish = true;
            }

            if (!marioEnterInSectionTwo) {
                marioEnterInSectionTwo = true;
                gameScreenFrame.levelOneSectionTwoScreen.thisSectionTime.setSectionTime(100);
                // Add Score At The End Of SectionOne
                gameScreenFrame.calculateScore.calculateScoreInSectionOneLevelOne();
            }

            if (gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).getX() >= 6200) {// Level is Finish
                gameScreenFrame.gameData.isGameFinish = true;
            }

            try {

                // Gravity:

                if (upMario) {// Mario start jumping

                    gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setVelocityY(gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).getVelocityY() + (Gravity.gravity * Gravity.dt));
                    gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setY((int) (gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).getY() + gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).getVelocityY()));
                    gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setMarioJumping(true);// Mario is jumping
                    if (gameScreenFrame.intersectMarioAndObjectsInSectionTwo.marioHitsDownOfTheObject) {// Mario hits down of an object and comes back to ground
                        gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setVelocityY(0);
                        gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setY((gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).getY() + 2));
                    } else if (gameScreenFrame.intersectMarioAndObjectsInSectionTwo.marioHitsUpOfTheObject) {// Mario hits up an object and stand on it
                        gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setVelocityY(0);
                        gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setY((gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).getY() - 2));
                        gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setMarioJumping(false);// Mario stop jumping
                        isUserPressedUp = false;
                    }

                    if (gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).getY() >= 840 && gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).getY() <= 860) {// Mario Hits Ground and Stop jumping
                        upMario = false;
                        isUserPressedUp = false;
                        gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setMarioJumping(false);
                    }

                }


                if (rightMario && !leftMario && !gameScreenFrame.intersectMarioAndObjectsInSectionTwo.marioHitsLeftOfTheObject) {
                    if (gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).getX() < 830 || gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).getX() >= 5800) {// Move Mario
                        gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setX(gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).getX() + 5);
                    } else {// Move Panel
                        int xLevelOneBackgroundPanel = gameScreenFrame.getxLevelOneBackgroundPanel();
                        gameScreenFrame.setxLevelOneBackgroundPanel(xLevelOneBackgroundPanel - 10);
                        gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setX(gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).getX() + 10);
                        gameScreenFrame.levelOneSectionTwoScreen.XThisGameCoinImage += 10;
                        gameScreenFrame.levelOneSectionTwoScreen.thisGameCoinImage.setX(gameScreenFrame.levelOneSectionTwoScreen.XThisGameCoinImage);
                        gameScreenFrame.levelOneSectionTwoScreen.XThisGameCoin += 10;
                        gameScreenFrame.levelOneSectionTwoScreen.XThisSectionTimeLabel += 10;
                        gameScreenFrame.levelOneSectionTwoScreen.XUserHeartImage += 10;
                        gameScreenFrame.levelOneSectionTwoScreen.userHeartImage.setX(gameScreenFrame.levelOneSectionTwoScreen.XUserHeartImage);
                        gameScreenFrame.levelOneSectionTwoScreen.XUserScoreLabel += 10;
                        gameScreenFrame.levelOneSectionTwoScreen.XUserHeartValueLabel += 10;
                    }
                }
                if (leftMario && !rightMario && !gameScreenFrame.intersectMarioAndObjectsInSectionTwo.marioHitsRightOfTheObject) {
                    if (gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).getX() < 840 || gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).getX() >= 5800) {// Move Mario
                        gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setX(gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).getX() - 5);

                    } else {// Move Panel
                        int xLevelOneBackgroundPanel = gameScreenFrame.getxLevelOneBackgroundPanel();
                        gameScreenFrame.setxLevelOneBackgroundPanel(xLevelOneBackgroundPanel + 10);
                        gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setX(gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).getX() - 10);
                        gameScreenFrame.levelOneSectionTwoScreen.XThisGameCoinImage -= 10;
                        gameScreenFrame.levelOneSectionTwoScreen.thisGameCoinImage.setX(gameScreenFrame.levelOneSectionTwoScreen.XThisGameCoinImage);
                        gameScreenFrame.levelOneSectionTwoScreen.XThisGameCoin -= 10;
                        gameScreenFrame.levelOneSectionTwoScreen.XThisSectionTimeLabel -= 10;
                        gameScreenFrame.levelOneSectionTwoScreen.XUserHeartImage -= 10;
                        gameScreenFrame.levelOneSectionTwoScreen.userHeartImage.setX(gameScreenFrame.levelOneSectionTwoScreen.XUserHeartImage);
                        gameScreenFrame.levelOneSectionTwoScreen.XUserScoreLabel -= 10;
                        gameScreenFrame.levelOneSectionTwoScreen.XUserHeartValueLabel -= 10;
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
            gameScreenFrame.gameData.isGamePause = true;
//            MyProject.gameSaves.set(gameScreenFrame.gameData.gameSave,)
            MainMenuScreen mainMenuScreen = new MainMenuScreen();
            try {
                objectMapper.writeValue(new File("User.jason"), MyProject.allUsers);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getKeyChar() == 'w') {
            if (!isUserPressedUp) {
                upMario = true;
                gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setVelocityY(-10);
                gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setVelocityY(-10);
                isUserPressedUp = true;
            }
        }

        if (e.getKeyChar() == 's') {
            downMario = true;
        }

        if (e.getKeyChar() == 'a') {
            leftMario = true;
            gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setMarioRight(false);
            gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setMarioLeft(true);
            gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setMarioRight(false);
            gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setMarioLeft(true);
        }

        if (e.getKeyChar() == 'd') {
            rightMario = true;
            gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setMarioRight(true);
            gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setMarioLeft(false);
            gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setMarioRight(true);
            gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setMarioLeft(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {


        if (e.getKeyChar() == 'w') {
//            upMario = false;
        }

        if (e.getKeyChar() == 's') {
            downMario = false;
        }

        if (e.getKeyChar() == 'a') {
            leftMario = false;
            gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setMarioLeft(false);
            gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setMarioLeft(false);
        }

        if (e.getKeyChar() == 'd') {
            rightMario = false;
            gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setMarioRight(false);
            gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setMarioRight(false);
        }
    }

    public boolean isRightMario() {
        return rightMario;
    }

    public boolean isLeftMario() {
        return leftMario;
    }

    public boolean isUpMario() {
        return upMario;
    }

    public boolean isDownMario() {
        return downMario;
    }
}