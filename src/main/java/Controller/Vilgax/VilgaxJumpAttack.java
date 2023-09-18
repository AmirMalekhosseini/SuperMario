package Controller.Vilgax;

import Model.Game.GameGodFather;
import Model.Mario.Mario;
import Model.Vilgax.Vilgax;

public class VilgaxJumpAttack extends VilgaxMove {


    VilgaxJump vilgaxJump;
    Mario activeMario;

    public VilgaxJumpAttack(GameGodFather godFather, Vilgax vilgax) {
        this.godFather = godFather;
        this.vilgax = vilgax;
        this.vilgaxJump = (VilgaxJump) vilgax.vilgaxJump;
        moveIntersection = new VilgaxMoveIntersection(godFather) {
            @Override
            public void intersection() {

                if (isMoveDone()) {

                    if (activeMario.isMarioOnGround()) {// Mario Will be Damaged:
                        godFather.getPowerUp().decreasePowerUp(activeMario);
                        // ToDo: Confuse Mario
                    }

                    vilgax.activeMove = vilgax.vilgaxDoNothing;
                    setMoveDone(false);

                }

            }
        };
    }

    @Override
    public void action() {

        if (!isMoveDone()) {
            if (!vilgaxJump.isJumpAttackActive()) {
                vilgaxJump.setJumpAttackActive(true);
            }

            vilgaxJump.action();
            changeBackground();

            // VilgaxJump is Done so JumpAttack Should Finish:
            if (vilgaxJump.isMoveDone()) {
                vilgaxJump.setMoveDone(false);
                this.setMoveDone(true);
                // Active CoolDown:
                godFather.gameTimer.jumpAttackCoolDown.counter = 2;

            }
        }

    }

    @Override
    public void changeBackground() {

        if (vilgax.getY() <= 940 - vilgax.getHeight()
                && vilgax.getYVelocity() >= 0) {// Vilgax changes on Air:

            if (vilgax.isVilgaxPhase_2()) {// Vilgax is in Phase_2:
                if (vilgax.getXVelocity() >= 0) {
                    vilgax.setActiveBackground(vilgax.getVilgax_Phase2_Filliped_Jump_Attack());
                } else {
                    vilgax.setActiveBackground(vilgax.getVilgax_Phase2_Jump_Attack());
                }
            } else {// Vilgax is in Phase_1:
                if (vilgax.getXVelocity() >= 0) {
                    vilgax.setActiveBackground(vilgax.getVilgax_Phase1_Filliped_Jump_Attack());
                } else {
                    vilgax.setActiveBackground(vilgax.getVilgax_Phase1_Jump_Attack());
                }
            }

        }

    }
}
