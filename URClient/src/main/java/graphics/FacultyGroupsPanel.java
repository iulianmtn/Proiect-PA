package graphics;

import example.ClientSocket;
import utilities.JsonSerialAndDeserial;
import utilities.entities.entitiesSentByClient.GiveGroupSchedule;
import utilities.entities.entitiesSentByServer.Faculty;
import utilities.entities.entitiesSentByServer.FacultyGroup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FacultyGroupsPanel extends JPanel {
    private MainFrame frame;

    private JLabel title;
    private JScrollPane groupContainer;
    private JPanel groupButtons;
    private List<FacultyGroup> groupList;
    private int selectedGroupId;

    public FacultyGroupsPanel(MainFrame frame) {
        this.frame = frame;

        groupContainer = new JScrollPane();
        groupButtons = new JPanel();
        groupList = new ArrayList<>();
    }

    public void paintGroupButtons(List<FacultyGroup> facultyGroupList)
    {
        groupList = facultyGroupList;
        for(FacultyGroup facultyGroup : facultyGroupList)
        {
            JButton button = new JButton(facultyGroup.getGroup());
            groupButtons.add(button);
            button.addActionListener(this::groupButton);
        }
        groupContainer = new JScrollPane(groupButtons);
        add(groupContainer);
    }

    private void groupButton(ActionEvent event) {
        PrintWriter out = ClientSocket.getInstance().getOutputStream();
        BufferedReader in = ClientSocket.getInstance().getInputStream();

        JButton button = (JButton) event.getSource();
        String groupName = button.getText();
        int year = Integer.parseInt(String.valueOf(groupName.charAt(0)));
        String semian = String.valueOf(groupName.charAt(1));
        int group = Integer.parseInt(String.valueOf(groupName.charAt(2)));

        GiveGroupSchedule giveGroupSchedule = new GiveGroupSchedule(frame.getStudentPanel().getSelectedFacultyId(), year, semian, group);
        out.println(JsonSerialAndDeserial.formatToJson(giveGroupSchedule));

    }
}
