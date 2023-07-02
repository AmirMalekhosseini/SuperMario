package Model;

import Graphic.*;

public class LevelTwoSectionTwoModel extends NormalScreenModel {

    public LevelTwoSectionTwoModel(GameGodFather godFather) {
        this.godFather = godFather;
        this.marioMoverModel = godFather.marioMoverModel;
        this.intersect = godFather.intersectInLevelTwoSectionTwo;
        this.screen = godFather.getLevelTwoSectionTwoScreen();

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

        if (!godFather.marioMoverModel.isMarioEnterInBossSection()) {// Mario enters in New Section:
            godFather.getLevelTwoGameBackgroundPanel().setVisible(false);
            godFather.activeLevel.levelPanel = godFather.getLevelThreeGameBackgroundPanel();
            godFather.activeLevel.levelPanel.setVisible(true);
            godFather.activeLevel.mario = godFather.getBossFightScreenSection().activeMario;
            godFather.marioMoverModel.activeMario = godFather.activeLevel.mario;
            godFather.activeLevel.intersect = godFather.intersectInBossSection;
            godFather.activeLevel.screen = godFather.getBossFightScreenSection();
            godFather.activeLevel.screenModel = godFather.getBossFightSectionModel();
            godFather.gameTimer.setSectionTime(50);
            // Add Score At The End Of Section
            godFather.calculateScore.calculateScore(godFather.getLevelTwoSectionTwoScreen());
            godFather.getPowerUp().loadPowerUp(godFather.marioMoverModel.activeMario);
            godFather.marioMoverModel.setMarioEnterInBossSection(true);
            CheckPointSave.getCheckPointSave().save(godFather.activeLevel.screen);
            CheckPointSave.getCheckPointSave().saveXPanel(godFather.activeLevel.levelPanel.getX());
        }

    }
}
