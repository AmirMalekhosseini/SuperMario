package Model;

import Graphic.*;

public class LevelOneSectionOneModel extends NormalScreenModel {

    public LevelOneSectionOneModel(GameGodFather godFather) {
        this.godFather = godFather;
        this.marioMoverModel = godFather.marioMoverModel;
        this.intersect = godFather.intersectInLevelOneSectionOne;
        this.screen = godFather.getLevelOneSectionOneScreen();

        controller = new ScreenController(godFather, LevelOneSectionOneModel.this.screen, intersect, marioMoverModel) {
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

        if (!godFather.marioMoverModel.isMarioEnterInLevelOneSectionTwo()) {// Mario Enter in SectionTwo:
            godFather.getLevelOneGameBackgroundPanel().setLocation(-6800, 0);
            godFather.activeLevel.mario = godFather.getLevelOneSectionTwoScreen().activeMario;
            godFather.marioMoverModel.activeMario = godFather.activeLevel.mario;
            godFather.activeLevel.intersect = godFather.intersectInLevelOneSectionTwo;
            godFather.activeLevel.screen = godFather.getLevelOneSectionTwoScreen();
            godFather.activeLevel.screenModel = godFather.getLevelOneSectionTwoModel();
            godFather.gameTimer.setSectionTime(50);
            // Add Score At The End Of SectionOne
            godFather.calculateScore.calculateScore(godFather.getLevelOneSectionOneScreen());
            godFather.getPowerUp().loadPowerUp(godFather.marioMoverModel.activeMario);
            godFather.marioMoverModel.setMarioEnterInLevelOneSectionTwo(true);
            CheckPointSave.getCheckPointSave().save(godFather.activeLevel.screen);
            CheckPointSave.getCheckPointSave().saveXPanel(godFather.activeLevel.levelPanel.getX());
        }

    }
}
