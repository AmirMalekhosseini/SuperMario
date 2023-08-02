package Controller.Menu;

import java.awt.Window;
import javax.swing.JFrame;

public class SwingUtils {

    public static JFrame getActiveFrame() {
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window instanceof JFrame) {
                JFrame frame = (JFrame) window;
                if (frame.isActive()) {
                    frame.revalidate();
                    frame.repaint();
                    return frame;
                }
            }
        }
        return null; // No active JFrame found
    }
}
