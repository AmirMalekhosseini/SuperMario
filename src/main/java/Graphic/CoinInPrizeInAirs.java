package Graphic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CoinInPrizeInAirs extends Coin{


    Timer timerForMovingTheCoin;
    private int secondCounter = 0;
    private BufferedImage background;
    private int x;
    private int y;
    private int width = 40;
    private int height = 40;
    private int velocity = -5;

    CoinInPrizeInAirs(int xx, int yy) {

        this.setSize(width, height);

        try {
            String pathBackground = "Coin.png";
            File fileBackground = new File(pathBackground);
            background = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.x = xx;
        this.y = yy;

        timerForMovingTheCoin=new Timer(1, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                secondCounter++;
                if (secondCounter == 10) {
                    y = y - velocity;
                    if (y <= 695) {// Coin should go up
                        velocity = -velocity;
                    } else if (y >= 800) {
                        velocity = -velocity;
                    }
                    secondCounter = 0;
                }

            }
        });

        timerForMovingTheCoin.setRepeats(false);
        timerForMovingTheCoin.start();
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
