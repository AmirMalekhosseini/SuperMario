package Graphic;

import MyProject.MyProject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Coin extends ObjectsInGame {


    private BufferedImage background;

    private int x;
    private int y;
    private int width = 40;
    private int height = 40;

    private boolean isCoinCatch;


    Coin(int x, int y) {

        this.setSize(width, height);

        background = MyProject.projectData.getCoin();

        this.x = x;
        this.y = y;
    }

    public Coin() {
    }

    public void paint(Graphics graphics) {
        if (!isCoinCatch) {
            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.drawImage(background, 0, -5, null);
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

    public boolean isCoinCatch() {
        return isCoinCatch;
    }

    public void setCoinCatch(boolean coinCatch) {
        isCoinCatch = coinCatch;
    }
}
