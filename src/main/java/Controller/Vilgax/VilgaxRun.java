package Controller.Vilgax;

import Model.Game.GameGodFather;
import Model.Vilgax.Vilgax;

public class VilgaxRun extends VilgaxMove {


    public VilgaxRun(GameGodFather godFather, Vilgax vilgax) {
        this.godFather = godFather;
        this.vilgax = vilgax;
        moveIntersection = new VilgaxMoveIntersection(godFather) {
            @Override
            public void intersection() {

                if (isMoveDone()) {
                    vilgax.activeMove = getVilgax().vilgaxDoNothing;
                    setMoveDone(false);
                }

            }
        };
    }

    @Override
    public void action() {

        if (!isMoveDone()) {
            vilgax.setX((int) (vilgax.getX() + vilgax.getXVelocity()));

            changeBackground();

            if (vilgax.getX() >= 6300 || vilgax.getX() <= 5400) {// Vilgax reaches to its move limit
                vilgax.setXVelocity(-vilgax.getXVelocity());
            }
        }

        // Set MoveDone in VilgaxMover.

    }

    @Override
    public void changeBackground() {

        if (vilgax.isVilgaxPhase_2()) {// Vilgax is in Phase_2:
            if (vilgax.getXVelocity() >= 0) {
                vilgax.setActiveBackground(vilgax.getVilgax_Phase2_Filliped());
            } else {
                vilgax.setActiveBackground(vilgax.getVilgax_Phase2());
            }
        } else {// Vilgax is in Phase_1:
            if (vilgax.getXVelocity() >= 0) {
                vilgax.setActiveBackground(vilgax.getVilgax_Phase1_Filliped());
            } else {
                vilgax.setActiveBackground(vilgax.getVilgax_Phase1());
            }
        }

    }

}
