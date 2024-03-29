package Controller.Game;

import View.Game.LevelScreens;
import Model.Game.GameGodFather;
import Model.Mario.MarioWeapon;
import Model.Object.PrizeInAir;

public class IntersectInHiddenEnemySection extends IntersectInGame{

    public IntersectInHiddenEnemySection(GameGodFather gameGodFather) {
        this.gameGodFather = gameGodFather;
        this.powerUp = gameGodFather.getPowerUp();
        this.levelScreen = gameGodFather.getHiddenEnemySectionScreen();

        intersection = new Intersection(gameGodFather, powerUp, levelScreen) {
            @Override
            public void marioIntersectWithObjects() {
                super.marioIntersectWithObjects();
            }

            @Override
            public void marioIntersectWithItems() {
                super.marioIntersectWithItems();
            }

            @Override
            public boolean marioIntersectWithEnemies() {
                return super.marioIntersectWithEnemies();
            }

            @Override
            public void arrowIntersection(MarioWeapon arrow) {
                super.arrowIntersection(arrow);
            }

            @Override
            public void intersectShot() {
                super.intersectShot();
            }

            @Override
            public void shieldIntersection(MarioWeapon shield) {
                super.shieldIntersection(shield);
            }

            @Override
            public void swordIntersection(MarioWeapon sword) {
                super.swordIntersection(sword);
            }

            @Override
            public void generateRandomItem(PrizeInAir prizeInAir) {
                super.generateRandomItem(prizeInAir);
            }

            @Override
            public void refreshIntersectsBooleans() {
                super.refreshIntersectsBooleans();
            }

            @Override
            public boolean isMarioHitsFullOfCoinBlockInAir() {
                return super.isMarioHitsFullOfCoinBlockInAir();
            }

            @Override
            public void setMarioHitsFullOfCoinBlockInAir(boolean marioHitsFullOfCoinBlockInAir) {
                super.setMarioHitsFullOfCoinBlockInAir(marioHitsFullOfCoinBlockInAir);
            }

            @Override
            public boolean isMarioHitsAnObject() {
                return super.isMarioHitsAnObject();
            }

            @Override
            public void setMarioHitsAnObject(boolean marioHitsAnObject) {
                super.setMarioHitsAnObject(marioHitsAnObject);
            }

            @Override
            public boolean isMarioHitsLeftOfTheObject() {
                return super.isMarioHitsLeftOfTheObject();
            }

            @Override
            public void setMarioHitsLeftOfTheObject(boolean marioHitsLeftOfTheObject) {
                super.setMarioHitsLeftOfTheObject(marioHitsLeftOfTheObject);
            }

            @Override
            public boolean isMarioHitsRightOfTheObject() {
                return super.isMarioHitsRightOfTheObject();
            }

            @Override
            public void setMarioHitsRightOfTheObject(boolean marioHitsRightOfTheObject) {
                super.setMarioHitsRightOfTheObject(marioHitsRightOfTheObject);
            }

            @Override
            public boolean isMarioHitsUpOfTheObject() {
                return super.isMarioHitsUpOfTheObject();
            }

            @Override
            public void setMarioHitsUpOfTheObject(boolean marioHitsUpOfTheObject) {
                super.setMarioHitsUpOfTheObject(marioHitsUpOfTheObject);
            }

            @Override
            public boolean isMarioHitsDownOfTheObject() {
                return super.isMarioHitsDownOfTheObject();
            }

            @Override
            public void setMarioHitsDownOfTheObject(boolean marioHitsDownOfTheObject) {
                super.setMarioHitsDownOfTheObject(marioHitsDownOfTheObject);
            }

            @Override
            public boolean isMarioHitsTurtle() {
                return super.isMarioHitsTurtle();
            }

            @Override
            public void setMarioHitsTurtle(boolean marioHitsTurtle) {
                super.setMarioHitsTurtle(marioHitsTurtle);
            }

            @Override
            public GameGodFather getGameScreenFrame() {
                return super.getGameScreenFrame();
            }

            @Override
            public void setGameScreenFrame(GameGodFather gameGodFather) {
                super.setGameScreenFrame(gameGodFather);
            }

            @Override
            public LevelScreens getScreen() {
                return super.getScreen();
            }

            @Override
            public void setScreen(LevelScreens screen) {
                super.setScreen(screen);
            }

            @Override
            public PowerUp getPowerUp() {
                return super.getPowerUp();
            }

            @Override
            public void setPowerUp(PowerUp powerUp) {
                super.setPowerUp(powerUp);
            }
        };

    }

    public IntersectInHiddenEnemySection() {

    }
}
