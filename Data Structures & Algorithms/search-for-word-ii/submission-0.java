class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < board.length; j++){
                for(int k = 0; k < board[0].length; k++){
                    boolean flag = dfs(board, words[i], j, k, 0);
                    if(flag){
                        result.add(words[i]);
                        j = board.length;
                        break;
                    }
                }
            }
        }
        return result;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int count){
        if(count == word.length()){
            return true;
        }
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        
        if(board[i][j] != word.charAt(count))
            return false;

        char letter = board[i][j];
        board[i][j] = '#';

        if(dfs(board, word, i+1, j, count+1) ||
            dfs(board, word, i-1, j, count+1) ||
            dfs(board, word, i, j+1, count+1) ||
            dfs(board, word, i, j-1, count+1)
        ){
            board[i][j] = letter;
            return true;
        }

        board[i][j] = letter;
        return false;
    }
}
