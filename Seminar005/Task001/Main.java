package Seminar005.Task001;

//В рамках выполнения задачи необходимо:
//Создать два класс ObjectA, ObjectB
//Реализовать класс в котором два потока при запуске
// провоцируют DeadLock для объектов ObjectA, ObjectB

public class Main {
    public static void main(String[] args) {
        ObA objectA = new ObA();
        ObB objectB = new ObB();

        Thread firstThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objectA) {
                    System.out.println("obA is locked " + Thread.currentThread().getName());
                    synchronized (objectB) {
                        System.out.println("obB is locked " + Thread.currentThread().getName());
                    }
                }
            }
        });
        Thread secondThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objectB) {
                    System.out.println("obB is locked " + Thread.currentThread().getName());
                    synchronized (objectA) {
                        System.out.println("obA is locked " + Thread.currentThread().getName());
                    }
                }
            }
        });
        firstThread.start();
        secondThread.start();
    }
}
