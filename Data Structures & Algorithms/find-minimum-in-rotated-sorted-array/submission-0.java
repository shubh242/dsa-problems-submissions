class Solution {
    public int findMin(int[] nums) {
        int minElement = Integer.MAX_VALUE;
        if(nums[0] <= nums[nums.length-1])
            return nums[0];
        else{
            int low = 0;
            int high = nums.length-1;
            int mid = nums.length/2;

            while(low <= high){
                minElement = Math.min(minElement, nums[mid]);

                if(nums[mid] > nums[high]){
                    low = mid+1;
                    mid = (high+low)/2;
                }else{
                    high = mid-1;
                    mid = (high+low)/2;
                }
            }
        }
        return minElement;
    }
}
