class TrieNode {
    TrieNode[] children;
    boolean endOfWord;
    public TrieNode() {
        children = new TrieNode[26];
        endOfWord = false;
    }
}

class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            int alphabet = c - 'a';
            if(curr.children[alphabet] == null) {
                curr.children[alphabet] = new TrieNode();
            }
            curr = curr.children[alphabet];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            int alphabet = c - 'a';
            if(curr.children[alphabet] == null) {
                return false;
            }
            curr = curr.children[alphabet];
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c: prefix.toCharArray()) {
            int alphabet = c - 'a';
            if(curr.children[alphabet] == null) {
                return false;
            }
            curr = curr.children[alphabet];
        }
        return true;
    }
}
