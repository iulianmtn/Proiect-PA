package example;

import example.ClientSocket;
import graphics.MainFrame;

public class Main {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int PORT = 5000;
        ClientSocket.getInstance();
        new MainFrame().setVisible(true);

    }
}
