package Graphic;

import Model.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Star extends ItemsInGame{


    private BufferedImage background;

    private int x;
    private int y;
    private int height = 50;
    private int width = 50;
    private int scoreItemAdds = 40;
    private int xVelocity = 5;
    private int yVelocity = 30;
    private int secondCounter = 0;
    private int waitTime;
    private int jumpTime;
    private boolean isItemConstant = true;
    private boolean isJumping;
    private boolean isItemHitsAnObject;

    public Star(int x, int y) {

        this.setSize(width, height);

        background = MyProjectData.getProjectData().getStar();

        this.x = x;
        this.y = y;
    }

    public Star() {
    }

    @Override
    public void move() {

        secondCounter++;
        if (secondCounter == 10) {
            if (isItemConstant) {
                waitTime++;
                if (waitTime == 24) {
                    x += xVelocity;
                    isItemConstant = false;
                    waitTime = 0;
                }
            } else {
                jumpTime++;
                if (jumpTime >= 16 && jumpTime <= 20) {// Star Is Jumping:
                    isJumping = true;
                    yVelocity = 30;
                    y -= yVelocity;
                    if (jumpTime == 20) {// Star Stop Jumping:
                        isJumping = false;
                        jumpTime = 0;
                    }
                } else {
                    x += xVelocity;
                }
            }
            secondCounter = 0;
        }

    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (!isItemCatch()) {
            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.drawImage(background, 0, -0, null);
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
    public int getScoreItemAdds() {
        return scoreItemAdds;
    }

    @Override
    public void setScoreItemAdds(int scoreItemAdds) {
        this.scoreItemAdds = scoreItemAdds;
    }

    public boolean isItemConstant() {
        return isItemConstant;
    }

    public void setItemConstant(boolean itemConstant) {
        isItemConstant = itemConstant;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    public int getXVelocity() {
        return xVelocity;
    }

    public void setXVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public int getYVelocity() {
        return yVelocity;
    }

    public void setYVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public int getSecondCounter() {
        return secondCounter;
    }

    public void setSecondCounter(int secondCounter) {
        this.secondCounter = secondCounter;
    }

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }

    public boolean isItemHitsAnObject() {
        return !isItemHitsAnObject;
    }

    public void setItemHitsAnObject(boolean itemHitsAnObject) {
        isItemHitsAnObject = itemHitsAnObject;
    }
}
