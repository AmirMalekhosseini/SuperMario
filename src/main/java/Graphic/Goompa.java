package Graphic;

import Model.MyProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Goompa extends Enemy {

    private BufferedImage background;
    private int x;
    private int y;
    private int width = 60;
    private int height = 65;
    private int velocity = -5;

    Goompa(int xx, int yy) {
        this.setSize(width, height);

        background = MyProjectData.getProjectData().getGoompa();

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

    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(background, 0, -5, null);
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

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }
}
