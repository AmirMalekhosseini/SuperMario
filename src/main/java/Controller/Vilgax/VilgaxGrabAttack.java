package Controller.Vilgax;

import Model.Game.GameGodFather;
import Model.Mario.Mario;
import Model.Vilgax.Vilgax;
import View.Game.BossFightSectionScreen;

public class VilgaxGrabAttack extends VilgaxMove {


    BossFightSectionScreen screen;
    protected Mario activeMario;


    public VilgaxGrabAttack(GameGodFather godFather, Vilgax vilgax) {
        this.godFather = godFather;
        this.vilgax = vilgax;
        this.screen = godFather.getBossFightScreenSection();
        this.activeMario = godFather.activeLevel.getMario();
        moveIntersection = new VilgaxMoveIntersection(godFather) {
            @Override
            public void intersection() {

                // time is up
                if (godFather.gameTimer.grabAttackCounter.counter == 5) {
                    activeMario.setMarioReleaseFromVilgax(true);
                    godFather.getPowerUp().decreasePowerUp(activeMario);
                    if (activeMario.isMarioShouldDie()) {
                        screen.getGameData().userHeartValue--;
                    }
                    return;
                }

                // got release
                if (activeMario.buttonPressCounter >= 10) {
                    activeMario.setMarioReleaseFromVilgax(true);
                }

            }
        };
    }

    @Override
    public void action() {

        vilgax.vilgaxAndMarioConnection.vilgaxGrabMario();
        changeBackground();

    }

    @Override
    public void changeBackground() {

        // Couldn't find a picture for Phase_2 :)
        if (vilgax.getXVelocity() >= 0) {
            vilgax.setActiveBackground(vilgax.getVilgax_Grab_Filliped());
        } else {
            vilgax.setActiveBackground(vilgax.getVilgax_Grab());
        }

    }
}
