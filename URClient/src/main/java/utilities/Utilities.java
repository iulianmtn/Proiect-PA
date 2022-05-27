package utilities;

import com.google.gson.Gson;

public class Utilities {
    private Utilities(){}
    private static Gson gson=new Gson();
    public static String formatToJson(Object object)
    {
        return gson.toJson(object);
    }
    public static InsertFormat formatToObject(String jasonFormat)
    {
        return gson.fromJson(jasonFormat,InsertFormat.class);
    }
}
