package server.utilities;

import com.google.gson.Gson;
import server.model.Event;
import server.model.Room;
import server.utilities.entities.entitiesSentByClient.InsertFormat;
import server.utilities.entities.entitiesSentByServer.*;

import java.util.ArrayList;
import java.util.List;

import static server.utilities.entities.helpers.Colours.*;

/**
 * This class defines the interaction between the data base and the Server
 */
public class DBController {
    private DBController(){}
    private static Gson transformer = new Gson();
    /**
     * This function will introduce the new data(faculty,rooms,events) into the database but WON'T apply the GCA
     * @param jsonString the data into json format
     */
    public static void  InsertNewFaculty(String jsonString){
        InsertFormat facultyObject = (InsertFormat) JsonSerialAndDeserial.formatToObject(jsonString);
        System.out.println(facultyObject);
        ///let's get the data from it
        ///what should we do?
        System.out.println("We need to : "+facultyObject.getInstruction());
        ///what faculty
        System.out.println(ANSI_GREEN+"We have the faculty : "+facultyObject.getFacultyName());
        ///the rooms
        List<Room> rooms=facultyObject.getRooms();
        int numberRooms=rooms.size();
        for(int indexRoom=0;indexRoom<numberRooms;++indexRoom)
        {
            System.out.println(ANSI_YELLOW+"We should insert the room : "+rooms.get(indexRoom));
        }
        ///the events
        List<Event> events=facultyObject.getEvents();
        int numberEvents=events.size();
        for(int indexEvent=0;indexEvent<numberEvents;++indexEvent)
        {
            System.out.println(ANSI_BLUE+"We should insert the event : "+events.get(indexEvent));
        }
        System.out.println(ANSI_RESET+"----------------");
    }


    public static String getFaculties(){
        ///statement to get faculties from where I will get the json for example the following

        String givenJson = "[{\"nume\":\"info\"},{\"nume\":\"mate\"}]";

        return givenJson;
    }

    public static String getGroups(int idFaculty)
    {
        //statement to get the faculties
       return null;
    }

    public static String getFacultySchedule(int idFaculty){
        ////statement so we can get a schedule
        List<ScheduledEvent> scheduledEventList = new ArrayList<>();
        scheduledEventList.add(new ScheduledEvent("mate",8,10,30,"3B1","C1","curs"));
        scheduledEventList.add(new ScheduledEvent("info",10,12,30,"2B2","C2","lab"));
        ScheduledDay monday = new ScheduledDay("luni",scheduledEventList);
        scheduledEventList.clear();
        scheduledEventList.add(new ScheduledEvent("romana",10,12,30,"3B1","C2","lab"));
        ScheduledDay tuesday = new ScheduledDay("marti",scheduledEventList);
        List<ScheduledDay> schedule = new ArrayList<>();
        schedule.add(monday);
        schedule.add(tuesday);

        String scheduledFaculty = transformer.toJson(schedule);
        return scheduledFaculty;
            }


    public static String getGroupSchedule(int idFaculty,int group,String semian,int year)
    { ////statement so we can get a schedule
        List<ScheduledEvent> scheduledEventList = new ArrayList<>();
        scheduledEventList.add(new ScheduledEvent("mate",8,10,30,"2B1","C1","curs"));
        scheduledEventList.add(new ScheduledEvent("info",10,12,30,"2B1","C2","curs"));
        ScheduledDay monday = new ScheduledDay("luni",scheduledEventList);
        List<ScheduledEvent> scheduledEventList1=new ArrayList<>();
        scheduledEventList1.add(new ScheduledEvent("romana",10,12,30,"2B1","P901","lab"));
        ScheduledDay tuesday = new ScheduledDay("marti",scheduledEventList1);
        List<ScheduledDay> schedule = new ArrayList<>();
        schedule.add(monday);
        schedule.add(tuesday);

        String scheduledFaculty = transformer.toJson(schedule);
        return scheduledFaculty;
    }



}
