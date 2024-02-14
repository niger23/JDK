package Seminar002;

import Seminar002.client.Client;
import Seminar002.client.ClientGUI;
import Seminar002.server.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientGUI(serverWindow);
        new ClientGUI(serverWindow);
    }
}
