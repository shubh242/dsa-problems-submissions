class TrieNode {
    TrieNode[] children;
    boolean endOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        endOfWord = false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return dfs(word, 0, root);
    }

    public boolean dfs(String word, int index, TrieNode curr) {
        if(curr == null) {
            return false;
        }

        if(index == word.length()) {
            return curr.endOfWord;
        }

        char c = word.charAt(index);

        if(c == '.') {
            for(int i = 0; i < 26; i++) {
                if(curr.children[i] != null && dfs(word, index+1, curr.children[i])) {
                    return true;
                }
            }
            return false;
        } else {
            int alphabet = c - 'a';
            return dfs(word, index+1, curr.children[alphabet]);
        }
    }
}
