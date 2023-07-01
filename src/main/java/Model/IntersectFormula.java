package Model;

import Graphic.ObjectsInGame;

public interface IntersectFormula {

    default boolean isIntersect(ObjectsInGame o1, ObjectsInGame o2) {
        return true;
    }

}
