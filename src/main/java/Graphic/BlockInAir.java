package Graphic;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class BlockInAir extends ObjectsInGame {

    private BufferedImage background;
    private int x;
    private int y;
    private int width = 70;
    private int height = 70;


    public BlockInAir() {
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

}
