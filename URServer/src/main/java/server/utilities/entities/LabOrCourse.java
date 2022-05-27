package server.utilities.entities;

public enum LabOrCourse {
    LABORATORY,COURSE;
    public String getValue(){
        switch (this)
        {
            case COURSE : return "Course";
            case LABORATORY:return "Laboratory";
            default : return null;
        }
    }
}
