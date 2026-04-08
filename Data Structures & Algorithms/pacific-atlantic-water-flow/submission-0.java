class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for(int i = 0; i < COLS; i++){
            dfs(0, i, heights, pac, heights[0][i]);
            dfs(ROWS-1, i, heights, atl, heights[ROWS-1][i]);
        }

        for(int i = 0; i < ROWS; i++){
            dfs(i, 0, heights, pac, heights[i][0]);
            dfs(i, COLS-1, heights, atl, heights[i][COLS-1]);
        }

        List<List<Integer>> result = new ArrayList<>(); 
        for(int i = 0; i < ROWS; i++){
            for(int j = 0; j < COLS; j++){
                if(pac[i][j] && atl[i][j]){
                    result.add(Arrays.asList(new Integer[]{i, j}));
                }
            }
        }

        return result;
    }
    
    // [1],
    // [1]

    public void dfs(int i, int j, int[][] heights, boolean[][] ocean, int prevHeight){
        if(i < 0 || i >= heights.length || j < 0 || j >= heights[0].length)
            return;

        if(ocean[i][j] == true)
            return;

        if(heights[i][j] >= prevHeight)
            ocean[i][j] = true;
        else
            return;
        
        dfs(i+1, j, heights, ocean, heights[i][j]);
        dfs(i-1, j, heights, ocean, heights[i][j]);
        dfs(i, j+1, heights, ocean, heights[i][j]);
        dfs(i, j-1, heights, ocean, heights[i][j]);
    }
}
