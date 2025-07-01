class Solution {
    public int kInversePairs(int n, int k) {
        final int mod = (int)1e9+7;
        int maxRange = (n*(n-1))/2;
        if(k==maxRange || k==0)
            return 1;
        if(k>maxRange)
            return 0;
        int dp[][] = new int[n+1][k+1];
        for(int i=1;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                for(int x=0;x<=Math.min(j,i-1);x++){
                    dp[i][j] = (dp[i][j] + dp[i-1][j-x])%mod;
                }
            }
        }
        return dp[n][k];
    }
}