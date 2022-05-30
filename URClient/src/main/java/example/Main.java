package example;

import graphics.MainFrame;

public class Main {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int PORT = 8001;
        ClientSocket.getInstance();
        new MainFrame().setVisible(true);
    }
}
