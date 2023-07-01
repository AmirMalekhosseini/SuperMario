package Model.Vilgax;

import Graphic.BossFightSectionScreen;
import Graphic.GameGodFather;
import Model.PowerUp;
import Model.VilgaxIntersection;

public abstract class VilgaxMoveIntersection extends VilgaxIntersection {

    public VilgaxMoveIntersection(GameGodFather godFather, PowerUp powerUp, BossFightSectionScreen screen) {
        super(godFather, powerUp, screen);
    }

    public abstract void intersection();

}
