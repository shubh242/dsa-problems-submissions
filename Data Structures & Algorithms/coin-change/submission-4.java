class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
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
