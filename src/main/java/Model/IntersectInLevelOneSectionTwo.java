package Model;

import Graphic.*;

import java.util.Random;

public class IntersectInLevelOneSectionTwo {

    GameScreenFrame gameScreenFrame;
    LevelOneSectionTwoScreen levelOneSectionTwoScreen;
    protected boolean marioHitsLeftOfTheObject;
    protected boolean marioHitsRightOfTheObject;
    protected boolean marioHitsUpOfTheObject;
    protected boolean marioHitsDownOfTheObject;
    protected boolean marioHitsAnObject;
    protected boolean marioHitsFullOfCoinBlockInAir;

    public IntersectInLevelOneSectionTwo(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
        this.levelOneSectionTwoScreen = gameScreenFrame.getLevelOneSectionTwoScreen();
    }

    public IntersectInLevelOneSectionTwo() {

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

            //      overflow || marioIntersectWithObjects
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

            //      overflow || marioIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                levelOneSectionTwoScreen.getGameData().userHeartValue--;
                return true;
            }

        }

        // Bomb Hits mario:
        for (int i = 0; i < levelOneSectionTwoScreen.getBombsInThisSection().size(); i++) {
            int marioWidth = levelOneSectionTwoScreen.activeMario.get(0).getWidth();
            int marioHeight = levelOneSectionTwoScreen.activeMario.get(0).getHeight();
            int objectWidth = levelOneSectionTwoScreen.getBombsInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.getBombsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = levelOneSectionTwoScreen.activeMario.get(0).getX();
            int marioY = levelOneSectionTwoScreen.activeMario.get(0).getY();
            int objectX = levelOneSectionTwoScreen.getBombsInThisSection().get(i).getX();
            int objectY = levelOneSectionTwoScreen.getBombsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || marioIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                levelOneSectionTwoScreen.remove(levelOneSectionTwoScreen.getBombsInThisSection().get(i));
                levelOneSectionTwoScreen.getBombsInThisSection().remove(i);
                levelOneSectionTwoScreen.getGameData().userHeartValue--;
                levelOneSectionTwoScreen.thisSectionTime.setSectionTime(50);
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

            //      overflow || marioIntersectWithObjects
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

    public boolean isEnemyHitAnObject(Enemy enemy) {

        if (enemy instanceof Plant) {
            return false;
        }

        for (int i = 0; i < levelOneSectionTwoScreen.getObjectsInThisSection().size(); i++) {
            int enemyWidth = enemy.getWidth();
            int enemyHeight = enemy.getHeight();
            int objectWidth = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || enemyWidth <= 0 || enemyHeight <= 0) {
                continue;
            }
            int enemyX = enemy.getX();
            int enemyY = enemy.getY();
            int objectX = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getX();
            int objectY = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getY();
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

        for (int i = 0; i < levelOneSectionTwoScreen.getEmptySpaceInGroundsInThisSection().size(); i++) {
            int enemyWidth = enemy.getWidth();
            int enemyHeight = enemy.getHeight();
            int objectWidth = levelOneSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || enemyWidth <= 0 || enemyHeight <= 0) {
                continue;
            }
            int enemyX = enemy.getX();
            int enemyY = enemy.getY();
            int objectX = levelOneSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getX();
            int objectY = levelOneSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getY();
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

        for (int i = 0; i < levelOneSectionTwoScreen.getObjectsInThisSection().size(); i++) {
            int itemWidth = item.getWidth();
            int itemHeight = item.getHeight();
            int objectWidth = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || itemWidth <= 0 || itemHeight <= 0) {
                continue;
            }
            if (item instanceof Coin || item instanceof FlowerItem) {
                continue;
            }
            int itemX = item.getX();
            int itemY = item.getY();
            int objectX = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getX();
            int objectY = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            itemWidth += itemX;
            itemHeight += itemY;

            if ((objectWidth < objectX || objectWidth > itemX) &&
                    (objectHeight < objectY || objectHeight > itemY) &&
                    (itemWidth < itemX || itemWidth > objectX) &&
                    (itemHeight < itemY || itemHeight > objectY)) {

                if ((objectHeight > itemY || itemHeight > objectY) && itemWidth <= objectX + 5 && item.isItemHitsAnObject()) {// Hit left of Object

                    item.setItemHitsAnObject(true);
                    return true;

                }
                if ((objectHeight > itemY || itemHeight > objectY) && objectWidth <= itemX+5 && item.isItemHitsAnObject()) {// Hit right of Object

                    item.setItemHitsAnObject(true);
                    return true;

                }
            }

        }

        for (int i = 0; i < levelOneSectionTwoScreen.getEmptySpaceInGroundsInThisSection().size(); i++) {
            int itemWidth = item.getWidth();
            int itemHeight = item.getHeight();
            int objectWidth = levelOneSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || itemWidth <= 0 || itemHeight <= 0) {
                continue;
            }
            if (item instanceof Coin || item instanceof FlowerItem) {
                continue;
            }
            int itemX = item.getX();
            int itemY = item.getY();
            int objectX = levelOneSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getX();
            int objectY = levelOneSectionTwoScreen.getEmptySpaceInGroundsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            itemWidth += itemX;
            itemHeight += itemY;

            if ((objectWidth < objectX || objectWidth > itemX) &&
                    (objectHeight < objectY || objectHeight > itemY) &&
                    (itemWidth < itemX || itemWidth > objectX) &&
                    (itemHeight < itemY || itemHeight > objectY)) {

                if ((objectHeight > itemY || itemHeight > objectY) && itemWidth <= objectX + 5 && item.isItemHitsAnObject()) {// Hit left of Object

                    item.setItemHitsAnObject(true);
                    return true;

                }
                if ((objectHeight > itemY || itemHeight > objectY) && objectWidth <= itemX+5 && item.isItemHitsAnObject()) {// Hit right of Object

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
            levelOneSectionTwoScreen.remove(bomb);
            levelOneSectionTwoScreen.getBombsInThisSection().remove(bomb);
            return;
        }
        // Bomb Hits An Enemy:
        for (int i = 0; i < levelOneSectionTwoScreen.getEnemiesInThisSection().size(); i++) {
            int bombWidth = bomb.getWidth();
            int bombHeight = bomb.getHeight();
            int objectWidth = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || bombWidth <= 0 || bombHeight <= 0) {
                continue;
            }
            int bombX = bomb.getX();
            int bombY = bomb.getY();
            int objectX = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getX();
            int objectY = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            bombWidth += bombX;
            bombHeight += bombY;

            //      overflow || bombIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > bombX) &&
                    (objectHeight < objectY || objectHeight > bombY) &&
                    (bombWidth < bombX || bombWidth > objectX) &&
                    (bombHeight < bombY || bombHeight > objectY)) {

                levelOneSectionTwoScreen.remove(bomb);
                levelOneSectionTwoScreen.remove(levelOneSectionTwoScreen.getEnemiesInThisSection().get(i));
                levelOneSectionTwoScreen.getEnemiesInThisSection().remove(i);
                levelOneSectionTwoScreen.getBombsInThisSection().remove(bomb);
                return;
            }
        }

        // Bomb Hits An Object:
        for (int i = 0; i < levelOneSectionTwoScreen.getObjectsInThisSection().size(); i++) {
            int bombWidth = bomb.getWidth();
            int bombHeight = bomb.getHeight() + 10;
            int objectWidth = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || bombWidth <= 0 || bombHeight <= 0) {
                continue;
            }
            int bombX = bomb.getX();
            int bombY = bomb.getY();
            int objectX = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getX();
            int objectY = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            bombWidth += bombX;
            bombHeight += bombY;

            //      overflow || bombIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > bombX) &&
                    (objectHeight < objectY || objectHeight > bombY) &&
                    (bombWidth < bombX || bombWidth > objectX) &&
                    (bombHeight < bombY || bombHeight > objectY)) {

                levelOneSectionTwoScreen.remove(bomb);
                levelOneSectionTwoScreen.getBombsInThisSection().remove(bomb);
                return;

            }
        }

    }

    public void arrowIntersection(MarioWeapon arrow) {

        if (arrow.getX() >= arrow.getXEndPosition()) {
            levelOneSectionTwoScreen.remove(arrow);
            levelOneSectionTwoScreen.getWeaponsInThisSection().remove(arrow);
            return;
        }

        // Arrow Hits An Enemy:
        for (int i = 0; i < levelOneSectionTwoScreen.getEnemiesInThisSection().size(); i++) {
            int arrowWidth = arrow.getWidth();
            int arrowHeight = arrow.getHeight();
            int objectWidth = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || arrowWidth <= 0 || arrowHeight <= 0) {
                continue;
            }
            int arrowX = arrow.getX();
            int arrowY = arrow.getY();
            int objectX = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getX();
            int objectY = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            arrowWidth += arrowX;
            arrowHeight += arrowY;

            //      overflow || bombIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > arrowX) &&
                    (objectHeight < objectY || objectHeight > arrowY) &&
                    (arrowWidth < arrowX || arrowWidth > objectX) &&
                    (arrowHeight < arrowY || arrowHeight > objectY)) {

                levelOneSectionTwoScreen.remove(arrow);
                levelOneSectionTwoScreen.remove(levelOneSectionTwoScreen.getEnemiesInThisSection().get(i));
                levelOneSectionTwoScreen.getEnemiesInThisSection().remove(i);
                levelOneSectionTwoScreen.getWeaponsInThisSection().remove(arrow);
                return;
            }
        }

        // Arrow Hits An Object:
        for (int i = 0; i < levelOneSectionTwoScreen.getObjectsInThisSection().size(); i++) {
            int arrowWidth = arrow.getWidth();
            int arrowHeight = arrow.getHeight()+10;
            int objectWidth = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || arrowWidth <= 0 || arrowHeight <= 0) {
                continue;
            }
            int arrowX = arrow.getX();
            int arrowY = arrow.getY();
            int objectX = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getX();
            int objectY = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            arrowWidth += arrowX;
            arrowHeight += arrowY;

            //      overflow || bombIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > arrowX) &&
                    (objectHeight < objectY || objectHeight > arrowY) &&
                    (arrowWidth < arrowX || arrowWidth > objectX) &&
                    (arrowHeight < arrowY || arrowHeight > objectY)) {

                levelOneSectionTwoScreen.remove(arrow);
                levelOneSectionTwoScreen.getWeaponsInThisSection().remove(arrow);
                return;

            }
        }

    }

    public void swordIntersection(MarioWeapon sword) {

        if (sword.getMarioVelocity() >= 0) {// Sword Throwed in positive direction:
            if (sword.getX() <= sword.getXStartPosition()) {// sword come back to mario
                levelOneSectionTwoScreen.remove(sword);
                levelOneSectionTwoScreen.getWeaponsInThisSection().remove(sword);
                return;
            }
        } else {
            if (sword.getX() >= sword.getXStartPosition() && sword.getXStartPosition() != 0) {// sword come back to mario
                levelOneSectionTwoScreen.remove(sword);
                levelOneSectionTwoScreen.getWeaponsInThisSection().remove(sword);
                return;
            }
        }



        // Sword Hits An Enemy:
        for (int i = 0; i < levelOneSectionTwoScreen.getEnemiesInThisSection().size(); i++) {
            int arrowWidth = sword.getWidth();
            int arrowHeight = sword.getHeight();
            int objectWidth = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || arrowWidth <= 0 || arrowHeight <= 0) {
                continue;
            }
            int arrowX = sword.getX();
            int arrowY = sword.getY();
            int objectX = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getX();
            int objectY = levelOneSectionTwoScreen.getEnemiesInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            arrowWidth += arrowX;
            arrowHeight += arrowY;

            //      overflow || bombIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > arrowX) &&
                    (objectHeight < objectY || objectHeight > arrowY) &&
                    (arrowWidth < arrowX || arrowWidth > objectX) &&
                    (arrowHeight < arrowY || arrowHeight > objectY)) {

                levelOneSectionTwoScreen.remove(sword);
                levelOneSectionTwoScreen.remove(levelOneSectionTwoScreen.getEnemiesInThisSection().get(i));
                levelOneSectionTwoScreen.getEnemiesInThisSection().remove(i);
                levelOneSectionTwoScreen.getWeaponsInThisSection().remove(sword);
                return;
            }
        }

        // Sword Hits An Object:
        for (int i = 0; i < levelOneSectionTwoScreen.getObjectsInThisSection().size(); i++) {
            int arrowWidth = sword.getWidth();
            int arrowHeight = sword.getHeight() + 10;
            int objectWidth = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || arrowWidth <= 0 || arrowHeight <= 0) {
                continue;
            }
            int arrowX = sword.getX();
            int arrowY = sword.getY();
            int objectX = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getX();
            int objectY = levelOneSectionTwoScreen.getObjectsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            arrowWidth += arrowX;
            arrowHeight += arrowY;

            //      overflow || bombIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > arrowX) &&
                    (objectHeight < objectY || objectHeight > arrowY) &&
                    (arrowWidth < arrowX || arrowWidth > objectX) &&
                    (arrowHeight < arrowY || arrowHeight > objectY)) {

                levelOneSectionTwoScreen.remove(sword);
                levelOneSectionTwoScreen.getWeaponsInThisSection().remove(sword);
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
