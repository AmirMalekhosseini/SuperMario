package Model;

import Graphic.*;

import java.util.ArrayList;

public class HiddenCoinSectionModel {

    HiddenCoinSectionScreen hiddenCoinSectionScreen;
    IntersectInHiddenCoinSection intersect;
    MarioMoverModel marioMoverModel;
    private volatile boolean cannonOneWorking = true;
    private volatile boolean cannonTwoWorking;
    private volatile boolean cannonThreeWorking;
    public volatile int coinCounter = 0;
    private int swordCoolDownCounter = 10;
    public Gravity gravity;

    public HiddenCoinSectionModel(HiddenCoinSectionScreen hiddenCoinSectionScreen, IntersectInHiddenCoinSection intersect, MarioMoverModel marioMoverModel) {
        this.marioMoverModel = marioMoverModel;
        this.intersect = intersect;
        this.hiddenCoinSectionScreen = hiddenCoinSectionScreen;
        gravityStarter();
    }

    public void gravityStarter() {
        gravity = new Gravity() {
            @Override
            public boolean isItemOnTopOfAnObject(ObjectsInGame object) {

                for (ObjectsInGame objects : hiddenCoinSectionScreen.getObjectsInThisSection()) {
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

                for (ItemsInGame itemsInGame : hiddenCoinSectionScreen.getItemsInThisSection()) {

                    // Object is on the Ground or On an Object:
                    if (gravity.isItemOnTopOfAnObject(itemsInGame) &&
                            (itemsInGame.getY() <= 920 - itemsInGame.getHeight())) {
                        int currentY = itemsInGame.getY();
                        itemsInGame.setY(currentY + 50);
                        try {
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        int currentX = itemsInGame.getX();
                        itemsInGame.setX(currentX - 50);
                    }

                }


            }
        };
    }

    public void moveShot() {

        ArrayList<MarioWeapon> weaponsInThisSection = hiddenCoinSectionScreen.getWeaponsInThisSection();
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
        for (int i = 0; i < hiddenCoinSectionScreen.getWeaponsInThisSection().size(); i++) {
            if (hiddenCoinSectionScreen.getWeaponsInThisSection().get(i) instanceof Arrow) {
                intersect.arrowIntersection(hiddenCoinSectionScreen.getWeaponsInThisSection().get(i));
            } else if (hiddenCoinSectionScreen.getWeaponsInThisSection().get(i) instanceof Sword) {
                intersect.swordIntersection(hiddenCoinSectionScreen.getWeaponsInThisSection().get(i));
            }
        }
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
