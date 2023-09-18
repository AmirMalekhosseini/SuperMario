package Model.Enemy;

import MyProject.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Turtle extends Enemy {

    private BufferedImage activeBackground;
    private BufferedImage background;
    private BufferedImage background_Filliped;
    public int hitCounter = 0;
    private boolean isTurtleHit;
    private int waitTime = 0;
    private int x;
    private int y;
    private int width = 60;
    private int height = 65;
    private double velocity = -5;
    private int scoreAdd = 2;

    public Turtle(int xx, int yy) {
        this.setSize(width, height);

        background = MyProjectData.getProjectData().getTurtle();
        background_Filliped = MyProjectData.getProjectData().getTurtle_Filliped();
        activeBackground = background;

        this.x = xx;
        this.y = yy;

    }

    public Turtle() {

    }

    @Override
    public void move() {

        secondCounter++;
        if (secondCounter == 10) {
            if (isTurtleHit) {
                waitTime++;
                if (waitTime == 24) {
                    x += velocity;
                    isTurtleHit = false;
                    waitTime = 0;
                }
            } else {
                x += velocity;
            }
            secondCounter = 0;
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

    @Override
    public double getVelocity() {
        return velocity;
    }

    @Override
    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public boolean isTurtleHit() {
        return isTurtleHit;
    }

    public void setTurtleHit(boolean turtleHit) {
        isTurtleHit = turtleHit;
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
