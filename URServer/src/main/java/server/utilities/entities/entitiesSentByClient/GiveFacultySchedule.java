package server.utilities.entities.entitiesSentByClient;

public class GiveFacultySchedule implements Instruction{
    private String instruction="giveFacultySchedule";
    private int id_faculty;

    public GiveFacultySchedule(int id_faculty) {
        this.id_faculty = id_faculty;
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

}
