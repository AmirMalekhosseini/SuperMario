package Graphic;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Enemy extends JLabel {

    private BufferedImage background;
    Timer timerForMovingEnemy;
    private int x;
    private int y;
    private int height;
    private int width;

    public Enemy() {

    }

    public void paint(Graphics graphics) {
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


}
