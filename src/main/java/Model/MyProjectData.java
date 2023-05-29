package Model;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyProjectData {

    private static MyProjectData projectData;

    protected ImageIcon gameIcon;
    protected ImageIcon gameMenuImage;
    protected ImageIcon normalMarioImage;
    protected ImageIcon runnerMarioImage;
    protected ImageIcon jumperMarioImage;
    protected ImageIcon shooterMarioImage;
    protected ImageIcon coinMarioImage;

    protected BufferedImage sword;
    protected BufferedImage fireBall;
    protected BufferedImage fireMario;
    protected BufferedImage fireMario_Mini;
    protected BufferedImage fireMario_Filliped;
    protected BufferedImage fireMario_Filliped_Mini;
    protected BufferedImage normalMario_Run_1;
    protected BufferedImage normalMario_Run_1_Flipped;
    protected BufferedImage normalMario_Run_2;
    protected BufferedImage normalMario_Run_2_Flipped;
    protected BufferedImage normalMario_Run_3;
    protected BufferedImage normalMario_Run_3_Mini;
    protected BufferedImage normalMario_Run_3_Flipped;
    protected BufferedImage normalMario_Run_3_Flipped_Mini;
    protected BufferedImage normalMario_jump;
    protected BufferedImage normalMario_jump_Flipped;
    protected BufferedImage normalMario_Stand;
    protected BufferedImage normalMario_Stand_Mini;
    protected BufferedImage normalMario_Stand_Flipped;
    protected BufferedImage normalMario_Stand_Flipped_Mini;

    protected BufferedImage runnerMario_Run_1;
    protected BufferedImage runnerMario_Run_1_Flipped;
    protected BufferedImage runnerMario_Run_2;
    protected BufferedImage runnerMario_Run_2_Flipped;
    protected BufferedImage runnerMario_Run_3;
    protected BufferedImage runnerMario_Run_3_Mini;
    protected BufferedImage runnerMario_Run_3_Flipped;
    protected BufferedImage runnerMario_Run_3_Flipped_Mini;
    protected BufferedImage runnerMario_jump;
    protected BufferedImage runnerMario_jump_Flipped;
    protected BufferedImage runnerMario_Stand;
    protected BufferedImage runnerMario_Stand_Mini;
    protected BufferedImage runnerMario_Stand_Flipped;
    protected BufferedImage runnerMario_Stand_Flipped_Mini;

    protected BufferedImage jumperMario_Run_1;
    protected BufferedImage jumperMario_Run_1_Flipped;
    protected BufferedImage jumperMario_Run_2;
    protected BufferedImage jumperMario_Run_2_Flipped;
    protected BufferedImage jumperMario_Run_3;
    protected BufferedImage jumperMario_Run_3_Mini;
    protected BufferedImage jumperMario_Run_3_Flipped;
    protected BufferedImage jumperMario_Run_3_Flipped_Mini;
    protected BufferedImage jumperMario_jump;
    protected BufferedImage jumperMario_jump_Flipped;
    protected BufferedImage jumperMario_Stand;
    protected BufferedImage jumperMario_Stand_Mini;
    protected BufferedImage jumperMario_Stand_Flipped;
    protected BufferedImage jumperMario_Stand_Flipped_Mini;

    protected BufferedImage shooterMario_Run_1;
    protected BufferedImage shooterMario_Run_1_Flipped;
    protected BufferedImage shooterMario_Run_2;
    protected BufferedImage shooterMario_Run_2_Flipped;
    protected BufferedImage shooterMario_Run_3;
    protected BufferedImage shooterMario_Run_3_Mini;
    protected BufferedImage shooterMario_Run_3_Flipped;
    protected BufferedImage shooterMario_Run_3_Flipped_Mini;
    protected BufferedImage shooterMario_jump;
    protected BufferedImage shooterMario_jump_Flipped;
    protected BufferedImage shooterMario_Stand;
    protected BufferedImage shooterMario_Stand_Mini;
    protected BufferedImage shooterMario_Stand_Flipped;
    protected BufferedImage shooterMario_Stand_Flipped_Mini;

    protected BufferedImage coinMario_Run_1;
    protected BufferedImage coinMario_Run_1_Flipped;
    protected BufferedImage coinMario_Run_2;
    protected BufferedImage coinMario_Run_2_Flipped;
    protected BufferedImage coinMario_Run_3;
    protected BufferedImage coinMario_Run_3_Mini;
    protected BufferedImage coinMario_Run_3_Flipped;
    protected BufferedImage coinMario_Run_3_Flipped_Mini;
    protected BufferedImage coinMario_jump;
    protected BufferedImage coinMario_jump_Flipped;
    protected BufferedImage coinMario_Stand;
    protected BufferedImage coinMario_Stand_Mini;
    protected BufferedImage coinMario_Stand_Flipped;
    protected BufferedImage coinMario_Stand_Flipped_Mini;

    protected BufferedImage blockInAir;
    protected BufferedImage emptyBlockInAir;
    protected BufferedImage castleLevelOne;
    protected BufferedImage coin;
    protected BufferedImage mushroom;
    protected BufferedImage star;
    protected BufferedImage flowerItem;
    protected BufferedImage coinForStore;
    protected BufferedImage pipe;
    protected BufferedImage pipeHorizontal;
    protected BufferedImage plant;
    protected BufferedImage goompa;
    protected BufferedImage goompa_Filliped;
    protected BufferedImage nukeBird;
    protected BufferedImage nukeBird_Filliped;
    protected BufferedImage birdBomb;
    protected BufferedImage turtle;
    protected BufferedImage turtle_Filliped;
    protected BufferedImage spiny;
    protected BufferedImage spiny_Filliped;
    protected BufferedImage activePrizeInAir;
    protected BufferedImage inActivePrizeInAir;
    protected BufferedImage userHeart;
    protected BufferedImage cannon;

    protected Font font10;
    protected Font font12;
    protected Font font15;
    protected Font font20;
    protected Font font22;
    protected Font font35;

    private MyProjectData() {

        importImages();
        importMarios();
        importWeapons();
        importFonts();
        importObjectsInGame();

    }

    public static MyProjectData getProjectData() {
        if (projectData == null) {
            projectData = new MyProjectData();
        }
        return projectData;
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
            String pathBackground = "EmptyBlockInAir.png";
            File fileBackground = new File(pathBackground);
            emptyBlockInAir = ImageIO.read(fileBackground);

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
            String pathBackground = "Item/Coin.png";
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
            String pathBackground = "Item/FlowerItem.png";
            File fileBackground = new File(pathBackground);
            flowerItem = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "Item/Mushroom.png";
            File fileBackground = new File(pathBackground);
            mushroom = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "Item/Star.png";
            File fileBackground = new File(pathBackground);
            star = ImageIO.read(fileBackground);

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
            String pathBackground = "Enemy/Goompa.png";
            File fileBackground = new File(pathBackground);
            goompa = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "Enemy/GoompaFilliped.png";
            File fileBackground = new File(pathBackground);
            goompa_Filliped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "Enemy/NukeBird.png";
            File fileBackground = new File(pathBackground);
            nukeBird = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "Enemy/NukeBirdFilliped.png";
            File fileBackground = new File(pathBackground);
            nukeBird_Filliped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "Enemy/Bomb.png";
            File fileBackground = new File(pathBackground);
            birdBomb = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "Enemy/Turtle.png";
            File fileBackground = new File(pathBackground);
            turtle = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "Enemy/TurtleFilliped.png";
            File fileBackground = new File(pathBackground);
            turtle_Filliped = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "Enemy/Spiny.png";
            File fileBackground = new File(pathBackground);
            spiny = ImageIO.read(fileBackground);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "Enemy/SpinyFilliped.png";
            File fileBackground = new File(pathBackground);
            spiny_Filliped = ImageIO.read(fileBackground);

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

        try {
            String pathBackground = "Cannon.png";
            File fileBackground = new File(pathBackground);
            cannon = ImageIO.read(fileBackground);

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
        importFireMario();

    }

    public void importWeapons() {

        try {
            String pathBackground = "MarioWeapon/Fireball.png";
            File fileBackground = new File(pathBackground);
            fireBall = ImageIO.read(fileBackground);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "MarioWeapon/Sword.png";
            File fileBackground = new File(pathBackground);
            sword = ImageIO.read(fileBackground);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void importFireMario() {

        try {
            String pathBackground = "mario/FireMario/FireMario.png";
            File fileBackground = new File(pathBackground);
            fireMario = ImageIO.read(fileBackground);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "mario/FireMario/FireMario_Mini.png";
            File fileBackground = new File(pathBackground);
            fireMario_Mini = ImageIO.read(fileBackground);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "MarioFilliped/FireMario/FireMario.png";
            File fileBackground = new File(pathBackground);
            fireMario_Filliped = ImageIO.read(fileBackground);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        try {
            String pathBackground = "MarioFilliped/FireMario/FireMario_Mini.png";
            File fileBackground = new File(pathBackground);
            fireMario_Filliped_Mini = ImageIO.read(fileBackground);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

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
            String pathBackground = "mario/Normal Mario/run_3_Red_Normal_Mini.png";
            File fileBackground = new File(pathBackground);
            normalMario_Run_3_Mini = ImageIO.read(fileBackground);

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
            String pathBackground = "mario/Normal Mario/stand_Red_Normal_Mini.png";
            File fileBackground = new File(pathBackground);
            normalMario_Stand_Mini = ImageIO.read(fileBackground);

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
            String pathBackground = "MarioFilliped/Normal Mario/run_3_Red_Normal_Mini.png";
            File fileBackground = new File(pathBackground);
            normalMario_Run_3_Flipped_Mini = ImageIO.read(fileBackground);

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
            String pathBackground = "MarioFilliped/Normal Mario/stand_Red_Normal_Mini.png";
            File fileBackground = new File(pathBackground);
            normalMario_Stand_Flipped_Mini = ImageIO.read(fileBackground);

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
            String pathBackground = "mario/BlueMario_Runner/run_3_Blue_Runner_Mini.png";
            File fileBackground = new File(pathBackground);
            runnerMario_Run_3_Mini = ImageIO.read(fileBackground);

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
            String pathBackground = "mario/BlueMario_Runner/stand_Blue_Runner_Mini.png";
            File fileBackground = new File(pathBackground);
            runnerMario_Stand_Mini = ImageIO.read(fileBackground);

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
            String pathBackground = "MarioFilliped/BlueMario_Runner/run_3_Blue_Runner_Mini.png";
            File fileBackground = new File(pathBackground);
            runnerMario_Run_3_Flipped_Mini = ImageIO.read(fileBackground);

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
            String pathBackground = "MarioFilliped/BlueMario_Runner/stand_Blue_Runner_Mini.png";
            File fileBackground = new File(pathBackground);
            runnerMario_Stand_Flipped_Mini = ImageIO.read(fileBackground);

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
            String pathBackground = "mario/GreenMario_Jumper/run_3_Green_Jumper_Mini.png";
            File fileBackground = new File(pathBackground);
            jumperMario_Run_3_Mini = ImageIO.read(fileBackground);

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
            String pathBackground = "mario/GreenMario_Jumper/stand_Green_Jumper_Mini.png";
            File fileBackground = new File(pathBackground);
            jumperMario_Stand_Mini = ImageIO.read(fileBackground);

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
            String pathBackground = "MarioFilliped/GreenMario_Jumper/run_3_Green_Jumper_Mini.png";
            File fileBackground = new File(pathBackground);
            jumperMario_Run_3_Flipped_Mini = ImageIO.read(fileBackground);

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
            String pathBackground = "MarioFilliped/GreenMario_Jumper/stand_Green_Jumper_Mini.png";
            File fileBackground = new File(pathBackground);
            jumperMario_Stand_Flipped_Mini = ImageIO.read(fileBackground);

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
            String pathBackground = "mario/BlackMario_Shooter/run_3_Black_Shooter_Mini.png";
            File fileBackground = new File(pathBackground);
            shooterMario_Run_3_Mini = ImageIO.read(fileBackground);

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
            String pathBackground = "mario/BlackMario_Shooter/stand_Black_Shooter_Mini.png";
            File fileBackground = new File(pathBackground);
            shooterMario_Stand_Mini = ImageIO.read(fileBackground);

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
            String pathBackground = "MarioFilliped/BlackMario_Shooter/run_3_Black_Shooter_Mini.png";
            File fileBackground = new File(pathBackground);
            shooterMario_Run_3_Flipped_Mini = ImageIO.read(fileBackground);

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
            String pathBackground = "MarioFilliped/BlackMario_Shooter/stand_Black_Shooter_Mini.png";
            File fileBackground = new File(pathBackground);
            shooterMario_Stand_Flipped_Mini = ImageIO.read(fileBackground);

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
            String pathBackground = "mario/YellowMario_Coin/run_3_Yellow_Coin_Mini.png";
            File fileBackground = new File(pathBackground);
            coinMario_Run_3_Mini = ImageIO.read(fileBackground);

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
            String pathBackground = "mario/YellowMario_Coin/stand_Yellow_Coin_Mini.png";
            File fileBackground = new File(pathBackground);
            coinMario_Stand_Mini = ImageIO.read(fileBackground);

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
            String pathBackground = "MarioFilliped/YellowMario_Coin/run_3_Yellow_Coin_Mini.png";
            File fileBackground = new File(pathBackground);
            coinMario_Run_3_Flipped_Mini = ImageIO.read(fileBackground);

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
            String pathBackground = "MarioFilliped/YellowMario_Coin/stand_Yellow_Coin_Mini.png";
            File fileBackground = new File(pathBackground);
            coinMario_Stand_Flipped_Mini = ImageIO.read(fileBackground);

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

    public BufferedImage getEmptyBlockInAir() {
        return emptyBlockInAir;
    }

    public BufferedImage getCastleLevelOne() {
        return castleLevelOne;
    }
    public BufferedImage getCoin() {
        return coin;
    }
    public BufferedImage getMushroom() {
        return mushroom;
    }
    public BufferedImage getStar() {
        return star;
    }
    public BufferedImage getFlowerItem() {
        return flowerItem;
    }
    public BufferedImage getCoinForStore() {
        return coinForStore;
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
    public BufferedImage getGoompa() {
        return goompa;
    }
    public BufferedImage getNukeBird() {
        return nukeBird;
    }
    public BufferedImage getBirdBomb() {
        return birdBomb;
    }
    public BufferedImage getTurtle() {
        return turtle;
    }
    public BufferedImage getSpiny() {
        return spiny;
    }

    public BufferedImage getGoompa_Filliped() {
        return goompa_Filliped;
    }

    public BufferedImage getNukeBird_Filliped() {
        return nukeBird_Filliped;
    }

    public BufferedImage getTurtle_Filliped() {
        return turtle_Filliped;
    }

    public BufferedImage getSpiny_Filliped() {
        return spiny_Filliped;
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
    public BufferedImage getCannon() {
        return cannon;
    }

    public BufferedImage getNormalMario_Run_3_Mini() {
        return normalMario_Run_3_Mini;
    }

    public BufferedImage getNormalMario_Run_3_Flipped_Mini() {
        return normalMario_Run_3_Flipped_Mini;
    }

    public BufferedImage getNormalMario_Stand_Mini() {
        return normalMario_Stand_Mini;
    }

    public BufferedImage getNormalMario_Stand_Flipped_Mini() {
        return normalMario_Stand_Flipped_Mini;
    }

    public BufferedImage getRunnerMario_Run_3_Mini() {
        return runnerMario_Run_3_Mini;
    }

    public BufferedImage getRunnerMario_Run_3_Flipped_Mini() {
        return runnerMario_Run_3_Flipped_Mini;
    }

    public BufferedImage getRunnerMario_Stand_Mini() {
        return runnerMario_Stand_Mini;
    }

    public BufferedImage getRunnerMario_Stand_Flipped_Mini() {
        return runnerMario_Stand_Flipped_Mini;
    }

    public BufferedImage getJumperMario_Run_3_Mini() {
        return jumperMario_Run_3_Mini;
    }

    public BufferedImage getJumperMario_Run_3_Flipped_Mini() {
        return jumperMario_Run_3_Flipped_Mini;
    }

    public BufferedImage getJumperMario_Stand_Mini() {
        return jumperMario_Stand_Mini;
    }

    public BufferedImage getJumperMario_Stand_Flipped_Mini() {
        return jumperMario_Stand_Flipped_Mini;
    }

    public BufferedImage getShooterMario_Run_3_Mini() {
        return shooterMario_Run_3_Mini;
    }

    public BufferedImage getShooterMario_Run_3_Flipped_Mini() {
        return shooterMario_Run_3_Flipped_Mini;
    }

    public BufferedImage getShooterMario_Stand_Mini() {
        return shooterMario_Stand_Mini;
    }

    public BufferedImage getShooterMario_Stand_Flipped_Mini() {
        return shooterMario_Stand_Flipped_Mini;
    }

    public BufferedImage getCoinMario_Run_3_Mini() {
        return coinMario_Run_3_Mini;
    }

    public BufferedImage getCoinMario_Run_3_Flipped_Mini() {
        return coinMario_Run_3_Flipped_Mini;
    }

    public BufferedImage getCoinMario_Stand_Mini() {
        return coinMario_Stand_Mini;
    }

    public BufferedImage getCoinMario_Stand_Flipped_Mini() {
        return coinMario_Stand_Flipped_Mini;
    }

    public BufferedImage getFireMario() {
        return fireMario;
    }

    public BufferedImage getFireMario_Mini() {
        return fireMario_Mini;
    }

    public BufferedImage getFireMario_Filliped() {
        return fireMario_Filliped;
    }

    public BufferedImage getFireMario_Filliped_Mini() {
        return fireMario_Filliped_Mini;
    }

    public BufferedImage getFireBall() {
        return fireBall;
    }

    public BufferedImage getSword() {
        return sword;
    }
}
