package Graphic;

import Model.SectionsTime;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HiddenCoinSectionTime extends SectionsTime {

    javax.swing.Timer timer;
    private int sectionTime;

    public HiddenCoinSectionTime(HiddenCoinSectionScreen hiddenCoinSectionScreen) {

        sectionTime = 50;
        timer=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!hiddenCoinSectionScreen.getGameData().isGamePause && !hiddenCoinSectionScreen.getGameData().isGameFinish) {
                    sectionTime--;
                    hiddenCoinSectionScreen.thisSectionTimeLabel.setText("Time: "+ sectionTime);
                }
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    public HiddenCoinSectionTime() {

    }

    public int getSectionTime() {
        return sectionTime;
    }

    public void setSectionTime(int sectionTime) {
        this.sectionTime = sectionTime;
    }

}
