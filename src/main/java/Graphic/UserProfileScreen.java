package Graphic;

import MyProject.MyProject;
import Model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class UserProfileScreen extends JFrame implements ActionListener {

    ObjectMapper objectMapper;
    JLayeredPane backgroundPanel;
    JLabel backgroundImageLabel;
    JLabel normalMario;
    JLabel normalMarioName;
    UserProfileChooseMarioButton normalMarioChooseButton;
    JLabel coinMario;
    JLabel coinMarioName;
    UserProfileChooseMarioButton coinMarioChooseButton;
    JLabel runnerMario;
    JLabel runnerMarioName;
    UserProfileChooseMarioButton runnerMarioChooseButton;
    JLabel jumperMario;
    JLabel jumperMarioName;
    UserProfileChooseMarioButton jumperMarioChooseButton;
    JLabel shooterMario;
    JLabel shooterMarioName;
    UserProfileChooseMarioButton shooterMarioChooseButton;

    JButton backButton;
    CoinForStore userCoin;
    JLabel userCoinValue;
    JLabel userName;
    JLabel userHighScore;


    public UserProfileScreen() {
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        ImageIcon backgroundImage = MyProject.projectData.getGameMenuImage();
        ImageIcon gameIcon = MyProject.projectData.getGameIcon();
        ImageIcon normalMarioImage = MyProject.projectData.getNormalMarioImage();
        ImageIcon coinMarioImage = MyProject.projectData.getCoinMarioImage();
        ImageIcon runnerMarioImage = MyProject.projectData.getRunnerMarioImage();
        ImageIcon shooterMarioImage = MyProject.projectData.getShooterMarioImage();
        ImageIcon jumperMarioImage = MyProject.projectData.getJumperMarioImage();

        Font font12 = MyProject.projectData.getFont12();
        Font font22 = MyProject.projectData.getFont22();
        Font font10 = MyProject.projectData.getFont10();


        this.setSize(650, 700);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setIconImage(gameIcon.getImage());

        backgroundPanel = new JLayeredPane();
        backgroundPanel.setBounds(0, 0, 700, 720);

        backgroundImageLabel = new JLabel(backgroundImage);
        backgroundImageLabel.setBounds(0, 0, 670, 700);

        normalMario = new JLabel(normalMarioImage);
        normalMario.setBounds(30, 250, 70, 120);
        normalMarioName = new JLabel("Normal Mario");
        normalMarioName.setBounds(30, 200, 80, 50);
        normalMarioName.setFont(font12);

        normalMarioChooseButton = new UserProfileChooseMarioButton();
        normalMarioChooseButton.setBounds(33, 420, 70, 35);
        normalMarioChooseButton.setForeground(Color.BLACK);
        normalMarioChooseButton.setFocusable(false);
        normalMarioChooseButton.setFont(font10);
        normalMarioChooseButton.addActionListener(this);
        normalMarioChooseButton.setButtonChoose(true);
        if (MyProject.activeUser.get(0).isUserChooseNormal_RedMario()) {
            normalMarioChooseButton.setBackground(Color.GRAY);
            normalMarioChooseButton.setText("Chosen");
        } else {
            normalMarioChooseButton.setBackground(Color.GREEN);
            normalMarioChooseButton.setText("Choose");
        }

        runnerMario = new JLabel(runnerMarioImage);
        runnerMario.setBounds(160, 250, 70, 120);
        runnerMarioName = new JLabel("Runner Mario");
        runnerMarioName.setBounds(160, 200, 80, 50);
        runnerMarioName.setFont(font12);
        runnerMarioChooseButton = new UserProfileChooseMarioButton();
        runnerMarioChooseButton.setBounds(158, 420, 70, 35);
        runnerMarioChooseButton.setForeground(Color.BLACK);
        runnerMarioChooseButton.setFocusable(false);
        runnerMarioChooseButton.setFont(font10);
        runnerMarioChooseButton.addActionListener(this);
        if (MyProject.activeUser.get(0).isUserChooseRunner_BlueMario()) {
            runnerMarioChooseButton.setBackground(Color.GRAY);
            runnerMarioChooseButton.setText("Chosen");
        } else {
            runnerMarioChooseButton.setBackground(Color.GREEN);
            runnerMarioChooseButton.setText("Choose");
        }

        jumperMario = new JLabel(jumperMarioImage);
        jumperMario.setBounds(290, 250, 70, 120);
        jumperMarioName = new JLabel("Jumper Mario");
        jumperMarioName.setBounds(290, 200, 80, 50);
        jumperMarioName.setFont(font12);
        jumperMarioChooseButton = new UserProfileChooseMarioButton();
        jumperMarioChooseButton.setBounds(288, 420, 70, 35);
        jumperMarioChooseButton.setForeground(Color.BLACK);
        jumperMarioChooseButton.setFocusable(false);
        jumperMarioChooseButton.setFont(font10);
        jumperMarioChooseButton.addActionListener(this);
        if (MyProject.activeUser.get(0).isUserChooseJumper_GreenMario()) {
            jumperMarioChooseButton.setBackground(Color.GRAY);
            jumperMarioChooseButton.setText("Chosen");
        } else {
            jumperMarioChooseButton.setBackground(Color.GREEN);
            jumperMarioChooseButton.setText("Choose");
        }

        shooterMario = new JLabel(shooterMarioImage);
        shooterMario.setBounds(420, 250, 70, 120);
        shooterMarioName = new JLabel("Shooter Mario");
        shooterMarioName.setBounds(420, 200, 85, 50);
        shooterMarioName.setFont(font12);
        shooterMarioChooseButton = new UserProfileChooseMarioButton();
        shooterMarioChooseButton.setBounds(418, 420, 70, 35);
        shooterMarioChooseButton.setForeground(Color.BLACK);
        shooterMarioChooseButton.setFocusable(false);
        shooterMarioChooseButton.setFont(font10);
        shooterMarioChooseButton.addActionListener(this);
        if (MyProject.activeUser.get(0).isUserChooseShooter_BlackMario()) {
            shooterMarioChooseButton.setBackground(Color.GRAY);
            shooterMarioChooseButton.setText("Chosen");
        } else {
            shooterMarioChooseButton.setBackground(Color.GREEN);
            shooterMarioChooseButton.setText("Choose");
        }

        coinMario = new JLabel(coinMarioImage);
        coinMario.setBounds(550, 250, 70, 120);
        coinMarioName = new JLabel("Coin Mario");
        coinMarioName.setBounds(550, 200, 80, 50);
        coinMarioName.setFont(font12);
        coinMarioChooseButton = new UserProfileChooseMarioButton();
        coinMarioChooseButton.setBounds(548, 420, 70, 35);
        coinMarioChooseButton.setForeground(Color.BLACK);
        coinMarioChooseButton.setFocusable(false);
        coinMarioChooseButton.setFont(font10);
        coinMarioChooseButton.addActionListener(this);
        if (MyProject.activeUser.get(0).isUserChooseCoin_YellowMario()) {
            coinMarioChooseButton.setBackground(Color.GRAY);
            coinMarioChooseButton.setText("Chosen");
        } else {
            coinMarioChooseButton.setBackground(Color.GREEN);
            coinMarioChooseButton.setText("Choose");
        }

        userCoinValue = new JLabel(String.valueOf(MyProject.activeUser.get(0).getUserCoinValue()));
        userCoinValue.setBounds(40, 85, 55, 40);
        userCoinValue.setFont(font22);

        userCoin = new CoinForStore(5, 94);
        userCoin.setLocation(userCoin.getX(), userCoin.getY());

        userName = new JLabel(String.valueOf(MyProject.activeUser.get(0).getUsername()));
        userName.setBounds(10, 0, 200, 40);
        userName.setFont(font22);

        userHighScore = new JLabel("HighScore: " + String.valueOf(MyProject.activeUser.get(0).getUserHighScore().getUserScore()));
        userHighScore.setBounds(10, 40, 200, 40);
        userHighScore.setFont(font22);

        backButton = new JButton("Back");
        backButton.setBounds(555, 0, 85, 50);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.setFont(font22);
        backButton.addActionListener(this);

        backgroundPanel.add(backgroundImageLabel, Integer.valueOf(0));
        backgroundPanel.add(normalMario, Integer.valueOf(1));
        backgroundPanel.add(normalMarioName, Integer.valueOf(1));
        backgroundPanel.add(normalMarioChooseButton, Integer.valueOf(1));

        backgroundPanel.add(runnerMario, Integer.valueOf(1));
        backgroundPanel.add(runnerMarioName, Integer.valueOf(1));
        backgroundPanel.add(runnerMarioChooseButton, Integer.valueOf(1));

        backgroundPanel.add(jumperMario, Integer.valueOf(1));
        backgroundPanel.add(jumperMarioName, Integer.valueOf(1));
        backgroundPanel.add(jumperMarioChooseButton, Integer.valueOf(1));

        backgroundPanel.add(shooterMario, Integer.valueOf(1));
        backgroundPanel.add(shooterMarioName, Integer.valueOf(1));
        backgroundPanel.add(shooterMarioChooseButton, Integer.valueOf(1));

        backgroundPanel.add(coinMario, Integer.valueOf(1));
        backgroundPanel.add(coinMarioName, Integer.valueOf(1));
        backgroundPanel.add(coinMarioChooseButton, Integer.valueOf(1));

        backgroundPanel.add(userCoinValue, Integer.valueOf(1));
        backgroundPanel.add(userCoin, Integer.valueOf(1));
        backgroundPanel.add(backButton, Integer.valueOf(1));
        backgroundPanel.add(userName, Integer.valueOf(1));
        backgroundPanel.add(userHighScore, Integer.valueOf(1));

        this.add(backgroundPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backButton) {
            new MainMenuScreen();
            this.dispose();
            try {
                objectMapper.writeValue(new File("User.jason"), MyProject.allUsers);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == normalMarioChooseButton) {// User choose normal mario

            if(!normalMarioChooseButton.isButtonChoose()) {
                if (MyProject.activeUser.get(0).isUserBoughtNormalMario()) {
                    normalMarioChooseButton.setBackground(Color.GRAY);
                    normalMarioChooseButton.setText("Chosen");
                    normalMarioChooseButton.setButtonChoose(true);
                    MyProject.activeUser.get(0).setUserChooseNormal_RedMario(true);
                    MyProject.activeUser.get(0).setUserChooseRunner_BlueMario(false);
                    MyProject.activeUser.get(0).setUserChooseJumper_GreenMario(false);
                    MyProject.activeUser.get(0).setUserChooseShooter_BlackMario(false);
                    MyProject.activeUser.get(0).setUserChooseCoin_YellowMario(false);
                    runnerMarioChooseButton.setBackground(Color.GREEN);
                    runnerMarioChooseButton.setText("Choose");
                    runnerMarioChooseButton.setButtonChoose(false);
                    jumperMarioChooseButton.setBackground(Color.GREEN);
                    jumperMarioChooseButton.setText("Choose");
                    jumperMarioChooseButton.setButtonChoose(false);
                    shooterMarioChooseButton.setBackground(Color.GREEN);
                    shooterMarioChooseButton.setText("Choose");
                    shooterMarioChooseButton.setButtonChoose(false);
                    coinMarioChooseButton.setBackground(Color.GREEN);
                    coinMarioChooseButton.setText("Choose");
                    coinMarioChooseButton.setButtonChoose(false);
                }
            }else {
                normalMarioChooseButton.setBackground(Color.GREEN);
                normalMarioChooseButton.setText("Choose");
                normalMarioChooseButton.setButtonChoose(false);
                MyProject.activeUser.get(0).setUserChooseNormal_RedMario(false);
                MyProject.activeUser.get(0).setUserChooseRunner_BlueMario(false);
                MyProject.activeUser.get(0).setUserChooseJumper_GreenMario(false);
                MyProject.activeUser.get(0).setUserChooseShooter_BlackMario(false);
                MyProject.activeUser.get(0).setUserChooseCoin_YellowMario(false);
            }

        }

        if (e.getSource() == runnerMarioChooseButton) {// User choose runner mario

            if(!runnerMarioChooseButton.isButtonChoose()) {// Choose Mario
                if (MyProject.activeUser.get(0).isUserBoughtRunnerMario()) {
                    runnerMarioChooseButton.setBackground(Color.GRAY);
                    runnerMarioChooseButton.setText("Chosen");
                    runnerMarioChooseButton.setButtonChoose(true);
                    MyProject.activeUser.get(0).setUserChooseNormal_RedMario(false);
                    MyProject.activeUser.get(0).setUserChooseRunner_BlueMario(true);
                    MyProject.activeUser.get(0).setUserChooseJumper_GreenMario(false);
                    MyProject.activeUser.get(0).setUserChooseShooter_BlackMario(false);
                    MyProject.activeUser.get(0).setUserChooseCoin_YellowMario(false);
                    normalMarioChooseButton.setBackground(Color.GREEN);
                    normalMarioChooseButton.setText("Choose");
                    normalMarioChooseButton.setButtonChoose(false);
                    jumperMarioChooseButton.setBackground(Color.GREEN);
                    jumperMarioChooseButton.setText("Choose");
                    jumperMarioChooseButton.setButtonChoose(false);
                    shooterMarioChooseButton.setBackground(Color.GREEN);
                    shooterMarioChooseButton.setText("Choose");
                    shooterMarioChooseButton.setButtonChoose(false);
                    coinMarioChooseButton.setBackground(Color.GREEN);
                    coinMarioChooseButton.setText("Choose");
                    coinMarioChooseButton.setButtonChoose(false);
                }
            }else {
                MyProject.activeUser.get(0).setUserChooseRunner_BlueMario(false);
                runnerMarioChooseButton.setBackground(Color.GREEN);
                runnerMarioChooseButton.setText("Choose");
                runnerMarioChooseButton.setButtonChoose(false);
                MyProject.activeUser.get(0).setUserChooseNormal_RedMario(false);
                MyProject.activeUser.get(0).setUserChooseRunner_BlueMario(false);
                MyProject.activeUser.get(0).setUserChooseJumper_GreenMario(false);
                MyProject.activeUser.get(0).setUserChooseShooter_BlackMario(false);
                MyProject.activeUser.get(0).setUserChooseCoin_YellowMario(false);

            }

        }

        if (e.getSource() == jumperMarioChooseButton) {

            if(!jumperMarioChooseButton.isButtonChoose()) {// User choose jumper mario
                if (MyProject.activeUser.get(0).isUserBoughtJumperMario()) {
                    jumperMarioChooseButton.setBackground(Color.GRAY);
                    jumperMarioChooseButton.setText("Chosen");
                    jumperMarioChooseButton.setButtonChoose(true);
                    MyProject.activeUser.get(0).setUserChooseNormal_RedMario(false);
                    MyProject.activeUser.get(0).setUserChooseRunner_BlueMario(false);
                    MyProject.activeUser.get(0).setUserChooseJumper_GreenMario(true);
                    MyProject.activeUser.get(0).setUserChooseShooter_BlackMario(false);
                    MyProject.activeUser.get(0).setUserChooseCoin_YellowMario(false);
                    normalMarioChooseButton.setBackground(Color.GREEN);
                    normalMarioChooseButton.setText("Choose");
                    normalMarioChooseButton.setButtonChoose(false);
                    runnerMarioChooseButton.setBackground(Color.GREEN);
                    runnerMarioChooseButton.setText("Choose");
                    runnerMarioChooseButton.setButtonChoose(false);
                    shooterMarioChooseButton.setBackground(Color.GREEN);
                    shooterMarioChooseButton.setText("Choose");
                    shooterMarioChooseButton.setButtonChoose(false);
                    coinMarioChooseButton.setBackground(Color.GREEN);
                    coinMarioChooseButton.setText("Choose");
                    coinMarioChooseButton.setButtonChoose(false);
                }
            }else {
                MyProject.activeUser.get(0).setUserChooseJumper_GreenMario(false);
                jumperMarioChooseButton.setBackground(Color.GREEN);
                jumperMarioChooseButton.setText("Choose");
                jumperMarioChooseButton.setButtonChoose(false);
                MyProject.activeUser.get(0).setUserChooseNormal_RedMario(false);
                MyProject.activeUser.get(0).setUserChooseRunner_BlueMario(false);
                MyProject.activeUser.get(0).setUserChooseJumper_GreenMario(false);
                MyProject.activeUser.get(0).setUserChooseShooter_BlackMario(false);
                MyProject.activeUser.get(0).setUserChooseCoin_YellowMario(false);
            }

        }

        if (e.getSource() == shooterMarioChooseButton) {

            if(!shooterMarioChooseButton.isButtonChoose()) {// User choose shooter mario
                if (MyProject.activeUser.get(0).isUserBoughtShooterMario()) {
                    shooterMarioChooseButton.setBackground(Color.GRAY);
                    shooterMarioChooseButton.setText("Chosen");
                    shooterMarioChooseButton.setButtonChoose(true);
                    MyProject.activeUser.get(0).setUserChooseNormal_RedMario(false);
                    MyProject.activeUser.get(0).setUserChooseRunner_BlueMario(false);
                    MyProject.activeUser.get(0).setUserChooseJumper_GreenMario(false);
                    MyProject.activeUser.get(0).setUserChooseShooter_BlackMario(true);
                    MyProject.activeUser.get(0).setUserChooseCoin_YellowMario(false);
                    normalMarioChooseButton.setBackground(Color.GREEN);
                    normalMarioChooseButton.setText("Choose");
                    normalMarioChooseButton.setButtonChoose(false);
                    runnerMarioChooseButton.setBackground(Color.GREEN);
                    runnerMarioChooseButton.setText("Choose");
                    runnerMarioChooseButton.setButtonChoose(false);
                    jumperMarioChooseButton.setBackground(Color.GREEN);
                    jumperMarioChooseButton.setText("Choose");
                    jumperMarioChooseButton.setButtonChoose(false);
                    coinMarioChooseButton.setBackground(Color.GREEN);
                    coinMarioChooseButton.setText("Choose");
                    coinMarioChooseButton.setButtonChoose(false);
                }
            }else {
                MyProject.activeUser.get(0).setUserChooseShooter_BlackMario(false);
                shooterMarioChooseButton.setBackground(Color.GREEN);
                shooterMarioChooseButton.setText("Choose");
                shooterMarioChooseButton.setButtonChoose(false);
                MyProject.activeUser.get(0).setUserChooseNormal_RedMario(false);
                MyProject.activeUser.get(0).setUserChooseRunner_BlueMario(false);
                MyProject.activeUser.get(0).setUserChooseJumper_GreenMario(false);
                MyProject.activeUser.get(0).setUserChooseShooter_BlackMario(false);
                MyProject.activeUser.get(0).setUserChooseCoin_YellowMario(false);
            }

        }

        if (e.getSource() == coinMarioChooseButton) {

            if (!coinMarioChooseButton.isButtonChoose()) {// User choose coin mario
                if (MyProject.activeUser.get(0).isUserBoughtCoinMario()) {
                    coinMarioChooseButton.setBackground(Color.GRAY);
                    coinMarioChooseButton.setText("Chosen");
                    coinMarioChooseButton.setButtonChoose(true);
                    MyProject.activeUser.get(0).setUserChooseNormal_RedMario(false);
                    MyProject.activeUser.get(0).setUserChooseRunner_BlueMario(false);
                    MyProject.activeUser.get(0).setUserChooseJumper_GreenMario(false);
                    MyProject.activeUser.get(0).setUserChooseShooter_BlackMario(false);
                    MyProject.activeUser.get(0).setUserChooseCoin_YellowMario(true);
                    normalMarioChooseButton.setBackground(Color.GREEN);
                    normalMarioChooseButton.setText("Choose");
                    normalMarioChooseButton.setButtonChoose(false);
                    runnerMarioChooseButton.setBackground(Color.GREEN);
                    runnerMarioChooseButton.setText("Choose");
                    runnerMarioChooseButton.setButtonChoose(false);
                    jumperMarioChooseButton.setBackground(Color.GREEN);
                    jumperMarioChooseButton.setText("Choose");
                    jumperMarioChooseButton.setButtonChoose(false);
                    shooterMarioChooseButton.setBackground(Color.GREEN);
                    shooterMarioChooseButton.setText("Choose");
                    shooterMarioChooseButton.setButtonChoose(false);
                }
            } else {
                MyProject.activeUser.get(0).setUserChooseCoin_YellowMario(false);
                coinMarioChooseButton.setBackground(Color.GREEN);
                coinMarioChooseButton.setText("Choose");
                coinMarioChooseButton.setButtonChoose(false);
                MyProject.activeUser.get(0).setUserChooseNormal_RedMario(false);
                MyProject.activeUser.get(0).setUserChooseRunner_BlueMario(false);
                MyProject.activeUser.get(0).setUserChooseJumper_GreenMario(false);
                MyProject.activeUser.get(0).setUserChooseShooter_BlackMario(false);
                MyProject.activeUser.get(0).setUserChooseCoin_YellowMario(false);
            }

        }
    }
}

