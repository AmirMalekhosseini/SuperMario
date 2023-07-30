package View.Menu;

import Model.Item.CoinForStore;
import Model.Item.Online.*;
import Model.Mario.Online.DamageBomb;
import Model.Mario.Online.Hammer;
import Model.Mario.Online.SpeedBomb;
import Model.Object.PackItems;
import Model.OnlineStorePack.Pack;
import Model.OnlineStorePack.StorePack;
import MyProject.MyProject;
import MyProject.MyProjectData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OnlineStoreScreen extends JFrame {

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

    public OnlineStoreScreen() {

        // ToDo: Send init Packs from Server.

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

        userCoinValue = new JLabel(String.valueOf(MyProject.activeUser.get(0).getUserCoinValue()));
        userCoinValue.setBounds(40, 0, 55, 40);
        userCoinValue.setFont(font22);
        backgroundPanel.add(userCoinValue, Integer.valueOf(1));

        userCoin = new CoinForStore(5, 10);
        backgroundPanel.add(userCoin, Integer.valueOf(1));

        userDiamondValue = new JLabel(String.valueOf(MyProject.activeUser.get(0).getUserDiamondValue()));
        userDiamondValue.setBounds(140, 0, 55, 40);
        userDiamondValue.setFont(font22);
        backgroundPanel.add(userDiamondValue, Integer.valueOf(1));

        userDiamond = new Diamond(90, -3);
        backgroundPanel.add(userDiamond, Integer.valueOf(1));

        init();
        add(backgroundPanel);

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

        // Test:
        // ToDo: Receive Packs from server and add Them to StorePacks.
        ArrayList<PackItems> packItems = new ArrayList<>();
        packItems.add(new Hammer(0, 0, true));
        Pack hammer = new Pack(packItems, 100);
        hammerPack = new StorePack(50, 150, hammer);
        backgroundPanel.add(hammerPack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(hammerPack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(hammerPack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(hammerPack.getPriceTag(), Integer.valueOf(1));

        packItems = new ArrayList<>();
        packItems.add(new DamageBomb(0, 0));
        Pack damageBomb = new Pack(packItems, 100);
        damageBombPack = new StorePack(200, 150, damageBomb);
        backgroundPanel.add(damageBombPack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(damageBombPack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(damageBombPack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(damageBombPack.getPriceTag(), Integer.valueOf(1));

        packItems = new ArrayList<>();
        packItems.add(new SpeedBomb(0, 0));
        Pack speedBomb = new Pack(packItems, 100);
        speedBombPack = new StorePack(350, 150, speedBomb);
        backgroundPanel.add(speedBombPack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(speedBombPack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(speedBombPack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(speedBombPack.getPriceTag(), Integer.valueOf(1));

        packItems = new ArrayList<>();
        packItems.add(new HealItem(0, 0));
        Pack healPotion = new Pack(packItems, 100);
        healPotionPack = new StorePack(50, 350, healPotion);
        backgroundPanel.add(healPotionPack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(healPotionPack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(healPotionPack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(healPotionPack.getPriceTag(), Integer.valueOf(1));

        packItems = new ArrayList<>();
        packItems.add(new InvisibleItem(0, 0));
        Pack invisiblePotion = new Pack(packItems, 100);
        invisiblePotionPack = new StorePack(200, 350, invisiblePotion);
        backgroundPanel.add(invisiblePotionPack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(invisiblePotionPack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(invisiblePotionPack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(invisiblePotionPack.getPriceTag(), Integer.valueOf(1));

        packItems = new ArrayList<>();
        packItems.add(new SpeedItem(0, 0));
        Pack speedPotion = new Pack(packItems, 100);
        speedPotionPack = new StorePack(350, 350, speedPotion);
        backgroundPanel.add(speedPotionPack.getBackgroundLabel(), Integer.valueOf(1));
        backgroundPanel.add(speedPotionPack.getCurrency(), Integer.valueOf(1));
        backgroundPanel.add(speedPotionPack.getBuyButton(), Integer.valueOf(1));
        backgroundPanel.add(speedPotionPack.getPriceTag(), Integer.valueOf(1));

    }

}
