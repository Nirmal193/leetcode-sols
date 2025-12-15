class WordDictionary {

   private Node node;
    public WordDictionary() {
        node = new Node();
    }

    public void addWord(String word) {
        Node current = node;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i) - 'a';
            if(current.next[index] == null){
                current.next[index] = new Node();
            }
            current = current.next[index];
        }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
        Node current = node;
        return search_util(word,current,0);
    }
    public boolean search_util(String word,Node current, int k){
        if(k== word.length())
            return current.isEndOfWord;
        char c = word.charAt(k);
        if(c != '.'){
            int index = c - 'a';
            if(current.next[index] == null)
                return false;
            return search_util(word,current.next[index],k+1);
        }else{
            for(int i=0;i<26;i++){
                if(current.next[i] != null){
                    if(search_util(word, current.next[i], k + 1))
                        return true;
                }
            }
        }
        return false;
    }
    private static  class Node{
        public boolean isEndOfWord;
        public Node[] next;
        public Node(){
            isEndOfWord = false;
            next = new Node[26];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */