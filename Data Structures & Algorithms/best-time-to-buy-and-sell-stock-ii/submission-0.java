class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        int i = 1;
        int starting = prices[0], tempSum = 0;

        while(i < prices.length) {
            if(starting >= prices[i]){
                starting = prices[i];
                i++;
                continue;
            }
            tempSum = prices[i] - starting;
            i++;

            while(i < prices.length && tempSum <= (prices[i] - starting)) {
                tempSum = prices[i] - starting;
                i++;
            }
            if(i < prices.length){
                starting = prices[i];
                i++;
            }
            sum += tempSum; // 3, 9, 14, 2, 3
        }
        return sum;
    }
}