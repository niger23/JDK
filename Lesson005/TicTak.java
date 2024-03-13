package Lesson005;

public class TicTak implements Runnable{

    private final String bracket;
    private final Object monitor;

    public TicTak(String bracket) {
        this.bracket = bracket;
        this.monitor = TicTak.class;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (monitor) {
                System.out.print(bracket);
                try {
                    Thread.sleep(300);
                    monitor.notify();
                    monitor.wait();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
