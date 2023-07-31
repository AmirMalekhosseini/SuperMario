package View.Menu;

import Controller.Menu.UsernameLogic;
import Controller.Online.ServerConnection;
import Model.NetworkCommunication.Message.MessageType;
import Model.NetworkCommunication.Message.SignInMessage;
import Model.NetworkCommunication.Message.SignUpMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import MyProject.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

public class LoginPageScreen extends JFrame implements ActionListener {

    ObjectMapper objectMapper;
    UsernameLogic usernameLogic = new UsernameLogic();
    JLayeredPane backgroundPanel;
    JLabel backgroundImageLabel;
    JButton signInButton;
    JButton signUpButton;
    JButton exitButton;
    JButton onlineButton;

    public LoginPageScreen() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        ImageIcon backgroundImage = MyProjectData.getProjectData().getGameMenuImage();
        ImageIcon gameIcon = MyProjectData.getProjectData().getGameIcon();
        Font font20 = MyProjectData.getProjectData().getFont20();


        this.setSize(650, 700);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setIconImage(gameIcon.getImage());

        backgroundPanel = new JLayeredPane();
        backgroundPanel.setBounds(0, 0, 700, 700);

        backgroundImageLabel = new JLabel(backgroundImage);
        backgroundImageLabel.setBounds(0, 0, 650, 700);
        backgroundImageLabel.setOpaque(true);

        signInButton = new JButton("Sign In");
        signInButton.setBounds(250, 220, 150, 70);
        signInButton.setBackground(Color.BLACK);
        signInButton.setForeground(Color.WHITE);
        signInButton.setFocusable(false);
        signInButton.setFont(font20);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(250, 300, 150, 70);
        signUpButton.setBackground(Color.BLACK);
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setFocusable(false);
        signUpButton.setFont(font20);

        exitButton = new JButton("Exit");
        exitButton.setBounds(250, 380, 150, 70);
        exitButton.setBackground(Color.BLACK);
        exitButton.setForeground(Color.WHITE);
        exitButton.setFocusable(false);
        exitButton.setFont(font20);

        onlineButton = new JButton("Offline");
        onlineButton.setBounds(0, 0, 150, 70);
        onlineButton.setBackground(Color.RED);
        onlineButton.setForeground(Color.WHITE);
        onlineButton.setFocusable(false);
        onlineButton.setFont(font20);

        signInButton.addActionListener(this);
        signUpButton.addActionListener(this);
        exitButton.addActionListener(this);
        onlineButton.addActionListener(this);

        backgroundPanel.add(backgroundImageLabel, Integer.valueOf(0));
        backgroundPanel.add(signInButton, Integer.valueOf(1));
        backgroundPanel.add(signUpButton, Integer.valueOf(1));
        backgroundPanel.add(exitButton, Integer.valueOf(1));
        backgroundPanel.add(onlineButton, Integer.valueOf(1));
        this.add(backgroundPanel);

    }

    private void signInOfflineUser() {
        String username = JOptionPane.showInputDialog("Enter Username");
        String password;

        if (usernameLogic.signInUser(username)) {
            for (int i = 0; i < 1000000000; i++) {
                password = JOptionPane.showInputDialog("Enter Password");
                if (usernameLogic.checkPassword(password)) {
                    JOptionPane.showMessageDialog(null, "Signed In Successfully", "Sign In", JOptionPane.INFORMATION_MESSAGE);
                    new MainMenuScreen();
                    this.dispose();
                    try {
                        objectMapper.writeValue(new File("OfflineUser.jason"), MyProject.allOfflineUsers);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    break;

                } else {
                    JOptionPane.showMessageDialog(null, "Password is not correct", "Sign In Problem", JOptionPane.WARNING_MESSAGE);
                }
            }

        } else {
            JOptionPane.showMessageDialog(null, "Username is not valid", "Sign In Problem", JOptionPane.WARNING_MESSAGE);
        }

    }

    private void signInOnlineUser() {

        String username = JOptionPane.showInputDialog("Enter Username");
        String password = JOptionPane.showInputDialog("Enter Password");
        SignInMessage signInMessage = new SignInMessage(username, password);
        signInMessage.setMessageType(MessageType.SIGN_IN);

        // Send SIGN_IN to Server
        MyProject.activeClient.sendToServer(signInMessage);

    }

    private void signUpUser() {

        String username = JOptionPane.showInputDialog("Enter Username");
        String password = JOptionPane.showInputDialog("Enter Password");
        SignUpMessage signUpMessage = new SignUpMessage(username, password);
        signUpMessage.setMessageType(MessageType.SIGN_UP);

        // Send SIGN_UP to Server
        MyProject.activeClient.sendToServer(signUpMessage);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exitButton) {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        }

        if (e.getSource() == signInButton) {
            if (MyProject.isProjectOnline) {// Online
                signInOnlineUser();
            } else {// Offline
                signInOfflineUser();
            }
        }

        if (e.getSource() == signUpButton) {
            if (!MyProject.isProjectOnline) {
                return; // Project is Offline.
            }
            signUpUser();
        }

        if (e.getSource() == onlineButton) {
            if (MyProject.isProjectOnline) {// It is Online
                MyProject.isProjectOnline = false;
                onlineButton.setText("Offline");
                onlineButton.setBackground(Color.RED);
                ServerConnection.disconnectFromServer();
            } else {// It is Offline
                MyProject.isProjectOnline = true;
                onlineButton.setText("Online");
                onlineButton.setBackground(Color.GREEN);
                try {
                    ServerConnection.connectToServer("localhost",12345);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

    }
}
