package Model;

import Graphic.BossFightSectionScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BossFightSectionTime extends SectionsTime{

    javax.swing.Timer timer;
    private int sectionTime;

    // ToDo: create  coolDown fields for everything in this section

    public BossFightSectionTime(BossFightSectionScreen bossFightSectionScreen) {

        sectionTime = 50;
        timer=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                if (!bossFightSectionScreen.getGameData().isGamePause && !bossFightSectionScreen.getGameData().isGameFinish) {
//                    sectionTime--;
//                    bossFightSectionScreen.thisSectionTimeLabel.setText("Time: "+ sectionTime);
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
