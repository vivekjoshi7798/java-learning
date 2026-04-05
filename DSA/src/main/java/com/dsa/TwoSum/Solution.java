package com.dsa.TwoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int numberToFind = target-nums[i] ;
            if(numMap.containsKey(numberToFind)) {
                return new int[] {numMap.get(numberToFind), i};
            }
            numMap.put(nums[i], i);

        }

        return new int[]{};
    }

    public static void main(String[] args) {
         Solution solution=new Solution();
         int[] arr=  solution.twoSum(new int[]{2,7,11,15}, 9);

            for (int j : arr) {
                System.out.println(j);
            }

    }
}
