package View.Button;

import MyProject.MyProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class RefreshButton extends JButton {

    private final BufferedImage background;

    public RefreshButton(int x, int y) {

        background = MyProjectData.getProjectData().getRefreshImage();
        setBounds(x, y, 50, 50);
        setFocusable(false);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, 50, 50, null);
    }

}
