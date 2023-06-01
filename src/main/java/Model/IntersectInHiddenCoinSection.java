package Model;

import Graphic.*;

import java.util.Random;

public class IntersectInHiddenCoinSection {

    GameScreenFrame gameScreenFrame;
    HiddenCoinSectionScreen hiddenCoinSectionScreen;
    PowerUp powerUp;
    protected boolean marioHitsLeftOfTheObject;
    protected boolean marioHitsRightOfTheObject;
    protected boolean marioHitsUpOfTheObject;
    protected boolean marioHitsDownOfTheObject;
    protected boolean marioHitsAnObject;
    protected boolean marioHitsFullOfCoinBlockInAir;

    public IntersectInHiddenCoinSection(GameScreenFrame gameScreenFrame, PowerUp powerUp) {
        this.powerUp = powerUp;
        this.gameScreenFrame = gameScreenFrame;
        this.hiddenCoinSectionScreen = gameScreenFrame.getHiddenCoinSectionScreen();
    }

    public IntersectInHiddenCoinSection() {

    }

    public void intersectWithObjects() {

        for (int i = 0; i < hiddenCoinSectionScreen.getObjectsInThisSection().size(); i++) {
            int marioWidth = hiddenCoinSectionScreen.activeMario.get(0).getWidth();
            int marioHeight = hiddenCoinSectionScreen.activeMario.get(0).getHeight();
            int objectWidth = hiddenCoinSectionScreen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = hiddenCoinSectionScreen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = hiddenCoinSectionScreen.activeMario.get(0).getX();
            int marioY = hiddenCoinSectionScreen.activeMario.get(0).getY();
            int objectX = hiddenCoinSectionScreen.getObjectsInThisSection().get(i).getX();
            int objectY = hiddenCoinSectionScreen.getObjectsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || marioIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {

                if ((marioWidth >= objectX || objectWidth >= marioX) && marioHeight <= objectY + 30) {// Hit up of Object

                    if (!marioHitsUpOfTheObject) {
                        marioHitsUpOfTheObject = true;
                    }


                } else {
                    marioHitsUpOfTheObject = false;
                }


                if ((marioWidth >= objectX || objectWidth >= marioX) && objectHeight <= marioY + 20) {// Hit down of Object

                    if (!marioHitsDownOfTheObject) {
                        marioHitsDownOfTheObject = true;
                    }

                } else {
                    marioHitsDownOfTheObject = false;
                }

                if ((objectHeight > marioY || marioHeight > objectY) && marioWidth <= objectX + 20 && !marioHitsDownOfTheObject && !marioHitsUpOfTheObject) {// Hit left of Object

                    marioHitsLeftOfTheObject = true;

                }
                if ((objectHeight > marioY || marioHeight > objectY) && objectWidth <= marioX + 20 && !marioHitsDownOfTheObject && !marioHitsUpOfTheObject) {// Hit right of Object

                    marioHitsRightOfTheObject = true;

                }

                if (hiddenCoinSectionScreen.getObjectsInThisSection().get(i) instanceof PrizeInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    if (((PrizeInAir) hiddenCoinSectionScreen.getObjectsInThisSection().get(i)).isItemCatch()) {
                        ((PrizeInAir) hiddenCoinSectionScreen.getObjectsInThisSection().get(i)).setItemCatch(true);
                        generateRandomItem((PrizeInAir) hiddenCoinSectionScreen.getObjectsInThisSection().get(i));
                        marioHitsAnObject = true;
                    }
                    continue;
                }

                if (hiddenCoinSectionScreen.activeMario.get(0).isMarioMini()) {// Mini Mario cant destroy
                    return;
                }

                if (hiddenCoinSectionScreen.getObjectsInThisSection().get(i) instanceof SimpleBlockInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    hiddenCoinSectionScreen.remove(hiddenCoinSectionScreen.getObjectsInThisSection().get(i));
                    hiddenCoinSectionScreen.getObjectsInThisSection().remove(hiddenCoinSectionScreen.getObjectsInThisSection().get(i));
                    gameScreenFrame.getGameData().thisGameScore++;
                    marioHitsAnObject = true;
                    i = 0;
                    continue;
                } else if (hiddenCoinSectionScreen.getObjectsInThisSection().get(i) instanceof OneCoinBlockInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    int x = hiddenCoinSectionScreen.getObjectsInThisSection().get(i).getX();
                    int y = hiddenCoinSectionScreen.getObjectsInThisSection().get(i).getY() - 50;
                    Coin newCoin = new Coin(x, y);
                    ((OneCoinBlockInAir) hiddenCoinSectionScreen.getObjectsInThisSection().get(i)).setCoinInBlockInAir(newCoin);
                    hiddenCoinSectionScreen.add(newCoin, Integer.valueOf(1));
                    hiddenCoinSectionScreen.getItemsInThisSection().add(newCoin);
                    hiddenCoinSectionScreen.remove(hiddenCoinSectionScreen.getObjectsInThisSection().get(i));
                    SimpleBlockInAir newSimpleBlockInAir = new SimpleBlockInAir(x, y + 50);
                    hiddenCoinSectionScreen.getObjectsInThisSection().set(i, newSimpleBlockInAir);
                    hiddenCoinSectionScreen.add(newSimpleBlockInAir, Integer.valueOf(1));
                    gameScreenFrame.getGameData().thisGameScore++;
                    marioHitsAnObject = true;
                    i = 0;
                    continue;
                } else if (hiddenCoinSectionScreen.getObjectsInThisSection().get(i) instanceof FullOfCoinBlockInAir && marioHitsDownOfTheObject
                        && !marioHitsAnObject && !marioHitsFullOfCoinBlockInAir) {
                    ((FullOfCoinBlockInAir) hiddenCoinSectionScreen.getObjectsInThisSection().get(i)).hitCounter++;
                    gameScreenFrame.getGameData().thisGameCoin++;
                    marioHitsFullOfCoinBlockInAir = true;

                    if (((FullOfCoinBlockInAir) hiddenCoinSectionScreen.getObjectsInThisSection().get(i)).getHitCounter() == 5) {
                        int x = hiddenCoinSectionScreen.getObjectsInThisSection().get(i).getX();
                        int y = hiddenCoinSectionScreen.getObjectsInThisSection().get(i).getY();
                        hiddenCoinSectionScreen.remove(hiddenCoinSectionScreen.getObjectsInThisSection().get(i));
                        EmptyBlockInAir newEmptyBlockInAir = new EmptyBlockInAir(x, y);
                        hiddenCoinSectionScreen.getObjectsInThisSection().set(i, newEmptyBlockInAir);
                        hiddenCoinSectionScreen.add(newEmptyBlockInAir, Integer.valueOf(1));
                    }
                    i = 0;
                    continue;
                }

                break;
            }
        }
    }

    public void intersectWithItems() {

        for (int i = 0; i < hiddenCoinSectionScreen.getItemsInThisSection().size(); i++) {
            int marioWidth = hiddenCoinSectionScreen.activeMario.get(0).getWidth();
            int marioHeight = hiddenCoinSectionScreen.activeMario.get(0).getHeight();
            int objectWidth = hiddenCoinSectionScreen.getItemsInThisSection().get(i).getWidth();
            int objectHeight = hiddenCoinSectionScreen.getItemsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = hiddenCoinSectionScreen.activeMario.get(0).getX();
            int marioY = hiddenCoinSectionScreen.activeMario.get(0).getY();
            int objectX = hiddenCoinSectionScreen.getItemsInThisSection().get(i).getX();
            int objectY = hiddenCoinSectionScreen.getItemsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || marioIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                if (!hiddenCoinSectionScreen.getItemsInThisSection().get(i).isItemCatch()) {
                    if (hiddenCoinSectionScreen.getItemsInThisSection().get(i) instanceof Coin) {
                        hiddenCoinSectionScreen.getGameData().thisGameCoin++;
                    }else {
                        powerUp.allocatePowerUpInHiddenCoinSection();
                    }
                    hiddenCoinSectionScreen.getGameData().thisGameScore += hiddenCoinSectionScreen.getItemsInThisSection().get(i).getScoreItemAdds();

                }
                hiddenCoinSectionScreen.getItemsInThisSection().get(i).setItemCatch(true);
            }

        }

    }

    public void intersectShot() {
        for (int i = 0; i < hiddenCoinSectionScreen.getWeaponsInThisSection().size(); i++) {
            if (hiddenCoinSectionScreen.getWeaponsInThisSection().get(i) instanceof Arrow) {
                arrowIntersection(hiddenCoinSectionScreen.getWeaponsInThisSection().get(i));
            } else if (hiddenCoinSectionScreen.getWeaponsInThisSection().get(i) instanceof Sword) {
                swordIntersection(hiddenCoinSectionScreen.getWeaponsInThisSection().get(i));
            }
        }
    }

    public void arrowIntersection(MarioWeapon arrow) {

        if (arrow.getX() >= arrow.getXEndPosition()) {
            hiddenCoinSectionScreen.remove(arrow);
            hiddenCoinSectionScreen.getWeaponsInThisSection().remove(arrow);
            return;
        }

        // Arrow Hits An Object:
        for (int i = 0; i < hiddenCoinSectionScreen.getObjectsInThisSection().size(); i++) {
            int arrowWidth = arrow.getWidth();
            int arrowHeight = arrow.getHeight()+10;
            int objectWidth = hiddenCoinSectionScreen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = hiddenCoinSectionScreen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || arrowWidth <= 0 || arrowHeight <= 0) {
                continue;
            }
            int arrowX = arrow.getX();
            int arrowY = arrow.getY();
            int objectX = hiddenCoinSectionScreen.getObjectsInThisSection().get(i).getX();
            int objectY = hiddenCoinSectionScreen.getObjectsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            arrowWidth += arrowX;
            arrowHeight += arrowY;

            //      overflow || bombIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > arrowX) &&
                    (objectHeight < objectY || objectHeight > arrowY) &&
                    (arrowWidth < arrowX || arrowWidth > objectX) &&
                    (arrowHeight < arrowY || arrowHeight > objectY)) {

                hiddenCoinSectionScreen.remove(arrow);
                hiddenCoinSectionScreen.getWeaponsInThisSection().remove(arrow);
                return;

            }
        }

    }

    public void swordIntersection(MarioWeapon sword) {

        if (sword.getMarioVelocity() >= 0) {// Sword Throwed in positive direction:
            if (sword.getX() <= sword.getXStartPosition()) {// sword come back to mario
                hiddenCoinSectionScreen.remove(sword);
                hiddenCoinSectionScreen.getWeaponsInThisSection().remove(sword);
                return;
            }
        } else {
            if (sword.getX() >= sword.getXStartPosition() && sword.getXStartPosition() != 0) {// sword come back to mario
                hiddenCoinSectionScreen.remove(sword);
                hiddenCoinSectionScreen.getWeaponsInThisSection().remove(sword);
                return;
            }
        }

        // Sword Hits An Object:
        for (int i = 0; i < hiddenCoinSectionScreen.getObjectsInThisSection().size(); i++) {
            int arrowWidth = sword.getWidth();
            int arrowHeight = sword.getHeight() + 10;
            int objectWidth = hiddenCoinSectionScreen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = hiddenCoinSectionScreen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || arrowWidth <= 0 || arrowHeight <= 0) {
                continue;
            }
            int arrowX = sword.getX();
            int arrowY = sword.getY();
            int objectX = hiddenCoinSectionScreen.getObjectsInThisSection().get(i).getX();
            int objectY = hiddenCoinSectionScreen.getObjectsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            arrowWidth += arrowX;
            arrowHeight += arrowY;

            //      overflow || bombIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > arrowX) &&
                    (objectHeight < objectY || objectHeight > arrowY) &&
                    (arrowWidth < arrowX || arrowWidth > objectX) &&
                    (arrowHeight < arrowY || arrowHeight > objectY)) {

                hiddenCoinSectionScreen.remove(sword);
                hiddenCoinSectionScreen.getWeaponsInThisSection().remove(sword);
                return;

            }
        }

    }

    public void generateRandomItem (PrizeInAir prizeInAir){

        Random random = new Random();
        int itemChooseNumber = random.nextInt(11);
        int x = prizeInAir.getX() + 10;
        int y = prizeInAir.getY() - 150;
        if (itemChooseNumber <= 5) {
            prizeInAir.setItemInPrizeInAir(new FlowerItem(x, y));
        } else if (itemChooseNumber <= 7) {
            prizeInAir.setItemInPrizeInAir(new Mushroom(x, y));
        } else {
            prizeInAir.setItemInPrizeInAir(new Star(x, y));
        }

        hiddenCoinSectionScreen.getItemsInThisSection().add(prizeInAir.getItemInPrizeInAir());
        hiddenCoinSectionScreen.add(prizeInAir.getItemInPrizeInAir(), Integer.valueOf(1));

    }

    public void refreshIntersectsBooleans () {
        marioHitsRightOfTheObject = false;
        marioHitsLeftOfTheObject = false;
        marioHitsDownOfTheObject = false;
        marioHitsUpOfTheObject = false;
    }

    public boolean isMarioHitsLeftOfTheObject() {
        return marioHitsLeftOfTheObject;
    }

    public void setMarioHitsLeftOfTheObject(boolean marioHitsLeftOfTheObject) {
        this.marioHitsLeftOfTheObject = marioHitsLeftOfTheObject;
    }

    public boolean isMarioHitsRightOfTheObject() {
        return marioHitsRightOfTheObject;
    }

    public void setMarioHitsRightOfTheObject(boolean marioHitsRightOfTheObject) {
        this.marioHitsRightOfTheObject = marioHitsRightOfTheObject;
    }

    public boolean isMarioHitsUpOfTheObject() {
        return marioHitsUpOfTheObject;
    }

    public void setMarioHitsUpOfTheObject(boolean marioHitsUpOfTheObject) {
        this.marioHitsUpOfTheObject = marioHitsUpOfTheObject;
    }

    public boolean isMarioHitsDownOfTheObject() {
        return marioHitsDownOfTheObject;
    }

    public void setMarioHitsDownOfTheObject(boolean marioHitsDownOfTheObject) {
        this.marioHitsDownOfTheObject = marioHitsDownOfTheObject;
    }

    public boolean isMarioHitsAnObject() {
        return marioHitsAnObject;
    }

    public void setMarioHitsAnObject(boolean marioHitsAnObject) {
        this.marioHitsAnObject = marioHitsAnObject;
    }

    public PowerUp getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }
}
