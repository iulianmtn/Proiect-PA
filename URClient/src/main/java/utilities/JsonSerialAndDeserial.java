package utilities;

import com.google.gson.Gson;
import utilities.entities.entitiesSentByClient.*;
import utilities.entities.entitiesSentByServer.*;

import java.io.ObjectStreamException;

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

        if(jasonFormat.contains("\"instruction\":\"Insert\""))  //////instructions sent by the client
            return gson.fromJson(jasonFormat, InsertFormat.class);
        else
        if(jasonFormat.contains("\"instruction\":\"giveFaculties\""))
            return gson.fromJson(jasonFormat, GiveFaculties.class);
        else
        if(jasonFormat.contains("\"instruction\":\"giveGroups\""))
            return gson.fromJson(jasonFormat, GiveGroups.class);
        else
        if(jasonFormat.contains("\"instruction\":\"giveFacultySchedule\""))
            return gson.fromJson(jasonFormat, GiveFacultySchedule.class);
        else
        if(jasonFormat.contains("\"instruction\":\"giveGroupSchedule\""))
            return gson.fromJson(jasonFormat, GiveGroupSchedule.class);
        else
            return null;

    }
}
