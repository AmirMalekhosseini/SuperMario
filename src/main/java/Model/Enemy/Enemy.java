package Model.Enemy;

import Model.Object.ObjectsInGame;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Enemy extends ObjectsInGame {

    private BufferedImage background;
    private BufferedImage background_Filliped;
    private int x;
    private int y;
    private int height;
    private int width;
    public int secondCounter = 0;
    private int scoreAdd;
    private double velocity;
    private boolean isEnemyHitsAnObject;

    public Enemy() {

    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(background, 0, -5, null);
    }
    public abstract void move();

    public abstract void changeBackground();
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


    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    public boolean isEnemyHitsAnObject() {
        return !isEnemyHitsAnObject;
    }

    public void setEnemyHitsAnObject(boolean enemyHitsAnObject) {

        isEnemyHitsAnObject = enemyHitsAnObject;
    }

    public int getScoreAdd() {
        return scoreAdd;
    }

    public void setScoreAdd(int scoreAdd) {
        this.scoreAdd = scoreAdd;
    }
}
