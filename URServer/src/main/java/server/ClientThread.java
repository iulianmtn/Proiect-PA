package server;

import server.utilities.DBController;
import server.utilities.JsonSerialAndDeserial;
import server.utilities.entities.entitiesSentByClient.*;

import java.io.*;
import java.net.Socket;

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
                        String jsonGroups = DBController.getGroups(giveGroups.getIdFaculty());
                        out.println(jsonGroups);
                        out.flush();
                            break;
                    case "giveFacultySchedule" :
                        System.out.println("I want the Faculty Schedule");
                        GiveFacultySchedule giveFacultySchedule = (GiveFacultySchedule) instruction;
                        String facultySchedule = DBController.getFacultySchedule(giveFacultySchedule.getIdFaculty());
                        out.println(facultySchedule);
                        out.flush();
//                        Type listType = new TypeToken<ArrayList<ScheduledDay>>(){}.getType();
//                        List<ScheduledDay> yourClassList = new Gson().fromJson(facultySchedule, listType);
                            break;
                    case "giveGroupSchedule" :
                        System.out.println("I want a group's Schedule");
                        GiveGroupSchedule giveGroupSchedule = (GiveGroupSchedule) instruction;
                        String groupSchedule = DBController.getGroupSchedule(giveGroupSchedule.getIdFaculty(),
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
