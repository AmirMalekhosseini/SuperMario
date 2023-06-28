package Model;

import Graphic.BossFightSectionScreen;
import Graphic.Mario;
import Graphic.Vilgax.Vilgax;

public class VilgaxAndMarioConnection {

    BossFightSectionScreen bossFightSectionScreen;
    Mario mario;
    Vilgax vilgax;

    public VilgaxAndMarioConnection(BossFightSectionScreen bossFightSectionScreen) {
        this.bossFightSectionScreen = bossFightSectionScreen;
        this.mario = bossFightSectionScreen.activeMario;
        this.vilgax = bossFightSectionScreen.vilgax;
    }

    public void vilgaxGrabMario() {

        // set Mario Location After Vilgax Catches it:
        if (mario.getX() <= vilgax.getX()) {// Mario is on vilgax left:
            mario.setX(vilgax.getX() - 40);
        } else {// Mario is on vilgax right:
            mario.setX(vilgax.getX() + 40);
        }
        mario.setY(vilgax.getY() + 10);

        // Vilgax Releases Mario:
        if (mario.isMarioReleaseFromVilgax()) {
            vilgaxReleaseMario();
            mario.setMarioReleaseFromVilgax(false);
        }

    }

    public void vilgaxReleaseMario() {

        // set Mario Location After Vilgax releases it:
        if (mario.getX() <= vilgax.getX()) {// Mario is on left:
            mario.setX(mario.getX() - 200);
        } else {// Mario is on right:
            mario.setX(mario.getX() + 200);
        }

        mario.setY(960 - mario.getHeight());

    }

}
