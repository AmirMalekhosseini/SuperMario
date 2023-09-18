package Model.NetworkCommunication.Message;

public class ChatMessage extends Message {

    private String context;
    public ChatMessage() {

    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
