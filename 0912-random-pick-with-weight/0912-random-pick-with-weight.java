class Solution {
    private int[] prefix;
    private int total;
    public Solution(int[] w) {
        prefix = new int[w.length];
        prefix[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefix[i] = prefix[i - 1] + w[i];
        }
        total = prefix[w.length - 1];
    }

    public int pickIndex() {
       int target = (int)(Math.random() * total); 
        return findIndex(target);
    }
    public int findIndex(double target){
         int lo = 0, hi = prefix.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (prefix[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;   
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */