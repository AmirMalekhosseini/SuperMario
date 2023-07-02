package Model;

import Graphic.*;

public class LevelOneSectionTwoModel extends NormalScreenModel {

    public LevelOneSectionTwoModel(GameGodFather godFather) {
        this.godFather = godFather;
        this.marioMoverModel = godFather.marioMoverModel;
        this.intersect = godFather.intersectInLevelOneSectionTwo;
        this.screen = godFather.getLevelOneSectionTwoScreen();

        controller = new ScreenController(godFather,screen, intersect, marioMoverModel) {
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

        if (!godFather.marioMoverModel.isMarioEnterInLevelTwoSectionOne()) {// Mario enters in New Section:
            godFather.getLevelOneGameBackgroundPanel().setVisible(false);
            godFather.activeLevel.levelPanel = godFather.getLevelTwoGameBackgroundPanel();
            godFather.activeLevel.levelPanel.setVisible(true);
            godFather.activeLevel.mario = godFather.getLevelTwoSectionOneScreen().activeMario;
            godFather.marioMoverModel.activeMario = godFather.activeLevel.mario;
            godFather.activeLevel.intersect = godFather.intersectInLevelTwoSectionOne;
            godFather.activeLevel.screen = godFather.getLevelTwoSectionOneScreen();
            godFather.activeLevel.screenModel = godFather.getLevelTwoSectionOneModel();
            godFather.gameTimer.setSectionTime(50);
            // Add Score At The End Of Section
            godFather.calculateScore.calculateScore(godFather.getLevelOneSectionTwoScreen());
            godFather.getPowerUp().loadPowerUp(godFather.marioMoverModel.activeMario);
            godFather.marioMoverModel.setMarioEnterInLevelTwoSectionOne(true);
            CheckPointSave.getCheckPointSave().save(godFather.activeLevel.screen);
            CheckPointSave.getCheckPointSave().saveXPanel(godFather.activeLevel.levelPanel.getX());
        }

    }
}
