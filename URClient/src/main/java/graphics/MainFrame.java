package graphics;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private Container container;
    private MainMenuPanel mainMenuPanel;
    private AdminPanel adminPanel;
    private StudentPanel studentPanel;
    private EventFormPanel eventFormPanel;
    private RoomFormPanel roomFormPanel;


    public MainFrame() {
        super("University Resource Allocator");
        init();
    }

    public void init()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200,800);

        container = getContentPane();
        container.setLayout(new CardLayout(40,30));

        mainMenuPanel = new MainMenuPanel(this);
        adminPanel = new AdminPanel(this);
        studentPanel = new StudentPanel(this);
        eventFormPanel = new EventFormPanel(this);
        roomFormPanel = new RoomFormPanel(this);

        container.add(mainMenuPanel, "main menu");
        container.add(adminPanel, "admin");
        container.add(studentPanel, "student");
        container.add(eventFormPanel, "event form");
        container.add(roomFormPanel, "room form");

        //panelul de intrare
        //getContentPane().add(new MainMenuPanel(this));
    }

    public Container getContainer() {
        return container;
    }

    public AdminPanel getAdminPanel() {
        return adminPanel;
    }

    public StudentPanel getStudentPanel() {
        return studentPanel;
    }

    public EventFormPanel getEventFormPanel() {
        return eventFormPanel;
    }

    public RoomFormPanel getRoomFormPanel() {
        return roomFormPanel;
    }
}
