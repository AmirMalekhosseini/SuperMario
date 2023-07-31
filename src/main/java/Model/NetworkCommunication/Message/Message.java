package Model.NetworkCommunication.Message;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "messageType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SignUpMessage.class, name = "SIGN_UP"),
        @JsonSubTypes.Type(value = SignInMessage.class, name = "SIGN_IN"),
        // Add other subclasses with corresponding discriminator names
})
public class Message {

    private MessageType messageType;
    private String senderUser;

    public Message() {

    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getSenderUser() {
        return senderUser;
    }

    public void setSenderUser(String senderUser) {
        this.senderUser = senderUser;
    }
}
