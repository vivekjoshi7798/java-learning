package maximum_subarray_1;
/*
How Kadane's Algorithm Works

The core idea is to traverse the array once, keeping track of two main variables: the maximum sum found so far and the maximum sum ending at the current position

Here is a step-by-step breakdown:
1.
Initialize two variables:
max_so_far: Stores the overall maximum subarray sum encountered up to the current point. Initialize it to the first element of the array.
current_max: Stores the maximum sum of a contiguous subarray ending at the current array index. Initialize it to the first element of the array.

2.
Iterate through the array starting from the second element:

For each element arr[i], update current_max by taking the maximum of the current element itself or the current element plus the previous current_max: current_max = max(arr[i], current_max + arr[i]). This choice decides whether to extend the current subarray or start a new one at the current position.
Update max_so_far by comparing it with the current current_max: max_so_far = max(max_so_far, current_max).
Return max_so_far: After iterating through the entire array, max_so_far holds the maximum possible sum of any contiguous subarray.
        Example
Consider the array [-2, 1, -3, 4, -1, 2, 1, -5, 4].

Element 	current_max logic	current_max	max_so_far
-2	        initial	                -2	    -2
1	        max(1, -2 + 1) = 1	    1       1
-3	        max(-3, 1 + -3) = -2    -2	    1
4	        max(4, -2 + 4) = 4	    4       4
-1	        max(-1, 4 + -1) = 3	    3       4
2	        max(2, 3 + 2) = 5	    5       5
1	        max(1, 5 + 1) = 6	    6       6
-5	        max(-5, 6 + -5) = 1	    1       6
4	        max(4, 1 + 4) = 5	    5       6

The maximum subarray sum is 6, which corresponds to the subarray [4, -1, 2, 1].

Complexity

Time Complexity: O(n), as the algorithm makes a single pass through the array.
Space Complexity: O(1), as it only uses a few constant extra variables.
        package maximum_subarray_1;
*/
public class Solution {

    public int maxSubArrayBruteForce(int[] nums) {
        int maxSum=0;
        for (int i = 0; i < nums.length; i++) {
            int sum =nums[i];
            maxSum= Math.max(maxSum,sum);
            for (int j = i+1; j < nums.length; j++) {
                sum = sum + nums[j];
                maxSum= Math.max(maxSum,sum);
            }
        }
        return maxSum;
    }

    public int maxSubArrayOptimal(int[] nums) {

        int max_so_far=Integer.MIN_VALUE;
        int current_max=nums[0];

        max_so_far= Math.max(max_so_far,current_max);
        for (int i = 1; i < nums.length; i++) {
            current_max= Math.max(nums[i],nums[i]+current_max);
            max_so_far= Math.max(max_so_far,current_max);
        }

        return max_so_far;
    }



    public static void main(String[] args) {
        Solution solution =new Solution();
        System.out.println(solution.maxSubArrayBruteForce(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(solution.maxSubArrayBruteForce(new int[]{1}));

        System.out.println(solution.maxSubArrayOptimal(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(solution.maxSubArrayOptimal(new int[]{1}));
        System.out.println(solution.maxSubArrayOptimal(new int[]{-1,-2}));
    }

}
