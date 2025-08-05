class Solution {
    public int reachNumber(int target) {
        if(target < 0)
             target = 0-target;
        long sum  = 0;
        int ans = 1;
        while(sum < target){
            sum += ans;
            ans++;
        }
        if(target == sum)
            return ans-1;
        while(Math.abs(sum - target) % 2 != 0){
            sum += ans;
            ans++;
        }
        return ans-1;
    }
}