package rotate_array_1;

public class Solution2 {

    public void rotate(int[] nums, int k) {

        int n=nums.length;
        k=k%n;

        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);

        for (int i = 0; i <nums.length ; i++) {
            System.out.print(nums[i]+",");
        }

    }

    private void reverse(int[] nums, int i, int j) {

        while (i<j){

            int t= nums[i];
            nums[i]=nums[j];
            nums[j]=t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {

        Solution2 solution2= new Solution2();
        solution2.rotate(new int[ ]{1,2,3,4,5,6,7},3);
        solution2.rotate(new int[ ]{-1,-100,3,99},2);

    }
}
