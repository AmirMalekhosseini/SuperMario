package Model;

import Graphic.*;
public class Game {

    GameGodFather gameGodFather;

    public Game(GameGodFather gameGodFather) {

        this.gameGodFather = gameGodFather;
    }

    public Game() {

    }

    public GameGodFather getGameScreenFrame() {
        return gameGodFather;
    }

    public void setGameScreenFrame(GameGodFather gameGodFather) {
        this.gameGodFather = gameGodFather;
    }
}
