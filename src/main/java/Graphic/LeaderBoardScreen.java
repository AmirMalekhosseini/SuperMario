package Graphic;

import MyProject.MyProject;
import Model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class LeaderBoardScreen extends JFrame implements ActionListener {


    ArrayList<Integer> scores = new ArrayList<>();
    JLayeredPane backgroundPanel;
    JLabel backgroundImageLabel;
    int firstScore;
    int secondScore;
    int thirdScore;
    String firstUsername;
    String secondUsername;
    String thirdUsername;
    JTextField firstUser;
    JTextField secondUser;
    JTextField thirdUser;
    JButton backButton;

    public LeaderBoardScreen() {

        ImageIcon backgroundImage = MyProject.projectData.getGameMenuImage();
        ImageIcon gameIcon = MyProject.projectData.getGameIcon();
        Font font20 = MyProject.projectData.getFont20();
        Font font35 = MyProject.projectData.getFont35();

        scores.add(-1);
        scores.add(-1);
        scores.add(-1);

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

        calculateHighestScore();
        calculateUsername();

        firstUser = new JTextField(firstUsername + ": " + firstScore);
        firstUser.setBounds(100, 150, 500, 100);
        firstUser.setFont(font35);
        firstUser.setBackground(Color.red);
        firstUser.setFocusable(false);

        secondUser = new JTextField(secondUsername + ": " + secondScore);
        secondUser.setBounds(100, 250, 500, 100);
        secondUser.setFont(font35);
        secondUser.setBackground(Color.red);
        secondUser.setFocusable(false);

        thirdUser = new JTextField(thirdUsername + ": " + thirdScore);
        thirdUser.setBounds(100, 350, 500, 100);
        thirdUser.setFont(font35);
        thirdUser.setBackground(Color.red);
        thirdUser.setFocusable(false);

        backButton = new JButton("Back");
        backButton.setBounds(555, 0, 85, 50);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.setFont(font20);
        backButton.addActionListener(this);

        backgroundPanel.add(backgroundImageLabel, Integer.valueOf(0));
        backgroundPanel.add(firstUser, Integer.valueOf(1));
        backgroundPanel.add(secondUser, Integer.valueOf(1));
        backgroundPanel.add(thirdUser, Integer.valueOf(1));
        backgroundPanel.add(backButton, Integer.valueOf(1));

        this.add(backgroundPanel);

    }

    public void calculateHighestScore() {
        for (int i = 0; i < MyProject.allUsers.size(); i++) {
            scores.add(MyProject.allUsers.get(i).getUserHighScore().getUserScore());
        }
        Collections.sort(scores);
        int scoresSize = scores.size();
        for (int i = 0; i < scores.size(); i++) {
            if (i == 0) {
                firstScore = scores.get(scoresSize - 1);
            }
            if (i == 1) {
                secondScore = scores.get(scoresSize - 2);
            }
            if (i == 2) {
                thirdScore = scores.get(scoresSize - 3);
                break;
            }
        }

    }

    public void calculateUsername() {
        for (int i = 0; i < MyProject.allUsers.size(); i++) {
            if (MyProject.allUsers.get(i).getUserHighScore().getUserScore() == scores.get(scores.size() - 1)) {
                firstUsername = MyProject.allUsers.get(i).getUsername();
                continue;
            }
            if (MyProject.allUsers.get(i).getUserHighScore().getUserScore() == scores.get(scores.size() - 2)) {
                secondUsername = MyProject.allUsers.get(i).getUsername();
                continue;
            }
            if (MyProject.allUsers.get(i).getUserHighScore().getUserScore() == scores.get(scores.size() - 3)) {
                thirdUsername = MyProject.allUsers.get(i).getUsername();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            new MainMenuScreen();
            this.dispose();
        }
    }
}
