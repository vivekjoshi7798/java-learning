package flatmap;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {

        List<List<Integer>> listInteger = Arrays.asList(
                List.of(1,2),
                List.of(3,9),
                List.of(4,6),
                List.of(5,8),
                List.of(6,7)
        );

        // 1. Flatten List
        List<Integer> integers = listInteger.stream()
                .flatMap(Collection::stream)
                .toList();
        System.out.println("Flattened List: " + integers);

        System.out.println("--------------------------------------------------");

        // 2. Sum of all elements
        int sumOfAll = listInteger.stream()
                .flatMap(List::stream)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum of all elements: " + sumOfAll);

        System.out.println("--------------------------------------------------");

        // 3. Even Numbers
        List<Integer> evenNumbers = listInteger.stream()
                .flatMap(List::stream)
                .filter(n -> n % 2 == 0)
                .toList();
        System.out.println("Even Numbers: " + evenNumbers);

        System.out.println("--------------------------------------------------");

        // 4. Count Total Elements
        long count = listInteger.stream()
                .flatMap(List::stream)
                .count();
        System.out.println("Total Count: " + count);

        System.out.println("--------------------------------------------------");

        // 5. Maximum Number
        int max = listInteger.stream()
                .flatMap(List::stream)
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
        System.out.println("Maximum Number: " + max);

        System.out.println("--------------------------------------------------");

        // 6. Unique Numbers
        List<Integer> uniqueNumbers = listInteger.stream()
                .flatMap(List::stream)
                .distinct()
                .toList();
        System.out.println("Unique Numbers: " + uniqueNumbers);

        System.out.println("--------------------------------------------------");

        // 7. Sorted Ascending
        List<Integer> sortedNumber = listInteger.stream()
                .flatMap(List::stream)
                .sorted()
                .toList();
        System.out.println("Sorted Ascending: " + sortedNumber);

        System.out.println("--------------------------------------------------");

        // 8. Multiply by 2
        List<Integer> multiplicationResult = listInteger.stream()
                .flatMap(List::stream)
                .map(n -> n * 2)
                .toList();
        System.out.println("After Multiplying by 2: " + multiplicationResult);

        System.out.println("--------------------------------------------------");

        // 9. Numbers greater than 3
        List<Integer> numberGThree = listInteger.stream()
                .flatMap(List::stream)
                .filter(n -> n > 3)
                .toList();
        System.out.println("Numbers > 3: " + numberGThree);

        System.out.println("--------------------------------------------------");

        // 10. Convert to Set
        Set<Integer> setCollection = listInteger.stream()
                .flatMap(List::stream)
                .collect(Collectors.toSet());
        System.out.println("Set Collection: " + setCollection);

        System.out.println("--------------------------------------------------");

        // 11. Second Highest (with distinct)
        Integer secondHighestNumber = listInteger.stream()
                .flatMap(List::stream)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(0);
        System.out.println("Second Highest Number: " + secondHighestNumber);
    }
}