package View.Notification;

import Controller.Menu.SwingUtils;
import MyProject.MyProject;
import View.Button.ChatChooseButton;
import View.Menu.OnlineChat.MainChatFrame;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChatNotification extends Notification{

    String sender;

    public ChatNotification(String title, String message) {

        super(title, message);
        sender = title;
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
        SwingUtils.closeAllFrames();
        MainChatFrame chatFrame = new MainChatFrame();
        MyProject.activeClient.setActiveChatFrame(chatFrame);
        for (ChatChooseButton button : chatFrame.getButtons()) {
            // Find button
            if (button.getRecipientUsername().equals(sender)) {
                chatFrame.getActiveChatScreen().setVisible(false);
                chatFrame.setActiveChatScreen(button.getChatScreen());
                button.getChatScreen().setVisible(true);
                chatFrame.chatScroll.setViewportView(button.getChatScreen()); // Update the JScrollPane view
                chatFrame.panel.revalidate();
                chatFrame.revalidate();
                chatFrame.messageField.requestFocus();
            }
        }
    }

    private void handleRightClick() {
        // Handle right-click behavior here
        dispose();

    }

}
