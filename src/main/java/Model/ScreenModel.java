package Model;

import Graphic.GameGodFather;
import Graphic.LevelScreens;

public class ScreenModel {

    GameGodFather godFather;
    LevelScreens screen;
    IntersectInGame intersect;
    MarioMoverModel marioMoverModel;
    protected int swordCoolDownCounter = 10;
    public ScreenController controller;

    public int getSwordCoolDownCounter() {
        return swordCoolDownCounter;
    }

    public void setSwordCoolDownCounter(int swordCoolDownCounter) {
        this.swordCoolDownCounter = swordCoolDownCounter;
    }
}
