package com.vivek.multithreading.ThreadLocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadLocalWithThreadPool {

    public static void main(String[] args) {
        ThreadLocal<String> name= new ThreadLocal<>();
        ExecutorService service= Executors.newFixedThreadPool(10);

        service.submit(()->name.set("balaji"));

        for (int i = 0; i < 20; i++) {
            service.submit(()-> System.out.println("Thread local value: "+name.get()+" by Thread :"+Thread.currentThread().getName()));
        }


    }
}
