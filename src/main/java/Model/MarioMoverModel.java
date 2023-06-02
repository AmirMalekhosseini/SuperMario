package Model;

import Graphic.*;

public class MarioMoverModel {

    GameScreenFrame gameScreenFrame;
    LevelOneSectionOneScreen levelOneSectionOneScreen;
    LevelOneSectionTwoScreen levelOneSectionTwoScreen;
    LevelTwoSectionOneScreen levelTwoSectionOneScreen;
    LevelTwoSectionTwoScreen levelTwoSectionTwoScreen;
    HiddenCoinSectionScreen hiddenCoinSectionScreen;
    HiddenEnemySectionScreen hiddenEnemySectionScreen;
    GameData gameData;
    private boolean rightMario;
    private boolean leftMario;
    private boolean upMario;
    private boolean isUserPressedUp;
    private boolean isUserPressedDown;
    private boolean marioEnterInLevelOneSectionTwo;
    private boolean marioShooting;
    private boolean marioThrowSword;
    public Mario activeMario;


    public MarioMoverModel(GameScreenFrame gameScreenFrame) {

        this.gameScreenFrame = gameScreenFrame;
        this.levelOneSectionOneScreen = gameScreenFrame.getLevelOneSectionOneScreen();
        this.levelOneSectionTwoScreen = gameScreenFrame.getLevelOneSectionTwoScreen();
        this.levelTwoSectionOneScreen = gameScreenFrame.getLevelTwoSectionOneScreen();
        this.levelTwoSectionTwoScreen = gameScreenFrame.getLevelTwoSectionTwoScreen();
        this.hiddenCoinSectionScreen = gameScreenFrame.getHiddenCoinSectionScreen();
        this.hiddenEnemySectionScreen = gameScreenFrame.getHiddenEnemySectionScreen();
        this.gameData = gameScreenFrame.getGameData();

    }

    public void move() {

        if (gameScreenFrame.getXLevelOneBackgroundPanel() >= -6700) {// Game is in LevelOne SectionOne
            gameScreenFrame.getGameData().setMarioLocation("levelonesectionone");
            activeMario = gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0);

            try {
                if (gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getX() >= 6380) {// Go to Section Two
                    gameScreenFrame.setXLevelOneBackgroundPanel(-6800);

                }

                if (isUserPressedUp && isUserPressedDown) {// When both button pressed together:
                    upMario = false;
                    isUserPressedUp = false;
                    activeMario.setMarioSit(false);
                    return;
                }

                // GravityData:

                if (upMario) {// Mario start jumping

                    activeMario.setVelocityY(gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getVelocityY() + (GravityData.gravity * GravityData.dt));
                    activeMario.setY((int) (gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getY() + gameScreenFrame.getLevelOneSectionOneScreen().activeMario.get(0).getVelocityY()));
                    activeMario.setMarioJumping(true);// Mario is jumping
                    if (gameScreenFrame.intersectInLevelOneSectionOne.isMarioHitsDownOfTheObject()) {// Mario hits down of an object and comes back to ground
                        activeMario.setVelocityY(0);
                        activeMario.setY((activeMario.getY() + 2));
                    } else if (gameScreenFrame.intersectInLevelOneSectionOne.isMarioHitsUpOfTheObject()) {// Mario hits up an object and stand on it
                        activeMario.setVelocityY(0);
                        activeMario.setY((activeMario.getY() - 2));
                        activeMario.setMarioJumping(false);// Mario stop jumping
                        gameScreenFrame.intersectInLevelOneSectionOne.setMarioHitsAnObject(false);
                        gameScreenFrame.intersectInLevelOneSectionOne.setMarioHitsFullOfCoinBlockInAir(false);
                        gameScreenFrame.intersectInLevelOneSectionOne.setMarioHitsTurtle(false);
                        isUserPressedUp = false;

                    }

                    if (activeMario.getY() >= 960 - activeMario.getHeight()
                            && activeMario.getY() <= 980 - activeMario.getHeight()) {// Mario Hits Ground and Stop jumping


                        upMario = false;
                        isUserPressedUp = false;
                        activeMario.setMarioJumping(false);
                        gameScreenFrame.intersectInLevelOneSectionOne.setMarioHitsAnObject(false);
                        gameScreenFrame.intersectInLevelOneSectionOne.setMarioHitsFullOfCoinBlockInAir(false);
                        gameScreenFrame.intersectInLevelOneSectionOne.setMarioHitsTurtle(false);
                    }

                }

                if (rightMario && !leftMario && !gameScreenFrame.intersectInLevelOneSectionOne.isMarioHitsLeftOfTheObject()) {// Go Right
                    if (activeMario.getX() < 830 || activeMario.getX() >= 5800) {// Move Mario
                        activeMario.setVelocityX(5);
                        activeMario.setX((int) (activeMario.getX() + activeMario.getVelocityX()));
                    } else {// Move Panel
                        int xLevelOneBackgroundPanel = gameScreenFrame.getXLevelOneBackgroundPanel();
                        gameScreenFrame.setXLevelOneBackgroundPanel(xLevelOneBackgroundPanel - 5);
                        activeMario.setVelocityX(5);
                        activeMario.setX((int) (activeMario.getX() + activeMario.getVelocityX()));
                        gameScreenFrame.getLevelOneSectionOneScreen().XThisGameCoinImage += 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().thisGameCoinImage.setX(gameScreenFrame.getLevelOneSectionOneScreen().XThisGameCoinImage);
                        gameScreenFrame.getLevelOneSectionOneScreen().XThisGameCoin += 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().XThisSectionTimeLabel += 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().XUserHeartImage += 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().userHeartImage.setX(gameScreenFrame.getLevelOneSectionOneScreen().XUserHeartImage);
                        gameScreenFrame.getLevelOneSectionOneScreen().XUserScoreLabel += 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().XUserHeartValueLabel += 5;
                    }
                }
                if (leftMario && !rightMario && !gameScreenFrame.intersectInLevelOneSectionOne.isMarioHitsRightOfTheObject()) {// Go Left
                    if (activeMario.getX() < 840 || activeMario.getX() >= 5800) {// Move Mario
                        activeMario.setVelocityX(-5);
                        activeMario.setX((int) (activeMario.getX() + activeMario.getVelocityX()));
                    } else {// Move Panel
                        int xLevelOneBackgroundPanel = gameScreenFrame.getXLevelOneBackgroundPanel();
                        gameScreenFrame.setXLevelOneBackgroundPanel(xLevelOneBackgroundPanel + 5);
                        activeMario.setVelocityX(-5);
                        activeMario.setX((int) (activeMario.getX() + activeMario.getVelocityX()));
                        gameScreenFrame.getLevelOneSectionOneScreen().XThisGameCoinImage -= 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().thisGameCoinImage.setX(gameScreenFrame.getLevelOneSectionOneScreen().XThisGameCoinImage);
                        gameScreenFrame.getLevelOneSectionOneScreen().XThisGameCoin -= 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().XThisSectionTimeLabel -= 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().XUserHeartImage -= 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().userHeartImage.setX(gameScreenFrame.getLevelOneSectionOneScreen().XUserHeartImage);
                        gameScreenFrame.getLevelOneSectionOneScreen().XUserScoreLabel -= 5;
                        gameScreenFrame.getLevelOneSectionOneScreen().XUserHeartValueLabel -= 5;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {// Game is in SectionTwo

            gameScreenFrame.getGameData().setMarioLocation("levelonesectiontwo");
            activeMario = gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0);
            gameScreenFrame.getPowerUp().loadPowerUp(activeMario);
            if (!marioEnterInLevelOneSectionTwo) {
                marioEnterInLevelOneSectionTwo = true;
                gameScreenFrame.getLevelOneSectionTwoScreen().thisSectionTime.setSectionTime(50);
                // Add Score At The End Of SectionOne
                gameScreenFrame.calculateScore.calculateScoreInSectionOneLevelOne();
            }

//            if (gameScreenFrame.getLevelTwoSectionTwoScreen().activeMario.get(0).getX() >= 6200) {// Level is Finish
//                gameScreenFrame.getGameData().setGameFinish(true);
//            }

            try {

                // GravityData:

                if (upMario) {// Mario start jumping

                    activeMario.setVelocityY(activeMario.getVelocityY() + (GravityData.gravity * GravityData.dt));
                    activeMario.setY((int) (activeMario.getY() + activeMario.getVelocityY()));
                    activeMario.setMarioJumping(true);// Mario is jumping
                    if (gameScreenFrame.intersectInLevelOneSectionTwo.isMarioHitsDownOfTheObject()) {// Mario hits down of an object and comes back to ground
                        activeMario.setVelocityY(0);
                        activeMario.setY(((activeMario).getY() + 2));
                    } else if (gameScreenFrame.intersectInLevelOneSectionTwo.isMarioHitsUpOfTheObject()) {// Mario hits up an object and stand on it
                        activeMario.setVelocityY(0);
                        activeMario.setY((gameScreenFrame.getLevelOneSectionTwoScreen().activeMario.get(0).getY() - 2));
                        activeMario.setMarioJumping(false);// Mario stop jumping
                        gameScreenFrame.intersectInLevelOneSectionTwo.setMarioHitsAnObject(false);
                        gameScreenFrame.intersectInLevelOneSectionTwo.setMarioHitsFullOfCoinBlockInAir(false);
                        isUserPressedUp = false;
                    }

                    if (activeMario.getY() >= 960 - activeMario.getHeight() && activeMario.getY() <= 980 - activeMario.getHeight()) {// Mario Hits Ground and Stop jumping

                        upMario = false;
                        isUserPressedUp = false;
                        activeMario.setMarioJumping(false);
                        gameScreenFrame.intersectInLevelOneSectionTwo.setMarioHitsAnObject(false);
                        gameScreenFrame.intersectInLevelOneSectionTwo.setMarioHitsFullOfCoinBlockInAir(false);
                    }

                }


                if (rightMario && !leftMario && !gameScreenFrame.intersectInLevelOneSectionTwo.isMarioHitsLeftOfTheObject()) {
                    if (activeMario.getX() < 830 || activeMario.getX() >= 5800) {// Move Mario
                        activeMario.setVelocityX(5);
                        activeMario.setX((int) (activeMario.getX() + activeMario.getVelocityX()));
                    } else {// Move Panel
                        int xLevelOneBackgroundPanel = gameScreenFrame.getXLevelOneBackgroundPanel();
                        gameScreenFrame.setXLevelOneBackgroundPanel(xLevelOneBackgroundPanel - 5);
                        activeMario.setVelocityX(5);
                        activeMario.setX((int) (activeMario.getX() + activeMario.getVelocityX()));
                        gameScreenFrame.getLevelOneSectionTwoScreen().XThisGameCoinImage += 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().thisGameCoinImage.setX(gameScreenFrame.getLevelOneSectionTwoScreen().XThisGameCoinImage);
                        gameScreenFrame.getLevelOneSectionTwoScreen().XThisGameCoin += 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().XThisSectionTimeLabel += 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().XUserHeartImage += 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().userHeartImage.setX(gameScreenFrame.getLevelOneSectionTwoScreen().XUserHeartImage);
                        gameScreenFrame.getLevelOneSectionTwoScreen().XUserScoreLabel += 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().XUserHeartValueLabel += 5;
                    }
                }
                if (leftMario && !rightMario && !gameScreenFrame.intersectInLevelOneSectionTwo.isMarioHitsRightOfTheObject()) {
                    if (activeMario.getX() < 840 || activeMario.getX() >= 5800) {// Move Mario
                        activeMario.setVelocityX(-5);
                        activeMario.setX((int) (activeMario.getX() + activeMario.getVelocityX()));

                    } else {// Move Panel
                        int xLevelOneBackgroundPanel = gameScreenFrame.getXLevelOneBackgroundPanel();
                        gameScreenFrame.setXLevelOneBackgroundPanel(xLevelOneBackgroundPanel + 5);
                        activeMario.setVelocityX(-5);
                        activeMario.setX((int) (activeMario.getX() + activeMario.getVelocityX()));
                        gameScreenFrame.getLevelOneSectionTwoScreen().XThisGameCoinImage -= 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().thisGameCoinImage.setX(gameScreenFrame.getLevelOneSectionTwoScreen().XThisGameCoinImage);
                        gameScreenFrame.getLevelOneSectionTwoScreen().XThisGameCoin -= 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().XThisSectionTimeLabel -= 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().XUserHeartImage -= 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().userHeartImage.setX(gameScreenFrame.getLevelOneSectionTwoScreen().XUserHeartImage);
                        gameScreenFrame.getLevelOneSectionTwoScreen().XUserScoreLabel -= 5;
                        gameScreenFrame.getLevelOneSectionTwoScreen().XUserHeartValueLabel -= 5;
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public void marioStartShooting() {

        if (!marioShooting) {
            return;
        }
        addShotToScreen();
        marioShooting = false;

    }

    public void marioStartsThrowsSword() {
        if (!marioThrowSword) {
            return;
        }
        addSwordToScreen();
        marioThrowSword = false;
    }

    public void addShotToScreen() {

        int x = activeMario.getX();
        int y = activeMario.getY() + 30;
        Arrow newArrow = new Arrow(x, y);
        newArrow.setMarioVelocity((int) activeMario.getVelocityX());

        if (gameData.getMarioLocation().equalsIgnoreCase("levelonesectionone")) {
            levelOneSectionOneScreen.add(newArrow, Integer.valueOf(1));
            levelOneSectionOneScreen.getWeaponsInThisSection().add(newArrow);
        } else if (gameData.getMarioLocation().equalsIgnoreCase("levelonesectiontwo")) {
            levelOneSectionTwoScreen.add(newArrow, Integer.valueOf(1));
            levelOneSectionTwoScreen.getWeaponsInThisSection().add(newArrow);
        }else if (gameData.getMarioLocation().equalsIgnoreCase("leveltwosectionone")) {
            levelTwoSectionOneScreen.add(newArrow, Integer.valueOf(1));
            levelTwoSectionOneScreen.getWeaponsInThisSection().add(newArrow);
        }else if (gameData.getMarioLocation().equalsIgnoreCase("leveltwosectiontwo")) {
            levelTwoSectionTwoScreen.add(newArrow, Integer.valueOf(1));
            levelTwoSectionTwoScreen.getWeaponsInThisSection().add(newArrow);
        }else if (gameData.getMarioLocation().equalsIgnoreCase("hiddencoinsection")) {
            hiddenCoinSectionScreen.add(newArrow, Integer.valueOf(1));
            hiddenCoinSectionScreen.getWeaponsInThisSection().add(newArrow);
        }else if (gameData.getMarioLocation().equalsIgnoreCase("hiddenenemysection")) {
            hiddenEnemySectionScreen.add(newArrow, Integer.valueOf(1));
            hiddenEnemySectionScreen.getWeaponsInThisSection().add(newArrow);
        }

    }

    public void addSwordToScreen() {

        int x = activeMario.getX();
//        int y = activeMario.getY() + 30;
        int y = 890;
        Sword newSword = new Sword(x, y);
        newSword.setMarioVelocity((int) activeMario.getVelocityX());

        if (gameData.getMarioLocation().equalsIgnoreCase("levelonesectionone")) {
            levelOneSectionOneScreen.add(newSword, Integer.valueOf(1));
            levelOneSectionOneScreen.getWeaponsInThisSection().add(newSword);
        } else if (gameData.getMarioLocation().equalsIgnoreCase("levelonesectiontwo")) {
            levelOneSectionTwoScreen.add(newSword, Integer.valueOf(1));
            levelOneSectionTwoScreen.getWeaponsInThisSection().add(newSword);
        }else if (gameData.getMarioLocation().equalsIgnoreCase("leveltwosectionone")) {
            levelTwoSectionOneScreen.add(newSword, Integer.valueOf(1));
            levelTwoSectionOneScreen.getWeaponsInThisSection().add(newSword);
        }else if (gameData.getMarioLocation().equalsIgnoreCase("leveltwosectiontwo")) {
            levelTwoSectionTwoScreen.add(newSword, Integer.valueOf(1));
            levelTwoSectionTwoScreen.getWeaponsInThisSection().add(newSword);
        }else if (gameData.getMarioLocation().equalsIgnoreCase("hiddencoinsection")) {
            hiddenCoinSectionScreen.add(newSword, Integer.valueOf(1));
            hiddenCoinSectionScreen.getWeaponsInThisSection().add(newSword);
        }else if (gameData.getMarioLocation().equalsIgnoreCase("hiddenenemysection")) {
            hiddenEnemySectionScreen.add(newSword, Integer.valueOf(1));
            hiddenEnemySectionScreen.getWeaponsInThisSection().add(newSword);
        }

    }

    public void changeMarioHeight() {

        if (isUpMario()) {
            return;
        }

        if (activeMario.isMarioMini()) {
            activeMario.setHeight(60);
            activeMario.setY(900);
        } else if (activeMario.isMarioMega() || activeMario.isMarioShooter()) {

            if (activeMario.isMarioSit()) {
                activeMario.setHeight(60);
                activeMario.setY(900);
            } else {
                activeMario.setHeight(120);
                activeMario.setY(840);
            }

        }

    }


    public boolean isRightMario() {
        return rightMario;
    }

    public void setRightMario(boolean rightMario) {
        this.rightMario = rightMario;
    }

    public boolean isLeftMario() {
        return leftMario;
    }

    public void setLeftMario(boolean leftMario) {
        this.leftMario = leftMario;
    }

    public boolean isUpMario() {
        return upMario;
    }

    public void setUpMario(boolean upMario) {
        this.upMario = upMario;
    }

    public boolean isUserPressedUp() {
        return isUserPressedUp;
    }

    public void setUserPressedUp(boolean userPressedUp) {
        isUserPressedUp = userPressedUp;
    }

    public boolean isUserPressedDown() {
        return isUserPressedDown;
    }

    public void setUserPressedDown(boolean userPressedDown) {
        isUserPressedDown = userPressedDown;
    }

    public boolean isMarioEnterInLevelOneSectionTwo() {
        return marioEnterInLevelOneSectionTwo;
    }

    public void setMarioEnterInLevelOneSectionTwo(boolean marioEnterInLevelOneSectionTwo) {
        this.marioEnterInLevelOneSectionTwo = marioEnterInLevelOneSectionTwo;
    }

    public boolean isMarioShooting() {
        return marioShooting;
    }

    public void setMarioShooting(boolean marioShooting) {
        this.marioShooting = marioShooting;
    }

    public boolean isMarioThrowSword() {
        return marioThrowSword;
    }

    public void setMarioThrowSword(boolean marioThrowSword) {
        this.marioThrowSword = marioThrowSword;
    }
}
