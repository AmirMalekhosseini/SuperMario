package View.Menu;

import Model.Game.GameData;
import View.Button.UserProfileChooseMarioButton;
import MyProject.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseCharacterForStartNewGame extends JFrame implements ActionListener {

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
    JButton OKButton;
    JRadioButton easyModeButton;
    JRadioButton normalModeButton;
    JRadioButton hardModeButton;
    ButtonGroup gameModeGroup;
    GameData gameData;

    ChooseCharacterForStartNewGame() {
        init();
    }

    private void init() {

        ImageIcon backgroundImage = MyProjectData.getProjectData().getGameMenuImage();
        ImageIcon gameIcon = MyProjectData.getProjectData().getGameIcon();
        ImageIcon normalMarioImage = MyProjectData.getProjectData().getNormalMarioImage();
        ImageIcon coinMarioImage = MyProjectData.getProjectData().getCoinMarioImage();
        ImageIcon runnerMarioImage = MyProjectData.getProjectData().getRunnerMarioImage();
        ImageIcon shooterMarioImage = MyProjectData.getProjectData().getShooterMarioImage();
        ImageIcon jumperMarioImage = MyProjectData.getProjectData().getJumperMarioImage();

        Font font12 = MyProjectData.getProjectData().getFont12();
        Font font22 = MyProjectData.getProjectData().getFont22();
        Font font10 = MyProjectData.getProjectData().getFont10();


        this.setSize(650, 700);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setIconImage(gameIcon.getImage());

        gameData = new GameData();

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
        if (MyProject.activeOfflineUser.getUserData().isUserChooseNormal_RedMario()) {
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
        if (MyProject.activeOfflineUser.getUserData().isUserChooseRunner_BlueMario()) {
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
        if (MyProject.activeOfflineUser.getUserData().isUserChooseJumper_GreenMario()) {
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
        if (MyProject.activeOfflineUser.getUserData().isUserChooseShooter_BlackMario()) {
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
        if (MyProject.activeOfflineUser.getUserData().isUserChooseCoin_YellowMario()) {
            coinMarioChooseButton.setBackground(Color.GRAY);
            coinMarioChooseButton.setText("Chosen");
        } else {
            coinMarioChooseButton.setBackground(Color.GREEN);
            coinMarioChooseButton.setText("Choose");
        }

        backButton = new JButton("Back");
        backButton.setBounds(555, 0, 85, 50);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.setFont(font22);
        backButton.addActionListener(this);

        OKButton = new JButton("OK");
        OKButton.setBounds(500, 550, 65, 45);
        OKButton.setBackground(Color.BLACK);
        OKButton.setForeground(Color.WHITE);
        OKButton.setFocusable(false);
        OKButton.setFont(font22);
        OKButton.addActionListener(this);

        easyModeButton = new JRadioButton("Easy");
        easyModeButton.addActionListener(this);
        easyModeButton.setBounds(20, 20, 80, 50);
        easyModeButton.setBackground(Color.red);
        easyModeButton.setFocusable(false);

        normalModeButton = new JRadioButton("Normal");
        normalModeButton.addActionListener(this);
        normalModeButton.setBounds(100, 20, 80, 50);
        normalModeButton.setBackground(Color.red);
        normalModeButton.setFocusable(false);

        hardModeButton = new JRadioButton("Hard");
        hardModeButton.addActionListener(this);
        hardModeButton.setBounds(180, 20, 80, 50);
        hardModeButton.setBackground(Color.red);
        hardModeButton.setFocusable(false);

        gameModeGroup = new ButtonGroup();
        gameModeGroup.add(easyModeButton);
        gameModeGroup.add(normalModeButton);
        gameModeGroup.add(hardModeButton);

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

        backgroundPanel.add(backButton, Integer.valueOf(1));
        backgroundPanel.add(OKButton, Integer.valueOf(1));
        backgroundPanel.add(easyModeButton, Integer.valueOf(1));
        backgroundPanel.add(normalModeButton, Integer.valueOf(1));
        backgroundPanel.add(hardModeButton, Integer.valueOf(1));

        this.add(backgroundPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == easyModeButton) {
            gameData.setGameMode("hard");
        } else if (e.getSource() == normalModeButton) {
            gameData.setGameMode("normal");
        } else if (e.getSource() == hardModeButton) {
            gameData.setGameMode("hard");
        }

        if (e.getSource() == backButton) {
            new MainMenuScreen();
            this.dispose();
        }

        if (e.getSource() == OKButton) {
            new NewGameScreen(gameData);
            this.dispose();
        }

        if (e.getSource() == normalMarioChooseButton) {// OfflineUser choose normal mario

            if(normalMarioChooseButton.isButtonChoose()) {
                if (MyProject.activeOfflineUser.getUserData().isUserBoughtNormalMario()) {
                    normalMarioChooseButton.setBackground(Color.GRAY);
                    normalMarioChooseButton.setText("Chosen");
                    normalMarioChooseButton.setButtonChoose(true);
                    MyProject.activeOfflineUser.getUserData().setUserChooseNormal_RedMario(true);
                    MyProject.activeOfflineUser.getUserData().setUserChooseRunner_BlueMario(false);
                    MyProject.activeOfflineUser.getUserData().setUserChooseJumper_GreenMario(false);
                    MyProject.activeOfflineUser.getUserData().setUserChooseShooter_BlackMario(false);
                    MyProject.activeOfflineUser.getUserData().setUserChooseCoin_YellowMario(false);
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
                MyProject.activeOfflineUser.getUserData().setUserChooseNormal_RedMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseRunner_BlueMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseJumper_GreenMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseShooter_BlackMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseCoin_YellowMario(false);
            }

        }

        if (e.getSource() == runnerMarioChooseButton) {// OfflineUser choose runner mario

            if(runnerMarioChooseButton.isButtonChoose()) {
                if (MyProject.activeOfflineUser.getUserData().isUserBoughtRunnerMario()) {
                    runnerMarioChooseButton.setBackground(Color.GRAY);
                    runnerMarioChooseButton.setText("Chosen");
                    runnerMarioChooseButton.setButtonChoose(true);
                    MyProject.activeOfflineUser.getUserData().setUserChooseNormal_RedMario(false);
                    MyProject.activeOfflineUser.getUserData().setUserChooseRunner_BlueMario(true);
                    MyProject.activeOfflineUser.getUserData().setUserChooseJumper_GreenMario(false);
                    MyProject.activeOfflineUser.getUserData().setUserChooseShooter_BlackMario(false);
                    MyProject.activeOfflineUser.getUserData().setUserChooseCoin_YellowMario(false);
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
                MyProject.activeOfflineUser.getUserData().setUserChooseRunner_BlueMario(false);
                runnerMarioChooseButton.setBackground(Color.GREEN);
                runnerMarioChooseButton.setText("Choose");
                runnerMarioChooseButton.setButtonChoose(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseNormal_RedMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseRunner_BlueMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseJumper_GreenMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseShooter_BlackMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseCoin_YellowMario(false);
            }

        }

        if (e.getSource() == jumperMarioChooseButton) {

            if(jumperMarioChooseButton.isButtonChoose()) {// OfflineUser choose jumper mario
                if (MyProject.activeOfflineUser.getUserData().isUserBoughtJumperMario()) {
                    jumperMarioChooseButton.setBackground(Color.GRAY);
                    jumperMarioChooseButton.setText("Chosen");
                    jumperMarioChooseButton.setButtonChoose(true);
                    MyProject.activeOfflineUser.getUserData().setUserChooseNormal_RedMario(false);
                    MyProject.activeOfflineUser.getUserData().setUserChooseRunner_BlueMario(false);
                    MyProject.activeOfflineUser.getUserData().setUserChooseJumper_GreenMario(true);
                    MyProject.activeOfflineUser.getUserData().setUserChooseShooter_BlackMario(false);
                    MyProject.activeOfflineUser.getUserData().setUserChooseCoin_YellowMario(false);
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
                MyProject.activeOfflineUser.getUserData().setUserChooseJumper_GreenMario(false);
                jumperMarioChooseButton.setBackground(Color.GREEN);
                jumperMarioChooseButton.setText("Choose");
                jumperMarioChooseButton.setButtonChoose(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseNormal_RedMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseRunner_BlueMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseJumper_GreenMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseShooter_BlackMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseCoin_YellowMario(false);
            }

        }

        if (e.getSource() == shooterMarioChooseButton) {

            if(shooterMarioChooseButton.isButtonChoose()) {// OfflineUser choose shooter mario
                if (MyProject.activeOfflineUser.getUserData().isUserBoughtShooterMario()) {
                    shooterMarioChooseButton.setBackground(Color.GRAY);
                    shooterMarioChooseButton.setText("Chosen");
                    shooterMarioChooseButton.setButtonChoose(true);
                    MyProject.activeOfflineUser.getUserData().setUserChooseNormal_RedMario(false);
                    MyProject.activeOfflineUser.getUserData().setUserChooseRunner_BlueMario(false);
                    MyProject.activeOfflineUser.getUserData().setUserChooseJumper_GreenMario(false);
                    MyProject.activeOfflineUser.getUserData().setUserChooseShooter_BlackMario(true);
                    MyProject.activeOfflineUser.getUserData().setUserChooseCoin_YellowMario(false);
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
                MyProject.activeOfflineUser.getUserData().setUserChooseShooter_BlackMario(false);
                shooterMarioChooseButton.setBackground(Color.GREEN);
                shooterMarioChooseButton.setText("Choose");
                shooterMarioChooseButton.setButtonChoose(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseNormal_RedMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseRunner_BlueMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseJumper_GreenMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseShooter_BlackMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseCoin_YellowMario(false);
            }

        }

        if (e.getSource() == coinMarioChooseButton) {

            if (coinMarioChooseButton.isButtonChoose()) {// OfflineUser choose coin mario
                if (MyProject.activeOfflineUser.getUserData().isUserBoughtCoinMario()) {
                    coinMarioChooseButton.setBackground(Color.GRAY);
                    coinMarioChooseButton.setText("Chosen");
                    coinMarioChooseButton.setButtonChoose(true);
                    MyProject.activeOfflineUser.getUserData().setUserChooseNormal_RedMario(false);
                    MyProject.activeOfflineUser.getUserData().setUserChooseRunner_BlueMario(false);
                    MyProject.activeOfflineUser.getUserData().setUserChooseJumper_GreenMario(false);
                    MyProject.activeOfflineUser.getUserData().setUserChooseShooter_BlackMario(false);
                    MyProject.activeOfflineUser.getUserData().setUserChooseCoin_YellowMario(true);
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
                MyProject.activeOfflineUser.getUserData().setUserChooseCoin_YellowMario(false);
                coinMarioChooseButton.setBackground(Color.GREEN);
                coinMarioChooseButton.setText("Choose");
                coinMarioChooseButton.setButtonChoose(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseNormal_RedMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseRunner_BlueMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseJumper_GreenMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseShooter_BlackMario(false);
                MyProject.activeOfflineUser.getUserData().setUserChooseCoin_YellowMario(false);
            }

        }
    }


}
