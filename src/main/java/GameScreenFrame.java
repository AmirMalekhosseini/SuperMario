import javax.swing.*;

public class GameScreenFrame extends JFrame {

    GameData gameData;
    JPanel levelOneGameBackgroundPanel;
    LevelOneSectionOneScreen levelOneSectionOneScreen;
    IntersectMarioAndObjectsInSectionOne intersectMarioAndObjectsInSectionOne;
    IntersectMarioAndObjectsInSectionTwo intersectMarioAndObjectsInSectionTwo;
    LevelOneSectionTwoScreen levelOneSectionTwoScreen;
    MarioMover marioMover;
    GameLoop gameLoop;
    CalculateScore calculateScore;

    private int xLevelOneBackgroundPanel = 0;

    GameScreenFrame(GameData gameData) {
        this.gameData = gameData;
        ImageIcon gameIcon = new ImageIcon("GameIcon.jpeg");
        levelOneSectionOneScreen = new LevelOneSectionOneScreen(gameData);
        intersectMarioAndObjectsInSectionOne = new IntersectMarioAndObjectsInSectionOne(this);
        levelOneSectionTwoScreen = new LevelOneSectionTwoScreen(gameData, levelOneSectionOneScreen);
        intersectMarioAndObjectsInSectionTwo = new IntersectMarioAndObjectsInSectionTwo(this);
        marioMover = new MarioMover(this);
        levelOneGameBackgroundPanel = new JPanel();
        gameLoop = new GameLoop(this);
        calculateScore = new CalculateScore(this);

        this.setSize(1700, 1300);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setIconImage(gameIcon.getImage());
        this.addKeyListener(marioMover);

        levelOneGameBackgroundPanel.setBounds(xLevelOneBackgroundPanel, 0, 14000, 1300);
        levelOneGameBackgroundPanel.setLayout(null);



        levelOneGameBackgroundPanel.add(levelOneSectionOneScreen);
        levelOneGameBackgroundPanel.add(levelOneSectionTwoScreen);
        this.add(levelOneGameBackgroundPanel);

    }

    public int getxLevelOneBackgroundPanel() {
        return xLevelOneBackgroundPanel;
    }

    public void setxLevelOneBackgroundPanel(int xLevelOneBackgroundPanel) {
        this.xLevelOneBackgroundPanel = xLevelOneBackgroundPanel;
    }

}
