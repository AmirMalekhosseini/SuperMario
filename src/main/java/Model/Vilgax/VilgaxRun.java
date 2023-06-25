package Model.Vilgax;

import Graphic.Vilgax.Vilgax;

public class VilgaxRun extends VilgaxMove {


    public VilgaxRun(Vilgax vilgax) {
        this.vilgax = vilgax;
    }

    @Override
    public void action() {

        vilgax.setX((int) (vilgax.getX() + vilgax.getVelocity()));

        if (vilgax.getX() >= 6300 || vilgax.getX() <= 5400) {// Vilgax reaches to its move limit
            vilgax.setVelocity(-vilgax.getVelocity());
        }

    }

}
