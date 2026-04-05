package mathop;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] numbers= new int[]{1,2,3,4,5,6,7};
        int addition= Arrays.stream(numbers).filter(s->s%2==0).map(s->s*s).sum();
        System.out.print(addition);
    }
}
