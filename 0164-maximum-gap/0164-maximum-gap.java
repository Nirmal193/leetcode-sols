class Solution {
    public int maximumGap(int[] nums) {
       int len = nums.length;
        if(len <= 1)
            return 0;
        int min = Arrays.stream(nums).min().orElse(-1);
        int max = Arrays.stream(nums).max().orElse(-1);
        int numOfGaps =  len-1;
        Bucket buckets[] = new Bucket[numOfGaps];
        for(int i=0;i<numOfGaps;i++)
            buckets[i] = new Bucket();
        double gapLength = (max-min)/(len-1);
        System.out.println(numOfGaps);
        for(int num: nums){
            if (num == min || num == max) continue;
            int index = (int)((num - min) / gapLength);
            if (index >= numOfGaps) index = numOfGaps - 1;
            buckets[index].update(num);
        }
        int ans = 0;
        int prev = min;
        for(int i=0;i<buckets.length;i++){
            if(buckets[i].isEmpty)
                continue;
            ans = Math.max(ans,buckets[i].min - prev);
            prev = buckets[i].max;
        }
        return Math.max(ans,max-prev);
    }
    private static class Bucket{
        public int max;
        public int min;
        public boolean isEmpty;
        public Bucket(){
            isEmpty = true;
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
        }
        public void update(int num){
            max = Math.max(max,num);
            min = Math.min(min,num);
            isEmpty = false;
        }

    }
}