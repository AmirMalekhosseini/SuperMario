package Model;

import Graphic.*;

public class LevelOneSectionOneModel {

    LevelOneSectionOneScreen levelOneSectionOneScreen;
    IntersectInLevelOneSectionOne intersect;
    public Gravity gravity;

    public LevelOneSectionOneModel(LevelOneSectionOneScreen levelOneSectionOneScreen, IntersectInLevelOneSectionOne intersect) {
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

                for (ItemsInGame item : levelOneSectionOneScreen.getItemsInThisSection()) {

                    if (item instanceof Star && ((Star) item).isJumping()) {
                        continue;
                    }

                    // Object is on the Ground or On an Object:
                    if (gravity.isItemOnTopOfAnObject(item) &&
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

                for (Enemy enemy : levelOneSectionOneScreen.getEnemiesInThisSection()) {

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

        for (int i = 0; i < levelOneSectionOneScreen.getItemsInThisSection().size(); i++) {

            levelOneSectionOneScreen.getItemsInThisSection().get(i).move();
            // Item Changes its Direction:
            if (intersect.isItemHitAnObject
                    (levelOneSectionOneScreen.getItemsInThisSection().get(i))) {
                int velocity = levelOneSectionOneScreen.getItemsInThisSection().get(i).getXVelocity();
                levelOneSectionOneScreen.getItemsInThisSection().get(i).setXVelocity(-velocity);

            }
        }

    }

    public void moveEnemy() {

        for (int i = 0; i < levelOneSectionOneScreen.getEnemiesInThisSection().size(); i++) {

                /*
                To Do:
                send mario x,y,height to spiny
                 */
            levelOneSectionOneScreen.getEnemiesInThisSection().get(i).move();
            // Enemy Changes its Direction:
            if (intersect.isEnemyHitAnObject
                    (levelOneSectionOneScreen.getEnemiesInThisSection().get(i))) {
                double velocity = levelOneSectionOneScreen.getEnemiesInThisSection().get(i).getVelocity();
                levelOneSectionOneScreen.getEnemiesInThisSection().get(i).setVelocity(-velocity);

            }
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

}
