package Model.Mario;

import MyProject.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Arrow extends MarioWeapon {

    private final BufferedImage background;
    private int x;
    private int y;
    private int XEndPosition;
    private int height = 50;
    private int width = 50;
    private int velocity = 30;
    private int secondCounter = 0;
    private int damage = 5;

    public Arrow(int x, int y) {

        background = MyProjectData.getProjectData().getFireBall();
        this.setSize(width, height);
        this.x = x;
        this.y = y;
        XEndPosition = x + 600;

    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(background, -0, 0, null);
    }

    @Override
    public void moveWeapon(Mario mario) {

        secondCounter++;
        if (secondCounter == 5) {
            if (getMarioVelocity() >= 0) {
                velocity = 30;
            } else {
                velocity = -30;
            }
            if (x <= XEndPosition) {
                x += velocity;
            }
            secondCounter = 0;
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

    public int getXEndPosition() {
        return XEndPosition;
    }

    public void setXEndPosition(int XEndPosition) {
        this.XEndPosition = XEndPosition;
    }

    public int getSecondCounter() {
        return secondCounter;
    }

    public void setSecondCounter(int secondCounter) {
        this.secondCounter = secondCounter;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
