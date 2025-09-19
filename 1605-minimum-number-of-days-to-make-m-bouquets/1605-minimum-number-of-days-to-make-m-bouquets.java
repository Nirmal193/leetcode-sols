class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
         int lo = 0, hi = Arrays.stream(bloomDay).max().getAsInt()+1;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(isPossible(bloomDay,m,k,mid))
                hi = mid;
            else
                lo = mid+1;
        }
        if(isPossible(bloomDay,m,k,lo))
            return lo;
        return -1;
    }
      public boolean isPossible(int bloomDay[],int m, int k, int days){
        int len = bloomDay.length;
        int count = 0,start  = 0;
        for(int i=0;i<len;i++){
            if(bloomDay[i] <= days)
                start++;
            else
                start = 0;
            if(start == k){
                count++;
                start = 0;
            }
        }
        return count >= m;
    }
}