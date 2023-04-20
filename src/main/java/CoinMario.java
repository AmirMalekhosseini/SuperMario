import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CoinMario extends Mario {

    private BufferedImage run_1;
    private BufferedImage run_2;
    private BufferedImage run_3;
    private BufferedImage jump;
    private BufferedImage stand;
    private BufferedImage run_1_Flipped;
    private BufferedImage run_2_Flipped;
    private BufferedImage run_3_Flipped;
    private BufferedImage jump_Flipped;
    private BufferedImage stand_Flipped;

    private int x;
    private int y;
    private int width = 70;
    private int height = 120;

    private double velocityY;
    private double velocityX;

    CoinMario(int x, int y) {

        this.setSize(this.width, this.height);

        try {
            String pathBackground = "mario/YellowMario_Coin/run_1_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            run_1 = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "mario/YellowMario_Coin/run_2_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            run_2 = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "mario/YellowMario_Coin/run_3_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            run_3 = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "mario/YellowMario_Coin/stand_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            stand = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "mario/YellowMario_Coin/jump_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            jump = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            String pathBackground = "MarioFilliped/YellowMario_Coin/run_1_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            run_1_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "MarioFilliped/YellowMario_Coin/run_2_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            run_2_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "MarioFilliped/YellowMario_Coin/run_3_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            run_3_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "MarioFilliped/YellowMario_Coin/stand_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            stand_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "MarioFilliped/YellowMario_Coin/jump_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            jump_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.x = x;
        this.y = y;

    }


    public void paint(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        if (isMarioRight()) {
            graphics2D.drawImage(run_3, -0, -5, null);
        } else if (isMarioLeft()) {
            graphics2D.drawImage(run_3_Flipped, -0, -5, null);
        } else {
            graphics2D.drawImage(stand, -0, -5, null);
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

    @Override
    public double getVelocityY() {
        return velocityY;
    }

    @Override
    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    @Override
    public double getVelocityX() {
        return velocityX;
    }

    @Override
    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

}
