class Solution {
    static final int MOD = 1_000_000_007;
    public int numSubseq(int[] nums, int target) {
         int n = nums.length;
         Arrays.sort(nums);
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % MOD;
        }

        int res = 0;
        int lo = 0, hi = n - 1;

        while (lo <= hi) {
            if (nums[lo] + nums[hi] <= target) {
                res = (res + pow2[hi - lo]) % MOD;
                lo++;
            } else {
                hi--;
            }
        }

        return res;
    }
}