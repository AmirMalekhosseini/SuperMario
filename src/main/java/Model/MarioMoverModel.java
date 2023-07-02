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
    private boolean marioEnterInBossSection;
    private boolean marioEnterInHiddenCoinSection;
    private boolean marioEnterInHiddenEnemySection;
    private boolean marioShooting;
    private boolean marioThrowSword;
    public Mario activeMario;
    private volatile boolean isMarioMoveRight;
    private volatile boolean isMarioMoveLeft;


    public MarioMoverModel(GameGodFather godFather) {

        this.godFather = godFather;
        this.gameData = godFather.getGameData();
        this.activeLevel = godFather.activeLevel;

    }

    public void locateMarioLocation() {

        if (!marioEnterInLevelOneSectionOne) {
            godFather.activeLevel.mario = godFather.getLevelOneSectionOneScreen().activeMario;
            activeMario = godFather.activeLevel.mario;
            activeLevel.intersect = godFather.intersectInLevelOneSectionOne;
            activeLevel.screen = godFather.getLevelOneSectionOneScreen();
            activeLevel.screenModel = godFather.getLevelOneSectionOneModel();
            marioEnterInLevelOneSectionOne = true;
            CheckPointSave.getCheckPointSave().save(activeLevel.screen);
            CheckPointSave.getCheckPointSave().saveXPanel(godFather.activeLevel.levelPanel.getX());

        }

        if (activeMario.getX() >= 6400) {
            if (godFather.activeLevel.screenModel instanceof NormalScreenModel) {
                ((NormalScreenModel) godFather.activeLevel.screenModel).goToNextSection();

            }
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
                } else if (activeLevel.intersect.intersection.isMarioHitsUpOfTheObject() ||
                        activeLevel.intersect.intersection.isMarioHitsUpOfTheVilgax()) {// Mario hits up an object and stand on it
                    activeMario.setVelocityY(0);
                    activeMario.setY((activeMario.getY() - 2));
                    activeMario.setMarioJumping(false);// Mario stop jumping
                    activeLevel.intersect.intersection.setMarioHitsAnObject(false);
                    activeLevel.intersect.intersection.setMarioHitsFullOfCoinBlockInAir(false);
                    activeLevel.intersect.intersection.setMarioHitsTurtle(false);
                    if (activeLevel.intersect.intersection.isMarioHitsUpOfTheObject()
                            && activeLevel.levelPanel == godFather.getLevelThreeGameBackgroundPanel()) {
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
                if (isMarioMoveRight) {// Move Mario
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
                    activeLevel.screen.XMarioLocationLabel += 5;

                }
            }
            if (leftMario && !rightMario && !activeLevel.intersect.intersection.isMarioHitsRightOfTheObject()) {// Go Left
                if (isMarioMoveLeft) {// Move Mario
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
                    activeLevel.screen.XMarioLocationLabel -= 5;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void marioStartShooting() {

        if (!marioShooting || godFather.gameTimer.marioShotCoolDown.counter > 0) {
            // Mario Can't Shoot.
            return;
        }
        // Active CoolDown:
        godFather.gameTimer.marioShotCoolDown.counter = 3;
        addShotToScreen();
        marioShooting = false;

    }

    public void marioStartsThrowsSword() {
        if (!marioThrowSword
                || godFather.gameTimer.marioShotCoolDown.counter > 0
                || gameData.thisGameCoin < 3) {

            // Mario Can't Shoot.
            return;
        }
        // Active CoolDown:
        godFather.gameTimer.marioShotCoolDown.counter = 3;
        gameData.thisGameCoin -= 3;
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

    public void moveMarioRight() {


        // Move Mario:
        isMarioMoveRight = activeMario.getX() < 830
                || activeMario.getX() >= 5800
                || activeLevel.screen.isScreenLock();

    }

    public void moveMarioLeft() {

        isMarioMoveLeft = activeMario.getX() < 840
                || activeMario.getX() >= 5800
                || activeLevel.screen.isScreenLock();

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

    public boolean isMarioEnterInBossSection() {
        return marioEnterInBossSection;
    }

    public void setMarioEnterInBossSection(boolean marioEnterInBossSection) {
        this.marioEnterInBossSection = marioEnterInBossSection;
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
