package Model;

import Graphic.GameScreenFrame;

public class Gravity {

    public static final int gravity = 10;
    public static final double dt = 0.018;

    GameScreenFrame gameScreenFrame;

    public Gravity(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
    }

    public Gravity() {

    }

    public void objectsGravityInLevelOneSectionOne() {

        for (int i = 0; i < gameScreenFrame.getLevelOneSectionOneScreen().getItemsInThisSection().size(); i++) {

            // Object is on the Ground or On an Object:
            if (gameScreenFrame.intersectInLevelOneSectionOne.isItemOnTopOfAnObject
                    (gameScreenFrame.getLevelOneSectionOneScreen().getItemsInThisSection().get(i)) &&
                    (gameScreenFrame.getLevelOneSectionOneScreen().getItemsInThisSection().get(i).getY() <=
                            920 - gameScreenFrame.getLevelOneSectionOneScreen().getItemsInThisSection().get(i).getHeight())){
                int currentY = gameScreenFrame.getLevelOneSectionOneScreen().getItemsInThisSection().get(i).getY();
                gameScreenFrame.getLevelOneSectionOneScreen().getItemsInThisSection().get(i).setY(currentY + 10);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }

        for (int i = 0; i < gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().size(); i++) {


            if (gameScreenFrame.intersectInLevelOneSectionOne.isItemOnTopOfAnObject
                    (gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i)) &&
                    (gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).getY() <=
                            940 - gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).getHeight())) {
                // Object is not on the Ground or On an Object:
                int currentY = gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).getY();
                gameScreenFrame.getLevelOneSectionOneScreen().getEnemiesInThisSection().get(i).setY(currentY + 10);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public void objectsGravityInLevelOneSectionTwo() {

        for (int i = 0; i < gameScreenFrame.getLevelOneSectionTwoScreen().getItemsInThisSection().size(); i++) {

            // Object is on the Ground or On an Object:
            if (!gameScreenFrame.intersectInLevelOneSectionTwo.isItemOnTopOfAnObject
                    (gameScreenFrame.getLevelOneSectionTwoScreen().getItemsInThisSection().get(i)) &&
                    (gameScreenFrame.getLevelOneSectionTwoScreen().getItemsInThisSection().get(i).getY() <=
                            920 - gameScreenFrame.getLevelOneSectionTwoScreen().getItemsInThisSection().get(i).getHeight())){
                int currentY = gameScreenFrame.getLevelOneSectionTwoScreen().getItemsInThisSection().get(i).getY();
                gameScreenFrame.getLevelOneSectionTwoScreen().getItemsInThisSection().get(i).setY(currentY + 10);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        for (int i = 0; i < gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().size(); i++) {

            // Object is on the Ground or On an Object:
            if (gameScreenFrame.intersectInLevelOneSectionTwo.isItemOnTopOfAnObject
                    (gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i)) &&
                    (gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i).getY() <=
                            920 - gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i).getHeight())){
                int currentY = gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i).getY();
                gameScreenFrame.getLevelOneSectionTwoScreen().getEnemiesInThisSection().get(i).setY(currentY + 10);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public void objectsGravityInLevelTwoSectionOne() {

        for (int i = 0; i < gameScreenFrame.getLevelTwoSectionOneScreen().getItemsInThisSection().size(); i++) {

            // Object is on the Ground or On an Object:
            if (!gameScreenFrame.intersectInLevelTwoSectionOne.isItemOnTopOfAnObject
                    (gameScreenFrame.getLevelTwoSectionOneScreen().getItemsInThisSection().get(i)) &&
                    (gameScreenFrame.getLevelTwoSectionOneScreen().getItemsInThisSection().get(i).getY() <=
                            920 - gameScreenFrame.getLevelTwoSectionOneScreen().getItemsInThisSection().get(i).getHeight())){
                int currentY = gameScreenFrame.getLevelTwoSectionOneScreen().getItemsInThisSection().get(i).getY();
                gameScreenFrame.getLevelTwoSectionOneScreen().getItemsInThisSection().get(i).setY(currentY + 10);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        for (int i = 0; i < gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().size(); i++) {

            // Object is on the Ground or On an Object:
            if (!gameScreenFrame.intersectInLevelTwoSectionOne.isItemOnTopOfAnObject
                    (gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i)) &&
                    (gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i).getY() <=
                            920 - gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i).getHeight())){
                int currentY = gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i).getY();
                gameScreenFrame.getLevelTwoSectionOneScreen().getEnemiesInThisSection().get(i).setY(currentY + 10);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public void objectsGravityInLevelTwoSectionTwo() {

        for (int i = 0; i < gameScreenFrame.getLevelTwoSectionTwoScreen().getItemsInThisSection().size(); i++) {

            // Object is on the Ground or On an Object:
            if (!gameScreenFrame.intersectInLevelTwoSectionTwo.isItemOnTopOfAnObject
                    (gameScreenFrame.getLevelTwoSectionTwoScreen().getItemsInThisSection().get(i)) &&
                    (gameScreenFrame.getLevelTwoSectionTwoScreen().getItemsInThisSection().get(i).getY() <=
                            920 - gameScreenFrame.getLevelTwoSectionTwoScreen().getItemsInThisSection().get(i).getHeight())){
                int currentY = gameScreenFrame.getLevelTwoSectionTwoScreen().getItemsInThisSection().get(i).getY();
                gameScreenFrame.getLevelTwoSectionTwoScreen().getItemsInThisSection().get(i).setY(currentY + 10);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        for (int i = 0; i < gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().size(); i++) {

            // Object is on the Ground or On an Object:
            if (!gameScreenFrame.intersectInLevelTwoSectionTwo.isItemOnTopOfAnObject
                    (gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i)) &&
                    (gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i).getY() <=
                            920 - gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i).getHeight())){
                int currentY = gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i).getY();
                gameScreenFrame.getLevelTwoSectionTwoScreen().getEnemiesInThisSection().get(i).setY(currentY + 10);
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }



    public GameScreenFrame getGameScreenFrame() {
        return gameScreenFrame;
    }

    public void setGameScreenFrame(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
    }
}
