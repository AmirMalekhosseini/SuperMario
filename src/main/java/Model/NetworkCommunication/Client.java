package Model.NetworkCommunication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private final String username;
    private final PrintWriter sender;
    private final Scanner receiver;
    private final ObjectMapper objectMapper;

    public Client(String serverAddress, int serverPort, String username) throws IOException {

        this.username = username;
        Socket socket = new Socket(serverAddress, serverPort);
        System.out.println(username + "  Connected to server.");

        sender = new PrintWriter(socket.getOutputStream(), true);
        receiver = new Scanner(socket.getInputStream());
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        // Send Username to Server:
        sender.println(username);

    }

    public synchronized String getUsername() {
        return username;
    }


    public synchronized PrintWriter getSender() {
        return sender;
    }

    public synchronized Scanner getReceiver() {
        return receiver;
    }


    public synchronized ObjectMapper getObjectMapper() {
        return objectMapper;
    }

}
