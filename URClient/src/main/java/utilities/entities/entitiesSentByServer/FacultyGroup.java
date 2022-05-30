package utilities.entities.entitiesSentByServer;

public class FacultyGroup {
    private String grupa;

    public FacultyGroup(String group) {
        this.grupa = group;
    }

    public String getGrupa() {
        return grupa;
    }

    public void setGrupa(String grupa) {
        this.grupa = grupa;
    }

    @Override
    public String toString() {
        return "FacultyGroup{" +
                "group='" + grupa + '\'' +
                '}';
    }
}
