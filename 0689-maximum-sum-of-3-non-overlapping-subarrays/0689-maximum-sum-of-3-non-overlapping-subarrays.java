class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
          if(k*3 > nums.length)
            return new int[3];
        int len = nums.length;
        List<Integer> subSum = new ArrayList<>();
        int start = 0,sum = 0;
        for(int i=0;i<len;i++){
            sum += nums[i];
            if (i - start + 1 == k) {
                subSum.add(sum);
                sum -= nums[start++];
            }
        }
        int len2 = subSum.size();
        int left[] = new int[len2];
        int right[] = new int[len2];
        int bestLeftIdx = 0,bestRightIdx = len2-1;
        for(int i=0;i<len2;i++){
            if (subSum.get(i) > subSum.get(bestLeftIdx)) {
                bestLeftIdx = i;
            }
            int j = len2 - 1 - i;
            if (subSum.get(j) >= subSum.get(bestRightIdx)) {
                bestRightIdx = j;
            }
            right[j] = bestRightIdx;
            left[i] = bestLeftIdx;
        }
        int res = Integer.MIN_VALUE;
        List<int[]> ansList = new ArrayList<>();
        for(int i=k;i<subSum.size()-k;i++){
            int l = left[i - k], m = i, r = right[i + k];
            int temp = subSum.get(l) + subSum.get(m) + subSum.get(r);

            if (temp > res) {
                res = temp;
                ansList.clear();
                ansList.add(new int[] {l, m, r});
            } else if (temp == res) {
                ansList.add(new int[] {l, m, r});
            }
        }
        return ansList.get(0);
    }
}