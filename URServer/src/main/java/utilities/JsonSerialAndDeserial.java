package server.utilities;

import com.google.gson.Gson;
import server.utilities.entities.*;

/**
 * This class helps with serialization and deserialization for the client and server
 */

public class JsonSerialAndDeserial {
    private JsonSerialAndDeserial(){}
    private static Gson gson=new Gson();
    public static String formatToJson(Object object)
    {
        return gson.toJson(object);
    }
    public static Object formatToObject(String jasonFormat) {

        if(jasonFormat.contains("\"instruction\":\"Insert\""))
                return gson.fromJson(jasonFormat, InsertFormat.class);
            else
        if(jasonFormat.contains("\"instruction\":\"listOfFaculties\""))
                return gson.fromJson(jasonFormat, FacultyList.class);
            else
        if(jasonFormat.contains("\"instruction\":\"getGroupList\""))
                return  gson.fromJson(jasonFormat, GroupList.class);
            else
        if(jasonFormat.contains("\"instruction\":\"getFacultySchedule\""))
                return gson.fromJson(jasonFormat, FacultySchedule.class);
            else
        if(jasonFormat.contains("\"instruction\":\"getGroupSchedule\""))
                return gson.fromJson(jasonFormat, GroupSchedule.class);
            else
                return null;

    }
}