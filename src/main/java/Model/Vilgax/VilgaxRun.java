package Model.Vilgax;

import Graphic.Vilgax.Vilgax;

public class VilgaxRun extends VilgaxMove {


    public VilgaxRun(Vilgax vilgax) {
        this.vilgax = vilgax;
    }

    @Override
    public void action() {

        vilgax.setX((int) (vilgax.getX() + vilgax.getXVelocity()));

        changeBackground();

        if (vilgax.getX() >= 6300 || vilgax.getX() <= 5400) {// Vilgax reaches to its move limit
            vilgax.setXVelocity(-vilgax.getXVelocity());
        }

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
