package com.vivek.number.even;

import java.util.List;
import java.util.stream.IntStream;

public class Solu {
    public static void main(String[] args) {

        List<Integer> evenNumber= IntStream.range(1,50).boxed().filter(s->s%2==0).toList();
        System.out.println(evenNumber);
    }
}
