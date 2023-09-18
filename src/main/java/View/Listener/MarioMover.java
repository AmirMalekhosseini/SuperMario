package View.Listener;

import javax.swing.*;

import Controller.Game.MarioMoverController;
import Model.Game.GameGodFather;

import java.awt.event.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SuppressWarnings("deprecation")
public class MarioMover {

    private GameGodFather gameGodFather;
    private MarioMoverController marioMoverController;
    private boolean isLeftPress;
    private boolean isRightPress;
    InputMap inputMap;
    ActionMap actionMap;

    public MarioMover(GameGodFather gameGodFather) {
        this.gameGodFather = gameGodFather;
        this.marioMoverController = gameGodFather.marioMoverController;
        createKeyBindings();
    }

    private void createKeyBindings() {

        inputMap = gameGodFather.getGameScreenFrame().getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        actionMap = gameGodFather.getGameScreenFrame().getRootPane().getActionMap();

        // Key Press:
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SHIFT, InputEvent.SHIFT_MASK), "shoot");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "moveUp");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "moveDown");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "moveLeft");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "moveRight");

        // Key Release:
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SHIFT, InputEvent.SHIFT_MASK, true), "shootReleased");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "moveUpReleased");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "moveDownReleased");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0, true), "moveLeftReleased");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0, true), "moveRightReleased");

        actionMap.put("shoot", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!marioMoverController.activeMario.isMarioShooter()
                || gameGodFather.getGameData().isGamePause) {
                    return;
                }
                marioMoverController.setMarioShooting(true);
                marioMoverController.activeMario.setMarioShooting(true);
                marioMoverController.marioStartShooting();
            }
        });

        actionMap.put("moveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameGodFather.getGameData().isGamePause) {
                    return;
                }
                if (!marioMoverController.isUserPressedUp()) {
                    marioMoverController.setUpMario(true);
                    marioMoverController.activeMario.setVelocityY(-10);
                    marioMoverController.setUserPressedUp(true);
                }
            }
        });

        actionMap.put("moveDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (marioMoverController.isUpMario()) {
                    return;
                }
                marioMoverController.setUserPressedDown(true);
                marioMoverController.activeMario.setMarioSit(!marioMoverController.isUserPressedUp());
            }
        });

        actionMap.put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameGodFather.getGameData().isGamePause) {
                    return;
                }
                if (!isLeftPress) {
                    gameGodFather.activeLevel.getMario().buttonPressCounter++;
                    isLeftPress = true;
                }

                // mario act unusual
                if (gameGodFather.activeLevel.getMario().isMarioDrunk()) {
                    marioMoverController.setRightMario(true);
                    marioMoverController.activeMario.setMarioRight(true);
                    marioMoverController.activeMario.setMarioLeft(false);
                } else {
                    marioMoverController.setLeftMario(true);
                    marioMoverController.activeMario.setMarioRight(false);
                    marioMoverController.activeMario.setMarioLeft(true);
                }
            }
        });

        actionMap.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameGodFather.getGameData().isGamePause) {
                    return;
                }
                if (!isRightPress) {
                    gameGodFather.activeLevel.getMario().buttonPressCounter++;
                    isRightPress = true;
                }

                // mario act unusual
                if (gameGodFather.activeLevel.getMario().isMarioDrunk()) {
                    marioMoverController.setLeftMario(true);
                    marioMoverController.activeMario.setMarioRight(false);
                    marioMoverController.activeMario.setMarioLeft(true);
                } else {
                    marioMoverController.setRightMario(true);
                    marioMoverController.activeMario.setMarioRight(true);
                    marioMoverController.activeMario.setMarioLeft(false);
                }
            }
        });

        // Key Release Actions
        actionMap.put("shootReleased", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marioMoverController.setMarioShooting(false);
                marioMoverController.activeMario.setMarioShooting(false);
            }
        });

        actionMap.put("moveDownReleased", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marioMoverController.activeMario.setMarioSit(false);
                marioMoverController.setUserPressedDown(false);
            }
        });

        actionMap.put("moveLeftReleased", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // mario act unusual
                if (gameGodFather.activeLevel.getMario().isMarioDrunk()) {
                    marioMoverController.setRightMario(false);
                    marioMoverController.activeMario.setMarioRight(false);
                } else {
                    marioMoverController.setLeftMario(false);
                    marioMoverController.activeMario.setMarioLeft(false);
                }
                isLeftPress = false;
            }
        });

        actionMap.put("moveRightReleased", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // mario act unusual
                if (gameGodFather.activeLevel.getMario().isMarioDrunk()) {
                    marioMoverController.setLeftMario(false);
                    marioMoverController.activeMario.setMarioLeft(false);
                } else {
                    marioMoverController.setRightMario(false);
                    marioMoverController.activeMario.setMarioRight(false);
                }
                isRightPress = false;
            }
        });
    }

    public GameGodFather getGameScreenFrame() {
        return gameGodFather;
    }

    public void setGameScreenFrame(GameGodFather gameGodFather) {
        this.gameGodFather = gameGodFather;
    }

    public MarioMoverController getMarioMoverModel() {
        return marioMoverController;
    }

    public void setMarioMoverModel(MarioMoverController marioMoverController) {
        this.marioMoverController = marioMoverController;
    }
}
