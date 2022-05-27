package model;

public class Event {
    private String name;
    private int start;
    private int end;
    private int size;
    private String day;
    private String type;
    private String year;
    private String semian;
    private String group;

    public Event(String name, int start, int end,int size, String day, String type, String year, String semian, String group) {
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

    public String getType() {
        return type;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
