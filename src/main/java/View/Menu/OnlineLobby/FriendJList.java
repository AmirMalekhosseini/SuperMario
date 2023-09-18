package View.Menu.OnlineLobby;

import javax.swing.*;
import java.awt.*;

public class FriendJList extends JList<String> {

    public FriendJList(String[] friends) {
        super(friends);
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setCellRenderer(new FriendListCellRenderer());
    }


    private static class FriendListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof String) {
                String friend = (String) value;
                setText(friend);
            }
            return this;
        }
    }

}
