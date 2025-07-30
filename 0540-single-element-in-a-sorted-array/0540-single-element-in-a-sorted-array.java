class Solution {
    public int singleNonDuplicate(int[] nums) {
        int hi = nums.length;
        if(hi == 1)
            return nums[0];
        int low = 0;
        while (low < hi){
            int mid = low + (hi-low)/2;
            int nextMid = mid%2==0 ? mid+1 : mid-1;
            if(nextMid == nums.length)
                return nums[mid];
            if(nums[mid]==nums[nextMid]){
                low = mid+1;
            }else{
                hi = mid;
            }
        }
        return nums[low];
    }
}