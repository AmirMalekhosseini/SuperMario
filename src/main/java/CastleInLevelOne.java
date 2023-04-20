import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CastleInLevelOne extends JLabel {

    private BufferedImage castleImage;
    private int x;
    private int y;
    private int width = 500;
    private int height = 850;

    public CastleInLevelOne(int x, int y) {
        this.setSize(width, height);

        try {
            String pathBackground = "Castle.png";
            File fileBackground = new File(pathBackground);
            castleImage = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.x = x;
        this.y = y;
    }

    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.drawImage(castleImage, 0, -5, null);
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
