class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> r = new HashMap<>();
        Map<Integer, Set<Character>> c = new HashMap<>();
        Map<String, Set<Character>> grid = new HashMap<>();

        for(int i = 0; i < board.length; i++) {
            r.put(i, new HashSet<>());
            c.put(i, new HashSet<>());
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.')
                    continue;

                if(r.get(i).contains(board[i][j])){
                    return false;
                }
                else
                    r.get(i).add(board[i][j]);
                
                if(c.get(j).contains(board[i][j])){
                    return false;
                }
                else
                    c.get(j).add(board[i][j]);

                String key = "" + i/3 + "," + j/3;

                if(!grid.containsKey(key)) {
                    grid.put(key, new HashSet<>());
                }

                if(grid.get(key).contains(board[i][j])){
                    return false;
                }
                else
                    grid.get(key).add(board[i][j]);
            }
        }
        return true;
    }
}
