package Model;

import Graphic.*;

import java.util.Random;

public class IntersectMarioAndObjectsInLevelOneSectionTwo {

    GameScreenFrame gameScreenFrame;
    LevelOneSectionTwoScreen levelOneSectionTwoScreen;
    protected boolean marioHitsLeftOfTheObject;
    protected boolean marioHitsRightOfTheObject;
    protected boolean marioHitsUpOfTheObject;
    protected boolean marioHitsDownOfTheObject;
    protected boolean marioHitsAnObject;
    protected boolean marioHitsFullOfCoinBlockInAir;

    public IntersectMarioAndObjectsInLevelOneSectionTwo(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
        this.levelOneSectionTwoScreen = gameScreenFrame.getLevelOneSectionTwoScreen();
    }

    public IntersectMarioAndObjectsInLevelOneSectionTwo() {

    }

    public void intersectWithObjects() {

        for (int i = 0; i < levelOneSectionTwoScreen.getObjectsInThisSection().size(); i++) {
            int marioWidth = levelOneSectionTwoScreen.activeMario.get(0).getWidth();
            int marioHeight = levelOneSectionTwoScreen.activeMario.get(0).getHeight();
            int objectWidth = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelOneSectionTwoScreen.activeMario.get(0).getX();
            int marioY = levelOneSectionTwoScreen.activeMario.get(0).getY();
            int objectX = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getX();
            int objectY = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getY();
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

                if (levelOneSectionTwoScreen.getObjectsInThisSection().get(i) instanceof PrizeInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    if (((PrizeInAir) levelOneSectionTwoScreen.getObjectsInThisSection().get(i)).isItemCatch()) {
                        ((PrizeInAir) levelOneSectionTwoScreen.getObjectsInThisSection().get(i)).setItemCatch(true);
                        generateRandomItem((PrizeInAir) levelOneSectionTwoScreen.getObjectsInThisSection().get(i));
                        marioHitsAnObject = true;
                    }
                    continue;
                } else if (levelOneSectionTwoScreen.getObjectsInThisSection().get(i) instanceof SimpleBlockInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    levelOneSectionTwoScreen.remove(levelOneSectionTwoScreen.getObjectsInThisSection().get(i));
                    levelOneSectionTwoScreen.getObjectsInThisSection().remove(levelOneSectionTwoScreen.getObjectsInThisSection().get(i));
                    gameScreenFrame.getGameData().thisGameScore++;
                    marioHitsAnObject = true;
                    i = 0;
                    continue;
                } else if (levelOneSectionTwoScreen.getObjectsInThisSection().get(i) instanceof OneCoinBlockInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    int x = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getX();
                    int y = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getY() - 50;
                    Coin newCoin = new Coin(x, y);
                    ((OneCoinBlockInAir) levelOneSectionTwoScreen.getObjectsInThisSection().get(i)).setCoinInBlockInAir(newCoin);
                    levelOneSectionTwoScreen.add(newCoin, Integer.valueOf(1));
                    levelOneSectionTwoScreen.getItemsInThisSection().add(newCoin);
                    levelOneSectionTwoScreen.remove(levelOneSectionTwoScreen.getObjectsInThisSection().get(i));
                    SimpleBlockInAir newSimpleBlockInAir = new SimpleBlockInAir(x, y + 50);
                    levelOneSectionTwoScreen.getObjectsInThisSection().set(i, newSimpleBlockInAir);
                    levelOneSectionTwoScreen.add(newSimpleBlockInAir, Integer.valueOf(1));
                    gameScreenFrame.getGameData().thisGameScore++;
                    marioHitsAnObject = true;
                    i = 0;
                    continue;
                } else if (levelOneSectionTwoScreen.getObjectsInThisSection().get(i) instanceof FullOfCoinBlockInAir && marioHitsDownOfTheObject
                        && !marioHitsAnObject && !marioHitsFullOfCoinBlockInAir) {
                    ((FullOfCoinBlockInAir) levelOneSectionTwoScreen.getObjectsInThisSection().get(i)).hitCounter++;
                    gameScreenFrame.getGameData().thisGameCoin++;
                    marioHitsFullOfCoinBlockInAir = true;

                    if (((FullOfCoinBlockInAir) levelOneSectionTwoScreen.getObjectsInThisSection().get(i)).getHitCounter() == 5) {
                        int x = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getX();
                        int y = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getY();
                        levelOneSectionTwoScreen.remove(levelOneSectionTwoScreen.getObjectsInThisSection().get(i));
                        EmptyBlockInAir newEmptyBlockInAir = new EmptyBlockInAir(x, y);
                        levelOneSectionTwoScreen.getObjectsInThisSection().set(i, newEmptyBlockInAir);
                        levelOneSectionTwoScreen.add(newEmptyBlockInAir, Integer.valueOf(1));
                    }
                    i = 0;
                    continue;
                }

                break;
            }
        }
    }


    public void intersectWithItems() {

        for (int i = 0; i < levelOneSectionTwoScreen.getItemsInThisSection().size(); i++) {
            int marioWidth = levelOneSectionTwoScreen.activeMario.get(0).getWidth();
            int marioHeight = levelOneSectionTwoScreen.activeMario.get(0).getHeight();
            int objectWidth = levelOneSectionTwoScreen.getItemsInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.getItemsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelOneSectionTwoScreen.activeMario.get(0).getX();
            int marioY = levelOneSectionTwoScreen.activeMario.get(0).getY();
            int objectX = levelOneSectionTwoScreen.getItemsInThisSection().get(i).getX();
            int objectY = levelOneSectionTwoScreen.getItemsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                if (!levelOneSectionTwoScreen.getItemsInThisSection().get(i).isItemCatch()) {
                    if (levelOneSectionTwoScreen.getItemsInThisSection().get(i) instanceof Coin) {
                        levelOneSectionTwoScreen.getGameData().thisGameCoin++;
                    }
                    levelOneSectionTwoScreen.getGameData().thisGameScore += levelOneSectionTwoScreen.getItemsInThisSection().get(i).getScoreItemAdds();

                }
                levelOneSectionTwoScreen.getItemsInThisSection().get(i).setItemCatch(true);
            }

        }

    }

    public boolean intersectWithEnemies() {
        for (int i = 0; i < levelOneSectionTwoScreen.getEnemiesInThisSection().size(); i++) {
            int marioWidth = levelOneSectionTwoScreen.activeMario.get(0).getWidth();
            int marioHeight = levelOneSectionTwoScreen.activeMario.get(0).getHeight();
            int objectWidth = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelOneSectionTwoScreen.activeMario.get(0).getX();
            int marioY = levelOneSectionTwoScreen.activeMario.get(0).getY();
            int objectX = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getX();
            int objectY = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                levelOneSectionTwoScreen.getGameData().userHeartValue--;
                return true;
            }

        }
        return false;
    }

    public boolean intersectWithEmptyGround() {
        for (int i = 0; i < levelOneSectionTwoScreen.getEmptySpaceInGroundsInThisSection().size(); i++) {
            int marioWidth = levelOneSectionTwoScreen.activeMario.get(0).getWidth();
            int marioHeight = levelOneSectionTwoScreen.activeMario.get(0).getHeight();
            int objectWidth = levelOneSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelOneSectionTwoScreen.activeMario.get(0).getX();
            int marioY = levelOneSectionTwoScreen.activeMario.get(0).getY();
            int objectX = levelOneSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getX();
            int objectY = levelOneSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                levelOneSectionTwoScreen.getGameData().userHeartValue--;
                return true;
            }

        }
        return false;
    }

    public void generateRandomItem(PrizeInAir prizeInAir) {

        Random random = new Random();
        int itemChooseNumber = random.nextInt(11);
        int x = prizeInAir.getX() + 10;
        int y = prizeInAir.getY() - 50;
        if (itemChooseNumber <= 5) {
            prizeInAir.setItemInPrizeInAir(new FlowerItem(x, y));
        } else if (itemChooseNumber <= 7) {
            prizeInAir.setItemInPrizeInAir(new Mushroom(x, y));
        } else{
            prizeInAir.setItemInPrizeInAir(new Star(x, y));
        }

        levelOneSectionTwoScreen.getItemsInThisSection().add(prizeInAir.getItemInPrizeInAir());
        levelOneSectionTwoScreen.add(prizeInAir.getItemInPrizeInAir(), Integer.valueOf(1));

    }


    public void refreshIntersectsBooleans() {
        marioHitsRightOfTheObject = false;
        marioHitsLeftOfTheObject = false;
        marioHitsDownOfTheObject = false;
        marioHitsUpOfTheObject = false;
    }

    public boolean isMarioHitsFullOfCoinBlockInAir() {
        return marioHitsFullOfCoinBlockInAir;
    }

    public void setMarioHitsFullOfCoinBlockInAir(boolean marioHitsFullOfCoinBlockInAir) {
        this.marioHitsFullOfCoinBlockInAir = marioHitsFullOfCoinBlockInAir;
    }

    public boolean isMarioHitsAnObject() {
        return marioHitsAnObject;
    }

    public void setMarioHitsAnObject(boolean marioHitsAnObject) {
        this.marioHitsAnObject = marioHitsAnObject;
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

    public GameScreenFrame getGameScreenFrame() {
        return gameScreenFrame;
    }

    public void setGameScreenFrame(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
    }

    public LevelOneSectionTwoScreen getLevelOneSectionTwoScreen() {
        return levelOneSectionTwoScreen;
    }

    public void setLevelOneSectionTwoScreen(LevelOneSectionTwoScreen levelOneSectionTwoScreen) {
        this.levelOneSectionTwoScreen = levelOneSectionTwoScreen;
    }
}
