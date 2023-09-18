package Controller.Game;

import Model.Game.GameGodFather;
import Model.Mario.Mario;

public class PowerUp {

    GameGodFather gameGodFather;

    public PowerUp(GameGodFather gameGodFather) {
        this.gameGodFather = gameGodFather;
    }

    public void allocatePowerUp(Mario activeMario) {

        if (activeMario.isMarioMini()) {

            activeMario.setHeight(120);
            activeMario.setMarioMini(false);
            activeMario.setMarioMega(true);

        } else if (activeMario.isMarioMega()) {

            activeMario.setHeight(120);
            activeMario.setMarioMega(false);
            activeMario.setMarioShooter(true);

        }

        savePowerUp(activeMario);

    }

    public void decreasePowerUp(Mario activeMario) {

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

        savePowerUp(activeMario);

    }

    public void savePowerUp(Mario activeMario) {// Get Mario powerUp Info and saveUserData it

        gameGodFather.getGameData().setMarioMini(activeMario.isMarioMini());
        gameGodFather.getGameData().setMarioMega(activeMario.isMarioMega());
        gameGodFather.getGameData().setMarioShooter(activeMario.isMarioShooter());

    }

    public void loadPowerUp(Mario activeMario) {// Load Mario PowerUp Info from saved Info


        activeMario.setMarioMini(gameGodFather.getGameData().isMarioMini());
        activeMario.setMarioMega(gameGodFather.getGameData().isMarioMega());
        activeMario.setMarioShooter(gameGodFather.getGameData().isMarioShooter());

    }

}
