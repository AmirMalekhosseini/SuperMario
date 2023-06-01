package Controller;

import MyProject.MyProject;
import Model.*;
import Graphic.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class MarioMover implements KeyListener {

    ObjectMapper objectMapper;
    GameScreenFrame gameScreenFrame;
    MarioMoverModel marioMoverModel;

    public MarioMover(GameScreenFrame gameScreenFrame, MarioMoverModel marioMoverModel) {
        this.marioMoverModel = marioMoverModel;
        this.gameScreenFrame = gameScreenFrame;
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    public MarioMover() {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            gameScreenFrame.dispose();
            gameScreenFrame.getGameData().setGamePause(true);
            new MainMenuScreen();
            try {
                objectMapper.writeValue(new File("User.jason"), MyProject.allUsers);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {// Shooting
            if (!marioMoverModel.activeMario.isMarioShooter()) {
                return;
            }
            marioMoverModel.setMarioShooting(true);
            marioMoverModel.marioStartShooting();
        }

        if (e.getKeyChar() == 'w') {
            if (!marioMoverModel.isUserPressedUp()) {
                marioMoverModel.setUpMario(true);
                marioMoverModel.activeMario.setVelocityY(-10);
                marioMoverModel.setUserPressedUp(true);
            }
        }

        if (e.getKeyChar() == 's') {

            if (marioMoverModel.isUpMario()) {
                return;
            }
            marioMoverModel.setUserPressedDown(true);
            if (!marioMoverModel.isUserPressedUp()) {
                marioMoverModel.activeMario.setMarioSit(true);
            } else {
                marioMoverModel.activeMario.setMarioSit(false);
            }

        }

        if (e.getKeyChar() == 'a') {
            marioMoverModel.setLeftMario(true);
            marioMoverModel.activeMario.setMarioRight(false);
            marioMoverModel.activeMario.setMarioLeft(true);
        }

        if (e.getKeyChar() == 'd') {
            marioMoverModel.setRightMario(true);
            marioMoverModel.activeMario.setMarioRight(true);
            marioMoverModel.activeMario.setMarioLeft(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_SHIFT) {// Shooting
            marioMoverModel.setMarioShooting(false);
        }

        if (e.getKeyChar() == 's') {
            marioMoverModel.activeMario.setMarioSit(false);
            marioMoverModel.setUserPressedDown(false);
        }

        if (e.getKeyChar() == 'a') {
            marioMoverModel.setLeftMario(false);
            marioMoverModel.activeMario.setMarioLeft(false);
        }

        if (e.getKeyChar() == 'd') {
            marioMoverModel.setRightMario(false);
            marioMoverModel.activeMario.setMarioRight(false);
        }
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    public GameScreenFrame getGameScreenFrame() {
        return gameScreenFrame;
    }

    public void setGameScreenFrame(GameScreenFrame gameScreenFrame) {
        this.gameScreenFrame = gameScreenFrame;
    }

    public MarioMoverModel getMarioMoverModel() {
        return marioMoverModel;
    }

    public void setMarioMoverModel(MarioMoverModel marioMoverModel) {
        this.marioMoverModel = marioMoverModel;
    }
}