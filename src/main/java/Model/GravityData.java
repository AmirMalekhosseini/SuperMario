package Model;

import Graphic.GameScreenFrame;

public class GravityData {

    private static GravityData gravityData;

    public final int gravity = 10;
    public double marioDt = 0.018;
    public double vilgaxDt = 0.006;

    public static GravityData getGravityData() {
        if (gravityData == null) {
            gravityData = new GravityData();
        }
        return gravityData;
    }

    public GravityData() {

    }

}
