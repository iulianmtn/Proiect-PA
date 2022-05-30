package graphics;

import javax.swing.*;

public class GroupSchedulePanel extends JPanel {
    private MainFrame frame;

    private JLabel title;
    private JPanel tables;
    private JScrollPane scrollableContainer;

    public GroupSchedulePanel(MainFrame frame) {
        this.frame = frame;

        title = new JLabel("orar facultate");

        tables = new JPanel();

        add(title);
        add(tables);
    }
}
