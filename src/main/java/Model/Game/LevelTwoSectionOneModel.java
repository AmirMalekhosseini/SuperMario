package Model.Game;

import Controller.Game.CheckPointSave;
import Controller.Game.ScreenController;

public class LevelTwoSectionOneModel extends NormalScreenModel {

    public LevelTwoSectionOneModel(GameGodFather godFather) {
        this.godFather = godFather;
        this.marioMoverController = godFather.marioMoverController;
        this.intersect = godFather.intersectInLevelTwoSectionOne;
        this.screen = godFather.getLevelTwoSectionOneScreen();

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


    @Override
    public void goToHiddenSection() {

    }

    @Override
    public void goToNextSection() {

        if (!godFather.marioMoverController.isMarioEnterInLevelTwoSectionTwo()) {// Mario Enter in SectionTwo:
            godFather.getLevelTwoGameBackgroundPanel().setLocation(-6800, 0);
            godFather.activeLevel.setMario(godFather.getLevelTwoSectionTwoScreen().activeMario);
            godFather.marioMoverController.activeMario = godFather.activeLevel.getMario();
            godFather.activeLevel.setIntersect(godFather.intersectInLevelTwoSectionTwo);
            godFather.activeLevel.setScreen(godFather.getLevelTwoSectionTwoScreen());
            godFather.activeLevel.setScreenModel(godFather.getLevelTwoSectionTwoModel());
            godFather.gameTimer.setSectionTime(50);
            // Add Score At The End Of SectionOne
            godFather.calculateScore.calculateScore(godFather.getLevelTwoSectionOneScreen());
            godFather.getPowerUp().loadPowerUp(godFather.marioMoverController.activeMario);
            godFather.marioMoverController.setMarioEnterInLevelTwoSectionTwo(true);
            CheckPointSave.getCheckPointSave().save(godFather.activeLevel.getScreen());
            CheckPointSave.getCheckPointSave().saveXPanel(godFather.activeLevel.getLevelPanel().getX());
        }

    }
}
