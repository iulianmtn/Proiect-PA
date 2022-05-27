package utilities;
import example.model.Event;
import example.model.Room;
import model.*;

import java.util.ArrayList;
import java.util.List;

public class InsertFormat {
    private String instruction;
    private String facultyName;
    private List<Room> rooms=new ArrayList<>();
    private List<Event> events=new ArrayList<>();

    @Override
    public String toString() {
        return "InsertFormat{" +
                "instruction='" + instruction + '\'' +
                ", facultyName='" + facultyName + '\'' +
                ", rooms=" + rooms +
                ", events=" + events +
                '}';
    }

    public InsertFormat(String instruction, String facultyName, List<Room> rooms, List<Event> events) {
        this.instruction = instruction;
        this.facultyName = facultyName;
        this.rooms = rooms;
        this.events = events;
    }
}
