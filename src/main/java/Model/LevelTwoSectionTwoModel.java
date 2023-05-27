package Model;

import Graphic.*;

import java.util.ArrayList;

public class LevelTwoSectionTwoModel {

    LevelTwoSectionTwoScreen levelTwoSectionTwoScreen;
    IntersectInLevelTwoSectionTwo intersect;
    public Gravity gravity;

    public LevelTwoSectionTwoModel(LevelTwoSectionTwoScreen levelTwoSectionTwoScreen, IntersectInLevelTwoSectionTwo intersect) {
        this.intersect = intersect;
        this.levelTwoSectionTwoScreen = levelTwoSectionTwoScreen;
        gravityStarter();
    }

    public void gravityStarter() {

        gravity = new Gravity() {
            @Override
            public boolean isItemOnTopOfAnObject(ObjectsInGame object) {

                for (ObjectsInGame objects : levelTwoSectionTwoScreen.getObjectsInThisSection()) {
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

                for (ItemsInGame itemsInGame : levelTwoSectionTwoScreen.getItemsInThisSection()) {

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

                for (Enemy enemy : levelTwoSectionTwoScreen.getEnemiesInThisSection()) {

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

                ArrayList<BirdBomb> bombInThisSection = levelTwoSectionTwoScreen.getBombsInThisSection();
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

        for (int i = 0; i < levelTwoSectionTwoScreen.getItemsInThisSection().size(); i++) {

            levelTwoSectionTwoScreen.getItemsInThisSection().get(i).move();
            // Item Changes its Direction:
            if (intersect.isItemHitAnObject
                    (levelTwoSectionTwoScreen.getItemsInThisSection().get(i))) {
                int velocity = levelTwoSectionTwoScreen.getItemsInThisSection().get(i).getXVelocity();
                levelTwoSectionTwoScreen.getItemsInThisSection().get(i).setXVelocity(-velocity);

            }
        }

    }

    public void moveEnemy() {

        for (int i = 0; i < levelTwoSectionTwoScreen.getEnemiesInThisSection().size(); i++) {

            // send mario x,y,height to spiny
            if (levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i) instanceof Spiny) {
                int marioX = levelTwoSectionTwoScreen.activeMario.get(0).getX();
                int marioY = levelTwoSectionTwoScreen.activeMario.get(0).getY();
                int marioHeight = levelTwoSectionTwoScreen.activeMario.get(0).getHeight();
                ((Spiny) levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i)).setMarioX(marioX);
                ((Spiny) levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i)).setMarioY(marioY);
                ((Spiny) levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i)).setMarioHeight(marioHeight);
            }

            if (levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i) instanceof Bird &&
                    ((Bird) levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i)).isThrowBomb()) {
                ((Bird) levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i)).setThrowBomb(false);
                int xBomb = levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).getX();
                int yBomb = levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).getY() + 200;
                BirdBomb bomb = new BirdBomb(xBomb, yBomb);
                levelTwoSectionTwoScreen.add(bomb, Integer.valueOf(1));
                levelTwoSectionTwoScreen.getBombsInThisSection().add(bomb);
            }

            levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).move();
            // Enemy Changes its Direction:
            if (intersect.isEnemyHitAnObject
                    (levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i))) {
                double velocity = levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).getVelocity();
                levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).setVelocity(-velocity);

            }
        }

        for (int i = 0; i < levelTwoSectionTwoScreen.getBombsInThisSection().size(); i++) {
            intersect.bombIntersection(levelTwoSectionTwoScreen.getBombsInThisSection().get(i));
        }

    }

    public void setLocationOfEnemies() {

        for (int i = 0; i < levelTwoSectionTwoScreen.getEnemiesInThisSection().size(); i++) {
            int x = levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).getX();
            int y = levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).getY();
            levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).setLocation(x, y);

        }
    }

    public void setLocationAfterLoose() {

        levelTwoSectionTwoScreen.activeMario.get(0).setX(100);
        levelTwoSectionTwoScreen.XUserHeartImage = 1520;
        levelTwoSectionTwoScreen.userHeartImage.setX(levelTwoSectionTwoScreen.XUserHeartImage);
        levelTwoSectionTwoScreen.XThisGameCoinImage = 1110;
        levelTwoSectionTwoScreen.thisGameCoinImage.setX(levelTwoSectionTwoScreen.XThisGameCoinImage);
        levelTwoSectionTwoScreen.XThisGameCoin = 1080;
        levelTwoSectionTwoScreen.XUserHeartValueLabel = 1510;
        levelTwoSectionTwoScreen.XThisSectionTimeLabel = 1180;
        levelTwoSectionTwoScreen.XUserScoreLabel = 1345;

    }

}
