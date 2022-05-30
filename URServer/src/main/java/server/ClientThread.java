package server;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import server.utilities.DBController;
import server.utilities.JsonSerialAndDeserial;
import server.utilities.entities.entitiesSentByClient.*;
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
                        out.println(jsonFaculties);
                        out.flush();

                            break;
                    case "giveGroups" :
                        System.out.println("I want the groups");
                        GiveGroups giveGroups = (GiveGroups) instruction;
                        String jsonGroups = DBController.getGroups(giveGroups.getId_faculty());
                        out.println(jsonGroups);
                        out.flush();
                            break;
                    case "giveFacultySchedule" :
                        System.out.println("I want the Faculty Schedule");
                        GiveFacultySchedule giveFacultySchedule = (GiveFacultySchedule) instruction;
                        String facultySchedule = DBController.getFacultySchedule(giveFacultySchedule.getId_faculty());
                        out.println(facultySchedule);
                        out.flush();
//                        Type listType = new TypeToken<ArrayList<ScheduledDay>>(){}.getType();
//                        List<ScheduledDay> yourClassList = new Gson().fromJson(facultySchedule, listType);
                            break;
                    case "giveGroupSchedule" :
                        System.out.println("I want a group's Schedule");
                        GiveGroupSchedule giveGroupSchedule = (GiveGroupSchedule) instruction;
                        String groupSchedule = DBController.getGroupSchedule(giveGroupSchedule.getId_faculty(),
                                                                            giveGroupSchedule.getGroup(),
                                                                            giveGroupSchedule.getSemian(),
                                                                            giveGroupSchedule.getYear());
                        out.println(groupSchedule);
                        out.flush();
                            break;
                    default : System.out.println("Something went wrong:(");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
