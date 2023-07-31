package Controller.Menu.OnlineChat;

import Model.Game.OfflineUser;
import MyProject.MyProject;
import View.Menu.OnlineChat.ChatChooseButton;
import View.Menu.OnlineChat.ChatScreen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChatButtonCreator {

    public ArrayList<ChatChooseButton> createButton(JTextField chatArea) {
        ArrayList<ChatChooseButton> buttons = new ArrayList<>();

        for (OfflineUser offlineUser : MyProject.allOfflineUsers) {
            if (offlineUser.getUserData().getUsername().equals(MyProject.activeOfflineUser.getUserData().getUsername())) {
                continue;
            }
            ChatScreen chatScreen = new ChatScreen(MyProject.activeOfflineUser.getUserData().getUsername(), offlineUser.getUserData().getUsername(), chatArea);
            chatScreen.setLocation(200, 0);
            chatScreen.setOpaque(false);
            chatScreen.setBackground(new Color(0, 0, 0, 0));
            ChatChooseButton button = new ChatChooseButton(chatScreen, offlineUser.getUserData().getUsername());
            buttons.add(button);
        }

        return buttons;
    }

}
