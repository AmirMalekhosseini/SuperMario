package Model.NetworkCommunication.Message;

public class GameRequestAnswer extends Message {

    boolean answer;
    String lobbyName;

    public GameRequestAnswer() {

    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public String getLobbyName() {
        return lobbyName;
    }

    public void setLobbyName(String lobbyName) {
        this.lobbyName = lobbyName;
    }
}
