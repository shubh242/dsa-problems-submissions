class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        // 1st example
        // 1. 6,1,2,3,4,5 -- l = 6, h = 5, m = 2, t = 1
        // 2. 6,1 -- l = 6, h = 1, m = 0, t = 1
        // 2. 1 -- l = 1, h = 1, m = 1, t = 1

        // 2nd example
        // 1. 3,4,5,6,1,2 -- l = 3, h = 2, m = 5, t = 1
        // 2. 3,4,5,6,1,2 -- l = 0, h = 2, m = 1, t = 1

        while(low <= high) {
            int mid = (low+high)/2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[low] <= nums[mid]) {
                if(target > nums[mid] || target < nums[low]) {
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            } else {
                if(target > nums[high] || target < nums[mid]) {
                    high = mid-1;
                } else {
                    low = mid+1;
                }
            }
        }
        return -1;
    }
    // nums = [6,1,2,3,4,5], target = 1
    // nums = [3,4,5,6,0,1,2], target = 4
}
