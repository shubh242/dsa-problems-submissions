class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = Integer.MIN_VALUE;
        

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    List<int[]> tracks = new ArrayList<>();
                    dfs(grid, tracks, i, j);
                    maxArea = Math.max(maxArea, tracks.size());
                }
            }
        }
        return Math.max(maxArea, 0);
    }

    public void dfs(int[][] grid, List<int[]> tracks, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0)
            return;
        
        // System.out.print("[" + i + ", " + j + "] -> ");

        grid[i][j] = 0;
        tracks.add(new int[]{i,j});
        dfs(grid, tracks, i+1, j);
        dfs(grid, tracks, i-1, j);
        dfs(grid, tracks, i, j+1);
        dfs(grid, tracks, i, j-1);
    }
}
