class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int mid = -1;
        for(int i = 0; i < matrix.length; i++){
            if(target >= matrix[i][0] && target <= matrix[i][matrix[i].length-1]){
                mid = i;
                break;
            }
        }
        if(mid != -1){
            int[] nums = matrix[mid];
            return binarySearch(nums.length-1, 0, nums, target);
        }
        
        return false;
    }

    public boolean binarySearch(int high, int low, int[] nums, int target){
        if(nums[(high+low)/2] == target)
            return true;
        
        if(low > high)
            return false;

        if(nums[(high+low)/2] < target)
            return binarySearch(high, ((high+low)/2)+1, nums, target);
        else if(nums[(high+low)/2] > target)
            return binarySearch(((high+low)/2)-1, low, nums, target);

        return false;
    }
}
