package Graphic;

import Model.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class CheckPoint extends ObjectsInGame {

    private BufferedImage background;
    private int x;
    private int y;
    private int height = 120;
    private int width = 50;

    public CheckPoint(int x, int y) {

        this.setSize(width, height);
        this.x = x;
        this.y = y;
        background = MyProjectData.getProjectData().getCheckPoint();

    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(background, -0, -0,50,120, null);
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
