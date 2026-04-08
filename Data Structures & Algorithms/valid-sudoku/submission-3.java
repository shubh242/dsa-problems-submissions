class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> row = new HashMap<>();
        Map<Integer, Set<Character>> col = new HashMap<>();
        Map<String, Set<Character>> square = new HashMap<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.println(board[i][j] == '.');
                if(board[i][j] == '.')
                    continue;
                int r = i/3;
                int c = j/3;
                String key = r + ", " + c;

                if(!row.containsKey(i)){
                    row.put(i, new HashSet<>());
                }
                if(!col.containsKey(j)){
                    col.put(j, new HashSet<>());
                }
                if(!square.containsKey(key)){
                    square.put(key, new HashSet<>());
                }

                if(row.get(i).contains(board[i][j]))
                    return false;
                else
                    row.get(i).add(board[i][j]);
                
                if(col.get(j).contains(board[i][j]))
                    return false;
                else
                    col.get(j).add(board[i][j]);
                
                if(square.get(key).contains(board[i][j]))
                    return false;
                else
                    square.get(key).add(board[i][j]);
            }
        }
        return true;
    }
}
