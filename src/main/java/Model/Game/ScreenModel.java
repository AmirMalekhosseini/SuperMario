package Model.Game;

import Controller.Game.IntersectInGame;
import Controller.Game.MarioMoverController;
import Controller.Game.ScreenController;
import View.Game.LevelScreens;

public abstract class ScreenModel {

    GameGodFather godFather;
    LevelScreens screen;
    IntersectInGame intersect;
    MarioMoverController marioMoverController;
    public ScreenController controller;
    public boolean isHitPipe;

    public abstract void goToHiddenSection();


}
