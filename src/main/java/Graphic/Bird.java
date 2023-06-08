package Graphic;

import Model.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bird extends Enemy {

    private BufferedImage activeBackground;
    private BufferedImage background;
    private BufferedImage background_Filliped;
    private int secondCounterForBomb = 0;
    private int secondCounter = 0;
    private boolean throwBomb;
    private int x;
    private int y;
    private int startPosition;
    private int endPosition;
    private int width = 60;
    private int height = 120;
    private double velocity = 5;

    public Bird(int xx, int yy, int startPosition, int endPosition) {

        this.setSize(width, height);

        background = MyProjectData.getProjectData().getNukeBird();
        background_Filliped = MyProjectData.getProjectData().getNukeBird_Filliped();
        activeBackground = background;

        this.x = xx;
        this.y = yy;
        this.startPosition = startPosition;
        this.endPosition = endPosition;

    }

    public Bird() {

    }

    @Override
    public void move() {

        secondCounter++;
        if (secondCounter == 10) {
            secondCounterForBomb++;
            x += velocity;
            if (x >= endPosition || x <= startPosition) {
                velocity = -velocity;
            }
            if (secondCounterForBomb == 20 && !throwBomb) {
                throwBomb = true;
                secondCounterForBomb = 0;
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
        graphics2D.drawImage(activeBackground, -15, 0, null);
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

    public int getSecondCounterForBomb() {
        return secondCounterForBomb;
    }

    public void setSecondCounterForBomb(int secondCounterForBomb) {
        this.secondCounterForBomb = secondCounterForBomb;
    }

    public boolean isThrowBomb() {
        return throwBomb;
    }

    public void setThrowBomb(boolean throwBomb) {
        this.throwBomb = throwBomb;
    }

    public int getSecondCounter() {
        return secondCounter;
    }

    public void setSecondCounter(int secondCounter) {
        this.secondCounter = secondCounter;
    }
}
