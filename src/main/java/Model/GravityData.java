package Model;

import Graphic.GameScreenFrame;

public class GravityData {

    public static final int gravity = 10;
    public static final double dt = 0.018;

    GameScreenFrame gameScreenFrame;

    public GravityData(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
    }

    public GravityData() {

    }

    public GameScreenFrame getGameScreenFrame() {
        return gameScreenFrame;
    }

    public void setGameScreenFrame(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
    }
}
