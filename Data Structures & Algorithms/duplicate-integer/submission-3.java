class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> dupSet = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(dupSet.contains(nums[i])) {
                return true;
            }

            dupSet.add(nums[i]);
        }

        return false;
    }
}