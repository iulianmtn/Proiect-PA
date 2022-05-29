package server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import server.utilities.DBController;
import server.utilities.JsonSerialAndDeserial;
import server.utilities.entities.entitiesSentByClient.GiveFaculties;
import server.utilities.entities.entitiesSentByClient.Instruction;
import server.utilities.entities.entitiesSentByServer.FacultyName;
import server.utilities.entities.entitiesSentByServer.ScheduledDay;

import java.io.*;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static server.utilities.entities.helpers.Colours.ANSI_BLUE;
import static server.utilities.entities.helpers.Colours.ANSI_RESET;

public class ClientThread extends Thread{
    private Socket socket = null;

    public ClientThread(Socket socket)
    {
        this.socket = socket;
    }
    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            while (true)
            {
                String request = in.readLine();
                Instruction instruction = (Instruction) JsonSerialAndDeserial.formatToObject(request);
                System.out.println(instruction.getInstruction());
                switch (instruction.getInstruction())
                {
                    case "Insert" :
                            System.out.println("I have an insert!");
                        DBController.InsertNewFaculty(request);
                            break;
                    case "giveFaculties" :
                            System.out.println("Somebody wants the faculties");
                        String jsonFaculties = DBController.getFaculties();
                        //out.println(jsonFaculties);

                            break;
                    case "giveGroups" :
                        System.out.println("I want the groups");
                        String jsonGroups = DBController.getGroups(1);
                        System.out.println(jsonGroups);
                            break;
                    case "giveFacultySchedule" :
                        System.out.println("I want the Faculty Schedule");
                        String facultySchedule = DBController.getFacultySchedule(1);
                        System.out.println(facultySchedule);
//                        Type listType = new TypeToken<ArrayList<ScheduledDay>>(){}.getType();
//                        List<ScheduledDay> yourClassList = new Gson().fromJson(facultySchedule, listType);
                            break;
                    case "giveGroupSchedule" :
                        System.out.println("I want a group's Schedule");
                        String groupSchedule = DBController.getGroupSchedule(1,1,"B",1);
                        System.out.println(groupSchedule);
                            break;
                    default : System.out.println("Something went wrong:(");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
