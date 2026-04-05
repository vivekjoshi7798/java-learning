package TopKFrequentWords;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SolutionByStream {

    public static void main(String[] args) {
        System.out.println(topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2));
        System.out.println(topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4));
    }

    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Long> listOfWords = Arrays.stream(words).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return listOfWords.entrySet().stream()
                .sorted(Comparator
                        .<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue).reversed()
                        .thenComparing(Map.Entry::getKey))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
