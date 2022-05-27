package server.utilities;

import com.google.gson.Gson;

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
                return gson.fromJson(jasonFormat,InsertFormat.class);
            else
        if(jasonFormat.contains("\"instruction\":\"listOfFaculties\""))
                return gson.fromJson(jasonFormat, FacultyList.class);
            else
        if(jasonFormat.contains("\"instruction\":\"getGroupList\""))
                return  gson.fromJson(jasonFormat, GroupList.class);
            else
                return null;
    }
}
