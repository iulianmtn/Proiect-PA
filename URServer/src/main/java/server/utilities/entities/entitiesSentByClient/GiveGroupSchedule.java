package server.utilities.entities.entitiesSentByClient;

public class GiveGroupSchedule implements Instruction{
    private String instruction = "giveGroupSchedule";
    private int id_faculty;
    private int year;
    private String semian;
    private int group;

    public GiveGroupSchedule(int id_faculty, int year, String semian, int group) {
        this.id_faculty = id_faculty;
        this.year = year;
        this.semian = semian;
        this.group = group;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public int getId_faculty() {
        return id_faculty;
    }

    public void setId_faculty(int id_faculty) {
        this.id_faculty = id_faculty;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSemian() {
        return semian;
    }

    public void setSemian(String semian) {
        this.semian = semian;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }
}
