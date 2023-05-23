package Graphic;

import Model.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Star extends ItemsInGame{


    private BufferedImage background;

    private int x;
    private int y;
    private int height = 50;
    private int width = 50;
    private int scoreItemAdds = 40;
    private boolean isItemAvailable;

    public Star(int x, int y) {

        this.setSize(width, height);

        background = MyProjectData.getProjectData().getStar();

        this.x = x;
        this.y = y;
    }

    public Star() {
    }

    public void paint(Graphics graphics) {
        if (!isItemCatch()) {
            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.drawImage(background, 0, -0, null);
        }

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
    public int getScoreItemAdds() {
        return scoreItemAdds;
    }

    @Override
    public void setScoreItemAdds(int scoreItemAdds) {
        this.scoreItemAdds = scoreItemAdds;
    }

    public boolean isItemAvailable() {
        return isItemAvailable;
    }

    public void setItemAvailable(boolean itemAvailable) {
        isItemAvailable = itemAvailable;
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
}
