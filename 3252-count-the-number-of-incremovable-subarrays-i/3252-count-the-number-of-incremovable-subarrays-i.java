class Solution {
    public int incremovableSubarrayCount(int[] nums) {
            int n = nums.length;
        int ans = 0;
        
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                if (isIncreasing(nums, l, r)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private boolean isIncreasing(int[] nums, int l, int r) {
        int prev = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i >= l && i <= r) continue; 
            if (prev != -1 && nums[prev] >= nums[i]) return false;
            prev = i;
        }
        return true;
    }
}