package Controller.Online.MessageHandler;

import Model.NetworkCommunication.Message.ChatMessage;
import Model.NetworkCommunication.Message.Message;
import Model.OnlineChat.UserChat;
import MyProject.MyProject;
import View.Button.ChatChooseButton;
import View.Menu.OnlineChat.ChatScreen;
import View.Menu.OnlineChat.MainChatFrame;
import View.Notification.ChatNotification;

import java.util.ArrayList;

public class ChatMessageHandler implements MessageHandler{


    @Override
    public void handlerMessage(Message message) {

        MainChatFrame chatFrame = MyProject.activeClient.getActiveChatFrame();
        if (message instanceof ChatMessage) {
            ChatMessage chatMessage = (ChatMessage) message;
            String sender = chatMessage.getSenderUser();
            String messageContext = chatMessage.getContext();
            if (chatFrame != null) {
                getChatScreen(chatMessage).addOtherMessage(messageContext);
                ChatChooseButton button = findButton(sender);
                chatFrame.getModel().moveButtonToTop(chatFrame, button);
            } else {// if Client is not in Chat Frame
                UserChat userChat = new UserChat();
                userChat.setContext(messageContext);
                userChat.setUserMessage(false);
                addUserChat(userChat, sender);
                new ChatNotification(sender, trimMessage(messageContext));
            }

        }

    }

    private void addUserChat(UserChat userChat, String sender) {
        if (!MyProject.activeClient.getUserChatScreens().containsKey(sender)) {
            MyProject.activeClient.getUserChatScreens().put(sender, new ArrayList<>());
        }
        MyProject.activeClient.getUserChatScreens().get(sender).add(userChat);
    }

    private ChatChooseButton findButton(String username) {
        MainChatFrame chatFrame = MyProject.activeClient.getActiveChatFrame();
        for (ChatChooseButton button : chatFrame.getButtons()) {
            if (button.getChatScreen().getModel().getMyUsername().equals(username)
                    || button.getChatScreen().getModel().getOtherUsername().equals(username)) {
                return button;
            }
        }
        return null;
    }

    private ChatScreen getChatScreen(ChatMessage message) {
        MainChatFrame chatFrame = MyProject.activeClient.getActiveChatFrame();
        return chatFrame.getChatScreens().get(message.getSenderUser());
    }

    private String trimMessage(String message) {

        if (message.length() > 40) {
            return message.substring(0, 40);
        } else {
            return message;
        }

    }

}
