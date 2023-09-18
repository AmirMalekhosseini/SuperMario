package Model.Game;

import Controller.Game.CheckPointSave;
import Controller.Game.ScreenController;

public class HiddenEnemySectionModel extends ScreenModel {

    private volatile boolean cannonOneWorking = true;
    private volatile boolean cannonTwoWorking;
    private volatile boolean cannonThreeWorking;
    public volatile int enemyCounter = 0;

    public HiddenEnemySectionModel(GameGodFather godFather) {
        this.godFather = godFather;
        this.marioMoverController = godFather.marioMoverController;
        this.intersect = godFather.intersectInHiddenEnemySection;
        this.screen = godFather.getHiddenEnemySectionScreen();
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

        godFather.activeLevel.getLevelPanel().setVisible(false);
        godFather.activeLevel.setLevelPanel(godFather.levelTwoGameBackgroundPanel);
        godFather.activeLevel.getLevelPanel().setVisible(true);
        godFather.activeLevel.setMario(godFather.getLevelTwoSectionTwoScreen().activeMario);
        godFather.marioMoverController.activeMario = godFather.activeLevel.getMario();
        godFather.activeLevel.setIntersect(godFather.intersectInLevelTwoSectionTwo);
        godFather.activeLevel.setScreen(godFather.getLevelTwoSectionTwoScreen());
        godFather.activeLevel.setScreenModel(godFather.getLevelTwoSectionTwoModel());

        // Load time
        godFather.gameTimer.setSectionTime(godFather.gameTimer.getSaveTime());
        godFather.getPowerUp().loadPowerUp(godFather.marioMoverController.activeMario);
        godFather.marioMoverController.setMarioEnterInLevelTwoSectionTwo(true);
        CheckPointSave.getCheckPointSave().save(godFather.activeLevel.getScreen());
        CheckPointSave.getCheckPointSave().saveXPanel(godFather.activeLevel.getLevelPanel().getX());

    }
}
