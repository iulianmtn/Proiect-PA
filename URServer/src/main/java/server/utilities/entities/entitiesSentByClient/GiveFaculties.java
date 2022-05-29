package server.utilities.entities.entitiesSentByClient;

public class GiveFaculties implements Instruction{
    private String instruction = "giveFaculties";

    public GiveFaculties() {}

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}
