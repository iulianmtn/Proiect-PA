package server.utilities.entities;

import java.util.ArrayList;
import java.util.List;

public class GroupSchedule {
    private String instruction = "getGroupSchedule";
    private List<OneEventSchedule> schedule=new ArrayList<>();

    public GroupSchedule(List<OneEventSchedule> schedule) {
        this.schedule = schedule;
    }

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

    @Override
    public String toString() {
        return "GroupSchedule{" +
                "instruction='" + instruction + '\'' +
                ", schedule=" + schedule +
                '}';
    }
}
