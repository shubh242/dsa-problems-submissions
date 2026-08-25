class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int longest = 0;

        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i]-1)) {
                int counter = 0;
                while(set.contains(nums[i]+counter)) {
                    counter++;
                }
                longest = Math.max(longest, counter);
            }
        }
        return longest;
    }
}
