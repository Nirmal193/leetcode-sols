class Solution {
    public  int numFriendRequests(int[] ages) {
       int[] count = new int[121]; 
        for (int age : ages) count[age]++;
        
        int total = 0;
        for (int ageA = 15; ageA <= 120; ageA++) {
            for (int ageB = 15; ageB <= ageA; ageB++) {
                if (ageB <= 0.5 * ageA + 7) continue;
                if (ageA == ageB) {
                    total += count[ageA] * (count[ageA] - 1);
                } else {
                    total += count[ageA] * count[ageB];
                }
            }
        }
        return total;
    }
    public  int lowerBound(int nums[], int target,int index){
        int lo = 0;
        int high = index;
        while(lo<high){
            int mid = lo + (high-lo)/2;
            if (nums[mid] > target) {
                high = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}