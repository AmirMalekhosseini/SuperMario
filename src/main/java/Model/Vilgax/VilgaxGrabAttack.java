package Model.Vilgax;

import Graphic.GameGodFather;
import Graphic.Vilgax.Vilgax;

public class VilgaxGrabAttack extends VilgaxMove {


    public VilgaxGrabAttack(GameGodFather godFather, Vilgax vilgax) {
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
