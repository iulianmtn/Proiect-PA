package utilities.entities.entitiesSentByServer;

public class FacultyGroup {
    private String group;

    public FacultyGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "FacultyGroup{" +
                "group='" + group + '\'' +
                '}';
    }
}
