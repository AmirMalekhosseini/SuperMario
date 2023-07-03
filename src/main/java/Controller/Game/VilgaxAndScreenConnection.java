package Controller.Game;

import Model.Enemy.Bomb;
import Model.Game.WaitObject;
import Model.Object.ObjectsInGame;
import View.Game.BossFightSectionScreen;
import Model.Vilgax.VilgaxWeapon;

public class VilgaxAndScreenConnection {

    BossFightSectionScreen screen;


    public VilgaxAndScreenConnection(BossFightSectionScreen screen) {
        this.screen = screen;
    }

    public void addVilgaxWeaponToScreen(VilgaxWeapon weapon) {
        screen.add(weapon, Integer.valueOf(1));
        screen.getVilgaxWeaponsInThisSection().add(weapon);
    }

    public void moveVilgaxWeapon() {
        for (VilgaxWeapon weapon : screen.getVilgaxWeaponsInThisSection()) {
            weapon.move();
        }
    }

    public void addVilgaxBombToScreen(Bomb bomb) {

        screen.add(bomb, Integer.valueOf(1));
        screen.getBombsInThisSection().add(bomb);

    }

}
