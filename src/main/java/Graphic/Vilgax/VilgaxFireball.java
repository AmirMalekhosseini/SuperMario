package Graphic.Vilgax;

import Model.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class VilgaxFireball extends VilgaxWeapon {

    private final BufferedImage background;
    private int x;
    private int y;
    private int height = 80;
    private int width = 80;
    private int velocity = 30;
    private int secondCounter = 0;

    public VilgaxFireball(int x, int y) {

        background = MyProjectData.getProjectData().getVilgax_FireBall();
        this.setSize(width, height);
        this.x = x;
        this.y = y;

    }

    @Override

    public void move() {

        secondCounter++;
        if (secondCounter == 5) {
            if (getVilgaxVelocity() >= 0) {
                velocity = 30;
            } else {
                velocity = -30;
            }
            x += velocity;

            secondCounter = 0;
        }

    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(background, -0, 0, 80, 80, null);
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

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public int getSecondCounter() {
        return secondCounter;
    }

    public void setSecondCounter(int secondCounter) {
        this.secondCounter = secondCounter;
    }
}
