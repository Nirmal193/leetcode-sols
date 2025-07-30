class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int len = nums.length;
        for(int k=len-1;k>=2;k--){
            int i =0 , j = k-1;
            while(i<j){
                if(nums[i] + nums[j] > nums[k]){
                    ans += (j-i);
                    j--;
                }else{
                    i++;
                }
            }
        }
        return ans;
    }
}