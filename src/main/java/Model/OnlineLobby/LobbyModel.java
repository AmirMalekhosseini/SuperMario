package Model.OnlineLobby;

import Controller.Menu.OnlineLobby.LobbyButtonCreator;
import Model.NetworkCommunication.Message.LobbyChatMessage;
import Model.NetworkCommunication.Message.MessageType;
import MyProject.MyProject;
import View.Button.LobbyMemberButton;
import View.Menu.OnlineLobby.OnlineLobbyScreen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LobbyModel {

    private String lobbyName;
    private String password;
    private String adminUser;
    public LobbyButtonCreator buttonCreator;
    private Map<String, LobbyMemberButton> memberButtons;

    // Admin Constructor:
    public LobbyModel(String adminUser, String password) {
        this.password = password;
        this.adminUser = adminUser;
        lobbyName = adminUser;
        buttonCreator = new LobbyButtonCreator();
        memberButtons = new HashMap<>();
    }


    // Members Constructor:
    public LobbyModel(ArrayList<String> members, String adminUser) {
        this.adminUser = adminUser;
        this.lobbyName = adminUser;
        buttonCreator = new LobbyButtonCreator();
        memberButtons = new HashMap<>();
    }

    public void addButton(OnlineLobbyScreen screen, String newUser) {
        if (MyProject.activeClient.getUsername().equals(newUser)) {
            return;
        }

        LobbyMemberButton newMemberButton = buttonCreator.createButton(newUser);
        screen.getModel().getMemberButtons().put(newUser, newMemberButton);
        screen.choosePanel.add(newMemberButton);
        screen.choosePanel.revalidate();
        screen.revalidate();
    }

    public void addButtonAction( OnlineLobbyScreen screen) {
        screen.backButton.addActionListener(e->{
            goToLobby(screen);
        });
    }

    public void addMessageFieldAction(OnlineLobbyScreen screen) {

        screen.messageField.addActionListener(e -> {
            sendMessage(screen);
        });

    }

    private void sendMessage(OnlineLobbyScreen screen) {

        String messageText = screen.messageField.getText().trim();
        if (!messageText.isEmpty()) {

            LobbyChatMessage newMessage = new LobbyChatMessage();
            newMessage.setMessageType(MessageType.LOBBY_CHAT_MESSAGE);
            newMessage.setMessageContext(messageText);
            System.out.println(MyProject.activeClient.getActiveLobbyScreen().getModel().lobbyName);
            newMessage.setLobbyName(MyProject.activeClient.getActiveLobbyScreen().getModel().getLobbyName());
            MyProject.activeClient.sendToServer(newMessage);

            // Scroll down to show the latest message
            MyProject.activeClient.getActiveLobbyScreen().getChatScreen().scrollDown();

            // Clear the chatArea after sending the message
            MyProject.activeClient.getActiveLobbyScreen().messageField.setText("");

            MyProject.activeClient.getActiveLobbyScreen().getChatScreen().addUserMessage(messageText);


        }
    }

    public void removeMember(String removedUser) {
        OnlineLobbyScreen screen = MyProject.activeClient.getActiveLobbyScreen();
        screen.choosePanel.remove(screen.getModel().getMemberButtons().get(removedUser));
        screen.choosePanel.revalidate();
        screen.revalidate();
        screen.getModel().getMemberButtons().remove(removedUser);
    }


    public void goToLobby(OnlineLobbyScreen screen) {

        screen.inputPanel.setVisible(false);
        screen.chatScroll.setVisible(false);
        screen.chatPanel.setVisible(false);

        screen.lobbyPanel.setVisible(true);

    }

    public void goToChat(OnlineLobbyScreen screen) {

        screen.inputPanel.setVisible(true);
        screen.chatScroll.setVisible(true);
        screen.chatPanel.setVisible(true);

        screen.lobbyPanel.setVisible(false);

    }

    public String getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
    }


    public String getLobbyName() {
        return lobbyName;
    }

    public void setLobbyName(String lobbyName) {
        this.lobbyName = lobbyName;
    }

    public Map<String, LobbyMemberButton> getMemberButtons() {
        return memberButtons;
    }

    public void setMemberButtons(Map<String, LobbyMemberButton> memberButtons) {
        this.memberButtons = memberButtons;
    }
}
