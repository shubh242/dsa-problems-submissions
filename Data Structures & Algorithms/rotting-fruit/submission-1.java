class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        Set<int[]> visited = new HashSet<>();
        int[][] directions = new int[][]{
            new int[]{1,0},
            new int[]{-1,0},
            new int[]{0,1},
            new int[]{0,-1},
        };
        int time = 0;
        int fresh = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    fresh++;

                if(grid[i][j] == 2)
                    q.add(new int[]{i, j});
            }
        }

        if(fresh == 0)
            return 0;

        while(!q.isEmpty()){
            int size = q.size();
            for(int j = 0; j < size; j++){
                int[] temp = q.poll();
                for(int i = 0; i < 4; i++){
                    int x = temp[0] + directions[i][0];
                    int y = temp[1] + directions[i][1];
                    if(isValid(grid, x, y)){
                        if(grid[x][y] == 1){
                            grid[x][y] = 2;
                            fresh--;
                            q.add(new int[]{x, y});
                        }
                    }
                }
            }
            time++;
            if(fresh == 0)
                break;
        }
        return fresh == 0 ? time : -1;
    }

    public boolean isValid(int[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || grid[i][j] == 2){
            return false;
        }
        return true;
    }
}
