package server.utilities;

import server.model.Event;
import server.model.Room;

import java.util.ArrayList;
import java.util.List;

import static server.utilities.Colours.*;

/**
 * This class defines the interaction between the data base and the Server
 */
public class DBController {
    private DBController(){}
    ////aici ar trebuii sa am conexiunea la server

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
    public static String getGroups(int idFaculty)
    {
        /////---->we will get all the groupt from the dataBase that have the id = idFaculty

        ///Now for test
        List<Integer> groupList = new ArrayList<>();
        groupList.add(1);
        groupList.add(2);
        groupList.add(3);
        groupList.add(4);

        GroupList myGroupList=new GroupList(groupList);
        System.out.println(ANSI_PURPLE+myGroupList+ANSI_RESET);

        System.out.println("----------");
        return JsonSerialAndDeserial.formatToJson(myGroupList);
    }

}
