package server.utilities.entities;

public enum DaysOfWeek {
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY;
    public String getValue(){
        switch (this)
        {
            case MONDAY : return "Monday";
            case TUESDAY: return "Tuesday";
            case WEDNESDAY: return "Wednesday";
            case THURSDAY: return "Thursday";
            case FRIDAY: return "Friday";
            case SATURDAY: return "Saturday";
            default: return null;
        }
    }
}
