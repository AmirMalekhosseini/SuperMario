package Model;

import Graphic.GameScreenFrame;

public class Gravity {

    public static final int gravity = 10;
    public static final double dt = 0.018;

    GameScreenFrame gameScreenFrame;

    public Gravity(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
    }

    public Gravity() {

    }

    public GameScreenFrame getGameScreenFrame() {
        return gameScreenFrame;
    }

    public void setGameScreenFrame(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
    }
}
