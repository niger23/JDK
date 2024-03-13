package Lesson005;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Calc {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Task> queue = new ArrayDeque<>();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Thread taskService = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    executor.submit(() -> {
                        Task task = queue.poll();
                        if (task != null) {
                            System.out.println("Task " + task + " started");
                            task.run();
                        }
                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        taskService.start();
        while (in.hasNextLine()) {
            try {
//                String[] tokens = in.nextLine().split("\\+");
//                int left = Integer.parseInt(tokens[0]);
//                int right = Integer.parseInt(tokens[1]);
                int value = Integer.parseInt(in.nextLine().trim());
                Task task = new Task(value);
                queue.add(task);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
