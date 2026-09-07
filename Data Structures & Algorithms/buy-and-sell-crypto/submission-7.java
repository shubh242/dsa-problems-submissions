class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int startPrice = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++) {
            if(startPrice > prices[i]) {
                startPrice = prices[i];
            } 
            profit = Math.max(profit, prices[i] - startPrice);
        }
        return profit;
    }
}
