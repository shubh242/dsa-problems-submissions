class Solution {
    public int removeDuplicates(int[] nums) {
        int prevUniqueElement = nums[0], i = 0, j = 1;
        while(j < nums.length) {
            if(nums[j] == nums[i]) {
                j++;
            } else {
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
}