package Model.Vilgax;

import Graphic.GameGodFather;
import Graphic.Vilgax.Vilgax;
import Model.GravityData;

public class VilgaxJump extends VilgaxMove {


    private boolean isJumpAttackActive;

    public VilgaxJump(GameGodFather godFather, Vilgax vilgax) {
        this.godFather = godFather;
        this.vilgax = vilgax;
        moveIntersection = new VilgaxMoveIntersection(godFather) {
            @Override
            public void intersection() {

                if (!isJumpAttackActive && isMoveDone()) {
                    vilgax.activeMove = vilgax.vilgaxDoNothing;
                    setMoveDone(false);
                }

            }
        };
    }

    @Override
    public void action() {

        vilgax.setYVelocity(vilgax.getYVelocity() + (GravityData.getGravityData().gravity) * GravityData.getGravityData().vilgaxDt);
        vilgax.setY((int) (vilgax.getY() + vilgax.getYVelocity()));

        if (!isJumpAttackActive) {// only do this when active move is jump,not jumpAttack!
            changeBackground();
        }

        if (vilgax.getY() >= 960 - vilgax.getHeight()
                && vilgax.getY() <= 980 - vilgax.getHeight()) {// Vilgax Hits Ground:
            this.setMoveDone(true);
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

    public boolean isJumpAttackActive() {
        return isJumpAttackActive;
    }

    public void setJumpAttackActive(boolean jumpAttackActive) {
        isJumpAttackActive = jumpAttackActive;
    }
}
