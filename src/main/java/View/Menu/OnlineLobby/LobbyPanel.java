package View.Menu.OnlineLobby;

import Model.NetworkCommunication.Message.GameRequestMessage;
import Model.NetworkCommunication.Message.MessageType;
import MyProject.MyProject;
import MyProject.MyProjectData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class LobbyPanel extends JLayeredPane {


    protected JLabel backgroundImageLabel;
    protected JButton chatButton;
    protected JButton inviteButton;
    protected JButton closeButton;
    protected JButton startButton;
    protected JButton readyButton;
    protected JScrollPane inviteListScrollPane;
    private FriendJList friendJList;

    public LobbyPanel(OnlineLobbyScreen screen) {
        setLayout(null);
        setBackground(Color.BLACK);
        setOpaque(true);
        ImageIcon backgroundImage = MyProjectData.getProjectData().getGameLobbyImage();

        backgroundImageLabel = new JLabel(backgroundImage);
        backgroundImageLabel.setBounds(0, 0, backgroundImage.getIconWidth(), backgroundImage.getIconHeight());
        backgroundImageLabel.setOpaque(true);

        add(backgroundImageLabel, Integer.valueOf(0));
        addJList();

        addMouseListener();
        addButtons();
        addButtonAction(screen);
    }

    private void addJList() {
        //ToDo: Create List from Client Friends.

        // Initialize the JList and JScrollPane
        ArrayList<String> inviteeList = new ArrayList<>();
        inviteeList.add("Invitee 1");
        inviteeList.add("Invitee 2");
        inviteeList.add("Invitee 3");
        inviteeList.add("Invitee 4");

        // Convert the ArrayList to an array and use it to initialize the JList
        String[] inviteItems = inviteeList.toArray(new String[0]);
        friendJList = new FriendJList(inviteItems);
        inviteListScrollPane = new JScrollPane(friendJList);
        inviteListScrollPane.setBounds(25, 280, 200, 100);
        inviteListScrollPane.setVisible(false); // Initially, hide the JList

        add(inviteListScrollPane, Integer.valueOf(1));


        // Add ListSelectionListener to the JList to perform action on selection
        friendJList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selectedInvitee = friendJList.getSelectedValue();
                if (selectedInvitee != null) {
                    System.out.println("Inviting: " + selectedInvitee);
                    GameRequestMessage requestMessage = new GameRequestMessage();
                    requestMessage.setMessageType(MessageType.GAME_REQUEST);
                    requestMessage.setTargetUser(selectedInvitee);
                    requestMessage.setLobbyName(MyProject.activeClient.getActiveLobbyScreen().getModel().getLobbyName());
                    MyProject.activeClient.sendToServer(requestMessage);

                    // Hide the JList after selection
                    inviteListScrollPane.setVisible(false);
                }
            }
        });
    }

    private void addMouseListener() {

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (!inviteListScrollPane.getBounds().contains(e.getPoint())) {
                    friendJList.clearSelection();
                    inviteListScrollPane.setVisible(false);
                }

            }
        });

    }

    private void addButtons() {

        Font font20 = MyProjectData.getProjectData().getFont20();
        Font font15 = MyProjectData.getProjectData().getFont15();

        chatButton = new JButton("Chat");
        chatButton.setBounds(242, 200, 120, 60);
        chatButton.setBackground(Color.BLACK);
        chatButton.setForeground(Color.WHITE);
        chatButton.setFocusable(false);
        chatButton.setFont(font20);

        add(chatButton, Integer.valueOf(1));

        inviteButton = new JButton("Invite");
        inviteButton.setBounds(242, 280, 120, 60);
        inviteButton.setBackground(Color.BLACK);
        inviteButton.setForeground(Color.WHITE);
        inviteButton.setFocusable(false);
        inviteButton.setFont(font20);
        add(inviteButton, Integer.valueOf(1));

        startButton = new JButton("Start Game");
        startButton.setBounds(242, 360, 120, 60);
        startButton.setBackground(Color.BLACK);
        startButton.setForeground(Color.WHITE);
        startButton.setFocusable(false);
        startButton.setFont(font15);
        add(startButton, Integer.valueOf(1));

        closeButton = new JButton("Close Room");
        closeButton.setBounds(242, 440, 120, 60);
        closeButton.setBackground(Color.BLACK);
        closeButton.setForeground(Color.WHITE);
        closeButton.setFocusable(false);
        closeButton.setFont(font15);
        add(closeButton, Integer.valueOf(1));

        readyButton = new JButton("Ready");
        readyButton.setBounds(450, 650, 150, 60);
        readyButton.setBackground(Color.green);
        readyButton.setForeground(Color.WHITE);
        readyButton.setFocusable(false);
        readyButton.setFont(font20);
        readyButton.setVisible(false);// Set it True When Game is Started.
        add(readyButton, Integer.valueOf(1));

    }

    private void addButtonAction(OnlineLobbyScreen screen) {
        chatButton.addActionListener(e -> {

            screen.getModel().goToChat(screen);

        });

        inviteButton.addActionListener(e -> {

            addJList();
            inviteListScrollPane.setVisible(true); // Show the JList
        });
    }

}
