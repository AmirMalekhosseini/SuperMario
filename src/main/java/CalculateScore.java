public class CalculateScore {

    GameScreenFrame gameScreenFrame;

    CalculateScore(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
    }
    public void calculateScoreInSectionOneLevelOne() {

        gameScreenFrame.gameData.thisGameScore += gameScreenFrame.levelOneSectionOneScreen.thisSectionTime.getSectionTime();
        gameScreenFrame.gameData.thisGameScore += gameScreenFrame.gameData.userHeartValue * 20;
    }

    public void calculateScoreInSectionTwoLevelOne() {
        gameScreenFrame.gameData.thisGameScore += gameScreenFrame.levelOneSectionOneScreen.thisSectionTime.getSectionTime();
        gameScreenFrame.gameData.thisGameScore += gameScreenFrame.gameData.userHeartValue * 20;
    }

}
