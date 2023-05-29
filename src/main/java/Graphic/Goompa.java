package Graphic;

import Model.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Goompa extends Enemy {

    private BufferedImage background;
    private BufferedImage background_Filliped;
    private int x;
    private int y;
    private int width = 60;
    private int height = 65;
    private double velocity = -5;

    public Goompa(int xx, int yy) {
        this.setSize(width, height);

        background = MyProjectData.getProjectData().getGoompa();
        background_Filliped = MyProjectData.getProjectData().getGoompa_Filliped();

        this.x = xx;
        this.y = yy;

    }

    public Goompa() {

    }

    @Override
    public void move() {

        secondCounter++;
        if (secondCounter == 10) {
            x += velocity;
            secondCounter = 0;
        }

    }

    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        if (velocity <= 0) {
            graphics2D.drawImage(background, -5, 0, null);
        } else {
            graphics2D.drawImage(background_Filliped, -5, 0, null);
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

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }
}
