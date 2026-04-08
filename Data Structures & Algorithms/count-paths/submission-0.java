class Solution {
    int uniquePaths = 0;
    int[][] matrix;
    public int uniquePaths(int m, int n) {
        matrix = new int[m][n];
        dfs(matrix, m, n, 0, 0);

        for(int[] arr: matrix) {
            System.out.println(Arrays.toString(arr));
        }

        return matrix[m-1][n-1];
    }

    public void dfs(int[][] matrix, int m, int n, int i, int j) {
        if(i >= m || j >= n) {
            return;
        }

        if(i == m-1 && j == n-1) {
            matrix[i][j]++;
            return;
        }

        matrix[i][j]++;
        dfs(matrix, m, n, i+1, j);
        dfs(matrix, m, n, i, j+1);

        return;
    }
}
