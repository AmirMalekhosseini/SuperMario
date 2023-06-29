package Model;

import Graphic.*;
import Graphic.Vilgax.Vilgax;
import Graphic.Vilgax.VilgaxWeapon;

public abstract class VilgaxIntersection {

    GameGodFather godFather;
    BossFightSectionScreen screen;
    PowerUp powerUp;
    Vilgax vilgax;
    Mario activeMario;

    public VilgaxIntersection(GameGodFather godFather, PowerUp powerUp, BossFightSectionScreen screen) {

        this.godFather = godFather;
        this.screen = screen;
        this.powerUp = powerUp;
        vilgax = screen.vilgax;
        activeMario = screen.activeMario;
    }

    public void vilgaxIntersectWithObjects() {

        for (int i = 0; i < screen.getObjectsInThisSection().size(); i++) {

            int vilgaxWidth = vilgax.getWidth();
            int vilgaxHeight = vilgax.getHeight();
            int objectWidth = screen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = screen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || vilgaxWidth <= 0 || vilgaxHeight <= 0) {
                continue;
            }
            int vilgaxX = vilgax.getX();
            int vilgaxY = vilgax.getY();
            int objectX = screen.getObjectsInThisSection().get(i).getX();
            int objectY = screen.getObjectsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            vilgaxWidth += vilgaxX;
            vilgaxHeight += vilgaxY;

            //      overflow || marioIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > vilgaxX) &&
                    (objectHeight < objectY || objectHeight > vilgaxY) &&
                    (vilgaxWidth < vilgaxX || vilgaxWidth > objectX) &&
                    (vilgaxHeight < vilgaxY || vilgaxHeight > objectY)) {

                screen.remove(screen.getObjectsInThisSection().get(i));
                screen.getObjectsInThisSection().remove(screen.getObjectsInThisSection().get(i));
                return;
            }
        }

    }

    public void bombIntersectVilgax() {

        for (int i = 0; i < screen.getBombsInThisSection().size(); i++) {
            Bomb bomb = screen.getBombsInThisSection().get(i);
            int vilgaxWidth = vilgax.getWidth();
            int vilgaxHeight = vilgax.getHeight();
            int objectWidth = bomb.getWidth();
            int objectHeight = bomb.getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || vilgaxWidth <= 0 || vilgaxHeight <= 0) {
                continue;
            }
            int vilgaxX = vilgax.getX();
            int vilgaxY = vilgax.getY();
            int objectX = bomb.getX();
            int objectY = bomb.getY();
            objectWidth += objectX;
            objectHeight += objectY;
            vilgaxWidth += vilgaxX;
            vilgaxHeight += vilgaxY;

            //      overflow || marioIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > vilgaxX) &&
                    (objectHeight < objectY || objectHeight > vilgaxY) &&
                    (vilgaxWidth < vilgaxX || vilgaxWidth > objectX) &&
                    (vilgaxHeight < vilgaxY || vilgaxHeight > objectY)) {
                screen.remove(bomb);
                screen.getBombsInThisSection().remove(i);
                // Bomb Hits Vilgax:
                vilgax.setHealth(screen.vilgax.getHealth() - 5);
                return;
            }
        }

    }

    public void fireBallIntersectObjects(VilgaxWeapon fireBall) {

        for (int i = 0; i < screen.getObjectsInThisSection().size(); i++) {
            int fireBallWidth = fireBall.getWidth();
            int fireBallHeight = fireBall.getHeight() + 10;
            int objectWidth = screen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = screen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || fireBallWidth <= 0 || fireBallHeight <= 0) {
                continue;
            }
            int fireBallX = fireBall.getX();
            int fireBallY = fireBall.getY();
            int objectX = screen.getObjectsInThisSection().get(i).getX();
            int objectY = screen.getObjectsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            fireBallWidth += fireBallX;
            fireBallHeight += fireBallY;

            //      overflow || bombIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > fireBallX) &&
                    (objectHeight < objectY || objectHeight > fireBallY) &&
                    (fireBallWidth < fireBallX || fireBallWidth > objectX) &&
                    (fireBallHeight < fireBallY || fireBallHeight > objectY)) {

                screen.remove(fireBall);
                screen.getVilgaxWeaponsInThisSection().remove(fireBall);
                return;

            }
        }

    }

    public void marioWeaponIntersectsVilgax() {

        for (int i = 0; i < screen.getWeaponsInThisSection().size(); i++) {

            int vilgaxWidth = vilgax.getWidth();
            int vilgaxHeight = vilgax.getHeight();
            int objectWidth = screen.getWeaponsInThisSection().get(i).getWidth();
            int objectHeight = screen.getWeaponsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || vilgaxWidth <= 0 || vilgaxHeight <= 0) {
                continue;
            }
            int vilgaxX = vilgax.getX();
            int vilgaxY = vilgax.getY();
            int objectX = screen.getWeaponsInThisSection().get(i).getX();
            int objectY = screen.getWeaponsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            vilgaxWidth += vilgaxX;
            vilgaxHeight += vilgaxY;

            //      overflow || marioIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > vilgaxX) &&
                    (objectHeight < objectY || objectHeight > vilgaxY) &&
                    (vilgaxWidth < vilgaxX || vilgaxWidth > objectX) &&
                    (vilgaxHeight < vilgaxY || vilgaxHeight > objectY)) {

                // Mario Hits Vilgax:
                screen.remove(screen.getWeaponsInThisSection().get(i));
                screen.getWeaponsInThisSection().remove(screen.getWeaponsInThisSection().get(i));
                vilgax.setHealth(vilgax.getHealth() - 5);
                return;
            }
        }

    }

    public void grabAttackIntersection() {

        /*

        if time==5
          if !marioRelease
          decrease powerUp
          else
          time=0;

         */

    }

    // Call it When Vilgax Hits Ground After Jump Attack
    public void jumpAttackIntersection() {

        if (activeMario.isMarioOnGround()) {// Mario Will be Damaged:
            powerUp.decreasePowerUp(activeMario);
            // ToDo: Confuse Mario
        }

    }

    public void fireBallAttackIntersection() {

        for (int i = 0; i < screen.getVilgaxWeaponsInThisSection().size(); i++) {
            VilgaxWeapon weapon = screen.getVilgaxWeaponsInThisSection().get(i);
            int marioWidth = activeMario.getWidth();
            int marioHeight = activeMario.getHeight();
            int objectWidth = weapon.getWidth();
            int objectHeight = weapon.getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = activeMario.getX();
            int marioY = activeMario.getY();
            int objectX = weapon.getX();
            int objectY = weapon.getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || marioIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                screen.remove(weapon);
                screen.getVilgaxWeaponsInThisSection().remove(i);
                powerUp.decreasePowerUp(activeMario);
                if (activeMario.isMarioShouldDie()) {
                    screen.getGameData().userHeartValue--;
                }
            }
        }

    }

}
