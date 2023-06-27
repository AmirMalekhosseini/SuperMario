package Model.Vilgax;

import Graphic.Vilgax.Vilgax;

public abstract class VilgaxMove {

    protected Vilgax vilgax;

    public abstract void action();

    public abstract void changeBackground();

    public Vilgax getVilgax() {
        return vilgax;
    }

    public void setVilgax(Vilgax vilgax) {
        this.vilgax = vilgax;
    }
}
