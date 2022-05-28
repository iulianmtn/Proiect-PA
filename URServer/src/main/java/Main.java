//import server.model.Event;
//import server.model.Room;
//import server.utilities.*;
//import server.utilities.entities.InsertFormat;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello World");
//        // new MainFrame().setVisible(true);
//        /////for testing
//        List<Room> rooms = new ArrayList<>();
//        rooms.add(new Room("c1", 100));
//        List<Event> events = new ArrayList<>();
//        events.add(new Event("Mate", 1, 2, 100, "monday", "course", "1", "B", "2"));
//        events.add(new Event("Info", 1, 2, 10, "tuesday", "lab", "2", "B", "2"));
//
//
//        InsertFormat insertFormat = new InsertFormat("UAIC", rooms, events);
//        String jsonFormat = JsonSerialAndDeserial.formatToJson(insertFormat);
//        DBController.InsertNewFaculty(jsonFormat);
//        System.out.println(JsonSerialAndDeserial.formatToObject(jsonFormat));
//        /////tests for the Insert in DB
//        String jsonFaculties = DBController.getFaculties();
//        System.out.println(jsonFaculties);
//        System.out.println(JsonSerialAndDeserial.formatToObject(jsonFaculties));
//        ////tests for the getter of faculties
//        String jsonGroups = DBController.getGroups(1);
//        System.out.println(jsonGroups);
//        System.out.println(JsonSerialAndDeserial.formatToObject(jsonGroups));
//        ////tests for the getter of groups
//        String jsonFacultySchedule = DBController.getFacultySchedule(1);
//        System.out.println(jsonFacultySchedule);
//        System.out.println(JsonSerialAndDeserial.formatToObject(jsonFacultySchedule));
//        ///tests for the getter of schedule of the faculty
//        String jsonGroupSchedule = DBController.getGroupSchedule(1, 1, "A", 1);
//        System.out.println(jsonGroupSchedule);
//        System.out.println(JsonSerialAndDeserial.formatToObject(jsonGroupSchedule));
//
//    }
//}
