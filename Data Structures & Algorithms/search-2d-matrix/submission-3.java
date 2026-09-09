class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int low = 0;
        int high = matrix.length-1;

        while(low <= high) {
            int mid = (low+high)/2;

            if(matrix[mid][matrix[0].length-1] >= target && target >= matrix[mid][0]) {
                int row = mid;
                low = 0;
                high = matrix[0].length;
                while(low <= high) {
                    mid = (low+high)/2;
                    if(matrix[row][mid] == target) {
                        return true;
                    } else if(matrix[row][mid] < target) {
                        low = mid+1;
                    } else {
                        high = mid-1;
                    }
                }
                break;
            } else if(matrix[mid][matrix[0].length-1] > target){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return false;
    }
}
