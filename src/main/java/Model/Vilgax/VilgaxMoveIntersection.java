package Model.Vilgax;

import Graphic.BossFightSectionScreen;
import Graphic.GameGodFather;
import Model.PowerUp;
import Model.VilgaxIntersection;

public abstract class VilgaxMoveIntersection extends VilgaxIntersection {

    public VilgaxMoveIntersection(GameGodFather godFather) {
        super(godFather);
    }

    public abstract void intersection();

}
