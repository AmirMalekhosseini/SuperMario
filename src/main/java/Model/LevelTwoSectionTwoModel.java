package Model;

import Graphic.*;

public class LevelTwoSectionTwoModel extends ScreenModel {

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


}
