class Solution {
    public int missingNumber(int[] nums) {
        int len = nums.length;
        int target = 0;
        int cal = 0;
        for(int i=0;i<=len;i++){
            target ^= i;
        }
        for(int num : nums){
            cal ^= num;
        }
        return cal ^ target;
    }
    
}