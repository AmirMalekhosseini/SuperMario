package Model.NetworkCommunication.Message;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "messageType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SignUpMessage.class, name = "SIGN_UP"),
        @JsonSubTypes.Type(value = SignInMessage.class, name = "SIGN_IN"),
        @JsonSubTypes.Type(value = LogOutMessage.class, name = "LOG_OUT"),
        @JsonSubTypes.Type(value = PackMessage.class, name = "PACK_MESSAGE"),
        @JsonSubTypes.Type(value = BagItemMessage.class, name = "BAG_ITEM_MESSAGE"),
        @JsonSubTypes.Type(value = ChooseBagMessage.class, name = "CHOOSE_BAG_MESSAGE"),
        // Add other subclasses with corresponding discriminator names
})
public class Message {

    private MessageType messageType;
    private String senderUser;
    private String targetUser;

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

    public String getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(String targetUser) {
        this.targetUser = targetUser;
    }
}
