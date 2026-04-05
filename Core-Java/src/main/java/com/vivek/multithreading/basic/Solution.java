package com.vivek.multithreading.basic;

class OwnThread extends Thread{
    @Override
    public void run() {
        System.out.println("Thread is running : "+Thread.currentThread().getName());
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println("Thread is running : "+Thread.currentThread().getName());

    }
}
public class Solution {
    public static void main(String[] args) {
       MyThread myThread = new MyThread();
       Thread thread = new Thread(myThread);
        System.out.println("Main method started "+ Thread.currentThread().getName());
       thread.run(); // it will run in main MyThread class as normal method
        thread.start(); // it will run in separate call stack
        // only start() method creates new (thread/call stack)
        // so output will be different for both

        System.out.println("---------------------");

        // Using Thread class by extending it
        OwnThread ownThread = new OwnThread();
        ownThread.start(); // it will run in separate call stack

        System.out.println("Main method ended " + Thread.currentThread().getName());

        // start internally calls run method of the class which extends Thread class


    }
}
