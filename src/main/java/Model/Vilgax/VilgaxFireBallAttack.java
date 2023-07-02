package Model.Vilgax;

import Graphic.BossFightSectionScreen;
import Graphic.GameGodFather;
import Graphic.Mario;
import Graphic.Vilgax.Vilgax;
import Graphic.Vilgax.VilgaxFireBall;
import Graphic.Vilgax.VilgaxWeapon;
import Model.GameTimer;

import java.util.Random;

public class VilgaxFireBallAttack extends VilgaxMove {


    BossFightSectionScreen screen;
    Mario activeMario;
    private int fireBallY = 850;// High ShotY: 800

    public VilgaxFireBallAttack(GameGodFather godFather, Vilgax vilgax) {
        this.godFather = godFather;
        this.vilgax = vilgax;
        this.screen = godFather.getBossFightScreenSection();
        this.activeMario = screen.activeMario;
        moveIntersection = new VilgaxMoveIntersection(godFather) {
            @Override
            public void intersection() {

                for (int i = 0; i < screen.getVilgaxWeaponsInThisSection().size(); i++) {
                    VilgaxWeapon fireBall = screen.getVilgaxWeaponsInThisSection().get(i);
                    if (fireBall.isWeaponHitsSth()) {
                        screen.remove(fireBall);
                        screen.getVilgaxWeaponsInThisSection().remove(fireBall);
                        vilgax.activeMove = vilgax.vilgaxDoNothing;
                        setMoveDone(false);
                        return;
                    }
                    int marioWidth = activeMario.getWidth();
                    int marioHeight = activeMario.getHeight();
                    int objectWidth = fireBall.getWidth();
                    int objectHeight = fireBall.getHeight();
                    if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                        continue;
                    }
                    int marioX = activeMario.getX();
                    int marioY = activeMario.getY();
                    int objectX = fireBall.getX();
                    int objectY = fireBall.getY();
                    objectWidth += objectX;
                    objectHeight += objectY;
                    marioWidth += marioX;
                    marioHeight += marioY;

                    //      overflow || marioIntersectWithObjects
                    if ((objectWidth < objectX || objectWidth > marioX)
                            && (objectHeight < objectY || objectHeight > marioY)
                            && (marioWidth < marioX || marioWidth > objectX)
                            && (marioHeight < marioY || marioHeight > objectY)) {
                        fireBall.setWeaponHitsSth(true);
                        screen.remove(fireBall);
                        screen.getVilgaxWeaponsInThisSection().remove(i);
                        vilgax.activeMove = vilgax.vilgaxDoNothing;
                        setMoveDone(false);
                        godFather.getPowerUp().decreasePowerUp(activeMario);
                        if (activeMario.isMarioShouldDie()) {
                            screen.getGameData().userHeartValue--;
                        }
                    }
                }

            }
        };
    }

    @Override
    public void action() {

        if (!isMoveDone()) {
            changeBackground();
            calculateFireBallY();
            VilgaxFireBall fireBall = new VilgaxFireBall(vilgax.getX(), fireBallY);
            // set fireBall velocity base on Vilgax Velocity:
            if (vilgax.getXVelocity() >= 0) {
                fireBall.setVelocity(30);
            } else {
                fireBall.setVelocity(-30);
            }
            vilgax.vilgaxAndScreenConnection.addVilgaxWeaponToScreen(fireBall);
            setMoveDone(true);
            // Active CoolDown:
            GameTimer.getGameTimer().fireBallAttackCoolDown.counter = 2;

        }


    }

    private void calculateFireBallY() {
        Random random = new Random();
        int chance = random.nextInt(2);
        if (chance == 0) {
            fireBallY = 800;
        } else {
            fireBallY = 850;
        }
    }

    @Override
    public void changeBackground() {

        if (vilgax.isVilgaxPhase_2()) {// Vilgax is in Phase_2:
            if (vilgax.getXVelocity() >= 0) {
                vilgax.setActiveBackground(vilgax.getVilgax_Phase2_Filliped());
            } else {
                vilgax.setActiveBackground(vilgax.getVilgax_Phase2());
            }
        } else {// Vilgax is in Phase_1:
            if (vilgax.getXVelocity() >= 0) {
                vilgax.setActiveBackground(vilgax.getVilgax_Phase1_Filliped());
            } else {
                vilgax.setActiveBackground(vilgax.getVilgax_Phase1());
            }
        }

    }

    public int getFireBallY() {
        return fireBallY;
    }

    public void setFireBallY(int fireBallY) {
        this.fireBallY = fireBallY;
    }

}
