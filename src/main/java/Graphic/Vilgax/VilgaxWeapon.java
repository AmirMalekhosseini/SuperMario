package Graphic.Vilgax;

import Graphic.ObjectsInGame;

public abstract class VilgaxWeapon extends ObjectsInGame {

    private int x;
    private int y;
    private int vilgaxVelocity;
    private int height;
    private int width;

    public abstract void move();

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
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getVilgaxVelocity() {
        return vilgaxVelocity;
    }

    public void setVilgaxVelocity(int vilgaxVelocity) {
        this.vilgaxVelocity = vilgaxVelocity;
    }
}
