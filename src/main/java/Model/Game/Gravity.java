package Model.Game;

import Model.Object.ObjectsInGame;

public interface Gravity {

    public boolean isItemOnTopOfAnObject(ObjectsInGame object);
    public void allocateGravity();

}
