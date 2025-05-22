class Solution {
    public int removeBoxes(int[] boxes) {
        Map<String,Integer> map = new HashMap<>();
        return solve(boxes,0,boxes.length-1,0,map);
    }
    public static int solve(int[] boxes,int i, int j, int k,Map<String,Integer> memo){
        if(i > j)
            return 0;
        String key = i+""+j+""+k;
        if(memo.containsKey(key))
            return memo.get(key);
        int original = i;
        while(i <= j && boxes[i] == boxes[original]){
            i++;
            k++;
        }
        int result = k * k + solve(boxes,i,j,0,memo);
        for(int m=i;m<=j;m++){
            if(boxes[m] == boxes[original]){
                int firstHalf = solve(boxes,i,m-1,0,memo);
                int secondHalf = solve(boxes,m,j,k,memo);
                result = Math.max(result,firstHalf+secondHalf);
            }
        }
        memo.put(key,result);
        return result;
    }
}