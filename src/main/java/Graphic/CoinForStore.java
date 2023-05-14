package Graphic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CoinForStore extends JLabel {

    private BufferedImage background;
    private int x;
    private int y;
    private int width = 25;
    private int height = 25;

    CoinForStore(int x, int y) {

        this.setSize(width, height);

        try {
            String pathBackground = "CoinForStore.png";
            File fileBackground = new File(pathBackground);
            background = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.x = x;
        this.y = y;
    }

    public void paint(Graphics graphics) {
            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.drawImage(background, 0, -5, null);

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
