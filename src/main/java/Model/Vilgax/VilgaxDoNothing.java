package Model.Vilgax;

import Graphic.GameGodFather;
import Graphic.Vilgax.Vilgax;

public class VilgaxDoNothing extends VilgaxMove{


    public VilgaxDoNothing(GameGodFather godFather, Vilgax vilgax) {
        this.godFather = godFather;
        this.vilgax = vilgax;
        moveIntersection = new VilgaxMoveIntersection(godFather) {
            @Override
            public void intersection() {

            }
        };
    }

    @Override
    public void action() {

        changeBackground();

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
