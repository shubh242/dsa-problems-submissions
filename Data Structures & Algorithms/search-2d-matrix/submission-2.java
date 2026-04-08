class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            if(target >= matrix[i][0] && target <= matrix[i][matrix[i].length-1]){
                return binarySearch(matrix[i], target);
            }
        }
        return false;
    }

    public boolean binarySearch(int[] nums, int target){
        int left = 0, right = nums.length-1;
        int mid = (left+right)/2;

        while(left <= right){
            if(nums[mid] == target)
                return true;
            else if(nums[mid] < target)
                left = mid+1;
            else
                right = mid-1;
            
            mid = (left+right)/2;
        }
        return false;
    }
}
