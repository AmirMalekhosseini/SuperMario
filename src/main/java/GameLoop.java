import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GameLoop {

    ObjectMapper objectMapper;
    GameScreenFrame gameScreenFrame;

    private boolean stopTimer;
    public GameLoop(GameScreenFrame gameScreenFrame) {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        this.gameScreenFrame = gameScreenFrame;
        final Timer timer = new Timer(5, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!gameScreenFrame.gameData.isGameFinish) {
                    int xLevelOneBackgroundPanel = gameScreenFrame.getxLevelOneBackgroundPanel();
                    gameScreenFrame.levelOneGameBackgroundPanel.setLocation(xLevelOneBackgroundPanel, 0);
                    setLocationOfEnemiesInSectionOneLevelOne();
                    setLocationOfEnemiesInSectionTwoLevelOne();
                    gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setLocation(gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).getX(), gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).getY());
                    gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setLocation(gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).getX(), gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).getY());
                    gameScreenFrame.marioMover.move();
                    gameScreenFrame.intersectMarioAndObjectsInSectionOne.refreshIntersectsBooleans();
                    gameScreenFrame.intersectMarioAndObjectsInSectionOne.intersect();
                    gameScreenFrame.intersectMarioAndObjectsInSectionOne.intersectWithCoin();
                    if (gameScreenFrame.intersectMarioAndObjectsInSectionOne.intersectWithEnemies()) {
                        setLocationAfterLooseInSectionOneLevelOne();
                    }
                    if (gameScreenFrame.intersectMarioAndObjectsInSectionOne.intersectWithEmptyGround()) {
                        setLocationAfterLooseInSectionOneLevelOne();
                    }
                    gameScreenFrame.intersectMarioAndObjectsInSectionTwo.refreshIntersectsBooleans();
                    gameScreenFrame.intersectMarioAndObjectsInSectionTwo.intersect();
                    gameScreenFrame.intersectMarioAndObjectsInSectionTwo.intersectWithCoin();
                    if (gameScreenFrame.intersectMarioAndObjectsInSectionTwo.intersectWithEnemies()) {
                        setLocationAfterLooseInSectionTwoLevelOne();
                    }
                    if (gameScreenFrame.intersectMarioAndObjectsInSectionTwo.intersectWithEmptyGround()) {
                        setLocationAfterLooseInSectionTwoLevelOne();
                    }
                    setGameDataInLevelOne();
                    gameScreenFrame.setFocusable(true);
                    gameScreenFrame.requestFocusInWindow();
                    gameScreenFrame.requestFocus();
                    if (gameScreenFrame.gameData.userHeartValue == 0) {
                        gameScreenFrame.gameData.isGameFinish = true;
                    }
                }

                else {// Finish the Game
                    gameScreenFrame.calculateScore.calculateScoreInSectionTwoLevelOne();
                    Score thisGameScore = new Score();
                    thisGameScore.setUserScore(gameScreenFrame.gameData.thisGameScore);
                    MyProject.activeUser.get(0).setUserCoinValue(MyProject.activeUser.get(0).getUserCoinValue() +gameScreenFrame.gameData.thisGameCoin);
                    MyProject.activeUser.get(0).userScore.add(thisGameScore);
                    if (MyProject.activeUser.get(0).userHighScore.getUserScore() <= thisGameScore.getUserScore()) {
                        MyProject.activeUser.get(0).userHighScore = thisGameScore;
                    }

                    gameScreenFrame.dispose();
                    MainMenuScreen mainMenuScreen = new MainMenuScreen();
                    ((Timer)e.getSource()).stop();

                    try {
                        objectMapper.writeValue(new File("User.jason"), MyProject.allUsers);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                }

                if (gameScreenFrame.gameData.isGamePause) {

                }

            }
        });
        timer.setRepeats(true);
        timer.start();

    }

    public void setLocationOfEnemiesInSectionOneLevelOne() {

        for (int i = 0; i < gameScreenFrame.levelOneSectionOneScreen.enemiesInThisSection.size(); i++) {
            int x = gameScreenFrame.levelOneSectionOneScreen.enemiesInThisSection.get(i).getX();
            int y = gameScreenFrame.levelOneSectionOneScreen.enemiesInThisSection.get(i).getY();
            gameScreenFrame.levelOneSectionOneScreen.enemiesInThisSection.get(i).setLocation(x, y);

        }
    }

    public void setLocationOfEnemiesInSectionTwoLevelOne() {

        for (int i = 0; i < gameScreenFrame.levelOneSectionTwoScreen.enemiesInThisSection.size(); i++) {
            int x = gameScreenFrame.levelOneSectionTwoScreen.enemiesInThisSection.get(i).getX();
            int y = gameScreenFrame.levelOneSectionTwoScreen.enemiesInThisSection.get(i).getY();
            gameScreenFrame.levelOneSectionTwoScreen.enemiesInThisSection.get(i).setLocation(x, y);

        }
    }

    public void setLocationAfterLooseInSectionOneLevelOne() {

        gameScreenFrame.setxLevelOneBackgroundPanel(0);
        gameScreenFrame.levelOneSectionOneScreen.activeMario.get(0).setX(100);
        gameScreenFrame.levelOneSectionOneScreen.XUserHeartImage = 1520;
        gameScreenFrame.levelOneSectionOneScreen.userHeartImage.setX(gameScreenFrame.levelOneSectionOneScreen.XUserHeartImage);
        gameScreenFrame.levelOneSectionOneScreen.XThisGameCoinImage = 1110;
        gameScreenFrame.levelOneSectionOneScreen.thisGameCoinImage.setX(gameScreenFrame.levelOneSectionOneScreen.XThisGameCoinImage);
        gameScreenFrame.levelOneSectionOneScreen.XThisGameCoin = 1080;
        gameScreenFrame.levelOneSectionOneScreen.XUserHeartValueLabel = 1510;
        gameScreenFrame.levelOneSectionOneScreen.XThisSectionTimeLabel = 1180;
        gameScreenFrame.levelOneSectionOneScreen.XUserScoreLabel = 1345;

    }

    public void setLocationAfterLooseInSectionTwoLevelOne() {

        gameScreenFrame.setxLevelOneBackgroundPanel(-6800);
        gameScreenFrame.levelOneSectionTwoScreen.activeMario.get(0).setX(100);
        gameScreenFrame.levelOneSectionTwoScreen.XUserHeartImage = 1520;
        gameScreenFrame.levelOneSectionTwoScreen.userHeartImage.setX(gameScreenFrame.levelOneSectionTwoScreen.XUserHeartImage);
        gameScreenFrame.levelOneSectionTwoScreen.XThisGameCoinImage = 1110;
        gameScreenFrame.levelOneSectionTwoScreen.thisGameCoinImage.setX(gameScreenFrame.levelOneSectionTwoScreen.XThisGameCoinImage);
        gameScreenFrame.levelOneSectionTwoScreen.XThisGameCoin = 1080;
        gameScreenFrame.levelOneSectionTwoScreen.XUserHeartValueLabel = 1510;
        gameScreenFrame.levelOneSectionTwoScreen.XThisSectionTimeLabel = 1180;
        gameScreenFrame.levelOneSectionTwoScreen.XUserScoreLabel = 1345;

    }

    public void setGameDataInLevelOne() {

        gameScreenFrame.levelOneSectionOneScreen.userHeartValueLabel.setText(String.valueOf(gameScreenFrame.gameData.userHeartValue));
        gameScreenFrame.levelOneSectionOneScreen.thisGameCoin.setText(String.valueOf(gameScreenFrame.gameData.thisGameCoin));
        gameScreenFrame.levelOneSectionOneScreen.userScoreLabel.setText("Score: " + String.valueOf(gameScreenFrame.gameData.thisGameScore));
        gameScreenFrame.levelOneSectionTwoScreen.userHeartValueLabel.setText(String.valueOf(gameScreenFrame.gameData.userHeartValue));
        gameScreenFrame.levelOneSectionTwoScreen.thisGameCoin.setText(String.valueOf(gameScreenFrame.gameData.thisGameCoin));
        gameScreenFrame.levelOneSectionTwoScreen.userScoreLabel.setText("Score: " + String.valueOf(gameScreenFrame.gameData.thisGameScore));
        gameScreenFrame.levelOneSectionOneScreen.userHeartValueLabel.setLocation(gameScreenFrame.levelOneSectionOneScreen.XUserHeartValueLabel, 30);
        gameScreenFrame.levelOneSectionOneScreen.userHeartImage.setLocation(gameScreenFrame.levelOneSectionOneScreen.XUserHeartImage, 30);
        gameScreenFrame.levelOneSectionOneScreen.userScoreLabel.setLocation(gameScreenFrame.levelOneSectionOneScreen.XUserScoreLabel, 30);
        gameScreenFrame.levelOneSectionOneScreen.thisSectionTimeLabel.setLocation(gameScreenFrame.levelOneSectionOneScreen.XThisSectionTimeLabel, 30);
        gameScreenFrame.levelOneSectionOneScreen.thisGameCoin.setLocation(gameScreenFrame.levelOneSectionOneScreen.XThisGameCoin, 27);
        gameScreenFrame.levelOneSectionOneScreen.thisGameCoinImage.setLocation(gameScreenFrame.levelOneSectionOneScreen.XThisGameCoinImage, 30);
        gameScreenFrame.levelOneSectionTwoScreen.userHeartValueLabel.setLocation(gameScreenFrame.levelOneSectionTwoScreen.XUserHeartValueLabel, 30);
        gameScreenFrame.levelOneSectionTwoScreen.userHeartImage.setLocation(gameScreenFrame.levelOneSectionTwoScreen.XUserHeartImage, 30);
        gameScreenFrame.levelOneSectionTwoScreen.userScoreLabel.setLocation(gameScreenFrame.levelOneSectionTwoScreen.XUserScoreLabel, 30);
        gameScreenFrame.levelOneSectionTwoScreen.thisSectionTimeLabel.setLocation(gameScreenFrame.levelOneSectionTwoScreen.XThisSectionTimeLabel, 30);
        gameScreenFrame.levelOneSectionTwoScreen.thisGameCoin.setLocation(gameScreenFrame.levelOneSectionTwoScreen.XThisGameCoin, 27);
        gameScreenFrame.levelOneSectionTwoScreen.thisGameCoinImage.setLocation(gameScreenFrame.levelOneSectionTwoScreen.XThisGameCoinImage, 30);

    }

}
