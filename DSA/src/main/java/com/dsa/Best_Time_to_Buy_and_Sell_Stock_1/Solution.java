package Best_Time_to_Buy_and_Sell_Stock_1;

public class Solution {

    public int maxProfit(int[] prices) {
        int lowerPrice = prices[0];
        int maxProfit=0;

        for(int i=1;i<prices.length;i++ ){
            int profit= prices[i] - lowerPrice;
            if(profit>maxProfit){
                maxProfit=profit;
            }
            if(prices[i]<lowerPrice){
                lowerPrice=prices[i];
            }
        }

    return maxProfit;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
