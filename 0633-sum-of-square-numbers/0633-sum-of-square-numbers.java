class Solution {
    public boolean judgeSquareSum(int c) {
        if(c==1)
            return true;
        int lo = 0, hi = (int) Math.sqrt(c);
        while(lo <= hi){
            long sum = (long) (lo * lo) + (long)(hi * hi);
            if(sum > c){
                hi--;
            }else if(sum  < c){
                lo++;
            }else{
                return true;
            }
        }
        return false;
    }
}