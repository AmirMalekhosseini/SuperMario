package Model;

import Graphic.*;
public class Game {

    GameScreenFrame gameScreenFrame;

    public Game(GameScreenFrame gameScreenFrame) {

        this.gameScreenFrame = gameScreenFrame;
    }

    public Game() {

    }

    public GameScreenFrame getGameScreenFrame() {
        return gameScreenFrame;
    }

    public void setGameScreenFrame(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
    }
}
