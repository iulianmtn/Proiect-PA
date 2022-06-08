package graphics;

import utilities.entities.entitiesSentByServer.ScheduledDay;
import utilities.entities.entitiesSentByServer.ScheduledEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class FacultySchedulePanel extends JPanel {
    private MainFrame frame;

    private JLabel title;
    private JPanel tables;
    private JScrollPane scrollableContainer;

    private JButton backButton;


    public FacultySchedulePanel(MainFrame frame) {
        this.frame = frame;

        title = new JLabel("orar facultate");
        tables = new JPanel();

        backButton = new JButton("Back");

        init();

    }

    private void init() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        add(title);
        add(tables);


        backButton = new JButton("Back");
        backButton.setLocation(50,50);
        backButton.addActionListener(this::goBack);

        add(backButton);
    }

    private void goBack(ActionEvent event) {
        remove(tables);
        tables = new JPanel();
        add(tables);

        remove(scrollableContainer);
        scrollableContainer = new JScrollPane(tables);
        add(scrollableContainer);

        //il stergem si redesenam din nou panelul
        frame.getContainer().remove(frame.getFacultySchedulePanel());
        frame.setFacultySchedulePanel(new FacultySchedulePanel(frame));
        frame.getContainer().add(frame.getFacultySchedulePanel(), "faculty schedule");

        frame.getContainer().remove(frame.getFacultyGroupsPanel());
        frame.setFacultyGroupsPanel(new FacultyGroupsPanel(frame));
        frame.getContainer().add(frame.getFacultyGroupsPanel(), "faculty groups");

        revalidate();

        CardLayout cardLayout = (CardLayout) frame.getContainer().getLayout();
        cardLayout.show(frame.getContainer(), "student");

    }

    public void paintTables(List<ScheduledDay> schedule)
    {

        String[] columns= {"nume", "inceput", "sfarsit", "dimensiune", "grupa", "camera", "tip"};

        tables.setLayout(new BoxLayout(tables, BoxLayout.Y_AXIS));
        for(ScheduledDay day : schedule)
        {
            JLabel dayLabel = new JLabel(day.getZi());
            tables.add(dayLabel);

            JTable table = new JTable(new DefaultTableModel(columns, 0));
            table.setFillsViewportHeight(true);

            //populam tabelul
            for(ScheduledEvent event : day.getEvents())
            {
                String[] cells = new String[columns.length];

                cells[0] = event.getNume();
                cells[1] = String.valueOf(event.getInceput());
                cells[2] = String.valueOf(event.getSfarsit());
                cells[3] = String.valueOf(event.getDimensiune());
                cells[4] = event.getGrupa();
                cells[5] = event.getCamera();
                cells[6] = event.getTip();

                DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
                tableModel.addRow(cells);
            }
            JPanel tableContainer = new JPanel();
            tableContainer.setLayout(new BorderLayout());
            tableContainer.add(table, BorderLayout.CENTER);
            tableContainer.add(table.getTableHeader(), BorderLayout.NORTH);

            tables.add(tableContainer);
        }
        scrollableContainer = new JScrollPane(tables);
        add(scrollableContainer);
        revalidate();
    }

}
