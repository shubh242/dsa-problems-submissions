class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        ways(n, dp);
        return dp[n];
    }

    public int ways(int n, int[] dp){
        if(n < 0){
            return 0;
        }else if(n == 0){
            return 1;
        }

        if(dp[n] != -1)
            return dp[n];
        dp[n] = ways(n-1, dp) + ways(n-2, dp);
        // dp[n] = ways(n-2, dp);
        System.out.println(Arrays.toString(dp));

        return dp[n];
    }
}
