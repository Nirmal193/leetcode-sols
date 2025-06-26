class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int magfreq[] = new int[26];
        int ranfreq[] = new int[26];
        for(int i=0;i<magazine.length();i++){
            magfreq[magazine.charAt(i)-'a']++;
        }
        for(int i=0;i<ransomNote.length();i++){
            ranfreq[ransomNote.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(ranfreq[i] > magfreq[i])
                return false;
        }
        return true;
    }
}