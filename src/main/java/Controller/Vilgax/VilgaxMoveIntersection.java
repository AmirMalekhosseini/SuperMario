package Controller.Vilgax;

import Model.Game.GameGodFather;
import Controller.Game.VilgaxIntersection;

public abstract class VilgaxMoveIntersection extends VilgaxIntersection {

    public VilgaxMoveIntersection(GameGodFather godFather) {
        super(godFather);
    }

    public abstract void intersection();

}
