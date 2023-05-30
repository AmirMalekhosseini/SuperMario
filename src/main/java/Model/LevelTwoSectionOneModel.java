package Model;

import Graphic.*;

import java.util.ArrayList;

public class LevelTwoSectionOneModel {

    LevelTwoSectionOneScreen levelTwoSectionOneScreen;
    IntersectInLevelTwoSectionOne intersect;
    MarioMoverModel marioMoverModel;
    private int swordCoolDownCounter = 10;
    public Gravity gravity;

    public LevelTwoSectionOneModel(LevelTwoSectionOneScreen levelTwoSectionOneScreen, IntersectInLevelTwoSectionOne intersect, MarioMoverModel marioMoverModel) {
        this.marioMoverModel = marioMoverModel;
        this.intersect = intersect;
        this.levelTwoSectionOneScreen = levelTwoSectionOneScreen;
        gravityStarter();
    }

    public void gravityStarter() {

        gravity = new Gravity() {
            @Override
            public boolean isItemOnTopOfAnObject(ObjectsInGame object) {

                for (ObjectsInGame objects : levelTwoSectionOneScreen.getObjectsInThisSection()) {
                    int firstObjectWidth = object.getWidth();
                    int firstObjectHeight = object.getHeight() + 5;
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
                            return false;
                        }
                    }
                }
                return true;
            }

            @Override
            public void allocateGravity() {

                for (ItemsInGame itemsInGame : levelTwoSectionOneScreen.getItemsInThisSection()) {

                    if (itemsInGame instanceof Star && ((Star) itemsInGame).isJumping()) {
                        continue;
                    }

                    // Object is on the Ground or On an Object:
                    if (gravity.isItemOnTopOfAnObject(itemsInGame) &&
                            (itemsInGame.getY() <= 920 - itemsInGame.getHeight())) {
                        int currentY = itemsInGame.getY();
                        itemsInGame.setY(currentY + 10);
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }

                for (Enemy enemy : levelTwoSectionOneScreen.getEnemiesInThisSection()) {

                    if (enemy instanceof Plant || enemy instanceof Bird) {
                        continue;
                    }
                    if (gravity.isItemOnTopOfAnObject(enemy) &&
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

                ArrayList<BirdBomb> bombInThisSection = levelTwoSectionOneScreen.getBombsInThisSection();
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

        for (int i = 0; i < levelTwoSectionOneScreen.getItemsInThisSection().size(); i++) {

            levelTwoSectionOneScreen.getItemsInThisSection().get(i).move();
            // Item Changes its Direction:
            if (intersect.isItemHitAnObject
                    (levelTwoSectionOneScreen.getItemsInThisSection().get(i))) {
                int velocity = levelTwoSectionOneScreen.getItemsInThisSection().get(i).getXVelocity();
                levelTwoSectionOneScreen.getItemsInThisSection().get(i).setXVelocity(-velocity);

            }
        }

    }

    public void moveEnemy() {

        for (int i = 0; i < levelTwoSectionOneScreen.getEnemiesInThisSection().size(); i++) {

            // send mario x,y,height to spiny
            if (levelTwoSectionOneScreen.getEnemiesInThisSection().get(i) instanceof Spiny) {
                int marioX = levelTwoSectionOneScreen.activeMario.get(0).getX();
                int marioY = levelTwoSectionOneScreen.activeMario.get(0).getY();
                int marioHeight = levelTwoSectionOneScreen.activeMario.get(0).getHeight();
                ((Spiny) levelTwoSectionOneScreen.getEnemiesInThisSection().get(i)).setMarioX(marioX);
                ((Spiny) levelTwoSectionOneScreen.getEnemiesInThisSection().get(i)).setMarioY(marioY);
                ((Spiny) levelTwoSectionOneScreen.getEnemiesInThisSection().get(i)).setMarioHeight(marioHeight);
            }

            if (levelTwoSectionOneScreen.getEnemiesInThisSection().get(i) instanceof Bird &&
                    ((Bird) levelTwoSectionOneScreen.getEnemiesInThisSection().get(i)).isThrowBomb()) {
                ((Bird) levelTwoSectionOneScreen.getEnemiesInThisSection().get(i)).setThrowBomb(false);
                int xBomb = levelTwoSectionOneScreen.getEnemiesInThisSection().get(i).getX();
                int yBomb = levelTwoSectionOneScreen.getEnemiesInThisSection().get(i).getY() + 200;
                BirdBomb bomb = new BirdBomb(xBomb, yBomb);
                levelTwoSectionOneScreen.add(bomb, Integer.valueOf(1));
                levelTwoSectionOneScreen.getBombsInThisSection().add(bomb);
            }


            levelTwoSectionOneScreen.getEnemiesInThisSection().get(i).move();
            // Enemy Changes its Direction:
            if (intersect.isEnemyHitAnObject
                    (levelTwoSectionOneScreen.getEnemiesInThisSection().get(i))) {
                double velocity = levelTwoSectionOneScreen.getEnemiesInThisSection().get(i).getVelocity();
                levelTwoSectionOneScreen.getEnemiesInThisSection().get(i).setVelocity(-velocity);

            }
        }

        for (int i = 0; i < levelTwoSectionOneScreen.getBombsInThisSection().size(); i++) {
            intersect.bombIntersection(levelTwoSectionOneScreen.getBombsInThisSection().get(i));
        }

    }

    public void moveShot() {

        ArrayList<MarioWeapon> weaponsInThisSection = levelTwoSectionOneScreen.getWeaponsInThisSection();
        for (MarioWeapon marioWeapon : weaponsInThisSection) {
            marioWeapon.move();
        }

    }

    public void startThrowSword() {
        swordCoolDownCounter++;
        if (marioMoverModel.isUserPressedUp() && marioMoverModel.isUserPressedDown() && swordCoolDownCounter >= 200) {
            marioMoverModel.setMarioThrowSword(true);
            marioMoverModel.marioStartsThrowsSword();
            marioMoverModel.setUserPressedDown(false);
            swordCoolDownCounter = 0;
        }
    }

    public void intersectShot() {
        for (int i = 0; i < levelTwoSectionOneScreen.getWeaponsInThisSection().size(); i++) {
            if (levelTwoSectionOneScreen.getWeaponsInThisSection().get(i) instanceof Arrow) {
                intersect.arrowIntersection(levelTwoSectionOneScreen.getWeaponsInThisSection().get(i));
            } else if (levelTwoSectionOneScreen.getWeaponsInThisSection().get(i) instanceof Sword) {
                intersect.swordIntersection(levelTwoSectionOneScreen.getWeaponsInThisSection().get(i));
            }
        }
    }


    public void setLocationOfEnemies() {

        for (int i = 0; i < levelTwoSectionOneScreen.getEnemiesInThisSection().size(); i++) {
            int x = levelTwoSectionOneScreen.getEnemiesInThisSection().get(i).getX();
            int y = levelTwoSectionOneScreen.getEnemiesInThisSection().get(i).getY();
            levelTwoSectionOneScreen.getEnemiesInThisSection().get(i).setLocation(x, y);

        }
    }

    public void setLocationAfterLoose() {

        levelTwoSectionOneScreen.activeMario.get(0).setX(100);
        levelTwoSectionOneScreen.XUserHeartImage = 1520;
        levelTwoSectionOneScreen.userHeartImage.setX(levelTwoSectionOneScreen.XUserHeartImage);
        levelTwoSectionOneScreen.XThisGameCoinImage = 1110;
        levelTwoSectionOneScreen.thisGameCoinImage.setX(levelTwoSectionOneScreen.XThisGameCoinImage);
        levelTwoSectionOneScreen.XThisGameCoin = 1080;
        levelTwoSectionOneScreen.XUserHeartValueLabel = 1510;
        levelTwoSectionOneScreen.XThisSectionTimeLabel = 1180;
        levelTwoSectionOneScreen.XUserScoreLabel = 1345;

    }

}
