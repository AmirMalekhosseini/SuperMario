package Model.Enemy;

import MyProject.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Goompa extends Enemy {

    private BufferedImage activeBackground;
    private BufferedImage background;
    private BufferedImage background_Filliped;
    private int x;
    private int y;
    private int width = 60;
    private int height = 65;
    private double velocity = -5;
    private int scoreAdd = 1;

    public Goompa(int xx, int yy) {

        this.setSize(width, height);

        background = MyProjectData.getProjectData().getGoompa();
        background_Filliped = MyProjectData.getProjectData().getGoompa_Filliped();
        activeBackground = background;

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

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public int getScoreAdd() {
        return scoreAdd;
    }

    public void setScoreAdd(int scoreAdd) {
        this.scoreAdd = scoreAdd;
    }
}
