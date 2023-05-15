package Model;

import Graphic.*;

public class CalculateScore {

    GameScreenFrame gameScreenFrame;

    public CalculateScore(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
    }
    public void calculateScoreInSectionOneLevelOne() {

        gameScreenFrame.getGameData().thisGameScore += gameScreenFrame.getLevelOneSectionOneScreen().thisSectionTime.getSectionTime();
        gameScreenFrame.getGameData().thisGameScore += gameScreenFrame.getGameData().userHeartValue * 20;
    }

    public void calculateScoreInSectionTwoLevelOne() {
        gameScreenFrame.getGameData().thisGameScore += gameScreenFrame.getLevelOneSectionOneScreen().thisSectionTime.getSectionTime();
        gameScreenFrame.getGameData().thisGameScore += gameScreenFrame.getGameData().userHeartValue * 20;
    }

}
