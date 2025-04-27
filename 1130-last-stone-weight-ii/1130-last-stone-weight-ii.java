class Solution {
    public int lastStoneWeightII(int[] stones) {
         int totalSum = Arrays.stream(stones).sum();
        int sum = totalSum/2;
        int n = stones.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for(int i=0;i<=n;i++)
            dp[i][0] = true;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(stones[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-stones[i-1]];
                }
            }
        }
        for(int i=sum;i>=0;i--)
            if(dp[n][i])
                return Math.abs(totalSum - 2*i);
        return 0;
    }
}