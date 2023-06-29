package Model;

import Graphic.GameGodFather;
import Graphic.LevelScreens;
import Graphic.Mario;

import javax.swing.*;

public class ActiveLevel {

    GameGodFather godFather;
    JPanel levelPanel;
    LevelScreens screen;
    ScreenModel screenModel;
    IntersectInGame intersect;
    Mario mario;

    public ActiveLevel(GameGodFather godFather) {
        this.godFather = godFather;
        levelPanel = godFather.getLevelThreeGameBackgroundPanel();
    }


}
