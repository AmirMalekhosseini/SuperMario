package Model;

import Graphic.*;

public class MarioMoverModel {

    GameGodFather godFather;
    ActiveLevel activeLevel;
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


    public MarioMoverModel(GameGodFather godFather) {

        this.godFather = godFather;
        this.gameData = godFather.getGameData();
        this.activeLevel = godFather.activeLevel;

    }

    public void locateMarioLocation() {

        if (godFather.getLevelOneGameBackgroundPanel() == godFather.activeLevel.levelPanel) {// Game is in LevelOne:

            if (!marioEnterInLevelOneSectionOne) {
                activeLevel.mario = godFather.getLevelOneSectionOneScreen().activeMario;
                activeMario = activeLevel.mario;
            }

            if (activeMario.getX() <= 6400) {// Game is in SectionOne:
                if (!marioEnterInLevelOneSectionOne) {
                    marioEnterInLevelOneSectionOne = true;
//                    godFather.getGameData().setMarioLocation("levelonesectionone");
                    activeLevel.intersect = godFather.intersectInLevelOneSectionOne;
                    activeLevel.screen = godFather.getLevelOneSectionOneScreen();
                    activeLevel.screenModel = godFather.getLevelOneSectionOneModel();

                }

            } else {// Game is in SectionTwo:

                if (!marioEnterInLevelOneSectionTwo) {// Mario Enter in SectionTwo:
                    godFather.getLevelOneGameBackgroundPanel().setLocation(-6800, 0);
                    activeLevel.mario = godFather.getLevelOneSectionTwoScreen().activeMario;
                    activeMario = activeLevel.mario;
                    activeLevel.intersect = godFather.intersectInLevelOneSectionTwo;
                    activeLevel.screen = godFather.getLevelOneSectionTwoScreen();
                    activeLevel.screenModel = godFather.getLevelOneSectionTwoModel();
                    godFather.gameTimer.setSectionTime(50);
                    // Add Score At The End Of SectionOne
                    godFather.calculateScore.calculateScore(godFather.getLevelOneSectionOneScreen());
//                    godFather.getGameData().setMarioLocation("levelonesectiontwo");
                    godFather.getPowerUp().loadPowerUp(activeMario);
                    marioEnterInLevelOneSectionTwo = true;
                }
            }

        } else if (godFather.getLevelTwoGameBackgroundPanel() == godFather.activeLevel.levelPanel) {// Game is in LevelTwo:

            if (activeMario.getX() <= 6700) {// Game is in SectionOne:

                if (!marioEnterInLevelTwoSectionOne) {
                    marioEnterInLevelTwoSectionOne = true;
                    godFather.gameTimer.setSectionTime(50);
                    // Add Score At The End Of LevelOneSectionTwo
                    godFather.calculateScore.calculateScore(godFather.getLevelOneSectionTwoScreen());
//                    godFather.getGameData().setMarioLocation("leveltwosectionone");
                    activeLevel.mario = godFather.getLevelTwoSectionOneScreen().activeMario;
                    activeMario = activeLevel.mario;
                    activeLevel.intersect = godFather.intersectInLevelTwoSectionOne;
                    activeLevel.screen = godFather.getLevelTwoSectionOneScreen();
                    activeLevel.screenModel = godFather.getLevelTwoSectionOneModel();
//                    godFather.getPowerUp().loadPowerUp(activeMario);

                }
            } else {// Game is in SectionTwo:

                if (!marioEnterInLevelTwoSectionTwo) {
                    marioEnterInLevelTwoSectionTwo = true;
                    godFather.gameTimer.setSectionTime(50);
                    // Add Score At The End Of SectionOne
                    godFather.calculateScore.calculateScore(godFather.getLevelTwoSectionTwoScreen());
                    godFather.getGameData().setMarioLocation("leveltwosectiontwo");
                    activeLevel.mario = godFather.getLevelTwoSectionTwoScreen().activeMario;
                    activeMario = activeLevel.mario;
                    activeLevel.intersect = godFather.intersectInLevelTwoSectionTwo;
                    activeLevel.screen = godFather.getLevelTwoSectionTwoScreen();
                    activeLevel.screenModel = godFather.getLevelTwoSectionTwoModel();
//                    godFather.getPowerUp().loadPowerUp(activeMario);

                }
            }

        } else if (godFather.getLevelThreeGameBackgroundPanel() == godFather.activeLevel.levelPanel) {

            godFather.getGameData().setMarioLocation("bossfightsection");
            activeLevel.mario = godFather.getBossFightScreenSection().activeMario;
            activeMario = activeLevel.mario;
            activeLevel.intersect = godFather.intersectInBossSection;
            activeLevel.screen = godFather.getBossFightScreenSection();
            activeLevel.screenModel = godFather.getBossFightSectionModel();
//            godFather.getPowerUp().loadPowerUp(activeMario);

        } else if (godFather.getHiddenCoinBackgroundPanel() == godFather.activeLevel.levelPanel) {// Game is in HiddenCoin:

            godFather.getGameData().setMarioLocation("hiddencoinsection");
            activeLevel.mario = godFather.getHiddenCoinSectionScreen().activeMario;
            activeMario = activeLevel.mario;
            activeLevel.intersect = godFather.intersectInHiddenCoinSection;
            activeLevel.screen = godFather.getHiddenCoinSectionScreen();
            activeLevel.screenModel = godFather.getHiddenCoinSectionModel();
//            godFather.getPowerUp().loadPowerUp(activeMario);

        } else if (godFather.getHiddenEnemyBackgroundPanel() == godFather.activeLevel.levelPanel) {// Game is in HiddenEnemy:

            godFather.getGameData().setMarioLocation("hiddenenemysection");
            activeLevel.mario = godFather.getHiddenEnemySectionScreen().activeMario;
            activeMario = activeLevel.mario;
            activeLevel.intersect = godFather.intersectInHiddenEnemySection;
            activeLevel.screen = godFather.getHiddenEnemySectionScreen();
            activeLevel.screenModel = godFather.getHiddenEnemySectionModel();
            godFather.getPowerUp().loadPowerUp(activeMario);

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

                activeMario.setMarioOnGround(false);
                activeMario.setVelocityY(activeMario.getVelocityY() + (GravityData.getGravityData().gravity * GravityData.getGravityData().marioDt));
                activeMario.setY((int) (activeMario.getY() + activeMario.getVelocityY()));
                activeMario.setMarioJumping(true);// Mario is jumping
                if (activeLevel.intersect.intersection.isMarioHitsDownOfTheObject()) {// Mario hits down of an object and comes back to ground
                    activeMario.setVelocityY(0);
                    activeMario.setY((activeMario.getY() + 2));
                } else if (activeLevel.intersect.intersection.isMarioHitsUpOfTheObject()) {// Mario hits up an object and stand on it
                    activeMario.setVelocityY(0);
                    activeMario.setY((activeMario.getY() - 2));
                    activeMario.setMarioJumping(false);// Mario stop jumping
                    activeLevel.intersect.intersection.setMarioHitsAnObject(false);
                    activeLevel.intersect.intersection.setMarioHitsFullOfCoinBlockInAir(false);
                    activeLevel.intersect.intersection.setMarioHitsTurtle(false);
                    if (activeLevel.intersect instanceof IntersectInBossSection) {
                        ((IntersectInBossSection) activeLevel.intersect).vilgaxIntersection.setMarioHitsVilgax(false);
                    }
                    isUserPressedUp = false;

                }

                if (activeMario.getY() >= 960 - activeMario.getHeight()
                        && activeMario.getY() <= 980 - activeMario.getHeight()) {// Mario Hits Ground and Stop jumping

                    upMario = false;
                    isUserPressedUp = false;
                    activeMario.setMarioOnGround(true);
                    activeMario.setMarioJumping(false);
                    activeLevel.intersect.intersection.setMarioHitsAnObject(false);
                    activeLevel.intersect.intersection.setMarioHitsFullOfCoinBlockInAir(false);
                    activeLevel.intersect.intersection.setMarioHitsTurtle(false);
                    if (activeLevel.intersect instanceof IntersectInBossSection) {
                        ((IntersectInBossSection) activeLevel.intersect).vilgaxIntersection.setMarioHitsVilgax(false);
                    }
                    GravityData.getGravityData().marioDt = 0.018;

                }

            }

            if (rightMario && !leftMario && !activeLevel.intersect.intersection.isMarioHitsLeftOfTheObject()) {// Go Right
                if (activeMario.getX() < 830 || activeMario.getX() >= 5800 || activeLevel.screen.isScreenLock()) {// Move Mario
                    activeMario.setVelocityX(5);
                    activeMario.setX((int) (activeMario.getX() + activeMario.getVelocityX()));
                } else {// Move Panel
//
                    int xLevelScreenBackgroundPanel = godFather.activeLevel.levelPanel.getX();
                    godFather.activeLevel.levelPanel.setLocation(xLevelScreenBackgroundPanel - 5, 0);

                    activeMario.setVelocityX(5);
                    activeMario.setX((int) (activeMario.getX() + activeMario.getVelocityX()));
                    activeLevel.screen.XThisGameCoinImage += 5;
                    activeLevel.screen.thisGameCoinImage.setX(activeLevel.screen.XThisGameCoinImage);
                    activeLevel.screen.XThisGameCoin += 5;
                    activeLevel.screen.XThisSectionTimeLabel += 5;
                    activeLevel.screen.XUserHeartImage += 5;
                    activeLevel.screen.userHeartImage.setX(activeLevel.screen.XUserHeartImage);
                    activeLevel.screen.XUserScoreLabel += 5;
                    activeLevel.screen.XUserHeartValueLabel += 5;

                }
            }
            // ToDO: Move Calculation Outside.
            if (leftMario && !rightMario && !activeLevel.intersect.intersection.isMarioHitsRightOfTheObject()) {// Go Left
                if (activeMario.getX() < 840 || activeMario.getX() >= 5800 || activeLevel.screen.isScreenLock()) {// Move Mario
                    activeMario.setVelocityX(-5);
                    activeMario.setX((int) (activeMario.getX() + activeMario.getVelocityX()));
                } else {// Move Panel
                    int xLevelScreenBackgroundPanel = godFather.activeLevel.levelPanel.getX();
                    godFather.activeLevel.levelPanel.setLocation(xLevelScreenBackgroundPanel + 5, 0);
                    activeMario.setVelocityX(-5);
                    activeMario.setX((int) (activeMario.getX() + activeMario.getVelocityX()));
                    activeLevel.screen.XThisGameCoinImage -= 5;
                    activeLevel.screen.thisGameCoinImage.setX(activeLevel.screen.XThisGameCoinImage);
                    activeLevel.screen.XThisGameCoin -= 5;
                    activeLevel.screen.XThisSectionTimeLabel -= 5;
                    activeLevel.screen.XUserHeartImage -= 5;
                    activeLevel.screen.userHeartImage.setX(activeLevel.screen.XUserHeartImage);
                    activeLevel.screen.XUserScoreLabel -= 5;
                    activeLevel.screen.XUserHeartValueLabel -= 5;
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

        activeLevel.screen.add(newArrow, Integer.valueOf(1));
        activeLevel.screen.getWeaponsInThisSection().add(newArrow);

    }

    public void addSwordToScreen() {

        int x = activeMario.getX();
//        int y = mario.getY() + 30;
        int y = 890;
        Sword newSword = new Sword(x, y);
        newSword.setMarioVelocity((int) activeMario.getVelocityX());

        activeLevel.screen.add(newSword, Integer.valueOf(1));
        activeLevel.screen.getWeaponsInThisSection().add(newSword);

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
