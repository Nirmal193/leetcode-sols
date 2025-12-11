class Solution {
    public long maxPoints(int[][] points) {
        int n = points.length;
        int m = points[0].length;

        long[] dp = new long[m];
        for (int j = 0; j < m; j++) {
            dp[j] = points[0][j];
        }

        for (int i = 1; i < n; i++) {
            long[] currentRow = new long[m];
            long[] leftMax = new long[m];
            leftMax[0] = dp[0];
            for (int j = 1; j < m; j++) {
                leftMax[j] = Math.max(leftMax[j - 1], dp[j] + j);
            }
            long[] rightMax = new long[m];
            rightMax[m - 1] = dp[m - 1] - (m - 1);
            for (int j = m - 2; j >= 0; j--) {
                rightMax[j] = Math.max(rightMax[j + 1], dp[j] - j);
            }
            for (int j = 0; j < m; j++) {
                long bestLeft = leftMax[j] - j;
                long bestRight = rightMax[j] + j;
                currentRow[j] = points[i][j] + Math.max(bestLeft, bestRight);
            }

            dp = currentRow;
        }
        long max = dp[0];
        for (long val : dp) {
            max = Math.max(max, val);
        }
        return max;
    }
}       