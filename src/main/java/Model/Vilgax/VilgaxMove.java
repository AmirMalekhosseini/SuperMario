package Model.Vilgax;

import Graphic.Vilgax.Vilgax;

public abstract class VilgaxMove {

    protected Vilgax vilgax;
    private boolean isMoveDone;
    VilgaxMoveIntersection moveIntersection;

    public abstract void action();

    public abstract void changeBackground();

    public Vilgax getVilgax() {
        return vilgax;
    }

    public void setVilgax(Vilgax vilgax) {
        this.vilgax = vilgax;
    }

    public boolean isMoveDone() {
        return isMoveDone;
    }

    public void setMoveDone(boolean moveDone) {
        isMoveDone = moveDone;
    }
}
