package Model;

import Graphic.LevelTwoSectionOneScreen;

public class LevelTwoSectionOneTime {

    javax.swing.Timer timer;
    LevelTwoSectionOneScreen levelTwoSectionOneScreen;
    private int sectionTime;

    public LevelTwoSectionOneTime() {

    }

    public LevelTwoSectionOneTime(LevelTwoSectionOneScreen levelTwoSectionOneScreen) {

        this.levelTwoSectionOneScreen = levelTwoSectionOneScreen;

    }

    public int getSectionTime() {
        return sectionTime;
    }

    public void setSectionTime(int sectionTime) {
        this.sectionTime = sectionTime;
    }
}
