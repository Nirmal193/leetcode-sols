class Solution {
    public int kthSmallest(int[][] matrix, int k) {
       int low = matrix[0][0];
        int high = matrix[matrix.length-1][matrix[0].length-1];
        int n = matrix.length;
        while(low<high){
            int mid = low + (high-low)/2;
            if(kSmallCheck(matrix,mid,k,n)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
    public boolean kSmallCheck(int matrix[][], int mid, int k,int n){
        int row = n-1;
        int col = 0;
        int count = 0;
        while(row >=0 && col < n){
            if(matrix[row][col] <= mid){
                col++;
                count += row+1;
            }else
                row--;
        }
        return count >= k;
    }
}