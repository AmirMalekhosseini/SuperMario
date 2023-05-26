package Model;

import Graphic.Enemy;
import Graphic.HiddenEnemySectionScreen;
import Graphic.ObjectsInGame;

public class HiddenEnemySectionModel {

    HiddenEnemySectionScreen hiddenEnemySectionScreen;
    private volatile boolean cannonOneWorking = true;
    private volatile boolean cannonTwoWorking;
    private volatile boolean cannonThreeWorking;
    public volatile int enemyCounter = 0;
    public Gravity gravity;

    public HiddenEnemySectionModel(HiddenEnemySectionScreen hiddenEnemySectionScreen) {
        this.hiddenEnemySectionScreen = hiddenEnemySectionScreen;
        gravityStarter();
    }

    public void gravityStarter() {
        gravity = new Gravity() {
            @Override
            public boolean isItemOnTopOfAnObject(ObjectsInGame object) {

                for (ObjectsInGame objects : hiddenEnemySectionScreen.getObjectsInThisSection()) {
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

                for (Enemy enemiesInGame : hiddenEnemySectionScreen.getEnemiesInThisSection()) {

                    // Object is on the Ground or On an Object:
                    if (gravity.isItemOnTopOfAnObject(enemiesInGame) &&
                            (enemiesInGame.getY() <= 920 - enemiesInGame.getHeight())) {
                        int currentY = enemiesInGame.getY();
                        enemiesInGame.setY(currentY + 50);
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        int currentX = enemiesInGame.getX();
                        enemiesInGame.setX(currentX - 50);
                    }

                }


            }
        };
    }

    public boolean isCannonOneWorking() {
        return cannonOneWorking;
    }

    public void setCannonOneWorking(boolean cannonOneWorking) {
        this.cannonOneWorking = cannonOneWorking;
    }

    public boolean isCannonTwoWorking() {
        return cannonTwoWorking;
    }

    public void setCannonTwoWorking(boolean cannonTwoWorking) {
        this.cannonTwoWorking = cannonTwoWorking;
    }

    public boolean isCannonThreeWorking() {
        return cannonThreeWorking;
    }

    public void setCannonThreeWorking(boolean cannonThreeWorking) {
        this.cannonThreeWorking = cannonThreeWorking;
    }
}
