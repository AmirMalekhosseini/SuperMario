package Model;

import Graphic.*;

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

                for (ItemsInGame itemsInGame : levelTwoSectionTwoScreen.getItemsInThisSection()) {

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

    public void moveEnemy() {

        for (int i = 0; i < levelTwoSectionTwoScreen.getEnemiesInThisSection().size(); i++) {

                /*
                To Do:
                send mario x,y,height to spiny
                 */
            levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).move();
            // Enemy Changes its Direction:
            if (intersect.isEnemyHitAnObject
                    (levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i))) {
                double velocity = levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).getVelocity();
                levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).setVelocity(-velocity);

            }
        }

    }

    public void setLocationOfEnemies() {

        for (int i = 0; i < levelTwoSectionTwoScreen.getEnemiesInThisSection().size(); i++) {
            int x = levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).getX();
            int y = levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).getY();
            levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).setLocation(x, y);

        }
    }

}
