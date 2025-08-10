class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int prefix[] = new int[len];
        for(int i=0;i<len;i++){
            prefix[i] =(Math.abs(s.charAt(i) - t.charAt(i)));
        }
        int ans  = solve(prefix,maxCost);
        return ans;
    }
    public int solve(int nums[],int target){
        int left = 0,right = 0;
        int sum = 0,ans = 0;
        while(right <  nums.length && left <= right){
            sum += nums[right];
            while(sum > target){
                sum -= nums[left++];
            }
            ans = Math.max(ans,right-left+1);
            right++;
        }
        return ans;
    }
}