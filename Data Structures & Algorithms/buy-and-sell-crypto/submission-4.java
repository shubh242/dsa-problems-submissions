class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1)
            return 0;
        int profit = Integer.MIN_VALUE;
        int i = 0, j = 1;

        while(j < prices.length){
            if(prices[i] < prices[j]){
                profit = Math.max(profit, (prices[j] - prices[i]));
                j++;
            }else{
                i = j;
                j += 1;
            }
        }
        return profit < 0 ? 0 : profit;
    }
}
