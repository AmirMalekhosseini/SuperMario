package Model;

import Graphic.BossFightScreenSection;
import Graphic.LevelOneSectionOneScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BossFightSectionTime extends SectionsTime{

    javax.swing.Timer timer;
    private int sectionTime;

    // ToDo: create  coolDown fields for everything in this section

    public BossFightSectionTime(BossFightScreenSection bossFightScreenSection) {

        sectionTime = 50;
        timer=new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!bossFightScreenSection.getGameData().isGamePause && !bossFightScreenSection.getGameData().isGameFinish) {
                    sectionTime--;
                    bossFightScreenSection.thisSectionTimeLabel.setText("Time: "+ sectionTime);
                }
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
