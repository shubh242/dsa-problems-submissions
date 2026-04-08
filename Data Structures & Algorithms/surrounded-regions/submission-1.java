class Solution {
    public void solve(char[][] board) {
        Set<String> borderOs = new HashSet<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O' && (i == 0 || j == 0 || i == board.length-1 || j == board[0].length-1)){
                    borderOs.add(Arrays.toString(new int[]{i,j}));
                }
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O' && !borderOs.contains(Arrays.toString(new int[]{i,j}))){
                    Set<String> visited = new HashSet<>();
                    boolean[] flag = new boolean[]{false};
                    dfs(board, i, j, visited, flag);
                    if(flag[0]){
                        for(String a : visited){
                            borderOs.add(a);
                        }
                    }else{
                        for(String a : visited){
                            String[] str = a.substring(1, a.length()-1).split(", ");
                            board[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 'X';
                        }
                    }
                    System.out.println();
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j, Set<String> visited, boolean[] flag){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'X' || visited.contains(Arrays.toString(new int[]{i, j})) || flag[0])
            return;
        
        if(board[i][j] == 'O' && (i == 0 || i == board.length-1 || j == 0 || j == board[0].length-1)){
            System.out.println(board[i][j] + " " + i + " " + j);
            flag[0] = true;
            return;
        }
        visited.add(Arrays.toString(new int[]{i, j}));
        // System.out.println(visited.toString());

        dfs(board, i+1, j, visited, flag);
        dfs(board, i-1, j, visited, flag);
        dfs(board, i, j+1, visited, flag);
        dfs(board, i, j-1, visited, flag);
    }
}
