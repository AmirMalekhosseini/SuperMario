package Model.NetworkCommunication.Message;

import Model.Game.OnlineUser;

public class MessageOtherClient extends Message {

    private String receiverUser;

    public String getReceiverUser() {
        return receiverUser;
    }

    public void setReceiverUser(String receiverUser) {
        this.receiverUser = receiverUser;
    }
}
