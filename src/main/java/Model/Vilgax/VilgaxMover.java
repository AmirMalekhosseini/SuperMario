package Model.Vilgax;

import Graphic.Mario;
import Graphic.MarioWeapon;
import Graphic.Vilgax.Vilgax;
import Model.DistanceCalculator;

import java.util.Random;

public class VilgaxMover {

    Vilgax vilgax;
    Mario mario;
    VilgaxMove vilgaxDoNothing;
    VilgaxMove vilgaxFireBallAttack;
    VilgaxMove vilgaxGrabAttack;
    VilgaxMove vilgaxJump;
    VilgaxMove vilgaxJumpAttack;
    VilgaxMove vilgaxNukeAttack;
    VilgaxMove vilgaxRun;

    public VilgaxMover(Vilgax vilgax, Mario activeMario, VilgaxMove[] vilgaxMoves) {

        this.vilgax = vilgax;
        this.mario = activeMario;
        addMoves(vilgaxMoves);

    }

    public void move() {
        vilgax.activeMove.action();
    }

    public void moveChooser() {

        // GrabAttack:
        if (DistanceCalculator.getDistanceCalculator().calculate(mario, vilgax) <= 120) {
            vilgax.activeMove = vilgaxGrabAttack;
            return;

        // FireBallAttack:
        } else if (DistanceCalculator.getDistanceCalculator().calculate(mario, vilgax) >= 360 &&
                DistanceCalculator.getDistanceCalculator().calculate(mario, vilgax) <= 600) {
            vilgax.activeMove = vilgaxFireBallAttack;
            return;
        } else if (DistanceCalculator.getDistanceCalculator().calculate(mario, vilgax) >= 600) {

        }

        // JumpAttack:
//        if (counter >= 4) {
//            vilgax.activeMove = vilgaxJumpAttack;
//            return;
//        }

        if (vilgax.isVilgaxPhase_2()) {
            vilgax.activeMove = vilgaxNukeAttack;
            return;
        }

    }

    private void vilgaxRunToMario() {

        // Vilgax Run To Mario:
        while (DistanceCalculator.getDistanceCalculator().calculate(mario, vilgax) >= 200) {
            if (mario.getX() > vilgax.getX()) {// Mario is On Vilgax Right:
                vilgax.setXVelocity(3);
            } else {
                vilgax.setXVelocity(-3);
            }
            vilgax.activeMove = vilgaxRun;
        }

        vilgax.setXVelocity(-1);
        vilgax.activeMove = vilgaxDoNothing;

    }

    public void vilgaxDodgeShot(MarioWeapon weapon) {

        Random random = new Random();
        int chance = random.nextInt(8);
        if (chance == 5 && !weapon.isVilgaxDodged()) {// Vilgax Preforms Dodge:
            vilgax.activeMove = vilgaxJump;
        }
        // Vilgax can Only Preform Dodging Once:
        weapon.setVilgaxDodged(true);

    }



    private void addMoves(VilgaxMove[] vilgaxMoves) {

        vilgaxDoNothing = vilgaxMoves[0];
        vilgaxFireBallAttack = vilgaxMoves[1];
        vilgaxGrabAttack = vilgaxMoves[2];
        vilgaxJump = vilgaxMoves[3];
        vilgaxJumpAttack = vilgaxMoves[4];
        vilgaxNukeAttack = vilgaxMoves[5];
        vilgaxRun = vilgaxMoves[6];

    }


}
