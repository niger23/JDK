package Seminar005.Task003;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner extends Thread{
    private String name;
    private CountDownLatch countDownLatch;
    private Random rnd = new Random();

    public Runner(String name, CountDownLatch countDownLatch) {
        this.name = name;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            toStart();
            countDownLatch.await();
            toFinish();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
    public void toStart() throws InterruptedException {
        System.out.println(name + " walk to start");
        Thread.sleep(rnd.nextInt(1000,3000));
        System.out.println(name + " ready run");
        countDownLatch.countDown();
    }
    public void toFinish() throws InterruptedException {
        System.out.println(name + " run to finish");
        Thread.sleep(rnd.nextInt(3000,6000));
        System.out.println(name + " finished");
    }
}
