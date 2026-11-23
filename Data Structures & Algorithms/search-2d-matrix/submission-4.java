class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length-1;
        int mid = -1;

        while(start <= end) {
            mid = (start + end) / 2;
            if(matrix[mid][0] <= target && target <= matrix[mid][matrix[mid].length-1]) {
                break;
            } else if(target < matrix[mid][0]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        int r = mid;
        start = 0;
        end = matrix[r].length-1;

        while(start <= end) {
            mid = (start + end) / 2;
            if(matrix[r][mid] == target) {
                return true;
            } else if(matrix[r][mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
}
