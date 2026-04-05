package com.vivek.multithreading.Excecutorserivice;

import java.util.concurrent.*;

public class ScheduledThreadPoolExecutorExample {
    public static void main(String[] args) {
        ScheduledExecutorService executorService1= Executors.newScheduledThreadPool(5);


        executorService1.schedule(() -> {
            try {
                System.out.println("Task 5 started");
                Thread.sleep(5000);
                System.out.println("Task 5 completed");


            } catch (InterruptedException e) {
                System.out.println("Task 5 interrupted");
            }
        },5,TimeUnit.SECONDS);


        Future<String> name= executorService1.schedule( ()->
        {
            try {
            System.out.println("Task 5 started");
            Thread.sleep(5000);
            System.out.println("Task 5 completed");


        } catch (InterruptedException e) {
            System.out.println("Task 5 interrupted");
        }
            return "Done";
    },5,TimeUnit.SECONDS);
        System.out.println(name);


        ScheduledExecutorService scheduleAtFixedRate= Executors.newScheduledThreadPool(5);
        scheduleAtFixedRate.scheduleAtFixedRate( ()->
    {
        try {
            System.out.println("Task scheduleAtFixedRate started");
            Thread.sleep(5000);
            System.out.println("Task scheduleAtFixedRate completed");
        } catch (InterruptedException e) {
            System.out.println("Task scheduleAtFixedRate interrupted");
        }

    },5,5,TimeUnit.SECONDS);
        System.out.println(name);

        scheduleAtFixedRate.shutdownNow();
}
}
