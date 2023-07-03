package Controller.Vilgax;

import Controller.Game.GenerateRandomNumber;
import Model.Game.GameTimer;
import Model.Mario.Mario;
import Model.Mario.MarioWeapon;
import Model.Vilgax.Vilgax;
import Controller.Game.DistanceCalculator;

import java.util.Random;

public class VilgaxMover {

    protected GameTimer timer;
    Vilgax vilgax;
    Mario mario;
    VilgaxMove vilgaxDoNothing;
    VilgaxMove vilgaxFireBallAttack;
    VilgaxMove vilgaxGrabAttack;
    VilgaxMove vilgaxJump;
    VilgaxMove vilgaxJumpAttack;
    VilgaxMove vilgaxNukeAttack;
    VilgaxMove vilgaxRun;

    public VilgaxMover(GameTimer timer, Vilgax vilgax, Mario activeMario, VilgaxMove[] vilgaxMoves) {

        this.timer = timer;
        this.vilgax = vilgax;
        this.mario = activeMario;
        addMoves(vilgaxMoves);

    }

    public void move() {
        vilgax.activeMove.action();
    }

    public void moveChooser() {

        // Vilgax hit and can't move
//        if (timer.vilgaxMoveCoolDown.counter != 0) {
//            vilgax.activeMove = vilgaxDoNothing;
//            return;
//        }


        // Vilgax run to mario
        if (vilgax.activeMove == vilgaxRun) {
            vilgaxRunToMario();
            System.out.println("run");
            return;
        }

        // Choose move only when Vilgax is not preform any move:
        if (vilgax.activeMove != vilgaxDoNothing) {
//            System.out.println("nothing");
            return;
        }

        // Vilgax Jump
        if (mario.isMarioShooting()) {
            vilgaxDodgeShot();
            System.out.println("jump");
            return;
        }

        // Vilgax FireAttack || NukeAttack
        if (DistanceCalculator.getDistanceCalculator().calculate(mario, vilgax) >= 360 &&
                DistanceCalculator.getDistanceCalculator().calculate(mario, vilgax) <= 600) {

            // Phase_2
            if (vilgax.isVilgaxPhase_2()) {
                int chance = GenerateRandomNumber.getRandomNumber().generateNumber(2);
                // NukeAttack
                if (chance == 0) {
                    vilgax.activeMove = vilgaxNukeAttack;
                    // FireAttack
                } else {
                    vilgax.activeMove = vilgaxFireBallAttack;
                }
            // Phase_1
            } else {
                vilgax.activeMove = vilgaxFireBallAttack;
            }
            System.out.println("fire || nuke");
            return;
        }

        // Vilgax Run
//        if (DistanceCalculator.getDistanceCalculator().calculate(mario, vilgax) >= 560) {
//            vilgax.activeMove = vilgaxRun;
//            System.out.println("runChoose");
//            return;
//        }

//         JumpAttack:
//        if (counter >= 4) {
//            vilgax.activeMove = vilgaxJumpAttack;
//            return;
//        }

        // GrabAttack:
        if (DistanceCalculator.getDistanceCalculator().calculate(mario, vilgax) <= 140) {

            vilgax.activeMove = vilgaxGrabAttack;
            System.out.println("Grab");
            return;
        }

        // none of the situations appears
//        vilgaxWalkToMario();
//        System.out.println("walk");


    }

    private void vilgaxRunToMario() {

        // Vilgax Run To Mario:
        if (DistanceCalculator.getDistanceCalculator().calculate(mario, vilgax) >= 200) {
            if (mario.getX() > vilgax.getX()) {// Mario is On Vilgax Right:
                vilgax.setXVelocity(3);
            } else {
                vilgax.setXVelocity(-3);
            }
            vilgax.activeMove = vilgaxRun;
        } else {
            vilgax.activeMove.setMoveDone(true);
        }

    }

    private void vilgaxWalkToMario() {

        // Vilgax Run To Mario:
        if (DistanceCalculator.getDistanceCalculator().calculate(mario, vilgax) >= 200) {
            if (mario.getX() > vilgax.getX()) {// Mario is On Vilgax Right:
                vilgax.setXVelocity(1);
            } else {
                vilgax.setXVelocity(-1);
            }
            vilgax.activeMove = vilgaxRun;
        } else {
            vilgax.activeMove.setMoveDone(true);
        }

    }

    public void vilgaxDodgeShot() {

        int chance = GenerateRandomNumber.getRandomNumber().generateNumber(8);
        // Vilgax Preforms Dodge
        if (chance == 5 ) {
            vilgax.activeMove = vilgaxJump;
        }

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
