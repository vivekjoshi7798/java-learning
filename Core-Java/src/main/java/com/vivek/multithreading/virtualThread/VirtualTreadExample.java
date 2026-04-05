package com.vivek.multithreading.virtualThread;
/*
*Goal: Understand how a virtual thread is created and scheduled.

Requirements:
Create 100,000 virtual threads
Each thread should:
    Print its thread name
    Sleep for 1 second

Ensure the program completes cleanly

Hints:

Use Thread.ofVirtual().start(...)

Compare thread names with platform threads
*
* */
public class VirtualTreadExample {
    public static void main(String[] args) {

        Thread vt =Thread.ofVirtual().start(()->{
            Thread.currentThread().setName("Raju");

            System.out.println(" by Thread :"+ Thread.currentThread().getName()+" "+Thread.currentThread().isVirtual());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } );

        try {
            vt.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println("Main thread exiting");

    }
}


/*
* What’s Actually Happening
1️⃣ Thread.ofVirtual()
Creates a virtual thread builder

2️⃣ .start(...)
Creates and starts the virtual thread immediately
No need to call run() yourself (that would run on main thread ❌)

3️⃣ Thread.sleep(2000)

Virtual thread is unmounted from its carrier thread
Carrier thread is free to run other virtual threads
After 2 seconds, scheduler remounts it
*
* */