package Model;

import Graphic.*;

import java.util.Random;

public class IntersectInLevelOneSectionOne {

    GameScreenFrame gameScreenFrame;
    LevelOneSectionOneScreen levelOneSectionOneScreen;
    protected boolean marioHitsLeftOfTheObject;
    protected boolean marioHitsRightOfTheObject;
    protected boolean marioHitsUpOfTheObject;
    protected boolean marioHitsDownOfTheObject;
    protected boolean marioHitsAnObject;
    protected boolean marioHitsFullOfCoinBlockInAir;
    protected boolean marioHitsTurtle;

    public IntersectInLevelOneSectionOne(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
        this.levelOneSectionOneScreen = gameScreenFrame.getLevelOneSectionOneScreen();
    }

    public IntersectInLevelOneSectionOne() {

    }

    public void intersectWithObjects() {

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

                if (levelOneSectionOneScreen.getObjectsInThisSection().get(i) instanceof PrizeInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    if (((PrizeInAir) levelOneSectionOneScreen.getObjectsInThisSection().get(i)).isItemCatch()) {
                        ((PrizeInAir) levelOneSectionOneScreen.getObjectsInThisSection().get(i)).setItemCatch(true);
                        generateRandomItem((PrizeInAir) levelOneSectionOneScreen.getObjectsInThisSection().get(i));
                        marioHitsAnObject = true;
                    }
                    continue;
                } else if (levelOneSectionOneScreen.getObjectsInThisSection().get(i) instanceof SimpleBlockInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    levelOneSectionOneScreen.remove(levelOneSectionOneScreen.getObjectsInThisSection().get(i));
                    levelOneSectionOneScreen.getObjectsInThisSection().remove(levelOneSectionOneScreen.getObjectsInThisSection().get(i));
                    gameScreenFrame.getGameData().thisGameScore++;
                    marioHitsAnObject = true;
                    i = 0;
                    continue;
                } else if (levelOneSectionOneScreen.getObjectsInThisSection().get(i) instanceof OneCoinBlockInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    int x = levelOneSectionOneScreen.getObjectsInThisSection().get(i).getX();
                    int y = levelOneSectionOneScreen.getObjectsInThisSection().get(i).getY() - 50;
                    Coin newCoin = new Coin(x, y);
                    ((OneCoinBlockInAir) levelOneSectionOneScreen.getObjectsInThisSection().get(i)).setCoinInBlockInAir(newCoin);
                    levelOneSectionOneScreen.add(newCoin, Integer.valueOf(1));
                    levelOneSectionOneScreen.getItemsInThisSection().add(newCoin);
                    levelOneSectionOneScreen.remove(levelOneSectionOneScreen.getObjectsInThisSection().get(i));
                    SimpleBlockInAir newSimpleBlockInAir = new SimpleBlockInAir(x, y + 50);
                    levelOneSectionOneScreen.getObjectsInThisSection().set(i, newSimpleBlockInAir);
                    levelOneSectionOneScreen.add(newSimpleBlockInAir, Integer.valueOf(1));
                    gameScreenFrame.getGameData().thisGameScore++;
                    marioHitsAnObject = true;
                    i = 0;
                    continue;
                } else if (levelOneSectionOneScreen.getObjectsInThisSection().get(i) instanceof FullOfCoinBlockInAir && marioHitsDownOfTheObject
                        && !marioHitsAnObject && !marioHitsFullOfCoinBlockInAir) {
                    ((FullOfCoinBlockInAir) levelOneSectionOneScreen.getObjectsInThisSection().get(i)).hitCounter++;
                    gameScreenFrame.getGameData().thisGameCoin++;
                    marioHitsFullOfCoinBlockInAir = true;

                    if (((FullOfCoinBlockInAir) levelOneSectionOneScreen.getObjectsInThisSection().get(i)).getHitCounter() == 5) {
                        int x = levelOneSectionOneScreen.getObjectsInThisSection().get(i).getX();
                        int y = levelOneSectionOneScreen.getObjectsInThisSection().get(i).getY();
                        levelOneSectionOneScreen.remove(levelOneSectionOneScreen.getObjectsInThisSection().get(i));
                        EmptyBlockInAir newEmptyBlockInAir = new EmptyBlockInAir(x, y);
                        levelOneSectionOneScreen.getObjectsInThisSection().set(i, newEmptyBlockInAir);
                        levelOneSectionOneScreen.add(newEmptyBlockInAir, Integer.valueOf(1));
                    }
                    i = 0;
                    continue;
                }

                break;
            }
        }
    }

    public void intersectWithItems() {

        for (int i = 0; i < levelOneSectionOneScreen.getItemsInThisSection().size(); i++) {
            int marioWidth = levelOneSectionOneScreen.activeMario.get(0).getWidth();
            int marioHeight = levelOneSectionOneScreen.activeMario.get(0).getHeight();
            int objectWidth = levelOneSectionOneScreen.getItemsInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionOneScreen.getItemsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelOneSectionOneScreen.activeMario.get(0).getX();
            int marioY = levelOneSectionOneScreen.activeMario.get(0).getY();
            int objectX = levelOneSectionOneScreen.getItemsInThisSection().get(i).getX();
            int objectY = levelOneSectionOneScreen.getItemsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || intersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                if (!levelOneSectionOneScreen.getItemsInThisSection().get(i).isItemCatch()) {
                    if (levelOneSectionOneScreen.getItemsInThisSection().get(i) instanceof Coin) {
                        levelOneSectionOneScreen.getGameData().thisGameCoin++;
                    }
                    levelOneSectionOneScreen.getGameData().thisGameScore += levelOneSectionOneScreen.getItemsInThisSection().get(i).getScoreItemAdds();

                }
                levelOneSectionOneScreen.getItemsInThisSection().get(i).setItemCatch(true);
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

            //      overflow || intersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                if ((marioWidth >= objectX || objectWidth >= marioX) && marioHeight <= objectY + 30) {// Hit up of Object and kill Enemy
                    if (levelOneSectionOneScreen.getEnemiesInThisSection().get(i) instanceof Goompa) {
                        gameScreenFrame.getGameData().thisGameScore++;
                        levelOneSectionOneScreen.remove(levelOneSectionOneScreen.getEnemiesInThisSection().get(i));
                        levelOneSectionOneScreen.getEnemiesInThisSection().remove(i);
                        gameScreenFrame.getGameData().thisGameCoin += 3;
                        return false;
                    }

                    if (levelOneSectionOneScreen.getEnemiesInThisSection().get(i) instanceof Turtle && !marioHitsTurtle) {
                        ((Turtle) levelOneSectionOneScreen.getEnemiesInThisSection().get(i)).hitCounter++;
                        ((Turtle) levelOneSectionOneScreen.getEnemiesInThisSection().get(i)).setTurtleHit(true);
                        if (((Turtle) levelOneSectionOneScreen.getEnemiesInThisSection().get(i)).hitCounter >= 2) {
                            gameScreenFrame.getGameData().thisGameScore += 2;
                            levelOneSectionOneScreen.remove(levelOneSectionOneScreen.getEnemiesInThisSection().get(i));
                            levelOneSectionOneScreen.getEnemiesInThisSection().remove(i);
                            gameScreenFrame.getGameData().thisGameCoin += 3;
                        }

                        int x = levelOneSectionOneScreen.getEnemiesInThisSection().get(i).getX() + 500;
                        levelOneSectionOneScreen.getEnemiesInThisSection().get(i).setX(x);
                        marioHitsTurtle = true;
                        return false;
                    }
                    return false;
                }
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

            //      overflow || intersectWithObjects
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

    public boolean isEnemyHitAnObject(Enemy enemy) {

        if (enemy instanceof Plant) {
            return false;
        }

        for (int i = 0; i < levelOneSectionOneScreen.getEnemiesInThisSection().size(); i++) {
            int enemyWidth = enemy.getWidth();
            int enemyHeight = enemy.getHeight();
            int objectWidth = levelOneSectionOneScreen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionOneScreen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || enemyWidth <= 0 || enemyHeight <= 0) {
                continue;
            }
            int enemyX = enemy.getX();
            int enemyY = enemy.getY();
            int objectX = levelOneSectionOneScreen.getObjectsInThisSection().get(i).getX();
            int objectY = levelOneSectionOneScreen.getObjectsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            enemyWidth += enemyX;
            enemyHeight += enemyY;

            if ((objectWidth < objectX || objectWidth > enemyX) &&
                    (objectHeight < objectY || objectHeight > enemyY) &&
                    (enemyWidth < enemyX || enemyWidth > objectX) &&
                    (enemyHeight < enemyY || enemyHeight > objectY)) {
                if ((objectHeight > enemyY || enemyHeight > objectY) && enemyWidth <= objectX + 30 ) {// Hit left of Object

                    return true;

                }
                if ((objectHeight > enemyY || enemyHeight > objectY) && objectWidth <= enemyX + 30) {// Hit right of Object

                    return true;

                }
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

            levelOneSectionOneScreen.getItemsInThisSection().add(prizeInAir.getItemInPrizeInAir());
            levelOneSectionOneScreen.add(prizeInAir.getItemInPrizeInAir(), Integer.valueOf(1));

        }


        public void refreshIntersectsBooleans () {
            marioHitsRightOfTheObject = false;
            marioHitsLeftOfTheObject = false;
            marioHitsDownOfTheObject = false;
            marioHitsUpOfTheObject = false;
        }

        public boolean isMarioHitsFullOfCoinBlockInAir () {
            return marioHitsFullOfCoinBlockInAir;
        }

        public void setMarioHitsFullOfCoinBlockInAir ( boolean marioHitsFullOfCoinBlockInAir){
            this.marioHitsFullOfCoinBlockInAir = marioHitsFullOfCoinBlockInAir;
        }

        public boolean isMarioHitsAnObject () {
            return marioHitsAnObject;
        }

        public void setMarioHitsAnObject ( boolean marioHitsAnObject){
            this.marioHitsAnObject = marioHitsAnObject;
        }

        public boolean isMarioHitsLeftOfTheObject () {
            return marioHitsLeftOfTheObject;
        }

        public void setMarioHitsLeftOfTheObject ( boolean marioHitsLeftOfTheObject){
            this.marioHitsLeftOfTheObject = marioHitsLeftOfTheObject;
        }

        public boolean isMarioHitsRightOfTheObject () {
            return marioHitsRightOfTheObject;
        }

        public void setMarioHitsRightOfTheObject ( boolean marioHitsRightOfTheObject){
            this.marioHitsRightOfTheObject = marioHitsRightOfTheObject;
        }

        public boolean isMarioHitsUpOfTheObject () {
            return marioHitsUpOfTheObject;
        }

        public void setMarioHitsUpOfTheObject ( boolean marioHitsUpOfTheObject){
            this.marioHitsUpOfTheObject = marioHitsUpOfTheObject;
        }

        public boolean isMarioHitsDownOfTheObject () {
            return marioHitsDownOfTheObject;
        }

        public void setMarioHitsDownOfTheObject ( boolean marioHitsDownOfTheObject){
            this.marioHitsDownOfTheObject = marioHitsDownOfTheObject;
        }

    public boolean isMarioHitsTurtle() {
        return marioHitsTurtle;
    }

    public void setMarioHitsTurtle(boolean marioHitsTurtle) {
        this.marioHitsTurtle = marioHitsTurtle;
    }

    public GameScreenFrame getGameScreenFrame () {
            return gameScreenFrame;
        }

        public void setGameScreenFrame (GameScreenFrame gameScreenFrame){
            this.gameScreenFrame = gameScreenFrame;
        }

        public LevelOneSectionOneScreen getLevelOneSectionOneScreen () {
            return levelOneSectionOneScreen;
        }

        public void setLevelOneSectionOneScreen (LevelOneSectionOneScreen levelOneSectionOneScreen){
            this.levelOneSectionOneScreen = levelOneSectionOneScreen;
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
        //      overflow || intersectWithObjects
        return ((rw < rx || rw > tx) &&
                (rh < ry || rh > ty) &&
                (tw < tx || tw > rx) &&
                (th < ty || th > ry));
    }
 */

