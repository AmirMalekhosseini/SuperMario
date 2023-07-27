package Model.OnlineStorePack;

import Model.Item.Coin;
import Model.Item.CoinForStore;
import Model.Item.Online.Diamond;
import Model.Item.Online.OnlineItems;
import Model.Mario.Online.OnlineWeapon;
import Model.Object.ObjectsInGame;
import Model.Object.PackItems;
import MyProject.MyProjectData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StorePack {

    private Pack pack;
    protected JLabel backgroundLabel;
    protected JLabel priceTag;
    protected JLabel currency;
    protected JButton buyButton;
    private int x;
    private int y;

    public StorePack(int x, int y, Pack pack) {

        this.x = x;
        this.y = y;
        this.pack = pack;

        backgroundLabel = new JLabel();
        backgroundLabel.setOpaque(false);
        backgroundLabel.setBounds(x, y, 200, 800);// test
        backgroundLabel.setLayout(null);
        addPack();
        init(x, y);
    }

    private void init(int x, int y) {

        Font font10 = MyProjectData.getProjectData().getFont10();
        Font font22 = MyProjectData.getProjectData().getFont22();

        priceTag = new JLabel(String.valueOf(pack.getPrice()));
        priceTag.setBounds(x, y + 70, 50, 30);
        priceTag.setFont(font22);

        if (pack.getCurrency() instanceof Diamond) {
            currency = new Diamond(x + 30, y + 60);
        } else {
            currency = new CoinForStore(x + 50, y + 75);
        }

        buyButton = new JButton("Buy");
        buyButton.setBounds(x, y + 120, 70, 35);
        buyButton.setForeground(Color.BLACK);
        buyButton.setBackground(Color.GREEN);
        buyButton.setFocusable(false);
        buyButton.setFont(font10);

    }

    private void addPack() {

        for (PackItems packItem : pack.packItems) {
            backgroundLabel.add((ObjectsInGame) packItem);
        }

    }

    private void addButtonAction() {

        // ToDo

    }

    public Pack getPack() {
        return pack;
    }

    public void setPack(Pack pack) {
        this.pack = pack;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public JLabel getBackgroundLabel() {
        return backgroundLabel;
    }

    public JLabel getPriceTag() {
        return priceTag;
    }

    public JLabel getCurrency() {
        return currency;
    }

    public JButton getBuyButton() {
        return buyButton;
    }
}
