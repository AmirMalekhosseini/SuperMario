package Model;

public class WaitObject {

    private static WaitObject wait;

    public static WaitObject getWait()
    {
        if (wait == null) {
            wait = new WaitObject();
        }
        return wait;
    }

}
