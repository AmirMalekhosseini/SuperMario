package Model;

import Graphic.*;

public class MarioMoverModel {

    GameGodFather gameGodFather;
    LevelScreens activeScreen;
    IntersectInGame activeIntersection;
    LevelOneSectionOneScreen levelOneSectionOneScreen;
    LevelOneSectionTwoScreen levelOneSectionTwoScreen;
    LevelTwoSectionOneScreen levelTwoSectionOneScreen;
    LevelTwoSectionTwoScreen levelTwoSectionTwoScreen;
    HiddenCoinSectionScreen hiddenCoinSectionScreen;
    HiddenEnemySectionScreen hiddenEnemySectionScreen;
    GameData gameData;
    private volatile boolean rightMario;
    private volatile boolean leftMario;
    private volatile boolean upMario;
    private volatile boolean isUserPressedUp;
    private volatile boolean isUserPressedDown;
    private boolean marioEnterInLevelOneSectionOne;
    private boolean marioEnterInLevelOneSectionTwo;
    private boolean marioEnterInLevelTwoSectionOne;
    private boolean marioEnterInLevelTwoSectionTwo;
    private boolean marioEnterInHiddenCoinSection;
    private boolean marioEnterInHiddenEnemySection;
    private boolean marioShooting;
    private boolean marioThrowSword;
    public Mario activeMario;


    public MarioMoverModel(GameGodFather gameGodFather) {

        this.gameGodFather = gameGodFather;
        this.levelOneSectionOneScreen = gameGodFather.getLevelOneSectionOneScreen();
        this.levelOneSectionTwoScreen = gameGodFather.getLevelOneSectionTwoScreen();
        this.levelTwoSectionOneScreen = gameGodFather.getLevelTwoSectionOneScreen();
        this.levelTwoSectionTwoScreen = gameGodFather.getLevelTwoSectionTwoScreen();
        this.hiddenCoinSectionScreen = gameGodFather.getHiddenCoinSectionScreen();
        this.hiddenEnemySectionScreen = gameGodFather.getHiddenEnemySectionScreen();
        this.gameData = gameGodFather.getGameData();

    }

    public void locateMarioLocation() {

        if (gameGodFather.getLevelOneGameBackgroundPanel() == gameGodFather.currentPanel) {// Game is in LevelOne:

            if (!marioEnterInLevelOneSectionOne) {
                activeMario = gameGodFather.getLevelOneSectionOneScreen().activeMario.get(0);
            }

            if (activeMario.getX() <= 6400) {// Game is in SectionOne:
                if (!marioEnterInLevelOneSectionOne) {
                    marioEnterInLevelOneSectionOne = true;
//                    gameGodFather.getGameData().setMarioLocation("levelonesectionone");
                    activeIntersection = gameGodFather.intersectInLevelOneSectionOne;
                    activeScreen = gameGodFather.getLevelOneSectionOneScreen();

                }

            } else {// Game is in SectionTwo:

                if (!marioEnterInLevelOneSectionTwo) {// Mario Enter in SectionTwo:
                    gameGodFather.getLevelOneGameBackgroundPanel().setLocation(-6800, 0);
                    activeMario = gameGodFather.getLevelOneSectionTwoScreen().activeMario.get(0);
                    activeScreen = gameGodFather.getLevelOneSectionTwoScreen();
                    activeIntersection = gameGodFather.intersectInLevelOneSectionTwo;
                    marioEnterInLevelOneSectionTwo = true;
                    gameGodFather.getLevelOneSectionTwoScreen().thisSectionTime.setSectionTime(50);
                    // Add Score At The End Of SectionOne
                    gameGodFather.calculateScore.calculateScore(gameGodFather.getLevelOneSectionOneScreen());
//                    gameGodFather.getGameData().setMarioLocation("levelonesectiontwo");
                    gameGodFather.getPowerUp().loadPowerUp(activeMario);
                }
            }

        } else if (gameGodFather.getLevelTwoGameBackgroundPanel() == gameGodFather.currentPanel) {// Game is in LevelTwo:


            activeScreen = gameGodFather.getLevelTwoSectionOneScreen();
            activeMario = gameGodFather.getLevelTwoSectionOneScreen().activeMario.get(0);
            if (activeMario.getX() <= 6700) {// Game is in SectionOne:

                if (!marioEnterInLevelTwoSectionOne) {
                    marioEnterInLevelTwoSectionOne = true;
                    gameGodFather.getLevelTwoSectionOneScreen().thisSectionTime.setSectionTime(50);
                    // Add Score At The End Of LevelOneSectionTwo
                    gameGodFather.calculateScore.calculateScore(gameGodFather.getLevelOneSectionTwoScreen());
//                    gameGodFather.getGameData().setMarioLocation("leveltwosectionone");
//                    gameGodFather.getPowerUp().loadPowerUp(activeMario);
                    activeIntersection = gameGodFather.intersectInLevelTwoSectionOne;
                }
            } else {// Game is in SectionTwo:

                if (!marioEnterInLevelTwoSectionTwo) {
                    marioEnterInLevelTwoSectionTwo = true;
                    gameGodFather.getLevelTwoSectionTwoScreen().thisSectionTime.setSectionTime(50);
                    // Add Score At The End Of SectionOne
                    gameGodFather.calculateScore.calculateScore(gameGodFather.getLevelTwoSectionTwoScreen());
                    gameGodFather.getGameData().setMarioLocation("leveltwosectiontwo");
                    gameGodFather.getPowerUp().loadPowerUp(activeMario);
                    activeMario = gameGodFather.getLevelTwoSectionTwoScreen().activeMario.get(0);
                    activeScreen = gameGodFather.getLevelTwoSectionTwoScreen();
                    activeIntersection = gameGodFather.intersectInLevelTwoSectionTwo;
                }
            }

        } else if (gameGodFather.getHiddenCoinBackgroundPanel() == gameGodFather.currentPanel) {// Game is in HiddenCoin:

            gameGodFather.getGameData().setMarioLocation("hiddencoinsection");
//            gameGodFather.getPowerUp().loadPowerUp(activeMario);
            activeMario = gameGodFather.getHiddenCoinSectionScreen().activeMario.get(0);
            activeScreen = gameGodFather.getHiddenCoinSectionScreen();
            activeIntersection = gameGodFather.intersectInHiddenCoinSection;

        } else if (gameGodFather.getHiddenEnemyBackgroundPanel() == gameGodFather.currentPanel) {// Game is in HiddenEnemy:

            gameGodFather.getGameData().setMarioLocation("hiddenenemysection");
            gameGodFather.getPowerUp().loadPowerUp(activeMario);
            activeMario = gameGodFather.getHiddenEnemySectionScreen().activeMario.get(0);
            activeScreen = gameGodFather.getHiddenEnemySectionScreen();
            activeIntersection = gameGodFather.intersectInHiddenEnemySection;

        }


    }

    public void move() {

        try {

            if (isUserPressedUp && isUserPressedDown) {// When both button pressed together:
                upMario = false;
                isUserPressedUp = false;
                activeMario.setMarioSit(false);
                return;
            }

            // Gravity:

            if (upMario) {// Mario start jumping

                activeMario.setVelocityY(activeMario.getVelocityY() + (GravityData.getGravityData().gravity * GravityData.getGravityData().marioDt));
                activeMario.setY((int) (activeMario.getY() + activeMario.getVelocityY()));
                activeMario.setMarioJumping(true);// Mario is jumping
                if (activeIntersection.intersection.isMarioHitsDownOfTheObject()) {// Mario hits down of an object and comes back to ground
                    activeMario.setVelocityY(0);
                    activeMario.setY((activeMario.getY() + 2));
                } else if (activeIntersection.intersection.isMarioHitsUpOfTheObject()) {// Mario hits up an object and stand on it
                    activeMario.setVelocityY(0);
                    activeMario.setY((activeMario.getY() - 2));
                    activeMario.setMarioJumping(false);// Mario stop jumping
                    activeIntersection.intersection.setMarioHitsAnObject(false);
                    activeIntersection.intersection.setMarioHitsFullOfCoinBlockInAir(false);
                    activeIntersection.intersection.setMarioHitsTurtle(false);
                    isUserPressedUp = false;

                }

                if (activeMario.getY() >= 960 - activeMario.getHeight()
                        && activeMario.getY() <= 980 - activeMario.getHeight()) {// Mario Hits Ground and Stop jumping

                    upMario = false;
                    isUserPressedUp = false;
                    activeMario.setMarioJumping(false);
                    activeIntersection.intersection.setMarioHitsAnObject(false);
                    activeIntersection.intersection.setMarioHitsFullOfCoinBlockInAir(false);
                    activeIntersection.intersection.setMarioHitsTurtle(false);

                }

            }

            if (rightMario && !leftMario && !activeIntersection.intersection.isMarioHitsLeftOfTheObject()) {// Go Right
                if (activeMario.getX() < 830 || activeMario.getX() >= 5800) {// Move Mario
                    activeMario.setVelocityX(5);
                    activeMario.setX((int) (activeMario.getX() + activeMario.getVelocityX()));
                } else {// Move Panel
//
                    int xLevelScreenBackgroundPanel = gameGodFather.currentPanel.getX();
                    gameGodFather.currentPanel.setLocation(xLevelScreenBackgroundPanel - 5, 0);

                    activeMario.setVelocityX(5);
                    activeMario.setX((int) (activeMario.getX() + activeMario.getVelocityX()));
                    activeScreen.XThisGameCoinImage += 5;
                    activeScreen.thisGameCoinImage.setX(activeScreen.XThisGameCoinImage);
                    activeScreen.XThisGameCoin += 5;
                    activeScreen.XThisSectionTimeLabel += 5;
                    activeScreen.XUserHeartImage += 5;
                    activeScreen.userHeartImage.setX(activeScreen.XUserHeartImage);
                    activeScreen.XUserScoreLabel += 5;
                    activeScreen.XUserHeartValueLabel += 5;

                }
            }
            if (leftMario && !rightMario && !activeIntersection.intersection.isMarioHitsRightOfTheObject()) {// Go Left
                if (activeMario.getX() < 840 || activeMario.getX() >= 5800) {// Move Mario
                    activeMario.setVelocityX(-5);
                    activeMario.setX((int) (activeMario.getX() + activeMario.getVelocityX()));
                } else {// Move Panel
                    int xLevelScreenBackgroundPanel = gameGodFather.currentPanel.getX();
                    gameGodFather.currentPanel.setLocation(xLevelScreenBackgroundPanel + 5, 0);
                    activeMario.setVelocityX(-5);
                    activeMario.setX((int) (activeMario.getX() + activeMario.getVelocityX()));
                    activeScreen.XThisGameCoinImage -= 5;
                    activeScreen.thisGameCoinImage.setX(activeScreen.XThisGameCoinImage);
                    activeScreen.XThisGameCoin -= 5;
                    activeScreen.XThisSectionTimeLabel -= 5;
                    activeScreen.XUserHeartImage -= 5;
                    activeScreen.userHeartImage.setX(activeScreen.XUserHeartImage);
                    activeScreen.XUserScoreLabel -= 5;
                    activeScreen.XUserHeartValueLabel -= 5;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
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
        } else if (gameData.getMarioLocation().equalsIgnoreCase("leveltwosectionone")) {
            levelTwoSectionOneScreen.add(newArrow, Integer.valueOf(1));
            levelTwoSectionOneScreen.getWeaponsInThisSection().add(newArrow);
        } else if (gameData.getMarioLocation().equalsIgnoreCase("leveltwosectiontwo")) {
            levelTwoSectionTwoScreen.add(newArrow, Integer.valueOf(1));
            levelTwoSectionTwoScreen.getWeaponsInThisSection().add(newArrow);
        } else if (gameData.getMarioLocation().equalsIgnoreCase("hiddencoinsection")) {
            hiddenCoinSectionScreen.add(newArrow, Integer.valueOf(1));
            hiddenCoinSectionScreen.getWeaponsInThisSection().add(newArrow);
        } else if (gameData.getMarioLocation().equalsIgnoreCase("hiddenenemysection")) {
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
        } else if (gameData.getMarioLocation().equalsIgnoreCase("leveltwosectionone")) {
            levelTwoSectionOneScreen.add(newSword, Integer.valueOf(1));
            levelTwoSectionOneScreen.getWeaponsInThisSection().add(newSword);
        } else if (gameData.getMarioLocation().equalsIgnoreCase("leveltwosectiontwo")) {
            levelTwoSectionTwoScreen.add(newSword, Integer.valueOf(1));
            levelTwoSectionTwoScreen.getWeaponsInThisSection().add(newSword);
        } else if (gameData.getMarioLocation().equalsIgnoreCase("hiddencoinsection")) {
            hiddenCoinSectionScreen.add(newSword, Integer.valueOf(1));
            hiddenCoinSectionScreen.getWeaponsInThisSection().add(newSword);
        } else if (gameData.getMarioLocation().equalsIgnoreCase("hiddenenemysection")) {
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

    public boolean isMarioEnterInLevelOneSectionOne() {
        return marioEnterInLevelOneSectionOne;
    }

    public void setMarioEnterInLevelOneSectionOne(boolean marioEnterInLevelOneSectionOne) {
        this.marioEnterInLevelOneSectionOne = marioEnterInLevelOneSectionOne;
    }

    public boolean isMarioEnterInLevelOneSectionTwo() {
        return marioEnterInLevelOneSectionTwo;
    }

    public void setMarioEnterInLevelOneSectionTwo(boolean marioEnterInLevelOneSectionTwo) {
        this.marioEnterInLevelOneSectionTwo = marioEnterInLevelOneSectionTwo;
    }

    public boolean isMarioEnterInLevelTwoSectionOne() {
        return marioEnterInLevelTwoSectionOne;
    }

    public void setMarioEnterInLevelTwoSectionOne(boolean marioEnterInLevelTwoSectionOne) {
        this.marioEnterInLevelTwoSectionOne = marioEnterInLevelTwoSectionOne;
    }

    public boolean isMarioEnterInLevelTwoSectionTwo() {
        return marioEnterInLevelTwoSectionTwo;
    }

    public void setMarioEnterInLevelTwoSectionTwo(boolean marioEnterInLevelTwoSectionTwo) {
        this.marioEnterInLevelTwoSectionTwo = marioEnterInLevelTwoSectionTwo;
    }

    public boolean isMarioEnterInHiddenCoinSection() {
        return marioEnterInHiddenCoinSection;
    }

    public void setMarioEnterInHiddenCoinSection(boolean marioEnterInHiddenCoinSection) {
        this.marioEnterInHiddenCoinSection = marioEnterInHiddenCoinSection;
    }

    public boolean isMarioEnterInHiddenEnemySection() {
        return marioEnterInHiddenEnemySection;
    }

    public void setMarioEnterInHiddenEnemySection(boolean marioEnterInHiddenEnemySection) {
        this.marioEnterInHiddenEnemySection = marioEnterInHiddenEnemySection;
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
