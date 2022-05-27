package example.graphics;


import javax.swing.*;
import java.util.List;

public class StudentPanel extends JPanel {
    private final MainFrame frame;

    private JLabel title;
    private JScrollPane facultyContainer;
    private List<JButton> facultyButtons;

    public StudentPanel(MainFrame frame) {
        this.frame = frame;

        init();
    }

    private void init()
    {

    }
}
