package Graphic;

import Model.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SimpleBlockInAir extends BlockInAir{

    private BufferedImage background;
    private int x;
    private int y;
    private int width = super.getWidth();
    private int height = super.getHeight();

    public SimpleBlockInAir(int x, int y) {

        this.setSize(width, height);

        background = MyProjectData.getProjectData().getBlockInAir();

        this.x = x;
        this.y = y;

    }

    public SimpleBlockInAir() {

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
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

}
