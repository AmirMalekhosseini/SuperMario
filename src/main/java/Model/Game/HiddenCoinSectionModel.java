package Model.Game;

import Controller.Game.ScreenController;

public class HiddenCoinSectionModel extends ScreenModel {

    private volatile boolean cannonOneWorking = true;
    private volatile boolean cannonTwoWorking;
    private volatile boolean cannonThreeWorking;
    public volatile int coinCounter = 0;

    public HiddenCoinSectionModel(GameGodFather godFather) {
        this.godFather = godFather;
        this.marioMoverController = godFather.marioMoverController;
        this.intersect = godFather.intersectInHiddenCoinSection;
        this.screen = godFather.getHiddenCoinSectionScreen();

        controller = new ScreenController(godFather,screen, intersect, marioMoverController) {
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
            public void checkAddShield() {
                super.checkAddShield();
            }

            @Override
            public void checkRemoveShield() {
                super.checkRemoveShield();
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

    @Override
    public void goToHiddenSection() {

    }
}
