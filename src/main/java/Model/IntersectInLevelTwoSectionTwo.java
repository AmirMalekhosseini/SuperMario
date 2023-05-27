package Model;

import Graphic.*;

import java.util.Random;

public class IntersectInLevelTwoSectionTwo {

    GameScreenFrame gameScreenFrame;
    LevelTwoSectionTwoScreen levelTwoSectionTwoScreen;
    protected boolean marioHitsLeftOfTheObject;
    protected boolean marioHitsRightOfTheObject;
    protected boolean marioHitsUpOfTheObject;
    protected boolean marioHitsDownOfTheObject;
    protected boolean marioHitsAnObject;
    protected boolean marioHitsFullOfCoinBlockInAir;

    public IntersectInLevelTwoSectionTwo(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
        this.levelTwoSectionTwoScreen = gameScreenFrame.getLevelTwoSectionTwoScreen();
    }

    public IntersectInLevelTwoSectionTwo() {

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

                if (levelTwoSectionTwoScreen.getObjectsInThisSection().get(i) instanceof PrizeInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    if (((PrizeInAir) levelTwoSectionTwoScreen.getObjectsInThisSection().get(i)).isItemCatch()) {
                        ((PrizeInAir) levelTwoSectionTwoScreen.getObjectsInThisSection().get(i)).setItemCatch(true);
                        generateRandomItem((PrizeInAir) levelTwoSectionTwoScreen.getObjectsInThisSection().get(i));
                        marioHitsAnObject = true;
                    }
                    continue;
                } else if (levelTwoSectionTwoScreen.getObjectsInThisSection().get(i) instanceof SimpleBlockInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    levelTwoSectionTwoScreen.remove(levelTwoSectionTwoScreen.getObjectsInThisSection().get(i));
                    levelTwoSectionTwoScreen.getObjectsInThisSection().remove(levelTwoSectionTwoScreen.getObjectsInThisSection().get(i));
                    gameScreenFrame.getGameData().thisGameScore++;
                    marioHitsAnObject = true;
                    i = 0;
                    continue;
                } else if (levelTwoSectionTwoScreen.getObjectsInThisSection().get(i) instanceof OneCoinBlockInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    int x = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getX();
                    int y = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getY() - 50;
                    Coin newCoin = new Coin(x, y);
                    ((OneCoinBlockInAir) levelTwoSectionTwoScreen.getObjectsInThisSection().get(i)).setCoinInBlockInAir(newCoin);
                    levelTwoSectionTwoScreen.add(newCoin, Integer.valueOf(1));
                    levelTwoSectionTwoScreen.getItemsInThisSection().add(newCoin);
                    levelTwoSectionTwoScreen.remove(levelTwoSectionTwoScreen.getObjectsInThisSection().get(i));
                    SimpleBlockInAir newSimpleBlockInAir = new SimpleBlockInAir(x, y + 50);
                    levelTwoSectionTwoScreen.getObjectsInThisSection().set(i, newSimpleBlockInAir);
                    levelTwoSectionTwoScreen.add(newSimpleBlockInAir, Integer.valueOf(1));
                    gameScreenFrame.getGameData().thisGameScore++;
                    marioHitsAnObject = true;
                    i = 0;
                    continue;
                } else if (levelTwoSectionTwoScreen.getObjectsInThisSection().get(i) instanceof FullOfCoinBlockInAir && marioHitsDownOfTheObject
                        && !marioHitsAnObject && !marioHitsFullOfCoinBlockInAir) {
                    ((FullOfCoinBlockInAir) levelTwoSectionTwoScreen.getObjectsInThisSection().get(i)).hitCounter++;
                    gameScreenFrame.getGameData().thisGameCoin++;
                    marioHitsFullOfCoinBlockInAir = true;

                    if (((FullOfCoinBlockInAir) levelTwoSectionTwoScreen.getObjectsInThisSection().get(i)).getHitCounter() == 5) {
                        int x = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getX();
                        int y = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getY();
                        levelTwoSectionTwoScreen.remove(levelTwoSectionTwoScreen.getObjectsInThisSection().get(i));
                        EmptyBlockInAir newEmptyBlockInAir = new EmptyBlockInAir(x, y);
                        levelTwoSectionTwoScreen.getObjectsInThisSection().set(i, newEmptyBlockInAir);
                        levelTwoSectionTwoScreen.add(newEmptyBlockInAir, Integer.valueOf(1));
                    }
                    i = 0;
                    continue;
                }

                break;
            }
        }
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

            //      overflow || marioIntersectWithObjects
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

            //      overflow || marioIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                levelTwoSectionTwoScreen.getGameData().userHeartValue--;
                return true;
            }

        }

        // Bomb Hits mario:
        for (int i = 0; i < levelTwoSectionTwoScreen.getBombsInThisSection().size(); i++) {
            int marioWidth = levelTwoSectionTwoScreen.activeMario.get(0).getWidth();
            int marioHeight = levelTwoSectionTwoScreen.activeMario.get(0).getHeight();
            int objectWidth = levelTwoSectionTwoScreen.getBombsInThisSection().get(i).getWidth();
            int objectHeight = levelTwoSectionTwoScreen.getBombsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelTwoSectionTwoScreen.activeMario.get(0).getX();
            int marioY = levelTwoSectionTwoScreen.activeMario.get(0).getY();
            int objectX = levelTwoSectionTwoScreen.getBombsInThisSection().get(i).getX();
            int objectY = levelTwoSectionTwoScreen.getBombsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || marioIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                levelTwoSectionTwoScreen.remove(levelTwoSectionTwoScreen.getBombsInThisSection().get(i));
                levelTwoSectionTwoScreen.getBombsInThisSection().remove(i);
                levelTwoSectionTwoScreen.getGameData().userHeartValue--;
                levelTwoSectionTwoScreen.thisSectionTime.setSectionTime(50);
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

            //      overflow || marioIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                levelTwoSectionTwoScreen.getGameData().userHeartValue--;
                return true;
            }

        }
        return false;
    }

    public boolean isEnemyHitAnObject(Enemy enemy) {

        if (enemy instanceof Plant) {
            return false;
        }

        for (int i = 0; i < levelTwoSectionTwoScreen.getObjectsInThisSection().size(); i++) {
            int enemyWidth = enemy.getWidth();
            int enemyHeight = enemy.getHeight();
            int objectWidth = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || enemyWidth <= 0 || enemyHeight <= 0) {
                continue;
            }
            int enemyX = enemy.getX();
            int enemyY = enemy.getY();
            int objectX = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getX();
            int objectY = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getY();
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

                    if (enemy instanceof Turtle) {
                        continue;
                    }

                    enemy.setEnemyHitsAnObject(true);
                    return true;

                }
                if ((objectHeight > enemyY || enemyHeight > objectY) && objectWidth <= enemyX + 30 && !enemy.isEnemyHitsAnObject()) {// Hit right of Object

                    if (enemy instanceof Spiny) {
                        enemy.setVelocity(0);
                        enemy.setX(enemy.getX() + 20);
                    }

                    if (enemy instanceof Turtle) {
                        continue;
                    }

                    enemy.setEnemyHitsAnObject(true);
                    return true;

                }
            }
        }

        for (int i = 0; i < levelTwoSectionTwoScreen.getEmptySpaceInGroundsInThisSection().size(); i++) {
            int enemyWidth = enemy.getWidth();
            int enemyHeight = enemy.getHeight();
            int objectWidth = levelTwoSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getWidth();
            int objectHeight = levelTwoSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || enemyWidth <= 0 || enemyHeight <= 0) {
                continue;
            }
            int enemyX = enemy.getX();
            int enemyY = enemy.getY();
            int objectX = levelTwoSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getX();
            int objectY = levelTwoSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getY();
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

                    if (enemy instanceof Turtle) {
                        continue;
                    }

                    enemy.setEnemyHitsAnObject(true);
                    return true;

                }
                if ((objectHeight > enemyY || enemyHeight > objectY) && objectWidth <= enemyX + 30 && !enemy.isEnemyHitsAnObject()) {// Hit right of Object

                    if (enemy instanceof Spiny) {
                        enemy.setVelocity(0);
                        enemy.setX(enemy.getX() + 20);
                    }

                    if (enemy instanceof Turtle) {
                        continue;
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

        for (int i = 0; i < levelTwoSectionTwoScreen.getObjectsInThisSection().size(); i++) {
            int itemWidth = item.getWidth();
            int itemHeight = item.getHeight();
            int objectWidth = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || itemWidth <= 0 || itemHeight <= 0) {
                continue;
            }
            if (item instanceof Coin || item instanceof FlowerItem) {
                continue;
            }
            int itemX = item.getX();
            int itemY = item.getY();
            int objectX = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getX();
            int objectY = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getY();
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

        for (int i = 0; i < levelTwoSectionTwoScreen.getEmptySpaceInGroundsInThisSection().size(); i++) {
            int itemWidth = item.getWidth();
            int itemHeight = item.getHeight();
            int objectWidth = levelTwoSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getWidth();
            int objectHeight = levelTwoSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || itemWidth <= 0 || itemHeight <= 0) {
                continue;
            }
            if (item instanceof Coin || item instanceof FlowerItem) {
                continue;
            }
            int itemX = item.getX();
            int itemY = item.getY();
            int objectX = levelTwoSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getX();
            int objectY = levelTwoSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getY();
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

    public void bombIntersection(BirdBomb bomb) {

        // Bomb Hits Ground:
        if (bomb.getY() + bomb.getHeight() >= 940) {
            levelTwoSectionTwoScreen.remove(bomb);
            levelTwoSectionTwoScreen.getBombsInThisSection().remove(bomb);
            return;
        }
        // Bomb Hits An Enemy:
        for (int i = 0; i < levelTwoSectionTwoScreen.getEnemiesInThisSection().size(); i++) {
            int bombWidth = bomb.getWidth();
            int bombHeight = bomb.getHeight();
            int objectWidth = levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).getWidth();
            int objectHeight = levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || bombWidth <= 0 || bombHeight <= 0) {
                continue;
            }
            int bombX = bomb.getX();
            int bombY = bomb.getY();
            int objectX = levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).getX();
            int objectY = levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            bombWidth += bombX;
            bombHeight += bombY;

            //      overflow || bombIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > bombX) &&
                    (objectHeight < objectY || objectHeight > bombY) &&
                    (bombWidth < bombX || bombWidth > objectX) &&
                    (bombHeight < bombY || bombHeight > objectY)) {

                levelTwoSectionTwoScreen.remove(bomb);
                levelTwoSectionTwoScreen.remove(levelTwoSectionTwoScreen.getEnemiesInThisSection().get(i));
                levelTwoSectionTwoScreen.getEnemiesInThisSection().remove(i);
                levelTwoSectionTwoScreen.getBombsInThisSection().remove(bomb);
                return;
            }
        }

        // Bomb Hits An Object:
        for (int i = 0; i < levelTwoSectionTwoScreen.getObjectsInThisSection().size(); i++) {
            int bombWidth = bomb.getWidth();
            int bombHeight = bomb.getHeight();
            int objectWidth = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || bombWidth <= 0 || bombHeight <= 0) {
                continue;
            }
            int bombX = bomb.getX();
            int bombY = bomb.getY();
            int objectX = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getX();
            int objectY = levelTwoSectionTwoScreen.getObjectsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            bombWidth += bombX;
            bombHeight += bombY;

            //      overflow || bombIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > bombX) &&
                    (objectHeight < objectY || objectHeight > bombY) &&
                    (bombWidth < bombX || bombWidth > objectX) &&
                    (bombHeight < bombY || bombHeight > objectY)) {

                levelTwoSectionTwoScreen.remove(bomb);
                levelTwoSectionTwoScreen.getBombsInThisSection().remove(bomb);
                return;

            }
        }

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

        levelTwoSectionTwoScreen.getItemsInThisSection().add(prizeInAir.getItemInPrizeInAir());
        levelTwoSectionTwoScreen.add(prizeInAir.getItemInPrizeInAir(), Integer.valueOf(1));

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

    public LevelTwoSectionTwoScreen getLevelTwoSectionTwoScreen() {
        return levelTwoSectionTwoScreen;
    }

    public void setLevelTwoSectionTwoScreen(LevelTwoSectionTwoScreen levelTwoSectionTwoScreen) {
        this.levelTwoSectionTwoScreen = levelTwoSectionTwoScreen;
    }
}
