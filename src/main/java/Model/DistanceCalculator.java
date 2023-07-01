package Model;

import Graphic.ObjectsInGame;

public class DistanceCalculator {

    private static DistanceCalculator distanceCalculator;

    public static DistanceCalculator getDistanceCalculator() {

        if (distanceCalculator == null) {
            distanceCalculator = new DistanceCalculator();
        }
        return distanceCalculator;

    }

    public int calculate(ObjectsInGame o1, ObjectsInGame o2) {
        int x1 = o1.getX();
        int x2 = o2.getX();
        return Math.abs(x1 - x2);
    }

}
