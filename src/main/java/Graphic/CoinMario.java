package Graphic;

import Model.*;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CoinMario extends Mario {

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

    CoinMario(int x, int y) {

        this.setSize(super.getWidth(), super.getHeight());

        MyProjectData projectData = MyProjectData.getProjectData();
        run_1 = projectData.getCoinMario_Run_1();
        run_2 = projectData.getCoinMario_Run_2();
        run_3 = projectData.getCoinMario_Run_3();
        run_3_Mini = projectData.getCoinMario_Run_3_Mini();
        stand = projectData.getCoinMario_Stand();
        stand_Mini = projectData.getCoinMario_Stand_Mini();
        jump = projectData.getCoinMario_jump();
        run_1_Flipped = projectData.getCoinMario_Run_1_Flipped();
        run_2_Flipped = projectData.getCoinMario_Run_2_Flipped();
        run_3_Flipped = projectData.getCoinMario_Run_3_Flipped();
        run_3_Flipped_Mini = projectData.getCoinMario_Run_3_Flipped_Mini();
        jump_Flipped = projectData.getCoinMario_jump_Flipped();
        stand_Flipped = projectData.getCoinMario_Stand_Flipped();

        this.x = x;
        this.y = y;

    }

    public CoinMario() {

    }


    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;

        if (isMarioMini()) {

            if (velocityX > 0) {
                graphics2D.drawImage(run_3_Mini, -0, -5, null);
            } else if (velocityX < 0) {
                graphics2D.drawImage(run_3_Flipped_Mini, -0, -5, null);
            } else {
                graphics2D.drawImage(stand_Mini, -0, -5, null);
            }

        } else if (isMarioMega()) {

            if (isMarioSit()) {// Mario is Siting:
                if (velocityX > 0) {
                    graphics2D.drawImage(run_3_Mini, -0, -5, null);
                } else if (velocityX < 0) {
                    graphics2D.drawImage(run_3_Flipped_Mini, -0, -5, null);
                } else {
                    graphics2D.drawImage(stand_Mini, -0, -5, null);
                }
            } else {// Mario is standing:
                if (velocityX > 0) {
                    graphics2D.drawImage(run_3, -0, -5, null);
                } else if (velocityX < 0) {
                    graphics2D.drawImage(run_3_Flipped, -0, -5, null);
                } else {
                    graphics2D.drawImage(stand, -0, -5, null);
                }
            }

        } else if (isMarioShooter()) {

            if (isMarioSit()) {// Mario is Siting:
                if (velocityX > 0) {
                    graphics2D.drawImage(getFireMario_Mini(), -0, -5, null);
                } else if (velocityX < 0) {
                    graphics2D.drawImage(getFireMario_Filliped_Mini(), -0, -5, null);
                } else {
                    graphics2D.drawImage(getFireMario_Mini(), -0, -5, null);
                }
            } else {// Mario is standing:
                if (velocityX > 0) {
                    graphics2D.drawImage(getFireMario(), -0, -5, null);
                } else if (velocityX < 0) {
                    graphics2D.drawImage(getFireMario_Filliped(), -0, -5, null);
                } else {
                    graphics2D.drawImage(getFireMario(), -0, -5, null);
                }
            }

        }

    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
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
