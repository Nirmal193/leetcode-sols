class Solution {
    public int singleNonDuplicate(int[] nums) {
        int hi = nums.length-1;
        if(hi == 1)
            return nums[0];
        int low = 0;
        while (low < hi){
            int mid = low + (hi-low)/2;
            if(nums[mid] == nums[mid^1]){
                low = mid+1;
            }else{
                hi = mid;
            }
        }
        return nums[low];
    }
}