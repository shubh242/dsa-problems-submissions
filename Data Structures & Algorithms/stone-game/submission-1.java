class Solution {
    public boolean stoneGame(int[] piles) {
        int[] dp = new int[piles.length];
        dp[0] = piles[0];
        dp[1] = piles[1];

        for(int i = 2; i < piles.length; i++) {
            dp[i] = piles[i] + dp[i-2];
        }

        System.out.println("Alice wins with " + (dp[piles.length-1] < dp[piles.length-2] ? "even sum of" + " " + dp[piles.length-2] : "odd sum of" + " " + dp[piles.length-1]) + " piles selection.");

        return true;
    }
}