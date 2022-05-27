package example.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainMenuPanel extends JPanel {
    private final MainFrame frame;
//    private JLabel logo;
    private JButton addFaculty;
    private JButton seeSchedule;


    public MainMenuPanel(MainFrame frame) {
        this.frame = frame;

        init();
    }

    public void init()
    {
        addFaculty = new JButton("Add Faculty");
        seeSchedule = new JButton("See Schedule");


        //setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));

        add(addFaculty);
        add(seeSchedule);

        addFaculty.addActionListener(this::changeToAdminPanel);
        seeSchedule.addActionListener(this::changeToStudentPanel);

    }

    private void changeToAdminPanel(ActionEvent event) {
        CardLayout cardLayout = (CardLayout) frame.getContainer().getLayout();
        cardLayout.show(frame.getContainer(), "admin");
    }

    private void changeToStudentPanel(ActionEvent event) {
        CardLayout cardLayout = (CardLayout) frame.getContainer().getLayout();
        cardLayout.show(frame.getContainer(), "student");
    }



}
