package Seminar002.client;

public interface ClientView {
    void sendMessage(String message);
    void connectedToServer();
    void disconnectedFromServer();
}
