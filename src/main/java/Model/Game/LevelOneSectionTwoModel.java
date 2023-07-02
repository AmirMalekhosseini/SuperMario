package Model.Game;

import Controller.Game.CheckPointSave;
import Controller.Game.ScreenController;

public class LevelOneSectionTwoModel extends NormalScreenModel {

    public LevelOneSectionTwoModel(GameGodFather godFather) {
        this.godFather = godFather;
        this.marioMoverController = godFather.marioMoverController;
        this.intersect = godFather.intersectInLevelOneSectionTwo;
        this.screen = godFather.getLevelOneSectionTwoScreen();

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

        if (!godFather.marioMoverController.isMarioEnterInLevelTwoSectionOne()) {// Mario enters in New Section:
            godFather.getLevelOneGameBackgroundPanel().setVisible(false);
            godFather.activeLevel.setLevelPanel(godFather.getLevelTwoGameBackgroundPanel());
            godFather.activeLevel.getLevelPanel().setVisible(true);
            godFather.activeLevel.setMario(godFather.getLevelTwoSectionOneScreen().activeMario);
            godFather.marioMoverController.activeMario = godFather.activeLevel.getMario();
            godFather.activeLevel.setIntersect(godFather.intersectInLevelTwoSectionOne);
            godFather.activeLevel.setScreen(godFather.getLevelTwoSectionOneScreen());
            godFather.activeLevel.setScreenModel(godFather.getLevelTwoSectionOneModel());
            godFather.gameTimer.setSectionTime(50);
            // Add Score At The End Of Section
            godFather.calculateScore.calculateScore(godFather.getLevelOneSectionTwoScreen());
            godFather.getPowerUp().loadPowerUp(godFather.marioMoverController.activeMario);
            godFather.marioMoverController.setMarioEnterInLevelTwoSectionOne(true);
            CheckPointSave.getCheckPointSave().save(godFather.activeLevel.getScreen());
            CheckPointSave.getCheckPointSave().saveXPanel(godFather.activeLevel.getLevelPanel().getX());
        }

    }
}
