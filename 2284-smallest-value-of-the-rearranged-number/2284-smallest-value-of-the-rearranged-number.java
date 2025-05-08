class Solution {
    public long smallestNumber(long num) {
        if(num == 0)
            return 0;
        if(num < 0){
            long ans  = createLargest(0-num);
            return 0 - ans;
        }
        else
            return createSmallest(num);
    }
    public long createLargest(long num){ 
        String str = String.valueOf(num);
        Character array[] = str.chars().mapToObj(x->(char)x).toArray(Character[]::new);
        Arrays.sort(array,Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        Arrays.stream(array).forEach(x->sb.append(x));
        long ans = Long.parseLong(sb.toString());
        return ans;
    }
    public long createSmallest(long num){
        String str  = String.valueOf(num);
        int len = str.length();
        char[] array = str.toCharArray();
        Arrays.sort(array);
        int zero = 0;
        while(array[zero]=='0'){
            zero++;
        }
        if(zero ==  len)
            return 0;
        StringBuilder sb = new StringBuilder();
        sb.append(array[zero]);
        IntStream.range(0,zero).forEach(x->sb.append("0"));
        for(int i = zero+1;i<len;i++){
            sb.append(array[i]);
        }
        long ans = Long.parseLong(sb.toString());
        return ans;
    }
}