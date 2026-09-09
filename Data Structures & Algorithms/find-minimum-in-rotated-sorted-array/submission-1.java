class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        
        while(low <= high) {
            mid = (low+high)/2;

            if(nums[low] > nums[high]) {
                if(nums[low] <= nums[mid]) {
                    low = mid+1;
                } else {
                    high = mid;
                }
            } else {
                return nums[low];
            }
        }
        return nums[low];
    }
}
