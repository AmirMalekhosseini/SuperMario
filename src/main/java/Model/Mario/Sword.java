package Model.Mario;

import MyProject.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Sword extends MarioWeapon{

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
    private boolean isSwordChangeDirection;
    private boolean isMarioThrowedSword;
    private int damage = 5;

    public Sword(int x, int y) {

        background = MyProjectData.getProjectData().getSword();
        backgroundFilliped = MyProjectData.getProjectData().getSwordFilliped();
        this.setSize(width, height);
        this.x = x;
        this.y = y;

    }

    @Override

    public void move() {

        secondCounter++;
        if (secondCounter == 5) {
            if (!isMarioThrowedSword) {
                if (getMarioVelocity() > 0) {
                    velocity = 30;
                    XStartPosition = x - 10;
                    XEndPosition = x + 600;
                } else {
                    velocity = -30;
                    XStartPosition = x + 10;
                    XEndPosition = x - 600;
                }
                isMarioThrowedSword = true;
            }

            if (getMarioVelocity() > 0) {// Mario Throws Sword in positive direction:
                if (x <= XEndPosition) {
                    x += velocity;
                } else if (!isSwordChangeDirection) {
                    velocity = -velocity;
                    x += velocity;
                    isSwordChangeDirection = true;
                }
            } else {
                if (x >= XEndPosition) {
                    x += velocity;
                } else if (!isSwordChangeDirection) {
                    velocity = -velocity;
                    x += velocity;
                    isSwordChangeDirection = true;
                }
            }

            secondCounter = 0;
        }

    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        if (velocity > 0) {
            graphics2D.drawImage(background, -0, -0, null);
        } else {
            graphics2D.drawImage(backgroundFilliped, -0, -0, null);
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

    public int getXStartPosition() {
        return XStartPosition;
    }

    public void setXStartPosition(int XStartPosition) {
        this.XStartPosition = XStartPosition;
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

    public boolean isSwordChangeDirection() {
        return isSwordChangeDirection;
    }

    public void setSwordChangeDirection(boolean swordChangeDirection) {
        isSwordChangeDirection = swordChangeDirection;
    }

    public void setMarioThrowedSword(boolean marioThrowedSword) {
        isMarioThrowedSword = marioThrowedSword;
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
