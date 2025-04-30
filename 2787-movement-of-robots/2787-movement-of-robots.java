class Solution {
    final int MOD = 1_000_000_007;
    public int sumDistance(int[] nums, String s, int d) {
        int len = nums.length;
        long prefix[] = new long[len]; 
        for(int i=0;i<len;i++){
            long move = (s.charAt(i) == 'R') ? d : -d;
            prefix[i] = ((nums[i] + move));
        }
        Arrays.sort(prefix);
        long ans = 0;
        long sum = prefix[0];
        for(int i=1;i<len;i++){
            ans = (ans + ((prefix[i] * i ) - sum ));
            ans %= MOD;
            sum = (sum + prefix[i]);
        }
        System.out.println(ans);
        return (int)ans;

    }
}