class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        HashMap<String, HashSet<Character>> grids = new HashMap<>();

        for(int i = 0; i < board.length; i++) {
            HashSet<Character> r = new HashSet<>();
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                if(r.contains(board[i][j])) {
                    return false;
                }
                r.add(board[i][j]);
            }
            rows.put(i, r);
        }
        
        for(int i = 0; i < board[0].length; i++) {
            HashSet<Character> c = new HashSet<>();
            for(int j = 0; j < board.length; j++) {
                if(board[j][i] == '.') {
                    continue;
                }
                if(c.contains(board[j][i])) {
                    return false;
                }
                c.add(board[j][i]);
            }
            cols.put(i, c);
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == '.') {
                    continue;
                }
                
                String key = i/3 + ", " + j/3;
                if(!grids.containsKey(key)) {
                    grids.put(key, new HashSet<>());
                }

                HashSet<Character> tmp = grids.get(key);
                if(tmp.contains(board[i][j])) {
                    return false;
                }
                tmp.add(board[i][j]);
                grids.put(key, tmp);
            }
        }
        return true;
    }
}
