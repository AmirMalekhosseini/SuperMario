package Model.NetworkCommunication.MessageHandler;

import Controller.Menu.SwingUtils;
import Model.NetworkCommunication.Message.Message;
import Model.NetworkCommunication.Message.SignInMessage;
import MyProject.MyProject;
import View.Menu.MainMenuScreen;

import javax.swing.*;
import java.util.Objects;

public class SignInHandler implements MessageHandler {
    @Override
    public void handleMessage(Message message) {


        if (message instanceof SignInMessage) {
            SignInMessage signInMessage = (SignInMessage) message;

            if (signInMessage.isPasswordOK() && signInMessage.isUsernameOK()) {
                JOptionPane.showMessageDialog(null, "Signed In Successfully", "Sign In", JOptionPane.INFORMATION_MESSAGE);
                MyProject.activeOnlineUser = signInMessage.getSignedInUser();
                Objects.requireNonNull(SwingUtils.getActiveFrame()).dispose();
                new MainMenuScreen();
            } else {
                JOptionPane.showMessageDialog(null, "Can't Sign In", "Sign In Problem", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
