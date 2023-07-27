package Model.Mario.Online;

import Model.Mario.Mario;
import MyProject.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class DamageBomb extends OnlineWeapon {


    private final BufferedImage background;
    private int x;
    private int y;
    private int XEndPosition;
    private int XStartPosition;
    private int height = 50;
    private int width = 70;
    private int velocity;
    private int secondCounter = 0;
    private boolean isMarioThrewBomb;
    private int damage = 5;// ToDo.

    public DamageBomb(int x, int y) {

        background = MyProjectData.getProjectData().getDamageBomb();
        this.setSize(width, height);
        this.x = x;
        this.y = y;

    }

    @Override
    public void moveWeapon(Mario mario) {

        // ToDo: Check this.
        secondCounter++;
        if (secondCounter == 5) {
            if (getMarioVelocity() > 0) {
                velocity = 30;
                XStartPosition = x - 10;
                XEndPosition = x + 600;
            } else {
                velocity = -30;
                XStartPosition = x + 10;
                XEndPosition = x - 600;
            }

            if (getMarioVelocity() > 0) {// Mario Throws Bomb in positive direction:
                if (x <= XEndPosition) {
                    x += velocity;
                }
            } else {
                if (x >= XEndPosition) {
                    x += velocity;
                }
            }
            secondCounter = 0;
        }

    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(background, -0, -0, width, height, null);
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
    public int getXEndPosition() {
        return XEndPosition;
    }

    @Override
    public void setXEndPosition(int XEndPosition) {
        this.XEndPosition = XEndPosition;
    }

    @Override
    public int getXStartPosition() {
        return XStartPosition;
    }

    @Override
    public void setXStartPosition(int XStartPosition) {
        this.XStartPosition = XStartPosition;
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

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public boolean isMarioThrewBomb() {
        return isMarioThrewBomb;
    }

    public void setMarioThrewBomb(boolean marioThrewBomb) {
        isMarioThrewBomb = marioThrewBomb;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSecondCounter() {
        return secondCounter;
    }

    public void setSecondCounter(int secondCounter) {
        this.secondCounter = secondCounter;
    }
}
