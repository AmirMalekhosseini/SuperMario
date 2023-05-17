package Model;

import Graphic.*;
public class IntersectMarioAndObjectsInLevelOneSectionTwo {

    GameScreenFrame gameScreenFrame;
    LevelOneSectionTwoScreen levelOneSectionTwoScreen;
    protected boolean marioHitsLeftOfTheObject;
    protected boolean marioHitsRightOfTheObject;
    protected boolean marioHitsUpOfTheObject;
    protected boolean marioHitsDownOfTheObject;

    public IntersectMarioAndObjectsInLevelOneSectionTwo(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
        this.levelOneSectionTwoScreen = gameScreenFrame.getLevelOneSectionTwoScreen();
    }

    public IntersectMarioAndObjectsInLevelOneSectionTwo() {

    }

    public void intersect() {


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

            //      overflow || intersect
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {

                if (levelOneSectionTwoScreen.getObjectsInThisSection().get(i) instanceof PrizeInAir) {
                    if (!((PrizeInAir) levelOneSectionTwoScreen.getObjectsInThisSection().get(i)).isCoinCatch()) {
                        ((PrizeInAir) levelOneSectionTwoScreen.getObjectsInThisSection().get(i)).setCoinCatch(true);
                        levelOneSectionTwoScreen.getGameData().thisGameCoin++;
                    }
                }

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
                break;
            }
        }
    }


    public void intersectWithCoin() {


        for (int i = 0; i < levelOneSectionTwoScreen.getCoinsInThisSection().size(); i++) {
            int marioWidth = levelOneSectionTwoScreen.activeMario.get(0).getWidth();
            int marioHeight = levelOneSectionTwoScreen.activeMario.get(0).getHeight();
            int objectWidth = levelOneSectionTwoScreen.getCoinsInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.getCoinsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelOneSectionTwoScreen.activeMario.get(0).getX();
            int marioY = levelOneSectionTwoScreen.activeMario.get(0).getY();
            int objectX = levelOneSectionTwoScreen.getCoinsInThisSection().get(i).getX();
            int objectY = levelOneSectionTwoScreen.getCoinsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersect
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)){
                if (!levelOneSectionTwoScreen.getCoinsInThisSection().get(i).isCoinCatch()) {
                    levelOneSectionTwoScreen.getGameData().thisGameCoin++;
                    levelOneSectionTwoScreen.getGameData().thisGameScore += 10;
                }
                levelOneSectionTwoScreen.getCoinsInThisSection().get(i).setCoinCatch(true);
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

            //      overflow || intersect
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)){
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

            //      overflow || intersect
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)){
                levelOneSectionTwoScreen.getGameData().userHeartValue--;
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

    public LevelOneSectionTwoScreen getLevelOneSectionTwoScreen() {
        return levelOneSectionTwoScreen;
    }

    public void setLevelOneSectionTwoScreen(LevelOneSectionTwoScreen levelOneSectionTwoScreen) {
        this.levelOneSectionTwoScreen = levelOneSectionTwoScreen;
    }
}
