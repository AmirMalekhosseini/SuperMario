public class IntersectMarioAndObjectsInSectionOne {

    GameScreenFrame gameScreenFrame;
    LevelOneSectionOneScreen levelOneSectionOneScreen;
    protected boolean marioHitsLeftOfTheObject;
    protected boolean marioHitsRightOfTheObject;
    protected boolean marioHitsUpOfTheObject;
    protected boolean marioHitsDownOfTheObject;

    IntersectMarioAndObjectsInSectionOne(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
        this.levelOneSectionOneScreen = gameScreenFrame.levelOneSectionOneScreen;
    }

    public void intersect() {


        for (int i = 0; i < levelOneSectionOneScreen.objectsInThisSection.size(); i++) {
            int marioWidth = levelOneSectionOneScreen.activeMario.get(0).getWidth();
            int marioHeight = levelOneSectionOneScreen.activeMario.get(0).getHeight();
            int objectWidth = levelOneSectionOneScreen.objectsInThisSection.get(i).getWidth();
            int objectHeight = levelOneSectionOneScreen.objectsInThisSection.get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelOneSectionOneScreen.activeMario.get(0).getX();
            int marioY = levelOneSectionOneScreen.activeMario.get(0).getY();
            int objectX = levelOneSectionOneScreen.objectsInThisSection.get(i).getX();
            int objectY = levelOneSectionOneScreen.objectsInThisSection.get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersect
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {

                if (levelOneSectionOneScreen.objectsInThisSection.get(i) instanceof PrizeInAir) {
                    if (!((PrizeInAir) levelOneSectionOneScreen.objectsInThisSection.get(i)).coinCatch) {
                        ((PrizeInAir) levelOneSectionOneScreen.objectsInThisSection.get(i)).coinCatch = true;
                        levelOneSectionOneScreen.gameData.thisGameCoin++;
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


        for (int i = 0; i < levelOneSectionOneScreen.coinsInThisSection.size(); i++) {
            int marioWidth = levelOneSectionOneScreen.activeMario.get(0).getWidth();
            int marioHeight = levelOneSectionOneScreen.activeMario.get(0).getHeight();
            int objectWidth = levelOneSectionOneScreen.coinsInThisSection.get(i).getWidth();
            int objectHeight = levelOneSectionOneScreen.coinsInThisSection.get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelOneSectionOneScreen.activeMario.get(0).getX();
            int marioY = levelOneSectionOneScreen.activeMario.get(0).getY();
            int objectX = levelOneSectionOneScreen.coinsInThisSection.get(i).getX();
            int objectY = levelOneSectionOneScreen.coinsInThisSection.get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersect
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                if (!levelOneSectionOneScreen.coinsInThisSection.get(i).isCoinCatch()) {
                    levelOneSectionOneScreen.gameData.thisGameCoin++;
                    levelOneSectionOneScreen.gameData.thisGameScore += 10;
                }
                levelOneSectionOneScreen.coinsInThisSection.get(i).setCoinCatch(true);
            }

        }

    }

    public boolean intersectWithEnemies() {
        for (int i = 0; i < levelOneSectionOneScreen.enemiesInThisSection.size(); i++) {
            int marioWidth = levelOneSectionOneScreen.activeMario.get(0).getWidth();
            int marioHeight = levelOneSectionOneScreen.activeMario.get(0).getHeight();
            int objectWidth = levelOneSectionOneScreen.enemiesInThisSection.get(i).getWidth();
            int objectHeight = levelOneSectionOneScreen.enemiesInThisSection.get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelOneSectionOneScreen.activeMario.get(0).getX();
            int marioY = levelOneSectionOneScreen.activeMario.get(0).getY();
            int objectX = levelOneSectionOneScreen.enemiesInThisSection.get(i).getX();
            int objectY = levelOneSectionOneScreen.enemiesInThisSection.get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersect
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                levelOneSectionOneScreen.gameData.userHeartValue--;
                return true;
            }

        }
        return false;
    }

    public boolean intersectWithEmptyGround() {
        for (int i = 0; i < levelOneSectionOneScreen.emptySpaceInGroundsInThisSection.size(); i++) {
            int marioWidth = levelOneSectionOneScreen.activeMario.get(0).getWidth();
            int marioHeight = levelOneSectionOneScreen.activeMario.get(0).getHeight();
            int objectWidth = levelOneSectionOneScreen.emptySpaceInGroundsInThisSection.get(i).getWidth();
            int objectHeight = levelOneSectionOneScreen.emptySpaceInGroundsInThisSection.get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelOneSectionOneScreen.activeMario.get(0).getX();
            int marioY = levelOneSectionOneScreen.activeMario.get(0).getY();
            int objectX = levelOneSectionOneScreen.emptySpaceInGroundsInThisSection.get(i).getX();
            int objectY = levelOneSectionOneScreen.emptySpaceInGroundsInThisSection.get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersect
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                levelOneSectionOneScreen.gameData.userHeartValue--;
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

