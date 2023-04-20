import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelOneSectionTwoTime {

    javax.swing.Timer timer;

    LevelOneSectionOneScreen levelOneSectionOneScreen;
    LevelOneSectionTwoScreen levelOneSectionTwoScreen;
    private int sectionTime = 1;

    LevelOneSectionTwoTime(LevelOneSectionTwoScreen levelOneSectionTwoScreen, LevelOneSectionOneScreen levelOneSectionOneScreen) {
        this.levelOneSectionTwoScreen = levelOneSectionTwoScreen;
        this.levelOneSectionOneScreen = levelOneSectionOneScreen;
        timer=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!levelOneSectionTwoScreen.gameData.isGamePause && !levelOneSectionTwoScreen.gameData.isGameFinish) {
                    sectionTime--;
                    levelOneSectionTwoScreen.thisSectionTimeLabel.setText("Time: "+ sectionTime);
                }
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    public int getSectionTime() {
        return sectionTime;
    }

    public void setSectionTime(int sectionTime) {
        this.sectionTime = sectionTime;
    }
}
