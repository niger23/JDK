package HomeWork005;

import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Philosopher extends Thread{
    private Table table;
    private int number = 0;
    private volatile List<Fork> listFr;
    private CountDownLatch cdl;
    private int countEat = 0;

    public Philosopher(int number, CountDownLatch cdl, List<Fork> listFr, Table table) {
        this.number = number;
        this.cdl = cdl;
        this.listFr = listFr;
        this.table = table;
    }

    @Override
    public void run() {
        try {
            while (countEat < 3) {
                eat(listFr);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        cdl.countDown();
        System.out.println("Philosopher " + number + " complete");
    }

    public void eat(List<Fork> listFr) throws InterruptedException {
        int fork1 = (((number - 1) < 0) ? listFr.size() - 1:number - 1);
        int fork2 = number;
        if (table.eatForks(fork1, fork2)) {
            Thread.sleep(2000);
            table.endEatForks(fork1, fork2);
            System.out.println("Philosopher " + number + " eat fork:" + number + fork1);
            countEat++;
        } else {
            Thread.sleep(2000);
        }
    }

}
