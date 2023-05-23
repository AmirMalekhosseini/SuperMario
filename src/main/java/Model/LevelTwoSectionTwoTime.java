package Model;

import Graphic.LevelTwoSectionTwoScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LevelTwoSectionTwoTime {

    javax.swing.Timer timer;
    private int sectionTime;

    public LevelTwoSectionTwoTime() {

    }

    public LevelTwoSectionTwoTime(LevelTwoSectionTwoScreen levelTwoSectionTwoScreen) {
        timer=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!levelTwoSectionTwoScreen.getGameData().isGamePause() && !levelTwoSectionTwoScreen.getGameData().isGameFinish()) {
                    sectionTime--;
                    levelTwoSectionTwoScreen.thisSectionTimeLabel.setText("Time: "+ sectionTime);
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
