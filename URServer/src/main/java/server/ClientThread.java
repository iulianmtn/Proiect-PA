package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

            while (true)
            {
                String request = in.readLine();
                System.out.println(request);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
