package View.Menu;

import MyProject.MyProjectData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.swing.*;
import java.awt.*;

public class OnlineGameScreen extends JFrame {


    ObjectMapper objectMapper;
    JLayeredPane backgroundPanel;
    JLabel backgroundImageLabel;
    JButton backButton;
    JButton scoreGameButton;
    JButton createLobbyButton;
    JButton enterLobbyButton;

    public OnlineGameScreen() {

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

        scoreGameButton = new JButton("Score Game");
        scoreGameButton.setBounds(250, 200, 150, 60);
        scoreGameButton.setBackground(Color.BLACK);
        scoreGameButton.setForeground(Color.WHITE);
        scoreGameButton.setFocusable(false);
        scoreGameButton.setFont(font20);

        createLobbyButton = new JButton("Create Lobby");
        createLobbyButton.setBounds(250, 280, 150, 60);
        createLobbyButton.setBackground(Color.BLACK);
        createLobbyButton.setForeground(Color.WHITE);
        createLobbyButton.setFocusable(false);
        createLobbyButton.setFont(font15);

        enterLobbyButton = new JButton("Join Lobby");
        enterLobbyButton.setBounds(250, 360, 150, 60);
        enterLobbyButton.setBackground(Color.BLACK);
        enterLobbyButton.setForeground(Color.WHITE);
        enterLobbyButton.setFocusable(false);
        enterLobbyButton.setFont(font20);

        backgroundPanel.add(backgroundImageLabel, Integer.valueOf(0));
        backgroundPanel.add(createLobbyButton, Integer.valueOf(1));
        backgroundPanel.add(scoreGameButton, Integer.valueOf(1));
        backgroundPanel.add(enterLobbyButton, Integer.valueOf(1));
        backgroundPanel.add(backButton, Integer.valueOf(1));

        add(backgroundPanel);
        addButtonAction();

    }

    private void addButtonAction() {

        backButton.addActionListener(e -> {
            new MainMenuScreen();
            dispose();
        });

    }

}
