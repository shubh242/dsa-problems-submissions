class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean flag = search(board, word, i, j, 0);
                    if(flag)
                        return true;
                }
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int i, int j, int counter){
        if(counter == word.length())
            return true;
        
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length)
            return false;
        
        if(board[i][j] != word.charAt(counter))
            return false;

        char letter = board[i][j];
        board[i][j] = '#';

        if(search(board, word, i+1, j, counter+1) || 
            search(board, word, i-1, j, counter+1) || 
            search(board, word, i, j+1, counter+1) || 
            search(board, word, i, j-1, counter+1)
        )
            return true;
            
        board[i][j] = letter;

        return false;
    }
}