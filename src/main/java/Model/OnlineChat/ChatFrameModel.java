package Model.OnlineChat;


import Controller.Menu.OnlineChat.ChatButtonCreator;
import Model.NetworkCommunication.Message.ChatMessage;
import Model.NetworkCommunication.Message.MessageType;
import MyProject.MyProject;
import View.Menu.MainMenuScreen;
import View.Menu.OnlineChat.ChatChooseButton;
import View.Menu.OnlineChat.MainChatFrame;

import java.io.IOException;
import java.util.ArrayList;

public class ChatFrameModel {


    public ChatButtonCreator chatButtonCreator;
    private boolean isLobbyChat;

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
                frame.panel.revalidate();
                frame.messageField.requestFocus();
            });
        }

        frame.backButton.addActionListener(e->{
            new MainMenuScreen();
            frame.dispose();
            MyProject.activeClient.setActiveChatFrame(null);
        });

    }

    public void addMessageFieldAction(MainChatFrame frame) {
        frame.messageField.addActionListener(e -> sendMessage(frame));
    }

    private void sendMessage(MainChatFrame frame) {

        String messageText = frame.messageField.getText().trim();
        if (!messageText.isEmpty()) {

            ChatMessage newMessage = new ChatMessage();
            newMessage.setMessageType(MessageType.CHAT_MESSAGE);
            newMessage.setContext(messageText);
            newMessage.setTargetUser(frame.getActiveChatScreen().getModel().getOtherUsername());
            MyProject.activeClient.sendToServer(newMessage);
            // Save Message:
            saveMessage(newMessage.getTargetUser(), newMessage.getContext());

            // Scroll down to show the latest message
            frame.getActiveChatScreen().scrollDown();

            // Clear the chatArea after sending the message
            frame.messageField.setText("");

            frame.getActiveChatScreen().addUserMessage(messageText);
            ChatChooseButton button = findButton(newMessage.getTargetUser(), frame);
            frame.getModel().moveButtonToTop(frame, button);

        }
    }

    private void saveMessage(String targetUser, String messageContext) {

        if (!MyProject.activeClient.getUserChatScreens().containsKey(targetUser)) {
            MyProject.activeClient.getUserChatScreens().put(targetUser, new ArrayList<>());
        }
        UserChat chat = new UserChat();
        chat.setUserMessage(true);
        chat.setContext(messageContext);
        MyProject.activeClient.getUserChatScreens().get(targetUser).add(chat);

    }

    private ChatChooseButton findButton(String username, MainChatFrame frame) {
        for (ChatChooseButton button : frame.getButtons()) {
            if (button.getChatScreen().getModel().getMyUsername().equals(username)
                    || button.getChatScreen().getModel().getOtherUsername().equals(username)) {
                return button;
            }
        }
        return null;
    }

    public void moveButtonToTop(MainChatFrame frame, ChatChooseButton button) {
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
