class Solution {
    public int hIndex(int[] citations) {
        int ans = -1, len = citations.length;
        int lo = 0, hi = len-1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            int rem = len - mid;
            if(citations[mid] >= rem){
                ans = mid;
                hi = mid-1;
            }else
                lo = mid+1;
        }
        if(ans == -1)
            return citations[0];
        return len-ans;
    }
}