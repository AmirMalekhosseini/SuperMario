package Graphic;

import Model.MyProjectData;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Coin extends ItemsInGame {


    private BufferedImage background;

    private int x;
    private int y;
    private int scoreItemAdds = 10;

    public Coin(int x, int y) {

        this.setSize(super.getWidth(), super.getHeight());

        background = MyProjectData.getProjectData().getCoin();

        this.x = x;
        this.y = y;
    }

    public Coin() {
    }

    @Override
    public void move() {

    }

    public void paint(Graphics graphics) {
        if (!isItemCatch()) {
            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.drawImage(background, 0, -5, null);
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
}
