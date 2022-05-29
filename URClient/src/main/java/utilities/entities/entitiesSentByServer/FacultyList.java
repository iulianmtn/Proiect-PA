package utilities.entities.entitiesSentByServer;

import java.util.ArrayList;
import java.util.List;

public class FacultyList {
    private List<FacultyName> faculties=new ArrayList<>();

    public List<FacultyName> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<FacultyName> faculties) {
        this.faculties = faculties;
    }

    public FacultyList(List<FacultyName> faculties) {
        this.faculties = faculties;
    }
}