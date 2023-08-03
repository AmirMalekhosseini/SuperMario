package Controller.Online.MessageHandler;

import Controller.Menu.SwingUtils;
import Model.NetworkCommunication.Message.Message;
import Model.NetworkCommunication.Message.SignInMessage;
import MyProject.MyProject;
import View.Menu.MainMenuScreen;

import javax.swing.*;
import java.util.Objects;

public class SignInHandler implements MessageHandler {

    @Override
    public void handlerMessage(Message message) {


        if (message instanceof SignInMessage) {
            SignInMessage signInMessage = (SignInMessage) message;

            if (signInMessage.isPasswordOK() && signInMessage.isUsernameOK()) {
                JOptionPane.showMessageDialog(null, "Signed In Successfully", "Sign In", JOptionPane.INFORMATION_MESSAGE);
                MyProject.activeClient.setUsername(signInMessage.getUsername());
                System.out.println("username is: "+ MyProject.activeClient.getUsername());
                Objects.requireNonNull(SwingUtils.getActiveFrame()).dispose();
                new MainMenuScreen();
            } else {
                JOptionPane.showMessageDialog(null, "Can't Sign In", "Sign In Problem", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}
