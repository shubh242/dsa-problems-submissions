class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for(int r = 0; r < board.length; r++){
            for(int c = 0; c < board[0].length; c++){
                if(board[r][c] == '.')
                    continue;

                String squareKey = (r/3) + ", " + (c/3);

                if(rows.containsKey(r)){
                    if(rows.get(r).contains(board[r][c]))
                        return false;
                    rows.get(r).add(board[r][c]);
                }else{
                    rows.put(r, new HashSet<>());
                    rows.get(r).add(board[r][c]);
                }

                if(cols.containsKey(c)){
                    if(cols.get(c).contains(board[r][c]))
                        return false;
                    cols.get(c).add(board[r][c]);
                }else{
                    cols.put(c, new HashSet<>());
                    cols.get(c).add(board[r][c]);
                }

                if(squares.containsKey(squareKey)){
                    if(squares.get(squareKey).contains(board[r][c]))
                        return false;
                    squares.get(squareKey).add(board[r][c]);
                }else{
                    squares.put(squareKey, new HashSet<>());
                    squares.get(squareKey).add(board[r][c]);
                }
                System.out.println(rows.toString() + " " + cols.toString() + " " + squares.toString());
            }
        }
        return true;
    }
}
