package Model;

import Graphic.BossFightScreenSectionScreen;
import Graphic.LevelScreens;
import Graphic.Vilgax.VilgaxWeapon;

public class VilgaxAndScreenConnection {

    BossFightScreenSectionScreen bossFightScreenSectionScreen;


    public VilgaxAndScreenConnection(BossFightScreenSectionScreen bossFightScreenSectionScreen) {
        this.bossFightScreenSectionScreen = bossFightScreenSectionScreen;
    }

    public void addVilgaxWeaponToScreen(VilgaxWeapon weapon) {
        bossFightScreenSectionScreen.add(weapon, Integer.valueOf(1));
        bossFightScreenSectionScreen.getVilgaxWeaponsInThisSection().add(weapon);
    }

    public void moveVilgaxWeapon() {
        for (VilgaxWeapon weapon : bossFightScreenSectionScreen.getVilgaxWeaponsInThisSection()) {
            weapon.move();
        }
    }

}
