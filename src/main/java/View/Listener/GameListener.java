package View.Listener;

import Model.Game.GameGodFather;
import Music.MusicPlayer;
import View.Menu.MainMenuScreen;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import MyProject.*;
public class GameListener {

    protected GameGodFather godFather;
    protected ObjectMapper objectMapper;
    protected InputMap inputMap;
    protected ActionMap actionMap;
    protected MusicPlayer musicPlayer;

    public GameListener(GameGodFather godFather) {
        this.godFather = godFather;
        objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        musicPlayer = godFather.getMusicPlayer();

        createKeyBindings();

        musicPlayer.playMusic("Music/SuperMario.wav");
    }

    private void createKeyBindings() {
        inputMap = godFather.getGameScreenFrame().getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        actionMap = godFather.getGameScreenFrame().getRootPane().getActionMap();

        // Key Press:
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "pause");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_M, 0), "mute");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, 0), "back");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_N, 0), "playNewSong");

        actionMap.put("pause", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (godFather.getGameData().isGamePause) {
                    godFather.getGameData().isGamePause = false;
                } else {
                    godFather.getGameData().isGamePause = true;
                }
            }
        });

        actionMap.put("back", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (godFather.getGameData().isGamePause) {
                    godFather.getGameScreenFrame().dispose();
                    new MainMenuScreen();
                    try {
                        objectMapper.writeValue(new File("User.jason"), MyProject.allUsers);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });

        actionMap.put("mute", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicPlayer.muteMusic();
            }
        });

        actionMap.put("playNewSong", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                musicPlayer.stopMusic();

                if (musicPlayer.getMusicFilePath().equals("Music/Pirate-Of-Caribbean.wav")) {
                    musicPlayer.playMusic("Music/SuperMario.wav");
                } else {
                    musicPlayer.playMusic("Music/Pirate-Of-Caribbean.wav");
                }

            }
        });
    }
}

