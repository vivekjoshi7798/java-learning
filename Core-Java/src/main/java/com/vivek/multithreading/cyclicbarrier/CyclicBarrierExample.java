package multithreading.cyclicbarrier;

/*
* CyclicBarrier allows a group of threads to wait for each other at a common point and automatically resets after all threads reach the barrier.
*
* */


import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    static CyclicBarrier barrier = new CyclicBarrier(3, ()-> {
        System.out.println("✅ All trekkers reached checkpoint. Moving together!\\n");
    });

    static Runnable runnable= ()-> {
        System.out.println("Thread Started : "+ Thread.currentThread().getName());
        try{
            Thread.sleep(10000);
        }catch (Exception e){
            System.out.println("Thread Interrupted : "+ Thread.currentThread().getName());
        }
        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Thread Ended : "+ Thread.currentThread().getName());
    };

    public static void main(String[] args) {

        new Thread(runnable,"Ramesh").start();
        new Thread(runnable,"Suresh").start();
        new Thread(runnable,"Ganesh").start();

        System.out.println("Team Leader Arrives at Gate Waiting for threads to reach checkpoint");



    }
}
