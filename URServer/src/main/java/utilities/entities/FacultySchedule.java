package server.utilities.entities;

import java.util.ArrayList;
import java.util.List;

public class FacultySchedule {
    private String instruction = "getFacultySchedule";
    private List<OneEventSchedule> schedule = new ArrayList<>();

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public List<OneEventSchedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<OneEventSchedule> schedule) {
        this.schedule = schedule;
    }

    public FacultySchedule(List<OneEventSchedule> schedule) {
        this.schedule = schedule;
    }

    @Override
    public String toString() {
        return "FacultySchedule{" +
                "instruction='" + instruction + '\'' +
                ", schedule=" + schedule +
                '}';
    }
}
