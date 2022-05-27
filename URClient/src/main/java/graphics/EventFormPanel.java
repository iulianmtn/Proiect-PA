package graphics;


import model.Event;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EventFormPanel extends JPanel implements ActionListener {
    private MainFrame frame;

    private List<Event> events;

    // Components of the Form
    private JLabel title;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel dayLabel;
    private JComboBox day;
    private JLabel interval;
    private JComboBox startTime;
    private JComboBox endTime;
    private JLabel sizeLabel;
    private JSpinner size;
    private JLabel typeLabel;
    private JComboBox type;
    private JLabel yearLabel;
    private JComboBox year;
    private JLabel semianLabel;
    private JComboBox semian;
    private JLabel groupLabel;
    private JComboBox group;

    private JButton addEventButton;
    private JButton submitButton;

    private JScrollPane tableContainer;
    private JTable table;

    private String days[]
            = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
    private String hours[]
            = { "8", "9", "10", "11",
            "12", "13", "14", "15",
            "16", "17", "18", "19", "20" };
    private String types[]
            = { "course", "lab"};
    private String years[] = {"1", "2", "3", "4"};
    private String semians[] = {"A", "B"};
    private String groups[] = {"1", "2", "3", "4", "5"};
    private String columns[] = {"name", "start", "end", "size", "day", "type", "year", "semian", "group"};

    // constructor, to initialize the components
    // with default values.
    public EventFormPanel(MainFrame frame)
    {
        this.frame = frame;
        events = new LinkedList<>();

        init();
    }

    private void init()
    {
        setBounds(300, 90, 900, 600);

        setLayout(null);

        title = new JLabel("Add Event");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        add(title);

        nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        nameLabel.setSize(100, 20);
        nameLabel.setLocation(100, 100);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 15));
        nameField.setSize(190, 20);
        nameField.setLocation(200, 100);
        add(nameField);

        dayLabel = new JLabel("Day");
        dayLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        dayLabel.setSize(100, 20);
        dayLabel.setLocation(100, 150);
        add(dayLabel);

        day = new JComboBox(days);
        day.setFont(new Font("Arial", Font.PLAIN, 15));
        day.setSize(150, 20);
        day.setLocation(200, 150);
        add(day);


        interval = new JLabel("Interval");
        interval.setFont(new Font("Arial", Font.PLAIN, 20));
        interval.setSize(100, 20);
        interval.setLocation(100, 200);
        add(interval);

        startTime = new JComboBox(hours);
        startTime.setFont(new Font("Arial", Font.PLAIN, 15));
        startTime.setSize(50, 20);
        startTime.setLocation(200, 200);
        add(startTime);

        endTime = new JComboBox(hours);
        endTime.setFont(new Font("Arial", Font.PLAIN, 15));
        endTime.setSize(50, 20);
        endTime.setLocation(260, 200);
        add(endTime);

        sizeLabel = new JLabel("Size");
        sizeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        sizeLabel.setSize(100, 20);
        sizeLabel.setLocation(100, 250);
        add(sizeLabel);

        size = new JSpinner(new SpinnerNumberModel(10,2,100,1));
        size.setFont(new Font("Arial", Font.PLAIN, 15));
        size.setSize(60, 20);
        size.setLocation(200, 250);
        add(size);

        typeLabel = new JLabel("Type");
        typeLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        typeLabel.setSize(100, 20);
        typeLabel.setLocation(100, 300);
        add(typeLabel);

        type = new JComboBox(types);
        type.setFont(new Font("Arial", Font.PLAIN, 15));
        type.setSize(100, 20);
        type.setLocation(200, 300);
        add(type);


        yearLabel = new JLabel("Yaar");
        yearLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        yearLabel.setSize(100, 20);
        yearLabel.setLocation(100, 350);
        add(yearLabel);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(60, 20);
        year.setLocation(200, 350);
        add(year);

        semianLabel = new JLabel("Semian");
        semianLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        semianLabel.setSize(100, 20);
        semianLabel.setLocation(100, 400);
        add(semianLabel);

        semian = new JComboBox(semians);
        semian.setFont(new Font("Arial", Font.PLAIN, 15));
        semian.setSize(60, 20);
        semian.setLocation(200, 400);
        add(semian);


        groupLabel = new JLabel("Group");
        groupLabel.setFont(new Font("Arial", Font.PLAIN, 15));
        groupLabel.setSize(100, 20);
        groupLabel.setLocation(100, 450);
        add(groupLabel);

        group = new JComboBox(groups);
        group.setFont(new Font("Arial", Font.PLAIN, 15));
        group.setSize(60, 20);
        group.setLocation(200, 450);
        add(group);

        addEventButton = new JButton("Add Event");
        addEventButton.setFont(new Font("Arial", Font.PLAIN, 15));
        addEventButton.setSize(100, 20);
        addEventButton.setLocation(150, 500);
        addEventButton.addActionListener(this::addEvent);
        add(addEventButton);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 15));
        submitButton.setSize(100, 20);
        submitButton.setLocation(270, 500);
        submitButton.addActionListener(this::submitForm);
        add(submitButton);

        String data[][] = {};
        table = new JTable(new DefaultTableModel(columns, 0));
        tableContainer = new JScrollPane(table);
        tableContainer.setBounds(500,500,500,500);
        tableContainer.setLocation(500,100);
        add(tableContainer);

    }

    private void addEvent(ActionEvent actionEvent)
    {
        //construim un obiect Event cu datele din form
        String name = nameField.getText();
        int start = Integer.parseInt((String) startTime.getSelectedItem());
        int end = Integer.parseInt((String) endTime.getSelectedItem());
        int sizeValue = (int) size.getValue();
        String dayOfWeek = (String) day.getSelectedItem();
        String eventType = (String) type.getSelectedItem();
        String studyYear = (String) year.getSelectedItem();
        String sem = (Strinag) semian.getSelectedItem();
        String studyGroup = (String) group.getSelectedItem();

        Event event = new Event(name,start, end, sizeValue, dayOfWeek,eventType, studyYear, sem, studyGroup);
        events.add(event);

        //rescriem tabelul cu toate datele
        //"name", "start", "end", "size", "day", "type", "year", "semian", "group"};


        String[] cells = new String[columns.length];
        int row=0;

        cells[0] = event.getName();
        cells[1] = String.valueOf(event.getStart());
        cells[2] = String.valueOf(event.getEnd());
        cells[3] = String.valueOf(event.getSize());
        cells[4] = event.getDay();
        cells[5] = event.getType();
        cells[6] = event.getYear();
        cells[7] = event.getSemian();
        cells[8] = event.getGroup();

        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.addRow(cells);

        //resetam toate campurile
        nameField.setText("");



    }

    private void submitForm(ActionEvent event)
    {
        CardLayout cardLayout = (CardLayout) frame.getContainer().getLayout();
        cardLayout.show(frame.getContainer(), "room form");
    }


    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == sub) {
//            if (term.isSelected()) {
//                String data1;
//                String data
//                        = "Name : "
//                        + nameField.getText() + "\n";
//
//
//
//            }
//            else {
//                tout.setText("");
//                resadd.setText("");
//                res.setText("Please accept the"
//                        + " terms & conditions..");
//            }
//        }
//
//        else if (e.getSource() == reset) {
//            String def = "";
//            nameField.setText(def);
//            tadd.setText(def);
//            res.setText(def);
//            tout.setText(def);
//            term.setSelected(false);
//            year.setSelectedIndex(0);
//            resadd.setText(def);
//        }
//
     }
}
