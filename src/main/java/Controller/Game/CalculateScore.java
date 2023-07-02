package Controller.Game;

import View.Game.LevelScreens;
import Model.Game.GameGodFather;

public class CalculateScore {

    GameGodFather gameGodFather;

    public CalculateScore(GameGodFather gameGodFather) {
        this.gameGodFather = gameGodFather;
    }

    public CalculateScore() {

    }
    public void calculateScore(LevelScreens screen) {

        gameGodFather.getGameData().thisGameScore += gameGodFather.gameTimer.getSectionTime();
        gameGodFather.getGameData().thisGameScore += screen.getGameData().userHeartValue * 20;
    }

    public GameGodFather getGameScreenFrame() {
        return gameGodFather;
    }

    public void setGameScreenFrame(GameGodFather gameGodFather) {
        this.gameGodFather = gameGodFather;
    }
}
