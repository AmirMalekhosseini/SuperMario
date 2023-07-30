package Controller.Menu.OnlineChat;

import Model.Game.User;
import MyProject.MyProject;
import View.Menu.OnlineChat.ChatChooseButton;
import View.Menu.OnlineChat.ChatScreen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChatButtonCreator {

    public ArrayList<ChatChooseButton> createButton(JTextField chatArea) {
        ArrayList<ChatChooseButton> buttons = new ArrayList<>();

        for (User user : MyProject.allUsers) {
            if (user.getUsername().equals(MyProject.activeUser.get(0).getUsername())) {
                continue;
            }
            ChatScreen chatScreen = new ChatScreen(MyProject.activeUser.get(0).getUsername(), user.getUsername(), chatArea);
            chatScreen.setLocation(200, 0);
            chatScreen.setOpaque(false);
            chatScreen.setBackground(new Color(0, 0, 0, 0));
            ChatChooseButton button = new ChatChooseButton(chatScreen, user.getUsername());
            buttons.add(button);
        }

        return buttons;
    }

}