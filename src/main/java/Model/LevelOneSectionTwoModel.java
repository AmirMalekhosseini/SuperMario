package Model;

import Graphic.*;

public class LevelOneSectionTwoModel {

    LevelOneSectionTwoScreen levelOneSectionTwoScreen;
    IntersectInLevelOneSectionTwo intersect;
    public Gravity gravity;

    public LevelOneSectionTwoModel(LevelOneSectionTwoScreen levelOneSectionTwoScreen, IntersectInLevelOneSectionTwo intersect) {
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
                    int firstObjectHeight = object.getHeight() + 15;
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

                    //      overflow || intersectWithObjects
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

                    if (enemy instanceof Plant) {
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

            }
        };
    }

    public void moveItem() {

        for (int i = 0; i < levelOneSectionTwoScreen.getItemsInThisSection().size(); i++) {

            levelOneSectionTwoScreen.getItemsInThisSection().get(i).move();
            // Item Changes its Direction:
            if (intersect.isItemHitAnObject
                    (levelOneSectionTwoScreen.getItemsInThisSection().get(i))) {
                int velocity = levelOneSectionTwoScreen.getItemsInThisSection().get(i).getXVelocity();
                levelOneSectionTwoScreen.getItemsInThisSection().get(i).setXVelocity(-velocity);

            }
        }

    }

    public void moveEnemy() {

        for (int i = 0; i < levelOneSectionTwoScreen.getEnemiesInThisSection().size(); i++) {

                /*
                To Do:
                send mario x,y,height to spiny
                 */
            levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).move();
            // Enemy Changes its Direction:
            if (intersect.isEnemyHitAnObject
                    (levelOneSectionTwoScreen.getEnemiesInThisSection().get(i))) {
                double velocity = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getVelocity();
                levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).setVelocity(-velocity);

            }
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
