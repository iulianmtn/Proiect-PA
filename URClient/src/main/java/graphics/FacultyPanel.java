package graphics;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import example.ClientSocket;
import utilities.JsonSerialAndDeserial;
import utilities.entities.entitiesSentByClient.GiveFacultySchedule;
import utilities.entities.entitiesSentByClient.GiveGroups;
import utilities.entities.entitiesSentByServer.Faculty;
import utilities.entities.entitiesSentByServer.FacultyGroup;
import utilities.entities.entitiesSentByServer.ScheduledDay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FacultyPanel extends JPanel {
    private MainFrame frame;
    private JButton facultyScheduleButton;
    private JButton seeGroups;

    public FacultyPanel(MainFrame frame) {
        this.frame = frame;

        init();
    }

    private void init() {
        facultyScheduleButton = new JButton("See Faculty Schedule");
        facultyScheduleButton.addActionListener(this::seeFacultySchedule);

        seeGroups = new JButton("See Faculty Groups");
        seeGroups.addActionListener(this::seeGroups);

        add(facultyScheduleButton);
        add(seeGroups);
    }

    private void seeGroups(ActionEvent event) {
        PrintWriter out = ClientSocket.getInstance().getOutputStream();
        BufferedReader in = ClientSocket.getInstance().getInputStream();

        ////------giveGroups
        GiveGroups giveGroups = new GiveGroups(frame.getStudentPanel().getSelectedFacultyId());
        out.println(JsonSerialAndDeserial.formatToJson(giveGroups));

        try {
            String jsonGroups = in.readLine();

            Type listType = new TypeToken<ArrayList<FacultyGroup>>(){}.getType();
            List<FacultyGroup> groupList = new Gson().fromJson(jsonGroups, listType);

            frame.getFacultyGroupsPanel().paintGroupButtons(groupList);

        } catch (IOException e) {
            e.printStackTrace();
        }

        CardLayout cardLayout = (CardLayout) frame.getContainer().getLayout();
        cardLayout.show(frame.getContainer(), "faculty groups");



    }

    private void seeFacultySchedule(ActionEvent event) {
        PrintWriter out = ClientSocket.getInstance().getOutputStream();
        BufferedReader in = ClientSocket.getInstance().getInputStream();

        GiveFacultySchedule giveFacultySchedule = new GiveFacultySchedule(frame.getStudentPanel().getSelectedFacultyId());
        out.println(JsonSerialAndDeserial.formatToJson(giveFacultySchedule));

        try {
            String jsonSchedule = in.readLine();

            Type listType = new TypeToken<ArrayList<ScheduledDay>>(){}.getType();
            List<ScheduledDay> schedule = new Gson().fromJson(jsonSchedule, listType);

            frame.getFacultySchedulePanel().paintTables(schedule);
        } catch (IOException e) {
            e.printStackTrace();
        }

        CardLayout cardLayout = (CardLayout) frame.getContainer().getLayout();
        cardLayout.show(frame.getContainer(), "faculty schedule");

    }
}
