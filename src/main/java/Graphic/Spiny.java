package Graphic;

import Model.MyProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Spiny extends Enemy {

    private BufferedImage background;
    private BufferedImage background_Filliped;
    private int x;
    private int y;
    private int marioX;
    private int marioY;
    private int marioHeight;
    private int width = 60;
    private int height = 70;
    private double velocity = 0;
    private final double acceleration = 0.5;

    public Spiny(int xx, int yy) {

        this.setSize(width, height);

        background = MyProjectData.getProjectData().getSpiny();
        background_Filliped = MyProjectData.getProjectData().getSpiny_Filliped();

        this.x = xx;
        this.y = yy;

    }

    public Spiny() {

    }

    @Override
    public void move() {

        // When Spiny Move Toward Mario:
        if ((x >= marioX + 200 || x <= marioX - 200) &&
                (marioY + marioHeight >= y + height - 30 || marioY + marioHeight <= y + height + 30)) {
            // Spiny Chasing Mario:
            if (x > marioX && velocity > 0) {
                velocity = -1;
            } else if (x < marioX && velocity < 0) {
                velocity = 1;
            }
            velocity += acceleration;
            x +=(int) velocity;
        }else
            velocity = 0;

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

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public int getMarioX() {
        return marioX;
    }

    public void setMarioX(int marioX) {
        this.marioX = marioX;
    }

    public int getMarioY() {
        return marioY;
    }

    public void setMarioY(int marioY) {
        this.marioY = marioY;
    }

    public int getMarioHeight() {
        return marioHeight;
    }

    public void setMarioHeight(int marioHeight) {
        this.marioHeight = marioHeight;
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

    @Override
    public double getVelocity() {
        return velocity;
    }

    @Override
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }
}
