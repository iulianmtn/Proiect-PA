package example.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AdminPanel extends JPanel {
    private MainFrame frame;

    private JLabel facultyLabel;
    private JTextField faculty;
    private JButton addButton;

    private String facultyName;

    public AdminPanel(MainFrame frame)
    {
        this.frame = frame;
        init();
    }

    private void init()
    {
        setLayout(null);

        facultyLabel = new JLabel("Faculty");
        facultyLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        facultyLabel.setSize(100, 20);
        facultyLabel.setLocation(100, 100);
        add(facultyLabel);

        faculty = new JTextField();
        faculty.setFont(new Font("Arial", Font.PLAIN, 15));
        faculty.setSize(190, 20);
        faculty.setLocation(200, 100);
        add(faculty);

        addButton = new JButton("Add Faculty");
        addButton.setSize(150, 30);
        addButton.setLocation(150, 150);
        add(addButton);

        addButton.addActionListener(this::buttonPressed);

    }

    private void buttonPressed(ActionEvent event)
    {
        //preluam in facultyName valoare din textField
        facultyName = faculty.getText();

        CardLayout cardLayout = (CardLayout) frame.getContainer().getLayout();
        cardLayout.show(frame.getContainer(), "event form");
    }

    public String getFacultyName() {
        return facultyName;
    }
}
