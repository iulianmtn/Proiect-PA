package server.utilities.entities;

import java.util.ArrayList;
import java.util.List;

public class FacultyList {
    private String instruction;
    private List<String> faculties=new ArrayList<>();

    public FacultyList(List<String> faculties) {
        this. instruction = "listOfFaculties";
        this.faculties = faculties;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public List<String> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<String> faculties) {
        this.faculties = faculties;
    }

    @Override
    public String toString() {
        return "GetListFaculties{" +
                "instruction='" + instruction + '\'' +
                ", faculties=" + faculties +
                '}';
    }
}
