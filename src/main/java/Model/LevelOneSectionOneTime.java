package Model;

import Graphic.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelOneSectionOneTime {

    javax.swing.Timer timer;

    LevelOneSectionOneScreen levelOneSectionOneScreen;
    private int sectionTime;

    public LevelOneSectionOneTime(LevelOneSectionOneScreen levelOneSectionOneScreen) {
        this.levelOneSectionOneScreen = levelOneSectionOneScreen;
        sectionTime = 50;
        timer=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!levelOneSectionOneScreen.getGameData().isGamePause && !levelOneSectionOneScreen.getGameData().isGameFinish) {
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
