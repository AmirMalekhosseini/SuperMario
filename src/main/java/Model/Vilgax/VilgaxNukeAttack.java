package Model.Vilgax;

import Graphic.Bomb;
import Graphic.GameGodFather;
import Graphic.Vilgax.Vilgax;
import Model.GameTimer;

import java.util.Random;

public class VilgaxNukeAttack extends VilgaxMove {

    public VilgaxNukeAttack(GameGodFather godFather, Vilgax vilgax) {
        this.godFather = godFather;
        this.vilgax = vilgax;
        moveIntersection = new VilgaxMoveIntersection(godFather) {
            @Override
            public void intersection() {

                if (isMoveDone()) {
                    vilgax.activeMove = vilgax.vilgaxDoNothing;
                    setMoveDone(false);
                }

            }
        };
    }

    @Override
    public void action() {

        if (!isMoveDone()) {
            Bomb bomb = new Bomb(generateBombX(), 300);
            vilgax.vilgaxAndScreenConnection.addVilgaxBombToScreen(bomb);
            changeBackground();
            this.setMoveDone(true);
            // Active CoolDown:
            godFather.gameTimer.nukeAttackCoolDown.counter = 1;

        }

    }

    @Override
    public void changeBackground() {

    }

    public int  generateBombX() {

        Random random = new Random();

        return random.nextInt(6300 - 5400) + 5400;
    }

}
