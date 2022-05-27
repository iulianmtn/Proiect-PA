package server.utilities.entities;

public class OneEventSchedule {
    private String roomName;
    private String eventName;
    private DaysOfWeek day;
    private int start;
    private int end;
    private int year;
    private int group;
    private String semian;
    private LabOrCourse courseOrLab;

    public OneEventSchedule(String roomName, String eventName, DaysOfWeek day, int start, int end, int year, int group, String semian, LabOrCourse courseOrLab) {
        this.roomName = roomName;
        this.eventName = eventName;
        this.day = day;
        this.start = start;
        this.end = end;
        this.year = year;
        this.group = group;
        this.semian = semian;
        this.courseOrLab = courseOrLab;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public DaysOfWeek getDay() {
        return day;
    }

    public void setDay(DaysOfWeek day) {
        this.day = day;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getSemian() {
        return semian;
    }

    public void setSemian(String semian) {
        this.semian = semian;
    }

    public LabOrCourse getCourseOrLab() {
        return courseOrLab;
    }

    public void setCourseOrLab(LabOrCourse courseOrLab) {
        this.courseOrLab = courseOrLab;
    }

    @Override
    public String toString() {
        return "\nFacultySchedule{" +
                ", roomName='" + roomName + '\'' +
                ", eventName='" + eventName + '\'' +
                ", day=" + day +
                ", start=" + start +
                ", end=" + end +
                ", year=" + year +
                ", group='" + group + '\'' +
                ", semian='" + semian + '\'' +
                ", courseOrLab=" + courseOrLab +
                '}';
    }
}
