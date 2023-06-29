package Model;

import Graphic.*;

public class HiddenEnemySectionModel extends ScreenModel {

    private volatile boolean cannonOneWorking = true;
    private volatile boolean cannonTwoWorking;
    private volatile boolean cannonThreeWorking;
    public volatile int enemyCounter = 0;

    public HiddenEnemySectionModel(HiddenEnemySectionScreen hiddenEnemySectionScreen,IntersectInHiddenEnemySection intersect,MarioMoverModel marioMoverModel) {
        this.marioMoverModel = marioMoverModel;
        this.intersect = intersect;
        this.screen = hiddenEnemySectionScreen;

        controller =new ScreenController(screen, intersect, marioMoverModel) {
            @Override
            public void gravityStarter() {
                super.gravityStarter();
            }

            @Override
            public void moveItem() {
                super.moveItem();
            }

            @Override
            public void moveEnemy() {
                super.moveEnemy();
            }

            @Override
            public void moveShot() {
                super.moveShot();
            }

            @Override
            public void startThrowSword() {
                super.startThrowSword();
            }

            @Override
            public void setLocationAfterLoose() {
                super.setLocationAfterLoose();
            }

            @Override
            public int getSwordCoolDownCounter() {
                return super.getSwordCoolDownCounter();
            }

            @Override
            public void setSwordCoolDownCounter(int swordCoolDownCounter) {
                super.setSwordCoolDownCounter(swordCoolDownCounter);
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
