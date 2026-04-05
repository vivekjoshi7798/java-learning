package stringoperations.charOps;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstRepeatingChar {
    public static void main(String[] args) {
        System.out.println("First repeating char: " + findFirstRepeatingCharUsingStream("banana"));
        System.out.println("First repeating char: " + findFirstRepeatingCharUsingStream("developer"));
        System.out.println("First repeating char: " + findFirstRepeatingCharUsingStream("GeeksForGeeks"));
         System.out.println("First repeating char: " + findFirstRepeatingChar("banana"));
        System.out.println("First repeating char: " + findFirstRepeatingChar("developer"));
        System.out.println("First repeating char: " + findFirstRepeatingChar("GeeksForGeeks"));
    }

    private static String findFirstRepeatingCharUsingStream(String banana) {
      return   banana.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(
                Function.identity(), LinkedHashMap::new,Collectors.counting()))
                .entrySet()
                .stream()
                .filter(s-> s.getValue() > 1)
//                .forEach(s-> System.out.println(s.getKey() + " : " + s.getValue()));
                .findFirst().map(s->s.getKey().toString()).orElse(null);
//    return  "";
    }

    private static String findFirstRepeatingChar(String banana) {
        int count[] = new int[256];

        for(char c : banana.toCharArray()){
                count[c]++;
        }

            for(char c : banana.toCharArray()){
                if(count[c] > 1){
                    return String.valueOf(c);
                }
            }

        return "";
    }
}
