package server.utilities;

import java.util.ArrayList;
import java.util.List;

public class SemianList {
    private String instruction = "getSemianList";
    private List<String> semianList = new ArrayList<>();

    public SemianList(List<String> semianList) {
        this.semianList = semianList;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public List<String> getSemianList() {
        return semianList;
    }

    public void setSemianList(List<String> semianList) {
        this.semianList = semianList;
    }

    @Override
    public String toString() {
        return "SemianList{" +
                "instruction='" + instruction + '\'' +
                ", semianList=" + semianList +
                '}';
    }
}
