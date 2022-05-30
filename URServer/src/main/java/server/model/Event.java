package server.model;

public class Event {
    private String name;
    private int start;
    private int end;
    private int size;
    private String day;
    private String type;
    private int year;
    private String semian;
    private int group;

    public Event(String name, int start, int end,int size, String day, String type, int year, String semian, int group) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.size = size;
        this.day = day;
        this.type = type;
        this.year = year;
        this.semian = semian;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public int getType() {
        if(type.equals("course"))
            return 0;
        else return 1;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSemian() {
        return semian;
    }

    public void setSemian(String semian) {
        this.semian = semian;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", start=" + start +
                ", end=" + end +
                ", size=" + size +
                ", day='" + day + '\'' +
                ", type='" + type + '\'' +
                ", year='" + year + '\'' +
                ", semian='" + semian + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
