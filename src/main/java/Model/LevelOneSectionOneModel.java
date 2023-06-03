package Model;

import Graphic.*;

import java.util.ArrayList;

public class LevelOneSectionOneModel {

    LevelOneSectionOneScreen levelOneSectionOneScreen;
    IntersectInLevelOneSectionOne intersect;
    MarioMoverModel marioMoverModel;
    private int swordCoolDownCounter = 10;
    public Gravity gravity;

    public LevelOneSectionOneModel(LevelOneSectionOneScreen levelOneSectionOneScreen, IntersectInLevelOneSectionOne intersect, MarioMoverModel marioMoverModel) {
        this.marioMoverModel = marioMoverModel;
        this.intersect = intersect;
        this.levelOneSectionOneScreen = levelOneSectionOneScreen;
        gravityStarter();
    }

    public void gravityStarter() {

        gravity = new Gravity() {
            @Override
            public boolean isItemOnTopOfAnObject(ObjectsInGame object) {

                for (ObjectsInGame objects : levelOneSectionOneScreen.getObjectsInThisSection()) {
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

                for (ItemsInGame item : levelOneSectionOneScreen.getItemsInThisSection()) {

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

                ArrayList<Enemy> enemiesInThisSection = levelOneSectionOneScreen.getEnemiesInThisSection();
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

                ArrayList<BirdBomb> bombInThisSection = levelOneSectionOneScreen.getBombsInThisSection();
                for (int i = 0; i < bombInThisSection.size(); i++) {
                    BirdBomb bomb = bombInThisSection.get(i);

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

        for (int i = 0; i < levelOneSectionOneScreen.getItemsInThisSection().size(); i++) {

            levelOneSectionOneScreen.getItemsInThisSection().get(i).move();
            // Item Changes its Direction:
            if (intersect.intersection.isItemHitAnObject
                    (levelOneSectionOneScreen.getItemsInThisSection().get(i))) {
                int velocity = levelOneSectionOneScreen.getItemsInThisSection().get(i).getXVelocity();
                levelOneSectionOneScreen.getItemsInThisSection().get(i).setXVelocity(-velocity);

            }
        }

    }

    public void moveEnemy() {

        for (int i = 0; i < levelOneSectionOneScreen.getEnemiesInThisSection().size(); i++) {

            // send mario x,y,height to spiny
            if (levelOneSectionOneScreen.getEnemiesInThisSection().get(i) instanceof Spiny) {
                int marioX = levelOneSectionOneScreen.activeMario.get(0).getX();
                int marioY = levelOneSectionOneScreen.activeMario.get(0).getY();
                int marioHeight = levelOneSectionOneScreen.activeMario.get(0).getHeight();
                ((Spiny) levelOneSectionOneScreen.getEnemiesInThisSection().get(i)).setMarioX(marioX);
                ((Spiny) levelOneSectionOneScreen.getEnemiesInThisSection().get(i)).setMarioY(marioY);
                ((Spiny) levelOneSectionOneScreen.getEnemiesInThisSection().get(i)).setMarioHeight(marioHeight);
            }

            if (levelOneSectionOneScreen.getEnemiesInThisSection().get(i) instanceof Bird &&
                    ((Bird) levelOneSectionOneScreen.getEnemiesInThisSection().get(i)).isThrowBomb()) {
                ((Bird) levelOneSectionOneScreen.getEnemiesInThisSection().get(i)).setThrowBomb(false);
                int xBomb = levelOneSectionOneScreen.getEnemiesInThisSection().get(i).getX();
                int yBomb = levelOneSectionOneScreen.getEnemiesInThisSection().get(i).getY() + 200;
                BirdBomb bomb = new BirdBomb(xBomb, yBomb);
                levelOneSectionOneScreen.add(bomb, Integer.valueOf(1));
                levelOneSectionOneScreen.getBombsInThisSection().add(bomb);
            }

            levelOneSectionOneScreen.getEnemiesInThisSection().get(i).move();
            // Enemy Changes its Direction:
            if (intersect.intersection.isEnemyHitAnObject
                    (levelOneSectionOneScreen.getEnemiesInThisSection().get(i))) {
                double velocity = levelOneSectionOneScreen.getEnemiesInThisSection().get(i).getVelocity();
                levelOneSectionOneScreen.getEnemiesInThisSection().get(i).setVelocity(-velocity);

            }
        }

        for (int i = 0; i < levelOneSectionOneScreen.getBombsInThisSection().size(); i++) {
            intersect.intersection.bombIntersection(levelOneSectionOneScreen.getBombsInThisSection().get(i));
        }

    }

    public void moveShot() {

        ArrayList<MarioWeapon> weaponsInThisSection = levelOneSectionOneScreen.getWeaponsInThisSection();
        for (MarioWeapon marioWeapon : weaponsInThisSection) {
            marioWeapon.move();
        }

    }

    public void startThrowSword() {
        swordCoolDownCounter++;
        if (marioMoverModel.isUserPressedUp() && marioMoverModel.isUserPressedDown() && swordCoolDownCounter >= 200) {
            marioMoverModel.setMarioThrowSword(true);
            marioMoverModel.marioStartsThrowsSword();
            swordCoolDownCounter = 0;
        }
    }

    public void setLocationOfEnemies() {

        for (int i = 0; i < levelOneSectionOneScreen.getEnemiesInThisSection().size(); i++) {
            int x = levelOneSectionOneScreen.getEnemiesInThisSection().get(i).getX();
            int y = levelOneSectionOneScreen.getEnemiesInThisSection().get(i).getY();
            levelOneSectionOneScreen.getEnemiesInThisSection().get(i).setLocation(x, y);

        }
    }

    public void setLocationAfterLoose() {

        levelOneSectionOneScreen.activeMario.get(0).setX(100);
        levelOneSectionOneScreen.XUserHeartImage = 1520;
        levelOneSectionOneScreen.userHeartImage.setX(levelOneSectionOneScreen.XUserHeartImage);
        levelOneSectionOneScreen.XThisGameCoinImage = 1110;
        levelOneSectionOneScreen.thisGameCoinImage.setX(levelOneSectionOneScreen.XThisGameCoinImage);
        levelOneSectionOneScreen.XThisGameCoin = 1080;
        levelOneSectionOneScreen.XUserHeartValueLabel = 1510;
        levelOneSectionOneScreen.XThisSectionTimeLabel = 1180;
        levelOneSectionOneScreen.XUserScoreLabel = 1345;

    }

    public int getSwordCoolDownCounter() {
        return swordCoolDownCounter;
    }

    public void setSwordCoolDownCounter(int swordCoolDownCounter) {
        this.swordCoolDownCounter = swordCoolDownCounter;
    }
}
