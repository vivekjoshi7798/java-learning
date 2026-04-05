package stringjoin;

import java.util.Arrays;
import java.util.stream.Collectors;

//3.	Join all elements of a list with a comma using Stream API.
public class Solution {

    public static void main(String[] args) {
        String[] words = {"Hello", "world", "this", "is", "Java", "8"};

        String result = String.join(",", words);
        System.out.println(result);
        String resultStramAPi = Arrays.stream(words).map(s->s).collect(Collectors.joining(","));
        System.out.println(resultStramAPi);
    }
}
