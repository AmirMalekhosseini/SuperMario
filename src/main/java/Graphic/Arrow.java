package Graphic;

import Model.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Arrow extends MarioWeapon {

    private final BufferedImage background;
    private int x;
    private int y;
    private int XEndPosition;
    private int height = 50;
    private int width = 50;
    private int velocity = 10;

    public Arrow(int x, int y) {

        background = MyProjectData.getProjectData().getFireBall();
        this.setSize(width, height);
        this.x = x;
        this.y = y;

    }

    @Override

    public void move() {

    }

    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(background, -0, 0, null);
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
}
