package Graphic;

import javax.swing.*;

public class GameScreenFrame extends JFrame {

    protected JPanel hiddenEnemyBackgroundPanel;
    protected JPanel hiddenCoinBackgroundPanel;
    protected JPanel levelOneGameBackgroundPanel;
    protected JPanel levelTwoGameBackgroundPanel;
    protected JPanel levelThreeGameBackgroundPanel;

    public GameScreenFrame(JPanel[] gamePanels) {
        hiddenEnemyBackgroundPanel = gamePanels[0];
        hiddenCoinBackgroundPanel = gamePanels[1];
        levelOneGameBackgroundPanel = gamePanels[2];
        levelTwoGameBackgroundPanel = gamePanels[3];
        levelThreeGameBackgroundPanel = gamePanels[4];
        init();
    }

    private void init() {
        ImageIcon gameIcon = new ImageIcon("GameIcon.jpeg");

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.requestFocus();
        this.setSize(1700, 1300);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setIconImage(gameIcon.getImage());

        this.add(hiddenEnemyBackgroundPanel);
        this.add(hiddenCoinBackgroundPanel);
        this.add(levelOneGameBackgroundPanel);
        this.add(levelTwoGameBackgroundPanel);
        this.add(levelThreeGameBackgroundPanel);

    }

}
