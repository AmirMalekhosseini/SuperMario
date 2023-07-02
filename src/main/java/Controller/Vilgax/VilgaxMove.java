package Controller.Vilgax;

import Model.Game.GameGodFather;
import Model.Vilgax.Vilgax;

public abstract class VilgaxMove {

    GameGodFather godFather;
    protected Vilgax vilgax;
    private boolean isMoveDone;
    public VilgaxMoveIntersection moveIntersection;

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
