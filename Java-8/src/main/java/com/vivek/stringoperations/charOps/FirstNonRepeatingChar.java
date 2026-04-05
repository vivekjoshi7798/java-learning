package com.vivek.stringoperations.charOps;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        System.out.println("First non-repeating char: " + firstNonRepeatingChar("aabbcddex"));
        System.out.println("First non-repeating char Traditional Way : " + firstNonRepeatingChar("developer"));
        System.out.println("First non-repeating char Traditional Way : " + firstNonRepeating("GeeksForGeeks"));

    }

    static String firstNonRepeatingChar(String str) {


        return Arrays.stream(str.split("")).collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting())
                ).entrySet()
                .stream()
                .filter(s -> s.getValue() == 1)
                .findFirst().map(Map.Entry::getKey).orElse(null);


    }

    static Character firstNonRepeatingCharTradional(String str) {
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 1) + 1);
        }

        for (int i = 0; i < charCountMap.size(); i++) {
            if (charCountMap.get(str.charAt(i)) == 1) {
                return str.charAt(i);
            }
        }

        return 1;
    }


    public static Character firstNonRepeating(String str) {
        int[] count = new int[256];

       for(char c : str.toCharArray()){
           count[c]++;
       }

       for(char c : str.toCharArray()){
           if(count[c] == 1){
               return c;
           }
       }
       return ' ';
    }

}

