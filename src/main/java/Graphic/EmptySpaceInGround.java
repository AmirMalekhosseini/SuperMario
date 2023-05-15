package Graphic;

import javax.swing.*;
import java.awt.*;

public class EmptySpaceInGround extends ObjectsInGame {

    private int x;
    private int y;
    private int width = 150;
    private int height = 120;

    EmptySpaceInGround(int x, int y) {

        this.setBackground(new Color(51, 153, 255));
        this.setSize(width, height);
        this.x = x;
        this.y = y;
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
