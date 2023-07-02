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
    private boolean marioHitsVilgax;

    public VilgaxIntersection(GameGodFather godFather) {

        this.godFather = godFather;
        this.screen = godFather.getBossFightScreenSection();
        this.powerUp = godFather.getPowerUp();
        vilgax = screen.vilgax;
        activeMario = screen.activeMario;
    }

    public void allIntersection() {

        marioIntersectVilgax();
        vilgaxIntersectWithObjects();
        bombIntersectVilgax();
        fireBallIntersectObjects();
        marioWeaponIntersectsVilgax();
        grabAttackIntersection();

    }

    protected void marioIntersectVilgax() {

        int marioWidth = activeMario.getWidth();
        int marioHeight = activeMario.getHeight();
        int vilgaxWidth = vilgax.getWidth();
        int vilgaxHeight = vilgax.getHeight();
        if (vilgaxWidth <= 0 || vilgaxHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
            return;
        }
        int marioX = activeMario.getX();
        int marioY = activeMario.getY();
        int vilgaxX = vilgax.getX();
        int vilgaxY = vilgax.getY();
        vilgaxWidth += vilgaxX;
        vilgaxHeight += vilgaxY;
        marioWidth += marioX;
        marioHeight += marioY;

        //      overflow || marioIntersectWithObjects
        if ((vilgaxWidth < vilgaxX || vilgaxWidth > marioX)
                && (vilgaxHeight < vilgaxY || vilgaxHeight > marioY)
                && (marioWidth < marioX || marioWidth > vilgaxX)
                && (marioHeight < marioY || marioHeight > vilgaxY)) {
            if ((marioWidth >= vilgaxX || vilgaxWidth >= marioX) && marioHeight <= vilgaxY + 30) {
                // Hit up of Vilgax and Damage it:

                godFather.activeLevel.intersect.intersection.setMarioHitsUpOfTheVilgax(true);
                activeMario.setY(vilgax.getY() - activeMario.getHeight() - 2);
                if (marioHitsVilgax) {
                    return;
                }
                vilgax.setHealth(vilgax.getHealth() - 5);
                marioHitsVilgax = true;
            }


        }

    }

    protected void vilgaxIntersectWithObjects() {

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
            if ((objectWidth < objectX || objectWidth > vilgaxX)
                    && (objectHeight < objectY || objectHeight > vilgaxY)
                    && (vilgaxWidth < vilgaxX || vilgaxWidth > objectX)
                    && (vilgaxHeight < vilgaxY || vilgaxHeight > objectY)) {

                screen.remove(screen.getObjectsInThisSection().get(i));
                screen.getObjectsInThisSection().remove(screen.getObjectsInThisSection().get(i));
                return;
            }
        }

    }

    protected void bombIntersectVilgax() {

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
            if ((objectWidth < objectX || objectWidth > vilgaxX)
                    && (objectHeight < objectY || objectHeight > vilgaxY)
                    && (vilgaxWidth < vilgaxX || vilgaxWidth > objectX)
                    && (vilgaxHeight < vilgaxY || vilgaxHeight > objectY)) {
                screen.remove(bomb);
                screen.getBombsInThisSection().remove(i);
                // Bomb Hits Vilgax:
                vilgax.setHealth(screen.vilgax.getHealth() - 5);
                return;
            }
        }

    }

    protected void fireBallIntersectObjects() {

        for (VilgaxWeapon fireBall : screen.getVilgaxWeaponsInThisSection()) {

        for (int i = 0; i < screen.getObjectsInThisSection().size(); i++) {
            int fireBallWidth = fireBall.getWidth();
            int fireBallHeight = fireBall.getHeight();
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
            if ((objectWidth < objectX || objectWidth > fireBallX)
                    && (objectHeight < objectY || objectHeight > fireBallY) &&
                    (fireBallWidth < fireBallX || fireBallWidth > objectX) &&
                    (fireBallHeight < fireBallY || fireBallHeight > objectY)) {

                fireBall.setWeaponHitsSth(true);
                // Remove it in fireBall Intersection.
                return;

            }
        }
    }

    }

    protected void marioWeaponIntersectsVilgax() {

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
            if ((objectWidth < objectX || objectWidth > vilgaxX) && (objectHeight < objectY || objectHeight > vilgaxY) && (vilgaxWidth < vilgaxX || vilgaxWidth > objectX) && (vilgaxHeight < vilgaxY || vilgaxHeight > objectY)) {

                // Mario Hits Vilgax:
                vilgax.setHealth(vilgax.getHealth() - screen.getWeaponsInThisSection().get(i).getDamage());
                screen.remove(screen.getWeaponsInThisSection().get(i));
                screen.getWeaponsInThisSection().remove(screen.getWeaponsInThisSection().get(i));
                return;
            }
        }

    }

    protected void grabAttackIntersection() {

        /*

        if time==5
          if !marioRelease
          decrease powerUp
          marioRelease = true
          else
          time=0;

         */



    }

    // Call it When Vilgax Hits Ground After Jump Attack

    public boolean isMarioHitsVilgax() {
        return marioHitsVilgax;
    }

    public void setMarioHitsVilgax(boolean marioHitsVilgax) {
        this.marioHitsVilgax = marioHitsVilgax;
    }
}
