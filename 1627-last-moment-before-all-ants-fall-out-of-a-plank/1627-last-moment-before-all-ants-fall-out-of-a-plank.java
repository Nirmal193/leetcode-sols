class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int rightMin = Arrays.stream(right).min().orElse(Integer.MAX_VALUE);
        int leftMax = Arrays.stream(left).max().orElse(Integer.MIN_VALUE);
        int rightAns  = (rightMin <= n) ? n - rightMin : -1;
        int leftAns = (leftMax >= 0) ? leftMax : -1;
        return Math.max(leftAns,rightAns);
    }
}