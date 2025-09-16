class Solution {
    public int findLatestStep(int[] arr, int m) {
         int n = arr.length;
        int[] string = new int[n + 2];
        //simulation + dp
        int count = 0;
        int step = -1;
        for (int i = 0; i < n; ++i) {
            int index = arr[i];
            int left = string[index - 1];
            int right = string[index + 1];
            int total = 1 + left + right;
            if (left == m) {
                --count;
            }
            if (right == m) {
                --count;
            }
            if (total == m) {
                ++count;
            }
            if (count > 0) {
                step = i + 1;
            }
            
            //update up to 3 points
            string[index] = total;
            string[index - left] = total;
            string[index + right] = total;
        }
        return step;
    }
}