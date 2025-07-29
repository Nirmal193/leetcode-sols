class Solution {
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        Stack<Integer> stk =  new Stack<>();
        int second = Integer.MIN_VALUE;
        for(int i=len-1;i>=0;i--){
            if(nums[i] < second)
                return true;
            while(!stk.isEmpty() && stk.peek() <  nums[i]){
                second = stk.pop();
            }
            stk.push(nums[i]);
        }
        return false;
    }
}