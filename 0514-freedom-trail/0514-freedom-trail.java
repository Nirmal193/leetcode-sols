class Solution {
    public int findRotateSteps(String ring, String key) {
        // int n = key.length();
        // int ans  = 0;
        // int len = ring.length();
        // StringBuilder sb = new StringBuilder(ring);
        // int index = 0;
        // for(int i=0;i<n;i++){
        //     int ck = findSteps(sb,index,key.charAt(i),true);
        //     int ack = findSteps(sb,index,key.charAt(i),false);
        //     System.out.println(ck + " " + ack);
        //     if(ck < ack){
        //         index = (len + index - ck) % len;
        //         ans += ck;
        //     }
        //     else{
        //         index = (index + ack) % len;
        //         ans += ack;
        //     }
        //     System.out.println(index);
        //     ans++;
        // }
        // return ans;
        int memo[][] = new int[ring.length()][key.length()];
        for(int i=0;i<ring.length();i++){
            Arrays.fill(memo[i],-1);
        }
        return solve(new StringBuilder(ring),key,0,0,memo);
    }
    public int solve(StringBuilder ring,String key, int index,int sbIndex,int[][] memo){
        if(index == key.length())
            return 0;
        if(memo[sbIndex][index] != -1)
            return memo[sbIndex][index];
        int len = ring.length();
        int ck = findSteps(ring,sbIndex,key.charAt(index),true);
        int ack = findSteps(ring,sbIndex,key.charAt(index),false);
        int x = ck + solve(ring,key,index + 1,(len + sbIndex - ck)%len,memo);
        int y = ack + solve(ring,key,index + 1, (sbIndex+ack)%len,memo);
        int ans  =  Math.min(x,y)+1;
        memo[sbIndex][index] = ans;
        return ans;
    }
    public int findSteps(StringBuilder sb,int ind,char target,boolean isClockWise){
        int len = sb.length();
        int ans = 0;
        while((sb.charAt(ind) != target) && ans < len){
            ans++;
            ind = isClockWise ? (ind-1+len)%len : (ind + 1)%len; 
        }
        return ans;
    }
}