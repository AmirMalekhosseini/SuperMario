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

            //      overflow || marioIntersectWithObjects
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

            //      overflow || marioIntersectWithObjects
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

            //      overflow || marioIntersectWithObjects
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

    public boolean isEnemyHitAnObject(Enemy enemy) {

        if (enemy instanceof Plant) {
            return false;
        }

        for (int i = 0; i < levelTwoSectionOneScreen.getObjectsInThisSection().size(); i++) {
            int enemyWidth = enemy.getWidth();
            int enemyHeight = enemy.getHeight();
            int objectWidth = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || enemyWidth <= 0 || enemyHeight <= 0) {
                continue;
            }
            int enemyX = enemy.getX();
            int enemyY = enemy.getY();
            int objectX = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getX();
            int objectY = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            enemyWidth += enemyX;
            enemyHeight += enemyY;

            if ((objectWidth < objectX || objectWidth > enemyX) &&
                    (objectHeight < objectY || objectHeight > enemyY) &&
                    (enemyWidth < enemyX || enemyWidth > objectX) &&
                    (enemyHeight < enemyY || enemyHeight > objectY)) {
                if ((objectHeight > enemyY || enemyHeight > objectY) && enemyWidth <= objectX + 30 && !enemy.isEnemyHitsAnObject()) {// Hit left of Object

                    if (enemy instanceof Spiny) {
                        enemy.setVelocity(0);
                        enemy.setX(enemy.getX() - 20);
                    }
                    enemy.setEnemyHitsAnObject(true);
                    return true;

                }
                if ((objectHeight > enemyY || enemyHeight > objectY) && objectWidth <= enemyX + 30 && !enemy.isEnemyHitsAnObject()) {// Hit right of Object

                    if (enemy instanceof Spiny) {
                        enemy.setVelocity(0);
                        enemy.setX(enemy.getX() + 20);
                    }
                    enemy.setEnemyHitsAnObject(true);
                    return true;

                }
            }
        }

        for (int i = 0; i < levelTwoSectionOneScreen.getEmptySpaceInGroundsInThisSection().size(); i++) {
            int enemyWidth = enemy.getWidth();
            int enemyHeight = enemy.getHeight();
            int objectWidth = levelTwoSectionOneScreen.getEmptySpaceInGroundsInThisSection().get(i).getWidth();
            int objectHeight = levelTwoSectionOneScreen.getEmptySpaceInGroundsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || enemyWidth <= 0 || enemyHeight <= 0) {
                continue;
            }
            int enemyX = enemy.getX();
            int enemyY = enemy.getY();
            int objectX = levelTwoSectionOneScreen.getEmptySpaceInGroundsInThisSection().get(i).getX();
            int objectY = levelTwoSectionOneScreen.getEmptySpaceInGroundsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            enemyWidth += enemyX;
            enemyHeight += enemyY;

            if ((objectWidth < objectX || objectWidth > enemyX) &&
                    (objectHeight < objectY || objectHeight > enemyY) &&
                    (enemyWidth < enemyX || enemyWidth > objectX) &&
                    (enemyHeight < enemyY || enemyHeight > objectY)) {
                if ((objectHeight > enemyY || enemyHeight > objectY) && enemyWidth <= objectX + 30 && !enemy.isEnemyHitsAnObject()) {// Hit left of Object

                    if (enemy instanceof Spiny) {
                        enemy.setVelocity(0);
                        enemy.setX(enemy.getX() - 20);
                    }
                    enemy.setEnemyHitsAnObject(true);
                    return true;

                }
                if ((objectHeight > enemyY || enemyHeight > objectY) && objectWidth <= enemyX + 30 && !enemy.isEnemyHitsAnObject()) {// Hit right of Object

                    if (enemy instanceof Spiny) {
                        enemy.setVelocity(0);
                        enemy.setX(enemy.getX() + 20);
                    }
                    enemy.setEnemyHitsAnObject(true);
                    return true;

                }
            }
        }

        enemy.setEnemyHitsAnObject(false);
        return false;
    }

    public boolean isItemHitAnObject(ItemsInGame item) {

        for (int i = 0; i < levelTwoSectionOneScreen.getObjectsInThisSection().size(); i++) {
            int itemWidth = item.getWidth();
            int itemHeight = item.getHeight();
            int objectWidth = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || itemWidth <= 0 || itemHeight <= 0) {
                continue;
            }
            if (item instanceof Coin || item instanceof FlowerItem) {
                continue;
            }
            int itemX = item.getX();
            int itemY = item.getY();
            int objectX = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getX();
            int objectY = levelTwoSectionOneScreen.getObjectsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            itemWidth += itemX;
            itemHeight += itemY;

            if ((objectWidth < objectX || objectWidth > itemX) &&
                    (objectHeight < objectY || objectHeight > itemY) &&
                    (itemWidth < itemX || itemWidth > objectX) &&
                    (itemHeight < itemY || itemHeight > objectY)) {

                if ((objectHeight > itemY || itemHeight > objectY) && itemWidth <= objectX + 5 && !item.isItemHitsAnObject()) {// Hit left of Object

                    item.setItemHitsAnObject(true);
                    return true;

                }
                if ((objectHeight > itemY || itemHeight > objectY) && objectWidth <= itemX+5 && !item.isItemHitsAnObject()) {// Hit right of Object

                    item.setItemHitsAnObject(true);
                    return true;

                }
            }

        }

        for (int i = 0; i < levelTwoSectionOneScreen.getEmptySpaceInGroundsInThisSection().size(); i++) {
            int itemWidth = item.getWidth();
            int itemHeight = item.getHeight();
            int objectWidth = levelTwoSectionOneScreen.getEmptySpaceInGroundsInThisSection().get(i).getWidth();
            int objectHeight = levelTwoSectionOneScreen.getEmptySpaceInGroundsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || itemWidth <= 0 || itemHeight <= 0) {
                continue;
            }
            if (item instanceof Coin || item instanceof FlowerItem) {
                continue;
            }
            int itemX = item.getX();
            int itemY = item.getY();
            int objectX = levelTwoSectionOneScreen.getEmptySpaceInGroundsInThisSection().get(i).getX();
            int objectY = levelTwoSectionOneScreen.getEmptySpaceInGroundsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            itemWidth += itemX;
            itemHeight += itemY;

            if ((objectWidth < objectX || objectWidth > itemX) &&
                    (objectHeight < objectY || objectHeight > itemY) &&
                    (itemWidth < itemX || itemWidth > objectX) &&
                    (itemHeight < itemY || itemHeight > objectY)) {

                if ((objectHeight > itemY || itemHeight > objectY) && itemWidth <= objectX + 5 && !item.isItemHitsAnObject()) {// Hit left of Object

                    item.setItemHitsAnObject(true);
                    return true;

                }
                if ((objectHeight > itemY || itemHeight > objectY) && objectWidth <= itemX+5 && !item.isItemHitsAnObject()) {// Hit right of Object

                    item.setItemHitsAnObject(true);
                    return true;

                }
            }

        }

        item.setItemHitsAnObject(false);
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
