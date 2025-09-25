class Solution {
    public int maxDistance(int[] position, int m) {
        TreeSet<Integer> tset = new TreeSet<Integer>(Arrays.stream(position).boxed().toList());
        int lo = 0, hi = tset.last() - tset.first();
        int ans = -1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(isPossible(tset,mid,m)){
                ans = mid;
                lo = mid+1;
            }else 
                hi = mid-1;
        }
        System.out.println(lo);
        return ans;
    }
    public boolean isPossible(TreeSet<Integer> treeSet, int target, int m){
        Integer start =  treeSet.first();
        int count = 1;
        while(start <= treeSet.last() && count < m){
            start+=target;
            count++;
            start = treeSet.ceiling(start);
            if(start == null)
                return false;
        }
        return start <= treeSet.last();
    }
}