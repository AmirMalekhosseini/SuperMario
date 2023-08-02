package View.Menu;

import Model.Item.CoinForStore;
import Model.Item.Online.*;
import Model.OnlineStorePack.StorePack;
import MyProject.MyProject;
import MyProject.MyProjectData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OnlineStoreScreen extends JFrame {


    private ArrayList<StorePack> storePacks = new ArrayList<>();
    ObjectMapper objectMapper;
    JLayeredPane backgroundPanel;
    JLabel backgroundImageLabel;
    JButton backButton;
    StorePack hammerPack;
    StorePack damageBombPack;
    StorePack speedBombPack;
    StorePack invisiblePotionPack;
    StorePack healPotionPack;
    StorePack speedPotionPack;
    StorePack multiplePack;
    CoinForStore userCoin;
    public JLabel userCoinValue;
    public JLabel userDiamondValue;
    Diamond userDiamond;
    JButton offlineStoreButton;

    public OnlineStoreScreen() {

        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        ImageIcon backgroundImage = MyProjectData.getProjectData().getGameMenuImage();
        ImageIcon gameIcon = MyProjectData.getProjectData().getGameIcon();
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
        backgroundPanel.add(backgroundImageLabel, Integer.valueOf(0));

        userCoinValue = new JLabel(String.valueOf(MyProject.activeOfflineUser.getUserData().getUserCoinValue()));
        userCoinValue.setBounds(40, 0, 55, 40);
        userCoinValue.setFont(font22);
        backgroundPanel.add(userCoinValue, Integer.valueOf(1));

        userCoin = new CoinForStore(5, 10);
        backgroundPanel.add(userCoin, Integer.valueOf(1));

        userDiamondValue = new JLabel(String.valueOf(MyProject.activeOfflineUser.getUserData().getUserDiamondValue()));
        userDiamondValue.setBounds(140, 0, 55, 40);
        userDiamondValue.setFont(font22);
        backgroundPanel.add(userDiamondValue, Integer.valueOf(1));

        userDiamond = new Diamond(90, -3);
        backgroundPanel.add(userDiamond, Integer.valueOf(1));

        init();
        add(backgroundPanel);

        addButtonAction();
        revalidate();
        repaint();
    }

    private void init() {

        Font font12 = MyProjectData.getProjectData().getFont12();
        Font font22 = MyProjectData.getProjectData().getFont22();

        backButton = new JButton("Back");
        backButton.setBounds(555, 0, 85, 50);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.setFont(font22);
        backgroundPanel.add(backButton, Integer.valueOf(1));

        offlineStoreButton = new JButton("Offline Store");
        offlineStoreButton.setBounds(460, 550, 150, 60);
        offlineStoreButton.setBackground(Color.BLACK);
        offlineStoreButton.setForeground(Color.WHITE);
        offlineStoreButton.setFocusable(false);
        offlineStoreButton.setFont(MyProjectData.getProjectData().getFont15());
        backgroundPanel.add(offlineStoreButton, Integer.valueOf(1));

        hammerPack = new StorePack(50, 150, MyProject.StorePacks.get(0).getPack(), false);
        backgroundPanel.add(hammerPack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(hammerPack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(hammerPack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(hammerPack.getPriceTag(), Integer.valueOf(1));
        storePacks.add(hammerPack);

        damageBombPack = new StorePack(200, 150, MyProject.StorePacks.get(1).getPack(), false);
        backgroundPanel.add(damageBombPack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(damageBombPack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(damageBombPack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(damageBombPack.getPriceTag(), Integer.valueOf(1));
        storePacks.add(damageBombPack);

        speedBombPack = new StorePack(350, 150, MyProject.StorePacks.get(2).getPack(), false);
        backgroundPanel.add(speedBombPack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(speedBombPack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(speedBombPack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(speedBombPack.getPriceTag(), Integer.valueOf(1));
        storePacks.add(speedBombPack);

        healPotionPack = new StorePack(50, 350, MyProject.StorePacks.get(3).getPack(), false);
        backgroundPanel.add(healPotionPack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(healPotionPack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(healPotionPack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(healPotionPack.getPriceTag(), Integer.valueOf(1));
        storePacks.add(healPotionPack);

        invisiblePotionPack = new StorePack(200, 350, MyProject.StorePacks.get(4).getPack(), false);
        backgroundPanel.add(invisiblePotionPack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(invisiblePotionPack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(invisiblePotionPack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(invisiblePotionPack.getPriceTag(), Integer.valueOf(1));
        storePacks.add(invisiblePotionPack);

        speedPotionPack = new StorePack(350, 350, MyProject.StorePacks.get(5).getPack(), false);
        backgroundPanel.add(speedPotionPack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(speedPotionPack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(speedPotionPack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(speedPotionPack.getPriceTag(), Integer.valueOf(1));
        storePacks.add(speedPotionPack);

        multiplePack = new StorePack(500, 150, MyProject.StorePacks.get(6).getPack(), true);
        backgroundPanel.add(multiplePack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(multiplePack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(multiplePack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(multiplePack.getPriceTag(), Integer.valueOf(1));
        storePacks.add(multiplePack);

    }

    public void addStorePacks() {
        backgroundPanel.remove(hammerPack.getBackgroundLabel());
        backgroundPanel.remove(hammerPack.getCurrency());
        backgroundPanel.remove(hammerPack.getBuyButton());
        backgroundPanel.remove(hammerPack.getPriceTag());

        hammerPack = new StorePack(50, 150, MyProject.StorePacks.get(0).getPack(), false);
        backgroundPanel.add(hammerPack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(hammerPack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(hammerPack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(hammerPack.getPriceTag(), Integer.valueOf(1));
        storePacks.add(hammerPack);

        damageBombPack = new StorePack(200, 150, MyProject.StorePacks.get(1).getPack(), false);
        backgroundPanel.add(damageBombPack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(damageBombPack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(damageBombPack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(damageBombPack.getPriceTag(), Integer.valueOf(1));
        storePacks.add(damageBombPack);

        speedBombPack = new StorePack(350, 150, MyProject.StorePacks.get(2).getPack(), false);
        backgroundPanel.add(speedBombPack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(speedBombPack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(speedBombPack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(speedBombPack.getPriceTag(), Integer.valueOf(1));
        storePacks.add(speedBombPack);

        healPotionPack = new StorePack(50, 350, MyProject.StorePacks.get(3).getPack(), false);
        backgroundPanel.add(healPotionPack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(healPotionPack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(healPotionPack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(healPotionPack.getPriceTag(), Integer.valueOf(1));
        storePacks.add(healPotionPack);

        invisiblePotionPack = new StorePack(200, 350, MyProject.StorePacks.get(4).getPack(), false);
        backgroundPanel.add(invisiblePotionPack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(invisiblePotionPack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(invisiblePotionPack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(invisiblePotionPack.getPriceTag(), Integer.valueOf(1));
        storePacks.add(invisiblePotionPack);

        speedPotionPack = new StorePack(350, 350, MyProject.StorePacks.get(5).getPack(), false);
        backgroundPanel.add(speedPotionPack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(speedPotionPack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(speedPotionPack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(speedPotionPack.getPriceTag(), Integer.valueOf(1));
        storePacks.add(speedPotionPack);

        multiplePack = new StorePack(500, 150, MyProject.StorePacks.get(6).getPack(), true);
        backgroundPanel.add(multiplePack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(multiplePack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(multiplePack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(multiplePack.getPriceTag(), Integer.valueOf(1));
        storePacks.add(multiplePack);

        revalidate();
        repaint();
    }

    private void addButtonAction() {

        backButton.addActionListener(e -> {
            new MainMenuScreen();
            dispose();
        });

        offlineStoreButton.addActionListener(e -> {
            new OfflineStoreScreen();
            dispose();
        });

    }

    public ArrayList<StorePack> getStorePacks() {
        return storePacks;
    }

    public void setStorePacks(ArrayList<StorePack> storePacks) {
        this.storePacks = storePacks;
    }
}
