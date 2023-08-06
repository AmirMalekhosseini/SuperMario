package Model.OnlineStorePack;

import Model.Item.CoinForStore;
import Model.Item.Online.Diamond;
import Model.NetworkCommunication.Message.MessageType;
import Model.NetworkCommunication.Message.OnlineShopMessage;
import Model.Object.ObjectsInGame;
import Model.Object.PackItem;
import MyProject.MyProject;
import MyProject.MyProjectData;

import javax.swing.*;
import java.awt.*;

public class StorePack {

    private Pack pack;
    protected JLabel backgroundLabel;
    protected JLabel priceTag;
    protected JLabel currency;
    protected JButton buyButton;
    protected JLabel countLabel;
    private int x;
    private int y;
    private final boolean isForMulti;

    public StorePack(int x, int y, Pack pack, boolean isForMulti) {

        this.isForMulti = isForMulti;
        this.x = x;
        this.y = y;
        this.pack = pack;

        backgroundLabel = new JLabel();
        backgroundLabel.setOpaque(false);
        backgroundLabel.setBounds(x, y, 200, 800);// test
        backgroundLabel.setLayout(null);
        addPack();
        init(x, y);
        addButtonAction();
    }

    private void init(int x, int y) {

        Font font10 = MyProjectData.getProjectData().getFont10();
        Font font22 = MyProjectData.getProjectData().getFont22();

        priceTag = new JLabel(String.valueOf(pack.getPrice()));
        priceTag.setFont(font22);


        buyButton = new JButton("Buy");
        if (isForMulti) {
            if (pack.getCurrency() instanceof Diamond) {
                currency = new Diamond(x + 30, 350 + 60);
            } else {
                currency = new CoinForStore(x + 50, 350 + 75);
            }
            buyButton.setBounds(x, 470, 70, 35);
            priceTag.setBounds(x, 420, 50, 30);
        } else {
            if (pack.getCurrency() instanceof Diamond) {
                currency = new Diamond(x + 30, y + 60);
            } else {
                currency = new CoinForStore(x + 50, y + 75);
            }
            buyButton.setBounds(x, y + 120, 70, 35);
            priceTag.setBounds(x, y + 70, 50, 30);
        }

        countLabel = new JLabel();
        countLabel.setBounds(x + 80, y + 120, 50, 50);
        countLabel.setFont(font22);
        if (pack.getCount() != -1) {// Count is Active
            countLabel.setText(pack.getCount() + " X");
        } else {// Count per Person is Active
            countLabel.setText(pack.getCountPerUser() + " X");
        }

        buyButton.setForeground(Color.BLACK);
        buyButton.setBackground(Color.GREEN);
        buyButton.setFocusable(false);
        buyButton.setFont(font10);

    }

    private void addPack() {

        for (PackItem packItem : pack.packItems) {
            backgroundLabel.add((ObjectsInGame) packItem);
        }

    }

    private void addButtonAction() {

        buyButton.addActionListener(e->{
            OnlineShopMessage shopMessage = new OnlineShopMessage();
            shopMessage.setMessageType(MessageType.ONLINE_SHOP_MESSAGE);
            shopMessage.setPackIndex(pack.getPackIndex());
            MyProject.activeClient.sendToServer(shopMessage);
        });

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

    public JLabel getCountLabel() {
        return countLabel;
    }

}
