package Model;

import Graphic.*;

public class CalculateScore {

    GameScreenFrame gameScreenFrame;

    public CalculateScore(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
    }

    public CalculateScore() {

    }
    public void calculateScore(LevelScreens screen) {

        gameScreenFrame.getGameData().thisGameScore += screen.thisSectionTime.getSectionTime();
        gameScreenFrame.getGameData().thisGameScore += screen.getGameData().userHeartValue * 20;
    }

    public GameScreenFrame getGameScreenFrame() {
        return gameScreenFrame;
    }

    public void setGameScreenFrame(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
    }
}
