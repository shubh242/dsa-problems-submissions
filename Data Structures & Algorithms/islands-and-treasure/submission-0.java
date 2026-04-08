class Solution {
    int[][] copy;
    public void islandsAndTreasure(int[][] grid) {
        copy = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                int[] steps = new int[1];
                if(grid[i][j] == 0){
                    dfs(grid, i, j, 0);
                }
            }
        }
    }

    public void dfs(int[][] grid, int i, int j, int distance){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || (distance != 0 && grid[i][j] <= distance)){
            return;
        }

        grid[i][j] = distance;
        dfs(grid, i+1, j, distance+1);
        dfs(grid, i-1, j, distance+1);
        dfs(grid, i, j+1, distance+1);
        dfs(grid, i, j-1, distance+1);
    }
}
