package Controller.Online.MessageHandler;

import Model.NetworkCommunication.Message.FriendRequestAnswer;
import Model.NetworkCommunication.Message.Message;
import MyProject.MyProject;

public class FriendAnswerHandler implements MessageHandler{
    @Override
    public void handlerMessage(Message message) {

        if (message instanceof FriendRequestAnswer) {
            FriendRequestAnswer requestAnswer = (FriendRequestAnswer) message;
            if (requestAnswer.isAnswer()) {
                MyProject.activeClient.getUserFriends().add(requestAnswer.getSenderUser());
            }
        }

    }
}
