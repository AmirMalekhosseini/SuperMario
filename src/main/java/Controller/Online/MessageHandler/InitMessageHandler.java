package Controller.Online.MessageHandler;

import Model.NetworkCommunication.Message.InitMessage;
import Model.NetworkCommunication.Message.Message;
import MyProject.MyProject;

public class InitMessageHandler implements MessageHandler{


    @Override
    public void handlerMessage(Message message) {

        if (message instanceof InitMessage) {
            InitMessage initMessage = (InitMessage) message;
            MyProject.activeClient.setClientItems(initMessage.getClientItems());
            MyProject.activeClient.setUserChatScreens(initMessage.getUserChatScreens());
            MyProject.activeClient.setUserFriends(initMessage.getUserFriends());
            MyProject.activeClient.setUserData(initMessage.getUserData());
        }

    }
}
