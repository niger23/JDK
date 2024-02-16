package Seminar002.server;

import Seminar002.client.Client;

import java.util.ArrayList;
import java.util.List;

public class Server {
    private List<Client> clientList;
    private Repository repository;
    private boolean work = false;
    private ServerView view;

    public Server(Repository repository, ServerView view) {
        clientList = new ArrayList<>();
        this.repository = repository;
        this.view = view;
    }
    public void work(boolean flag) {
        if (flag && work) {
            view.message("Сервер уже запущен");
        } else if (!flag && !work) {
            view.message("Сервер уже остановлен");
        } else {
            work = flag;
            if (work) {
                view.message("Сервер запущен");
                view.message(getLog());
            }
            else {
                view.message("Сервер остановлен");
                for (Client client: clientList){
                    client.disconnectFromServer();
                }
                answerAll("Сервер остановлен!");
            }
        }
    }
    public String getLog() {
        return repository.load();
    }
    public void setLog(String log) {
        repository.save(log);
    }
    public boolean connectUser(Client client){
        if (!work){
            return false;
        }
        clientList.add(client);
        return true;
    }
    private void answerAll(String text){
        for (Client client: clientList){
            client.answerFromServer(text);
        }
    }
    public void disconnectUser(Client client){
        clientList.remove(client);
        if (client != null){
            client.disconnectFromServer();
        }
    }
    public void message(String text){
        if (!work){
            return;
        }
        view.message(text);
        answerAll(text);
        setLog(text);
    }
}
