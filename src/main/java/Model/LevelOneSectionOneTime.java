package Model;

import Graphic.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelOneSectionOneTime extends SectionsTime {

    javax.swing.Timer timer;
    private int sectionTime;

    // ToDo: create  coolDown fields for everything in this section

    public LevelOneSectionOneTime(LevelOneSectionOneScreen levelOneSectionOneScreen) {

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

    public LevelOneSectionOneTime() {

    }

    public int getSectionTime() {
        return sectionTime;
    }

    public void setSectionTime(int sectionTime) {
        this.sectionTime = sectionTime;
    }

}
