package Graphic;

import Model.GameData;
import Model.SectionsTime;

import javax.swing.*;
import java.util.ArrayList;

public class LevelScreens extends JLayeredPane {

    protected ArrayList<ObjectsInGame> objectsInThisSection = new ArrayList<>();
    protected ArrayList<ItemsInGame> itemsInThisSection = new ArrayList<>();
    protected volatile ArrayList<Enemy> enemiesInThisSection = new ArrayList<>();
    protected ArrayList<BirdBomb> bombsInThisSection = new ArrayList<>();
    protected volatile ArrayList<MarioWeapon> weaponsInThisSection = new ArrayList<>();
    protected ArrayList<EmptySpaceInGround> emptySpaceInGroundsInThisSection = new ArrayList<>();
    public ArrayList<Mario> activeMario;
    public SectionsTime thisSectionTime;
    GameData gameData;

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

    public ArrayList<BirdBomb> getBombsInThisSection() {
        return bombsInThisSection;
    }

    public void setBombsInThisSection(ArrayList<BirdBomb> bombsInThisSection) {
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

    public ArrayList<Mario> getActiveMario() {
        return activeMario;
    }

    public void setActiveMario(ArrayList<Mario> activeMario) {
        this.activeMario = activeMario;
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }
}
