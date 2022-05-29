package server;

import com.google.gson.Gson;
import server.utilities.DBController;
import server.utilities.entities.entitiesSentByServer.FacultyName;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static final int PORT = 8001;

    public Server(){
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(PORT);

            while(true)
            {
                System.out.println("waiting for a client");
                Socket socket = serverSocket.accept();

                ClientThread clientThread = new ClientThread(socket);
                clientThread.start();
                clientThread.join();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
       Server server = new Server();
    }
}
