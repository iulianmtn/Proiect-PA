package utilities.entities.entitiesSentByClient;

public class GiveFacultySchedule implements Instruction{
    private String instruction="giveFacultySchedule";
    private int idFaculty;

    public GiveFacultySchedule(int idFaculty) {
        this.idFaculty = idFaculty;
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

}
