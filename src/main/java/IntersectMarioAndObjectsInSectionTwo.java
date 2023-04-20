public class IntersectMarioAndObjectsInSectionTwo{

    GameScreenFrame gameScreenFrame;
    LevelOneSectionTwoScreen levelOneSectionTwoScreen;
    protected boolean marioHitsLeftOfTheObject;
    protected boolean marioHitsRightOfTheObject;
    protected boolean marioHitsUpOfTheObject;
    protected boolean marioHitsDownOfTheObject;

    IntersectMarioAndObjectsInSectionTwo(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
        this.levelOneSectionTwoScreen = gameScreenFrame.levelOneSectionTwoScreen;
    }

    public void intersect() {


        for (int i = 0; i < levelOneSectionTwoScreen.objectsInThisSection.size(); i++) {
            int marioWidth = levelOneSectionTwoScreen.activeMario.get(0).getWidth();
            int marioHeight = levelOneSectionTwoScreen.activeMario.get(0).getHeight();
            int objectWidth = levelOneSectionTwoScreen.objectsInThisSection.get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.objectsInThisSection.get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelOneSectionTwoScreen.activeMario.get(0).getX();
            int marioY = levelOneSectionTwoScreen.activeMario.get(0).getY();
            int objectX = levelOneSectionTwoScreen.objectsInThisSection.get(i).getX();
            int objectY = levelOneSectionTwoScreen.objectsInThisSection.get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersect
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {

                if (levelOneSectionTwoScreen.objectsInThisSection.get(i) instanceof PrizeInAir) {
                    if (!((PrizeInAir) levelOneSectionTwoScreen.objectsInThisSection.get(i)).coinCatch) {
                        ((PrizeInAir) levelOneSectionTwoScreen.objectsInThisSection.get(i)).coinCatch = true;
                        levelOneSectionTwoScreen.gameData.thisGameCoin++;
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


        for (int i = 0; i < levelOneSectionTwoScreen.coinsInThisSection.size(); i++) {
            int marioWidth = levelOneSectionTwoScreen.activeMario.get(0).getWidth();
            int marioHeight = levelOneSectionTwoScreen.activeMario.get(0).getHeight();
            int objectWidth = levelOneSectionTwoScreen.coinsInThisSection.get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.coinsInThisSection.get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelOneSectionTwoScreen.activeMario.get(0).getX();
            int marioY = levelOneSectionTwoScreen.activeMario.get(0).getY();
            int objectX = levelOneSectionTwoScreen.coinsInThisSection.get(i).getX();
            int objectY = levelOneSectionTwoScreen.coinsInThisSection.get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersect
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)){
                if (!levelOneSectionTwoScreen.coinsInThisSection.get(i).isCoinCatch()) {
                    levelOneSectionTwoScreen.gameData.thisGameCoin++;
                    levelOneSectionTwoScreen.gameData.thisGameScore += 10;
                }
                levelOneSectionTwoScreen.coinsInThisSection.get(i).setCoinCatch(true);
            }

        }

    }

    public boolean intersectWithEnemies() {
        for (int i = 0; i < levelOneSectionTwoScreen.enemiesInThisSection.size(); i++) {
            int marioWidth = levelOneSectionTwoScreen.activeMario.get(0).getWidth();
            int marioHeight = levelOneSectionTwoScreen.activeMario.get(0).getHeight();
            int objectWidth = levelOneSectionTwoScreen.enemiesInThisSection.get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.enemiesInThisSection.get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelOneSectionTwoScreen.activeMario.get(0).getX();
            int marioY = levelOneSectionTwoScreen.activeMario.get(0).getY();
            int objectX = levelOneSectionTwoScreen.enemiesInThisSection.get(i).getX();
            int objectY = levelOneSectionTwoScreen.enemiesInThisSection.get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersect
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)){
                levelOneSectionTwoScreen.gameData.userHeartValue--;
                return true;
            }

        }
        return false;
    }

    public boolean intersectWithEmptyGround() {
        for (int i = 0; i < levelOneSectionTwoScreen.emptySpaceInGroundsInThisSection.size(); i++) {
            int marioWidth = levelOneSectionTwoScreen.activeMario.get(0).getWidth();
            int marioHeight = levelOneSectionTwoScreen.activeMario.get(0).getHeight();
            int objectWidth = levelOneSectionTwoScreen.emptySpaceInGroundsInThisSection.get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.emptySpaceInGroundsInThisSection.get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelOneSectionTwoScreen.activeMario.get(0).getX();
            int marioY = levelOneSectionTwoScreen.activeMario.get(0).getY();
            int objectX = levelOneSectionTwoScreen.emptySpaceInGroundsInThisSection.get(i).getX();
            int objectY = levelOneSectionTwoScreen.emptySpaceInGroundsInThisSection.get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersect
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)){
                levelOneSectionTwoScreen.gameData.userHeartValue--;
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
