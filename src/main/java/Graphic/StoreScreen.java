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

public class StoreScreen extends JFrame implements ActionListener {

    ObjectMapper objectMapper;
    JLayeredPane backgroundPanel;
    JLabel backgroundImageLabel;
    JLabel normalMario;
    JLabel normalMarioName;
    CoinForStore normalMarioCoin;
    StoreBuyButton normalMarioBuyButton;
    JLabel normalMarioPriceTag;
    JLabel coinMario;
    JLabel coinMarioName;
    CoinForStore coinMarioCoin;
    StoreBuyButton coinMarioBuyButton;
    JLabel coinMarioPriceTag;
    JLabel runnerMario;
    JLabel runnerMarioName;
    CoinForStore runnerMarioCoin;
    StoreBuyButton runnerMarioBuyButton;
    JLabel runnerMarioPriceTag;
    JLabel jumperMario;
    JLabel jumperMarioName;
    CoinForStore jumperMarioCoin;
    StoreBuyButton jumperMarioBuyButton;
    JLabel jumperMarioPriceTag;
    JLabel shooterMario;
    JLabel shooterMarioName;
    CoinForStore shooterMarioCoin;
    StoreBuyButton shooterMarioBuyButton;
    JLabel shooterMarioPriceTag;

    JButton backButton;
    CoinForStore userCoin;
    public JLabel userCoinValue;


    StoreScreen() {
        init();
    }

    private void init() {

        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        ImageIcon backgroundImage = MyProjectData.getProjectData().getGameMenuImage();
        ImageIcon gameIcon = MyProjectData.getProjectData().getGameIcon();
        ImageIcon normalMarioImage = MyProjectData.getProjectData().getNormalMarioImage();
        ImageIcon coinMarioImage = MyProjectData.getProjectData().getCoinMarioImage();
        ImageIcon runnerMarioImage = MyProjectData.getProjectData().getRunnerMarioImage();
        ImageIcon shooterMarioImage = MyProjectData.getProjectData().getShooterMarioImage();
        ImageIcon jumperMarioImage = MyProjectData.getProjectData().getJumperMarioImage();

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

        normalMario = new JLabel(normalMarioImage);
        normalMario.setBounds(30, 250, 70, 120);
        normalMarioName = new JLabel("Normal Mario");
        normalMarioName.setBounds(30, 200, 80, 50);
        normalMarioName.setFont(font12);
        normalMarioPriceTag = new JLabel("0");
        normalMarioPriceTag.setBounds(50, 378, 25, 25);
        normalMarioPriceTag.setFont(font22);
        normalMarioCoin = new CoinForStore(70, 380);
        normalMarioCoin.setLocation(normalMarioCoin.getX(), normalMarioCoin.getY());
        normalMarioBuyButton = new StoreBuyButton();
        normalMarioBuyButton.setBounds(33, 420, 70, 35);
        normalMarioBuyButton.setForeground(Color.BLACK);
        normalMarioBuyButton.setFocusable(false);
        normalMarioBuyButton.setFont(font10);
        normalMarioBuyButton.addActionListener(this);
        if (MyProject.activeUser.get(0).isUserBoughtNormalMario()) {
            normalMarioBuyButton.setBackground(Color.GRAY);
            normalMarioBuyButton.setText("Bought");
        } else {
            normalMarioBuyButton.setBackground(Color.GREEN);
            normalMarioBuyButton.setText("Buy");
        }

        runnerMario = new JLabel(runnerMarioImage);
        runnerMario.setBounds(160, 250, 70, 120);
        runnerMarioName = new JLabel("Runner Mario");
        runnerMarioName.setBounds(160, 200, 80, 50);
        runnerMarioName.setFont(font12);
        runnerMarioPriceTag = new JLabel(String.valueOf(StoreBuyLogic.runnerMarioPrice));
        runnerMarioPriceTag.setBounds(170, 378, 30, 30);
        runnerMarioPriceTag.setFont(font22);
        runnerMarioCoin = new CoinForStore(200, 383);
        runnerMarioCoin.setLocation(normalMarioCoin.getX(), normalMarioCoin.getY());
        runnerMarioBuyButton = new StoreBuyButton();
        runnerMarioBuyButton.setBounds(158, 420, 70, 35);
        runnerMarioBuyButton.setForeground(Color.BLACK);
        runnerMarioBuyButton.setFocusable(false);
        runnerMarioBuyButton.setFont(font10);
        runnerMarioBuyButton.addActionListener(this);
        if (MyProject.activeUser.get(0).isUserBoughtRunnerMario()) {
            runnerMarioBuyButton.setBackground(Color.GRAY);
            runnerMarioBuyButton.setText("Bought");
        } else {
            runnerMarioBuyButton.setBackground(Color.GREEN);
            runnerMarioBuyButton.setText("Buy");
        }

        jumperMario = new JLabel(jumperMarioImage);
        jumperMario.setBounds(290, 250, 70, 120);
        jumperMarioName = new JLabel("Jumper Mario");
        jumperMarioName.setBounds(290, 200, 80, 50);
        jumperMarioName.setFont(font12);
        jumperMarioPriceTag = new JLabel(String.valueOf(StoreBuyLogic.jumperMarioPrice));
        jumperMarioPriceTag.setBounds(300, 378, 30, 30);
        jumperMarioPriceTag.setFont(font22);
        jumperMarioCoin = new CoinForStore(330, 383);
        jumperMarioCoin.setLocation(jumperMarioCoin.getX(), jumperMarioCoin.getY());
        jumperMarioBuyButton = new StoreBuyButton();
        jumperMarioBuyButton.setBounds(288, 420, 70, 35);
        jumperMarioBuyButton.setForeground(Color.BLACK);
        jumperMarioBuyButton.setFocusable(false);
        jumperMarioBuyButton.setFont(font10);
        jumperMarioBuyButton.addActionListener(this);
        if (MyProject.activeUser.get(0).isUserBoughtJumperMario()) {
            jumperMarioBuyButton.setBackground(Color.GRAY);
            jumperMarioBuyButton.setText("Bought");
        } else {
            jumperMarioBuyButton.setBackground(Color.GREEN);
            jumperMarioBuyButton.setText("Buy");
        }

        shooterMario = new JLabel(shooterMarioImage);
        shooterMario.setBounds(420, 250, 70, 120);
        shooterMarioName = new JLabel("Shooter Mario");
        shooterMarioName.setBounds(420, 200, 85, 50);
        shooterMarioName.setFont(font12);
        shooterMarioPriceTag = new JLabel(String.valueOf(StoreBuyLogic.shooterMarioPrice));
        shooterMarioPriceTag.setBounds(430, 378, 30, 30);
        shooterMarioPriceTag.setFont(font22);
        shooterMarioCoin = new CoinForStore(460, 383);
        shooterMarioCoin.setLocation(shooterMarioCoin.getX(), shooterMarioCoin.getY());
        shooterMarioBuyButton = new StoreBuyButton();
        shooterMarioBuyButton.setBounds(418, 420, 70, 35);
        shooterMarioBuyButton.setForeground(Color.BLACK);
        shooterMarioBuyButton.setFocusable(false);
        shooterMarioBuyButton.setFont(font10);
        shooterMarioBuyButton.addActionListener(this);
        if (MyProject.activeUser.get(0).isUserBoughtShooterMario()) {
            shooterMarioBuyButton.setBackground(Color.GRAY);
            shooterMarioBuyButton.setText("Bought");
        } else {
            shooterMarioBuyButton.setBackground(Color.GREEN);
            shooterMarioBuyButton.setText("Buy");
        }

        coinMario = new JLabel(coinMarioImage);
        coinMario.setBounds(550, 250, 70, 120);
        coinMarioName = new JLabel("Coin Mario");
        coinMarioName.setBounds(550, 200, 80, 50);
        coinMarioName.setFont(font12);
        coinMarioPriceTag = new JLabel(String.valueOf(StoreBuyLogic.coinMarioPrice));
        coinMarioPriceTag.setBounds(560, 378, 30, 30);
        coinMarioPriceTag.setFont(font22);
        coinMarioCoin = new CoinForStore(590, 383);
        coinMarioCoin.setLocation(coinMarioCoin.getX(), coinMarioCoin.getY());
        coinMarioBuyButton = new StoreBuyButton();
        coinMarioBuyButton.setBounds(548, 420, 70, 35);
        coinMarioBuyButton.setForeground(Color.BLACK);
        coinMarioBuyButton.setFocusable(false);
        coinMarioBuyButton.setFont(font10);
        coinMarioBuyButton.addActionListener(this);
        if (MyProject.activeUser.get(0).isUserBoughtCoinMario()) {
            coinMarioBuyButton.setBackground(Color.GRAY);
            coinMarioBuyButton.setText("Bought");
        } else {
            coinMarioBuyButton.setBackground(Color.GREEN);
            coinMarioBuyButton.setText("Buy");
        }

        userCoinValue = new JLabel(String.valueOf(MyProject.activeUser.get(0).getUserCoinValue()));
        userCoinValue.setBounds(40, 0, 55, 40);
        userCoinValue.setFont(font22);

        userCoin = new CoinForStore(5, 10);
        userCoin.setLocation(userCoin.getX(), userCoin.getY());

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

        if (e.getSource() == runnerMarioBuyButton) {

            if(runnerMarioBuyButton.isButtonChoose()) {
                StoreBuyLogic buyLogic = new StoreBuyLogic("runner mario",this);
                if (buyLogic.canUserBuyMario()) {
                    userCoinValue.setText(String.valueOf(MyProject.activeUser.get(0).getUserCoinValue()));
                    runnerMarioBuyButton.setBackground(Color.GRAY);
                    runnerMarioBuyButton.setText("Bought");
                    runnerMarioBuyButton.setButtonChoose(true);
                    MyProject.activeUser.get(0).setUserBoughtRunnerMario(true);
                }
            }

        }

        if (e.getSource() == jumperMarioBuyButton) {

            if(jumperMarioBuyButton.isButtonChoose()) {
                StoreBuyLogic buyLogic = new StoreBuyLogic("jumper mario",this);
                if (buyLogic.canUserBuyMario()) {
                    userCoinValue.setText(String.valueOf(MyProject.activeUser.get(0).getUserCoinValue()));
                    jumperMarioBuyButton.setBackground(Color.GRAY);
                    jumperMarioBuyButton.setText("Bought");
                    jumperMarioBuyButton.setButtonChoose(true);
                    MyProject.activeUser.get(0).setUserBoughtJumperMario(true);
                }
            }

        }

        if (e.getSource() == shooterMarioBuyButton) {

            if(shooterMarioBuyButton.isButtonChoose()) {
                StoreBuyLogic buyLogic = new StoreBuyLogic("shooter mario",this);
                if (buyLogic.canUserBuyMario()) {
                    userCoinValue.setText(String.valueOf(MyProject.activeUser.get(0).getUserCoinValue()));
                    shooterMarioBuyButton.setBackground(Color.GRAY);
                    shooterMarioBuyButton.setText("Bought");
                    shooterMarioBuyButton.setButtonChoose(true);
                    MyProject.activeUser.get(0).setUserBoughtShooterMario(true);
                }
            }

        }

        if (e.getSource() == coinMarioBuyButton) {

            if(coinMarioBuyButton.isButtonChoose()) {
                StoreBuyLogic buyLogic = new StoreBuyLogic("coin mario",this);
                if (buyLogic.canUserBuyMario()) {
                    userCoinValue.setText(String.valueOf(MyProject.activeUser.get(0).getUserCoinValue()));
                    coinMarioBuyButton.setBackground(Color.GRAY);
                    coinMarioBuyButton.setText("Bought");
                    coinMarioBuyButton.setButtonChoose(true);
                    MyProject.activeUser.get(0).setUserBoughtCoinMario(true);
                }
            }

        }

    }
}
