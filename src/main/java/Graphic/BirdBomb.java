package Graphic;

import Model.MyProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BirdBomb extends Enemy {

    private BufferedImage background;
    Timer timerForMovingTheGoompa;
    private int secondCounter = 0;

    private int x;
    private int y;
    private int width = 35;
    private int height = 65;
    private int velocity = -5;

    BirdBomb(int xx, int yy) {

        this.setSize(width, height);

        background = MyProjectData.getProjectData().getBirdBomb();

        this.x = xx;
        this.y = yy;

    }

    public BirdBomb() {

    }

    @Override
    public void move() {

    }

    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(background, -15, -5, null);
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
