package Controller.Game;

import Model.Enemy.Bomb;
import View.Game.BossFightSectionScreen;
import Model.Vilgax.VilgaxWeapon;

public class VilgaxAndScreenConnection {

    BossFightSectionScreen bossFightSectionScreen;


    public VilgaxAndScreenConnection(BossFightSectionScreen bossFightSectionScreen) {
        this.bossFightSectionScreen = bossFightSectionScreen;
    }

    public void addVilgaxWeaponToScreen(VilgaxWeapon weapon) {
        bossFightSectionScreen.add(weapon, Integer.valueOf(1));
        bossFightSectionScreen.getVilgaxWeaponsInThisSection().add(weapon);
    }

    public void moveVilgaxWeapon() {
        for (VilgaxWeapon weapon : bossFightSectionScreen.getVilgaxWeaponsInThisSection()) {
            weapon.move();
        }
    }

    public void addVilgaxBombToScreen(Bomb bomb) {

        bossFightSectionScreen.add(bomb, Integer.valueOf(1));
        bossFightSectionScreen.getBombsInThisSection().add(bomb);

    }

}
