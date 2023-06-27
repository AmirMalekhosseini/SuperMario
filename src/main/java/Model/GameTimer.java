package Model;

import Graphic.GameScreenFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer {

    GameScreenFrame gameScreenFrame;
    GameData gameData;
    javax.swing.Timer timer;
    private int sectionTime;

    public GameTimer(GameScreenFrame gameScreenFrame, GameData gameData) {
        this.gameScreenFrame = gameScreenFrame;
        this.gameData = gameData;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!gameData.isGamePause && !gameData.isGameFinish) {
                    sectionTime--;
                }

            }
        });
    }

    public int getSectionTime() {
        return sectionTime;
    }

    public void setSectionTime(int sectionTime) {
        this.sectionTime = sectionTime;
    }
}
