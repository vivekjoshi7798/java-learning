package stringoperations;

import java.util.Comparator;
import java.util.List;

public class ListOfStringsOperation {
    public static void main(String[] args) {
        System.out.println("1 longest string from a list : " + findLongestString(List.of("longest", "string", "from", "a", "list")));
        System.out.println("2 longest string from a list : " + findSecondLongestString(List.of("longest", "string", "from", "a", "list")));

    }

    private static String findLongestString(List<String> longest) {
        return longest.stream().max(Comparator.comparingInt(String::length)).orElse(null);
    }

    private static String findSecondLongestString(List<String> longest) {
        return longest.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(null);
    }

}
