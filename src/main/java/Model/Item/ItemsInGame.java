package Model.Item;

import Model.Object.ObjectsInGame;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ItemsInGame extends ObjectsInGame {

    private BufferedImage background;
    private int x;
    private int y;
    private int height = 40;
    private int width = 40;
    private int scoreItemAdds;
    private boolean itemCatch;
    private int xVelocity;
    private int yVelocity;
    private boolean isItemHitsAnObject;

    public ItemsInGame() {

    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(background, 0, -5, null);
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
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public boolean isItemCatch() {
        return itemCatch;
    }

    public void setItemCatch(boolean itemCatch) {
        this.itemCatch = itemCatch;
    }

    public int getScoreItemAdds() {
        return scoreItemAdds;
    }

    public void setScoreItemAdds(int scoreItemAdds) {
        this.scoreItemAdds = scoreItemAdds;
    }

    public int getXVelocity() {
        return xVelocity;
    }

    public void setXVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public int getYVelocity() {
        return yVelocity;
    }

    public void setYVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public boolean isItemHitsAnObject() {
        return !isItemHitsAnObject;
    }

    public void setItemHitsAnObject(boolean itemHitsAnObject) {
        isItemHitsAnObject = itemHitsAnObject;
    }
}
