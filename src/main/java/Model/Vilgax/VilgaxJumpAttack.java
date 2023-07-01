package Model.Vilgax;

import Graphic.Vilgax.Vilgax;

public class VilgaxJumpAttack extends VilgaxMove {


    VilgaxJump vilgaxJump;

    public VilgaxJumpAttack(Vilgax vilgax) {
        this.vilgax = vilgax;
        this.vilgaxJump = (VilgaxJump) vilgax.vilgaxJump;
    }

    @Override
    public void action() {

        if (!vilgaxJump.isJumpAttackActive()) {
            vilgaxJump.setJumpAttackActive(true);
        }

        vilgaxJump.action();
        changeBackground();

        // VilgaxJump is Done so JumpAttack Should Finish:
        if (vilgaxJump.isMoveDone()) {
            vilgaxJump.setMoveDone(false);
            this.setMoveDone(true);
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
