package Model.Item.Online;

import Model.Object.ObjectsInGame;
import MyProject.MyProjectData;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Bag extends ObjectsInGame {

    private final BufferedImage background;
    private ArrayList<String> bagItems = new ArrayList<>();

    private int x;
    private int y;

    private int height = 80;
    private int width = 80;

    public Bag(int x, int y) {

        this.setSize(width, height);

        background = MyProjectData.getProjectData().getBag();

        this.x = x;
        this.y = y;

    }

    public Bag() {
        background = MyProjectData.getProjectData().getBag();
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(background, -0, -0, width, height, null);
    }

    public ArrayList<String> getBagItems() {
        return bagItems;
    }

    public void setBagItems(ArrayList<String> bagItems) {
        this.bagItems = bagItems;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }
}
