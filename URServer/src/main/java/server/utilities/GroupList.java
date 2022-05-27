package server.utilities;

import java.util.ArrayList;
import java.util.List;

public class GroupList {
    private String instruction;
    private List<String> groupList=new ArrayList<>();

    public String getInstruction() {
        return instruction;
    }

    public GroupList( List<String> groupList) {
        this.instruction = "getGroupList";
        this.groupList = groupList;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public List<String> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<String> groupList) {
        this.groupList = groupList;
    }

    @Override
    public String toString() {
        return "GroupList{" +
                "instruction='" + instruction + '\'' +
                ", groupList=" + groupList +
                '}';
    }
}
