package Model;

import Graphic.*;

import java.util.Random;

public abstract class Intersection {

    GameScreenFrame gameScreenFrame;
    LevelScreens screen;
    PowerUp powerUp;
    protected boolean marioHitsLeftOfTheObject;
    protected boolean marioHitsRightOfTheObject;
    protected boolean marioHitsUpOfTheObject;
    protected boolean marioHitsDownOfTheObject;
    protected boolean marioHitsAnObject;
    protected boolean marioHitsFullOfCoinBlockInAir;
    protected boolean marioHitsTurtle;

    public Intersection(GameScreenFrame gameScreenFrame, PowerUp powerUp,LevelScreens screen) {
        this.powerUp = powerUp;
        this.gameScreenFrame = gameScreenFrame;
        this.screen = screen;
    }


    public void marioIntersectWithObjects() {

        for (int i = 0; i < screen.getObjectsInThisSection().size(); i++) {
            int marioWidth = screen.activeMario.get(0).getWidth();
            int marioHeight = screen.activeMario.get(0).getHeight();
            int objectWidth = screen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = screen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = screen.activeMario.get(0).getX();
            int marioY = screen.activeMario.get(0).getY();
            int objectX = screen.getObjectsInThisSection().get(i).getX();
            int objectY = screen.getObjectsInThisSection().get(i).getY();
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

                if (screen.getObjectsInThisSection().get(i) instanceof PrizeInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    if (((PrizeInAir) screen.getObjectsInThisSection().get(i)).isItemCatch()) {
                        ((PrizeInAir) screen.getObjectsInThisSection().get(i)).setItemCatch(true);
                        generateRandomItem((PrizeInAir) screen.getObjectsInThisSection().get(i));
                        marioHitsAnObject = true;
                    }
                    continue;
                }

                if (screen.activeMario.get(0).isMarioMini()) {// Mini Mario cant destroy
                    return;
                }

                if (screen.getObjectsInThisSection().get(i) instanceof SimpleBlockInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    screen.remove(screen.getObjectsInThisSection().get(i));
                    screen.getObjectsInThisSection().remove(screen.getObjectsInThisSection().get(i));
                    gameScreenFrame.getGameData().thisGameScore++;
                    marioHitsAnObject = true;
                    i = 0;
                    continue;
                } else if (screen.getObjectsInThisSection().get(i) instanceof OneCoinBlockInAir && marioHitsDownOfTheObject && !marioHitsAnObject) {
                    int x = screen.getObjectsInThisSection().get(i).getX();
                    int y = screen.getObjectsInThisSection().get(i).getY() - 50;
                    Coin newCoin = new Coin(x, y);
                    ((OneCoinBlockInAir) screen.getObjectsInThisSection().get(i)).setCoinInBlockInAir(newCoin);
                    screen.add(newCoin, Integer.valueOf(1));
                    screen.getItemsInThisSection().add(newCoin);
                    screen.remove(screen.getObjectsInThisSection().get(i));
                    SimpleBlockInAir newSimpleBlockInAir = new SimpleBlockInAir(x, y + 50);
                    screen.getObjectsInThisSection().set(i, newSimpleBlockInAir);
                    screen.add(newSimpleBlockInAir, Integer.valueOf(1));
                    gameScreenFrame.getGameData().thisGameScore++;
                    marioHitsAnObject = true;
                    i = 0;
                    continue;
                } else if (screen.getObjectsInThisSection().get(i) instanceof FullOfCoinBlockInAir && marioHitsDownOfTheObject
                        && !marioHitsAnObject && !marioHitsFullOfCoinBlockInAir) {
                    ((FullOfCoinBlockInAir) screen.getObjectsInThisSection().get(i)).hitCounter++;
                    gameScreenFrame.getGameData().thisGameCoin++;
                    marioHitsFullOfCoinBlockInAir = true;

                    if (((FullOfCoinBlockInAir) screen.getObjectsInThisSection().get(i)).getHitCounter() == 5) {
                        int x = screen.getObjectsInThisSection().get(i).getX();
                        int y = screen.getObjectsInThisSection().get(i).getY();
                        screen.remove(screen.getObjectsInThisSection().get(i));
                        EmptyBlockInAir newEmptyBlockInAir = new EmptyBlockInAir(x, y);
                        screen.getObjectsInThisSection().set(i, newEmptyBlockInAir);
                        screen.add(newEmptyBlockInAir, Integer.valueOf(1));
                    }
                    i = 0;
                    continue;
                }

                break;
            }
        }
    }

    public void marioIntersectWithItems() {

        for (int i = 0; i < screen.getItemsInThisSection().size(); i++) {
            int marioWidth = screen.activeMario.get(0).getWidth();
            int marioHeight = screen.activeMario.get(0).getHeight();
            int objectWidth = screen.getItemsInThisSection().get(i).getWidth();
            int objectHeight = screen.getItemsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = screen.activeMario.get(0).getX();
            int marioY = screen.activeMario.get(0).getY();
            int objectX = screen.getItemsInThisSection().get(i).getX();
            int objectY = screen.getItemsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || marioIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                if (!screen.getItemsInThisSection().get(i).isItemCatch()) {
                    if (screen.getItemsInThisSection().get(i) instanceof Coin) {
                        screen.getGameData().thisGameCoin++;
                    } else {
                        powerUp.allocatePowerUp(screen.activeMario.get(0));
                    }
                    screen.getGameData().thisGameScore += screen.getItemsInThisSection().get(i).getScoreItemAdds();

                }
                screen.getItemsInThisSection().get(i).setItemCatch(true);
            }

        }

    }

    public boolean marioIntersectWithEnemies() {

        for (int i = 0; i < screen.getEnemiesInThisSection().size(); i++) {
            Enemy enemy = screen.getEnemiesInThisSection().get(i);
            Mario activeMario = screen.activeMario.get(0);
            int marioWidth = activeMario.getWidth();
            int marioHeight = activeMario.getHeight();
            int objectWidth = enemy.getWidth();
            int objectHeight = enemy.getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = activeMario.getX();
            int marioY = activeMario.getY();
            int objectX = enemy.getX();
            int objectY = enemy.getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || marioIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                if ((marioWidth >= objectX || objectWidth >= marioX) && marioHeight <= objectY + 30) {// Hit up of Object and kill Enemy
                    if (enemy instanceof Goompa) {
                        screen.remove(enemy);
                        screen.getEnemiesInThisSection().remove(i);
                        gameScreenFrame.getGameData().thisGameCoin += 3;
                        gameScreenFrame.getGameData().thisGameScore++;
                        return false;
                    }

                    if (enemy instanceof Turtle && !marioHitsTurtle) {
                        ((Turtle) enemy).hitCounter++;
                        ((Turtle) enemy).setTurtleHit(true);
                        if (((Turtle) enemy).hitCounter >= 2) {
                            screen.remove(enemy);
                            screen.getEnemiesInThisSection().remove(i);
                            gameScreenFrame.getGameData().thisGameCoin += 3;
                            gameScreenFrame.getGameData().thisGameScore += 2;
                        }

                        int x = enemy.getX() + 500;
                        enemy.setX(x);
                        marioHitsTurtle = true;
                        return false;
                    }
                }

                powerUp.decreasePowerUp(screen.activeMario.get(0));
                if (activeMario.isMarioShouldDie()) {
                    screen.getGameData().userHeartValue--;
                    screen.thisSectionTime.setSectionTime(50);
                    return true;
                } else {// Mario decrease powerUp and the enemy will be killed:
                    screen.remove(enemy);
                    screen.getEnemiesInThisSection().remove(enemy);
                    return false;
                }

            }

        }

        // Bomb Hits mario:
        for (int i = 0; i < screen.getBombsInThisSection().size(); i++) {
            BirdBomb bomb = screen.getBombsInThisSection().get(i);
            Mario activeMario = screen.activeMario.get(0);
            int marioWidth = activeMario.getWidth();
            int marioHeight = activeMario.getHeight();
            int objectWidth = bomb.getWidth();
            int objectHeight = bomb.getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = activeMario.getX();
            int marioY = activeMario.getY();
            int objectX = bomb.getX();
            int objectY = bomb.getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || marioIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                screen.remove(bomb);
                screen.getBombsInThisSection().remove(i);
                powerUp.decreasePowerUp(screen.activeMario.get(0));
                if (activeMario.isMarioShouldDie()) {
                    screen.getGameData().userHeartValue--;
                    screen.thisSectionTime.setSectionTime(50);
                    return true;
                }
            }
        }

        return false;
    }

    public boolean marioIntersectWithEmptyGround() {
        for (int i = 0; i < screen.getEmptySpaceInGroundsInThisSection().size(); i++) {
            int marioWidth = screen.activeMario.get(0).getWidth();
            int marioHeight = screen.activeMario.get(0).getHeight();
            int objectWidth = screen.getEmptySpaceInGroundsInThisSection().get(i).getWidth();
            int objectHeight = screen.getEmptySpaceInGroundsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || marioWidth <= 0 || marioHeight <= 0) {
                continue;
            }
            int marioX = screen.activeMario.get(0).getX();
            int marioY = screen.activeMario.get(0).getY();
            int objectX = screen.getEmptySpaceInGroundsInThisSection().get(i).getX();
            int objectY = screen.getEmptySpaceInGroundsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            marioWidth += marioX;
            marioHeight += marioY;

            //      overflow || marioIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > marioX) &&
                    (objectHeight < objectY || objectHeight > marioY) &&
                    (marioWidth < marioX || marioWidth > objectX) &&
                    (marioHeight < marioY || marioHeight > objectY)) {
                screen.getGameData().userHeartValue--;
                screen.thisSectionTime.setSectionTime(50);
                return true;
            }

        }
        return false;
    }

    public boolean isEnemyHitAnObject(Enemy enemy) {

        if (enemy instanceof Plant) {
            return false;
        }

        for (int i = 0; i < screen.getObjectsInThisSection().size(); i++) {
            int enemyWidth = enemy.getWidth();
            int enemyHeight = enemy.getHeight();
            int objectWidth = screen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = screen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || enemyWidth <= 0 || enemyHeight <= 0) {
                continue;
            }
            int enemyX = enemy.getX();
            int enemyY = enemy.getY();
            int objectX = screen.getObjectsInThisSection().get(i).getX();
            int objectY = screen.getObjectsInThisSection().get(i).getY();
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

        for (int i = 0; i < screen.getEmptySpaceInGroundsInThisSection().size(); i++) {
            int enemyWidth = enemy.getWidth();
            int enemyHeight = enemy.getHeight();
            int objectWidth = screen.getEmptySpaceInGroundsInThisSection().get(i).getWidth();
            int objectHeight = screen.getEmptySpaceInGroundsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || enemyWidth <= 0 || enemyHeight <= 0) {
                continue;
            }
            int enemyX = enemy.getX();
            int enemyY = enemy.getY();
            int objectX = screen.getEmptySpaceInGroundsInThisSection().get(i).getX();
            int objectY = screen.getEmptySpaceInGroundsInThisSection().get(i).getY();
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

        for (int i = 0; i < screen.getObjectsInThisSection().size(); i++) {
            int itemWidth = item.getWidth();
            int itemHeight = item.getHeight();
            int objectWidth = screen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = screen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || itemWidth <= 0 || itemHeight <= 0) {
                continue;
            }
            if (item instanceof Coin || item instanceof FlowerItem) {
                continue;
            }
            int itemX = item.getX();
            int itemY = item.getY();
            int objectX = screen.getObjectsInThisSection().get(i).getX();
            int objectY = screen.getObjectsInThisSection().get(i).getY();
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
                if ((objectHeight > itemY || itemHeight > objectY) && objectWidth <= itemX + 5 && item.isItemHitsAnObject()) {// Hit right of Object

                    item.setItemHitsAnObject(true);
                    return true;

                }
            }

        }

        for (int i = 0; i < screen.getEmptySpaceInGroundsInThisSection().size(); i++) {
            int itemWidth = item.getWidth();
            int itemHeight = item.getHeight();
            int objectWidth = screen.getEmptySpaceInGroundsInThisSection().get(i).getWidth();
            int objectHeight = screen.getEmptySpaceInGroundsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || itemWidth <= 0 || itemHeight <= 0) {
                continue;
            }
            if (item instanceof Coin || item instanceof FlowerItem) {
                continue;
            }
            int itemX = item.getX();
            int itemY = item.getY();
            int objectX = screen.getEmptySpaceInGroundsInThisSection().get(i).getX();
            int objectY = screen.getEmptySpaceInGroundsInThisSection().get(i).getY();
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
                if ((objectHeight > itemY || itemHeight > objectY) && objectWidth <= itemX + 5 && item.isItemHitsAnObject()) {// Hit right of Object

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
            screen.remove(bomb);
            screen.getBombsInThisSection().remove(bomb);
            return;
        }
        // Bomb Hits An Enemy:
        for (int i = 0; i < screen.getEnemiesInThisSection().size(); i++) {
            int bombWidth = bomb.getWidth();
            int bombHeight = bomb.getHeight();
            int objectWidth = screen.getEnemiesInThisSection().get(i).getWidth();
            int objectHeight = screen.getEnemiesInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || bombWidth <= 0 || bombHeight <= 0) {
                continue;
            }
            int bombX = bomb.getX();
            int bombY = bomb.getY();
            int objectX = screen.getEnemiesInThisSection().get(i).getX();
            int objectY = screen.getEnemiesInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            bombWidth += bombX;
            bombHeight += bombY;

            //      overflow || bombIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > bombX) &&
                    (objectHeight < objectY || objectHeight > bombY) &&
                    (bombWidth < bombX || bombWidth > objectX) &&
                    (bombHeight < bombY || bombHeight > objectY)) {

                screen.remove(bomb);
                screen.remove(screen.getEnemiesInThisSection().get(i));
                screen.getEnemiesInThisSection().remove(i);
                screen.getBombsInThisSection().remove(bomb);
                return;
            }
        }

        // Bomb Hits An Object:
        for (int i = 0; i < screen.getObjectsInThisSection().size(); i++) {
            int bombWidth = bomb.getWidth();
            int bombHeight = bomb.getHeight() + 10;
            int objectWidth = screen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = screen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || bombWidth <= 0 || bombHeight <= 0) {
                continue;
            }
            int bombX = bomb.getX();
            int bombY = bomb.getY();
            int objectX = screen.getObjectsInThisSection().get(i).getX();
            int objectY = screen.getObjectsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            bombWidth += bombX;
            bombHeight += bombY;

            //      overflow || bombIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > bombX) &&
                    (objectHeight < objectY || objectHeight > bombY) &&
                    (bombWidth < bombX || bombWidth > objectX) &&
                    (bombHeight < bombY || bombHeight > objectY)) {

                screen.remove(bomb);
                screen.getBombsInThisSection().remove(bomb);
                return;

            }
        }

    }

    public void arrowIntersection(MarioWeapon arrow) {

        if (arrow.getX() >= arrow.getXEndPosition()) {
            screen.remove(arrow);
            screen.getWeaponsInThisSection().remove(arrow);
            return;
        }

        // Arrow Hits An Enemy:
        for (int i = 0; i < screen.getEnemiesInThisSection().size(); i++) {
            int arrowWidth = arrow.getWidth();
            int arrowHeight = arrow.getHeight();
            int objectWidth = screen.getEnemiesInThisSection().get(i).getWidth();
            int objectHeight = screen.getEnemiesInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || arrowWidth <= 0 || arrowHeight <= 0) {
                continue;
            }
            int arrowX = arrow.getX();
            int arrowY = arrow.getY();
            int objectX = screen.getEnemiesInThisSection().get(i).getX();
            int objectY = screen.getEnemiesInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            arrowWidth += arrowX;
            arrowHeight += arrowY;

            //      overflow || bombIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > arrowX) &&
                    (objectHeight < objectY || objectHeight > arrowY) &&
                    (arrowWidth < arrowX || arrowWidth > objectX) &&
                    (arrowHeight < arrowY || arrowHeight > objectY)) {

                screen.remove(arrow);
                screen.remove(screen.getEnemiesInThisSection().get(i));
                screen.getEnemiesInThisSection().remove(i);
                screen.getWeaponsInThisSection().remove(arrow);
                return;
            }
        }

        // Arrow Hits An Object:
        for (int i = 0; i < screen.getObjectsInThisSection().size(); i++) {
            int arrowWidth = arrow.getWidth();
            int arrowHeight = arrow.getHeight() + 10;
            int objectWidth = screen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = screen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || arrowWidth <= 0 || arrowHeight <= 0) {
                continue;
            }
            int arrowX = arrow.getX();
            int arrowY = arrow.getY();
            int objectX = screen.getObjectsInThisSection().get(i).getX();
            int objectY = screen.getObjectsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            arrowWidth += arrowX;
            arrowHeight += arrowY;

            //      overflow || bombIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > arrowX) &&
                    (objectHeight < objectY || objectHeight > arrowY) &&
                    (arrowWidth < arrowX || arrowWidth > objectX) &&
                    (arrowHeight < arrowY || arrowHeight > objectY)) {

                screen.remove(arrow);
                screen.getWeaponsInThisSection().remove(arrow);
                return;

            }
        }

    }

    public void intersectShot() {
        for (int i = 0; i < screen.getWeaponsInThisSection().size(); i++) {
            if (screen.getWeaponsInThisSection().get(i) instanceof Arrow) {
                arrowIntersection(screen.getWeaponsInThisSection().get(i));
            } else if (screen.getWeaponsInThisSection().get(i) instanceof Sword) {
                swordIntersection(screen.getWeaponsInThisSection().get(i));
            }
        }
    }

    public void swordIntersection(MarioWeapon sword) {

        if (sword.getMarioVelocity() >= 0) {// Sword Throwed in positive direction:
            if (sword.getX() <= sword.getXStartPosition()) {// sword come back to mario
                screen.remove(sword);
                screen.getWeaponsInThisSection().remove(sword);
                return;
            }
        } else {
            if (sword.getX() >= sword.getXStartPosition() && sword.getXStartPosition() != 0) {// sword come back to mario
                screen.remove(sword);
                screen.getWeaponsInThisSection().remove(sword);
                return;
            }
        }


        // Sword Hits An Enemy:
        for (int i = 0; i < screen.getEnemiesInThisSection().size(); i++) {
            int arrowWidth = sword.getWidth();
            int arrowHeight = sword.getHeight();
            int objectWidth = screen.getEnemiesInThisSection().get(i).getWidth();
            int objectHeight = screen.getEnemiesInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || arrowWidth <= 0 || arrowHeight <= 0) {
                continue;
            }
            int arrowX = sword.getX();
            int arrowY = sword.getY();
            int objectX = screen.getEnemiesInThisSection().get(i).getX();
            int objectY = screen.getEnemiesInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            arrowWidth += arrowX;
            arrowHeight += arrowY;

            //      overflow || bombIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > arrowX) &&
                    (objectHeight < objectY || objectHeight > arrowY) &&
                    (arrowWidth < arrowX || arrowWidth > objectX) &&
                    (arrowHeight < arrowY || arrowHeight > objectY)) {

                screen.remove(sword);
                screen.remove(screen.getEnemiesInThisSection().get(i));
                screen.getEnemiesInThisSection().remove(i);
                screen.getWeaponsInThisSection().remove(sword);
                return;
            }
        }

        // Sword Hits An Object:
        for (int i = 0; i < screen.getObjectsInThisSection().size(); i++) {
            int arrowWidth = sword.getWidth();
            int arrowHeight = sword.getHeight() + 10;
            int objectWidth = screen.getObjectsInThisSection().get(i).getWidth();
            int objectHeight = screen.getObjectsInThisSection().get(i).getHeight();
            if (objectWidth <= 0 || objectHeight <= 0 || arrowWidth <= 0 || arrowHeight <= 0) {
                continue;
            }
            int arrowX = sword.getX();
            int arrowY = sword.getY();
            int objectX = screen.getObjectsInThisSection().get(i).getX();
            int objectY = screen.getObjectsInThisSection().get(i).getY();
            objectWidth += objectX;
            objectHeight += objectY;
            arrowWidth += arrowX;
            arrowHeight += arrowY;

            //      overflow || bombIntersectWithObjects
            if ((objectWidth < objectX || objectWidth > arrowX) &&
                    (objectHeight < objectY || objectHeight > arrowY) &&
                    (arrowWidth < arrowX || arrowWidth > objectX) &&
                    (arrowHeight < arrowY || arrowHeight > objectY)) {

                screen.remove(sword);
                screen.getWeaponsInThisSection().remove(sword);
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
        } else {
            prizeInAir.setItemInPrizeInAir(new Star(x, y));
        }

        screen.getItemsInThisSection().add(prizeInAir.getItemInPrizeInAir());
        screen.add(prizeInAir.getItemInPrizeInAir(), Integer.valueOf(1));

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

    public boolean isMarioHitsTurtle() {
        return marioHitsTurtle;
    }

    public void setMarioHitsTurtle(boolean marioHitsTurtle) {
        this.marioHitsTurtle = marioHitsTurtle;
    }

    public GameScreenFrame getGameScreenFrame() {
        return gameScreenFrame;
    }

    public void setGameScreenFrame(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
    }

    public LevelScreens getScreen() {
        return screen;
    }

    public void setScreen(LevelScreens screen) {
        this.screen = screen;
    }
    public PowerUp getPowerUp() {
        return powerUp;
    }

    public void setPowerUp(PowerUp powerUp) {
        this.powerUp = powerUp;
    }
}
