class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int rightMin = Integer.MAX_VALUE;
        int leftMax = Integer.MIN_VALUE;
        for(int i=0;i<right.length;i++){
            rightMin = Math.min(rightMin,right[i]);
        }
        for(int i=0;i<left.length;i++){
            leftMax = Math.max(leftMax,left[i]);
        }
        int rightAns  = (rightMin <= n) ? n - rightMin : -1;
        int leftAns = (leftMax >= 0) ? leftMax : -1;
        return Math.max(leftAns,rightAns);
    }
}