package Controller;

import javax.swing.*;

import Graphic.GameGodFather;
import MyProject.MyProject;
import java.awt.event.*;

import Graphic.MainMenuScreen;
import Model.MarioMoverModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;

@SuppressWarnings("deprecation")
public class MarioMover {
    private final ObjectMapper objectMapper;
    private GameGodFather gameGodFather;
    private MarioMoverModel marioMoverModel;
    InputMap inputMap;
    ActionMap actionMap;

    public MarioMover(GameGodFather gameGodFather) {
        this.gameGodFather = gameGodFather;
        this.marioMoverModel = gameGodFather.marioMoverModel;
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        createKeyBindings();
    }

    private void createKeyBindings() {

        inputMap = gameGodFather.getGameScreenFrame().getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        actionMap = gameGodFather.getGameScreenFrame().getRootPane().getActionMap();

        // Key Press:
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "pause");
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

        actionMap.put("pause", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameGodFather.getGameScreenFrame().dispose();
                if (gameGodFather.getGameData().isGamePause) {
                    gameGodFather.getGameData().isGamePause = false;
                } else {
                    gameGodFather.getGameData().isGamePause = true;
                }
                System.out.println(marioMoverModel.activeMario.getX());
                new MainMenuScreen();
                try {
                    objectMapper.writeValue(new File("User.jason"), MyProject.allUsers);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        actionMap.put("shoot", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!marioMoverModel.activeMario.isMarioShooter()
                || gameGodFather.getGameData().isGamePause) {
                    return;
                }
                marioMoverModel.setMarioShooting(true);
                marioMoverModel.marioStartShooting();
            }
        });

        actionMap.put("moveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameGodFather.getGameData().isGamePause) {
                    return;
                }
                if (!marioMoverModel.isUserPressedUp()) {
                    marioMoverModel.setUpMario(true);
                    marioMoverModel.activeMario.setVelocityY(-10);
                    marioMoverModel.setUserPressedUp(true);
                }
            }
        });

        actionMap.put("moveDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (marioMoverModel.isUpMario()) {
                    return;
                }
                marioMoverModel.setUserPressedDown(true);
                marioMoverModel.activeMario.setMarioSit(!marioMoverModel.isUserPressedUp());
            }
        });

        actionMap.put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameGodFather.getGameData().isGamePause) {
                    return;
                }
                marioMoverModel.setLeftMario(true);
                marioMoverModel.activeMario.setMarioRight(false);
                marioMoverModel.activeMario.setMarioLeft(true);
            }
        });

        actionMap.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameGodFather.getGameData().isGamePause) {
                    return;
                }
                marioMoverModel.setRightMario(true);
                marioMoverModel.activeMario.setMarioRight(true);
                marioMoverModel.activeMario.setMarioLeft(false);
            }
        });

        // Key Release Actions
        actionMap.put("shootReleased", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marioMoverModel.setMarioShooting(false);
            }
        });

        actionMap.put("moveDownReleased", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marioMoverModel.activeMario.setMarioSit(false);
                marioMoverModel.setUserPressedDown(false);
            }
        });

        actionMap.put("moveLeftReleased", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marioMoverModel.setLeftMario(false);
                marioMoverModel.activeMario.setMarioLeft(false);
            }
        });

        actionMap.put("moveRightReleased", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                marioMoverModel.setRightMario(false);
                marioMoverModel.activeMario.setMarioRight(false);
            }
        });
    }

    public GameGodFather getGameScreenFrame() {
        return gameGodFather;
    }

    public void setGameScreenFrame(GameGodFather gameGodFather) {
        this.gameGodFather = gameGodFather;
    }

    public MarioMoverModel getMarioMoverModel() {
        return marioMoverModel;
    }

    public void setMarioMoverModel(MarioMoverModel marioMoverModel) {
        this.marioMoverModel = marioMoverModel;
    }
}
