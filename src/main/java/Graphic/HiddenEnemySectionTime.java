package Graphic;

import Model.SectionsTime;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HiddenEnemySectionTime extends SectionsTime {

    javax.swing.Timer timer;
    private int sectionTime;

    public HiddenEnemySectionTime(HiddenEnemySectionScreen hiddenEnemySectionScreen) {

        sectionTime = 50;
        timer=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!hiddenEnemySectionScreen.getGameData().isGamePause && !hiddenEnemySectionScreen.getGameData().isGameFinish) {
                    sectionTime--;
                    hiddenEnemySectionScreen.thisSectionTimeLabel.setText("Time: "+ sectionTime);
                }
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    public HiddenEnemySectionTime() {

    }

    public int getSectionTime() {
        return sectionTime;
    }

    public void setSectionTime(int sectionTime) {
        this.sectionTime = sectionTime;
    }

}
