class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int mod = 1_000_000_007;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {  
            for (int j = 1; j <= target; j++) { 
                for (int f = 1; f <= k; f++) { 
                    if (f <= j) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - f]) % mod;
                    }
                }
            }
        }
        return dp[n][target];
    }
}