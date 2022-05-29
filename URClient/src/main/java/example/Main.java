package example;

import example.ClientSocket;
import graphics.MainFrame;
import utilities.JsonSerialAndDeserial;
import utilities.entities.entitiesSentByServer.FacultyName;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int PORT = 8001;
        ClientSocket.getInstance();
        new MainFrame().setVisible(true);
    }
}
