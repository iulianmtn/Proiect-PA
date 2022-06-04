package utilities.entities.entitiesSentByClient;

public class GiveGroups implements Instruction{
    private String instruction = "giveGroups";
    private int idFaculty;

    public GiveGroups( int idFaculty) {
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
