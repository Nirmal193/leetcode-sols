class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
          int n = mat.length;
        Set<Integer> prev_row = new HashSet<>();
        for(int i=0;i<mat[0].length;i++){
            prev_row.add(mat[0][i]);
        }
        for(int i=1;i<n;i++){
            Set<Integer> current_row = new HashSet<>();
            for(int prevNumber : prev_row) {
                for (int j = 0; j < mat[i].length; j++) {
                    current_row.add(prevNumber + mat[i][j]);
                }
            }
            prev_row = current_row;
        }
        int ans = Integer.MAX_VALUE;
        for(int currentNumber : prev_row){
            ans = Math.min(Math.abs(target - currentNumber),ans);
        }
        return ans;
    }
}