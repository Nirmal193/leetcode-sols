class Solution {
    public List<String> findRepeatedDnaSequences(String str) {
         int mod = (int) 1e9 + 7;
        long base = 7;
        int len = str.length();
        long hash = 0;
        long pow = 1;
        int k = 10;
        Set<Long> seehHashes = new HashSet<>();
        Set<String> ansSet = new HashSet<>();
        for(int i=0;i<k;i++){
            pow = (pow * (long)base) % mod;
        }
        for(int i=0;i<len;i++){
           hash =((hash * base) % mod + (long)(str.charAt(i) - 'A' + 1)) % mod;
           if(i >= k){
               long remove = ((str.charAt(i - k) - 'A' + 1L) * pow) % mod;
               hash = (hash - remove + mod) % mod;
           }
            if(i>=k-1){
                if(seehHashes.contains(hash)){
                    ansSet.add(str.substring(i - k + 1, i + 1));
                }else
                    seehHashes.add(hash);
            }
        }
        return new ArrayList<>(ansSet);
    }
}