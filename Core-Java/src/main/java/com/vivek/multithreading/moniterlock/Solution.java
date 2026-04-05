package multithreading.moniterlock;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class SharedTask {

    List<Integer> number = new ArrayList<>();

    public synchronized void insertOddNumber() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }
        System.out.println("Thread Name For insertOddNumber : " + Thread.currentThread().getName());
        for (int i = 0; i < 20; i++) {
            if (i % 2 != 0) {
                number.add(i);
            }
        }


    }

    public void insertEvenNumber() {

        System.out.println("Thread Name For insertEvenNumber : " + Thread.currentThread().getName());
        synchronized (this){
            for (int i = 0; i < 20; i++) {
                if (i % 2 == 0) {
                    number.add(i);
                }
            }

        }

    }

    public synchronized void printNumber() {
        number.forEach(System.out::println);
    }

}

public class Solution {


    public static void main(String[] args) {

        SharedTask sharedTask= new SharedTask();
        Thread t1= new Thread(sharedTask::insertEvenNumber);
        Thread t2=new Thread(sharedTask::insertOddNumber);
        Thread t3=new Thread(sharedTask::printNumber);

        t1.start();
        t2.start();
        t3.start();

    }
}
