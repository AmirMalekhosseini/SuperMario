package View.Notification;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChatNotification extends Notification{


    public ChatNotification(String title, String message) {

        super(title, message);
        addButtonListener();

    }

    private void addButtonListener() {

        okButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    handleLeftClick();
                } else if (SwingUtilities.isRightMouseButton(e)) {
                    handleRightClick();
                }
            }
        });

    }


    private void handleLeftClick() {
        // Handle left-click behavior here
    }

    private void handleRightClick() {
        // Handle right-click behavior here
        dispose();

    }

}
