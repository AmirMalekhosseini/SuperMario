package Model.Mario.Online;

import Model.Mario.Mario;
import MyProject.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Hammer extends OnlineWeapon {


    private final BufferedImage background;
    private final BufferedImage backgroundFilliped;
    private int x;
    private int y;
    private int XEndPosition;
    private int XStartPosition;
    private int height = 50;
    private int width = 120;
    private int velocity;
    private int secondCounter = 0;
    private boolean isHammerChangeDirection;
    private boolean isMarioThrewHammer;
    private int damage = 5;// ToDo.

    public Hammer(int x, int y) {

        background = MyProjectData.getProjectData().getHammer();
        backgroundFilliped = MyProjectData.getProjectData().getHammerFilliped();
        this.setSize(width, height);
        this.x = x;
        this.y = y;

    }

    public Hammer(int x, int y,Boolean isForStore) {

        background = MyProjectData.getProjectData().getHammer();
        backgroundFilliped = MyProjectData.getProjectData().getHammerFilliped();
        width = 80;
        height = 50;
        this.setSize(width, height);
        this.x = x;
        this.y = y;

    }

    @Override
    public void moveWeapon(Mario mario) {

        // ToDo: Check this.
        secondCounter++;
        if (secondCounter == 5) {
            if (!isHammerChangeDirection) {
                if (getMarioVelocity() > 0) {
                    velocity = 30;
                    XStartPosition = x - 10;
                    XEndPosition = x + 600;
                } else {
                    velocity = -30;
                    XStartPosition = x + 10;
                    XEndPosition = x - 600;
                }
                isHammerChangeDirection = true;
            }

            if (getMarioVelocity() > 0) {// Mario Throws Sword in positive direction:
                if (x <= XEndPosition) {
                    x += velocity;
                } else if (!isHammerChangeDirection) {
                    velocity = -velocity;
                    x += velocity;
                    isHammerChangeDirection = true;
                }
            } else {
                if (x >= XEndPosition) {
                    x += velocity;
                } else if (!isHammerChangeDirection) {
                    velocity = -velocity;
                    x += velocity;
                    isHammerChangeDirection = true;
                }
            }
            secondCounter = 0;
        }

    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        if (velocity >= 0) {
            graphics2D.drawImage(background, -0, -0,width,height, null);
        } else {
            graphics2D.drawImage(backgroundFilliped, -0, -0,width,height, null);
        }
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

    public boolean isHammerChangeDirection() {
        return isHammerChangeDirection;
    }

    public void setHammerChangeDirection(boolean hammerChangeDirection) {
        isHammerChangeDirection = hammerChangeDirection;
    }

    public boolean isMarioThrewHammer() {
        return isMarioThrewHammer;
    }

    public void setMarioThrewHammer(boolean marioThrewHammer) {
        isMarioThrewHammer = marioThrewHammer;
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
