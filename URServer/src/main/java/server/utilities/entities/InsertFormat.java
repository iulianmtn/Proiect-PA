package server.utilities.entities;

import server.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used in case we want to put another faculty in the DB
 */
public class InsertFormat {
    private String instruction;
    private String facultyName;
    private List<Room> rooms=new ArrayList<>();
    private List<Event> events=new ArrayList<>();

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Event> getEvents() {
        return events;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "InsertFormat{" +
                "instruction='" + instruction + '\'' +
                ", facultyName='" + facultyName + '\'' +
                ", rooms=" + rooms +
                ", events=" + events +
                '}';
    }

    public InsertFormat( String facultyName, List<Room> rooms, List<Event> events) {
        this.instruction = "Insert";
        this.facultyName = facultyName;
        this.rooms = rooms;
        this.events = events;
    }
}
