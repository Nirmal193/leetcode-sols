class Solution {
    public int findLatestStep(int[] arr, int m) {
       int n = arr.length;
        if(m == n)
            return n;
        
        TreeSet<Integer> walls = new TreeSet<Integer>();
        walls.add(0);
        walls.add(n+1);
        
        for(int i=n-1;i>=0;i--){
            int left = walls.floor(arr[i]);
            int right = walls.ceiling(arr[i]);
            if(arr[i]-left-1 == m || right-arr[i]-1 == m)
                return i;
            walls.add(arr[i]);
        }
        
        return -1;
    }
}