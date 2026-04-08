class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> noDupes = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(noDupes.contains(nums[i]))
                return true;
            noDupes.add(nums[i]);
        }
        return false;
    }
}
