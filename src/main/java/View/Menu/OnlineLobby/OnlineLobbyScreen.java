package View.Menu.OnlineLobby;

import Controller.Menu.OnlineLobby.LobbyButtonCreator;
import Model.Game.User;
import Model.OnlineLobby.LobbyMemberButton;
import Model.OnlineLobby.LobbyModel;
import MyProject.MyProjectData;
import View.Menu.OnlineChat.*;
import View.Menu.OnlineChat.ChatScrollPane;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OnlineLobbyScreen extends JFrame {

    private LobbyModel model;
    protected ArrayList<LobbyMemberButton> memberButtons;
    public LobbyChoosePanel choosePanel;
    public ChatPanel chatPanel;
    protected ChatScreen chatScreen;
    public ChatScrollPane chatScroll;
    protected JScrollPane chooseScroll;
    public JPanel panel;
    public JPanel inputPanel;
    public LobbyPanel lobbyPanel;
    public JTextField messageField;
    protected JList friendList;

    public OnlineLobbyScreen(User adminUser) {
        ImageIcon gameIcon = MyProjectData.getProjectData().getGameIcon();
        model = new LobbyModel(adminUser);
        setTitle("Lobby");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(835, 830);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(gameIcon.getImage());

        panel = new JPanel();
        panel.setBounds(0, 0, 835, 820);
        panel.setVisible(true);
        panel.setFocusable(true);
        panel.requestFocus();
        panel.requestFocusInWindow();
        panel.setLayout(null);
        setContentPane(panel);

        lobbyPanel = new LobbyPanel(this);
        lobbyPanel.setBounds(200,0,620,950);

        chatPanel = new ChatPanel();
        chatPanel.setBounds(200, 0, 605, 800);
        chatPanel.setLayout(null);
        chatPanel.setVisible(false);

        inputPanel = new JPanel();
        inputPanel.setBounds(200, 735, 605, 55);
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setVisible(false);

        messageField = new JTextField();
        messageField.setBackground(Color.DARK_GRAY);
        messageField.setForeground(Color.WHITE);
        messageField.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));

        chatScreen = new ChatScreen("usernames", "reza", messageField);
        chatScreen.setLocation(200, 0);
        chatScreen.setOpaque(false);
        chatScreen.setBackground(new Color(0, 0, 0, 0));

        choosePanel = new LobbyChoosePanel();
        choosePanel.setLocation(0, 0);
        choosePanel.setLayout(new BoxLayout(choosePanel, BoxLayout.Y_AXIS));

        chatScroll = new ChatScrollPane(chatScreen);
        chatScroll.setVisible(false);

        chooseScroll = new JScrollPane(choosePanel);
        chooseScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        chooseScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        chooseScroll.setBounds(0, 0, 200, 800); // Set the bounds of the scroll pane
        chooseScroll.getViewport().setBackground(new Color(0, 0, 0, 0));
        chooseScroll.setOpaque(false);
        chooseScroll.getViewport().setOpaque(false);
        chooseScroll.getViewport().setViewPosition(new Point(0, 0));

        inputPanel.add(messageField, BorderLayout.CENTER);

        panel.add(inputPanel);
        panel.add(chatScroll);
        panel.add(chatPanel);
        panel.add(lobbyPanel);
        messageField.requestFocus();

    }

    public ArrayList<LobbyMemberButton> getMemberButtons() {
        return memberButtons;
    }

    public void setMemberButtons(ArrayList<LobbyMemberButton> memberButtons) {
        this.memberButtons = memberButtons;
    }

    public LobbyModel getModel() {
        return model;
    }

    public void setModel(LobbyModel model) {
        this.model = model;
    }


}
