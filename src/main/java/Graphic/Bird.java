package Graphic;

import Model.MyProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Bird extends Enemy{

    protected BirdBomb birdBomb;
    private BufferedImage background;
    private BufferedImage background_Filliped;
    private int secondCounter = 0;
    private int x;
    private int y;
    private int startPosition;
    private int endPosition;
    private int width = 60;
    private int height = 120;
    private double velocity = 5;

    public Bird(int xx, int yy, int startPosition, int endPosition) {

        birdBomb = new BirdBomb(xx, yy);
        this.setSize(width, height);

        background = MyProjectData.getProjectData().getNukeBird();
        background_Filliped = MyProjectData.getProjectData().getNukeBird_Filliped();

        this.x = xx;
        this.y = yy;
        this.startPosition = startPosition;
        this.endPosition = endPosition;

    }

    public Bird() {

    }

    @Override
    public void move() {

        x += velocity;
        if (x >= endPosition || x <= startPosition) {
            velocity = -velocity;
        }

    }

    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        if (velocity <= 0) {
            graphics2D.drawImage(background, -15, 0, null);
        } else {
            graphics2D.drawImage(background_Filliped, -15, 0, null);
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

    public int getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
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

    public int getSecondCounter() {
        return secondCounter;
    }

    public void setSecondCounter(int secondCounter) {
        this.secondCounter = secondCounter;
    }
}
