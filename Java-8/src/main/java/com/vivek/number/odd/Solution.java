package number.odd;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/*
*
* need to findout the vowel indexes for give string
input - vivekjoshi
*
* 1369
* */
public class Solution {

    public static void main(String[] args) {
        List<Integer> OddNumber= IntStream.range(1,50).boxed().filter(s->s%2!=0).toList();
        System.out.println(OddNumber);

    }
}
