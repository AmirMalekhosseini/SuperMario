package Model;

import Graphic.*;

import java.util.Random;

public class IntersectInLevelTwoSectionOne {

    GameScreenFrame gameScreenFrame;
    LevelTwoSectionOneScreen levelTwoSectionOneScreen;
    protected boolean marioHitsLeftOfTheObject;
    protected boolean marioHitsRightOfTheObject;
    protected boolean marioHitsUpOfTheObject;
    protected boolean marioHitsDownOfTheObject;
    protected boolean marioHitsAnObject;
    protected boolean marioHitsFullOfCoinBlockInAir;

    public IntersectInLevelTwoSectionOne(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
        this.levelTwoSectionOneScreen = gameScreenFrame.getLevelTwoSectionOneScreen();
    }

    public IntersectInLevelTwoSectionOne() {

    }

    public void intersectWithObjects() {

        for (int i = 0; i < levelTwoSectionOneScreen.getObjectsInThisSection().size(); i++) {
            int marioWidth = levelTwoSectionOneScreen.activeMario.get(0).getWidth();
            int marioHeight = levelTwoSectionOneScreen.activeMario.get(0).getHeight();
            int objectWidth = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelTwoSectionOneScreen.activeMario.get(0).getX();
            int marioY = levelTwoSectionOneScreen.activeMario.get(0).getY();
            int objectX = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getX();
            int objectY = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getY();
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

                if (levelTwoSectionOneScreen.getObjectsInThisSection().get(i) instanceof PrizeInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    if (((PrizeInAir) levelTwoSectionOneScreen.getObjectsInThisSection().get(i)).isItemCatch()) {
                        ((PrizeInAir) levelTwoSectionOneScreen.getObjectsInThisSection().get(i)).setItemCatch(true);
                        generateRandomItem((PrizeInAir) levelTwoSectionOneScreen.getObjectsInThisSection().get(i));
                        marioHitsAnObject = true;
                    }
                    continue;
                } else if (levelTwoSectionOneScreen.getObjectsInThisSection().get(i) instanceof SimpleBlockInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    levelTwoSectionOneScreen.remove(levelTwoSectionOneScreen.getObjectsInThisSection().get(i));
                    levelTwoSectionOneScreen.getObjectsInThisSection().remove(levelTwoSectionOneScreen.getObjectsInThisSection().get(i));
                    gameScreenFrame.getGameData().thisGameScore++;
                    marioHitsAnObject = true;
                    i = 0;
                    continue;
                } else if (levelTwoSectionOneScreen.getObjectsInThisSection().get(i) instanceof OneCoinBlockInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    int x = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getX();
                    int y = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getY() - 50;
                    Coin newCoin = new Coin(x, y);
                    ((OneCoinBlockInAir) levelTwoSectionOneScreen.getObjectsInThisSection().get(i)).setCoinInBlockInAir(newCoin);
                    levelTwoSectionOneScreen.add(newCoin, Integer.valueOf(1));
                    levelTwoSectionOneScreen.getItemsInThisSection().add(newCoin);
                    levelTwoSectionOneScreen.remove(levelTwoSectionOneScreen.getObjectsInThisSection().get(i));
                    SimpleBlockInAir newSimpleBlockInAir = new SimpleBlockInAir(x, y + 50);
                    levelTwoSectionOneScreen.getObjectsInThisSection().set(i, newSimpleBlockInAir);
                    levelTwoSectionOneScreen.add(newSimpleBlockInAir, Integer.valueOf(1));
                    gameScreenFrame.getGameData().thisGameScore++;
                    marioHitsAnObject = true;
                    i = 0;
                    continue;
                } else if (levelTwoSectionOneScreen.getObjectsInThisSection().get(i) instanceof FullOfCoinBlockInAir && marioHitsDownOfTheObject
                        && !marioHitsAnObject && !marioHitsFullOfCoinBlockInAir) {
                    ((FullOfCoinBlockInAir) levelTwoSectionOneScreen.getObjectsInThisSection().get(i)).hitCounter++;
                    gameScreenFrame.getGameData().thisGameCoin++;
                    marioHitsFullOfCoinBlockInAir = true;

                    if (((FullOfCoinBlockInAir) levelTwoSectionOneScreen.getObjectsInThisSection().get(i)).getHitCounter() == 5) {
                        int x = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getX();
                        int y = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getY();
                        levelTwoSectionOneScreen.remove(levelTwoSectionOneScreen.getObjectsInThisSection().get(i));
                        EmptyBlockInAir newEmptyBlockInAir = new EmptyBlockInAir(x, y);
                        levelTwoSectionOneScreen.getObjectsInThisSection().set(i, newEmptyBlockInAir);
                        levelTwoSectionOneScreen.add(newEmptyBlockInAir, Integer.valueOf(1));
                    }
                    i = 0;
                    continue;
                }

                break;
            }
        }
    }


    public void intersectWithItems() {

        for (int i = 0; i < levelTwoSectionOneScreen.getItemsInThisSection().size(); i++) {
            int marioWidth = levelTwoSectionOneScreen.activeMario.get(0).getWidth();
            int marioHeight = levelTwoSectionOneScreen.activeMario.get(0).getHeight();
            int objectWidth = levelTwoSectionOneScreen.getItemsInThisSection().get(i).getWidth();
            int objectHeight = levelTwoSectionOneScreen.getItemsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelTwoSectionOneScreen.activeMario.get(0).getX();
            int marioY = levelTwoSectionOneScreen.activeMario.get(0).getY();
            int objectX = levelTwoSectionOneScreen.getItemsInThisSection().get(i).getX();
            int objectY = levelTwoSectionOneScreen.getItemsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                if (!levelTwoSectionOneScreen.getItemsInThisSection().get(i).isItemCatch()) {
                    if (levelTwoSectionOneScreen.getItemsInThisSection().get(i) instanceof Coin) {
                        levelTwoSectionOneScreen.getGameData().thisGameCoin++;
                    }
                    levelTwoSectionOneScreen.getGameData().thisGameScore += levelTwoSectionOneScreen.getItemsInThisSection().get(i).getScoreItemAdds();

                }
                levelTwoSectionOneScreen.getItemsInThisSection().get(i).setItemCatch(true);
            }

        }

    }

    public boolean intersectWithEnemies() {
        for (int i = 0; i < levelTwoSectionOneScreen.getEnemiesInThisSection().size(); i++) {
            int marioWidth = levelTwoSectionOneScreen.activeMario.get(0).getWidth();
            int marioHeight = levelTwoSectionOneScreen.activeMario.get(0).getHeight();
            int objectWidth = levelTwoSectionOneScreen.getEnemiesInThisSection().get(i).getWidth();
            int objectHeight = levelTwoSectionOneScreen.getEnemiesInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelTwoSectionOneScreen.activeMario.get(0).getX();
            int marioY = levelTwoSectionOneScreen.activeMario.get(0).getY();
            int objectX = levelTwoSectionOneScreen.getEnemiesInThisSection().get(i).getX();
            int objectY = levelTwoSectionOneScreen.getEnemiesInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                levelTwoSectionOneScreen.getGameData().userHeartValue--;
                return true;
            }

        }
        return false;
    }

    public boolean intersectWithEmptyGround() {
        for (int i = 0; i < levelTwoSectionOneScreen.getEmptySpaceInGroundsInThisSection().size(); i++) {
            int marioWidth = levelTwoSectionOneScreen.activeMario.get(0).getWidth();
            int marioHeight = levelTwoSectionOneScreen.activeMario.get(0).getHeight();
            int objectWidth = levelTwoSectionOneScreen.getEmptySpaceInGroundsInThisSection().get(i).getWidth();
            int objectHeight = levelTwoSectionOneScreen.getEmptySpaceInGroundsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelTwoSectionOneScreen.activeMario.get(0).getX();
            int marioY = levelTwoSectionOneScreen.activeMario.get(0).getY();
            int objectX = levelTwoSectionOneScreen.getEmptySpaceInGroundsInThisSection().get(i).getX();
            int objectY = levelTwoSectionOneScreen.getEmptySpaceInGroundsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                levelTwoSectionOneScreen.getGameData().userHeartValue--;
                return true;
            }

        }
        return false;
    }

    public void generateRandomItem(PrizeInAir prizeInAir) {

        Random random = new Random();
        int itemChooseNumber = random.nextInt(11);
        int x = prizeInAir.getX() + 10;
        int y = prizeInAir.getY() - 150;
        if (itemChooseNumber <= 5) {
            prizeInAir.setItemInPrizeInAir(new FlowerItem(x, y));
        } else if (itemChooseNumber <= 7) {
            prizeInAir.setItemInPrizeInAir(new Mushroom(x, y));
        } else{
            prizeInAir.setItemInPrizeInAir(new Star(x, y));
        }

        levelTwoSectionOneScreen.getItemsInThisSection().add(prizeInAir.getItemInPrizeInAir());
        levelTwoSectionOneScreen.add(prizeInAir.getItemInPrizeInAir(), Integer.valueOf(1));

    }

    public boolean isItemOnTopOfAnObject(ObjectsInGame object) {

        for (int i = 0; i < levelTwoSectionOneScreen.getObjectsInThisSection().size(); i++) {
            int firstObjectWidth = object.getWidth();
            int firstObjectHeight = object.getHeight() + 15;
            int secondObjectWidth = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getWidth();
            int secondObjectHeight = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getHeight();
            if (secondObjectWidth <= 0 || secondObjectHeight <= 0 || firstObjectWidth <= 0 || firstObjectHeight <= 0) {
                continue;
            }
            int firstObjectX = object.getX();
            int firstObjectY = object.getY();
            int secondObjectX = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getX();
            int secondObjectY = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getY();
            secondObjectWidth += secondObjectX;
            secondObjectHeight += secondObjectY;
            firstObjectWidth += firstObjectX;
            firstObjectHeight += firstObjectY;

            //      overflow || intersectWithObjects
            if ((secondObjectWidth < secondObjectX || secondObjectWidth > firstObjectX) &&
                    (secondObjectHeight < secondObjectY || secondObjectHeight > firstObjectY) &&
                    (firstObjectWidth < firstObjectX || firstObjectWidth > secondObjectX) &&
                    (firstObjectHeight < firstObjectY || firstObjectHeight > secondObjectY)) {

                if ((firstObjectWidth >= secondObjectX || secondObjectWidth >= firstObjectX) && firstObjectHeight <= secondObjectY + 10) {// Hit up of Object
                    return true;
                }
            }
        }
        return false;
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

    public LevelTwoSectionOneScreen getLevelTwoSectionOneScreen() {
        return levelTwoSectionOneScreen;
    }

    public void setLevelTwoSectionOneScreen(LevelTwoSectionOneScreen levelTwoSectionOneScreen) {
        this.levelTwoSectionOneScreen = levelTwoSectionOneScreen;
    }
}
