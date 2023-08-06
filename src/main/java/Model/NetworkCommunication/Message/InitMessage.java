package Model.NetworkCommunication.Message;

import Model.Game.UserData;
import Model.OnlineChat.UserChat;

import java.util.ArrayList;
import java.util.Map;

public class InitMessage extends Message {


    private Map<String, ArrayList<UserChat>> userChatScreens;
    private ArrayList<String> userFriends;
    private Map<String, Integer> clientItems;
    private UserData userData;


    public InitMessage() {

    }

    public Map<String, ArrayList<UserChat>> getUserChatScreens() {
        return userChatScreens;
    }

    public void setUserChatScreens(Map<String, ArrayList<UserChat>> userChatScreens) {
        this.userChatScreens = userChatScreens;
    }

    public ArrayList<String> getUserFriends() {
        return userFriends;
    }

    public void setUserFriends(ArrayList<String> userFriends) {
        this.userFriends = userFriends;
    }

    public Map<String, Integer> getClientItems() {
        return clientItems;
    }

    public void setClientItems(Map<String, Integer> clientItems) {
        this.clientItems = clientItems;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }
}
