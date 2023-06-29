package Model;

import Graphic.BossFightSectionScreen;

public class BossFightSectionModel extends ScreenModel {

    public BossFightSectionModel(BossFightSectionScreen screen, IntersectInBossSection intersect, MarioMoverModel marioMoverModel) {
        this.screen = screen;
        this.intersect = intersect;
        this.marioMoverModel = marioMoverModel;

        controller=new ScreenController(screen, intersect, marioMoverModel) {
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
