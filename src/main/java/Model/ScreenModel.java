package Model;

import Graphic.GameGodFather;
import Graphic.LevelScreens;

public abstract class ScreenModel {

    GameGodFather godFather;
    LevelScreens screen;
    IntersectInGame intersect;
    MarioMoverModel marioMoverModel;
    public ScreenController controller;

    public abstract void goToHiddenSection();

}
