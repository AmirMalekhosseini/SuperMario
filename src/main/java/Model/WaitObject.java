package Model;

public class WaitObject {

    private static volatile Object wait;

    private WaitObject() {

    }

    public static Object getWait() {
        if (wait == null) {
            wait = new Object();
        }
        return wait;
    }

}
