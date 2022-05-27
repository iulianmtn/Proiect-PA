package server.utilities;

import java.util.ArrayList;
import java.util.List;

public class GroupList {
    private String instruction;
    private List<Integer> groupList=new ArrayList<>();

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public List<Integer> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Integer> groupList) {
        this.groupList = groupList;
    }

    public GroupList( List<Integer> groupList) {
        this.instruction = "getGroupList";
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
