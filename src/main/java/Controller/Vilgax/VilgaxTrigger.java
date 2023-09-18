package Controller.Vilgax;

import Model.Game.GameGodFather;
import Model.Game.WaitObject;
import Model.Object.ObjectsInGame;
import Music.MusicPlayer;
import View.Game.BossFightSectionScreen;

import javax.swing.*;

public class VilgaxTrigger {

    JPanel levelPanel;
    BossFightSectionScreen screen;
    protected MusicPlayer musicPlayer;



    public VilgaxTrigger(BossFightSectionScreen screen, MusicPlayer musicPlayer, JPanel levelPanel) {
        this.musicPlayer = musicPlayer;
        this.screen = screen;
        this.levelPanel = levelPanel;
    }

    public void triggerBoss(GameGodFather godFather) {

        if (screen.activeMario.getX() >= 5840) {
            screen.getGameData().setBossTriggered(true);

            // Add HealthBar
            screen.add(screen.healthBar, Integer.valueOf(1));

            // Add Wall
            for (ObjectsInGame wall : screen.getWall_BlockInAir()) {
                screen.add(wall, Integer.valueOf(1));
            }
            screen.getObjectsInThisSection().addAll(screen.getWall_BlockInAir());
            screen.setScreenLock(true);
            levelPanel.setLocation(-5100,0);


            // play boss music
            musicPlayer.stopMusic();
            musicPlayer.playMusic("Music/Pirate-Of-Caribbean.wav");

            // Trigger Boss
            synchronized (godFather.waitObject) {
                godFather.waitObject.notifyAll();
            }

        }


    }

    public void shutDownBoss() {

        screen.getGameData().setBossTriggered(false);

        // remove HealthBar
        screen.remove(screen.healthBar);

        // remove wall
        for (ObjectsInGame wall : screen.getWall_BlockInAir()) {
            screen.remove(wall);
        }
        screen.getObjectsInThisSection().removeAll(screen.getWall_BlockInAir());
        screen.setScreenLock(false);

        // reset vilgax health
        screen.vilgax.setHealth(100);
        activePhase_1();

        // play mario music
        musicPlayer.stopMusic();
        musicPlayer.playMusic("Music/SuperMario.wav");

    }

    private boolean isPhase_2_Active() {
        return screen.vilgax.getHealth() <= 50;
    }

    public void activePhase_2() {
        if (isPhase_2_Active()) {
            screen.vilgax.setVilgaxPhase_2(true);
            screen.activeMario.setMarioMini(false);
            screen.activeMario.setMarioMega(false);
            screen.activeMario.setMarioShooter(true);
        }
    }

    private void activePhase_1() {
        screen.vilgax.setVilgaxPhase_2(false);
    }

}
