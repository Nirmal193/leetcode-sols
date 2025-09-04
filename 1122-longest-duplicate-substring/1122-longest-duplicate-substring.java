class Solution {
    public static final long mod = 1_000_000_007L;
    public String longestDupSubstring(String s) {
        int lo = 1, hi = s.length(),index = -1,ans = -1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
             int temp = isPossible(s,mid);
            if(temp != -1) {
                ans = mid;
                index = temp;
                lo = mid+1;}
            else hi = mid-1;
        }
        if(ans == -1)
            return "";
        return s.substring(index,index + ans);
    }
     public  int isPossible(String text,int k){
        if (k <= 0 || k > text.length()) return -1;

        int n = text.length();
        long th = 0,pow = 1,base = 256;
        Map<Long,Integer> index = new HashMap<>();
        for(int i=0;i<k-1;i++){
            pow = (pow * base)%mod;
        }
        for(int i=0;i<k;i++){
            th = ((th * base)%mod + text.charAt(i))%mod;
        }
        index.put(th,0);
        for(int i=k;i<n;i++){
            if(i<n) {
                th = ((((th - (pow * text.charAt(i - k)) % mod) * base)%mod + mod) % mod + text.charAt(i)) % mod;
            }
            if(index.containsKey(th) && text.regionMatches(i-k+1,text.substring(index.get(th),index.get(th) + k),0,k))
                    return i - k + 1;
            index.put(th,i-k+1);
        }
        return -1;
    }
}