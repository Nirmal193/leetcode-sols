class Solution {
    public int minCost(int[] nums, int k) {
        int len = nums.length;
        int dp[] = new int[len+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=len;i++){
            Map<Integer,Integer> freq = new HashMap<>();
            int duplicateCost = 0;
            for(int j=i-1;j>=0;j--){
                freq.put(nums[j],freq.getOrDefault(nums[j],0)+1);
                if(freq.get(nums[j]) == 2) duplicateCost += 2;
                else if(freq.get(nums[j]) > 2) duplicateCost += 1;
                dp[i] = Math.min(dp[i],dp[j] + k + duplicateCost); 
            }
        }
        return dp[len];
    }
}