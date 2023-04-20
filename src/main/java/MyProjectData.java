import javax.swing.*;
import java.awt.*;

public class MyProjectData {

    public static ImageIcon gameIcon;
    public static ImageIcon gameMenuImage;
    public static ImageIcon normalMarioImage;
    public static ImageIcon runnerMarioImage;
    public static ImageIcon jumperMarioImage;
    public static ImageIcon shooterMarioImage;
    public static ImageIcon coinMarioImage;

    public static Font font10;
    public static Font font12;
    public static Font font15;
    public static Font font20;
    public static Font font22;
    public static Font font35;

    public MyProjectData() {

        gameIcon = new ImageIcon("GameIcon.jpeg");
        gameMenuImage = new ImageIcon("GameMenuImage.jpg");
        normalMarioImage = new ImageIcon("mario/Normal Mario/stand_Red_Normal.png");
        runnerMarioImage = new ImageIcon("mario/BlueMario_Runner/stand_Blue_Runner.png");
        jumperMarioImage = new ImageIcon("mario/GreenMario_Jumper/stand_Green_Jumper.png");
        shooterMarioImage = new ImageIcon("mario/BlackMario_Shooter/stand_Black_Shooter.png");
        coinMarioImage = new ImageIcon("mario/YellowMario_Coin/stand_Yellow_Coin.png");

        font10 = new Font("Comic Sans MS", Font.PLAIN, 10);
        font12 = new Font("Comic Sans MS", Font.PLAIN, 12);
        font15 = new Font("Comic Sans MS", Font.PLAIN, 15);
        font20 = new Font("Comic Sans MS", Font.PLAIN, 20);
        font22 = new Font("Comic Sans MS", Font.PLAIN, 22);
        font35 = new Font("Comic Sans MS", Font.PLAIN, 35);

    }

}
