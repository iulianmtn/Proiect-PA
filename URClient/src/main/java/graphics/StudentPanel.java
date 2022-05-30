package graphics;


import utilities.entities.entitiesSentByServer.Faculty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class StudentPanel extends JPanel {
    private final MainFrame frame;

    private JLabel title;
    private JScrollPane facultiesContainer;
    private JPanel facultyButtons;
    private List<Faculty> facultyList;
    private int selectedFacultyId;

    public StudentPanel(MainFrame frame) {
        this.frame = frame;

        facultiesContainer = new JScrollPane();
        facultyButtons = new JPanel();
        facultyList = new ArrayList<>();
    }

    public void paintButtons(List<Faculty> facultyList)
    {
        this.facultyList = facultyList;
        for(Faculty faculty : facultyList)
        {
            JButton button = new JButton(faculty.getNume());
            //facultiesContainer.add(button);
            facultyButtons.add(button);
            button.addActionListener(this::facultyButton);
        }
        facultiesContainer = new JScrollPane(facultyButtons);
        add(facultiesContainer);
    }

    private void facultyButton(ActionEvent event) {
        //trebui sa obtinem id ul facultatii apasate
        JButton button = (JButton) event.getSource();
        String facultyName = button.getText();

        Faculty selectedFaculty = facultyList.stream().filter(faculty -> facultyName.equals(faculty.getNume())).findFirst().orElse(null);
        selectedFacultyId = selectedFaculty.getId();

        //alt meniu
        CardLayout cardLayout = (CardLayout) frame.getContainer().getLayout();
        cardLayout.show(frame.getContainer(), "faculty");
    }

//    private void init()
//    {
//        add(facultiesContainer);
//    }


    public int getSelectedFacultyId() {
        return selectedFacultyId;
    }
}
