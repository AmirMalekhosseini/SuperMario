package Graphic;

import Model.MyProjectData;
import MyProject.MyProject;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Plant extends Enemy {

    private BufferedImage activeBackground;
    private BufferedImage background;
    public int plantWaitTime = 0;

    private int x;
    private int y;
    private int width = 65;
    private int height = 75;
    private double velocity = +5;

    Plant(int xx, int yy) {
        this.setSize(width, height);

        background = MyProjectData.getProjectData().getPlant();
        activeBackground = background;

        this.x = xx;
        this.y = yy;

    }

    public Plant() {

    }

    @Override
    public void move() {

        secondCounter++;
        if (secondCounter == 10) {
            y -= velocity;
            if (y <= 695) {// Plant should go up
                velocity = -velocity;
                plantWaitTime++;
                velocity = 0;
                if (plantWaitTime == 20) {
                    velocity = -5;
                    plantWaitTime = 0;
                }
            } else if (y >= 850) {
                velocity = -velocity;
            }
            secondCounter = 0;
        }

    }
    @Override
    public void changeBackground() {
        activeBackground = background;
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
}
