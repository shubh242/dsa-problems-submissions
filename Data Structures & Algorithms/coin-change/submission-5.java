class Solution {
    public int coinChange(int[] coins, int amount) {
        // Filling the dp with max and using the recurrence relation
        // for every coins  check the min of dp[i-coins[i]]+1 and store the min
        // value.
        
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= amount; i++){
            int val = Integer.MAX_VALUE;
            for(int c = 0; c < coins.length; c++){
                if(coins[c] <= i && dp[i-coins[c]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-coins[c]]+1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
