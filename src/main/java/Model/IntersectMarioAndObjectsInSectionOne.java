package Model;

import Graphic.*;
public class IntersectMarioAndObjectsInSectionOne {

    GameScreenFrame gameScreenFrame;
    LevelOneSectionOneScreen levelOneSectionOneScreen;
    protected boolean marioHitsLeftOfTheObject;
    protected boolean marioHitsRightOfTheObject;
    protected boolean marioHitsUpOfTheObject;
    protected boolean marioHitsDownOfTheObject;

    public IntersectMarioAndObjectsInSectionOne(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
        this.levelOneSectionOneScreen = gameScreenFrame.getLevelOneSectionOneScreen();
    }

    public void intersect() {


        for (int i = 0; i < levelOneSectionOneScreen.getObjectsInThisSection().size(); i++) {
            int marioWidth = levelOneSectionOneScreen.activeMario.get(0).getWidth();
            int marioHeight = levelOneSectionOneScreen.activeMario.get(0).getHeight();
            int objectWidth = levelOneSectionOneScreen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionOneScreen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelOneSectionOneScreen.activeMario.get(0).getX();
            int marioY = levelOneSectionOneScreen.activeMario.get(0).getY();
            int objectX = levelOneSectionOneScreen.getObjectsInThisSection().get(i).getX();
            int objectY = levelOneSectionOneScreen.getObjectsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersect
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {

                if (levelOneSectionOneScreen.getObjectsInThisSection().get(i) instanceof PrizeInAir) {
                    if (!((PrizeInAir) levelOneSectionOneScreen.getObjectsInThisSection().get(i)).isCoinCatch()) {
                        ((PrizeInAir) levelOneSectionOneScreen.getObjectsInThisSection().get(i)).setCoinCatch(true);
                        levelOneSectionOneScreen.getGameData().thisGameCoin++;
                    }
                }

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
                break;
            }
        }
    }


    public void intersectWithCoin() {


        for (int i = 0; i < levelOneSectionOneScreen.getCoinsInThisSection().size(); i++) {
            int marioWidth = levelOneSectionOneScreen.activeMario.get(0).getWidth();
            int marioHeight = levelOneSectionOneScreen.activeMario.get(0).getHeight();
            int objectWidth = levelOneSectionOneScreen.getCoinsInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionOneScreen.getCoinsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelOneSectionOneScreen.activeMario.get(0).getX();
            int marioY = levelOneSectionOneScreen.activeMario.get(0).getY();
            int objectX = levelOneSectionOneScreen.getCoinsInThisSection().get(i).getX();
            int objectY = levelOneSectionOneScreen.getCoinsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersect
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                if (!levelOneSectionOneScreen.getCoinsInThisSection().get(i).isCoinCatch()) {
                    levelOneSectionOneScreen.getGameData().thisGameCoin++;
                    levelOneSectionOneScreen.getGameData().thisGameScore += 10;
                }
                levelOneSectionOneScreen.getCoinsInThisSection().get(i).setCoinCatch(true);
            }

        }

    }

    public boolean intersectWithEnemies() {
        for (int i = 0; i < levelOneSectionOneScreen.getEnemiesInThisSection().size(); i++) {
            int marioWidth = levelOneSectionOneScreen.activeMario.get(0).getWidth();
            int marioHeight = levelOneSectionOneScreen.activeMario.get(0).getHeight();
            int objectWidth = levelOneSectionOneScreen.getEnemiesInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionOneScreen.getEnemiesInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelOneSectionOneScreen.activeMario.get(0).getX();
            int marioY = levelOneSectionOneScreen.activeMario.get(0).getY();
            int objectX = levelOneSectionOneScreen.getEnemiesInThisSection().get(i).getX();
            int objectY = levelOneSectionOneScreen.getEnemiesInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersect
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                levelOneSectionOneScreen.getGameData().userHeartValue--;
                return true;
            }

        }
        return false;
    }

    public boolean intersectWithEmptyGround() {
        for (int i = 0; i < levelOneSectionOneScreen.getEmptySpaceInGroundsInThisSection().size(); i++) {
            int marioWidth = levelOneSectionOneScreen.activeMario.get(0).getWidth();
            int marioHeight = levelOneSectionOneScreen.activeMario.get(0).getHeight();
            int objectWidth = levelOneSectionOneScreen.getEmptySpaceInGroundsInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionOneScreen.getEmptySpaceInGroundsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelOneSectionOneScreen.activeMario.get(0).getX();
            int marioY = levelOneSectionOneScreen.activeMario.get(0).getY();
            int objectX = levelOneSectionOneScreen.getEmptySpaceInGroundsInThisSection().get(i).getX();
            int objectY = levelOneSectionOneScreen.getEmptySpaceInGroundsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersect
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                levelOneSectionOneScreen.getGameData().userHeartValue--;
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
}

/*
public boolean intersects(ObjectsInGame r) {
        int tw = this.width;
        int th = this.height;
        int rw = r.width;
        int rh = r.height;
        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
            return false;
        }
        int tx = this.x;
        int ty = this.y;
        int rx = r.x;
        int ry = r.y;
        rw += rx;
        rh += ry;
        tw += tx;
        th += ty;
        //      overflow || intersect
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));
    }
 */

