package Graphic;

import Model.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public abstract class Mario extends JLabel {


    private final BufferedImage fireMario;
    private final BufferedImage fireMario_Mini;
    private final BufferedImage fireMario_Filliped;
    private final BufferedImage fireMario_Filliped_Mini;
    private int width = 70;
    private int height = 120;
    private boolean isMarioJumping;
    private boolean isMarioLeft;
    private boolean isMarioRight;
    private boolean isMarioSit;
    private boolean isMarioMini = false;
    private boolean isMarioMega;
    private boolean isMarioShooter = true;

    public Mario() {

        fireMario = MyProjectData.getProjectData().getFireMario();
        fireMario_Mini = MyProjectData.getProjectData().getFireMario_Mini();
        fireMario_Filliped = MyProjectData.getProjectData().getFireMario_Filliped();
        fireMario_Filliped_Mini = MyProjectData.getProjectData().getFireMario_Filliped_Mini();

    }


    public abstract void setX(int x);

    public abstract void setY(int y);



    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }


    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract double getVelocityY();

    public abstract void setVelocityY(double velocityY);

    public abstract double getVelocityX();

    public abstract void setVelocityX(double velocityX);

    public boolean isMarioJumping() {
        return isMarioJumping;
    }

    public void setMarioJumping(boolean marioJumping) {
        isMarioJumping = marioJumping;
    }

    public boolean isMarioLeft() {
        return isMarioLeft;
    }

    public void setMarioLeft(boolean marioLeft) {
        isMarioLeft = marioLeft;
    }

    public boolean isMarioRight() {
        return isMarioRight;
    }

    public void setMarioRight(boolean marioRight) {
        isMarioRight = marioRight;
    }

    public boolean isMarioMini() {
        return isMarioMini;
    }

    public void setMarioMini(boolean marioMini) {
        isMarioMini = marioMini;
    }

    public boolean isMarioMega() {
        return isMarioMega;
    }

    public void setMarioMega(boolean marioMega) {
        isMarioMega = marioMega;
    }

    public boolean isMarioShooter() {
        return isMarioShooter;
    }

    public void setMarioShooter(boolean marioShooter) {
        isMarioShooter = marioShooter;
    }

    public BufferedImage getFireMario() {
        return fireMario;
    }

    public BufferedImage getFireMario_Mini() {
        return fireMario_Mini;
    }

    public BufferedImage getFireMario_Filliped() {
        return fireMario_Filliped;
    }

    public BufferedImage getFireMario_Filliped_Mini() {
        return fireMario_Filliped_Mini;
    }

    public boolean isMarioSit() {
        return isMarioSit;
    }

    public void setMarioSit(boolean marioSit) {
        isMarioSit = marioSit;
    }
}
