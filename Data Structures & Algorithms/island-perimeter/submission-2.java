class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    return dfs(i , j, visited, grid);
                }
            }
        }
        return 0;
    }

    public int dfs(int i, int j, boolean[][] visited, int[][] grid) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 1;
        }
        if(visited[i][j]) return 0;

        visited[i][j] = true;

        return dfs(i+1, j, visited, grid) + dfs(i-1, j, visited, grid) + dfs(i, j+1, visited, grid) + dfs(i, j-1, visited, grid);
    }
}