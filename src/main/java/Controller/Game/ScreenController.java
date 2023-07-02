package Controller.Game;

import View.Game.LevelScreens;
import Model.Enemy.*;
import Model.Game.GameGodFather;
import Model.Game.Gravity;
import Model.Item.ItemsInGame;
import Model.Item.MoverItemsInGame;
import Model.Item.Star;
import Model.Mario.MarioWeapon;
import Model.Mario.Shield;
import Model.Object.ObjectsInGame;

import java.util.ArrayList;

public abstract class ScreenController {

    GameGodFather godFather;
    LevelScreens screen;
    IntersectInGame intersect;
    MarioMoverController marioMoverController;
    public Gravity gravity;

    public ScreenController(GameGodFather godFather, LevelScreens screen, IntersectInGame intersect, MarioMoverController marioMoverController) {
        this.godFather = godFather;
        this.screen = screen;
        this.intersect = intersect;
        this.marioMoverController = marioMoverController;
        gravityStarter();
    }

    public void gravityStarter() {

        gravity = new Gravity() {
            @Override
            public boolean isItemOnTopOfAnObject(ObjectsInGame object) {

                for (ObjectsInGame objects : screen.getObjectsInThisSection()) {
                    int firstObjectWidth = object.getWidth();
                    int firstObjectHeight = object.getHeight();
                    if (object instanceof ItemsInGame) {
                        firstObjectHeight += 15;
                    }
                    int secondObjectWidth = objects.getWidth();
                    int secondObjectHeight = objects.getHeight();
                    if (secondObjectWidth <= 0 || secondObjectHeight <= 0 || firstObjectWidth <= 0 || firstObjectHeight <= 0) {
                        continue;
                    }
                    int firstObjectX = object.getX();
                    int firstObjectY = object.getY();
                    int secondObjectX = objects.getX();
                    int secondObjectY = objects.getY();
                    secondObjectWidth += secondObjectX;
                    secondObjectHeight += secondObjectY;
                    firstObjectWidth += firstObjectX;
                    firstObjectHeight += firstObjectY;

                    //      overflow || marioIntersectWithObjects
                    if ((secondObjectWidth < secondObjectX || secondObjectWidth > firstObjectX) &&
                            (secondObjectHeight < secondObjectY || secondObjectHeight > firstObjectY) &&
                            (firstObjectWidth < firstObjectX || firstObjectWidth > secondObjectX) &&
                            (firstObjectHeight < firstObjectY || firstObjectHeight > secondObjectY)) {

                        if ((firstObjectWidth >= secondObjectX || secondObjectWidth >= firstObjectX) && firstObjectHeight <= secondObjectY + 10) {// Hit up of Object
                            return true;
                        }
                    }
                }
                return false;
            }

            @Override
            public void allocateGravity() {

                for (ItemsInGame item : screen.getItemsInThisSection()) {

                    if (item instanceof Star && ((Star) item).isJumping()) {
                        continue;
                    }

                    // Object is on the Ground or On an Object:
                    if (!gravity.isItemOnTopOfAnObject(item) &&
                            (item.getY() <= 920 - item.getHeight())) {
                        int currentY = item.getY();
                        item.setY(currentY + 10);
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }

                ArrayList<Enemy> enemiesInThisSection = screen.getEnemiesInThisSection();
                for (int i = 0; i < enemiesInThisSection.size(); i++) {
                    Enemy enemy = enemiesInThisSection.get(i);

                    if (enemy instanceof Plant || enemy instanceof Bird) {
                        continue;
                    }
                    if (!gravity.isItemOnTopOfAnObject(enemy) &&
                            (enemy.getY() <= 940 - enemy.getHeight())) {
                        // Object is not on the Ground or On an Object:
                        int currentY = enemy.getY();
                        enemy.setY(currentY + 10);
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

                ArrayList<Bomb> bombInThisSection = screen.getBombsInThisSection();
                for (int i = 0; i < bombInThisSection.size(); i++) {
                    Bomb bomb = bombInThisSection.get(i);

                    if (!gravity.isItemOnTopOfAnObject(bomb) &&
                            (bomb.getY() <= 940 - bomb.getHeight())) {
                        // Object is not on the Ground or On an Object:
                        int currentY = bomb.getY();
                        bomb.setY(currentY + 10);
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            }
        };
    }

    public void moveItem() {

        for (int i = 0; i < screen.getItemsInThisSection().size(); i++) {

            if (screen.getItemsInThisSection().get(i) instanceof MoverItemsInGame) {
                ((MoverItemsInGame) screen.getItemsInThisSection().get(i)).move();
            }

            // Item Changes its Direction:
            if (intersect.intersection.isItemHitAnObject
                    (screen.getItemsInThisSection().get(i))) {
                int velocity = screen.getItemsInThisSection().get(i).getXVelocity();
                screen.getItemsInThisSection().get(i).setXVelocity(-velocity);

            }
        }

    }

    public void moveEnemy() {

        for (int i = 0; i < screen.getEnemiesInThisSection().size(); i++) {

            // send mario x,y,height to spiny
            if (screen.getEnemiesInThisSection().get(i) instanceof Spiny) {
                int marioX = screen.activeMario.getX();
                int marioY = screen.activeMario.getY();
                int marioHeight = screen.activeMario.getHeight();
                ((Spiny) screen.getEnemiesInThisSection().get(i)).setMarioX(marioX);
                ((Spiny) screen.getEnemiesInThisSection().get(i)).setMarioY(marioY);
                ((Spiny) screen.getEnemiesInThisSection().get(i)).setMarioHeight(marioHeight);
            }

            if (screen.getEnemiesInThisSection().get(i) instanceof Bird &&
                    ((Bird) screen.getEnemiesInThisSection().get(i)).isThrowBomb()) {
                ((Bird) screen.getEnemiesInThisSection().get(i)).setThrowBomb(false);
                int xBomb = screen.getEnemiesInThisSection().get(i).getX();
                int yBomb = screen.getEnemiesInThisSection().get(i).getY() + 200;
                Bomb bomb = new Bomb(xBomb, yBomb);
                screen.add(bomb, Integer.valueOf(1));
                screen.getBombsInThisSection().add(bomb);
            }

            screen.getEnemiesInThisSection().get(i).move();
            screen.getEnemiesInThisSection().get(i).changeBackground();

            // Enemy Changes its Direction:
            if (intersect.intersection.isEnemyHitAnObject
                    (screen.getEnemiesInThisSection().get(i))) {
                double velocity = screen.getEnemiesInThisSection().get(i).getVelocity();
                screen.getEnemiesInThisSection().get(i).setVelocity(-velocity);

            }
        }

        for (int i = 0; i < screen.getBombsInThisSection().size(); i++) {
            intersect.intersection.bombIntersection(screen.getBombsInThisSection().get(i));
        }

    }

    public void checkAddShield() {

        if (screen.activeMario.isMarioGotShield()) {
            Shield shield = new Shield(screen.activeMario.getX() - 55, screen.activeMario.getY() - 40);
            screen.getWeaponsInThisSection().add(shield);
            screen.add(shield, Integer.valueOf(1));
            screen.activeMario.setMarioGotShield(false);
            godFather.gameTimer.shieldCounter.counter = 0;
        }

    }

    public void checkRemoveShield() {

        // Remove Shield
        if (godFather.gameTimer.shieldCounter.counter == 15) {
            for (MarioWeapon weapon : screen.getWeaponsInThisSection()) {
                if (weapon instanceof Shield) {
                    screen.remove(weapon);
                    screen.remove(weapon);
                    break;
                }
            }
            godFather.gameTimer.shieldCounter.counter = 18;
        }

    }

    public void moveShot() {

        for (MarioWeapon marioWeapon : screen.getWeaponsInThisSection()) {
            marioWeapon.moveWeapon(screen.activeMario);
        }

    }

    public void startThrowSword() {
        if (marioMoverController.isUserPressedUp() && marioMoverController.isUserPressedDown()) {
            marioMoverController.setMarioThrowSword(true);
            marioMoverController.marioStartsThrowsSword();
        }
    }

    public void setLocationAfterLoose() {

        CheckPointSave.getCheckPointSave().load(screen);
        godFather.activeLevel.getLevelPanel().setLocation(CheckPointSave.getCheckPointSave().loadXPanel(), 0);
        // To Stand On Block:
        godFather.marioMoverController.setUpMario(true);

    }

}
