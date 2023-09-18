package View.Menu;

import Model.Game.Game;
import Model.Game.GameData;
import Model.Game.GameGodFather;
import MyProject.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameScreen extends JFrame implements ActionListener {

    JLayeredPane backgroundPanel;
    JButton backButton;
    JButton firstSaveButton;
    JButton secondSaveButton;
    JButton thirdSaveButton;
    JLabel backgroundImageLabel;
    GameData gameData;

    NewGameScreen(GameData gameData) {
        init(gameData);
    }

    private void init(GameData gameData) {

        ImageIcon backgroundImage = MyProjectData.getProjectData().getGameMenuImage();
        ImageIcon gameIcon = MyProjectData.getProjectData().getGameIcon();
        Font font35 = MyProjectData.getProjectData().getFont35();
        Font font20 = MyProjectData.getProjectData().getFont20();

        this.setSize(650, 700);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setIconImage(gameIcon.getImage());
        this.gameData = gameData;

        backgroundPanel = new JLayeredPane();
        backgroundPanel.setBounds(0, 0, 700, 700);

        backgroundImageLabel = new JLabel(backgroundImage);
        backgroundImageLabel.setBounds(0, 0, 650, 700);
        backgroundImageLabel.setOpaque(true);

        backButton = new JButton("Back");
        backButton.setBounds(555, 0, 85, 50);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.setFont(font20);
        backButton.addActionListener(this);

        firstSaveButton = new JButton("Game 1");
        firstSaveButton.setBounds(200, 180, 250, 70);
        firstSaveButton.setBackground(Color.BLACK);
        firstSaveButton.setForeground(Color.WHITE);
        firstSaveButton.setFocusable(false);
        firstSaveButton.setFont(font35);
        firstSaveButton.addActionListener(this);

        secondSaveButton = new JButton("Game 2");
        secondSaveButton.setBounds(200, 280, 250, 70);
        secondSaveButton.setBackground(Color.BLACK);
        secondSaveButton.setForeground(Color.WHITE);
        secondSaveButton.setFocusable(false);
        secondSaveButton.setFont(font35);
        secondSaveButton.addActionListener(this);

        thirdSaveButton = new JButton("Game 3");
        thirdSaveButton.setBounds(200, 380, 250, 70);
        thirdSaveButton.setBackground(Color.BLACK);
        thirdSaveButton.setForeground(Color.WHITE);
        thirdSaveButton.setFocusable(false);
        thirdSaveButton.setFont(font35);
        thirdSaveButton.addActionListener(this);

        backgroundImageLabel.add(firstSaveButton);
        backgroundImageLabel.add(secondSaveButton);
        backgroundImageLabel.add(thirdSaveButton);
        backgroundImageLabel.add(backButton);

        backgroundPanel.add(backgroundImageLabel, Integer.valueOf(0));
        backgroundPanel.add(firstSaveButton, Integer.valueOf(1));
        backgroundPanel.add(secondSaveButton, Integer.valueOf(1));
        backgroundPanel.add(thirdSaveButton, Integer.valueOf(1));
        backgroundPanel.add(backButton, Integer.valueOf(1));


        this.add(backgroundPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backButton) {
            new OfflineGameScreen();
            this.dispose();
        }

        if (e.getSource() == firstSaveButton) {
            Game newGame = new Game( new GameGodFather(gameData));
            MyProject.activeOfflineUser.getGameSaves().set(0, newGame);
            this.dispose();
        }

        if (e.getSource() == secondSaveButton) {
            Game newGame = new Game(new GameGodFather(gameData));
            MyProject.activeOfflineUser.getGameSaves().set(1, newGame);
            this.dispose();
        }

        if (e.getSource() == thirdSaveButton) {
            Game newGame = new Game( new GameGodFather(gameData));
            MyProject.activeOfflineUser.getGameSaves().set(2, newGame);
            this.dispose();
        }

    }
}
