package Controller.Online.MessageHandler;

import Controller.Menu.SwingUtils;
import Model.NetworkCommunication.Message.Message;
import MyProject.MyProject;
import View.Menu.MainMenuScreen;

import javax.swing.*;

public class RemoveLobbyMessageHandler implements MessageHandler{
    @Override
    public void handlerMessage(Message message) {
        MyProject.activeClient.setActiveLobbyScreen(null);
        SwingUtils.closeAllFrames();
        new MainMenuScreen();
        JOptionPane.showMessageDialog(null, "Lobby has been Removed", "Remove Lobby", JOptionPane.INFORMATION_MESSAGE);
    }
}
