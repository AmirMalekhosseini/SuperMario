package Controller.Menu.OnlineChat;

import Model.Game.OfflineUser;
import Model.OnlineChat.UserChat;
import MyProject.MyProject;
import View.Menu.OnlineChat.ChatChooseButton;
import View.Menu.OnlineChat.ChatScreen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class ChatButtonCreator {

    public ArrayList<ChatChooseButton> createButton(JTextField chatArea) {
        ArrayList<ChatChooseButton> buttons = new ArrayList<>();

        for (String username : MyProject.activeClient.getUserFriends()) {
            if (username.equals(MyProject.activeClient.getUsername())) {
                continue;
            }
            ChatScreen chatScreen = new ChatScreen(MyProject.activeClient.getUsername(), username, chatArea);
            chatScreen.setLocation(200, 0);
            chatScreen.setOpaque(false);
            chatScreen.setBackground(new Color(0, 0, 0, 0));
            loadChatScreen(chatScreen, username);
            ChatChooseButton button = new ChatChooseButton(chatScreen, username);
            buttons.add(button);
        }

        return buttons;
    }

    private void loadChatScreen(ChatScreen chatScreen, String otherUsername) {
        if (MyProject.activeClient.getUserChatScreens().get(otherUsername) == null) {
            return;
        }
        for (UserChat chat : MyProject.activeClient.getUserChatScreens().get(otherUsername)) {
            System.out.println(chat.getContext() + "  " + chat.isUserMessage());
            if (chat.isUserMessage()) {
                chatScreen.addUserMessage(chat.getContext());
            } else {
                chatScreen.addOtherMessage(chat.getContext());
            }
        }
    }

}
