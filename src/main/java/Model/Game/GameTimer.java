package Model.Game;

import Controller.Vilgax.VilgaxMover;
import Model.Vilgax.Vilgax;
import View.Game.BossFightSectionScreen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameTimer {

    private ArrayList<CoolDown> negativeCoolDownList = new ArrayList<>();
    private ArrayList<CoolDown> positiveCoolDownList = new ArrayList<>();
    public CoolDown vilgaxMoveCoolDown;
    public CoolDown fireBallAttackCoolDown;
    public CoolDown grabAttackCoolDown;
    public CoolDown jumpAttackCoolDown;
    public CoolDown nukeAttackCoolDown;
    public CoolDown marioShotCoolDown;
    public CoolDown grabAttackCounter;
    public CoolDown jumpAttackCounter;
    public CoolDown shieldCounter;

    protected GameGodFather godFather;
    private GameData gameData;
    javax.swing.Timer timer;
    private int sectionTime = 50;
    private int saveTime;

    public GameTimer(GameGodFather godFather) {

        this.godFather = godFather;
        addCoolDowns();

    }

    public void addGameData(GameData gameData) {
        this.gameData = gameData;
    }

    public void startTimer() {

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!gameData.isGamePause && !gameData.isGameFinish) {

                    sectionTime--;

                    grabAttackCounter();
                    jumpAttackCounter();

                    for (CoolDown coolDownObject : negativeCoolDownList) {
                        if (coolDownObject.counter > 0) {
                            coolDownObject.counter--;
                        }
                    }

                    for (CoolDown coolDownObject : positiveCoolDownList) {
                        if (coolDownObject.counter != 18) {
                            // Set A Random Number For Stop Counting.
                            coolDownObject.counter++;
                        }
                    }

                }

            }
        });
        timer.setRepeats(true);
        timer.start();

    }

    public void stopTimer() {

        timer.stop();

    }

    private void addCoolDowns() {

        vilgaxMoveCoolDown = new CoolDown();
        fireBallAttackCoolDown = new CoolDown();
        grabAttackCoolDown = new CoolDown();
        jumpAttackCoolDown = new CoolDown();
        nukeAttackCoolDown = new CoolDown();
        marioShotCoolDown = new CoolDown();

        negativeCoolDownList.add(vilgaxMoveCoolDown);
        negativeCoolDownList.add(fireBallAttackCoolDown);
        negativeCoolDownList.add(grabAttackCoolDown);
        negativeCoolDownList.add(jumpAttackCoolDown);
        negativeCoolDownList.add(nukeAttackCoolDown);
        negativeCoolDownList.add(marioShotCoolDown);

        grabAttackCounter = new CoolDown();
        jumpAttackCounter = new CoolDown();
        shieldCounter = new CoolDown();

        positiveCoolDownList.add(shieldCounter);

    }

    private void jumpAttackCounter() {

        if (godFather.activeLevel.getScreen() instanceof BossFightSectionScreen) {
            if (godFather.activeLevel.getMario().isMarioOnGround()) {
                jumpAttackCounter.counter++;
            } else {
                jumpAttackCounter.counter = 0;
            }
        }

    }

    private void grabAttackCounter() {

        if (godFather.activeLevel.getScreen() instanceof BossFightSectionScreen) {

            Vilgax vilgax = ((BossFightSectionScreen) godFather.activeLevel.getScreen()).vilgax;
            // Active move is GrabAttack
            if (vilgax.activeMove == vilgax.vilgaxGrabAttack) {
                grabAttackCounter.counter++;
            } else {
                grabAttackCounter.counter = 0;
            }

            System.out.println(grabAttackCounter.counter);
        }

    }

    public int getSectionTime() {
        return sectionTime;
    }

    public void setSectionTime(int sectionTime) {
        this.sectionTime = sectionTime;
    }

    public ArrayList<CoolDown> getNegativeCoolDownList() {
        return negativeCoolDownList;
    }

    public void setNegativeCoolDownList(ArrayList<CoolDown> negativeCoolDownList) {
        this.negativeCoolDownList = negativeCoolDownList;
    }

    public ArrayList<CoolDown> getPositiveCoolDownList() {
        return positiveCoolDownList;
    }

    public void setPositiveCoolDownList(ArrayList<CoolDown> positiveCoolDownList) {
        this.positiveCoolDownList = positiveCoolDownList;
    }

    public int getSaveTime() {
        return saveTime;
    }

    public void setSaveTime(int saveTime) {
        this.saveTime = saveTime;
    }
}
