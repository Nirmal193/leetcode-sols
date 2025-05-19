class Solution {
    private final int mod = (int)1e9+7;
    public int numRollsToTarget(int n, int k, int target) {
        int dp[] = new int[target+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            int newdp[] = new int[target+1];
            for(int j=1;j<=k;j++){
                for(int t=1;t<=target;t++){
                    if(t-j >= 0)
                        newdp[t] = (newdp[t] + dp[t-j])%mod;
                }
            }
            dp = newdp;
        }
        return dp[target];
    }
}