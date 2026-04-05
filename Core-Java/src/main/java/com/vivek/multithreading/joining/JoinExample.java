package com.vivek.multithreading.joining;


class TaskManager{

    public void performTask(){
        System.out.println("Child thread started");

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {

        }
        System.out.println("Child thread stopped");

    }
}
public class JoinExample {
    public static void main(String[] args) {

        System.out.println("Main thread started");
        Thread th1= new Thread(()-> {
           new TaskManager().performTask();
        });

       th1.start();

       System.out.println("Main thread Stoped");


    }
}
