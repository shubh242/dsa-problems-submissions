class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> numSet = new HashSet<>();

        // Row Check
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(!(board[i][j] == '.')){
                    if(numSet.contains(board[i][j])){
                        return false;
                    }else{
                        numSet.add(board[i][j]);
                    }
                }
            }
            numSet.clear();
        }

        // Column Check
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(!(board[j][i] == '.')){
                    if(numSet.contains(board[j][i])){
                        return false;
                    }else{
                        numSet.add(board[j][i]);
                    }
                }
            }
            numSet.clear();
        }

        // Matrix Check
        int n = 3;

        while(n <= 9){
            for(int i = n-3; i < n; i++){
                for(int j = n-3; j < n; j++){
                    if(!(board[i][j] == '.')){
                        if(numSet.contains(board[i][j])){
                            return false;
                        }else{
                            numSet.add(board[i][j]);
                        }
                    }
                    System.out.println("1 - board[" + i + "]" + "[" + j + "]");
                }
            }

            numSet.clear();
            System.out.println();

            for(int i = n-3; i < n; i++){
                for(int j = n; (j < (n+3)) && (j < 9); j++){
                    if(!(board[i][j] == '.')){
                        if(numSet.contains(board[i][j])){
                            return false;
                        }else{
                            numSet.add(board[i][j]);
                        }
                    }
                    System.out.println("2 - board[" + i + "]" + "[" + j + "]");
                }
            }

            numSet.clear();
            System.out.println();

            for(int i = n-3; i < n; i++){

                for(int j = n; (j < (n+3)) && (j < 9); j++){
                    if(!(board[j][i] == '.')){
                        if(numSet.contains(board[j][i])){
                            return false;
                        }else{
                            numSet.add(board[j][i]);
                        }
                    }
                    System.out.println("3 - board[" + j + "]" + "[" + i + "]" + " -- " + numSet.toString());
                }
            }
            numSet.clear();
            System.out.println();
            n+=3;
        }

        for(int i = 6; i < 9; i++){
            for(int j = 0; j < 3; j++){
                if(!(board[j][i] == '.')){
                    if(numSet.contains(board[j][i])){
                        return false;
                    }else{
                        numSet.add(board[j][i]);
                    }
                }
            }
        }
        
        numSet.clear();
        
        for(int i = 6; i < 9; i++){
            for(int j = 0; j < 3; j++){
                if(!(board[i][j] == '.')){
                    if(numSet.contains(board[i][j])){
                        return false;
                    }else{
                        numSet.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }
}
