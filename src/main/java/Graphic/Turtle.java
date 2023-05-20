package Graphic;

import Model.MyProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Turtle extends Enemy {

    private BufferedImage background;
    Timer timerForMovingTheGoompa;
    private int secondCounter = 0;

    private int x;
    private int y;
    private int width = 60;
    private int height = 70;
    private int velocity = -5;

    Turtle(int xx, int yy) {
        this.setSize(width, height);

        background = MyProjectData.getProjectData().getTurtle();

        this.x = xx;
        this.y = yy;

//        timerForMovingTheGoompa =new Timer(1, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//
//
//                secondCounter++;
//                if (secondCounter == 10) {
//                    y = y - velocity;
//                    if (y <= 695) {// Plant should go up
//                        velocity = -velocity;
//                    } else if (y >= 800) {
//                        velocity = -velocity;
//                    }
//                    secondCounter = 0;
//                }
//
//            }
//        });

//        timerForMovingTheGoompa.setRepeats(true);
//        timerForMovingTheGoompa.start();

    }

    public Turtle() {

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

}
