package Model;

import Graphic.LevelScreens;

public class ScreenModel {

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
