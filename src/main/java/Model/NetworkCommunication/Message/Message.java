package Model.NetworkCommunication.Message;

import com.fasterxml.jackson.annotation.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "messageType", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = InitMessage.class, name = "INIT_MESSAGE"),
        @JsonSubTypes.Type(value = SignUpMessage.class, name = "SIGN_UP"),
        @JsonSubTypes.Type(value = SignInMessage.class, name = "SIGN_IN"),
        @JsonSubTypes.Type(value = LogOutMessage.class, name = "LOG_OUT"),
        @JsonSubTypes.Type(value = PackMessage.class, name = "PACK_MESSAGE"),
        @JsonSubTypes.Type(value = BagItemMessage.class, name = "BAG_ITEM_MESSAGE"),
        @JsonSubTypes.Type(value = ChooseBagMessage.class, name = "CHOOSE_BAG_MESSAGE"),
        @JsonSubTypes.Type(value = ChatMessage.class, name = "CHAT_MESSAGE"),
        @JsonSubTypes.Type(value = FriendRequestMessage.class, name = "FRIEND_REQUEST"),
        @JsonSubTypes.Type(value = FriendRequestAnswer.class, name = "FRIEND_REQUEST_ANSWER"),
        @JsonSubTypes.Type(value = GameRequestMessage.class, name = "GAME_REQUEST"),
        @JsonSubTypes.Type(value = GameRequestAnswer.class, name = "GAME_REQUEST_ANSWER"),
        @JsonSubTypes.Type(value = OnlineShopMessage.class, name = "ONLINE_SHOP_MESSAGE"),
        @JsonSubTypes.Type(value = UpdateShopMessage.class, name = "UPDATE_SHOP_MESSAGE"),
        @JsonSubTypes.Type(value = NewItemMessage.class, name = "NEW_ITEM_MESSAGE"),
        @JsonSubTypes.Type(value = NewLobbyMessage.class, name = "NEW_LOBBY_MESSAGE"),
        @JsonSubTypes.Type(value = LobbyChatMessage.class, name = "LOBBY_CHAT_MESSAGE"),
        @JsonSubTypes.Type(value = JoinLobbyMessage.class, name = "JOIN_LOBBY_MESSAGE"),
        @JsonSubTypes.Type(value = NewLobbyMemberMessage.class, name = "NEW_LOBBY_MEMBER"),
        @JsonSubTypes.Type(value = AddAdminMessage.class, name = "ADD_ADMIN_MESSAGE"),
        @JsonSubTypes.Type(value = RemoveLobbyMemberMessage.class, name = "REMOVE_LOBBY_MEMBER"),
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
