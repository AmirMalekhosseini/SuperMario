package View.Menu;

import Controller.Online.ServerConnection;
import MyProject.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MainMenuScreen extends JFrame implements ActionListener {


    ObjectMapper objectMapper;
    JLayeredPane backgroundPanel;
    JLabel backgroundImageLabel;
    JButton onlineGameButton;
    JButton offlineGameButton;
    JButton LeaderBoardButton;
    JButton storeButton;
    JButton profileButton;
    JButton backButton;
    public MainMenuScreen() {

        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        ImageIcon backgroundImage = MyProjectData.getProjectData().getGameMenuImage();
        ImageIcon gameIcon = MyProjectData.getProjectData().getGameIcon();
        Font font20 = MyProjectData.getProjectData().getFont20();
        Font font15 = MyProjectData.getProjectData().getFont15();

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
        backgroundImageLabel.setBounds(0, 0, 670, 700);
        backgroundImageLabel.setOpaque(true);

        backButton = new JButton("Back");
        backButton.setBounds(555, 0, 85, 50);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.setFont(font20);
        backButton.addActionListener(this);

        onlineGameButton = new JButton("Online Game");
        onlineGameButton.setBounds(250, 130, 150, 60);
        onlineGameButton.setBackground(Color.BLACK);
        onlineGameButton.setForeground(Color.WHITE);
        onlineGameButton.setFocusable(false);
        onlineGameButton.setFont(font20);
        onlineGameButton.addActionListener(this);

        offlineGameButton = new JButton("Offline Game");
        offlineGameButton.setBounds(250, 210, 150, 60);
        offlineGameButton.setBackground(Color.BLACK);
        offlineGameButton.setForeground(Color.WHITE);
        offlineGameButton.setFocusable(false);
        offlineGameButton.setFont(font15);
        offlineGameButton.addActionListener(this);

        LeaderBoardButton = new JButton("Leaderboard");
        LeaderBoardButton.setBounds(250, 290, 150, 60);
        LeaderBoardButton.setBackground(Color.BLACK);
        LeaderBoardButton.setForeground(Color.WHITE);
        LeaderBoardButton.setFocusable(false);
        LeaderBoardButton.setFont(font15);
        LeaderBoardButton.addActionListener(this);

        storeButton = new JButton("Store");
        storeButton.setBounds(250, 370, 150, 60);
        storeButton.setBackground(Color.BLACK);
        storeButton.setForeground(Color.WHITE);
        storeButton.setFocusable(false);
        storeButton.setFont(font20);
        storeButton.addActionListener(this);

        profileButton = new JButton("Profile");
        profileButton.setBounds(250, 450, 150, 60);
        profileButton.setBackground(Color.BLACK);
        profileButton.setForeground(Color.WHITE);
        profileButton.setFocusable(false);
        profileButton.setFont(font20);
        profileButton.addActionListener(this);

        backgroundPanel.add(backgroundImageLabel, Integer.valueOf(0));
        backgroundPanel.add(onlineGameButton, Integer.valueOf(1));
        backgroundPanel.add(offlineGameButton, Integer.valueOf(1));
        backgroundPanel.add(LeaderBoardButton, Integer.valueOf(1));
        backgroundPanel.add(storeButton, Integer.valueOf(1));
        backgroundPanel.add(profileButton, Integer.valueOf(1));
        backgroundPanel.add(backButton, Integer.valueOf(1));

        this.add(backgroundPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backButton) {
            ServerConnection.logOut();
            new LoginPageScreen();
            this.dispose();
            try {
                objectMapper.writeValue(new File("OfflineUser.jason"), MyProject.allOfflineUsers);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == onlineGameButton) {
            new OnlineGameScreen();
            this.dispose();
        }

        if (e.getSource() == offlineGameButton) {
            new OfflineGameScreen();
            this.dispose();
        }

        if (e.getSource() == LeaderBoardButton) {
            new LeaderBoardScreen();
            this.dispose();
        }

        if (e.getSource() == storeButton) {
            new OfflineStoreScreen();
            this.dispose();
        }

        if (e.getSource() == profileButton) {
            new UserProfileScreen();
            this.dispose();
        }

    }
}
