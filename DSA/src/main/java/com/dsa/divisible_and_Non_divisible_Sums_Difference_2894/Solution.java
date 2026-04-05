package divisible_and_Non_divisible_Sums_Difference_2894;

public class Solution {
    public static void main(String[] args) {
        System.out.println(differenceOfSums(10, 3));
    }

    private static int differenceOfSums(int n, int m) {
        int total= (n*(n+1))/2;
        if(m>n){
            return total;
        }
        else{
            int sum=m,i=2;

            while ((m*i) <= n){
                sum=sum+(m*i);
                i++;
            }
            total=total-(sum*2);
        }
    return total;
    }
}
