package Model;

import Graphic.BossFightScreenSectionScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BossFightSectionTime extends SectionsTime{

    javax.swing.Timer timer;
    private int sectionTime;

    // ToDo: create  coolDown fields for everything in this section

    public BossFightSectionTime(BossFightScreenSectionScreen bossFightScreenSectionScreen) {

        sectionTime = 50;
        timer=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if (!bossFightScreenSectionScreen.getGameData().isGamePause && !bossFightScreenSectionScreen.getGameData().isGameFinish) {
//                    sectionTime--;
//                    bossFightScreenSectionScreen.thisSectionTimeLabel.setText("Time: "+ sectionTime);
//                }
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    public BossFightSectionTime() {

    }

    public int getSectionTime() {
        return sectionTime;
    }

    public void setSectionTime(int sectionTime) {
        this.sectionTime = sectionTime;
    }

}
