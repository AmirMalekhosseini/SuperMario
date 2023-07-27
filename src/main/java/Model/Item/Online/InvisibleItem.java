package Model.Item.Online;

import Model.Mario.Mario;
import MyProject.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class InvisibleItem extends OnlineItems {

    private BufferedImage background;

    private int x;
    private int y;

    private int height = 60;
    private int width = 60;

    public InvisibleItem(int x, int y) {

        this.setSize(width, height);

        background = MyProjectData.getProjectData().getInvisiblePotion();

        this.x = x;
        this.y = y;

    }

    public InvisibleItem() {

        this.setSize(width, height);

        background = MyProjectData.getProjectData().getHealPotion();

    }

    @Override
    public void action(Mario mario) {

    }

    @Override
    public void removeAction(Mario mario) {

    }

    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (!isItemCatch()) {
            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.drawImage(background, -0, -0,width,height, null);
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
}
