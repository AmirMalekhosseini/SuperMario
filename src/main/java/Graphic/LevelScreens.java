package Graphic;

import Graphic.Vilgax.Vilgax;
import Model.GameData;

import javax.swing.*;
import java.util.ArrayList;

public class LevelScreens extends JLayeredPane {

    protected ArrayList<ObjectsInGame> objectsInThisSection = new ArrayList<>();
    protected ArrayList<ItemsInGame> itemsInThisSection = new ArrayList<>();
    protected volatile ArrayList<Enemy> enemiesInThisSection = new ArrayList<>();
    protected ArrayList<Bomb> bombsInThisSection = new ArrayList<>();
    protected volatile ArrayList<MarioWeapon> weaponsInThisSection = new ArrayList<>();
    protected ArrayList<EmptySpaceInGround> emptySpaceInGroundsInThisSection = new ArrayList<>();
    public Mario activeMario;
    GameData gameData;

    public UserHeart userHeartImage;
    public JLabel userHeartValueLabel;
    public JLabel userScoreLabel;
    public JLabel thisSectionTimeLabel;
    public JLabel thisGameCoin;
    public JLabel marioLocationLabel;
    public CoinForStore thisGameCoinImage;

    public int XUserHeartImage = 1520;
    public int XUserHeartValueLabel = 1510;
    public int XUserScoreLabel = 1345;
    public int XThisSectionTimeLabel = 1180;
    public int XThisGameCoin = 1080;
    public int XThisGameCoinImage = 1110;
    public int XMarioLocationLabel = 880;
    private boolean isScreenLock;


    public ArrayList<ObjectsInGame> getObjectsInThisSection() {
        return objectsInThisSection;
    }

    public void setObjectsInThisSection(ArrayList<ObjectsInGame> objectsInThisSection) {
        this.objectsInThisSection = objectsInThisSection;
    }

    public ArrayList<ItemsInGame> getItemsInThisSection() {
        return itemsInThisSection;
    }

    public void setItemsInThisSection(ArrayList<ItemsInGame> itemsInThisSection) {
        this.itemsInThisSection = itemsInThisSection;
    }

    public ArrayList<Enemy> getEnemiesInThisSection() {
        return enemiesInThisSection;
    }

    public void setEnemiesInThisSection(ArrayList<Enemy> enemiesInThisSection) {
        this.enemiesInThisSection = enemiesInThisSection;
    }

    public ArrayList<Bomb> getBombsInThisSection() {
        return bombsInThisSection;
    }

    public void setBombsInThisSection(ArrayList<Bomb> bombsInThisSection) {
        this.bombsInThisSection = bombsInThisSection;
    }

    public ArrayList<MarioWeapon> getWeaponsInThisSection() {
        return weaponsInThisSection;
    }

    public void setWeaponsInThisSection(ArrayList<MarioWeapon> weaponsInThisSection) {
        this.weaponsInThisSection = weaponsInThisSection;
    }

    public ArrayList<EmptySpaceInGround> getEmptySpaceInGroundsInThisSection() {
        return emptySpaceInGroundsInThisSection;
    }

    public void setEmptySpaceInGroundsInThisSection(ArrayList<EmptySpaceInGround> emptySpaceInGroundsInThisSection) {
        this.emptySpaceInGroundsInThisSection = emptySpaceInGroundsInThisSection;
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    public boolean isScreenLock() {
        return isScreenLock;
    }

    public void setScreenLock(boolean screenLock) {
        isScreenLock = screenLock;
    }
}
