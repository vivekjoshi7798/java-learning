package com.vivek.multithreading.Excecutorserivice;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.*;

public class ShutdownExample {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        ExecutorService service = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        service.submit(() -> {
            try {
                System.out.println("Task 1 started");
                Thread.sleep(5000);
                System.out.println("Task 1 completed");
                System.out.println("ShutDown  exercise completed " + LocalDateTime.now().format(formatter));
            } catch (InterruptedException e) {
                System.out.println("Task 1 interrupted");
            }
        });

        service.shutdown();
        System.out.println("ShutDown exercise started " + LocalDateTime.now().format(formatter));

        ExecutorService service2 = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        service2.submit(() -> {
            try {
                System.out.println("Task 1 started");
                Thread.sleep(5000);
                System.out.println("Task 1 completed");
            } catch (InterruptedException e) {
                System.out.println("Task 1 interrupted");
            }
        });

        service2.shutdown();
//        service2.submit(()-> System.out.println("Hello"));
//        will get RejectedExecutionException


        ExecutorService service3 = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        service3.submit(() -> {
            try {
                System.out.println("Task 2 started");
                Thread.sleep(5000);
                System.out.println("Task 2 completed");
                System.out.println("ShutDown now exercise completed " + LocalDateTime.now().format(formatter));

            } catch (InterruptedException e) {
                System.out.println("Task 2 interrupted");
            }
        });

        service3.shutdownNow();
        List<Runnable> runnable= service3.shutdownNow();

        ExecutorService service5 = new ThreadPoolExecutor(2, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        service5.submit(() -> {
            try {
                System.out.println("Task 5 started");
                Thread.sleep(5000);
                System.out.println("Task 5 completed");


            } catch (InterruptedException e) {
                System.out.println("Task 5 interrupted");
            }
        });

        try {
            System.out.println("Forcing shutdown now " + LocalDateTime.now().format(formatter));
            boolean isTerminated = service5.awaitTermination(3, TimeUnit.SECONDS);
            if (!isTerminated) {
                System.out.println("ShutDown now exercise Started "+LocalDateTime.now().format(formatter));

            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        runnable.forEach(System.out::println);




        System.out.println("ExecutorService shutdown initiated amd main thread completed");
    }
}

