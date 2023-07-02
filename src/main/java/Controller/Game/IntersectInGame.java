package Controller.Game;

import Model.Game.GameGodFather;
import View.Game.LevelScreens;

public class IntersectInGame {

    GameGodFather gameGodFather;
    LevelScreens levelScreen;
    PowerUp powerUp;
    public Intersection intersection;

    public GameGodFather getGameScreenFrame() {
        return gameGodFather;
    }

    public void setGameScreenFrame(GameGodFather gameGodFather) {
        this.gameGodFather = gameGodFather;
    }

    public LevelScreens getLevelScreen() {
        return levelScreen;
    }

    public void setLevelScreen(LevelScreens levelScreen) {
        this.levelScreen = levelScreen;
    }

    public PowerUp getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }

}
