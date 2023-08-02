package View.Menu;

import Controller.Menu.StoreBuyLogic;
import View.Button.StoreBuyButton;
import Model.Item.CoinForStore;
import Model.Item.Online.Diamond;
import Model.Mario.*;
import MyProject.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class OfflineStoreScreen extends JFrame implements ActionListener {

    ObjectMapper objectMapper;
    JLayeredPane backgroundPanel;
    JLabel backgroundImageLabel;
    Mario normalMario;
    JLabel normalMarioName;
    CoinForStore normalMarioCoin;
    StoreBuyButton normalMarioBuyButton;
    JLabel normalMarioPriceTag;
    Mario coinMario;
    JLabel coinMarioName;
    CoinForStore coinMarioCoin;
    StoreBuyButton coinMarioBuyButton;
    JLabel coinMarioPriceTag;
    Mario runnerMario;
    JLabel runnerMarioName;
    CoinForStore runnerMarioCoin;
    StoreBuyButton runnerMarioBuyButton;
    JLabel runnerMarioPriceTag;
    Mario jumperMario;
    JLabel jumperMarioName;
    CoinForStore jumperMarioCoin;
    StoreBuyButton jumperMarioBuyButton;
    JLabel jumperMarioPriceTag;
    Mario shooterMario;
    JLabel shooterMarioName;
    CoinForStore shooterMarioCoin;
    StoreBuyButton shooterMarioBuyButton;
    JLabel shooterMarioPriceTag;

    JButton onlineStoreButton;
    JButton backButton;
    CoinForStore userCoin;
    public JLabel userCoinValue;
    public JLabel userDiamondValue;
    Diamond userDiamond;


    OfflineStoreScreen() {
        init();
    }

    private void init() {

        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        ImageIcon backgroundImage = MyProjectData.getProjectData().getGameMenuImage();
        ImageIcon gameIcon = MyProjectData.getProjectData().getGameIcon();


        Font font10 = MyProjectData.getProjectData().getFont10();
        Font font12 = MyProjectData.getProjectData().getFont12();
        Font font22 = MyProjectData.getProjectData().getFont22();

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

        normalMario = new NormalMario(30, 250, true);
        normalMarioName = new JLabel("Normal Mario");
        normalMarioName.setBounds(30, 200, 80, 50);
        normalMarioName.setFont(font12);
        normalMarioPriceTag = new JLabel("0");
        normalMarioPriceTag.setBounds(50, 378, 25, 25);
        normalMarioPriceTag.setFont(font22);
        normalMarioCoin = new CoinForStore(70, 380);
        normalMarioCoin.setLocation(normalMarioCoin.getX(), normalMarioCoin.getY());
        normalMarioBuyButton = new StoreBuyButton(normalMario);
        normalMarioBuyButton.setBounds(33, 420, 70, 35);
        normalMarioBuyButton.setForeground(Color.BLACK);
        normalMarioBuyButton.setFocusable(false);
        normalMarioBuyButton.setFont(font10);
        normalMarioBuyButton.addActionListener(this);
        if (MyProject.activeOfflineUser.getUserData().isUserBoughtNormalMario()) {
            normalMarioBuyButton.setBackground(Color.GRAY);
            normalMarioBuyButton.setText("Bought");
        } else {
            normalMarioBuyButton.setBackground(Color.GREEN);
            normalMarioBuyButton.setText("Buy");
        }

        runnerMario = new RunnerMario(160, 250, true);
        runnerMarioName = new JLabel("Runner Mario");
        runnerMarioName.setBounds(160, 200, 80, 50);
        runnerMarioName.setFont(font12);
        runnerMarioPriceTag = new JLabel(String.valueOf(StoreBuyLogic.runnerMarioPrice));
        runnerMarioPriceTag.setBounds(170, 378, 30, 30);
        runnerMarioPriceTag.setFont(font22);
        runnerMarioCoin = new CoinForStore(200, 383);
        runnerMarioCoin.setLocation(normalMarioCoin.getX(), normalMarioCoin.getY());
        runnerMarioBuyButton = new StoreBuyButton(runnerMario);
        runnerMarioBuyButton.setBounds(158, 420, 70, 35);
        runnerMarioBuyButton.setForeground(Color.BLACK);
        runnerMarioBuyButton.setFocusable(false);
        runnerMarioBuyButton.setFont(font10);
        runnerMarioBuyButton.addActionListener(this);
        if (MyProject.activeOfflineUser.getUserData().isUserBoughtRunnerMario()) {
            runnerMarioBuyButton.setBackground(Color.GRAY);
            runnerMarioBuyButton.setText("Bought");
        } else {
            runnerMarioBuyButton.setBackground(Color.GREEN);
            runnerMarioBuyButton.setText("Buy");
        }

        jumperMario = new JumperMario(290, 250, true);
        jumperMarioName = new JLabel("Jumper Mario");
        jumperMarioName.setBounds(290, 200, 80, 50);
        jumperMarioName.setFont(font12);
        jumperMarioPriceTag = new JLabel(String.valueOf(StoreBuyLogic.jumperMarioPrice));
        jumperMarioPriceTag.setBounds(300, 378, 30, 30);
        jumperMarioPriceTag.setFont(font22);
        jumperMarioCoin = new CoinForStore(330, 383);
        jumperMarioCoin.setLocation(jumperMarioCoin.getX(), jumperMarioCoin.getY());
        jumperMarioBuyButton = new StoreBuyButton(jumperMario);
        jumperMarioBuyButton.setBounds(288, 420, 70, 35);
        jumperMarioBuyButton.setForeground(Color.BLACK);
        jumperMarioBuyButton.setFocusable(false);
        jumperMarioBuyButton.setFont(font10);
        jumperMarioBuyButton.addActionListener(this);
        if (MyProject.activeOfflineUser.getUserData().isUserBoughtJumperMario()) {
            jumperMarioBuyButton.setBackground(Color.GRAY);
            jumperMarioBuyButton.setText("Bought");
        } else {
            jumperMarioBuyButton.setBackground(Color.GREEN);
            jumperMarioBuyButton.setText("Buy");
        }

        shooterMario = new ShooterMario(420, 250, true);
        shooterMarioName = new JLabel("Shooter Mario");
        shooterMarioName.setBounds(420, 200, 85, 50);
        shooterMarioName.setFont(font12);
        shooterMarioPriceTag = new JLabel(String.valueOf(StoreBuyLogic.shooterMarioPrice));
        shooterMarioPriceTag.setBounds(430, 378, 30, 30);
        shooterMarioPriceTag.setFont(font22);
        shooterMarioCoin = new CoinForStore(460, 383);
        shooterMarioCoin.setLocation(shooterMarioCoin.getX(), shooterMarioCoin.getY());
        shooterMarioBuyButton = new StoreBuyButton(shooterMario);
        shooterMarioBuyButton.setBounds(418, 420, 70, 35);
        shooterMarioBuyButton.setForeground(Color.BLACK);
        shooterMarioBuyButton.setFocusable(false);
        shooterMarioBuyButton.setFont(font10);
        shooterMarioBuyButton.addActionListener(this);
        if (MyProject.activeOfflineUser.getUserData().isUserBoughtShooterMario()) {
            shooterMarioBuyButton.setBackground(Color.GRAY);
            shooterMarioBuyButton.setText("Bought");
        } else {
            shooterMarioBuyButton.setBackground(Color.GREEN);
            shooterMarioBuyButton.setText("Buy");
        }

        coinMario = new CoinMario(550, 250, true);
        coinMarioName = new JLabel("Coin Mario");
        coinMarioName.setBounds(550, 200, 80, 50);
        coinMarioName.setFont(font12);
        coinMarioPriceTag = new JLabel(String.valueOf(StoreBuyLogic.coinMarioPrice));
        coinMarioPriceTag.setBounds(560, 378, 30, 30);
        coinMarioPriceTag.setFont(font22);
        coinMarioCoin = new CoinForStore(590, 383);
        coinMarioCoin.setLocation(coinMarioCoin.getX(), coinMarioCoin.getY());
        coinMarioBuyButton = new StoreBuyButton(coinMario);
        coinMarioBuyButton.setBounds(548, 420, 70, 35);
        coinMarioBuyButton.setForeground(Color.BLACK);
        coinMarioBuyButton.setFocusable(false);
        coinMarioBuyButton.setFont(font10);
        coinMarioBuyButton.addActionListener(this);
        if (MyProject.activeOfflineUser.getUserData().isUserBoughtCoinMario()) {
            coinMarioBuyButton.setBackground(Color.GRAY);
            coinMarioBuyButton.setText("Bought");
        } else {
            coinMarioBuyButton.setBackground(Color.GREEN);
            coinMarioBuyButton.setText("Buy");
        }

        userCoinValue = new JLabel(String.valueOf(MyProject.activeOfflineUser.getUserData().getUserCoinValue()));
        userCoinValue.setBounds(40, 0, 55, 40);
        userCoinValue.setFont(font22);

        userCoin = new CoinForStore(5, 10);
        userCoin.setLocation(userCoin.getX(), userCoin.getY());

        userDiamondValue = new JLabel(String.valueOf(MyProject.activeOfflineUser.getUserData().getUserDiamondValue()));
        userDiamondValue.setBounds(140, 0, 55, 40);
        userDiamondValue.setFont(font22);
        backgroundPanel.add(userDiamondValue, Integer.valueOf(1));

        userDiamond = new Diamond(90, -3);
        backgroundPanel.add(userDiamond, Integer.valueOf(1));

        onlineStoreButton = new JButton("Online Store");
        onlineStoreButton.setBounds(460, 550, 150, 60);
        onlineStoreButton.setBackground(Color.BLACK);
        onlineStoreButton.setForeground(Color.WHITE);
        onlineStoreButton.setFocusable(false);
        onlineStoreButton.setFont(MyProjectData.getProjectData().getFont15());
        onlineStoreButton.addActionListener(this);

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
        backgroundPanel.add(normalMarioPriceTag, Integer.valueOf(1));
        backgroundPanel.add(normalMarioCoin, Integer.valueOf(1));
        backgroundPanel.add(normalMarioBuyButton, Integer.valueOf(1));

        backgroundPanel.add(runnerMario, Integer.valueOf(1));
        backgroundPanel.add(runnerMarioName, Integer.valueOf(1));
        backgroundPanel.add(runnerMarioPriceTag, Integer.valueOf(1));
        backgroundPanel.add(runnerMarioCoin, Integer.valueOf(1));
        backgroundPanel.add(runnerMarioBuyButton, Integer.valueOf(1));

        backgroundPanel.add(jumperMario, Integer.valueOf(1));
        backgroundPanel.add(jumperMarioName, Integer.valueOf(1));
        backgroundPanel.add(jumperMarioPriceTag, Integer.valueOf(1));
        backgroundPanel.add(jumperMarioCoin, Integer.valueOf(1));
        backgroundPanel.add(jumperMarioBuyButton, Integer.valueOf(1));

        backgroundPanel.add(shooterMario, Integer.valueOf(1));
        backgroundPanel.add(shooterMarioName, Integer.valueOf(1));
        backgroundPanel.add(shooterMarioPriceTag, Integer.valueOf(1));
        backgroundPanel.add(shooterMarioCoin, Integer.valueOf(1));
        backgroundPanel.add(shooterMarioBuyButton, Integer.valueOf(1));

        backgroundPanel.add(coinMario, Integer.valueOf(1));
        backgroundPanel.add(coinMarioName, Integer.valueOf(1));
        backgroundPanel.add(coinMarioPriceTag, Integer.valueOf(1));
        backgroundPanel.add(coinMarioCoin, Integer.valueOf(1));
        backgroundPanel.add(coinMarioBuyButton, Integer.valueOf(1));

        backgroundPanel.add(userCoinValue, Integer.valueOf(1));
        backgroundPanel.add(userCoin, Integer.valueOf(1));
        backgroundPanel.add(backButton, Integer.valueOf(1));
        backgroundPanel.add(onlineStoreButton, Integer.valueOf(1));

        this.add(backgroundPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backButton) {
            new MainMenuScreen();
            this.dispose();
            try {
                objectMapper.writeValue(new File("OfflineUser.jason"), MyProject.allOfflineUsers);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == onlineStoreButton) {
            new OnlineStoreScreen();
            dispose();
        }

        if (e.getSource() == runnerMarioBuyButton) {

            if (runnerMarioBuyButton.isButtonChoose()) {
                StoreBuyLogic buyLogic = new StoreBuyLogic(runnerMarioBuyButton, this);
                if (buyLogic.canUserBuyMario()) {
                    userCoinValue.setText(String.valueOf(MyProject.activeOfflineUser.getUserData().getUserCoinValue()));
                    runnerMarioBuyButton.setBackground(Color.GRAY);
                    runnerMarioBuyButton.setText("Bought");
                    runnerMarioBuyButton.setButtonChoose(true);
                    MyProject.activeOfflineUser.getUserData().setUserBoughtRunnerMario(true);
                }
            }

        }

        if (e.getSource() == jumperMarioBuyButton) {

            if (jumperMarioBuyButton.isButtonChoose()) {
                StoreBuyLogic buyLogic = new StoreBuyLogic(jumperMarioBuyButton, this);
                if (buyLogic.canUserBuyMario()) {
                    userCoinValue.setText(String.valueOf(MyProject.activeOfflineUser.getUserData().getUserCoinValue()));
                    jumperMarioBuyButton.setBackground(Color.GRAY);
                    jumperMarioBuyButton.setText("Bought");
                    jumperMarioBuyButton.setButtonChoose(true);
                    MyProject.activeOfflineUser.getUserData().setUserBoughtJumperMario(true);
                }
            }

        }

        if (e.getSource() == shooterMarioBuyButton) {

            if (shooterMarioBuyButton.isButtonChoose()) {
                StoreBuyLogic buyLogic = new StoreBuyLogic(shooterMarioBuyButton, this);
                if (buyLogic.canUserBuyMario()) {
                    userCoinValue.setText(String.valueOf(MyProject.activeOfflineUser.getUserData().getUserCoinValue()));
                    shooterMarioBuyButton.setBackground(Color.GRAY);
                    shooterMarioBuyButton.setText("Bought");
                    shooterMarioBuyButton.setButtonChoose(true);
                    MyProject.activeOfflineUser.getUserData().setUserBoughtShooterMario(true);
                }
            }

        }

        if (e.getSource() == coinMarioBuyButton) {

            if (coinMarioBuyButton.isButtonChoose()) {
                StoreBuyLogic buyLogic = new StoreBuyLogic(coinMarioBuyButton, this);
                if (buyLogic.canUserBuyMario()) {
                    userCoinValue.setText(String.valueOf(MyProject.activeOfflineUser.getUserData().getUserCoinValue()));
                    coinMarioBuyButton.setBackground(Color.GRAY);
                    coinMarioBuyButton.setText("Bought");
                    coinMarioBuyButton.setButtonChoose(true);
                    MyProject.activeOfflineUser.getUserData().setUserBoughtCoinMario(true);
                }
            }

        }

    }
}
