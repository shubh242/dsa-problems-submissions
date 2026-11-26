class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int mid = 0;

        while(start <= end) {
            mid = (start + end) / 2;

            if(nums[start] > nums[end]) {
                if(nums[start] <= nums[mid]) {
                    start = mid+1;
                } else {
                    end = mid;
                }
            } else {
                return nums[start];
            }
        }
        return nums[mid];
    }
}
