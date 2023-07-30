package Model.OnlineChat;


import Controller.Menu.OnlineChat.ChatButtonCreator;
import View.Menu.OnlineChat.ChatChooseButton;
import View.Menu.OnlineChat.MainChatFrame;

public class ChatFrameModel {


    public ChatButtonCreator chatButtonCreator;
    public void addButtons(MainChatFrame frame) {

        for (ChatChooseButton button : frame.getButtons()) {
            frame.choosePanel.add(button);
        }
    }

    public void addButtonAction(MainChatFrame frame) {

        for (ChatChooseButton button : frame.getButtons()) {
            button.addActionListener(e -> {
                frame.getActiveChatScreen().setVisible(false);
                frame.setActiveChatScreen(button.getChatScreen());
                button.getChatScreen().setVisible(true);
                frame.chatScroll.setViewportView(button.getChatScreen()); // Update the JScrollPane view
//                moveButtonToTop(frame,button);
                frame.panel.revalidate();
                frame.messageField.requestFocus();
            });
        }

    }

    public void moveButtonToTop(MainChatFrame frame,ChatChooseButton button) {
        if (frame.choosePanel.getComponentCount() > 1) {
            frame.choosePanel.setComponentZOrder(button, 0);
            frame.choosePanel.revalidate();
            frame.choosePanel.repaint();
        }
    }

    public void addChatScreens(MainChatFrame frame) {
        for (ChatChooseButton button : frame.getButtons()) {
            frame.getChatScreens().put(button.getRecipientUsername(), button.getChatScreen());
        }
    }

}
