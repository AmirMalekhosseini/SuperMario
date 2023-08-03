package View.Menu;

import Model.Item.Online.Bag;
import Model.Item.Online.HealItem;
import Model.Item.Online.InvisibleItem;
import Model.Item.Online.SpeedItem;
import Model.Mario.Online.DamageBomb;
import Model.Mario.Online.Hammer;
import Model.Mario.Online.SpeedBomb;
import Model.Mario.Sword;
import MyProject.MyProjectData;
import View.Button.BagAddButton;
import View.Button.BagButton;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.swing.*;
import java.awt.*;

public class BagScreen extends JFrame {


    ObjectMapper objectMapper;

    JLayeredPane backgroundPanel;
    JButton backButton;
    Bag bag_1;
    Bag bag_2;
    Bag bag_3;

    // First Bag
    BagButton bagButton_1;
    BagAddButton hammerButton_1;
    BagAddButton damageBombButton_1;
    BagAddButton speedBombButton_1;
    BagAddButton healPotionButton_1;
    BagAddButton invisiblePotionButton_1;
    BagAddButton speedPotionButton_1;
    BagAddButton swordButton_1;

    // Second Bag
    BagButton bagButton_2;
    BagAddButton hammerButton_2;
    BagAddButton damageBombButton_2;
    BagAddButton speedBombButton_2;
    BagAddButton healPotionButton_2;
    BagAddButton invisiblePotionButton_2;
    BagAddButton speedPotionButton_2;
    BagAddButton swordButton_2;

    // Third Bag
    BagButton bagButton_3;
    BagAddButton hammerButton_3;
    BagAddButton damageBombButton_3;
    BagAddButton speedBombButton_3;
    BagAddButton healPotionButton_3;
    BagAddButton invisiblePotionButton_3;
    BagAddButton speedPotionButton_3;
    BagAddButton swordButton_3;


    public BagScreen() {

        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        ImageIcon backgroundImage = MyProjectData.getProjectData().getGameMenuImage();
        ImageIcon gameIcon = MyProjectData.getProjectData().getGameIcon();
        Font font22 = MyProjectData.getProjectData().getFont22();

        this.setSize(1200, 700);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setIconImage(gameIcon.getImage());
        getContentPane().setBackground(Color.red);

        backgroundPanel = new JLayeredPane();
        backgroundPanel.setBounds(0, 0, 1200, 720);


        backButton = new JButton("Back");
        backButton.setBounds(1105, 0, 85, 50);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.setFont(font22);
        backButton.addActionListener(e ->{
            new UserProfileScreen();
            dispose();
        });
        backgroundPanel.add(backButton, Integer.valueOf(1));

        init();
        add(backgroundPanel);

    }

    private void init() {

        bag_1 = new Bag(20, 100);
        bag_2 = new Bag(20, 300);
        bag_3 = new Bag(20, 500);

        bagButton_1 = new BagButton(20, 200, 0);
        bagButton_2 = new BagButton(20, 400, 1);
        bagButton_3 = new BagButton(20, 600, 2);

        backgroundPanel.add(bag_1, Integer.valueOf(1));
        backgroundPanel.add(bag_2, Integer.valueOf(1));
        backgroundPanel.add(bag_3, Integer.valueOf(1));
        backgroundPanel.add(bagButton_1, Integer.valueOf(1));
        backgroundPanel.add(bagButton_2, Integer.valueOf(1));
        backgroundPanel.add(bagButton_3, Integer.valueOf(1));

        addButtons();


    }

    private void addButtons() {

        hammerButton_1 = new BagAddButton(150, 170, new Hammer(150, 100, true), backgroundPanel, 0);
        damageBombButton_1 = new BagAddButton(300, 170, new DamageBomb(300, 100), backgroundPanel, 0);
        speedBombButton_1 = new BagAddButton(450, 170, new SpeedBomb(450, 100), backgroundPanel, 0);
        healPotionButton_1 = new BagAddButton(600, 170, new HealItem(600, 100), backgroundPanel, 0);
        invisiblePotionButton_1 = new BagAddButton(750, 170, new InvisibleItem(750, 100), backgroundPanel, 0);
        speedPotionButton_1 = new BagAddButton(900, 170, new SpeedItem(900, 100), backgroundPanel, 0);
        swordButton_1 = new BagAddButton(1050, 170, new Sword(1020, 100), backgroundPanel, 0);

        hammerButton_2 = new BagAddButton(150, 370, new Hammer(150, 300, true), backgroundPanel, 1);
        damageBombButton_2 = new BagAddButton(300, 370, new DamageBomb(300, 300), backgroundPanel, 1);
        speedBombButton_2 = new BagAddButton(450, 370, new SpeedBomb(450, 300), backgroundPanel, 1);
        healPotionButton_2 = new BagAddButton(600, 370, new HealItem(600, 300), backgroundPanel, 1);
        invisiblePotionButton_2 = new BagAddButton(750, 370, new InvisibleItem(750, 300), backgroundPanel, 1);
        speedPotionButton_2 = new BagAddButton(900, 370, new SpeedItem(900, 300), backgroundPanel, 1);
        swordButton_2 = new BagAddButton(1050, 370, new Sword(1020, 300), backgroundPanel, 1);

        hammerButton_3 = new BagAddButton(150, 570, new Hammer(150, 500, true), backgroundPanel, 2);
        damageBombButton_3 = new BagAddButton(300, 570, new DamageBomb(300, 500), backgroundPanel, 2);
        speedBombButton_3 = new BagAddButton(450, 570, new SpeedBomb(450, 500), backgroundPanel, 2);
        healPotionButton_3 = new BagAddButton(600, 570, new HealItem(600, 500), backgroundPanel, 2);
        invisiblePotionButton_3 = new BagAddButton(750, 570, new InvisibleItem(750, 500), backgroundPanel, 2);
        speedPotionButton_3 = new BagAddButton(900, 570, new SpeedItem(900, 500), backgroundPanel, 2);
        swordButton_3 = new BagAddButton(1050, 570, new Sword(1020, 500), backgroundPanel, 2);

    }

}
