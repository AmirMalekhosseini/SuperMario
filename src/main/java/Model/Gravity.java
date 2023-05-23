package Model;

import Graphic.ObjectsInGame;

public interface Gravity {

    public boolean isItemOnTopOfAnObject(ObjectsInGame object);
    public void allocateGravity();

}
