package View.Notification;

import MyProject.MyProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Notification extends JFrame {

    JPanel panel;
    JButton okButton;
    JLabel messageLabel;

    public Notification(String title, String message) {
        ImageIcon gameIcon = MyProjectData.getProjectData().getGameIcon();
        setTitle(title);
        setSize(500, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setIconImage(gameIcon.getImage());

        panel = new JPanel();
        panel.setBounds(0, 0, 500, 200);
        panel.setLayout(null);
        setContentPane(panel);

        okButton = new JButton("OK");
        okButton.setBounds(215, 120, 70, 35);
        okButton.setVisible(true);
        okButton.setForeground(Color.WHITE);
        okButton.setFocusable(false);
        okButton.setFont(MyProjectData.getProjectData().getFont10());
        okButton.setBackground(Color.BLACK);
        panel.add(okButton);

        messageLabel = new JLabel(message);
        messageLabel.setBounds(0, 0, panel.getWidth(), 100);
        messageLabel.setFont(MyProjectData.getProjectData().getFont15());
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(messageLabel);


    }


}

