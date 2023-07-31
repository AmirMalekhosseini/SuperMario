package Model.NetworkCommunication;

import Controller.Online.JsonUtils;
import Controller.Online.MessageHandlerCreator;
import Model.NetworkCommunication.Message.Message;
import Model.NetworkCommunication.Message.MessageType;
import Model.NetworkCommunication.MessageHandler.MessageHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;

public class Client {


    private Map<MessageType, MessageHandler> messageHandlerMap;
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
                    handler.handleMessage(receivedMessage);
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
}
