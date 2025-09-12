class Solution {
    public long repairCars(int[] ranks, int cars) {
         Arrays.sort(ranks);
        long lo = 1,hi = Long.MAX_VALUE;
        long ans = 0;
        while(lo <= hi){
            long mid = lo + (hi-lo)/2;
            if(isPossible(ranks,cars,mid)){
                ans = mid;
                hi = mid-1;
            }else{
                lo = mid+1;
            }
        }
        return ans;
    }
    public boolean isPossible(int ranks[],int cars, long target){
        long x = 0;
        for(int rank: ranks){
            x += (int)Math.sqrt(target/rank);
        }
        return x>=cars;
    }

}