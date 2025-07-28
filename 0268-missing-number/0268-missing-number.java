class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        return findNumber(nums);
    }
    public int findNumber(int nums[]){
        int start = 0;
        int ans = nums.length;
        int end = nums[nums.length-1];
        while(start < end){
            int mid = start + (end-start)/2;
            if(nums[mid] == mid)
                start = mid+1;
            else{
                ans = mid;
                end = mid;
            }
        }
        return ans;
    }
}