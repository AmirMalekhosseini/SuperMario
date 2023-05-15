package Graphic;

import Model.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NormalMario extends Mario {


    private BufferedImage run_1;
    private BufferedImage run_2;
    private BufferedImage run_3;
    private BufferedImage jump;
    private BufferedImage stand;
    private BufferedImage run_1_Flipped;
    private BufferedImage run_2_Flipped;
    private BufferedImage run_3_Flipped;
    private BufferedImage jump_Flipped;
    private BufferedImage stand_Flipped;

    private int x;
    private int y;
    private int width = 70;
    private int height = 120;

    private double velocityY = -10;
    private double velocityX = 5;

    NormalMario(int x, int y) {

        this.setSize(this.width, this.height);

        MyProjectData projectData = new MyProjectData();
        run_1 = projectData.getNormalMario_Run_1();
        run_2 = projectData.getNormalMario_Run_2();
        run_3 = projectData.getNormalMario_Run_3();
        stand = projectData.getNormalMario_Stand();
        jump = projectData.getNormalMario_jump();
        run_1_Flipped = projectData.getNormalMario_Run_1_Flipped();
        run_2_Flipped = projectData.getNormalMario_Run_2_Flipped();
        run_3_Flipped = projectData.getNormalMario_Run_3_Flipped();
        jump_Flipped = projectData.getNormalMario_jump_Flipped();
        stand_Flipped = projectData.getNormalMario_Stand_Flipped();

        this.x = x;
        this.y = y;
    }

    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        if (isMarioRight()) {
            graphics2D.drawImage(run_3, -0, -5, null);
        } else if (isMarioLeft()) {
            graphics2D.drawImage(run_3_Flipped, -0, -5, null);
        } else {
            graphics2D.drawImage(stand, -0, -5, null);
        }

    }

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

    @Override
    public double getVelocityY() {
        return velocityY;
    }

    @Override
    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    @Override
    public double getVelocityX() {
        return velocityX;
    }

    @Override
    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }
}
