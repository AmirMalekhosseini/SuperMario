package Model.Enemy;

import MyProject.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Spiny extends Enemy {

    private BufferedImage activeBackground;
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
    private double acceleration = -0.01;
    private int scoreAdd = 3;

    public Spiny(int xx, int yy) {

        this.setSize(width, height);

        background = MyProjectData.getProjectData().getSpiny();
        background_Filliped = MyProjectData.getProjectData().getSpiny_Filliped();
        activeBackground = background;

        this.x = xx;
        this.y = yy;

    }

    public Spiny() {

    }

    @Override
    public void move() {

        // When Spiny Move Toward Mario:

        if (x >= marioX) {
            if (x - 600 <= marioX && marioY + marioHeight >= y + height - 30) {
                // Spiny Chasing Mario:
                if (velocity > 0) {
                    velocity = 0;
                }
                acceleration = -0.01;
                velocity += acceleration;
                x += (int) velocity;
            }else
                velocity = 0;
        } else {
            if (x + 600 >= marioX && marioY + marioHeight >= y + height - 30) {
                if (velocity < 0) {
                    velocity = 0;
                }
                acceleration = 0.01;
                velocity += acceleration;
                x += (int) velocity;
            }else
                velocity = 0;
        }

    }
    @Override
    public void changeBackground() {
        if (velocity <= 0) {
            activeBackground = background;
        } else {
            activeBackground = background_Filliped;
        }
    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(activeBackground, -5, 0, null);
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

    @Override
    public int getScoreAdd() {
        return scoreAdd;
    }

    @Override
    public void setScoreAdd(int scoreAdd) {
        this.scoreAdd = scoreAdd;
    }
}
