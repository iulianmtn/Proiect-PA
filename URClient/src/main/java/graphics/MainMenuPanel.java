package graphics;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import example.ClientSocket;
import utilities.JsonSerialAndDeserial;
import utilities.entities.entitiesSentByClient.GiveFaculties;
import utilities.entities.entitiesSentByServer.Faculty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

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
        //////----giveFaculties test
        PrintWriter out = ClientSocket.getInstance().getOutputStream();
        BufferedReader in = ClientSocket.getInstance().getInputStream();

        GiveFaculties giveFaculties=new GiveFaculties();
        out.println(JsonSerialAndDeserial.formatToJson(giveFaculties));



        try {
            String jsonFacultati = in.readLine();

            Type listType = new TypeToken<ArrayList<Faculty>>(){}.getType();
            List<Faculty> facultyList = new Gson().fromJson(jsonFacultati, listType);

            frame.getStudentPanel().paintButtons(facultyList);

        } catch (IOException e) {
            e.printStackTrace();
        }

        CardLayout cardLayout = (CardLayout) frame.getContainer().getLayout();
        cardLayout.show(frame.getContainer(), "student");
    }



}
