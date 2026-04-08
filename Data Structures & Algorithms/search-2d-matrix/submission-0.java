class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            int[] nums = matrix[i];
            if(binarySearch(nums.length-1, 0, nums, target))
                return true;
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
