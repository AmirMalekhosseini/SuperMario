package Model.NetworkCommunication.Message;

import Model.Item.Currency;
import Model.OnlineStorePack.Pack;

import java.util.ArrayList;

public class PackMessage extends Message {

    private ArrayList<String> packItems;
    private int price;
    private String currency;
    private int count = -1;
    private int countPerUser = -1;
    private int level = 0;
    private String startTime;
    private String endTime;
    private int packIndex;
    public PackMessage() {
        packItems = new ArrayList<>();
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCountPerUser() {
        return countPerUser;
    }

    public void setCountPerUser(int countPerUser) {
        this.countPerUser = countPerUser;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPackIndex() {
        return packIndex;
    }

    public void setPackIndex(int packIndex) {
        this.packIndex = packIndex;
    }

    public ArrayList<String> getPackItems() {
        return packItems;
    }

    public void setPackItems(ArrayList<String> packItems) {
        this.packItems = packItems;
    }
}
