package utilities.entities.entitiesSentByServer;

import java.util.ArrayList;
import java.util.List;

/**
 * used by GiveFacultySchedule and GiveGroupSchedule
 */
public class ScheduledDay {
    private String zi;
    private List<ScheduledEvent> events=new ArrayList<>();

    public ScheduledDay(String zi, List<ScheduledEvent> events) {
        this.zi = zi;
        this.events = new ArrayList<>(events);
    }

    public String getZi() {
        return zi;
    }

    public void setZi(String zi) {
        this.zi = zi;
    }

    public List<ScheduledEvent> getEvents() {
        return events;
    }

    public void setEvents(List<ScheduledEvent> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "ScheduledDay{" +
                "zi='" + zi + '\'' +
                ", events=" + events +
                '}';
    }
}
