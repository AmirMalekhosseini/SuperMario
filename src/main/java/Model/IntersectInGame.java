package Model;

import Graphic.GameScreenFrame;
import Graphic.LevelScreens;

public class IntersectInGame {

    GameScreenFrame gameScreenFrame;
    LevelScreens levelScreen;
    PowerUp powerUp;
    public Intersection intersection;

    public GameScreenFrame getGameScreenFrame() {
        return gameScreenFrame;
    }

    public void setGameScreenFrame(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
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
