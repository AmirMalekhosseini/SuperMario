package Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyProjectData {

    protected ImageIcon gameIcon;
    protected ImageIcon gameMenuImage;
    protected ImageIcon normalMarioImage;
    protected ImageIcon runnerMarioImage;
    protected ImageIcon jumperMarioImage;
    protected ImageIcon shooterMarioImage;
    protected ImageIcon coinMarioImage;

    protected BufferedImage normalMario_Run_1;
    protected BufferedImage normalMario_Run_1_Flipped;
    protected BufferedImage normalMario_Run_2;
    protected BufferedImage normalMario_Run_2_Flipped;
    protected BufferedImage normalMario_Run_3;
    protected BufferedImage normalMario_Run_3_Flipped;
    protected BufferedImage normalMario_jump;
    protected BufferedImage normalMario_jump_Flipped;
    protected BufferedImage normalMario_Stand;
    protected BufferedImage normalMario_Stand_Flipped;

    protected BufferedImage runnerMario_Run_1;
    protected BufferedImage runnerMario_Run_1_Flipped;
    protected BufferedImage runnerMario_Run_2;
    protected BufferedImage runnerMario_Run_2_Flipped;
    protected BufferedImage runnerMario_Run_3;
    protected BufferedImage runnerMario_Run_3_Flipped;
    protected BufferedImage runnerMario_jump;
    protected BufferedImage runnerMario_jump_Flipped;
    protected BufferedImage runnerMario_Stand;
    protected BufferedImage runnerMario_Stand_Flipped;

    protected BufferedImage jumperMario_Run_1;
    protected BufferedImage jumperMario_Run_1_Flipped;
    protected BufferedImage jumperMario_Run_2;
    protected BufferedImage jumperMario_Run_2_Flipped;
    protected BufferedImage jumperMario_Run_3;
    protected BufferedImage jumperMario_Run_3_Flipped;
    protected BufferedImage jumperMario_jump;
    protected BufferedImage jumperMario_jump_Flipped;
    protected BufferedImage jumperMario_Stand;
    protected BufferedImage jumperMario_Stand_Flipped;

    protected BufferedImage shooterMario_Run_1;
    protected BufferedImage shooterMario_Run_1_Flipped;
    protected BufferedImage shooterMario_Run_2;
    protected BufferedImage shooterMario_Run_2_Flipped;
    protected BufferedImage shooterMario_Run_3;
    protected BufferedImage shooterMario_Run_3_Flipped;
    protected BufferedImage shooterMario_jump;
    protected BufferedImage shooterMario_jump_Flipped;
    protected BufferedImage shooterMario_Stand;
    protected BufferedImage shooterMario_Stand_Flipped;

    protected BufferedImage coinMario_Run_1;
    protected BufferedImage coinMario_Run_1_Flipped;
    protected BufferedImage coinMario_Run_2;
    protected BufferedImage coinMario_Run_2_Flipped;
    protected BufferedImage coinMario_Run_3;
    protected BufferedImage coinMario_Run_3_Flipped;
    protected BufferedImage coinMario_jump;
    protected BufferedImage coinMario_jump_Flipped;
    protected BufferedImage coinMario_Stand;
    protected BufferedImage coinMario_Stand_Flipped;

    protected BufferedImage blockInAir;
    protected BufferedImage castleLevelOne;
    protected BufferedImage coin;
    protected BufferedImage coinForStore;
    protected BufferedImage coinInPrizeInAirs;
    protected BufferedImage pipe;
    protected BufferedImage pipeHorizontal;
    protected BufferedImage plant;
    protected BufferedImage activePrizeInAir;
    protected BufferedImage inActivePrizeInAir;
    protected BufferedImage userHeart;

    protected Font font10;
    protected Font font12;
    protected Font font15;
    protected Font font20;
    protected Font font22;
    protected Font font35;

    public MyProjectData() {

        importImages();
        importMarios();
        importFonts();
        importObjectsInGame();

    }

    public void importObjectsInGame() {

        try {
            String pathBackground = "BlockInAir.png";
            File fileBackground = new File(pathBackground);
            blockInAir = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "Castle.png";
            File fileBackground = new File(pathBackground);
            castleLevelOne = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "Coin.png";
            File fileBackground = new File(pathBackground);
            coin = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "CoinForStore.png";
            File fileBackground = new File(pathBackground);
            coinForStore = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "Coin.png";
            File fileBackground = new File(pathBackground);
            coinInPrizeInAirs = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "Pipe.png";
            File fileBackground = new File(pathBackground);
            pipe = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "PipeHorizontal.png";
            File fileBackground = new File(pathBackground);
            pipeHorizontal = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "Enemy/Plant.png";
            File fileBackground = new File(pathBackground);
            plant = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "PrizeInAir_Active.png";
            File fileBackground = new File(pathBackground);
            activePrizeInAir = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "PrizeInAir_InActive.png";
            File fileBackground = new File(pathBackground);
            inActivePrizeInAir = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "Heart.png";
            File fileBackground = new File(pathBackground);
            userHeart = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void importImages() {

        gameIcon = new ImageIcon("GameIcon.jpeg");
        gameMenuImage = new ImageIcon("GameMenuImage.jpg");
        normalMarioImage = new ImageIcon("mario/Normal Mario/stand_Red_Normal.png");
        runnerMarioImage = new ImageIcon("mario/BlueMario_Runner/stand_Blue_Runner.png");
        jumperMarioImage = new ImageIcon("mario/GreenMario_Jumper/stand_Green_Jumper.png");
        shooterMarioImage = new ImageIcon("mario/BlackMario_Shooter/stand_Black_Shooter.png");
        coinMarioImage = new ImageIcon("mario/YellowMario_Coin/stand_Yellow_Coin.png");

    }

    public void importFonts() {

        font10 = new Font("Comic Sans MS", Font.PLAIN, 10);
        font12 = new Font("Comic Sans MS", Font.PLAIN, 12);
        font15 = new Font("Comic Sans MS", Font.PLAIN, 15);
        font20 = new Font("Comic Sans MS", Font.PLAIN, 20);
        font22 = new Font("Comic Sans MS", Font.PLAIN, 22);
        font35 = new Font("Comic Sans MS", Font.PLAIN, 35);

    }

    public void importMarios() {

        importNormalMario();
        importRunnerMario();
        importJumperMario();
        importShooterMario();
        importCoinMario();

    }

    public void importNormalMario() {
        try {
            String pathBackground = "mario/Normal Mario/run_1_Red_Normal.png";
            File fileBackground = new File(pathBackground);
            normalMario_Run_1 = ImageIO.read(fileBackground);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "mario/Normal Mario/run_2_Red_Normal.png";
            File fileBackground = new File(pathBackground);
            normalMario_Run_2 = ImageIO.read(fileBackground);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "mario/Normal Mario/run_3_Red_Normal.png";
            File fileBackground = new File(pathBackground);
            normalMario_Run_3 = ImageIO.read(fileBackground);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "mario/Normal Mario/stand_Red_Normal.png";
            File fileBackground = new File(pathBackground);
            normalMario_Stand = ImageIO.read(fileBackground);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "mario/Normal Mario/jump_Red_Normal.png";
            File fileBackground = new File(pathBackground);
            normalMario_jump = ImageIO.read(fileBackground);

        }
        catch (IOException e) {
            e.printStackTrace();
        }


        try {
            String pathBackground = "MarioFilliped/Normal Mario/run_1_Red_Normal.png";
            File fileBackground = new File(pathBackground);
            normalMario_Run_1_Flipped = ImageIO.read(fileBackground);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "MarioFilliped/Normal Mario/run_2_Red_Normal.png";
            File fileBackground = new File(pathBackground);
            normalMario_Run_2_Flipped = ImageIO.read(fileBackground);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "MarioFilliped/Normal Mario/run_3_Red_Normal.png";
            File fileBackground = new File(pathBackground);
            normalMario_Run_3_Flipped = ImageIO.read(fileBackground);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "MarioFilliped/Normal Mario/stand_Red_Normal.png";
            File fileBackground = new File(pathBackground);
            normalMario_Stand_Flipped = ImageIO.read(fileBackground);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "MarioFilliped/Normal Mario/jump_Red_Normal.png";
            File fileBackground = new File(pathBackground);
            normalMario_jump_Flipped = ImageIO.read(fileBackground);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importRunnerMario() {

        try {
            String pathBackground = "mario/BlueMario_Runner/run_1_Blue_Runner.png";
            File fileBackground = new File(pathBackground);
            runnerMario_Run_1 = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "mario/BlueMario_Runner/run_2_Blue_Runner.png";
            File fileBackground = new File(pathBackground);
            runnerMario_Run_2 = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "mario/BlueMario_Runner/run_3_Blue_Runner.png";
            File fileBackground = new File(pathBackground);
            runnerMario_Run_3 = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "mario/BlueMario_Runner/stand_Blue_Runner.png";
            File fileBackground = new File(pathBackground);
            runnerMario_Stand = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "mario/BlueMario_Runner/jump_Blue_Runner.png";
            File fileBackground = new File(pathBackground);
            runnerMario_jump = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "MarioFilliped/BlueMario_Runner/run_1_Blue_Runner.png";
            File fileBackground = new File(pathBackground);
            runnerMario_Run_1_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "MarioFilliped/BlueMario_Runner/run_2_Blue_Runner.png";
            File fileBackground = new File(pathBackground);
            runnerMario_Run_2_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "MarioFilliped/BlueMario_Runner/run_3_Blue_Runner.png";
            File fileBackground = new File(pathBackground);
            runnerMario_Run_3_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "MarioFilliped/BlueMario_Runner/stand_Blue_Runner.png";
            File fileBackground = new File(pathBackground);
            runnerMario_Stand_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "MarioFilliped/BlueMario_Runner/jump_Blue_Runner.png";
            File fileBackground = new File(pathBackground);
            runnerMario_jump_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void importJumperMario() {

        try {
            String pathBackground = "mario/GreenMario_Jumper/run_1_Green_Jumper.png";
            File fileBackground = new File(pathBackground);
            jumperMario_Run_1 = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "mario/GreenMario_Jumper/run_2_Green_Jumper.png";
            File fileBackground = new File(pathBackground);
            jumperMario_Run_2 = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "mario/GreenMario_Jumper/run_3_Green_Jumper.png";
            File fileBackground = new File(pathBackground);
            jumperMario_Run_3 = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "mario/GreenMario_Jumper/stand_Green_Jumper.png";
            File fileBackground = new File(pathBackground);
            jumperMario_Stand = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "mario/GreenMario_Jumper/jump_Green_Jumper.png";
            File fileBackground = new File(pathBackground);
            jumperMario_jump = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            String pathBackground = "MarioFilliped/GreenMario_Jumper/run_1_Green_Jumper.png";
            File fileBackground = new File(pathBackground);
            jumperMario_Run_1_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "MarioFilliped/GreenMario_Jumper/run_2_Green_Jumper.png";
            File fileBackground = new File(pathBackground);
            jumperMario_Run_2_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "MarioFilliped/GreenMario_Jumper/run_3_Green_Jumper.png";
            File fileBackground = new File(pathBackground);
            jumperMario_Run_3_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "MarioFilliped/GreenMario_Jumper/stand_Green_Jumper.png";
            File fileBackground = new File(pathBackground);
            jumperMario_Stand_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "MarioFilliped/GreenMario_Jumper/jump_Green_Jumper.png";
            File fileBackground = new File(pathBackground);
            jumperMario_jump_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void importShooterMario() {

        try {
            String pathBackground = "mario/BlackMario_Shooter/run_1_Black_Shooter.png";
            File fileBackground = new File(pathBackground);
            shooterMario_Run_1 = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "mario/BlackMario_Shooter/run_2_Black_Shooter.png";
            File fileBackground = new File(pathBackground);
            shooterMario_Run_2 = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "mario/BlackMario_Shooter/run_3_Black_Shooter.png";
            File fileBackground = new File(pathBackground);
            shooterMario_Run_3 = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "mario/BlackMario_Shooter/stand_Black_Shooter.png";
            File fileBackground = new File(pathBackground);
            shooterMario_Stand = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "mario/BlackMario_Shooter/jump_Black_Shooter.png";
            File fileBackground = new File(pathBackground);
            shooterMario_jump = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            String pathBackground = "MarioFilliped/BlackMario_Shooter/run_1_Black_Shooter.png";
            File fileBackground = new File(pathBackground);
            shooterMario_Run_1_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "MarioFilliped/BlackMario_Shooter/run_2_Black_Shooter.png";
            File fileBackground = new File(pathBackground);
            shooterMario_Run_2_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "MarioFilliped/BlackMario_Shooter/run_3_Black_Shooter.png";
            File fileBackground = new File(pathBackground);
            shooterMario_Run_3_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "MarioFilliped/BlackMario_Shooter/stand_Black_Shooter.png";
            File fileBackground = new File(pathBackground);
            shooterMario_Stand_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "MarioFilliped/BlackMario_Shooter/jump_Black_Shooter.png";
            File fileBackground = new File(pathBackground);
            shooterMario_jump_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void importCoinMario() {

        try {
            String pathBackground = "mario/YellowMario_Coin/run_1_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            coinMario_Run_1 = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "mario/YellowMario_Coin/run_2_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            coinMario_Run_2 = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "mario/YellowMario_Coin/run_3_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            coinMario_Run_3 = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "mario/YellowMario_Coin/stand_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            coinMario_Stand = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "mario/YellowMario_Coin/jump_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            coinMario_jump = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            String pathBackground = "MarioFilliped/YellowMario_Coin/run_1_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            coinMario_Run_1_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "MarioFilliped/YellowMario_Coin/run_2_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            coinMario_Run_2_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String pathBackground = "MarioFilliped/YellowMario_Coin/run_3_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            coinMario_Run_3_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "MarioFilliped/YellowMario_Coin/stand_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            coinMario_Stand_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "MarioFilliped/YellowMario_Coin/jump_Yellow_Coin.png";
            File fileBackground = new File(pathBackground);
            coinMario_jump_Flipped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ImageIcon getGameIcon() {
        return gameIcon;
    }

    public ImageIcon getGameMenuImage() {
        return gameMenuImage;
    }

    public ImageIcon getNormalMarioImage() {
        return normalMarioImage;
    }

    public ImageIcon getRunnerMarioImage() {
        return runnerMarioImage;
    }

    public ImageIcon getJumperMarioImage() {
        return jumperMarioImage;
    }

    public ImageIcon getShooterMarioImage() {
        return shooterMarioImage;
    }

    public ImageIcon getCoinMarioImage() {
        return coinMarioImage;
    }

    public Font getFont10() {
        return font10;
    }

    public Font getFont12() {
        return font12;
    }

    public Font getFont15() {
        return font15;
    }

    public Font getFont20() {
        return font20;
    }

    public Font getFont22() {
        return font22;
    }

    public Font getFont35() {
        return font35;
    }

    public BufferedImage getNormalMario_Run_1() {
        return normalMario_Run_1;
    }

    public BufferedImage getNormalMario_Run_1_Flipped() {
        return normalMario_Run_1_Flipped;
    }

    public BufferedImage getNormalMario_Run_2() {
        return normalMario_Run_2;
    }

    public BufferedImage getNormalMario_Run_2_Flipped() {
        return normalMario_Run_2_Flipped;
    }

    public BufferedImage getNormalMario_Run_3() {
        return normalMario_Run_3;
    }

    public BufferedImage getNormalMario_Run_3_Flipped() {
        return normalMario_Run_3_Flipped;
    }

    public BufferedImage getNormalMario_jump() {
        return normalMario_jump;
    }

    public BufferedImage getNormalMario_jump_Flipped() {
        return normalMario_jump_Flipped;
    }

    public BufferedImage getNormalMario_Stand() {
        return normalMario_Stand;
    }

    public BufferedImage getNormalMario_Stand_Flipped() {
        return normalMario_Stand_Flipped;
    }

    public BufferedImage getRunnerMario_Run_1() {
        return runnerMario_Run_1;
    }

    public BufferedImage getRunnerMario_Run_1_Flipped() {
        return runnerMario_Run_1_Flipped;
    }

    public BufferedImage getRunnerMario_Run_2() {
        return runnerMario_Run_2;
    }

    public BufferedImage getRunnerMario_Run_2_Flipped() {
        return runnerMario_Run_2_Flipped;
    }

    public BufferedImage getRunnerMario_Run_3() {
        return runnerMario_Run_3;
    }

    public BufferedImage getRunnerMario_Run_3_Flipped() {
        return runnerMario_Run_3_Flipped;
    }

    public BufferedImage getRunnerMario_jump() {
        return runnerMario_jump;
    }

    public BufferedImage getRunnerMario_jump_Flipped() {
        return runnerMario_jump_Flipped;
    }

    public BufferedImage getRunnerMario_Stand() {
        return runnerMario_Stand;
    }

    public BufferedImage getRunnerMario_Stand_Flipped() {
        return runnerMario_Stand_Flipped;
    }

    public BufferedImage getJumperMario_Run_1() {
        return jumperMario_Run_1;
    }

    public BufferedImage getJumperMario_Run_1_Flipped() {
        return jumperMario_Run_1_Flipped;
    }

    public BufferedImage getJumperMario_Run_2() {
        return jumperMario_Run_2;
    }

    public BufferedImage getJumperMario_Run_2_Flipped() {
        return jumperMario_Run_2_Flipped;
    }

    public BufferedImage getJumperMario_Run_3() {
        return jumperMario_Run_3;
    }

    public BufferedImage getJumperMario_Run_3_Flipped() {
        return jumperMario_Run_3_Flipped;
    }

    public BufferedImage getJumperMario_jump() {
        return jumperMario_jump;
    }

    public BufferedImage getJumperMario_jump_Flipped() {
        return jumperMario_jump_Flipped;
    }

    public BufferedImage getJumperMario_Stand() {
        return jumperMario_Stand;
    }

    public BufferedImage getJumperMario_Stand_Flipped() {
        return jumperMario_Stand_Flipped;
    }

    public BufferedImage getShooterMario_Run_1() {
        return shooterMario_Run_1;
    }

    public BufferedImage getShooterMario_Run_1_Flipped() {
        return shooterMario_Run_1_Flipped;
    }

    public BufferedImage getShooterMario_Run_2() {
        return shooterMario_Run_2;
    }

    public BufferedImage getShooterMario_Run_2_Flipped() {
        return shooterMario_Run_2_Flipped;
    }

    public BufferedImage getShooterMario_Run_3() {
        return shooterMario_Run_3;
    }

    public BufferedImage getShooterMario_Run_3_Flipped() {
        return shooterMario_Run_3_Flipped;
    }

    public BufferedImage getShooterMario_jump() {
        return shooterMario_jump;
    }

    public BufferedImage getShooterMario_jump_Flipped() {
        return shooterMario_jump_Flipped;
    }

    public BufferedImage getShooterMario_Stand() {
        return shooterMario_Stand;
    }

    public BufferedImage getShooterMario_Stand_Flipped() {
        return shooterMario_Stand_Flipped;
    }

    public BufferedImage getCoinMario_Run_1() {
        return coinMario_Run_1;
    }

    public BufferedImage getCoinMario_Run_1_Flipped() {
        return coinMario_Run_1_Flipped;
    }

    public BufferedImage getCoinMario_Run_2() {
        return coinMario_Run_2;
    }

    public BufferedImage getCoinMario_Run_2_Flipped() {
        return coinMario_Run_2_Flipped;
    }

    public BufferedImage getCoinMario_Run_3() {
        return coinMario_Run_3;
    }

    public BufferedImage getCoinMario_Run_3_Flipped() {
        return coinMario_Run_3_Flipped;
    }

    public BufferedImage getCoinMario_jump() {
        return coinMario_jump;
    }

    public BufferedImage getCoinMario_jump_Flipped() {
        return coinMario_jump_Flipped;
    }

    public BufferedImage getCoinMario_Stand() {
        return coinMario_Stand;
    }

    public BufferedImage getCoinMario_Stand_Flipped() {
        return coinMario_Stand_Flipped;
    }

    public BufferedImage getBlockInAir() {
        return blockInAir;
    }

    public BufferedImage getCastleLevelOne() {
        return castleLevelOne;
    }

    public BufferedImage getCoin() {
        return coin;
    }

    public BufferedImage getCoinForStore() {
        return coinForStore;
    }

    public BufferedImage getCoinInPrizeInAirs() {
        return coinInPrizeInAirs;
    }

    public BufferedImage getPipe() {
        return pipe;
    }

    public BufferedImage getPipeHorizontal() {
        return pipeHorizontal;
    }

    public BufferedImage getPlant() {
        return plant;
    }

    public BufferedImage getActivePrizeInAir() {
        return activePrizeInAir;
    }

    public BufferedImage getInActivePrizeInAir() {
        return inActivePrizeInAir;
    }

    public BufferedImage getUserHeart() {
        return userHeart;
    }

}