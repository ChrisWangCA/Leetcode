class Trie {
    
    class TrieNode{
        int pass;
        int end;
        TrieNode[] nexts;
        TrieNode(){
            pass = 0;
            end = 0;
            nexts = new TrieNode[26];
        }
    }
    
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        if(word == null) return;
        char[] chs = word.toCharArray();
        int index = 0;
        TrieNode node = root;
        for(int i=0;i<chs.length;i++){
            index = chs[i] - 'a';
            if(node.nexts[index] == null){
                node.nexts[index] = new TrieNode();
            }
            node = node.nexts[index];
            node.pass++;
        }
        node.end++;
    }
    
    public boolean search(String word) {
        if(word == null) return false;
        char[] chs = word.toCharArray();
        int index = 0;
        TrieNode node = root;
        for(int i=0;i<chs.length;i++){
            index = chs[i] - 'a';
            if(node.nexts[index] == null){
                return false;
            }
            node = node.nexts[index];
        }
        return node.end != 0;
    }
    
    public boolean startsWith(String prefix) {
        if(prefix == null) return false;
        char[] chs = prefix.toCharArray();
        int index = 0;
        TrieNode node = root;
        for(int i=0;i<chs.length;i++){
            index = chs[i] - 'a';
            if(node.nexts[index] == null) return false;
            node = node.nexts[index];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */