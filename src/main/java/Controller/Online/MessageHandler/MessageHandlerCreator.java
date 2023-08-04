package Controller.Online.MessageHandler;

import Model.NetworkCommunication.Message.MessageType;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MessageHandlerCreator {

    private static MessageHandlerCreator creator;

    private MessageHandlerCreator() {
    }

    public static MessageHandlerCreator getInstance() {
        if (creator == null) {
            creator = new MessageHandlerCreator();
        }
        return creator;
    }

    public Map<MessageType, MessageHandler> createMessageHandler() {

        Map<MessageType, MessageHandler> messageHandlerMap = new ConcurrentHashMap<>();
        messageHandlerMap.put(MessageType.SIGN_IN, new SignInHandler());
        messageHandlerMap.put(MessageType.SIGN_UP, new SignUpHandler());
        messageHandlerMap.put(MessageType.PACK_MESSAGE, new PackMessageHandler());
        messageHandlerMap.put(MessageType.CHAT_MESSAGE, new ChatMessageHandler());
        messageHandlerMap.put(MessageType.CHAT_NOTIFICATION, new ChatNotificationHandler());
        messageHandlerMap.put(MessageType.FRIEND_REQUEST, new FriendRequestHandler());
        messageHandlerMap.put(MessageType.GAME_REQUEST, new GameRequestHandler());
        messageHandlerMap.put(MessageType.NEW_ITEM_MESSAGE, new NewItemHandler());
        messageHandlerMap.put(MessageType.New_Lobby_Member, new NewLobbyMemberHandler());
        messageHandlerMap.put(MessageType.REMOVE_LOBBY_MEMBER, new RemoveLobbyMemberHandler());


        // TO be Continued...

        return messageHandlerMap;
    }

}
