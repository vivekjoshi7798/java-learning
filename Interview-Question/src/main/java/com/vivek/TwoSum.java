package com.vivek;

//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.You may assume that each input would have exactly one solution, and you may not use the same element twice.You can return the answer in any order.
//
//
//
//        Example 1:Input: nums = [2,7,11,15], target = 9Output: [0,1]Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
//
//Example 2:Input: nums = [3,2,4], target = 6Output: [1,2]
//
//Example 3:Input: nums = [3,3], target = 6"

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

        System.out.println(getSumIndex(new int[] {2, 7, 11, 15}, 9));   // [0, 1]
        System.out.println(getSumIndex(new int[] {3, 2, 4}, 6));        // [1, 2]
        System.out.println(getSumIndex(new int[] {1, 5, 3, 7}, 8));     // [0, 3]
        System.out.println(getSumIndex(new int[] {4, 6, 2, 8}, 10));    // [0, 1] or [2, 3]
        System.out.println(getSumIndex(new int[] {10, 20, 30, 40}, 50));// [0, 3]
        System.out.println(getSumIndex(new int[] {5, 1, 9, 3}, 10));    // [0, 1]
        System.out.println(getSumIndex(new int[] {8, 3, 5, 2}, 10));    // [0, 3]
        System.out.println(getSumIndex(new int[] {6, 4}, 10));          // [0, 1]
        System.out.println(getSumIndex(new int[] {1, 2, 3, 4, 5}, 9));  // [3, 4]
        System.out.println(getSumIndex(new int[] {11, 15, 2, 7}, 9));   // [2, 3]


    }

    private static boolean getSumIndex(int[] nums,int target) {

        HashMap<Integer, Integer> sum = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (sum.containsKey(nums[i])) {
                System.out.println(sum.get(nums[i]) + "," + i);
                break;
            } else {
                int sub = target - nums[i];
                sum.put(sub, i);
            }

        }
        return true;
    }
}
