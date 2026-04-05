package com.vivek.number.prime;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {

        int n = 29; // Example number to check

        Predicate<Integer> isPrimePredicate = (x) -> x > 1 && IntStream.range(2, x).noneMatch(i -> x % i == 0);
        List<Integer> primeNumber = IntStream.range(2, n).filter(isPrimePredicate::test).boxed().toList();

        System.out.println(primeNumber);
        Map<Boolean, List<Integer>> partitionedPrimes = IntStream.range(2,n).boxed().collect(Collectors.partitioningBy(isPrimePredicate));

        System.out.println(partitionedPrimes);



    }

}
