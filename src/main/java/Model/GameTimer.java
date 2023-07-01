package Model;

import Graphic.CoolDown;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameTimer {

    private static GameTimer gameTimer;
    private ArrayList<CoolDown> coolDownList = new ArrayList<>();
    public CoolDown vilgaxMove;
    public CoolDown fireBallAttack;
    public CoolDown grabAttack;
    public CoolDown jumpAttack;
    public CoolDown nukeAttack;
    public CoolDown marioShot;

    GameData gameData;
    javax.swing.Timer timer;
    private int sectionTime = 50;

    private GameTimer(GameData gameData) {

        this.gameData = gameData;

        addCoolDowns();
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!gameData.isGamePause && !gameData.isGameFinish) {

                    sectionTime--;

                    for (CoolDown coolDownObject : coolDownList) {
                        if (coolDownObject.counter > 0) {
                            coolDownObject.counter--;
                        }
                    }

                }

            }
        });
        timer.setRepeats(true);
        timer.start();

    }

    public static synchronized GameTimer getGameTimer(GameData gameData) {
        if (gameTimer == null) {
            gameTimer = new GameTimer(gameData);
        }
        return gameTimer;
    }

    private void addCoolDowns() {

        vilgaxMove = new CoolDown();
        fireBallAttack = new CoolDown();
        grabAttack = new CoolDown();
        jumpAttack = new CoolDown();
        nukeAttack = new CoolDown();
        marioShot = new CoolDown();

        coolDownList.add(vilgaxMove);
        coolDownList.add(fireBallAttack);
        coolDownList.add(grabAttack);
        coolDownList.add(jumpAttack);
        coolDownList.add(nukeAttack);
        coolDownList.add(marioShot);

    }

    public int getSectionTime() {
        return sectionTime;
    }

    public void setSectionTime(int sectionTime) {
        this.sectionTime = sectionTime;
    }

    public ArrayList<CoolDown> getCoolDownList() {
        return coolDownList;
    }

    public void setCoolDownList(ArrayList<CoolDown> coolDownList) {
        this.coolDownList = coolDownList;
    }
}
