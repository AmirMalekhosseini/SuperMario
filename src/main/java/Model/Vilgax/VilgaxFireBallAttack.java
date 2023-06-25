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
            if (vilgax.getVelocity() >= 0) {
                fireBall.setVelocity(30);
            } else {
                fireBall.setVelocity(-30);
            }
            vilgax.vilgaxAndScreenConnection.addVilgaxWeaponToScreen(fireBall);
//            fireBall.move();
            canThrowFireBall = false;
        }

    }

    public int getFireBallY() {
        return fireBallY;
    }

    public void setFireBallY(int fireBallY) {
        this.fireBallY = fireBallY;
    }

}
