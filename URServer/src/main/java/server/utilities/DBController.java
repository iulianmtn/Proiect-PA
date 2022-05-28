package server.utilities;

import server.model.Event;
import server.model.Room;
import server.utilities.entities.*;

import java.util.ArrayList;
import java.util.List;

import static server.utilities.entities.Colours.*;

/**
 * This class defines the interaction between the data base and the Server
 */
public class DBController {
    private DBController(){}
    ////here we will need the connection to a DB

    /////-------------//////
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

    /**
     * @return all the faculties in a Json format from the server
     */
    public static String getFaculties(){
        ////--->data base interogation
        List<String> faculties = new ArrayList<>();
        faculties.add("UAIC");
        faculties.add("UBB");
        faculties.add("UMF");
        faculties.add("AC");
        FacultyList listFaculties=new FacultyList(faculties);
        ////show us the faculties
        System.out.println(ANSI_PURPLE+listFaculties+ANSI_RESET+"\n------------");

        return JsonSerialAndDeserial.formatToJson(listFaculties);
    }

    /**
     *
     * @param idFaculty
     * @return  returns a json object that contains all the groups of a faculty under de Format 1B1 1B2 2B3..etc
     */
    public static String getGroups(int idFaculty)
    {
        /////---->we will get all the groupt from the dataBase that have the id = idFaculty
        ///---get distinct Semian An grupa for the events and we get all the faculty members
        ///Now for test
        List<String> groupList = new ArrayList<>();
        groupList.add("1B1");
        groupList.add("1B2");
        groupList.add("2B3");
        groupList.add("2B4");

        GroupList myGroupList=new GroupList(groupList);
        System.out.println(ANSI_PURPLE+myGroupList+ANSI_RESET);

        System.out.println("----------");
        return JsonSerialAndDeserial.formatToJson(myGroupList);
    }

    /**
     *  This function gives the schedule of the hole faculty
     * @param idFaculty
     * @return
     */
    public static String getFacultySchedule(int idFaculty){
        //////----making the selection
        //////
        OneEventSchedule eventSchedule1 = new OneEventSchedule("c1","Fisics", DaysOfWeek.SATURDAY,2,10,1,1,"B",LabOrCourse.COURSE);
        OneEventSchedule eventSchedule2 = new OneEventSchedule("c2","Romanian", DaysOfWeek.MONDAY,7,10,2,3,"A",LabOrCourse.COURSE);
        List<OneEventSchedule> listScheduledEvents = new ArrayList<>();
        listScheduledEvents.add(eventSchedule1);
        listScheduledEvents.add(eventSchedule2);
        FacultySchedule facultySchedule = new FacultySchedule(listScheduledEvents);

        System.out.println(ANSI_CYAN+"The schedule of the given faculty : "+ facultySchedule+ANSI_RESET);
        System.out.println("------------");
        return JsonSerialAndDeserial.formatToJson(facultySchedule);

    }

    /**
     *  this function gives the schedule of a certain group of a faculty
     * @param idFaculty
     * @param group
     * @param semian
     * @param year
     * @return
     */

    public static String getGroupSchedule(int idFaculty,int group,String semian,int year)
    {
        ////---here we will make the interogation
        /////
        OneEventSchedule eventSchedule1 = new OneEventSchedule("c1","Fisics", DaysOfWeek.SATURDAY,2,10,2,3,"A",LabOrCourse.COURSE);
        OneEventSchedule eventSchedule2 = new OneEventSchedule("c2","Romanian", DaysOfWeek.MONDAY,7,10,2,3,"A",LabOrCourse.COURSE);
        List<OneEventSchedule> listScheduledEvents = new ArrayList<>();
        listScheduledEvents.add(eventSchedule1);
        listScheduledEvents.add(eventSchedule2);
        GroupSchedule groupSchedule = new GroupSchedule(listScheduledEvents);
        System.out.println(ANSI_GREEN+"The schedule of the given group : "+groupSchedule+ANSI_RESET);
        System.out.println("------------");
        return JsonSerialAndDeserial.formatToJson(groupSchedule);
    }



}
