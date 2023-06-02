package Model;

import Graphic.*;

import java.util.ArrayList;

public class LevelOneSectionTwoModel {

    LevelOneSectionTwoScreen levelOneSectionTwoScreen;
    IntersectInLevelOneSectionTwo intersect;
    MarioMoverModel marioMoverModel;
    private int swordCoolDownCounter = 10;
    public Gravity gravity;

    public LevelOneSectionTwoModel(LevelOneSectionTwoScreen levelOneSectionTwoScreen, IntersectInLevelOneSectionTwo intersect, MarioMoverModel marioMoverModel) {
        this.marioMoverModel = marioMoverModel;
        this.intersect = intersect;
        this.levelOneSectionTwoScreen = levelOneSectionTwoScreen;
        gravityStarter();
    }

    public void gravityStarter() {

        gravity = new Gravity() {
            @Override
            public boolean isItemOnTopOfAnObject(ObjectsInGame object) {

                for (ObjectsInGame objects : levelOneSectionTwoScreen.getObjectsInThisSection()) {
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

                for (ItemsInGame itemsInGame : levelOneSectionTwoScreen.getItemsInThisSection()) {

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

                for (Enemy enemy : levelOneSectionTwoScreen.getEnemiesInThisSection()) {

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

                ArrayList<BirdBomb> bombInThisSection = levelOneSectionTwoScreen.getBombsInThisSection();
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

        for (int i = 0; i < levelOneSectionTwoScreen.getItemsInThisSection().size(); i++) {

            levelOneSectionTwoScreen.getItemsInThisSection().get(i).move();
            // Item Changes its Direction:
            if (intersect.intersection.isItemHitAnObject
                    (levelOneSectionTwoScreen.getItemsInThisSection().get(i))) {
                int velocity = levelOneSectionTwoScreen.getItemsInThisSection().get(i).getXVelocity();
                levelOneSectionTwoScreen.getItemsInThisSection().get(i).setXVelocity(-velocity);

            }
        }

    }

    public void moveEnemy() {

        for (int i = 0; i < levelOneSectionTwoScreen.getEnemiesInThisSection().size(); i++) {

            // send mario x,y,height to spiny
            if (levelOneSectionTwoScreen.getEnemiesInThisSection().get(i) instanceof Spiny) {
                int marioX = levelOneSectionTwoScreen.activeMario.get(0).getX();
                int marioY = levelOneSectionTwoScreen.activeMario.get(0).getY();
                int marioHeight = levelOneSectionTwoScreen.activeMario.get(0).getHeight();
                ((Spiny) levelOneSectionTwoScreen.getEnemiesInThisSection().get(i)).setMarioX(marioX);
                ((Spiny) levelOneSectionTwoScreen.getEnemiesInThisSection().get(i)).setMarioY(marioY);
                ((Spiny) levelOneSectionTwoScreen.getEnemiesInThisSection().get(i)).setMarioHeight(marioHeight);
            }

            if (levelOneSectionTwoScreen.getEnemiesInThisSection().get(i) instanceof Bird &&
                    ((Bird) levelOneSectionTwoScreen.getEnemiesInThisSection().get(i)).isThrowBomb()) {
                ((Bird) levelOneSectionTwoScreen.getEnemiesInThisSection().get(i)).setThrowBomb(false);
                int xBomb = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getX();
                int yBomb = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getY() + 200;
                BirdBomb bomb = new BirdBomb(xBomb, yBomb);
                levelOneSectionTwoScreen.add(bomb, Integer.valueOf(1));
                levelOneSectionTwoScreen.getBombsInThisSection().add(bomb);
            }

            levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).move();
            // Enemy Changes its Direction:
            if (intersect.intersection.isEnemyHitAnObject
                    (levelOneSectionTwoScreen.getEnemiesInThisSection().get(i))) {
                double velocity = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getVelocity();
                levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).setVelocity(-velocity);

            }
        }

        for (int i = 0; i < levelOneSectionTwoScreen.getBombsInThisSection().size(); i++) {
            intersect.intersection.bombIntersection(levelOneSectionTwoScreen.getBombsInThisSection().get(i));
        }

    }

    public void moveShot() {

        ArrayList<MarioWeapon> weaponsInThisSection = levelOneSectionTwoScreen.getWeaponsInThisSection();
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

    public void setLocationOfEnemies() {

        for (int i = 0; i < levelOneSectionTwoScreen.getEnemiesInThisSection().size(); i++) {
            int x = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getX();
            int y = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getY();
            levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).setLocation(x, y);

        }
    }

    public void setLocationAfterLoose() {

        levelOneSectionTwoScreen.activeMario.get(0).setX(100);
        levelOneSectionTwoScreen.XUserHeartImage = 1520;
        levelOneSectionTwoScreen.userHeartImage.setX(levelOneSectionTwoScreen.XUserHeartImage);
        levelOneSectionTwoScreen.XThisGameCoinImage = 1110;
        levelOneSectionTwoScreen.thisGameCoinImage.setX(levelOneSectionTwoScreen.XThisGameCoinImage);
        levelOneSectionTwoScreen.XThisGameCoin = 1080;
        levelOneSectionTwoScreen.XUserHeartValueLabel = 1510;
        levelOneSectionTwoScreen.XThisSectionTimeLabel = 1180;
        levelOneSectionTwoScreen.XUserScoreLabel = 1345;

    }

}
