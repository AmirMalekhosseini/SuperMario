package Model.Game;

import Controller.Game.CheckPointSave;
import Controller.Game.ScreenController;

public class LevelOneSectionOneModel extends NormalScreenModel {

    public LevelOneSectionOneModel(GameGodFather godFather) {
        this.godFather = godFather;
        this.marioMoverController = godFather.marioMoverController;
        this.intersect = godFather.intersectInLevelOneSectionOne;
        this.screen = godFather.getLevelOneSectionOneScreen();

        controller = new ScreenController(godFather, LevelOneSectionOneModel.this.screen, intersect, marioMoverController) {
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

    @Override
    public void goToHiddenSection() {

    }

    @Override
    public void goToNextSection() {

        if (!godFather.marioMoverController.isMarioEnterInLevelOneSectionTwo()) {// Mario Enter in SectionTwo:
            godFather.getLevelOneGameBackgroundPanel().setLocation(-6800, 0);
            godFather.activeLevel.setMario(godFather.getLevelOneSectionTwoScreen().activeMario);
            godFather.marioMoverController.activeMario = godFather.activeLevel.getMario();
            godFather.activeLevel.setIntersect(godFather.intersectInLevelOneSectionTwo);
            godFather.activeLevel.setScreen(godFather.getLevelOneSectionTwoScreen());
            godFather.activeLevel.setScreenModel(godFather.getLevelOneSectionTwoModel());
            godFather.gameTimer.setSectionTime(50);
            // Add Score At The End Of SectionOne
            godFather.calculateScore.calculateScore(godFather.getLevelOneSectionOneScreen());
            godFather.getPowerUp().loadPowerUp(godFather.marioMoverController.activeMario);
            godFather.marioMoverController.setMarioEnterInLevelOneSectionTwo(true);
            CheckPointSave.getCheckPointSave().save(godFather.activeLevel.getScreen());
            CheckPointSave.getCheckPointSave().saveXPanel(godFather.activeLevel.getLevelPanel().getX());
        }

    }
}
