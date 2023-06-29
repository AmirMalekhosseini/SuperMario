package Model;

import Graphic.GameScreenFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer {

    GameData gameData;
    javax.swing.Timer timer;
    private int sectionTime = 50;

    public GameTimer(GameData gameData) {

        this.gameData = gameData;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!gameData.isGamePause && !gameData.isGameFinish) {
                    sectionTime--;
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