class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int max = Integer.MAX_VALUE;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        long low = 0,high = max;
        while(low < high){
            long mid = low + (high -low)/2;
            if(check(houses,heaters,mid)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return (int)low;
    }
     public boolean check(int houses[], int heaters[], long radius){
        int ch = 0;
        for(Integer heater : heaters){
            while( ch  < houses.length  && Math.abs(houses[ch] - heater) <= radius){
                ch++;
            }
        }
        return ch == houses.length;
    }
}