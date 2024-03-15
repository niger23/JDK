package HomeWork005;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Table extends Thread{
    private List<Fork> listFr;
    private List<Philosopher> listPh;
    private CountDownLatch cdl;

    public Table() {
        listFr = new ArrayList<>();
        listPh = new ArrayList<>();
        cdl = new CountDownLatch(5);
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            listFr.add(new Fork());
        }
        for (int i = 0; i < 5; i++) {
            listPh.add(new Philosopher(i, cdl, listFr, this));
        }
        for (Philosopher philosopher : listPh) {
            philosopher.start();
        }
    }
    public synchronized boolean eatForks(int fork1, int fork2) {
        if (listFr.get(fork1).isFree() && listFr.get(fork2).isFree()) {
            listFr.get(fork1).takeFork();
            listFr.get(fork2).takeFork();
            return true;
        }
        return false;
    }
    public void endEatForks(int fork1, int fork2) {
        listFr.get(fork1).putFork();
        listFr.get(fork2).putFork();
    }

}
