import com.google.gson.Gson;
import graphics.MainFrame;
import model.Event;
import model.Room;
import utilities.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");
        new MainFrame().setVisible(true);
        InsertFormat insertFormat=new InsertFormat("Insert","UAIC",new ArrayList<Room>(),new ArrayList<Event>());
        String jsonFormat=Utilities.formatToJson(insertFormat);
        System.out.println(jsonFormat);
        insertFormat=Utilities.formatToObject(jsonFormat);
        System.out.println(insertFormat);
    }
}
