package Graphic;

import Model.*;
import MyProject.MyProject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PrizeInAir extends ObjectsInGame {

    protected CoinInPrizeInAirs coinInPrizeInAirs;
    private BufferedImage background_Active;
    private BufferedImage background_InActive;
    private int x;
    private int y;
    private int width = 70;
    private int height = 70;

    protected boolean coinCatch;

    PrizeInAir(int x, int y) {

        this.setSize(width, height);

        background_Active = MyProject.projectData.getActivePrizeInAir();
        background_InActive = MyProject.projectData.getInActivePrizeInAir();

        this.x = x;
        this.y = y;

    }

    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        if (!coinCatch) {
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

    public CoinInPrizeInAirs getCoinInPrizeInAirs() {
        return coinInPrizeInAirs;
    }

    public void setCoinInPrizeInAirs(CoinInPrizeInAirs coinInPrizeInAirs) {
        this.coinInPrizeInAirs = coinInPrizeInAirs;
    }

    public boolean isCoinCatch() {
        return coinCatch;
    }

    public void setCoinCatch(boolean coinCatch) {
        this.coinCatch = coinCatch;
    }
}