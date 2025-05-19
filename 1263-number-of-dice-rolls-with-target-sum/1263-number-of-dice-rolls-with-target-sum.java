class Solution {
    private final int mod = (int)1e9+7;
    public int numRollsToTarget(int n, int k, int target) {
        int dp[][] = new int[n+1][target+1];
        dp[0][0] = 1;

        for(int j=1;j<=n;j++){
             for(int i=1;i<=k;i++){
                for(int t=1;t <= target;t++){
                    if(t-i >=0) {
                        dp[j][t] = (dp[j][t] +  dp[j - 1][t - i])%mod;
                    }
                }
            }
        }
        return dp[n][target]; 
    }
}