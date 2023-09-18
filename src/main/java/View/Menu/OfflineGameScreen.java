package View.Menu;

import MyProject.MyProjectData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javax.swing.*;
import java.awt.*;


public class OfflineGameScreen extends JFrame {

    ObjectMapper objectMapper;
    JLayeredPane backgroundPanel;
    JLabel backgroundImageLabel;
    JButton backButton;
    JButton continueButton;
    JButton newGameButton;

    public OfflineGameScreen() {

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

        continueButton = new JButton("Continue");
        continueButton.setBounds(350, 290, 150, 60);
        continueButton.setBackground(Color.BLACK);
        continueButton.setForeground(Color.WHITE);
        continueButton.setFocusable(false);
        continueButton.setFont(font20);

        newGameButton = new JButton("New Game");
        newGameButton.setBounds(150, 290, 150, 60);
        newGameButton.setBackground(Color.BLACK);
        newGameButton.setForeground(Color.WHITE);
        newGameButton.setFocusable(false);
        newGameButton.setFont(font20);

        backgroundPanel.add(backgroundImageLabel, Integer.valueOf(0));
        backgroundPanel.add(continueButton, Integer.valueOf(1));
        backgroundPanel.add(newGameButton, Integer.valueOf(1));
        backgroundPanel.add(backButton, Integer.valueOf(1));

        add(backgroundPanel);
        addButtonAction();

    }

    private void addButtonAction() {

        backButton.addActionListener(e -> {
            new MainMenuScreen();
            dispose();
        });

        continueButton.addActionListener(e ->{
            new ContinueGameScreen();
            dispose();
        });

        newGameButton.addActionListener(e -> {
            new ChooseCharacterForStartNewGame();
            dispose();
        });


    }

}
