package Model.Object;

import Model.Item.ItemsInGame;
import MyProject.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PrizeInAir extends ObjectsInGame {

    protected ItemsInGame itemInPrizeInAir;
    private BufferedImage background_Active;
    private BufferedImage background_InActive;
    private int x;
    private int y;
    private int width = 70;
    private int height = 70;

    protected boolean itemCatch;

    public PrizeInAir(int x, int y) {

        this.setSize(width, height);

        background_Active = MyProjectData.getProjectData().getActivePrizeInAir();
        background_InActive = MyProjectData.getProjectData().getInActivePrizeInAir();

        this.x = x;
        this.y = y;

    }

    public PrizeInAir() {

    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        if (!itemCatch) {
            graphics2D.drawImage(background_Active, 0, -5, null);
        } else {
            graphics2D.drawImage(background_InActive, 0, -5, null);
        }
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    @Override
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public boolean isItemCatch() {
        return !itemCatch;
    }

    public void setItemCatch(boolean itemCatch) {
        this.itemCatch = itemCatch;
    }

    public ItemsInGame getItemInPrizeInAir() {
        return itemInPrizeInAir;
    }

    public void setItemInPrizeInAir(ItemsInGame itemInPrizeInAir) {
        this.itemInPrizeInAir = itemInPrizeInAir;
    }
}
