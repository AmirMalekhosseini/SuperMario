package Model.NetworkCommunication;

import Controller.Online.JsonUtils;
import Controller.Online.MessageHandler.MessageHandler;
import Controller.Online.MessageHandler.MessageHandlerCreator;
import Model.Game.UserData;
import Model.NetworkCommunication.Message.Message;
import Model.NetworkCommunication.Message.MessageType;
import Model.OnlineChat.UserChat;
import View.Menu.OnlineChat.MainChatFrame;
import View.Menu.OnlineLobby.OnlineLobbyScreen;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Client {


    private UserData userData;
    private Map<MessageType, MessageHandler> messageHandlerMap;
    private Map<String, ArrayList<UserChat>> userChatScreens;
    private ArrayList<String> userFriends;
    private Map<String, Integer> clientItems;
    private int activeBagIndex;
    private OnlineLobbyScreen activeLobbyScreen;
    private MainChatFrame activeChatFrame;
    private volatile boolean isClientOnline;
    private final Socket socket;
    private String username;
    private final PrintWriter sender;
    private final Scanner receiver;
    private final ObjectMapper objectMapper;

    public Client(String serverAddress, int serverPort) throws IOException {

        socket = new Socket(serverAddress, serverPort);
        isClientOnline = true;
        messageHandlerMap = MessageHandlerCreator.getInstance().createMessageHandler();
        System.out.println("Connected to server.");
        clientItems = new ConcurrentHashMap<>();
        userFriends = new ArrayList<>();
        userChatScreens = new ConcurrentHashMap<>();

        sender = new PrintWriter(socket.getOutputStream(), true);
        receiver = new Scanner(socket.getInputStream());
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        // Start separate threads for receiving and sending
        Thread receiveThread = new Thread(this::receiveFromServer);
        receiveThread.start();
    }

    private void receiveFromServer() {

        while (isClientOnline) {

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (receiver.hasNextLine()) {
                String receivedJson = receiver.nextLine();
                try {
                    Message receivedMessage = JsonUtils.deserializeFromJson(receivedJson, Message.class);
                    MessageHandler handler = messageHandlerMap.get(receivedMessage.getMessageType());
                    handler.handlerMessage(receivedMessage);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }

    public synchronized void sendToServer(Message messageToSend) {
        // Create a New Thread to Send the Message:
        Thread senderThread = new Thread(() -> {
            try {
                messageToSend.setSenderUser(username);
                String jsonToSend = JsonUtils.serializeToJson(messageToSend);
                sender.println(jsonToSend);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Start the Thread to Send the Message:
        senderThread.start();
    }

    public synchronized Socket getSocket() {
        return socket;
    }

    public synchronized String getUsername() {
        return username;
    }

    public synchronized void setUsername(String username) {
        this.username = username;
    }

    public synchronized ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public boolean isClientOnline() {
        return isClientOnline;
    }

    public void setClientOnline(boolean clientOnline) {
        isClientOnline = clientOnline;
    }

    public Map<MessageType, MessageHandler> getMessageHandlerMap() {
        return messageHandlerMap;
    }

    public void setMessageHandlerMap(Map<MessageType, MessageHandler> messageHandlerMap) {
        this.messageHandlerMap = messageHandlerMap;
    }

    public int getActiveBagIndex() {
        return activeBagIndex;
    }

    public void setActiveBagIndex(int activeBagIndex) {
        this.activeBagIndex = activeBagIndex;
    }


    public OnlineLobbyScreen getActiveLobbyScreen() {
        return activeLobbyScreen;
    }

    public void setActiveLobbyScreen(OnlineLobbyScreen activeLobbyScreen) {
        this.activeLobbyScreen = activeLobbyScreen;
    }

    public MainChatFrame getActiveChatFrame() {
        return activeChatFrame;
    }

    public void setActiveChatFrame(MainChatFrame activeChatFrame) {
        this.activeChatFrame = activeChatFrame;
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
