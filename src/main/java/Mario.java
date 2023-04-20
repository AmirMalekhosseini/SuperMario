import javax.swing.*;

public abstract class Mario extends JLabel {


    private int width = 70;
    private int height = 120;

    private boolean isMarioJumping;
    private boolean isMarioLeft;
    private boolean isMarioRight;


    public abstract void setX(int x);

    public abstract void setY(int y);


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
}
