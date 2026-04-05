package com.vivek.stringoperations;


import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharOperation {
    public static void main(String[] args) {
        System.out.println("6 Char frequency: " + charFrequency("banana"));
        System.out.println("6 Char frequency: " + charFrequencyAsc("banana"));
        System.out.println("6 Char frequency: " + charFrequencyDsc("banana"));
    }




    static Map<Character, Long> charFrequency(String str) {
        return str.chars().mapToObj(s->(char) s).collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()));

    }


    static Map<Character, Long> charFrequencyAsc(String str) {
        return str.chars().mapToObj(s->(char) s).collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()));

    }


    static Map<Character, Long> charFrequencyDsc(String str) {
        return str.chars().mapToObj(s->(char) s).collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()));

    }

}
