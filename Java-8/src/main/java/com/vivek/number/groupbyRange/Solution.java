package com.vivek.number.groupbyRange;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        
        SortByRange(List.of(2,34,54,23,33,20,59,11,19,37));
        SortByRangeByTradtionalWay(List.of(2,34,54,23,33,20,59,11,19,37));
        
    }

    private static void SortByRangeByTradtionalWay(List<Integer> integers) {
    }


    /*Q12) Given an array of integers (2,34,54,23,33,20,59,11,19,37 ) group the numbers by the range they belong to. The put put should be {0=[2], 50=[54,59], 20=[23,20], 10=[11,19], 30=[34,33,37]}
        Solution is:
        Map<Integer, List<Integer>> map =
        Stream.of(2, 34, 54, 23, 33, 20, 59, 11, 19,37).collect(Collectors.groupingBy (i -> i/10 * 10 ));
        System.out.println(map);*/
    private static void SortByRange(List<Integer> integers) {

      Map<Integer, List<Integer>> k=  integers.stream().sorted().collect(Collectors.groupingBy(i-> i/10*10, LinkedHashMap::new,Collectors.toList()  ));
        System.out.println(k);

    }
    
    
    

}
