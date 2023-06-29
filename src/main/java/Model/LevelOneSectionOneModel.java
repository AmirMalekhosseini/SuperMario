package Model;

import Graphic.*;

public class LevelOneSectionOneModel extends ScreenModel {

    public LevelOneSectionOneModel(LevelOneSectionOneScreen levelOneSectionOneScreen, IntersectInLevelOneSectionOne intersect, MarioMoverModel marioMoverModel) {
        this.marioMoverModel = marioMoverModel;
        this.intersect = intersect;
        this.screen = levelOneSectionOneScreen;

        controller = new ScreenController(screen, intersect, marioMoverModel) {
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

}
