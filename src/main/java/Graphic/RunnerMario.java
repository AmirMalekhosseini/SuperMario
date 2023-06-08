package Graphic;

import Model.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RunnerMario extends Mario {

    private BufferedImage activeBackground;
    private BufferedImage run_1;
    private BufferedImage run_2;
    private BufferedImage run_3;
    private BufferedImage run_3_Mini;
    private BufferedImage jump;
    private BufferedImage stand;
    private BufferedImage stand_Mini;
    private BufferedImage run_1_Flipped;
    private BufferedImage run_2_Flipped;
    private BufferedImage run_3_Flipped;
    private BufferedImage run_3_Flipped_Mini;
    private BufferedImage jump_Flipped;
    private BufferedImage stand_Flipped;

    private volatile int x;
    private volatile int y;
    private double velocityY;
    private double velocityX;

    public RunnerMario(int x, int y) {

        this.setSize(super.getWidth(), super.getHeight());

        MyProjectData projectData = MyProjectData.getProjectData();
        run_1 = projectData.getRunnerMario_Run_1();
        run_2 = projectData.getRunnerMario_Run_2();
        run_3 = projectData.getRunnerMario_Run_3();
        run_3_Mini = projectData.getRunnerMario_Run_3_Mini();
        stand = projectData.getRunnerMario_Stand();
        stand_Mini = projectData.getRunnerMario_Stand_Mini();
        jump = projectData.getRunnerMario_jump();
        run_1_Flipped = projectData.getRunnerMario_Run_1_Flipped();
        run_2_Flipped = projectData.getRunnerMario_Run_2_Flipped();
        run_3_Flipped = projectData.getRunnerMario_Run_3_Flipped();
        run_3_Flipped_Mini = projectData.getRunnerMario_Run_3_Flipped_Mini();
        jump_Flipped = projectData.getRunnerMario_jump_Flipped();
        stand_Flipped = projectData.getRunnerMario_Stand_Flipped();
        activeBackground = stand_Mini;

        this.x = x;
        this.y = y;

    }

    public RunnerMario() {

    }

    @Override
    public void changeBackground() {

        if (isMarioMini()) {

            if (velocityX > 0) {
                activeBackground = run_3_Mini;
            } else if (velocityX < 0) {
                activeBackground = run_3_Flipped_Mini;
            } else {
                activeBackground = stand_Mini;
            }

        } else if (isMarioMega()) {

            if (isMarioSit()) {// Mario is Siting:
                if (velocityX > 0) {
                    activeBackground = run_3_Mini;
                } else if (velocityX < 0) {
                    activeBackground = run_3_Flipped_Mini;
                } else {
                    activeBackground = stand_Mini;
                }
            } else {// Mario is standing:
                if (velocityX > 0) {
                    activeBackground = run_3;
                } else if (velocityX < 0) {
                    activeBackground = run_3_Flipped;
                } else {
                    activeBackground = stand;
                }
            }

        } else if (isMarioShooter()) {

            if (isMarioSit()) {// Mario is Siting:
                if (velocityX > 0) {
                    activeBackground = getFireMario_Mini();
                } else if (velocityX < 0) {
                    activeBackground = getFireMario_Filliped_Mini();
                } else {
                    activeBackground = getFireMario_Mini();
                }
            } else {// Mario is standing:
                if (velocityX > 0) {
                    activeBackground = getFireMario();
                } else if (velocityX < 0) {
                    activeBackground = getFireMario_Filliped();
                } else {
                    activeBackground = getFireMario();
                }
            }

        }

    }


    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(activeBackground, -0, -5, null);
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


