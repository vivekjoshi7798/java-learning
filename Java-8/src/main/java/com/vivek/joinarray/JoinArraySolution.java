package joinarray;

import java.util.Arrays;
import java.util.stream.IntStream;

public class JoinArraySolution {
    public static void main(String[] args) {

        int arr1[]= new int[]{1,2,3,4,5,6};
        int arr2[]= new int[]{7,8,9,10};

        int[] result = IntStream.concat(Arrays.stream(arr1),Arrays.stream(arr2)).toArray();

        for (int i = 0; i < result.length; i++) {
            System.out.print(i);
        }
    }
}
