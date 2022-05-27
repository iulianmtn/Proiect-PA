package example.graphics;

import example.model.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;
import java.util.List;

public class RoomFormPanel extends JPanel {
    private MainFrame frame;

    private JLabel title;
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel capacityLabel;
    private JSpinner capacity;
    private JButton addRoomButton;
    private JButton submitButton;
    private JScrollPane tableContainer;
    private  JTable table;

    private List<Room> rooms;

    private static String columns[] = {"name", "capacity"};

    public RoomFormPanel(MainFrame frame)
    {
        this.frame = frame;

        rooms = new LinkedList<>();
        init();
    }

    private void init()
    {
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
        nameField.setFont(new Font("Arial", Font.PLAIN, 20));
        nameField.setSize(190, 20);
        nameField.setLocation(200, 100);
        add(nameField);

        capacityLabel = new JLabel("Capacity");
        capacityLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        capacityLabel.setSize(100, 20);
        capacityLabel.setLocation(100, 150);
        add(capacityLabel);

        capacity = new JSpinner(new SpinnerNumberModel(30,20,100,1));
        capacity.setFont(new Font("Arial", Font.PLAIN, 20));
        capacity.setSize(60, 20);
        capacity.setLocation(200, 150);
        add(capacity);

        addRoomButton = new JButton("Add Room");
        addRoomButton.setFont(new Font("Arial", Font.PLAIN, 20));
        addRoomButton.setSize(160, 30);
        addRoomButton.setLocation(100, 200);
        addRoomButton.addActionListener(this::addEvent);
        add(addRoomButton);

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 20));
        submitButton.setSize(160, 30);
        submitButton.setLocation(280, 200);
        submitButton.addActionListener(this::submitForm);
        add(submitButton);

        table = new JTable(new DefaultTableModel(columns, 0));
        tableContainer = new JScrollPane(table);
        tableContainer.setBounds(500,500,500,500);
        tableContainer.setLocation(500,100);
        add(tableContainer);

    }

    private void addEvent(ActionEvent actionEvent)
    {
        //construim un obiect Room cu datele din form
        String name = nameField.getText();
        int capacityValue = (int) capacity.getValue();

        Room room = new Room(name, capacityValue);
        rooms.add(room);

        //rescriem tabelul cu toate datele
        //"name", "start", "end", "size", "day", "type", "year", "semian", "group"};


        String[] cells = new String[columns.length];
        int row=0;

        cells[0] = room.getName();
        cells[1] = String.valueOf(room.getCapacity());


        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        tableModel.addRow(cells);

        //resetam toate campurile
        nameField.setText("");

    }

    private void submitForm(ActionEvent event)
    {
        CardLayout cardLayout = (CardLayout) frame.getContainer().getLayout();
        cardLayout.show(frame.getContainer(), "main menu");
    }
}
