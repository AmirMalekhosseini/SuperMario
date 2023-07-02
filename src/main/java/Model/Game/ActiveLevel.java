package Model.Game;

import Controller.Game.IntersectInGame;
import View.Game.LevelScreens;
import Model.Mario.Mario;

import javax.swing.*;

public class ActiveLevel {

    GameGodFather godFather;
    private JPanel levelPanel;
    private LevelScreens screen;
    private ScreenModel screenModel;
    private IntersectInGame intersect;
    private Mario mario;

    public ActiveLevel(GameGodFather godFather) {
        this.godFather = godFather;
        levelPanel = godFather.getLevelOneGameBackgroundPanel();
    }

    public JPanel getLevelPanel() {
        return levelPanel;
    }

    public void setLevelPanel(JPanel levelPanel) {
        this.levelPanel = levelPanel;
    }

    public LevelScreens getScreen() {
        return screen;
    }

    public void setScreen(LevelScreens screen) {
        this.screen = screen;
    }

    public ScreenModel getScreenModel() {
        return screenModel;
    }

    public void setScreenModel(ScreenModel screenModel) {
        this.screenModel = screenModel;
    }

    public IntersectInGame getIntersect() {
        return intersect;
    }

    public void setIntersect(IntersectInGame intersect) {
        this.intersect = intersect;
    }

    public Mario getMario() {
        return mario;
    }

    public void setMario(Mario mario) {
        this.mario = mario;
    }
}
