package Model;

import Graphic.LevelTwoSectionOneScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelTwoSectionOneTime {

    javax.swing.Timer timer;
    private int sectionTime;

    public LevelTwoSectionOneTime() {

    }

    public LevelTwoSectionOneTime(LevelTwoSectionOneScreen levelTwoSectionOneScreen) {
        timer=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!levelTwoSectionOneScreen.getGameData().isGamePause() && levelTwoSectionOneScreen.getGameData().isGameFinish()) {
                    sectionTime--;
                    levelTwoSectionOneScreen.thisSectionTimeLabel.setText("Time: "+ sectionTime);
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
