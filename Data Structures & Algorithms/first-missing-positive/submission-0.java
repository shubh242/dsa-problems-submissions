class Solution {
    public int firstMissingPositive(int[] nums) {
        int lowerBound = Integer.MAX_VALUE;
        int higherBound = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            lowerBound = Math.min(lowerBound, nums[i]);
            higherBound = Math.max(higherBound, nums[i]);
            set.add(nums[i]);
        }

        if(lowerBound < 0 && higherBound <= 0) {
            return 1;
        }

        for(int i = 1; i < higherBound; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return higherBound+1;
    }
}