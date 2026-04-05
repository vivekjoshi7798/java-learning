package multithreading.lock;

import java.time.format.DateTimeFormatter;

/*

https://www.youtube.com/watch?v=0ZRlIR-o9mI

Implement the dining philosophers problem to demonstrate the problem of deadlock and synchronization in Java.
Five philosophers are sitting at a table, and each philosopher thinks and eats. They need two forks to eat.

Requirements:
     - Create five philosopher threads and a shared fork object.
     - Each philosopher must pick up the left and right forks to eat and release them afterward.
     - Handle synchronization of forks to prevent deadlocks.

Use `ReentrantLock` and `Condition` objects for more fine-grained control.

*/
class SharedResourceFork {


}
class Philosophers extends  Thread  {

    DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void eat(){
        try {
            System.out.println("Eating Started by Philosophers " + Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void sleep(){
        try {
            System.out.println("Sleep is Started by Philosophers " + Thread.currentThread().getName());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }



}

public class DiningPhilosophersProblem {
    public static void main(String[] args) {
        System.out.println("Dining Philosophers Problem Example");


        Thread person1= new Thread("P1");
        Thread person2= new Thread("P1");
        Thread person3= new Thread("P1");
        Thread person4= new Thread("P1");
        Thread person5= new Thread("P1");


    }
}
