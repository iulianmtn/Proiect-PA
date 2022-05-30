package graphics;

import utilities.entities.entitiesSentByServer.ScheduledDay;
import utilities.entities.entitiesSentByServer.ScheduledEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public class FacultySchedulePanel extends JPanel {
    private MainFrame frame;

    private JLabel title;
    private JPanel tables;
    private JScrollPane scrollableContainer;



    public FacultySchedulePanel(MainFrame frame) {
        this.frame = frame;

        title = new JLabel("orar facultate");

        tables = new JPanel();

        add(title);
        add(tables);
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

            tables.add(table);
        }
        scrollableContainer = new JScrollPane(tables);
        add(scrollableContainer);
        revalidate();
    }

}
