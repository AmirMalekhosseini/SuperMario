package Model.Vilgax;

import Graphic.Vilgax.Vilgax;
import Graphic.Vilgax.VilgaxFireBall;

public class VilgaxFireBallAttack extends VilgaxMove {


    private boolean canThrowFireBall = true;
    private int fireBallY = 850;// High ShotY: 800
    public VilgaxFireBallAttack(Vilgax vilgax) {
        this.vilgax = vilgax;
    }

    @Override
    public void action() {

        if (canThrowFireBall) {
            VilgaxFireBall fireBall = new VilgaxFireBall(vilgax.getX(), fireBallY);
            // set fireBall velocity base on Vilgax Velocity:
            if (vilgax.getXVelocity() >= 0) {
                fireBall.setVelocity(30);
            } else {
                fireBall.setVelocity(-30);
            }
            vilgax.vilgaxAndScreenConnection.addVilgaxWeaponToScreen(fireBall);
            canThrowFireBall = false;
        }

        changeBackground();

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
