package Model;

import Graphic.BossFightSectionScreen;
import Graphic.Vilgax.VilgaxWeapon;

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

}
