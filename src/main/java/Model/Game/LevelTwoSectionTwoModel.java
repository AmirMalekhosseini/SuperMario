package Model.Game;

import Controller.Game.CheckPointSave;
import Controller.Game.ScreenController;

public class LevelTwoSectionTwoModel extends NormalScreenModel {

    public LevelTwoSectionTwoModel(GameGodFather godFather) {
        this.godFather = godFather;
        this.marioMoverController = godFather.marioMoverController;
        this.intersect = godFather.intersectInLevelTwoSectionTwo;
        this.screen = godFather.getLevelTwoSectionTwoScreen();

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


    @Override
    public void goToHiddenSection() {

        if (!godFather.marioMoverController.isMarioEnterInHiddenEnemySection()) {// Mario Enter in hiddenSection:
            godFather.activeLevel.getLevelPanel().setVisible(false);
            godFather.activeLevel.setLevelPanel(godFather.hiddenEnemyBackgroundPanel);
            godFather.activeLevel.getLevelPanel().setVisible(true);
            godFather.activeLevel.setMario(godFather.getHiddenEnemySectionScreen().activeMario);
            godFather.marioMoverController.activeMario = godFather.activeLevel.getMario();
            godFather.activeLevel.setIntersect(godFather.intersectInHiddenEnemySection);
            godFather.activeLevel.setScreen(godFather.getHiddenEnemySectionScreen());
            godFather.activeLevel.setScreenModel(godFather.getHiddenEnemySectionModel());

            // Save time
            godFather.gameTimer.setSaveTime(godFather.gameTimer.getSectionTime());
            godFather.gameTimer.setSectionTime(50);
            godFather.getPowerUp().loadPowerUp(godFather.marioMoverController.activeMario);
            godFather.marioMoverController.setMarioEnterInHiddenEnemySection(true);
            CheckPointSave.getCheckPointSave().save(godFather.activeLevel.getScreen());
            CheckPointSave.getCheckPointSave().saveXPanel(godFather.activeLevel.getLevelPanel().getX());
        }

    }

    @Override
    public void goToNextSection() {

        if (!godFather.marioMoverController.isMarioEnterInBossSection()) {// Mario enters in New Section:
            godFather.getLevelTwoGameBackgroundPanel().setVisible(false);
            godFather.activeLevel.setLevelPanel(godFather.getLevelThreeGameBackgroundPanel());
            godFather.activeLevel.getLevelPanel().setVisible(true);
            godFather.activeLevel.setMario(godFather.getBossFightScreenSection().activeMario);
            godFather.marioMoverController.activeMario = godFather.activeLevel.getMario();
            godFather.activeLevel.setIntersect(godFather.intersectInBossSection);
            godFather.activeLevel.setScreen(godFather.getBossFightScreenSection());
            godFather.activeLevel.setScreenModel(godFather.getBossFightSectionModel());
            godFather.gameTimer.setSectionTime(50);
            // Add Score At The End Of Section
            godFather.calculateScore.calculateScore(godFather.getLevelTwoSectionTwoScreen());
            godFather.getPowerUp().loadPowerUp(godFather.marioMoverController.activeMario);
            godFather.marioMoverController.setMarioEnterInBossSection(true);
            CheckPointSave.getCheckPointSave().save(godFather.activeLevel.getScreen());
            CheckPointSave.getCheckPointSave().saveXPanel(godFather.activeLevel.getLevelPanel().getX());
        }

    }
}
