package Model.NetworkCommunication.MessageHandler;

import Model.NetworkCommunication.Message.Message;
import Model.NetworkCommunication.Message.SignUpMessage;

import javax.swing.*;

public class SignUpHandler implements MessageHandler {
    @Override
    public void handleMessage(Message message) {

        if (message instanceof SignUpMessage) {

            System.out.println("fknadklfnsd");
            SignUpMessage signUpMessage = (SignUpMessage) message;
            if (signUpMessage.isPasswordOK()) {// Successful
                JOptionPane.showMessageDialog(null, "Account has been created Successfully", "Sign up", JOptionPane.INFORMATION_MESSAGE);
            } else {// Failed
                JOptionPane.showMessageDialog(null, "Username is not available", "Sign Up Problem", JOptionPane.WARNING_MESSAGE);
            }

        }
    }
}
