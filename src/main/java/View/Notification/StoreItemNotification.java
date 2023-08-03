package View.Notification;

import Controller.Menu.SwingUtils;
import View.Menu.OnlineStoreScreen;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class StoreItemNotification extends Notification{


    public StoreItemNotification(String title, String message) {
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
        dispose();
        Objects.requireNonNull(SwingUtils.getActiveFrame()).dispose();
        new OnlineStoreScreen();

    }

    private void handleRightClick() {
        // Handle right-click behavior here
        dispose();
    }

}
