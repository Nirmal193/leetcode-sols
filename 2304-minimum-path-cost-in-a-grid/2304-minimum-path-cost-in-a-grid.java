class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
         int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for(int i=0;i<m;i++){
            dp[0][i] = grid[0][i];
        }
        for(int i=1;i<n;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
            for(int j=0;j<m;j++){
                for(int k =0;k<m;k++){
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][k] + moveCost[grid[i-1][k]][j] + grid[i][j]);
                }
            }
        }
        int ans  = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            ans = Math.min(dp[n-1][i],ans);
        }
        return ans;
    }
}