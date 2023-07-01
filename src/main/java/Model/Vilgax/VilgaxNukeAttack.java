package Model.Vilgax;

import Graphic.Bomb;
import Graphic.Vilgax.Vilgax;

import java.util.Random;

public class VilgaxNukeAttack extends VilgaxMove {

    public VilgaxNukeAttack(Vilgax vilgax) {
        this.vilgax = vilgax;
    }

    @Override
    public void action() {

        // ToDO: make it only one time attack
        Bomb bomb = new Bomb(generateBombX(), 300);
        vilgax.vilgaxAndScreenConnection.addVilgaxBombToScreen(bomb);
        changeBackground();
        vilgax.activeMove = vilgax.vilgaxRun;
        this.setMoveDone(true);

    }

    @Override
    public void changeBackground() {

    }

    public int  generateBombX() {

        Random random = new Random();

        return random.nextInt(6300 - 5400) + 5400;
    }

}
