package Controller.Online.MessageHandler;

import Model.NetworkCommunication.Message.ChatMessage;
import Model.NetworkCommunication.Message.Message;
import Model.OnlineChat.UserChat;
import MyProject.MyProject;
import View.Menu.OnlineChat.ChatChooseButton;
import View.Menu.OnlineChat.ChatScreen;
import View.Menu.OnlineChat.MainChatFrame;
import View.Notification.ChatNotification;

public class ChatMessageHandler implements MessageHandler{

    MainChatFrame chatFrame = MyProject.activeClient.getActiveChatFrame();
    @Override
    public void handlerMessage(Message message) {

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
                MyProject.activeClient.getUserChatScreens().get(sender).add(userChat);
                new ChatNotification(sender, trimMessage(messageContext));
            }

        }

    }

    private ChatChooseButton findButton(String username) {
        for (ChatChooseButton button : chatFrame.getButtons()) {
            if (button.getChatScreen().getModel().getMyUsername().equals(username)
                    || button.getChatScreen().getModel().getOtherUsername().equals(username)) {
                return button;
            }
        }
        return null;
    }

    private ChatScreen getChatScreen(ChatMessage message) {
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
