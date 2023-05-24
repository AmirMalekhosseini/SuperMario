package Model;

import Graphic.*;

import java.util.Random;

public class IntersectInHiddenEnemySection {

    GameScreenFrame gameScreenFrame;
    HiddenEnemySectionScreen hiddenEnemySectionScreen;
    protected boolean marioHitsLeftOfTheObject;
    protected boolean marioHitsRightOfTheObject;
    protected boolean marioHitsUpOfTheObject;
    protected boolean marioHitsDownOfTheObject;
    protected boolean marioHitsAnObject;
    protected boolean marioHitsFullOfCoinBlockInAir;
    protected boolean marioHitsTurtle;

    public IntersectInHiddenEnemySection(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
        this.hiddenEnemySectionScreen = gameScreenFrame.getHiddenEnemySectionScreen();
    }

    public IntersectInHiddenEnemySection() {

    }

    public void intersectWithObjects() {

        for (int i = 0; i < hiddenEnemySectionScreen.getObjectsInThisSection().size(); i++) {
            int marioWidth = hiddenEnemySectionScreen.activeMario.get(0).getWidth();
            int marioHeight = hiddenEnemySectionScreen.activeMario.get(0).getHeight();
            int objectWidth = hiddenEnemySectionScreen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = hiddenEnemySectionScreen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = hiddenEnemySectionScreen.activeMario.get(0).getX();
            int marioY = hiddenEnemySectionScreen.activeMario.get(0).getY();
            int objectX = hiddenEnemySectionScreen.getObjectsInThisSection().get(i).getX();
            int objectY = hiddenEnemySectionScreen.getObjectsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersectWithObjects
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

                if (hiddenEnemySectionScreen.getObjectsInThisSection().get(i) instanceof PrizeInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    if (((PrizeInAir) hiddenEnemySectionScreen.getObjectsInThisSection().get(i)).isItemCatch()) {
                        ((PrizeInAir) hiddenEnemySectionScreen.getObjectsInThisSection().get(i)).setItemCatch(true);
                        generateRandomItem((PrizeInAir) hiddenEnemySectionScreen.getObjectsInThisSection().get(i));
                        marioHitsAnObject = true;
                    }
                    continue;
                } else if (hiddenEnemySectionScreen.getObjectsInThisSection().get(i) instanceof SimpleBlockInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    hiddenEnemySectionScreen.remove(hiddenEnemySectionScreen.getObjectsInThisSection().get(i));
                    hiddenEnemySectionScreen.getObjectsInThisSection().remove(hiddenEnemySectionScreen.getObjectsInThisSection().get(i));
                    gameScreenFrame.getGameData().thisGameScore++;
                    marioHitsAnObject = true;
                    i = 0;
                    continue;
                } else if (hiddenEnemySectionScreen.getObjectsInThisSection().get(i) instanceof OneCoinBlockInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    int x = hiddenEnemySectionScreen.getObjectsInThisSection().get(i).getX();
                    int y = hiddenEnemySectionScreen.getObjectsInThisSection().get(i).getY() - 50;
                    Coin newCoin = new Coin(x, y);
                    ((OneCoinBlockInAir) hiddenEnemySectionScreen.getObjectsInThisSection().get(i)).setCoinInBlockInAir(newCoin);
                    hiddenEnemySectionScreen.add(newCoin, Integer.valueOf(1));
                    hiddenEnemySectionScreen.getItemsInThisSection().add(newCoin);
                    hiddenEnemySectionScreen.remove(hiddenEnemySectionScreen.getObjectsInThisSection().get(i));
                    SimpleBlockInAir newSimpleBlockInAir = new SimpleBlockInAir(x, y + 50);
                    hiddenEnemySectionScreen.getObjectsInThisSection().set(i, newSimpleBlockInAir);
                    hiddenEnemySectionScreen.add(newSimpleBlockInAir, Integer.valueOf(1));
                    gameScreenFrame.getGameData().thisGameScore++;
                    marioHitsAnObject = true;
                    i = 0;
                    continue;
                } else if (hiddenEnemySectionScreen.getObjectsInThisSection().get(i) instanceof FullOfCoinBlockInAir && marioHitsDownOfTheObject
                        && !marioHitsAnObject && !marioHitsFullOfCoinBlockInAir) {
                    ((FullOfCoinBlockInAir) hiddenEnemySectionScreen.getObjectsInThisSection().get(i)).hitCounter++;
                    gameScreenFrame.getGameData().thisGameCoin++;
                    marioHitsFullOfCoinBlockInAir = true;

                    if (((FullOfCoinBlockInAir) hiddenEnemySectionScreen.getObjectsInThisSection().get(i)).getHitCounter() == 5) {
                        int x = hiddenEnemySectionScreen.getObjectsInThisSection().get(i).getX();
                        int y = hiddenEnemySectionScreen.getObjectsInThisSection().get(i).getY();
                        hiddenEnemySectionScreen.remove(hiddenEnemySectionScreen.getObjectsInThisSection().get(i));
                        EmptyBlockInAir newEmptyBlockInAir = new EmptyBlockInAir(x, y);
                        hiddenEnemySectionScreen.getObjectsInThisSection().set(i, newEmptyBlockInAir);
                        hiddenEnemySectionScreen.add(newEmptyBlockInAir, Integer.valueOf(1));
                    }
                    i = 0;
                    continue;
                }

                break;
            }
        }
    }

    public void intersectWithItems() {

        for (int i = 0; i < hiddenEnemySectionScreen.getItemsInThisSection().size(); i++) {
            int marioWidth = hiddenEnemySectionScreen.activeMario.get(0).getWidth();
            int marioHeight = hiddenEnemySectionScreen.activeMario.get(0).getHeight();
            int objectWidth = hiddenEnemySectionScreen.getItemsInThisSection().get(i).getWidth();
            int objectHeight = hiddenEnemySectionScreen.getItemsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = hiddenEnemySectionScreen.activeMario.get(0).getX();
            int marioY = hiddenEnemySectionScreen.activeMario.get(0).getY();
            int objectX = hiddenEnemySectionScreen.getItemsInThisSection().get(i).getX();
            int objectY = hiddenEnemySectionScreen.getItemsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                if (!hiddenEnemySectionScreen.getItemsInThisSection().get(i).isItemCatch()) {
                    if (hiddenEnemySectionScreen.getItemsInThisSection().get(i) instanceof Coin) {
                        hiddenEnemySectionScreen.getGameData().thisGameCoin++;
                    }
                    hiddenEnemySectionScreen.getGameData().thisGameScore += hiddenEnemySectionScreen.getItemsInThisSection().get(i).getScoreItemAdds();

                }
                hiddenEnemySectionScreen.getItemsInThisSection().get(i).setItemCatch(true);
            }

        }

    }

    public boolean intersectWithEnemies() {

        for (int i = 0; i < hiddenEnemySectionScreen.getEnemiesInThisSection().size(); i++) {
            int marioWidth = hiddenEnemySectionScreen.activeMario.get(0).getWidth();
            int marioHeight = hiddenEnemySectionScreen.activeMario.get(0).getHeight();
            int objectWidth = hiddenEnemySectionScreen.getEnemiesInThisSection().get(i).getWidth();
            int objectHeight = hiddenEnemySectionScreen.getEnemiesInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = hiddenEnemySectionScreen.activeMario.get(0).getX();
            int marioY = hiddenEnemySectionScreen.activeMario.get(0).getY();
            int objectX = hiddenEnemySectionScreen.getEnemiesInThisSection().get(i).getX();
            int objectY = hiddenEnemySectionScreen.getEnemiesInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                if ((marioWidth >= objectX || objectWidth >= marioX) && marioHeight <= objectY + 30) {// Hit up of Object and kill Enemy
                    if (hiddenEnemySectionScreen.getEnemiesInThisSection().get(i) instanceof Goompa) {
                        hiddenEnemySectionScreen.remove(hiddenEnemySectionScreen.getEnemiesInThisSection().get(i));
                        hiddenEnemySectionScreen.getEnemiesInThisSection().remove(i);
                        gameScreenFrame.getGameData().thisGameCoin += 3;
                        gameScreenFrame.getGameData().thisGameScore++;
                        return false;
                    }

                    if (hiddenEnemySectionScreen.getEnemiesInThisSection().get(i) instanceof Turtle && !marioHitsTurtle) {
                        ((Turtle) hiddenEnemySectionScreen.getEnemiesInThisSection().get(i)).hitCounter++;
                        ((Turtle) hiddenEnemySectionScreen.getEnemiesInThisSection().get(i)).setTurtleHit(true);
                        if (((Turtle) hiddenEnemySectionScreen.getEnemiesInThisSection().get(i)).hitCounter >= 2) {
                            hiddenEnemySectionScreen.remove(hiddenEnemySectionScreen.getEnemiesInThisSection().get(i));
                            hiddenEnemySectionScreen.getEnemiesInThisSection().remove(i);
                            gameScreenFrame.getGameData().thisGameCoin += 3;
                            gameScreenFrame.getGameData().thisGameScore += 2;
                        }

                        int x = hiddenEnemySectionScreen.getEnemiesInThisSection().get(i).getX() + 500;
                        hiddenEnemySectionScreen.getEnemiesInThisSection().get(i).setX(x);
                        marioHitsTurtle = true;
                        return false;
                    }
                    return false;
                }
                hiddenEnemySectionScreen.getGameData().userHeartValue--;
                return true;
            }

        }
        return false;
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

        hiddenEnemySectionScreen.getItemsInThisSection().add(prizeInAir.getItemInPrizeInAir());
        hiddenEnemySectionScreen.add(prizeInAir.getItemInPrizeInAir(), Integer.valueOf(1));

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

    public boolean isMarioHitsFullOfCoinBlockInAir() {
        return marioHitsFullOfCoinBlockInAir;
    }

    public void setMarioHitsFullOfCoinBlockInAir(boolean marioHitsFullOfCoinBlockInAir) {
        this.marioHitsFullOfCoinBlockInAir = marioHitsFullOfCoinBlockInAir;
    }

    public boolean isMarioHitsTurtle() {
        return marioHitsTurtle;
    }

    public void setMarioHitsTurtle(boolean marioHitsTurtle) {
        this.marioHitsTurtle = marioHitsTurtle;
    }
}
