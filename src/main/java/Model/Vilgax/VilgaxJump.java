package Model.Vilgax;

import Graphic.Vilgax.Vilgax;
import Model.GravityData;

public class VilgaxJump extends VilgaxMove {


    public VilgaxJump(Vilgax vilgax) {
        this.vilgax = vilgax;
    }

    @Override
    public void action() {

        vilgax.setVelocity(vilgax.getVelocity() + (GravityData.getGravityData().gravity) * GravityData.getGravityData().vilgaxDt);
        vilgax.setY((int) (vilgax.getY() + vilgax.getVelocity()));

        if (vilgax.getY() >= 960 - vilgax.getHeight()
                && vilgax.getY() <= 980 - vilgax.getHeight()) {
            vilgax.activeMove = vilgax.vilgaxDoNothing;
        }

    }
}
