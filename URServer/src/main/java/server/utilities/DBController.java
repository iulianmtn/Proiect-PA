package server.utilities;

import com.google.gson.Gson;
import server.Database;
import server.model.Event;
import server.model.Room;
import server.utilities.DSaturAlgorithm.DSatur;
import server.utilities.entities.entitiesSentByClient.InsertFormat;
import server.utilities.entities.entitiesSentByServer.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static server.utilities.entities.helpers.Colours.*;

/**
 * This class defines the interaction between the data base and the Server
 */
public class DBController {
    private static Connection connection = Database.getConnection();

    private DBController(){}
    private static Gson transformer = new Gson();
    /**
     * This function will introduce the new data(faculty,rooms,events) into the database but WON'T apply the GCA
     * @param jsonString the data into json format
     */
    public static void  InsertNewFaculty(String jsonString){
        int idFacutate = 0;
        Map<Room, Integer> idRooms = new HashMap<>();

        InsertFormat facultyObject = (InsertFormat) JsonSerialAndDeserial.formatToObject(jsonString);
        System.out.println(facultyObject);
        ///let's get the data from it
        ///what should we do?
        System.out.println("We need to : "+facultyObject.getInstruction());
        ///what faculty
        System.out.println(ANSI_GREEN+"We have the faculty : "+facultyObject.getFacultyName());
        //insert facultate
        try {
            CallableStatement callableStatement = connection.prepareCall("{? = call insert_facultate(?)}");
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.setString(2, facultyObject.getFacultyName());
            callableStatement.executeUpdate();
            idFacutate = callableStatement.getInt(1);
            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ///the rooms
        List<Room> rooms=facultyObject.getRooms();
        int numberRooms=rooms.size();
        for(int indexRoom=0;indexRoom<numberRooms;++indexRoom)
        {
            int idCamera;
            System.out.println(ANSI_YELLOW+"We should insert the room : "+rooms.get(indexRoom));

            try {
                CallableStatement callableStatement = connection.prepareCall("{? = call insert_camera(?, ?, ?)}");
                callableStatement.registerOutParameter(1, Types.INTEGER);
                callableStatement.setInt(2, idFacutate);
                callableStatement.setInt(3, rooms.get(indexRoom).getCapacity());
                callableStatement.setString(4, rooms.get(indexRoom).getName());
                callableStatement.executeUpdate();
                idCamera = callableStatement.getInt(1);
                idRooms.put(rooms.get(indexRoom), idCamera);

                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        Map<Event, Integer> distribution = DSatur.makeSchedule(facultyObject.getRooms(), facultyObject.getEvents(), idRooms);

        ///the events
        List<Event> events=facultyObject.getEvents();
        int numberEvents=events.size();
        for(int indexEvent=0;indexEvent<numberEvents;++indexEvent)
        {
            System.out.println(ANSI_BLUE+"We should insert the event : "+events.get(indexEvent));

            try {
                CallableStatement callableStatement = connection.prepareCall("insert into events (id_facultate, nume, zi, inceput, sfarsit, an, grupa, semian, tip, dimensiune, id_camera) values (?,?,?,?,?,?,?,?,?,?,?)");
                callableStatement.setInt(1, idFacutate);
                callableStatement.setString(2,events.get(indexEvent).getName());
                callableStatement.setString(3,events.get(indexEvent).getDay());
                callableStatement.setInt(4,events.get(indexEvent).getStart());
                callableStatement.setInt(5,events.get(indexEvent).getEnd());
                callableStatement.setInt(6,events.get(indexEvent).getYear());
                callableStatement.setInt(7,events.get(indexEvent).getGroup());
                callableStatement.setString(8,events.get(indexEvent).getSemian());
                callableStatement.setInt(9,events.get(indexEvent).getType());
                callableStatement.setInt(10,events.get(indexEvent).getSize());
                callableStatement.setInt(11, distribution.get(events.get(indexEvent)));
                callableStatement.execute();
                connection.commit();

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        System.out.println(ANSI_RESET+"----------------");
    }


    public static String getFaculties(){
        ///statement to get faculties from where I will get the json for example the following
        String givenJson = null;
        try {
            CallableStatement callableStatement = connection.prepareCall("{? = call get_facultati()}");
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.executeUpdate();
            givenJson = callableStatement.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return givenJson;
    }

    public static String getGroups(int idFaculty)
    {
        ////statement to get the groups of a faculty

        String givenJson = null;
        try {
            CallableStatement callableStatement = connection.prepareCall("{? = call get_grupe(?)}");
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.setInt(2,idFaculty);
            callableStatement.executeUpdate();
            givenJson = callableStatement.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return givenJson;
    }

    public static String getFacultySchedule(int idFaculty){
        ////statement so we can get a schedule
        String givenJson = null;
        try {
            CallableStatement callableStatement = connection.prepareCall("{ ? = call get_fac_ev(?)}");
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.setInt(2, idFaculty);
            callableStatement.executeUpdate();
            givenJson = callableStatement.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return givenJson;
    }


    public static String getGroupSchedule(int idFaculty,int group,String semian,int year)
    { ////statement so we can get a schedule
        String givenJson = null;
        try {
            CallableStatement callableStatement = connection.prepareCall("{ ? = call get_gr_ev(?, ?, ?, ?)}");
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            callableStatement.setInt(2, idFaculty);
            callableStatement.setInt(3,year);
            callableStatement.setString(4,semian);
            callableStatement.setInt(5, group);

            callableStatement.executeUpdate();
            givenJson = callableStatement.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return givenJson;
    }
}
