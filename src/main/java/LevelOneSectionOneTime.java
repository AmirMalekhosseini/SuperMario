import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelOneSectionOneTime {

    javax.swing.Timer timer;

    LevelOneSectionOneScreen levelOneSectionOneScreen;
    private int sectionTime;

    LevelOneSectionOneTime(LevelOneSectionOneScreen levelOneSectionOneScreen) {
        this.levelOneSectionOneScreen = levelOneSectionOneScreen;
        sectionTime = 100;
        timer=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!levelOneSectionOneScreen.gameData.isGamePause && !levelOneSectionOneScreen.gameData.isGameFinish) {
                    sectionTime--;
                    levelOneSectionOneScreen.thisSectionTimeLabel.setText("Time: "+ sectionTime);
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
