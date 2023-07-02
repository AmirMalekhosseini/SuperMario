package Model.Mario;

import MyProject.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Shield extends MarioWeapon {

    private final BufferedImage background;
    private int x;
    private int y;
    private int height = 180;
    private int width = 180;
    private int damage = 10;

    public Shield(int x, int y) {

        background = MyProjectData.getProjectData().getShield();
        this.setSize(width, height);
        this.x = x;
        this.y = y;

    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(background, -0, 0, width, height, null);
    }

    @Override
    public void moveWeapon(Mario mario) {

        setX(mario.getX() - 50);
        setY(mario.getY() - 40);

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
    public int getHeight() {
        return height;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
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
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
