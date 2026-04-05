package rotate_array_1;

import static java.util.Collections.swap;

public class Solution {

    public void rotate(int[] nums, int k) {

        if(k> nums.length){
            k=k%nums.length;
        }

        reverse(nums, 0, nums.length);
        reverse(nums, 0, k);
        reverse(nums,k, nums.length);

        for (int i = 0; i <nums.length ; i++) {
            System.out.print(nums[i]+",");
        }

    }

    private void reverse(int[] nums, int firstIndex, int lastIndex) {


        for (int i = firstIndex; i < (firstIndex+lastIndex)/2; i++) {

            if(firstIndex != 0){
                swap(nums,i,firstIndex+(lastIndex-i)-1);
            }else{
                swap(nums,i,lastIndex-i-1);
            }

        }

    }
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
//        solution.rotate(new int[ ]{1,2,3,4,5,6,7},3);
        solution.rotate(new int[ ]{-1,-100,3,99},2);

    }
}
