package Model.NetworkCommunication.Message;

public class ChatNotificationMessage extends Message {

    private String message;

    public ChatNotificationMessage() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
