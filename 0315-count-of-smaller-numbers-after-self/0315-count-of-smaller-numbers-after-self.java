class Solution {
    public List<Integer> countSmaller(int[] nums) {
         TreeSet<Integer> set = new TreeSet<>();
        for(Integer num : nums){
            set.add(num);
        }
        Map<Integer,Integer> rank = new HashMap<>();
        int idx = 1;
        for (int val : set) rank.put(val, idx++);
        int len = nums.length;
        List<Integer> ans = new ArrayList<>();
        Tree tr = new Tree(len);
        for(int i=len-1;i>=0;i--){
            ans.add(tr.query(rank.get(nums[i])-1));
            tr.update(rank.get(nums[i]),1);
        }
        Collections.reverse(ans);
        return ans;
    }
}
class Tree{
     int bit[];
    int n;
    public Tree(int n){
        this.n = n;
        bit = new int[n+1];
    }
    public void update(int i, int delta){
        while(i <= n){
            bit[i]++;
            i += (i & -i);
        }
    }
    public int query(int i){
        int ans = 0;
        while(i > 0){
            ans += bit[i];
            i -= (i & -i);
        }
        return ans;
    }
}