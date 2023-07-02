package Model.Mario;

import Model.Object.ObjectsInGame;

public abstract class MarioWeapon extends ObjectsInGame {

    private int x;
    private int y;
    private int XEndPosition;
    private int XStartPosition;
    private int marioVelocity;
    private int height;
    private int width;
    private int damage;
    private boolean isVilgaxDodged;

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

    public int getXEndPosition() {
        return XEndPosition;
    }

    public void setXEndPosition(int XEndPosition) {
        this.XEndPosition = XEndPosition;
    }

    public int getXStartPosition() {
        return XStartPosition;
    }

    public void setXStartPosition(int XStartPosition) {
        this.XStartPosition = XStartPosition;
    }

    public int getMarioVelocity() {
        return marioVelocity;
    }

    public void setMarioVelocity(int marioVelocity) {
        this.marioVelocity = marioVelocity;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isVilgaxDodged() {
        return isVilgaxDodged;
    }

    public void setVilgaxDodged(boolean vilgaxDodged) {
        isVilgaxDodged = vilgaxDodged;
    }
}
