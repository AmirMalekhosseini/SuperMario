package Controller.Online.MessageHandler;

import Controller.Menu.SwingUtils;
import Model.NetworkCommunication.Message.Message;
import Model.NetworkCommunication.Message.RemoveLobbyMemberMessage;
import MyProject.MyProject;
import View.Menu.MainMenuScreen;
import View.Notification.RemoveLobbyNotification;

public class RemoveLobbyMemberHandler implements MessageHandler{

    @Override
    public void handlerMessage(Message message) {

        if (message instanceof RemoveLobbyMemberMessage) {
            RemoveLobbyMemberMessage removeMessage = (RemoveLobbyMemberMessage) message;
            if (removeMessage.isUserRemoved()) {// User is Removed
                String messageContext = "You Have been Removed from Lobby";
                String title = removeMessage.getSenderUser();
                MyProject.activeClient.setActiveLobbyScreen(null);
                SwingUtils.closeAllFrames();
                new MainMenuScreen();
                new RemoveLobbyNotification(title, messageContext);
            } else {// Another User is Removed:
                MyProject.activeClient.getActiveLobbyScreen().getModel().removeMember(removeMessage.getTargetUser());
            }


        }

    }
}
