package View.Menu.OnlineChat;

import Controller.Menu.OnlineChat.ChatButtonCreator;
import Model.OnlineChat.ChatFrameModel;
import MyProject.MyProject;
import MyProject.MyProjectData;
import View.Button.ChatChooseButton;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class MainChatFrame extends JFrame {


    protected ArrayList<ChatChooseButton> buttons;
    protected HashMap<String, ChatScreen> chatScreens = new HashMap<>();
    protected JPanel backPanel;
    public JButton backButton;
    public ChatChoosePanel choosePanel;
    public ChatScrollPane chatScroll;
    public JPanel panel;
    public JTextField messageField;
    protected ChatPanel chatPanel;
    protected ChatScreen activeChatScreen;
    protected JScrollPane chooseScroll;
    protected JPanel inputPanel;
    protected JLabel backgroundImage;
    protected JPanel searchPanel;
    public JTextField searchField;
    private final ChatFrameModel model;

    public MainChatFrame() {
        MyProject.activeClient.setActiveChatFrame(this);
        // Main Chat Frame
        ImageIcon gameIcon = MyProjectData.getProjectData().getGameIcon();
        model = new ChatFrameModel();
        setTitle("Message App");
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

        chatPanel = new ChatPanel();
        chatPanel.setBounds(200, 0, 605, 800);
        chatPanel.setLayout(null);

        inputPanel = new JPanel();
        inputPanel.setBounds(200, 735, 605, 55);
        inputPanel.setLayout(new BorderLayout());

        messageField = new JTextField();
        messageField.setBackground(Color.DARK_GRAY);
        messageField.setForeground(Color.WHITE);
        messageField.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));


        ImageIcon background = new ImageIcon("Background.png");
        backgroundImage = new JLabel(background);
        int imageWidth = background.getIconWidth();
        int imageHeight = background.getIconHeight();
        backgroundImage.setBounds(0, 0, imageWidth, imageHeight);

        activeChatScreen = new ChatScreen("usernames", "reza", messageField);
        activeChatScreen.setLocation(200, 0);
        activeChatScreen.setOpaque(false);
        activeChatScreen.setBackground(new Color(0, 0, 0, 0));

        choosePanel = new ChatChoosePanel();
        choosePanel.setLocation(0, 50);
        choosePanel.setLayout(new BoxLayout(choosePanel, BoxLayout.Y_AXIS));

        searchPanel = new JPanel();
        searchPanel.setBounds(0, 0, 200, 50);
        searchPanel.setLayout(null);

        searchField = new JTextField();
        searchField.setBounds(0, 0, 200, 50);
        searchField.setBackground(Color.DARK_GRAY);
        searchField.setForeground(Color.WHITE);
        searchField.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));

        searchPanel.add(searchField);

        chatScroll = new ChatScrollPane(activeChatScreen);

        chooseScroll = new JScrollPane(choosePanel);
        chooseScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        chooseScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        chooseScroll.setBounds(0, 50, 200, 750); // Set the bounds of the scroll pane
        chooseScroll.getViewport().setBackground(new Color(0, 0, 0, 0));
        chooseScroll.setOpaque(false);
        chooseScroll.getViewport().setOpaque(false);
        chooseScroll.getViewport().setViewPosition(new Point(0, 0));

        backButton = new JButton("Back");
        backButton.setBounds(535, 0, 70, 50);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setFocusable(false);
        backButton.setFont(MyProjectData.getProjectData().getFont15());

        backPanel = new JPanel();
        backPanel.setBounds(0, 0, 620, 50);
        backPanel.add(backButton);
        backPanel.setLayout(null);
        backPanel.setVisible(true);

        inputPanel.add(messageField, BorderLayout.CENTER);
        panel.add(inputPanel);
        panel.add(chatScroll);
        panel.add(chatPanel);
        panel.add(searchPanel);
        messageField.requestFocus();

        model.chatButtonCreator = new ChatButtonCreator();
        buttons = model.chatButtonCreator.createButton(messageField);
        model.addButtons(this);
        model.addMessageFieldAction(this);
        model.addButtonAction(this);
        model.addChatScreens(this);

        panel.add(chooseScroll);
        chatPanel.add(backPanel);

    }

    public ArrayList<ChatChooseButton> getButtons() {
        return buttons;
    }

    public ChatScreen getActiveChatScreen() {
        return activeChatScreen;
    }

    public void setActiveChatScreen(ChatScreen activeChatScreen) {
        this.activeChatScreen = activeChatScreen;
    }

    public HashMap<String, ChatScreen> getChatScreens() {
        return chatScreens;
    }

    public ChatFrameModel getModel() {
        return model;
    }
}
