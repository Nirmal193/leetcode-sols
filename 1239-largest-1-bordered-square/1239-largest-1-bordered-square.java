class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        int ver[][] = new int[m][n];
        int her[][] = new int[m][n];
        int max = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    her[i][j] = (j==0) ? 1 : her[i][j-1] + 1;
                    ver[i][j] =  (i==0) ? 1 : ver[i-1][j] + 1;
                }
            }
        }
        for(int i = m-1;i>=0;i--){
            for(int j = n-1;j>=0;j--){
                int small = Math.min(her[i][j] , ver[i][j]);
                while(small > max){
                    if((ver[i][j - small+1] >= small) && (her[i-small + 1][j] >= small))
                        max = small;
                    small--;
                }
            }
        }
        return max * max;
    }
}