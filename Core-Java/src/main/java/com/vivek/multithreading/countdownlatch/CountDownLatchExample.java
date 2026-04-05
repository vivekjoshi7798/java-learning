package com.vivek.multithreading.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(3);

        Runnable runnable = ()-> {
            System.out.println("Thread Started : "+ Thread.currentThread().getName());
            try{
                Thread.sleep(10000);
            }catch (Exception e){

            }
            System.out.println("Thread Ended : "+ Thread.currentThread().getName());
            latch.countDown();
        };

        new Thread(runnable,"Ramesh").start();
        new Thread(runnable,"Suresh").start();
        new Thread(runnable,"Ganesh").start();

        System.out.println("Team Leader Arrives at Gate Waiting for threads to finish");
        latch.await();
        System.out.println("All threads have finished execution");
    }
}
