package server.utilities;

import server.utilities.entities.DaysOfWeek;
import server.utilities.entities.LabOrCourse;

/**
 * This class is made so we make it easier to see where we decode Enums
 */
public class EnumDecoder {
    private EnumDecoder(){};
    public static String decode(DaysOfWeek day){
        return day.getValue();
    }
    public static String decode(LabOrCourse loc){
        return loc.getValue();
    }
}
