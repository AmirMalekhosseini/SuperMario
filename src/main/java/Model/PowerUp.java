package Model;

import Graphic.*;

public class PowerUp {

    GameScreenFrame gameScreenFrame;
    LevelOneSectionOneScreen levelOneSectionOneScreen;
    LevelOneSectionTwoScreen levelOneSectionTwoScreen;
    LevelTwoSectionOneScreen levelTwoSectionOneScreen;
    LevelTwoSectionTwoScreen levelTwoSectionTwoScreen;
    HiddenCoinSectionScreen hiddenCoinSectionScreen;
    HiddenEnemySectionScreen hiddenEnemySectionScreen;

    public PowerUp(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
        this.levelOneSectionOneScreen = gameScreenFrame.getLevelOneSectionOneScreen();
        this.levelOneSectionTwoScreen = gameScreenFrame.getLevelOneSectionTwoScreen();
        this.levelTwoSectionOneScreen = gameScreenFrame.getLevelTwoSectionOneScreen();
        this.levelTwoSectionTwoScreen = gameScreenFrame.getLevelTwoSectionTwoScreen();
        this.hiddenCoinSectionScreen = gameScreenFrame.getHiddenCoinSectionScreen();
        this.hiddenEnemySectionScreen = gameScreenFrame.getHiddenEnemySectionScreen();
    }

    public void allocatePowerUpInLevelOneSectionOne() {

        Mario activeMario = levelOneSectionOneScreen.activeMario.get(0);
        if (activeMario.isMarioMini()) {

            activeMario.setHeight(120);
            activeMario.setMarioMini(false);
            activeMario.setMarioMega(true);

        } else if (activeMario.isMarioMega()) {

            activeMario.setHeight(120);
            activeMario.setMarioMega(false);
            activeMario.setMarioShooter(true);

        }

    }

    public void decreasePowerUpInLevelOneSectionOne() {

        Mario activeMario = levelOneSectionOneScreen.activeMario.get(0);
        activeMario.setMarioShouldDie(false);
        if (activeMario.isMarioShooter()) {

            activeMario.setMarioShooter(false);
            activeMario.setMarioMega(true);

        } else if (activeMario.isMarioMega()) {

            activeMario.setHeight(60);
            activeMario.setMarioMega(false);
            activeMario.setMarioMini(true);

        } else if (activeMario.isMarioMini()) {// Mario dies after hit
            activeMario.setMarioShouldDie(true);
        }

    }

    public void allocatePowerUpInLevelOneSectionTwo() {

        Mario activeMario = levelOneSectionTwoScreen.activeMario.get(0);
        if (activeMario.isMarioMini()) {

            activeMario.setHeight(120);
            activeMario.setMarioMini(false);
            activeMario.setMarioMega(true);

        } else if (activeMario.isMarioMega()) {

            activeMario.setHeight(120);
            activeMario.setMarioMega(false);
            activeMario.setMarioShooter(true);

        }

    }

    public void decreasePowerUpInLevelOneSectionTwo() {

        Mario activeMario = levelOneSectionTwoScreen.activeMario.get(0);
        activeMario.setMarioShouldDie(false);
        if (activeMario.isMarioShooter()) {

            activeMario.setMarioShooter(false);
            activeMario.setMarioMega(true);

        } else if (activeMario.isMarioMega()) {

            activeMario.setHeight(60);
            activeMario.setMarioMega(false);
            activeMario.setMarioMini(true);

        }else if (activeMario.isMarioMini()) {// Mario dies after hit
            activeMario.setMarioShouldDie(true);
        }

    }

    public void allocatePowerUpInLevelTwoSectionOne() {

        Mario activeMario = levelTwoSectionOneScreen.activeMario.get(0);
        if (activeMario.isMarioMini()) {

            activeMario.setHeight(120);
            activeMario.setMarioMini(false);
            activeMario.setMarioMega(true);

        } else if (activeMario.isMarioMega()) {

            activeMario.setHeight(120);
            activeMario.setMarioMega(false);
            activeMario.setMarioShooter(true);

        }

    }

    public void decreasePowerUpInLevelTwoSectionOne() {

        Mario activeMario = levelTwoSectionOneScreen.activeMario.get(0);
        activeMario.setMarioShouldDie(false);
        if (activeMario.isMarioShooter()) {

            activeMario.setMarioShooter(false);
            activeMario.setMarioMega(true);

        } else if (activeMario.isMarioMega()) {

            activeMario.setHeight(60);
            activeMario.setMarioMega(false);
            activeMario.setMarioMini(true);

        }else if (activeMario.isMarioMini()) {// Mario dies after hit
            activeMario.setMarioShouldDie(true);
        }

    }

    public void allocatePowerUpInLevelTwoSectionTwo() {

        Mario activeMario = levelTwoSectionTwoScreen.activeMario.get(0);
        if (activeMario.isMarioMini()) {

            activeMario.setHeight(120);
            activeMario.setMarioMini(false);
            activeMario.setMarioMega(true);

        } else if (activeMario.isMarioMega()) {

            activeMario.setHeight(120);
            activeMario.setMarioMega(false);
            activeMario.setMarioShooter(true);

        }

    }

    public void decreasePowerUpInLevelTwoSectionTwo() {

        Mario activeMario = levelTwoSectionTwoScreen.activeMario.get(0);
        activeMario.setMarioShouldDie(false);
        if (activeMario.isMarioShooter()) {

            activeMario.setMarioShooter(false);
            activeMario.setMarioMega(true);

        } else if (activeMario.isMarioMega()) {

            activeMario.setHeight(60);
            activeMario.setMarioMega(false);
            activeMario.setMarioMini(true);

        }else if (activeMario.isMarioMini()) {// Mario dies after hit
            activeMario.setMarioShouldDie(true);
        }

    }

    public void allocatePowerUpInHiddenCoinSection() {

        Mario activeMario = hiddenCoinSectionScreen.activeMario.get(0);
        if (activeMario.isMarioMini()) {

            activeMario.setHeight(120);
            activeMario.setMarioMini(false);
            activeMario.setMarioMega(true);

        } else if (activeMario.isMarioMega()) {

            activeMario.setHeight(120);
            activeMario.setMarioMega(false);
            activeMario.setMarioShooter(true);

        }

    }

    public void decreasePowerUpInHiddenCoinSection() {

        Mario activeMario = hiddenCoinSectionScreen.activeMario.get(0);
        activeMario.setMarioShouldDie(false);
        if (activeMario.isMarioShooter()) {

            activeMario.setMarioShooter(false);
            activeMario.setMarioMega(true);

        } else if (activeMario.isMarioMega()) {

            activeMario.setHeight(60);
            activeMario.setMarioMega(false);
            activeMario.setMarioMini(true);

        }else if (activeMario.isMarioMini()) {// Mario dies after hit
            activeMario.setMarioShouldDie(true);
        }

    }

    public void allocatePowerUpInHiddenEnemySection() {

        Mario activeMario = hiddenEnemySectionScreen.activeMario.get(0);
        if (activeMario.isMarioMini()) {

            activeMario.setHeight(120);
            activeMario.setMarioMini(false);
            activeMario.setMarioMega(true);

        } else if (activeMario.isMarioMega()) {

            activeMario.setHeight(120);
            activeMario.setMarioMega(false);
            activeMario.setMarioShooter(true);

        }

    }

    public void decreasePowerUpInHiddenEnemySection() {

        Mario activeMario = hiddenEnemySectionScreen.activeMario.get(0);
        activeMario.setMarioShouldDie(false);
        if (activeMario.isMarioShooter()) {

            activeMario.setMarioShooter(false);
            activeMario.setMarioMega(true);

        } else if (activeMario.isMarioMega()) {

            activeMario.setHeight(60);
            activeMario.setMarioMega(false);
            activeMario.setMarioMini(true);

        }else if (activeMario.isMarioMini()) {// Mario dies after hit
            activeMario.setMarioShouldDie(true);
        }

    }

}
