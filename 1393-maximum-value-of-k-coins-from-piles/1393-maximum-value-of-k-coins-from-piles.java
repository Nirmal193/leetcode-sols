class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        List<List<Integer>> prefix = new ArrayList<>();
        int size = 0;
        int len = piles.size();
        for(int i=0;i<len;i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            size = Math.max(size,piles.get(i).size());
            for(int j=0;j<piles.get(i).size();j++){
                temp.add(temp.getLast() + piles.get(i).get(j));
            }
            prefix.add(temp);
        }
        int dp[][] = new int[len+1][k+1];
        for(int i=1;i<=len;i++){
            List<Integer> currPrefix = prefix.get(i - 1);
            int pileSize = currPrefix.size() - 1;
            for (int j = 0; j <= k; j++) {
                for(int x = 0;x<=Math.min(pileSize,j);x++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-x] + currPrefix.get(x));
                }
            }
        }
        return dp[len][k];
    }
}