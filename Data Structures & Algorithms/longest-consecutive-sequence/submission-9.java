class Solution {
    public int longestConsecutive(int[] nums) {
        // Create a set and add all values of nums in it.
        // check if nums[i]-1 exists if not then loop till nums[i]+1 exists
        // and increment the counter

        Set<Integer> numSet = new HashSet<>();
        for(int n : nums){
            numSet.add(n);
        }
        int consecutive = 0, longest = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(!numSet.contains(nums[i]-1)){
                consecutive = 0;
                while(numSet.contains(nums[i]+consecutive)){
                    consecutive++;
                }   
                longest = Math.max(longest, consecutive);
            }
        }
        return longest == Integer.MIN_VALUE ? 0 : longest;
    }
}
