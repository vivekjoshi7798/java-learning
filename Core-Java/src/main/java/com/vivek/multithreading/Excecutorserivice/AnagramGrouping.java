package multithreading.Excecutorserivice;

import java.util.*;

public class AnagramGrouping {

    @SuppressWarnings("unchecked")
    public static <T, U> List<List<T>> groupAnagrams(U arr) {
        // Typecast U to List<T>, assuming U is passed as a List<T> (an array of strings).
        List<T> strings = (List<T>) arr;

        // Use a HashMap to group anagrams, with the key being the sorted string and value being a list of T.
        Map<String, List<T>> map = new HashMap<>();

        // Iterate through each element in the list.
        for (T t : strings) {
            String s = t.toString(); // Convert T to String for processing.

            // Sort the string to create a unique key for anagrams.
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Add to the hashmap under the appropriate key.
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(t);
        }

        // Collect all grouped anagrams from the map and return them.
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        // Example usage of the method.
        List<String> input = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        List<List<String>> groupedAnagrams = groupAnagrams(input);

        // Print the grouped anagrams.
        System.out.println(groupedAnagrams);
    }
}