package Model.NetworkCommunication.Message;

public class FriendRequestAnswer extends Message {


    private boolean answer;

    public FriendRequestAnswer() {

    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
