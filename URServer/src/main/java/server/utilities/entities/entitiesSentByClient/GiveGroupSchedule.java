package server.utilities.entities.entitiesSentByClient;

public class GiveGroupSchedule implements Instruction{
    private String instruction = "giveGroupSchedule";
    private int idFaculty;
    private int year;
    private String semian;
    private int group;

    public GiveGroupSchedule(int id_faculty, int year, String semian, int group) {
        this.idFaculty = id_faculty;
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

    public int getIdFaculty() {
        return idFaculty;
    }

    public void setIdFaculty(int idFaculty) {
        this.idFaculty = idFaculty;
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
