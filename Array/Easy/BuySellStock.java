package Array.Easy;

// leetcode.121. Best Time to Buy and Sell Stock = https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

public class BuySellStock {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int maxProfit = 0;
        int bestBuy = prices[0];
        
        for(int i=1; i<n; i++){
            if(prices[i]>bestBuy){
                maxProfit = Math.max(maxProfit, prices[i]-bestBuy);
            }
            bestBuy = Math.min(bestBuy, prices[i]);
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
}
