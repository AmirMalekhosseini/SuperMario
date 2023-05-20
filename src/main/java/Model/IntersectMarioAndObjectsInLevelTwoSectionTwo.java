package Model;

import Graphic.*;

import java.util.Random;

public class IntersectMarioAndObjectsInLevelTwoSectionTwo {

    GameScreenFrame gameScreenFrame;
    LevelTwoSectionTwoScreen levelTwoSectionTwoScreen;
    protected boolean marioHitsLeftOfTheObject;
    protected boolean marioHitsRightOfTheObject;
    protected boolean marioHitsUpOfTheObject;
    protected boolean marioHitsDownOfTheObject;

    public IntersectMarioAndObjectsInLevelTwoSectionTwo(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
        this.levelTwoSectionTwoScreen = gameScreenFrame.getLevelTwoSectionTwoScreen();
    }

    public IntersectMarioAndObjectsInLevelTwoSectionTwo() {

    }

    public void intersectWithObjects() {

        for (int i = 0; i < levelTwoSectionTwoScreen.getObjectsInThisSection().size(); i++) {
            int marioWidth = levelTwoSectionTwoScreen.activeMario.get(0).getWidth();
            int marioHeight = levelTwoSectionTwoScreen.activeMario.get(0).getHeight();
            int objectWidth = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelTwoSectionTwoScreen.activeMario.get(0).getX();
            int marioY = levelTwoSectionTwoScreen.activeMario.get(0).getY();
            int objectX = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getX();
            int objectY = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getY();
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


                }
                else {
                    marioHitsUpOfTheObject = false;
                }


                if ((marioWidth >= objectX || objectWidth >= marioX) && objectHeight <= marioY + 20) {// Hit down of Object

                    if (!marioHitsDownOfTheObject) {
                        marioHitsDownOfTheObject = true;
                    }

                }
                else{
                    marioHitsDownOfTheObject = false;
                }

                if ((objectHeight > marioY || marioHeight > objectY) && marioWidth <= objectX + 20 && !marioHitsDownOfTheObject && !marioHitsUpOfTheObject) {// Hit left of Object

                    marioHitsLeftOfTheObject = true;

                }  if ((objectHeight > marioY || marioHeight > objectY) && objectWidth <= marioX + 20 && !marioHitsDownOfTheObject && !marioHitsUpOfTheObject) {// Hit right of Object

                    marioHitsRightOfTheObject = true;

                }

                if (levelTwoSectionTwoScreen.getObjectsInThisSection().get(i) instanceof PrizeInAir && marioHitsDownOfTheObject) {
                    if (((PrizeInAir) levelTwoSectionTwoScreen.getObjectsInThisSection().get(i)).isItemCatch()) {
                        ((PrizeInAir) levelTwoSectionTwoScreen.getObjectsInThisSection().get(i)).setItemCatch(true);
                        generateRandomItem((PrizeInAir) levelTwoSectionTwoScreen.getObjectsInThisSection().get(i));
                    }
                }

                break;
            }
        }
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

        levelTwoSectionTwoScreen.itemsInThisSection.add(prizeInAir.getItemInPrizeInAir());
        levelTwoSectionTwoScreen.add(prizeInAir.getItemInPrizeInAir(), Integer.valueOf(1));

    }

    public void intersectWithItems() {

        for (int i = 0; i < levelTwoSectionTwoScreen.getItemsInThisSection().size(); i++) {
            int marioWidth = levelTwoSectionTwoScreen.activeMario.get(0).getWidth();
            int marioHeight = levelTwoSectionTwoScreen.activeMario.get(0).getHeight();
            int objectWidth = levelTwoSectionTwoScreen.getItemsInThisSection().get(i).getWidth();
            int objectHeight = levelTwoSectionTwoScreen.getItemsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelTwoSectionTwoScreen.activeMario.get(0).getX();
            int marioY = levelTwoSectionTwoScreen.activeMario.get(0).getY();
            int objectX = levelTwoSectionTwoScreen.getItemsInThisSection().get(i).getX();
            int objectY = levelTwoSectionTwoScreen.getItemsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                if (!levelTwoSectionTwoScreen.getItemsInThisSection().get(i).isItemCatch()) {
                    if (levelTwoSectionTwoScreen.getItemsInThisSection().get(i) instanceof Coin) {
                        levelTwoSectionTwoScreen.getGameData().thisGameCoin++;
                    }
                    levelTwoSectionTwoScreen.getGameData().thisGameScore += levelTwoSectionTwoScreen.getItemsInThisSection().get(i).getScoreItemAdds();

                }
                levelTwoSectionTwoScreen.getItemsInThisSection().get(i).setItemCatch(true);
            }

        }

    }

    public boolean intersectWithEnemies() {

        for (int i = 0; i < levelTwoSectionTwoScreen.getEnemiesInThisSection().size(); i++) {
            int marioWidth = levelTwoSectionTwoScreen.activeMario.get(0).getWidth();
            int marioHeight = levelTwoSectionTwoScreen.activeMario.get(0).getHeight();
            int objectWidth = levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).getWidth();
            int objectHeight = levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelTwoSectionTwoScreen.activeMario.get(0).getX();
            int marioY = levelTwoSectionTwoScreen.activeMario.get(0).getY();
            int objectX = levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).getX();
            int objectY = levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)){
                levelTwoSectionTwoScreen.getGameData().userHeartValue--;
                return true;
            }

        }
        return false;
    }

    public boolean intersectWithEmptyGround() {

        for (int i = 0; i < levelTwoSectionTwoScreen.getEmptySpaceInGroundsInThisSection().size(); i++) {
            int marioWidth = levelTwoSectionTwoScreen.activeMario.get(0).getWidth();
            int marioHeight = levelTwoSectionTwoScreen.activeMario.get(0).getHeight();
            int objectWidth = levelTwoSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getWidth();
            int objectHeight = levelTwoSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelTwoSectionTwoScreen.activeMario.get(0).getX();
            int marioY = levelTwoSectionTwoScreen.activeMario.get(0).getY();
            int objectX = levelTwoSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getX();
            int objectY = levelTwoSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)){
                levelTwoSectionTwoScreen.getGameData().userHeartValue--;
                return true;
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

    public LevelTwoSectionTwoScreen getLevelTwoSectionTwoScreen() {
        return levelTwoSectionTwoScreen;
    }

    public void setLevelTwoSectionTwoScreen(LevelTwoSectionTwoScreen levelTwoSectionTwoScreen) {
        this.levelTwoSectionTwoScreen = levelTwoSectionTwoScreen;
    }
}
