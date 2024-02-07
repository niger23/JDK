package HomeWork001;

import HomeWork001.client.ClientWindow;
import HomeWork001.server.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow serverWindow = new ServerWindow();
        new ClientWindow(serverWindow);
        new ClientWindow(serverWindow);
    }
}
