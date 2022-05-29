package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocket {
    private static ClientSocket instance = null;
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    private static final String serverAddress = "127.0.0.1";
    private static final int PORT = 8001;

    private ClientSocket(){
        try {
            socket = new Socket(serverAddress, PORT);
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    };

    public static ClientSocket getInstance() {
        if(instance == null) {
            instance = new ClientSocket();
        }

        return instance;
    }

    public PrintWriter getOutputStream()
    {
        return out;
    }

    public BufferedReader getInputStream(){
        return in;
    }
}
